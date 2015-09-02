import java.util.ArrayList;
import java.util.List;


public class ListeChainee implements Linkable {
	
	public List<Integer> list = new ArrayList<Integer>();
	
	public ListeChainee(List<Integer> list){
		this.list = list;
	}

	@Override
	public void add(int element) {
		this.list.add(element);
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
