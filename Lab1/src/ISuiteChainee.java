
// TODO: Auto-generated Javadoc
/**
 * The Interface ISuiteChainee.
 */
public interface ISuiteChainee {
	
	/**
	 * Ajoute un �l�ment � la fin de la liste.
	 *
	 * @param element : �l�ment � ajouter
	 */
	void add(Element element);
	
	/**
	 * Supprimer l'�l�ment � une position donn�e.
	 *
	 * @param position : position de l'�l�ment � supprimer dans la cha�ne
	 */
	void removeAt(int position); 
	
	/**
	 * Supprimer l'�l�ment.
	 *
	 * @param element : �l�ment � supprimer
	 */
	void removeItem(Element element);
	
	/**
	 * Remplace l'�l�ment � une position donn�e.
	 *
	 * @param element : �l�ment � ajouter the element
	 * @param position : position de l'�l�ment � modifier
	 */
	void setAt(Element element,	int position);
		
	/**
	 * R�cup�re l'�l�ment � la position donn�e.
	 *
	 * @param position : position donn�e
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
 	 * Remet la cha�ne � vide.
 	 */
	void reset();
		
	/**
	 * V�rifie que la cha�ne est valide.
	 *
	 * @return true : si la cha�ne est valide
	 * @throws Exception : argument invalides pour une cha�ne correctement construite 
	 */
	boolean isValide() throws Exception; 
}
