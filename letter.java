import java.io.*;
import java.util.*;

//100 done
public class letter {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		String firstPart = reader.next();
		String secondPart = reader.next();
		int count = 0;
		var lastLetter = secondPart.lastIndexOf(firstPart.charAt(firstPart.length() - 1));
		int lastIndexOfFirstPart = firstPart.length() - 1;
		for (var i = lastLetter; i >= 0; i--) {
			if (lastIndexOfFirstPart >= 0) {
				if (firstPart.charAt(lastIndexOfFirstPart) == secondPart.charAt(i)) {
					lastIndexOfFirstPart--;
					count++;
				} else if (count > 0) {
					count = 0;
					lastIndexOfFirstPart = firstPart.length() - 1;
					i++;
				}
			}
		}
		System.out.println(firstPart.length() + secondPart.length() - count);
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
