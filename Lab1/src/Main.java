import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String [] args)
	{
		SuiteChainee("MaListe.properties", "product", 4, 8, 6, true);
	}
	
	public static void SuiteChainee(String path, String op, int va1, int va2, int size, boolean empty){
		List<Integer> listNumbers = new ArrayList<Integer>();
		ListeChainee list = new ListeChainee(listNumbers);
		
		list.add(va1);
		list.add(va2);
		
		for (int i = 2; i < size; i++){
			if (op.equals("addition")){
				list.setAt(Operators.addition(list.getAt(i-2), list.getAt(i-1)), i);
			}
			else if (op.equals("substraction")){
				list.setAt(Operators.substraction(list.getAt(i-2), list.getAt(i-1)), i);
			}
			else if (op.equals("product")){
				list.setAt(Operators.product(list.getAt(i-2), list.getAt(i-1)), i);
			}
			else if (op.equals("division")){
				list.setAt(Operators.division(list.getAt(i-2), list.getAt(i-1)), i);
			}
			else {
				System.out.println("Operator invalid");
			} 
		}
		
		displayList(listNumbers);

		//int[] myList = computeList(op, va1, va2, size);
		//isValid
		//check le empty à true / false
		//	size <= 10 >0
		// si valide : 
		
		writeToFile(path, listNumbers, op, 0, size);

	}
	
	public static void writeToFile(String path, List<Integer> myList, String op, int index, int size){
    	File file = new File(path);
    	
        try {
			if (!file.exists()) {
				file.createNewFile();
			}
			 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Paramètre 1 : "+ myList.get(0) +" \n");
			bw.write("Paramètre 2 : "+ myList.get(1) +" \n");
			bw.write("Paramètre 3 : "+ op +" \n");
			bw.write("Paramètre 4 : "+ index +" \n");
			bw.write("Paramètre 5 : "+ size +" \n");
			bw.write("Paramètre 6 : ");
			for (int i : myList) {
				bw.write(Integer.toString(i)+" ");
			}
			bw.write("\n");
			bw.close();
			
		} catch (IOException  e) {
            throw new RuntimeException("Error reading file ["+ file + "]");
		}
	}
	
	public static void displayList(List<Integer> list){
		System.out.print("MaListe : ");
		for (int i : list) {
			    System.out.print(i+" ");
		}
	}
	
}
