import java.io.*;
import java.util.*;

//100 done
public class kGreatestNumbers {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfNumbers = reader.nextInt();
		var quantityOfMax = reader.nextInt();
		int[] max = createNumbers(quantityOfNumbers);
		Arrays.sort(max);
		int count = 0;
		for (int i = quantityOfNumbers - 1; i >= 0; i--) {
			stringBuilder.append(max[i] + " ");
			count++;
			if (count == quantityOfMax) {
				break;
			}
		}
		System.out.println(stringBuilder);
	}

	static int[] createNumbers(int quantity) {
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
