public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

    public static int plus(int a, int b) {
        for (int i = 0; i < b; i++) a++;
        return a;
    }

    public static int minus(int a, int b) {
        for (int i = 0; i < b; i++) a--;
        return a;
    }

    public static int times(int a, int b) {
        int r = 0;
        for (int i = 0; i < b; i++) r = plus(r, a);
        return r;
    }

    public static int pow(int a, int b) {
        int r = 1;
        for (int i = 0; i < b; i++) r = times(r, a);
        return r;
    }

    public static int div(int a, int b) {
        int c = 0;
        int s = b;
        while (s <= a) {
            s = plus(s, b);
            c++;
        }
        return c;
    }

    public static int mod(int a, int b) {
        int d = div(a, b);
        int m = times(d, b);
        return minus(a, m);
    }

    public static int sqrt(int x) {
        int c = 1;
        while (times(c, c) <= x) c++;
        return c - 1;
    }
}