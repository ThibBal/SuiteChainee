
/**
 * Classe regroupant les méthodes d'opération
 */
public class Operateurs {
	
	/**
	 * Méthode pour l'addition. Donnée dans le sujet du Lab 1.
	 *
	 * @param a : premier argument de l'addition
	 * @param b : second argument de l'addition
	 * @return res : le résultat de l'addition
	 */
	public static int addition(int a, int b){
		int res = a;
		if(b>0){
			while(b-- != 0){
				res++;
			}
		}
		else if (b<0){
			while(b++ != 0){
				res--;
			}
		}
		return res;
	}
	
	
	/**
	 * Méthode pour la soustraction. Adaptée de l'addition.
	 *
	 * @param a : premier argument de la soustraction
	 * @param b : second argument de la soustraction
	 * @return res : résultat de la soustraction
	 */
	public static int substraction(int a, int b){
		int res = a;
		if(b>0){
			while(b-- != 0){
				res--;
			}
		}
		else if (b<0){
			while(b++ != 0){
				res++;
			}
		}
		return res;
	}
	
	/**
	 * Méthode pour la multiplication.
	 *
	 * @param a: premier paramètre
	 * @param b: second paramètre
	 * @return res: résultat de la multiplication
	 */
	public static int product(int a, int b){
		int res = 0;
		if(b>0){
			while(b-- != 0){
				res = addition(res,a);
			}
		}
		else if (b<0){
			while(b++ != 0){
				res = addition(res, -a);
			}
		}
		return res;
	}
	
	/**
	 * Méthode pour la division. 
	 * Merci à Liondancer du site StackExchange
	 * http://codereview.stackexchange.com/questions/48709/division-without-operator
	 *
	 * @param a: numérateur
	 * @param b: dénominateur
	 * @return result: résultat de la division
	 */
    public static int division(int a, int b){
        int result = 0;

        // Si b = 0 : IllegalArgumentException
        if (b == 0) {
        	throw new IllegalArgumentException("You cannot divide by 0! Try again.");
        }
        // Si a = 0, la division est égale à 0.
        else if (a == 0) {
            return result;
        }
        // Si a = b, la division est égale à 1
        else if (a == b) {
            result = 1;
            return result;
        }
        else if (a > 0 && b > 0 && a < b) {
        	// division = 0
            return result;
        }
        else {
            // a et b négatifs
            if (a < 0 && b < 0) {
                while (a <= b) {
                    a += -1 * b;
                    result++;
                }
            }
            // a ou b négatif
            else if (a < 0 || b < 0) {
                if (a < 0) {
                    a = -1 * a;
                }
                else {
                    b = -1 * b;
                }
                while (a >= b) {
                    a -= b;
                    result--;
                }
            }
            // a et b positifs
            else {
                while (a >= b) {
                    a -= b;
                    result++;
                }
            }
        }
        return result;
    }
}