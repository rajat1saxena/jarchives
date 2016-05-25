/**
* Solution to HS08TEST.
*
* This solution uses BigDecimal to do monetary calculations
*/
import java.io.*;
import java.math.BigDecimal;

final class HS08TEST {
	private static final BufferedReader reader;
	private static final BufferedWriter writer;

	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	// Returns calculated result
	private static BigDecimal process(BigDecimal transactionAmount, BigDecimal balance) {
		// Check 1 - Balance < transaction amount
		// Check 2 - transaction amount not multiple of 5
		BigDecimal transact = transactionAmount.add(new BigDecimal(0.5));
		if ((transactionAmount.intValue() % 5) == 0 
				&& transact.compareTo(balance) <= 0) {
			return balance.subtract(transact);	
		} else {
			return balance;
		}		
	}

	public static void main(String args[]) throws IOException{
		String[] values = (reader.readLine()).split(" ");

		BigDecimal transactionAmount = new BigDecimal(values[0]);
		BigDecimal balance = new BigDecimal(values[1]);

		writer.append(process(transactionAmount, balance).toString());
		writer.flush();
	}
}
