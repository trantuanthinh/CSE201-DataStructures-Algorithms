import java.io.*;
import java.util.*;

//100 done
public class pageNumbers {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfPages = reader.nextInt();
		int[] pages = createArray(quantityOfPages);
		Arrays.sort(pages);
		for (int i = 0; i < quantityOfPages; i++) {
			int countConsecutive = 1;
			int nextIndex = 0;
			if (checkLastNumber(pages[i], pages, quantityOfPages)) {
				stringBuilder.append(pages[i]);
			} else {
				int firstValue = pages[i];
				int lastValue = 0;
				for (int j = i + 1; j < quantityOfPages; j++) {
					nextIndex++;
					if (checkConsecutive(pages[i], nextIndex, pages[j])) {
						lastValue = pages[j];
						countConsecutive++;
					} else {
						break;
					}
				}
				if (countConsecutive >= 3) {
					stringBuilder.append(firstValue).append("-").append(lastValue).append(" ");
					i = countConsecutive + i - 1;
				} else if (countConsecutive == 2) {
					stringBuilder.append(firstValue).append(" ").append(lastValue).append(" ");
					i++;
				} else {
					stringBuilder.append(firstValue).append(" ");
				}
				if (checkLastNumber(lastValue, pages, quantityOfPages)) {
					break;
				}
			}
		}
		System.out.println(stringBuilder);
	}

	static boolean checkLastNumber(int pageNumber, int[] pages, int quantityOfPages) {
		if (pageNumber == pages[quantityOfPages - 1]) {
			return true;
		}
		return false;
	}

	static boolean checkConsecutive(int pageNumber, int nextIndex, int nextPage) {
		if (pageNumber + nextIndex == nextPage) {
			return true;
		}
		return false;
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
