import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Classe permettant la construction et la gestion d'une SuiteChainee
 */
public class SuiteChainee implements ISuiteChainee {

	String chemin;
	String op;
	int val1;
	int val2;
	int taille;
	boolean étatVide;
	Element firstElement;
	private int index = 0;
	
	/**
	 * Construit une SuiteChainee.
	 *
	 * @param chemin : nom du fichier où enregistrer la suite
	 * @param op : opérateur choisi pour construire la SuiteChainee
	 * @param val1 : première valeur de la SuiteChainee
	 * @param val2 :  deuxième valeur de la SuiteChainee
	 * @param taille : taille de la SuiteChainee
	 * @param étatVide : exige si la liste doit être vide ou non
	 * @throws Exception
	 */
	public SuiteChainee(String chemin, String op, int val1, int val2, int taille, boolean étatVide) throws Exception {
		this.chemin = chemin;
		this.op = op;
		this.val1 = val1;
		this.val2 = val2;
		this.taille = taille;
		this.étatVide = étatVide;
		//this.firstElement = firstElement;
		
		//Vérifie que les paramètres d'entrée sont valides pour construire la liste selon le règlement
		isValide();
		
		//Vérifie si la liste est vide
		if (!étatVide){
			isVide(chemin);
		}
		
		//Initialise la liste avec ses deux premiers éléments
		firstElement = new Element(val1);
		Element secondElement = new Element(val2);
		add(secondElement);
		
		//Construction de la suite
		
		//Check l'opérateurr demandé et applique le cas associé
		switch(op){
			case "addition":
				for (int i = 2; i < taille; i++){
					Element newElement = new Element(Operateurs.addition(getAt(i-2).getValue(),getAt(i-1).getValue()));
					add(newElement);
				}
				break;
			case "soustraction":
				for (int i = 2; i < taille; i++){
					Element newElement = new Element(Operateurs.substraction(getAt(i-2).getValue(),getAt(i-1).getValue()));
					add(newElement);
				}
				break;				
			case "multiplication":
				for (int i = 2; i < taille; i++){
					Element newElement = new Element(Operateurs.product(getAt(i-2).getValue(),getAt(i-1).getValue()));
					add(newElement);
				}
				break;
			case "division":
				for (int i = 2; i < taille; i++){
					Element newElement = new Element(Operateurs.division(getAt(i-2).getValue(),getAt(i-1).getValue()));
					add(newElement);
				}
				break;
			default:
				throw new Exception("Invalid operator");
			}
		
		String contenu = saveToFile(chemin, firstElement, op, index, taille);
		System.out.println("MaListe	: "+contenu);
		
		
		// Affiche la liste dans la console
		//display();
				
		//	Test de la fonction "getSize()"
		//	System.out.println(getSize());
		
		//	Test de la fonction "setAt()"
		//	Element nouvelElement = new Element(314);
		//	setAt(nouvelElement, 3);
		
		//	Test de la fonction "remove()"
		//	removeAt(3);
		
		//	Test de la fonction "reset()"
		//	reset();
		
		//	Test de la fonction "removeItem()"
		//	Element elementRetirer = new Element(220, null);
	    //	Element avantDernier = firstElement.getNextElement();
	  	//	removeItem(avantDernier);
		
	}
	
