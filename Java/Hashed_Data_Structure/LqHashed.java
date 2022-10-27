//LQHashed.java

/*
 * This is the LQHashed Data Structure class
 */
public class LqHashed {
	// PG 2800000000000
	int N;
	int n = 0;// the number of nodes in the structure
	int defaultQuotient = 9967;
	double loadingFactor = 0.75;
	BankCustomer_Amaya deleted;// the dummy node, v2 (v1=null)
	private BankCustomer_Amaya[] data;// the primary storage array

	/*
	 * (Argument) Constructor
	 */
	public LqHashed(int length) {
		int pct = (int) ((1.0 / loadingFactor - 1) * 100.0);
		N = fourKPlus3(length, pct);
		data = new BankCustomer_Amaya[N];
		deleted = new BankCustomer_Amaya();
		for (int i = 0; i < N; i++)
			data[i] = null;
	}// end of constructor

	/*
	 * insert Method
	 */
	public boolean insert(BankCustomer_Amaya newNode) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt(newNode.getKey());// preprocess the key
		if ((((double) n) / N) < loadingFactor)// insert the node
		{
			pass = 0;
			q = pk / N;
			offset = q;
			ip = pk % N;
			if (q % N == 0)
				offset = defaultQuotient;
			while (pass < N) {
				if (data[ip] == null || data[ip] == deleted) {
					hit = true;
					break;
				}
				ip = (ip + offset) % N;
				pass = pass + 1;
			} // end while
			if (hit == true) // insert the node
			{
				data[ip] = newNode.deepCopy();
				n++;
				return noError = true;
			} else
				return noError = false;
		} else // structure full to loading factor, insert not performed
			return noError = false;
	}// end of the insert method

	/*
	 * fetch method
	 */
	public BankCustomer_Amaya fetch(String targetKey) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt(targetKey);// preprocess the key
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if (q % N == 0)
			offset = defaultQuotient;
		while (pass < N) {
			if (data[ip] == null)// node not in structure
				break;
			if (data[ip].compareTo(targetKey) == 0)// node found
			{
				hit = true;
				break;
			}
			ip = (ip + offset) % N;// collision occurred
			pass = pass + 1;
		} // end while loop
		if (hit == true) // return a deep copy of the node
			return data[ip].deepCopy();
		else
			return null;
	}// end of the fetch method

	/*
	 * delete method
	 */
	public boolean delete(String targetKey) {
		boolean noError;
		boolean hit = false;
		int pass, q, offset, ip;
		int pk = stringToInt(targetKey); // preprocess the key
		pass = 0;
		q = pk / N;
		offset = q;
		ip = pk % N;
		if (q % N == 0)
			offset = defaultQuotient;
		while (pass < N) {
			if (data[ip] == null) // node not in structure
				break;
			if (data[ip].compareTo(targetKey) == 0)// node found
			{
				hit = true;
				break;
			}
			ip = (ip + offset) % N; // collision occurred
			pass = pass + 1;
		}
		if (hit == true) // delete the node
		{
			data[ip] = deleted;
			n--;
			return noError = true;
		} else
			return noError = false;
	}// end of the delete method

	/*
	 * update method
	 */
	public boolean update(String targetKey, BankCustomer_Amaya newNode) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newNode) == false)
			return false;
		return true;
	}// end of the update method

	/*
	 * showAll method
	 */
	public void showAll() {
		for (int i = 0; i < N; i++)
			if (data[i] != null && data[i] != deleted)
				System.out.println(data[i].toString());
	}// end of the showAll method

	/*
	 * getData method - return copy of node array
	 */
	public BankCustomer_Amaya[] getData() {
		BankCustomer_Amaya[] copy = new BankCustomer_Amaya[N];
		int index=0;
		for (int i = 0; i < N; i++)
			if (data[i] != null && data[i] != deleted)
			{
				copy[index] = data[i].deepCopy();
				index++;
			}
		return copy;
	}

	/*
	 * fourPlus3 method
	 */
	public static int fourKPlus3(int n, int pct) {
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		double pctd = pct;
		prime = (int) (n * (1.0 + (pctd / 100.0))); // guess the prime pct
													// percent larger than n
		if (prime % 2 == 0)// if even make the prime odd
			prime = prime + 1;
		while (fkp3 == false)// not a 4k + 3 prime
		{
			while (aPrime == false)// not a prime
			{
				highDivisor = (int) (Math.sqrt(prime) + 0.5);
				for (d = highDivisor; d > 1; d--) {
					if (prime % d == 0)
						break;
				}
				if (d != 1)// prime not found
					prime = prime + 2;
				else
					aPrime = true;
			} // end of the prime search loop
			if ((prime - 3) % 4 == 0)
				fkp3 = true;
			else {
				prime = prime + 2;
				aPrime = false;
			}
		} // end of 4k + 3 prime search loop
		return prime;
	}// end of fourKPlus3 method

	/*
	 * stringToInt method
	 */
	public static int stringToInt(String aKey) {
		int pseudoKey = 0;
		int n = 1;
		int cn = 0;
		char c[] = aKey.toCharArray();
		int grouping = 0;
		while (cn < aKey.length())// still more characters in the key
		{
			grouping = grouping << 8;// pack next 4 characters
			grouping = grouping + c[cn];
			cn = cn + 1;
			if (n == 4 || cn == aKey.length()) // 4 characters are processed
												// or no more characters
			{
				pseudoKey = pseudoKey + grouping; // add grouping to
													// pseudo key
				n = 0;
				grouping = 0;
			}
			n = n + 1;
		} // end while
		return Math.abs(pseudoKey);
	}// end of stringToInt method
}// end of LqHashed class
