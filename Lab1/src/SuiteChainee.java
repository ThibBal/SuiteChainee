import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SuiteChainee implements ListInterface {

	//	Vous pourriez définir SuiteChainee comme une classe, puis appeler une méthode
	//	build de son instance (ex. suitChainee) pour construire la liste, comme :
	//		suiteChainee.build("chemin_liste", "opérateur", val1, val2, tailleDeLaList, etatVide)

	String chemin;
	String opérateur;
	int val1;
	int val2;
	int taille;
	boolean étatVide;
	Element firstElement;

	public SuiteChainee(String chemin, String opérateur, int val1, int val2, int taille, boolean étatVide) throws Exception {
		this.chemin = chemin;
		this.opérateur = opérateur;
		this.val1 = val1;
		this.val2 = val2;
		this.taille = taille;
		this.étatVide = étatVide;

		//Check if the list is valid
		isValide();

		//Initiate the list
		firstElement = new Element(val1);
		Element secondElement = new Element(val2);
		add(secondElement);

		//Construction of the rest of the list

		//Check the operator and use the corresponding case
		switch(opérateur){
		case "addition":
			for (int i = 2; i < taille; i++){
				Element newElement = new Element(Operators.addition(getAt(i-2).getValue(),getAt(i-1).getValue()));
				add(newElement);
			}
			break;
		case "substraction":
			for (int i = 2; i < taille; i++){
				Element newElement = new Element(Operators.substraction(getAt(i-2).getValue(),getAt(i-1).getValue()));
				add(newElement);
			}
			break;				
		case "product":
			for (int i = 2; i < taille; i++){
				Element newElement = new Element(Operators.product(getAt(i-2).getValue(),getAt(i-1).getValue()));
				add(newElement);
			}
			break;
		case "division":
			for (int i = 2; i < taille; i++){
				Element newElement = new Element(Operators.division(getAt(i-2).getValue(),getAt(i-1).getValue()));
				add(newElement);
			}
			break;
		default:
			throw new Exception("Invalid operator");
		}
		//TODO : POSITION : commence à 0 ou 1 ?
		//		System.out.println(getSize());
		//		Element nouvelElement = new Element(314);
		//		setAt(nouvelElement, 3);
		//		removeAt(3);
		//		reset();
		//Element elementRetirer = new Element(220, null);
		//Element avantDernier = firstElement.getNextElement();
		//removeItem(avantDernier);
		//display();
	}

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

	@Override
	public void add(Element secondElement) {
		firstElement.add(secondElement);
	}

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

	@Override
	public void reset() {
		// TODO Remet la chaîne à vide
		firstElement.setNextElement(null);
	}

	@Override
	public boolean isValide() throws Exception {
		System.out.println("--Start the validation of the list--");
		boolean operatorCheck = false;
		boolean sizeListCheck = false; 

		//test validité opération
		if ((opérateur == ("addition") || (opérateur == "substraction") || (opérateur == "product") || (opérateur == "division"))){
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
			System.out.println("The construction is valid.");
		}
		else{
			throw new Exception("Invalid Constrution");
		}
		System.out.println("--End of the validation--"+"\n");
		return false;
	}
}
