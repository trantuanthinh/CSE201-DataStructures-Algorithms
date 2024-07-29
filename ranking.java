import java.io.*;
import java.util.*;

//100 done
public class ranking {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfStudent = reader.nextInt();
		var quantityOfScholarship = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfStudent; i++) {
			long studentID = reader.nextLong();
			String name = reader.next();
			var quantityOfCourse = reader.nextInt();
			var totalGrade = 0;
			var count = 0;
			for (int j = 0; j < quantityOfCourse; j++) {
				var grade = reader.nextInt();
				if (grade >= 50) {
					totalGrade += grade;
					count++;
				}
			}
			double averageGrade = 0;
			if (count != 0) {
				averageGrade = (double) totalGrade / count;
			}
			var student = new Student(name, studentID, averageGrade);
			listOfStudent.add(student);
		}
		Collections.sort(listOfStudent, (student1, student2) -> {
			int compareGPA = Double.compare(student2.gpa, student1.gpa);
			if (compareGPA == 0) {
				return Double.compare(student1.studentID, student2.studentID);
			}
			return compareGPA;
		});
		if (quantityOfStudent == 1) {
			stringBuilder.append(1).append(" ").append(listOfStudent.get(0).toString()).append("\n");
		} else {
			var tempGPA = listOfStudent.get(0).gpa;
			var rank = 1;
			stringBuilder.append(1).append(" ").append(listOfStudent.get(0).toString()).append("\n");
			int i = 1;
			int count = 1;
			while (count < quantityOfScholarship || listOfStudent.get(i).gpa == tempGPA) {
				if (listOfStudent.get(i).gpa == tempGPA) {
					stringBuilder.append(rank).append(" ");
				} else {
					rank = i + 1;
					stringBuilder.append(rank).append(" ");
					tempGPA = listOfStudent.get(i).gpa;
				}
				stringBuilder.append(listOfStudent.get(i).toString()).append("\n");
				count++;
				i++;
				if (i == quantityOfStudent) {
					break;
				}
			}
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public String name;
		public long studentID;
		public double gpa;

		public Student(String name, long studentID, double gpa) {
			super();
			this.name = name;
			this.studentID = studentID;
			this.gpa = gpa;
		}

		@Override
		public String toString() {
			return (studentID + " " + name + " " + (int) Math.round(gpa)).toString();
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
