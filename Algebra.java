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

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int max = Math.max(x1, x2);
		int min = Math.min(x1, x2);
		if (x1 < 0 && x2 < 0) {
			return minus(x1, x2);
		}
		for (int i = 0; i < max; i ++) {
			min ++;
		}
		return min;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < x2; i ++) {
			x1 --;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times_results = 0;
		for (int i = 0; i < x2; i ++) {
			times_results = plus(times_results, x1);
		}
		return times_results;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power_results = 1;
		for (int i = 0; i < n; i ++) {
			power_results = times(power_results, x);
		}
		return power_results;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int div_results = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			div_results ++;
		}
		return div_results;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int n = 1;
		while (times(n, x2) <= x1) {
			n ++;
		}
		n = minus(n, 1);
		int r = minus(x1, times(x2, n));
		return r;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int a = 1;
		while (times(a, a) < x) {
			a ++;
		}
		return a;
	}	  	  
}