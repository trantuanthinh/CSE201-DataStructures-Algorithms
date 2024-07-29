import java.io.*;
import java.util.*;

//100 done
public class gpa {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfStudent = reader.nextInt();
		for (var i = 0; i < quantityOfStudent; i++) {
			String studentName = reader.next();
			stringBuilder.append(studentName + " ");
			var quantityOfCourses = reader.nextInt();
			var count = 0;
			var gpa = 0;
			for (var j = 0; j < quantityOfCourses; j++) {
				var grade = reader.nextInt();
				if (grade >= 50) {
					count++;
					gpa += grade;
					stringBuilder.append(grade + " ");
				}
			}
			if (count != 0) {
				gpa = gpa / count;
				stringBuilder.append(gpa + " " + "\n");
			} else {
				stringBuilder.append(0 + "\n");
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
