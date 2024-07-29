import java.io.*;
import java.util.*;

//100 done
public class logFiles2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfLogFile = reader.nextInt();
		var quantityOfEvent = reader.nextInt();
		long[] listOfLogFile = new long[quantityOfLogFile];
		long[] listOfEvent = new long[quantityOfEvent];
		for (int i = 0; i < quantityOfLogFile; i++) {
			listOfLogFile[i] = reader.nextLong();
		}
		for (int i = 0; i < quantityOfEvent; i++) {
			listOfEvent[i] = reader.nextLong();
		}
		System.out.println(checkLogFile(quantityOfLogFile, quantityOfEvent, listOfLogFile, listOfEvent));
	}

	static StringBuilder checkLogFile(int quantityOfLogFile, int quantityOfEvent, long[] listOfLogFile,
			long[] listOfEvent) {
		Arrays.sort(listOfLogFile);
		for (int i = 0; i < quantityOfEvent; i++) {
			int index = Arrays.binarySearch(listOfLogFile, listOfEvent[i]);
			if (index >= 0) {
				stringBuilder.append(listOfLogFile[index]).append(" ");
			} else if (index < 0) {
				index = -(index + 1);
				if (index < listOfLogFile.length) {
					stringBuilder.append(listOfLogFile[index]).append(" ");
				} else {
					stringBuilder.append(-1).append(" ");
				}
			}
		}
		return stringBuilder;
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