
// TODO: Auto-generated Javadoc
/**
 * The Interface ISuiteChainee.
 */
public interface ISuiteChainee {
	
	/**
	 * Ajoute un élément à la fin de la liste.
	 *
	 * @param element : élément à ajouter
	 */
	void add(Element element);
	
	/**
	 * Supprimer l'élément à une position donnée.
	 *
	 * @param position : position de l'élément à supprimer dans la chaîne
	 */
	void removeAt(int position); 
	
	/**
	 * Supprimer l'élément.
	 *
	 * @param element : élément à supprimer
	 */
	void removeItem(Element element);
	
	/**
	 * Remplace l'élément à une position donnée.
	 *
	 * @param element : élément à ajouter the element
	 * @param position : position de l'élément à modifier
	 */
	void setAt(Element element,	int position);
		
	/**
	 * Récupère l'élément à la position donnée.
	 *
	 * @param position : position donnée
	 * @return 
	 */
	Element getAt(int position);
	
	/**
	 * Retourne la longueur de la suite.
	 *
	 * @return size : taille de la suite
	 */
	int getSize();
	
	 /**
 	 * Remet la chaîne à vide.
 	 */
	void reset();
		
	/**
	 * Vérifie que la chaîne est valide.
	 *
	 * @return true : si la chaîne est valide
	 * @throws Exception : argument invalides pour une chaîne correctement construite 
	 */
	boolean isValide() throws Exception; 
}
