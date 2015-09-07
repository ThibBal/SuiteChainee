import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String [] args) throws Exception
	{
		System.out.println("--Welcome to Lab 1--");
		SuiteChainee suite = new SuiteChainee("MaListe.properties", "addition", 4, 8, 9, true);
		//TODO : SuiteChainee.isValide(); ici ?
		SuiteChainee.saveToFile("MaListe.properties", suite, "addition", 0, 9);
		
	
		System.out.println("--Everything seems perfect. Bye!--");
	}
		
}
