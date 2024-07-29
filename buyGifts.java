import java.io.*;
import java.util.*;

//100 done
public class buyGifts {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfTestCase = reader.nextInt();
		for (int i = 0; i < quantityOfTestCase; i++) {
			var quantityOfItem = reader.nextInt();
			long total = 0;
			int[] listOfItem = createArray(quantityOfItem);
			Arrays.sort(listOfItem);
			total = countWays(listOfItem, quantityOfItem);
			stringBuilder.append(total).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static long countWays(int[] listOfItem, int quantityOfItem) {
		long count = 1;
		long total = 0;
		for (int i = 0; i < quantityOfItem - 1; i++) {
			count = 1;
			while (checkSimilarNumber(listOfItem[i], listOfItem[i + 1])) {
				i++;
				count++;
				if (i == quantityOfItem - 1) {
					break;
				}
			}
			if (count == 2) {
				total += 1;
			} else if (count > 2) {
				total += (count * (count - 1)) / 2;
			}
		}
		return total;
	}

	static boolean checkSimilarNumber(int number1, int number2) {
		if (number1 == number2) {
			return true;
		}
		return false;
	}

	static int[] createArray(int quantity) {
		int[] numbers = new int[quantity];
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
