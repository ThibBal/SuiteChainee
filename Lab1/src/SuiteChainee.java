
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
		//isValide();
		
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
		
		display();
	}
	
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
	
	@Override
	public void add(Element secondElement) {
		firstElement.add(secondElement);
		
	}

	@Override
	public void removeAt(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAt(Element element, int position) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValide() {
		System.out.println("--Start the validation of the list--");
		System.out.println("--End of the validation, it's fine--");
		return false;
	}
}
