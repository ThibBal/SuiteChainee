
public interface Linkable {
	//Ajout d’un élément a la chaine.
	void add(int element);
	
	//Supprime l’élément de position “position” de la chaine
	void removeAt(int position); 
	
	//Supprime l’élément “element” de la chaine
	void removeItem(int element);
	
	//changer le contenu de l’élément a la position “position” par “element”.
	void setAt(int element,	int position);
		
	//retourne l’élément a la position “position”.
	int getAt(int position);
	
	//retourne la longueur de la chaine.
	int getSize();
	
	 //remet la chaine a vide.
	void reset();
		
	//qui retourne vrai si la chaine a été construite suivant les règles.
	boolean isValide(); 
}
