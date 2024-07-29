import java.io.*;
import java.util.*;

// 100 done
public class buildPyramid {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var quantityOfBricks = reader.nextInt();
		System.out.println(bricksAtExactlyLayers(quantityOfBricks));
	}

	static int bricksAtExactlyLayers(int quantityOfBricks) {
		if (quantityOfBricks == 0) {
			return 0;
		}
		ArrayList<Integer> layers = new ArrayList<Integer>();
		layers.add(1);
		int total = 1;
		int nthLayer = 1;
		for (int i = 1; total < quantityOfBricks; i++) {
			int tempValue = layers.get(i - 1) + i + 1;
			if (total + tempValue <= quantityOfBricks) {
				layers.add(tempValue);
				total += tempValue;
				nthLayer++;
			} else {
				break;
			}
		}
		return nthLayer;
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
