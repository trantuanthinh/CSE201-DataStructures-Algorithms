import java.io.*;
import java.util.*;

//100 done
public class messages {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfSentWord = reader.nextInt();
		var quantityOfWord = reader.nextInt();
		Dictionary<String, String> wordMap = new Hashtable<>();
		for (int i = 0; i < quantityOfWord; i++) {
			String languageA = reader.next();
			String languageB = reader.next();
			if (languageA.length() > languageB.length()) {
				wordMap.put(languageA, languageB);
			}
		}
		for (int i = 0; i < quantityOfSentWord; i++) {
			String sentWord = reader.next();
			if (wordMap.get(sentWord) == null) {
				stringBuilder.append(sentWord).append(" ");
			} else {
				stringBuilder.append(wordMap.get(sentWord)).append(" ");
			}
		}
		System.out.println(stringBuilder);
	}

	static String chooseShortWord(String languageA, String languageB) {
		// A > B --> true
		if (languageA.length() > languageB.length()) {
			return languageB;
		}
		// A <= B --> false
		return languageA;
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
