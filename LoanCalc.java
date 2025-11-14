// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan;
		for (int i = 0; i < n; i ++) {
			balance = (balance - payment) * (1 + (rate / 100));
		}
		return balance;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double periodicalPayment = loan / n;
		double balance = loan;
		while (Math.abs(balance) > epsilon){
			balance = endBalance(loan, rate, n, periodicalPayment);
			periodicalPayment += epsilon;
			iterationCounter ++;
		}

		return periodicalPayment - epsilon;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double periodicalPayment = loan / n;			   	// 10,000
		double low = loan / n; 					            // 10,000
		double high = loan;  					     	    // 100,000
		double balance = loan;
		while (Math.abs(balance) > epsilon) {
			balance = endBalance(loan, rate, n, periodicalPayment);
			if (balance > epsilon) {
				low = periodicalPayment;
				periodicalPayment = (low + high) / 2;
			}
			else {
				high = periodicalPayment;
				periodicalPayment = (low + high) / 2;
			}
			iterationCounter ++;
		}
		return periodicalPayment;
    }
}