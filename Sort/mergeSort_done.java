package Sort;

import java.io.*;
import java.util.*;

public class mergeSort_done {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantity = reader.nextInt();
		int[] array = creatArray(quantity);
		array = mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		System.out.println(stringBuilder);
	}

	static int[] mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, array.length - 1);
			merge(array, left, mid, right);
		}
		return array;
	}

	static void merge(int[] array, int left, int mid, int right) {
		int[] temp = new int[array.length];
		for (int i = left; i <= right; i++) {
			temp[i] = array[i];
		}
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			array[k] = temp[i];
			i++;
			k++;
		}
		while (j <= right) {
			array[k] = temp[j];
			j++;
			k++;
		}
	}

	static int[] creatArray(int quantity) {
		int[] numbers = new int[quantity];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = reader.nextInt();
		}
		return numbers;
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
