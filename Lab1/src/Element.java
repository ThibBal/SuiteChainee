
/**
 * Classe permettant la création d'un Element d'une SuiteChainee.
 */
public class Element {
	
	int value;
	Element nextElement;
	
	/**
	 * Constructeur d'un élément.
	 *
	 * @param valeur : valeur de l'élément
	 */
	public Element(int valeur){
		value = valeur;
		nextElement = null;
	}
	
	/**
	 * Constructeur d'un élément avec un suivant.
	 *
	 * @param valeur : valeur de l'élément
	 * @param next : élément suivant à associer
	 */
	public Element(int valeur, Element next){
		value = valeur;
		nextElement = next;
	}

	/**
	 * Récupère la valeur de l'élément.
	 *
	 * @return value : valeur de l'élément.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Set la valeur de l'élément.
	 *
	 * @param value : valeur de l'élément
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Récupère le prochain élément.
	 *
	 * @return nextElement : l'élément suivant
	 */
	public Element getNextElement() {
		return nextElement;
	}

	/**
	 * Set le prochain élément.
	 *
	 * @param nextElement : le prochain élément
	 */
	public void setNextElement(Element nextElement) {
		this.nextElement = nextElement;
	}
		
	/**
	 * Ajouter un élément à la fin de la SuiteChainee.
	 *
	 * @param newItem : nouvel élément à ajouter
	 */
	public void add(Element newItem){
		if(nextElement == null)
		{
			nextElement = newItem;
		}
		else
		{
			nextElement.add(newItem);
		}
	}
	
}