	/**
	 * Affiche la SuiteChainee construite.
	 */
	public void display() {
		System.out.println("--Display of the list--");
		System.out.print(firstElement.getValue()+" ");
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			currentElement = currentElement.getNextElement();
			System.out.print(currentElement.getValue()+" ");
		}
		System.out.println("\n--End--");
	}
	
	/**
	 * Sauvegarde la Suite dans un fichier.
	 *
	 * @param path : chemin vers le nom du fichier
	 * @param firstElement : premier élément de la suite
	 * @param op : opérateur utilisé
	 * @param index : dernier index depuis lequel la chaîne a été rempli
	 * @param size : taille de la chaîne
	 * @return contenu : String contenant le contenu de la chaîne
	 */
	public static String saveToFile(String path, Element firstElement,  String op, int index, int size){
    	File file = new File(path);
    	String contenu = "";
        try {
			if (!file.exists()) {
				file.createNewFile();
			}
			 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Paramètre 1 : "+ firstElement.getValue() +" \n");
			bw.write("Paramètre 2 : "+ firstElement.getNextElement().getValue() +" \n");
			bw.write("Paramètre 3 : "+ op +" \n");
			bw.write("Paramètre 4 : "+ index +" \n");
			bw.write("Paramètre 5 : "+ size +" \n");
			bw.write("Paramètre 6 : ");
			
			Element currentElement = firstElement;
			contenu+=currentElement.getValue()+" ";
			while (currentElement.getNextElement() != null){
				currentElement = currentElement.getNextElement();
				contenu+=currentElement.getValue()+" ";									
			}
			bw.write(contenu);
			bw.write("\n");
			bw.close();
			
		} catch (IOException  e) {
            throw new RuntimeException("Error writing file ["+ file + "]");
		}
        
        return contenu;
	}
	
	/* (non-Javadoc)
	 * @see ISuiteChainee#add(Element)
	 */
	@Override
	public void add(Element newElement) {
		firstElement.add(newElement);
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#removeAt(int)
	 */
	@Override
	public void removeAt(int position) {
		// Supprime et reconstruit la liste
		int cursor = 0;
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			if(cursor == position - 1){
				Element newNextElement = currentElement.getNextElement().getNextElement();
				currentElement.setNextElement(newNextElement);
				return;
			}
			currentElement = currentElement.getNextElement();
			cursor++;
		}		
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#removeItem(Element)
	 */
	@Override
	public void removeItem(Element element) {

		int cursor = 0;
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			if(currentElement == element){
				Element newNextElement = currentElement.getNextElement();
				setAt(newNextElement, cursor);
				return;
			}
			currentElement = currentElement.getNextElement();
			cursor++;
		}	
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#setAt(Element, int)
	 */
	@Override
	public void setAt(Element element, int position) {
		int cursor = 0;
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			if(cursor == position -1){	
				currentElement.setNextElement(element);
				return;
			}
			currentElement = currentElement.getNextElement();
			cursor++;
		}		
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#getAt(int)
	 */
	@Override
	public Element getAt(int position) {
		int cursor = 0;
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			if(cursor == position){	
				return currentElement;
			}
			currentElement = currentElement.getNextElement();
			cursor++;
		}
		return currentElement;
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#getSize()
	 */
	@Override
	public int getSize() {
		int size = 1;
		Element currentElement = firstElement;
		while (currentElement.getNextElement() != null){
			currentElement = currentElement.getNextElement();
			size++;
		}
		return size;
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#reset()
	 */
	@Override
	public void reset() {
		firstElement.setNextElement(null);
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#isValide()
	 */
	@Override
	public boolean isValide() throws Exception {
		boolean operatorCheck = false;
	    boolean sizeListCheck = false; 
	    
        //Test de la validité de l'opération
       	if ((op == ("addition") || (op == "soustraction") || (op == "multiplication") || (op == "division"))){
            operatorCheck = true;
        }
        else {
            throw new Exception("Invalid Operation");
        }
        
        //Test de la validité de la taille
        if(taille > 1 && taille <= 10){
            sizeListCheck = true;
        }
        else{
            throw new Exception("Invalid Dimension");
        }
        
        // Réponse finale
        if (operatorCheck && sizeListCheck){
            return true;
        }
        else{
            throw new Exception("Invalid Operation");
        }
	}

	/**
	 * Vérifie si la liste est vide.
	 */
	public static void isVide(String path){
		int nbLigne = 0;

		try{
			InputStream ins=new FileInputStream(path); 
			InputStreamReader insr=new InputStreamReader(ins);
			BufferedReader br=new BufferedReader(insr);
			
			while ((br.readLine())!=null){
				nbLigne++;
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

		if(nbLigne != 0){
			System.out.println("The file is not empty. It contains informations."+"\n");
		}else{
			System.out.println("The file is empty."+"\n");
		}
	}

}
