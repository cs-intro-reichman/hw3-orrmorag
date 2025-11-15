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
        while (b > 0) {
            a++;
            b--;
        }
        while (b < 0) {
            a--;
            b++;
        }
        return a;
    }

    public static int minus(int a, int b) {
        while (b > 0) {
            a--;
            b--;
        }
        while (b < 0) {
            a++;
            b++;
        }
        return a;
    }

    private static int negate(int x) {
        int r = 0;
        while (x > 0) {
            x--;
            r--;
        }
        while (x < 0) {
            x++;
            r++;
        }
        return r;
    }

    private static int abs(int x) {
        if (x >= 0) return x;
        return negate(x);
    }

    public static int times(int a, int b) {
        int r = 0;
        boolean neg = false;

        if (a < 0) {
            a = abs(a);
            neg = !neg;
        }
        if (b < 0) {
            b = abs(b);
            neg = !neg;
        }

        for (int i = 0; i < b; i++) {
            r = plus(r, a);
        }

        if (neg) r = negate(r);
        return r;
    }

    public static int pow(int a, int b) {
        int r = 1;
        for (int i = 0; i < b; i++) {
            r = times(r, a);
        }
        return r;
    }

    public static int div(int a, int b) {
        if (b == 0) return 0;

        boolean neg = false;
        if (a < 0) {
            a = abs(a);
            neg = !neg;
        }
        if (b < 0) {
            b = abs(b);
            neg = !neg;
        }

        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum = plus(sum, b);
            count++;
        }

        if (neg) count = negate(count);
        return count;
    }

    public static int mod(int a, int b) {
        if (b == 0) return 0;
        int q = div(a, b);
        int p = times(q, b);
        return minus(a, p);
    }

    public static int sqrt(int x) {
        if (x <= 0) return 0;
        int c = 1;
        while (times(c, c) <= x) {
            c++;
        }
        c--;
        return c;
    }
}