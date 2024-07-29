import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class installmentPurchase {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var cost = reader.nextDouble(); // N
//		var temp = cost;
		var paymentPerMonth = reader.nextInt(); // X
		var period = reader.nextInt(); // M
		var remainingPaymentPerMonth = reader.nextInt(); // K
//		var interestRate = (double) paymentPerMonth / period;
		var interestRate = (((paymentPerMonth * period) - cost) / (cost * period * 0.55));
//		var interestRate = (((paymentPerMonth * period) - cost) / (cost * period)) * (12 / period);
//		var interestRate = 0.041666666667d;
//		var interestRate = (((paymentPerMonth * period) / cost) - 1) * 12/period;
//		var annualInterestRate = (((double) paymentPerMonth * period / cost) - 1) * 12 / period;
//		var interestRate = Math.pow(1 + annualInterestRate / 12, 12.0 / period) - 1;
//		var interestRate = (paymentPerMonth * period) / (cost * period * (remainingPaymentPerMonth + 1));
		BigDecimal bigDecimal1 = new BigDecimal(interestRate);
		interestRate = bigDecimal1.setScale(4, RoundingMode.HALF_UP).doubleValue();
		for (int i = 1; i < remainingPaymentPerMonth; i++) {
			var interestPerMonth = cost * interestRate;
			BigDecimal bigDecimal2 = new BigDecimal(interestPerMonth);
			interestPerMonth = bigDecimal2.setScale(4, RoundingMode.HALF_UP).doubleValue();
			cost = (double) (cost - (paymentPerMonth - interestPerMonth));
		}
		var total = (int) Math.round(cost);
		System.out.println(total);
	}

	public static double findInterestRate(double N, double X, int M, int K) {
		// Set the lower and upper bounds for the interest rate
		double low = 0.0;
		double high = 1.0;

		// Define a tolerance level for the remaining cost
		double tolerance = 0.0001;

		// Perform the binary search
		while (high - low > tolerance) {
			// Calculate the midpoint between the lower and upper bounds
			double mid = (low + high) / 2;

			// Calculate the remaining cost after M-1 months using this interest rate
			double remaining_cost = N * Math.pow(1 + mid, M - 1) - X * (Math.pow(1 + mid, M - 1) - 1) / mid;

			// Compare the remaining cost to the amount we need to pay in the Kth month
			if (remaining_cost > X * (M - K)) {
				// If the remaining cost is too high, adjust the upper bound
				high = mid;
			} else {
				// If the remaining cost is too low, adjust the lower bound
				low = mid;
			}
		}

		// At this point, the binary search has converged to a single interest rate
		// Calculate the remaining cost using this interest rate
		double remaining_cost = N * Math.pow(1 + low, M - 1) - X * (Math.pow(1 + low, M - 1) - 1) / low;

		// Calculate the amount we need to pay in the Kth month
		double payment = remaining_cost / Math.pow(1 + low, M - K);

		return payment;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}