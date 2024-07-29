import java.io.*;
import java.util.*;

//100 done
public class theMostCommonNumber {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int quantity = reader.nextInt();
		Hashtable<Integer, Integer> freqMap = new Hashtable<>();
		int maxOccurrence = Integer.MIN_VALUE;
		int maxOccurrenceValue = 0;
		for (var i = 0; i < quantity; i++) {
			var value = reader.nextInt();
			Integer occur = freqMap.getOrDefault(value, 0);
			occur++;
			freqMap.put(value, occur);
			if (occur > maxOccurrence) {
				maxOccurrence = occur;
				maxOccurrenceValue = value;
			} else if (occur == maxOccurrence && value < maxOccurrenceValue) {
				maxOccurrenceValue = value;
			}
		}
		System.out.println(maxOccurrenceValue + " " + maxOccurrence);
	}

	static int countOccurrence(int[] numbers, int number) {
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				count++;
			}
		}
		return count;
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
