import java.io.*;
import java.util.*;

//100 done
public class topHighestGPA2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfStudent = reader.nextInt();
		int quantityOfChosenStudent = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfStudent; i++) {
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
			var student = new Student(name, averageGrade, credit);
			listOfStudent.add(student);
		}

		Collections.sort(listOfStudent, (student1, student2) -> {
			int compareGPA = Double.compare(student2.averageGrade, student1.averageGrade);
			if (compareGPA == 0) {
				var compareCredit = Integer.compare(student2.credit, student1.credit);
				if (compareCredit == 0) {
					return student1.name.compareTo(student2.name);
				}
				return compareCredit;
			}
			return compareGPA;
		});

		if (quantityOfChosenStudent == quantityOfStudent) {
			for (Student student : listOfStudent) {
				stringBuilder.append(student).append("\n");
			}
		} else {
			var pivotIndex = quantityOfChosenStudent;
			var pivotAverageGrade = listOfStudent.get(pivotIndex).averageGrade;
			while (Double.compare(pivotAverageGrade, listOfStudent.get(pivotIndex - 1).averageGrade) == 0L) {
				pivotIndex--;
				if (pivotIndex == 0) {
					break;
				}
			}
			if (pivotIndex != 0) {
				for (int i = 0; i < pivotIndex; i++) {
					stringBuilder.append(listOfStudent.get(i)).append("\n");
				}
			}
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public String name;
		public int credit;
		public double averageGrade;

		public Student(String name, double averageGrade, int credit) {
			super();
			this.name = name;
			this.averageGrade = averageGrade;
			this.credit = credit;
		}

		@Override
		public String toString() {
			return (name + " " + (int) Math.round(averageGrade) + " " + credit).toString();
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
