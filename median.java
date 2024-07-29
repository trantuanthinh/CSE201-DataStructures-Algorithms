import java.io.*;
import java.util.*;

//100 done
public class median {
	static InputReader reader = new InputReader(System.in);
	static Random random = new Random();

	public static void main(String[] args) {
		var quantity = reader.nextInt();
		int[] numbers = createArray(quantity);
		Arrays.sort(numbers);
		double medianNumber = 0;
		if (numbers.length % 2 == 0) {
			int number1 = numbers[(numbers.length / 2) - 1];
			int number2 = numbers[numbers.length / 2];
			medianNumber = (double) (number1 + number2) / 2;
		} else {
			medianNumber = (double) numbers[((numbers.length + 1) / 2) - 1];
		}
		System.out.println(medianNumber);
	}

	static int[] createArray(int quantity) {
		int[] numbers = new int[quantity];
		for (int i = 0; i < numbers.length; i++) {
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
