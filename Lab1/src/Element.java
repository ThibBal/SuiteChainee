
public class Element {
	
	int value;
	Element nextElement;
	
	public Element(int valeur){
		value = valeur;
		nextElement = null;
	}
	
	public Element(int valeur, Element next){
		value = valeur;
		nextElement = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Element getNextElement() {
		return nextElement;
	}

	public void setNextElement(Element nextElement) {
		this.nextElement = nextElement;
	}
		
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
