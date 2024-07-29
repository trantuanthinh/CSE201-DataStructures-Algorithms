import java.io.*;
import java.util.*;

//100 done
public class exerciseGrade {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfStudent = reader.nextInt();
		var quantityOfExercise = reader.nextInt();
		var totalSubmission = reader.nextInt();
		Hashtable<Integer, Student> studentMap = new Hashtable<>();
		for (int i = 0; i < quantityOfStudent; i++) {
			var studentID = reader.nextInt();
			Student student = new Student(studentID, quantityOfExercise);
			studentMap.put(studentID, student);
		}
		for (int i = 0; i < quantityOfExercise; i++) {
			reader.nextInt();
		}
		for (int i = 0; i < totalSubmission; i++) {
			// input
			var studentID = reader.nextInt();
			var exerciseID = reader.nextInt();
			var grade = reader.nextInt();
			Student student = studentMap.get(studentID);
			student.addGrade(exerciseID, grade);
		}

		List<Student> setOfStudent = new ArrayList<>(studentMap.values());
		Collections.sort(setOfStudent, Comparator.comparing(Student::getStudentID));
		for (Student eachStudent : setOfStudent) {
			stringBuilder.append(eachStudent).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static List<Integer> creatList(int quantity) {
		List<Integer> listID = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			var id = reader.nextInt();
			listID.add(id);
		}
		return listID;
	}

	static class Student {
		public int studentID, totalGrade, quantityOfSubmission, quantityOfExercise;
		public double gpa;
		List<Integer> listOfExerciseID;
		Hashtable<Integer, Integer> gradeOfExerciseIDMap;

		public Student(int studentID, int quantityOfExercise) {
			super();
			Hashtable<Integer, Integer> gradeOfExerciseID = new Hashtable<>();
			gradeOfExerciseID.put(0, 0);
			this.studentID = studentID;
			this.totalGrade = 0;
			this.quantityOfSubmission = 0;
			this.gpa = 0;
			this.gradeOfExerciseIDMap = gradeOfExerciseID;
			this.quantityOfExercise = quantityOfExercise;
		}

		public void addGrade(int exerciseID, int grade) {
			var previousGrade = this.gradeOfExerciseIDMap.get(exerciseID);
			if (previousGrade == null) {
				this.totalGrade += grade;
				this.gradeOfExerciseIDMap.put(exerciseID, grade);
			} else if (previousGrade < grade) {
				this.totalGrade += grade - previousGrade;
				this.gradeOfExerciseIDMap.put(exerciseID, grade);
			}
			this.gpa = this.totalGrade / this.quantityOfExercise;
		}

		@Override
		public String toString() {
			return studentID + " " + (int) Math.floor(gpa);
		}

		public int getStudentID() {
			return studentID;
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
