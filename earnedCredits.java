import java.io.*;
import java.util.*;

//100 done
public class earnedCredits {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfCourses = reader.nextInt();
		var count = 0;
		Hashtable<String, Integer> courseMap = new Hashtable<String, Integer>();
		for (var i = 0; i < quantityOfCourses; i++) {
			String idCourse = reader.next();
			var credit = reader.nextInt();
			if (!courseMap.contains(idCourse)) {
				courseMap.put(idCourse, credit);
			}
		}
		for (var i = 0; i < quantityOfCourses; i++) {
			int grade = reader.nextInt();
			String idCourse = reader.next();
			if (grade >= 50) {
				count += courseMap.get(idCourse);
			}
		}
		System.out.println(count);
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
