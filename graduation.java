import java.io.*;
import java.util.*;

//100 done
public class graduation {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfStudent = reader.nextInt();
		var minCredit = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (var i = 0; i < quantityOfStudent; i++) {
			var studentID = reader.nextInt();
			String studentName = reader.next();
			var quantityOfCourse = reader.nextInt();
			var credit = 0;
			var totalGrade = 0;
			for (var j = 0; j < quantityOfCourse; j++) {
				var grade = reader.nextInt();
				if (grade >= 50) {
					totalGrade += grade;
					credit += 4;
				}
			}
			if (credit >= minCredit) {
				var studentGPA = totalGrade / (credit / 4);
				Student student = new Student(studentID, studentName, studentGPA);
				listOfStudent.add(student);
			}
		}
		Collections.sort(listOfStudent, (student1, student2) -> {
			var compare = Double.compare(student2.gpa, student1.gpa);
			if (compare == 0) {
				return Double.compare(student1.id, student2.id);
			}
			return compare;
		});
		for (Student i : listOfStudent) {
			stringBuilder.append(i).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public int id;
		public double gpa;
		public String name;

		public Student(int id, String name, int gpa) {
			super();
			this.id = id;
			this.name = name;
			this.gpa = gpa;
		}

		@Override
		public String toString() {
			return id + " " + name + " " + (int) Math.floor(gpa);
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
