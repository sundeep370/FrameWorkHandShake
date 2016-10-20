/**
 * @author <>
 * 
 */
public class Primes {

	/**
	 * Checking for prime number
	 * 
	 * @param num
	 * @return
	 */
	boolean isPrime(Object num) {
		// check if n is a multiple of 2
		if (parseWithFallback(num)) {
			int n = (int) num;
			if (n % 2 == 0)
				return false;
			// if not, then just check the odds
			for (int i = 3; i * i <= n; i += 2) {
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}

	/**
	 * checking for valid number
	 * 
	 * @param text
	 * @return
	 */
	public boolean parseWithFallback(Object text) {
		try {
			Integer.parseInt(text.toString());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
