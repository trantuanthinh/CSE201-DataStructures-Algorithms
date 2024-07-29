import java.io.*;
import java.util.*;

//100 done
public class qualityAndValue {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var quantityOfLaptop = reader.nextInt();
		Hashtable<Integer, Integer> laptopMap = new Hashtable<>();
		for (var i = 0; i < quantityOfLaptop; i++) {
			var price = reader.nextInt();
			var speed = reader.nextInt();
			laptopMap.put(price, speed);
		}
		List<Integer> listOfPrice = new ArrayList<>(laptopMap.keySet());
		Collections.sort(listOfPrice);
		boolean flag = false;
		for (int i = 0; i < quantityOfLaptop - 1; i++) {
			if (laptopMap.get(listOfPrice.get(i)) > laptopMap.get(listOfPrice.get(i + 1))) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Happy Beo");
		} else {
			System.out.println("Poor Beo");
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