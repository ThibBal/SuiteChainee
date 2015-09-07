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
		
		//Vérifie que les paramètres d'entrée sont valides pour construire la liste selon le règlement
		isValide();
		
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
			case "substraction":
				for (int i = 2; i < taille; i++){
					Element newElement = new Element(Operateurs.substraction(getAt(i-2).getValue(),getAt(i-1).getValue()));
					add(newElement);
				}
				break;				
			case "product":
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
		
		// Affiche la liste dans la console
		display();
		
		//TODO : POSITION : commence à 0 ou 1 ?
		
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
	 * @param suite : SuiteChainee à sauvergarder
	 * @param op : opérateur utilisé
	 * @param index : dernier index depuis lequel la chaîne a été rempli
	 * @param size : taille de la chaîne
	 */
	public static void saveToFile(String path, SuiteChainee suite, String op, int index, int size){
    	File file = new File(path);
    	
        try {
			if (!file.exists()) {
				file.createNewFile();
			}
			 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			Element firstElement = suite.getAt(0);
			bw.write("Paramètre 1 : "+ firstElement.getValue() +" \n");
			bw.write("Paramètre 2 : "+ firstElement.getNextElement().getValue() +" \n");
			bw.write("Paramètre 3 : "+ op +" \n");
			bw.write("Paramètre 4 : "+ index +" \n");
			bw.write("Paramètre 5 : "+ size +" \n");
			bw.write("Paramètre 6 : ");
			Element currentElement = firstElement;
			bw.write(currentElement.getValue()+" ");
			while (currentElement.getNextElement() != null){
				currentElement = currentElement.getNextElement();
				bw.write(currentElement.getValue()+" ");
					
			}
			bw.write("\n");
			bw.close();
			
		} catch (IOException  e) {
            throw new RuntimeException("Error writing file ["+ file + "]");
		}
	}
	
	/* (non-Javadoc)
	 * @see ISuiteChainee#add(Element)
	 */
	@Override
	public void add(Element secondElement) {
		firstElement.add(secondElement);
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
		// TODO Remet la chaîne à vide
		firstElement.setNextElement(null);
	}

	/* (non-Javadoc)
	 * @see ISuiteChainee#isValide()
	 */
	@Override
	public boolean isValide() throws Exception {
		System.out.println("--Start the validation of the list--");
		boolean operatorCheck = false;
	    boolean sizeListCheck = false; 
	    
        //test validité opération
       	if ((op == ("addition") || (op == "substraction") || (op == "product") || (op == "division"))){
            operatorCheck = true;
        }
        else {
            throw new Exception("Invalid Operation");
        }
        
        //test validité dimension
        if(taille > 1 && taille <= 10){
            sizeListCheck = true;
        }
        else{
            throw new Exception("Invalid Dimension");
        }
        
        // réponse finale
        if (operatorCheck && sizeListCheck){
            System.out.println("The construction is valid");
        }
        else{
            throw new Exception("Invalid Operation");
        }
		System.out.println("--End of the validation, it's fine--");
		return false;
	}

	public static void readFile(String path, boolean etatVide){
		String chaine ="";
		int nbLigne = 0;

		try{
			InputStream ins=new FileInputStream(path); 
			InputStreamReader insr=new InputStreamReader(ins);
			BufferedReader br=new BufferedReader(insr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				//System.out.println(ligne);
				chaine+=ligne+"\n";
				nbLigne++;
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		//System.out.println(nbLigne);

		if(nbLigne != 0){
			etatVide = false;
			System.out.println("The file is not empty. It contains informations."+"\n");
		}else{
			System.out.println("The file is empty."+"\n");
		}
	}

	public static void readLine(String path) throws IOException{
		FileInputStream fs= new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for(int i = 0; i < 5; ++i)
		  br.readLine();
		String lineIWant = br.readLine();
		
		System.out.println("--Display of the list--");
		System.out.println(lineIWant);
		System.out.println("--End--"+"\n");
	}

}
