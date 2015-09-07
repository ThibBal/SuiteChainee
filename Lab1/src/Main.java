import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String [] args) throws Exception
	{
		System.out.println("--Welcome to Lab 1--"+"\n");
		
		SuiteChainee.readFile("MaListe.properties", true);
		SuiteChainee suite = new SuiteChainee("MaListe.properties", "addition", 4, 8, 10, true);
		//SuiteChainee.saveToFile("MaListe.properties", suite, "addition", 0, 9);
		SuiteChainee.readLine("MaListe.properties");
		
		System.out.println("--Everything seems perfect. Bye!--");
	}
		
}
