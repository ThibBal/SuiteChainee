import java.util.ArrayList;
import java.util.List;


public class ListeChainee implements Linkable {
	
	public List<Integer> list = new ArrayList<Integer>();
	public Element start;
	
	public ListeChainee(Element firstElement){
		start = firstElement;
	}
	
//	public ListeChainee(List<Integer> list){
//		this.list = list;
//	}

	@Override
	public void add(int value) {
		Element nextElement = new Element(value);
		//start.setNext(nextElement);
	}

	@Override
	public void removeAt(int position) {
		this.list.remove(position);		
	}

	@Override
	public void removeItem(int element) {
		this.list.remove(element);
	}

	@Override
	public void setAt(int element, int position) {
		this.list.add(position, element);	
	}

	@Override
	public int getAt(int position) {
		return this.list.get(position);
	}

	@Override
	public int getSize() {
		return this.list.size();
	}

	@Override
	public void reset() {
		this.list.clear();		
	}

	@Override
	public boolean isValide() {
		return true;
	}

}
