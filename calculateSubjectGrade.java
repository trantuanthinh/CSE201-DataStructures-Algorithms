import java.io.*;
import java.util.*;

//80
public class calculateSubjectGrade {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfStudent = reader.nextInt();
		var quantityOfExercise = reader.nextInt();
		var totalSubmission = reader.nextInt();
		List<Integer> listOfStudentID = creatList(quantityOfStudent);
		List<Integer> listOfExerciseID = creatList(quantityOfExercise);
		Hashtable<Integer, Student> studentMap = new Hashtable<>();
		for (int i : listOfStudentID) {
			Hashtable<Integer, Integer> gradeOfExerciseID = new Hashtable<>();
			gradeOfExerciseID.put(0, 0);
			Student student = new Student(i, 0, 0, gradeOfExerciseID);
			studentMap.put(i, student);
		}
		for (int i = 0; i < totalSubmission; i++) {
			// input
			var studentID = reader.nextInt();
			var exerciseID = reader.nextInt();
			var grade = reader.nextInt();
			if (checkExerciseID(listOfExerciseID, exerciseID)) {
				// set quantity of submission
				var tempSubmittion = studentMap.get(studentID).getQuantityOfSubmission() + 1;
				studentMap.get(studentID).setQuantityOfSubmission(tempSubmittion);
				// set exercise-grade
				var tempGradeOfExercise = studentMap.get(studentID).getGradeOfExerciseIDMap().get(exerciseID);
				if (tempGradeOfExercise == null || tempGradeOfExercise < grade) {
					Hashtable<Integer, Integer> gradeOfExercise = studentMap.get(studentID).gradeOfExerciseIDMap;
					gradeOfExercise.put(exerciseID, grade);
					studentMap.get(studentID).setGradeOfExerciseIDMap(gradeOfExercise);
				}
			}
		}
		List<Student> setOfStudent = new ArrayList<>(studentMap.values());
		for (Student eachStudent : setOfStudent) {
			eachStudent.setGpa(calculateGPA(eachStudent, quantityOfExercise));
		}
		Collections.sort(setOfStudent, (student1, student2) -> {
			int compareGPA = Double.compare(student2.gpa, student1.gpa);
			if (compareGPA == 0) {
				int compareSubmittion = Integer.compare(student1.quantityOfSubmission, student2.quantityOfSubmission);
				if (compareSubmittion == 0) {
					int compareStudentID = Integer.compare(student1.studentID, student2.studentID);
					return compareStudentID;
				}
				return compareSubmittion;
			}
			return compareGPA;
		});
		for (Student eachStudent : setOfStudent) {
			stringBuilder.append(eachStudent).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static double calculateGPA(Student student, int quantityOfExercise) {
		if (student.getGradeOfExerciseIDMap() == null) {
			return 0;
		}
		List<Integer> setOfGrade = new ArrayList<>(student.gradeOfExerciseIDMap.values());
		int tempTotalGrade = 0;
		for (int eachGrade : setOfGrade) {
			tempTotalGrade += eachGrade;
		}
		double tempGPA = tempTotalGrade / quantityOfExercise;
		return tempGPA;
	}

	static boolean checkExerciseID(List<Integer> listOfExerciseID, int exerciseID) {
		for (int eachExerciseID : listOfExerciseID) {
			if (eachExerciseID == exerciseID) {
				return true;
			}
		}
		return false;
	}

	static List<Integer> creatList(int quantity) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			var ID = reader.nextInt();
			list.add(ID);
		}
		return list;
	}

	static class Student {
		public int studentID, quantityOfSubmission;
		public double gpa;
		Hashtable<Integer, Integer> gradeOfExerciseIDMap;

		public Student(int studentID, int quantityOfSubmittion, double gpa,
				Hashtable<Integer, Integer> gradeOfExerciseIDMap) {
			super();
			this.studentID = studentID;
			this.quantityOfSubmission = quantityOfSubmittion;
			this.gpa = gpa;
			this.gradeOfExerciseIDMap = gradeOfExerciseIDMap;
		}

		public int getStudentID() {
			return studentID;
		}

		public void setStudentID(int studentID) {
			this.studentID = studentID;
		}

		public int getQuantityOfSubmission() {
			return quantityOfSubmission;
		}

		public void setQuantityOfSubmission(int quantityOfSubmission) {
			this.quantityOfSubmission = quantityOfSubmission;
		}

		public double getGpa() {
			return gpa;
		}

		public void setGpa(double gpa) {
			this.gpa = gpa;
		}

		public Hashtable<Integer, Integer> getGradeOfExerciseIDMap() {
			return gradeOfExerciseIDMap;
		}

		public void setGradeOfExerciseIDMap(Hashtable<Integer, Integer> gradeOfExerciseIDMap) {
			this.gradeOfExerciseIDMap = gradeOfExerciseIDMap;
		}

		@Override
		public String toString() {
			return studentID + " " + (int) Math.floor(gpa) + " " + quantityOfSubmission;
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
