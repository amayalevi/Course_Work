//RecursionStaticMethods_Amaya.java

/*
 * This is the recursion methods Data Class
 */
public class RecursionStaticMethods_Amaya {

	/*
	 * This is the factorial recursion method
	 */
	public static int factorial(int n) {
		if (n == 1 || n == 0)// base case
			return 1;
		else
			return n * factorial(n - 1);// recursive algorithm
	}

	/*
	 * This is the a power n recursive method
	 */
	public static int aPowern(int a, int n) {
		// base case
		if (n == 0)
			return 1;
		if (n == 1)
			return a;
		// recursive algorithm
		return a * aPowern(a, n - 1);
	}

	/*
	 * This is the recursive Sum method
	 */
	public static int sum(int n) {
		// base case
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		// recursive algorithm
		return n + sum(n - 1);
	}

	/*
	 * This is the Sum(m,n) method
	 */
	public static int sum(int m, int n) {
		// base case
		if (m >= n)// m should not be larger than n, if true return m
			return m;
		// recursive algorithm
		return m + sum(m + 1, n);

	}

	/*
	 * This is the fibonacci method
	 */
	public static int fibonacci(int n) {
		// base case
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
		// recursive algorithm
	}

	/*
	 * This is the gcd method. AKA Greatest Common Denominator
	 */
	public static int gcd(int m, int n) {
		// base case
		if (n == 0)
			return m;
		if (n == 1)
			return 1;
		return gcd(n,m%n);

	}
}// end of RecursionStaticMethods_Amaya class
