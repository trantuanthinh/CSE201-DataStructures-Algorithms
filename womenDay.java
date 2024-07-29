import java.io.*;
import java.util.*;

//50
public class womenDay {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfItem = reader.nextInt();
		var amountOfMoney = reader.nextLong();
		long[] listOfItem = createArray(quantityOfItem);
		Arrays.sort(listOfItem);
		long maxPrice = -1;
		long minDistance = Integer.MAX_VALUE;
		int i = 0;
		int j = listOfItem.length - 1;
		while (i < j) {
			long price = listOfItem[i] + listOfItem[j];
			long distance = Math.abs(listOfItem[i] - listOfItem[j]);
			if (price <= amountOfMoney) {
				i++;
				if (price > maxPrice) {
					maxPrice = price;
					minDistance = distance;
				} else if (price == maxPrice && distance < minDistance) {
					minDistance = distance;
				}
			} else {
				j--;
				i = 0;
			}
		}
		if (minDistance == Integer.MAX_VALUE) {
			minDistance = -1;
		}
		System.out.println(maxPrice + " " + minDistance);
	}

	static long[] createArray(int quantity) {
		long[] numbers = new long[quantity];
		for (int i = 0; i < quantity; i++) {
			numbers[i] = reader.nextInt();
		}
		return numbers;
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
