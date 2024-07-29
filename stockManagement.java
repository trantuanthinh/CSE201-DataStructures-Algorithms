import java.io.*;
import java.util.*;

//100 done
public class stockManagement {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringbuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfTransaction = reader.nextInt();
		Hashtable<Integer, Type> typeMap = new Hashtable<>();
		for (var i = 0; i < quantityOfTransaction; i++) {
			char sign = reader.next().charAt(0);
			var code = reader.nextInt();
			var quantity = reader.nextInt();
			var averageUnitPrice = reader.nextInt();
			if (sign == '+') {
				if (!typeMap.containsKey(code)) {
					Type type = new Type(code, 0, 0, 0);
					typeMap.put(code, type);
				}
				var totalQuantity = typeMap.get(code).getTotalQuantity() + quantity;
				long importPrice = (long) quantity * averageUnitPrice;
				long totalImportPrice = (long) typeMap.get(code).getTotalImportPrice() + importPrice;
				typeMap.get(code).setTotalQuantity(totalQuantity);
				typeMap.get(code).setTotalImportPrice(totalImportPrice);
			} else {
				if (typeMap.get(code) != null) {
					if (typeMap.get(code).getTotalQuantity() >= quantity) {
						var totalQuantity = typeMap.get(code).getTotalQuantity() - quantity;
						long exportPrice = (long) quantity * averageUnitPrice;
						long totalExportPrice = (long) typeMap.get(code).getTotalExportPrice() + exportPrice;
						typeMap.get(code).setTotalQuantity(totalQuantity);
						typeMap.get(code).setTotalExportPrice(totalExportPrice);
					}
				}
			}
		}
		List<Integer> setOfCode = new ArrayList<>(typeMap.keySet());
		Collections.sort(setOfCode);
		for (int eachCode : setOfCode) {
			stringbuilder.append(typeMap.get(eachCode)).append("\n");
		}
		System.out.println(stringbuilder);
	}

	static class Type {
		public int code, totalQuantity;
		public long totalImportPrice, totalExportPrice;

		@Override
		public String toString() {
			return code + " " + totalImportPrice + " " + totalExportPrice;
		}

		public Type(int code, int totalQuantity, long totalImportPrice, long totalExportPrice) {
			super();
			this.code = code;
			this.totalQuantity = totalQuantity;
			this.totalImportPrice = totalImportPrice;
			this.totalExportPrice = totalExportPrice;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public int getTotalQuantity() {
			return totalQuantity;
		}

		public void setTotalQuantity(int totalQuantity) {
			this.totalQuantity = totalQuantity;
		}

		public long getTotalImportPrice() {
			return totalImportPrice;
		}

		public void setTotalImportPrice(long totalImportPrice) {
			this.totalImportPrice = totalImportPrice;
		}

		public long getTotalExportPrice() {
			return totalExportPrice;
		}

		public void setTotalExportPrice(long totalExportPrice) {
			this.totalExportPrice = totalExportPrice;
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