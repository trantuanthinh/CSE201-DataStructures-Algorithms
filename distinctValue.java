import java.io.*;
import java.util.*;

//100 done
public class distinctValue {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfTestCase = reader.nextInt();
		for (var i = 0; i < quantityOfTestCase; i++) {
			Hashtable<Integer, Boolean> valueMap = new Hashtable<>();
			var quantityOfNumber = reader.nextInt();
			for (var j = 0; j < quantityOfNumber; j++) {
				var value = reader.nextInt();
				if (valueMap.containsKey(value)) {
					valueMap.put(value, false);
				} else {
					valueMap.put(value, true);
				}
			}
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for (var j : valueMap.keySet()) {
				if (valueMap.get(j)) {
					numbers.add(j);
				}
			}
			Collections.sort(numbers);
			for (var j : numbers) {
				stringBuilder.append(j + " ");
			}
		}
		System.out.println(stringBuilder);
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
