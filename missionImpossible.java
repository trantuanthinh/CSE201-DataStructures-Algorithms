import java.io.*;
import java.util.*;

//100 done
public class missionImpossible {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfName = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfName; i++) {
			String fullName = reader.nextLine();
			listOfStudent.add(addStudent(fullName));
		}
		Collections.sort(listOfStudent, Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName)
				.thenComparing(Student::getMiddleName));
		for (Student i : listOfStudent) {
			stringBuilder.append(i.getFullName()).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public String lastName, middleName, firstName;

		public Student(String lastName, String middleName, String firstName) {
			super();
			this.lastName = lastName;
			this.middleName = middleName;
			this.firstName = firstName;
		}

		public String getFullName() {
			if (this.middleName != null) {
				return lastName + " " + middleName + " " + firstName;
			}
			return lastName + " " + firstName;

		}

		public String getLastName() {
			return lastName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public String getFirstName() {
			return firstName;
		}

	}

	static boolean haveMiddleName(String fullName) {
		if (fullName.indexOf(" ") != fullName.lastIndexOf(" ")) {
			// have a middle name
			return true;
		}
		// dont have a middle name
		return false;
	}

	static Student addStudent(String fullName) {
		String lastName = fullName.substring(0, fullName.indexOf(" "));
		String middleName = "";
		if (haveMiddleName(fullName)) {
			middleName = fullName.substring(fullName.indexOf(" ") + 1, fullName.lastIndexOf(" "));
		}
		String firstName = fullName.substring(fullName.lastIndexOf(" ") + 1);
		var student = new Student(lastName, middleName, firstName);
		return student;
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
