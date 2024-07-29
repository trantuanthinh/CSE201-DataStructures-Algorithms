import java.io.*;
import java.util.*;

//100 done
public class firstActivitiesOfTheYear {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		int quantityOfStudent = reader.nextInt();
		List<Integer> badge = new ArrayList<>();
		for (int i = 0; i < quantityOfStudent; i++) {
			badge.add(Integer.parseInt(reader.next()));
		}
		Collections.sort(badge);
		int count = 1;
		for (int i = quantityOfStudent - 1; i >= 0; i--) {
			if (i == 0) {
				stringBuilder.append(badge.get(i)).append(" ").append(count);
				break;
			}
			if (badge.get(i).equals(badge.get(i - 1))) {
				count++;
			} else {
				stringBuilder.append(badge.get(i)).append(" ").append(count).append("\n");
				count = 1;
			}
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
