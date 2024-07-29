import java.io.*;
import java.util.*;

//100 done
public class leapYear {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
		int quantity = reader.nextInt();
		int[] years = new int[quantity];
		for (int i = 0; i < years.length; i++) {
			years[i] = reader.nextInt();
		}
		for (int i = 0; i < quantity; i++) {
			if (checkLeapYear(years[i])) {
				stringBuffer.append("YES \n");
			} else {
				stringBuffer.append("NO \n");
			}
		}
		System.out.println(stringBuffer);
	}

	static boolean checkLeapYear(int years) {
		if (years % 400 == 0) {
			return true;
		} else if (years % 4 == 0 && years % 100 != 0) {
			return true;
		}
		return false;
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
