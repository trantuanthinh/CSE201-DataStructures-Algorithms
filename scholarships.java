import java.io.*;
import java.util.*;

//100 done
public class scholarships {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfStudent = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfStudent; i++) {
			String name = reader.next();
			int quantityOfCourse = reader.nextInt();
			int totalGrade = 0;
			int count = 0;
			for (int j = 0; j < quantityOfCourse; j++) {
				int grade = reader.nextInt();
				totalGrade += grade;
				count++;
			}
			double averageGrade = (double) totalGrade / count;
			var student = new Student(name, totalGrade, quantityOfCourse, averageGrade);
			listOfStudent.add(student);
		}
		if (listOfStudent.size() == 1) {
			stringBuilder.append(listOfStudent.get(0).getName()).append("\n");
		} else {
			Collections.sort(listOfStudent, (student1, student2) -> {
				int compare = Double.compare(student2.getAverageGrade(), student1.getAverageGrade());
				return compare;
			});
			stringBuilder.append(listOfStudent.get(0).getName()).append("\n").append(listOfStudent.get(1).getName());
		}

		System.out.println(stringBuilder);
	}

	static class Student {
		public String name;
		public int totalGrade, quantityOfCourse;
		public double averageGrade;

		public Student(String name, int totalGrade, int quantityOfCourse, double averageGrade) {
			super();
			this.name = name;
			this.totalGrade = totalGrade;
			this.quantityOfCourse = quantityOfCourse;
			this.averageGrade = averageGrade;
		}

		public double getAverageGrade() {
			return averageGrade;
		}

		public String getName() {
			return name;
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
