
/**
 * Classe permettant la cr�ation d'un Element d'une SuiteChainee.
 */
public class Element {
	
	int value;
	Element nextElement;
	
	/**
	 * Constructeur d'un �l�ment.
	 *
	 * @param valeur : valeur de l'�l�ment
	 */
	public Element(int valeur){
		value = valeur;
		nextElement = null;
	}
	
	/**
	 * Constructeur d'un �l�ment avec un suivant.
	 *
	 * @param valeur : valeur de l'�l�ment
	 * @param next : �l�ment suivant � associer
	 */
	public Element(int valeur, Element next){
		value = valeur;
		nextElement = next;
	}

	/**
	 * R�cup�re la valeur de l'�l�ment.
	 *
	 * @return value : valeur de l'�l�ment.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Set la valeur de l'�l�ment.
	 *
	 * @param value : valeur de l'�l�ment
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * R�cup�re le prochain �l�ment.
	 *
	 * @return nextElement : l'�l�ment suivant
	 */
	public Element getNextElement() {
		return nextElement;
	}

	/**
	 * Set le prochain �l�ment.
	 *
	 * @param nextElement : le prochain �l�ment
	 */
	public void setNextElement(Element nextElement) {
		this.nextElement = nextElement;
	}
		
	/**
	 * Ajouter un �l�ment � la fin de la SuiteChainee.
	 *
	 * @param newItem : nouvel �l�ment � ajouter
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
