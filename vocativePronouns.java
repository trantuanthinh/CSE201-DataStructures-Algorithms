import java.io.*;
import java.util.*;

//100 done
public class vocativePronouns {
	static InputReader reader = new InputReader(System.in);
	static StringBuffer stringBuffer = new StringBuffer();

	public static void main(String[] args) {
		int age = reader.nextInt();
		String gender = reader.next();
		switch (checkAge(age)) {
		case 1:
			System.out.println("Be");
			break;
		case 2:
			System.out.println("Em");
			break;
		case 3:
			if (checkGender(gender)) {
				System.out.println("Anh");
			} else {
				System.out.println("Chi");
			}
			break;
		case 4:
			if (checkGender(gender)) {
				System.out.println("Chu");
			} else {
				System.out.println("Co");
			}
			break;
		case 5:
			if (checkGender(gender)) {
				System.out.println("Ong");
			} else {
				System.out.println("Ba");
			}
			break;
		}
	}

	static int checkAge(int age) {
		if (age <= 5) {
			return 1;
		}
		if (age <= 20) {
			return 2;
		}
		if (age <= 35) {
			return 3;
		}
		if (age <= 60) {
			return 4;
		}
		if (age > 60) {
			return 5;
		}
		return 0;
	}

	static boolean checkGender(String gender) {
		if (gender.equalsIgnoreCase("Nam")) {
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
