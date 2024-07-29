import java.io.*;
import java.util.*;

//100 done
public class topHighestGPA1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfStudent = reader.nextInt();
		int quantityOfChosenStudent = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfStudent; i++) {
			long studentID = reader.nextLong();
			String name = reader.next();
			var quantityOfCourse = reader.nextInt();
			var totalGrade = 0;
			var count = 0;
			var credit = 0;
			for (int j = 0; j < quantityOfCourse; j++) {
				var grade = reader.nextInt();
				if (grade >= 50) {
					totalGrade += grade;
					credit += 4;
					count++;
				}
			}
			double averageGrade = 0;
			if (count != 0) {
				averageGrade = (double) totalGrade / count;
			}
			var student = new Student(name, studentID, averageGrade, credit);
			listOfStudent.add(student);
		}
		Collections.sort(listOfStudent, (student1, student2) -> {
			int compare = Double.compare(student2.averageGrade, student1.averageGrade);
			return compare;
		});
		StringBuilder sb = new StringBuilder();
		if (quantityOfStudent == 1) {
			stringBuilder.append(listOfStudent.get(0)).append("\n");
		} else {
			double prevScore = Math.round(listOfStudent.get(0).averageGrade);
			sb.append(listOfStudent.get(0)).append("\n");
			var count = 0;
			for (int i = 1; i <= quantityOfChosenStudent; i++) {
				double temp = Math.round(listOfStudent.get(i).averageGrade);
				if (temp == prevScore) {
					sb.append(listOfStudent.get(i)).append("\n");
					count++;
					if (i == quantityOfStudent - 1) {
						stringBuilder.append(sb);
						break;
					}
				} else {
					if (count <= quantityOfChosenStudent) {
						stringBuilder.append(sb);
						sb.setLength(0);
						sb.append(listOfStudent.get(i)).append("\n");
						prevScore = Math.round(listOfStudent.get(i).averageGrade);
						count++;
						if (i == quantityOfStudent - 1) {
							stringBuilder.append(sb);
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public String name;
		public long studentID;
		public int credit;
		public double averageGrade;

		public Student(String name, long studentID, double averageGrade, int credit) {
			super();
			this.name = name;
			this.studentID = studentID;
			this.averageGrade = averageGrade;
			this.credit = credit;
		}

		@Override
		public String toString() {
			return (studentID + " " + name + " " + (int) Math.round(averageGrade) + " " + credit).toString();
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
