import java.io.*;
import java.util.*;

//100 done
public class firstOccurrence {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var quantity = reader.nextInt();
		Hashtable<Integer, Boolean> valueMap = new Hashtable<>();
		for (var i = 0; i < quantity; i++) {
			var value = reader.nextInt();
			if (!valueMap.getOrDefault(value, false)) {
				valueMap.put(value, true);
				System.out.println(value);
			}
		}
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
