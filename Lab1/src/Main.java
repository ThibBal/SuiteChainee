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
		
		// Affiche la liste dans la console
		//display();
				
		//	Test de la fonction "getSize()"
		//	System.out.println(getSize());
		
		//	Test de la fonction "setAt()"
		//	Element nouvelElement = new Element(314);
		//	setAt(nouvelElement, 3);
		
		//	Test de la fonction "remove()"
		//	removeAt(3);
		
		//	Test de la fonction "reset()"
		//	reset();
		
		//	Test de la fonction "removeItem()"
		//	Element elementRetirer = new Element(220, null);
	    //	Element avantDernier = firstElement.getNextElement();
	  	//	removeItem(avantDernier);
		
		System.out.println("--Everything seems perfect. Bye!--");
	}
		
}
