
public interface ListInterface {
	
	//Ajout d�un �l�ment a la chaine.
	void add(Element element);
	
	//Supprime l��l�ment de position �position� de la chaine
	void removeAt(int position); 
	
	//Supprime l��l�ment �element� de la chaine
	void removeItem(Element element);
	
	//changer le contenu de l��l�ment a la position �position� par �element�.
	void setAt(Element element,	int position);
		
	//retourne l��l�ment a la position �position�.
	Element getAt(int position);
	
	//retourne la longueur de la chaine.
	int getSize();
	
	 //remet la chaine a vide.
	void reset();
		
	//qui retourne vrai si la chaine a �t� construite suivant les r�gles.
	boolean isValide() throws Exception; 
}
