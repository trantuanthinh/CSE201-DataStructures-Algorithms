import java.io.*;
import java.util.*;

//100 done
public class eatIceCream {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfIceCream = reader.nextLong();
		var quantityOfPromotionIceCream = reader.nextLong();
		var day = quantityOfIceCream;
		while (quantityOfIceCream >= quantityOfPromotionIceCream) {
			day += quantityOfIceCream / quantityOfPromotionIceCream;
			quantityOfIceCream = (quantityOfIceCream / quantityOfPromotionIceCream)
					+ quantityOfIceCream % quantityOfPromotionIceCream;
		}
		System.out.println(day);
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
