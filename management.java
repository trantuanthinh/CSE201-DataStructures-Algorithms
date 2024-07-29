import java.io.*;
import java.util.*;

//100 done
public class management {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfEmployee = reader.nextInt();
		var quantityOfQuery = reader.nextInt();
		Hashtable<Integer, Integer> employeesMap = new Hashtable<>();
		for (var i = 0; i < quantityOfEmployee; i++) {
			var employeeID = reader.nextInt();
			var taskID = reader.nextInt();
			if (!employeesMap.containsKey(employeeID)) {
				employeesMap.put(employeeID, taskID);
			}
		}
		for (var i = 0; i < quantityOfQuery; i++) {
			var employeeID = reader.nextInt();
			stringBuilder.append(employeesMap.get(employeeID)).append("\n");
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
