import java.io.*;
import java.util.*;

//100 done
public class giftWrapping {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfGifts = reader.nextInt();
		int quantityOfWrappingPaper = reader.nextInt();
		List<Double> sizeOfGifts = createArrayList(quantityOfGifts);
		List<Double> sizeOfWrappingPaper = createArrayList(quantityOfWrappingPaper);
		Collections.sort(sizeOfGifts);
		Collections.sort(sizeOfWrappingPaper);
		int tempIndex = 0;
		int count = 0;
		for (var i = 0; i < quantityOfGifts; i++) {
			for (var j = tempIndex; j < quantityOfWrappingPaper; j++) {
				double temp = sizeOfWrappingPaper.get(j) / sizeOfGifts.get(i);
				if ((2 <= temp) && (temp <= 3)) {
					tempIndex = j + 1;
					count++;
					break;
				}
				if (temp > 3) {
					break;
				}
			}
		}
		System.out.println(count);
	}

	static List<Double> createArrayList(int quantity) {
		List<Double> numbers = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			numbers.add(reader.nextDouble());
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
