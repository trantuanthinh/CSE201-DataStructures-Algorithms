import java.io.*;
import java.util.*;

//90.91
public class logFiles {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfLogFile = reader.nextInt();
		long[] listOfLogFile = new long[quantityOfLogFile];
		for (int i = 0; i < quantityOfLogFile; i++) {
			listOfLogFile[i] = reader.nextLong();
		}
		long totalTime = calculateTimeToCheckAllLogFiles(quantityOfLogFile, listOfLogFile);
		System.out.println(totalTime);
	}

	static long calculateTimeToCheckAllLogFiles(int quantityOfLogFile, long[] listOfLogFile) {
		Arrays.sort(listOfLogFile);
		long totalTime = 0;
		for (int i = 0; i < quantityOfLogFile; i++) {
			int index = Arrays.binarySearch(listOfLogFile, listOfLogFile[i] + 600000);
			if (index > 0 && index != i) {
				totalTime += index - i;
			} else if (index < 0 && Math.abs(index + 2) != i) {
				totalTime += -index - 2 - i;
			}
		}
		return totalTime;
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