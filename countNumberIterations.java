import java.io.*;
import java.util.*;

//100 done
public class countNumberIterations {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantity = reader.nextInt();
		while (quantity > 0) {
			int[] numbers = input(quantity);
			stringBuilder.append(count(numbers) + "\n");
			quantity = reader.nextInt();
		}
		System.out.println(stringBuilder);
	}

	public static int[] input(int n) {
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = reader.nextInt();
		}
		return numbers;
	}

	public static int count(int[] numbers) {
		int count = 0;
		while (!checkEqual(numbers)) {
			int valueIndex0 = numbers[0];
			numbers = calculate(numbers, valueIndex0);
			count++;
			if (count > 1000) {
				return -1;
			}
		}
		return count;
	}

	public static int[] calculate(int[] numbers, int valueIndex0) {
		for (int i = 0; i < numbers.length; i++) {
			if (i == numbers.length - 1) {
				numbers[i] = Math.abs(numbers[i] - valueIndex0);
			} else {
				numbers[i] = Math.abs(numbers[i] - numbers[i + 1]);
			}
		}
		return numbers;
	}

	public static boolean checkEqual(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[0] != numbers[i]) {
				return false;
			}
		}
		return true;
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