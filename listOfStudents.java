import java.io.*;
import java.util.*;

//100 done
public class listOfStudents {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var quantityOfName = reader.nextInt();
		List<Student> listOfStudent = new ArrayList<>();
		for (int i = 0; i < quantityOfName; i++) {
			listOfStudent.add(addStudent());
		}
		Collections.sort(listOfStudent, Comparator.comparing(Student::getId));
		for (Student i : listOfStudent) {
			stringBuilder.append(i.getId()).append(" ").append(i.getName()).append(" ").append(i.age).append(" ")
					.append(i.majorCode).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static class Student {
		public int age, majorCode;
		public long id;
		public String name;

		public Student(long id, String name, int age, int majorCode) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.majorCode = majorCode;
		}

		public long getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getMajorCode() {
			return majorCode;
		}

		public void setMajorCode(int major) {
			this.majorCode = major;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	static Student addStudent() {
		var id = reader.nextLong();
		var name = reader.next();
		var age = reader.nextInt();
		var majorCode = reader.nextInt();
		var student = new Student(id, name, age, majorCode);
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
