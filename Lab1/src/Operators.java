
public class Operators {
	
	// Addition, @lab subject
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
	
	//Merci à Liondancer du site http://codereview.stackexchange.com/questions/48709/division-without-operator
    public static int division(int a, int b){
        int result = 0;

        if (b == 0) {
            System.out.println("Cannot divide by 0");
        }
        else if (a == 0) {
            System.out.println(0);
        }
        else if (a == b) {
            System.out.println(1);
        }
        else if (a > 0 && b > 0 && a < b) {
            System.out.println(0);
        }
        else {
            // both negative
            if (a < 0 && b < 0) {
                while (a <= b) {
                    a += -1 * b;
                    result++;
                }
            }
            // either N or D negative
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
            // both positive
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