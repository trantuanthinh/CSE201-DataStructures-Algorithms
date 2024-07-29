import java.io.*;
import java.util.*;

//100 done
public class warehouseManagement {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringbuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfTransaction = reader.nextInt();
		Hashtable<Integer, List<Product>> listOfImportTransactionMap = new Hashtable<>();
		Hashtable<Integer, Type> typeMap = new Hashtable<>();
		for (var i = 0; i < quantityOfTransaction; i++) {
			char sign = reader.next().charAt(0);
			var code = reader.nextInt();
			var quantity = reader.nextInt();
			var averageUnitPrice = reader.nextLong();
			var transactionTime = reader.nextInt();
			if (sign == '+') {
				Product product = new Product(quantity, transactionTime, averageUnitPrice);
				if (!listOfImportTransactionMap.containsKey(code)) {
					listOfImportTransactionMap.put(code, new ArrayList<>());
				}
				listOfImportTransactionMap.get(code).add(product);

				if (!typeMap.containsKey(code)) {
					Type type = new Type(code, 0, 0, 0, transactionTime);
					typeMap.put(code, type);
				}
				var totalQuantity = typeMap.get(code).getTotalQuantity() + quantity;
				typeMap.get(code).setTotalQuantity(totalQuantity);
			} else {
				if (typeMap.get(code) != null) {
					if (typeMap.get(code).getTotalQuantity() >= quantity) {
						var totalQuantity = typeMap.get(code).getTotalQuantity() - quantity;
						typeMap.get(code).setTotalQuantity(totalQuantity);
						for (int j = 0; j < listOfImportTransactionMap.get(code).size(); j++) {
							quantity = quantity - listOfImportTransactionMap.get(code).get(j).quantity;
							typeMap.get(code).setOldestTime(Math.max(typeMap.get(code).getOldestTime(),
									listOfImportTransactionMap.get(code).get(j).transactionTime));
							if (quantity > 0) {
								listOfImportTransactionMap.get(code).remove(j).setQuantity(0);
								typeMap.get(code).setOldestTime(Math.max(typeMap.get(code).getOldestTime(),
										listOfImportTransactionMap.get(code).get(j).transactionTime));
								j--;
							} else if (quantity < 0) {
								listOfImportTransactionMap.get(code).get(j).setQuantity(Math.abs(quantity));
								break;
							} else {
								listOfImportTransactionMap.get(code).remove(j).setQuantity(0);
								if (j != listOfImportTransactionMap.get(code).size()) {
									typeMap.get(code).setOldestTime(Math.max(typeMap.get(code).getOldestTime(),
											listOfImportTransactionMap.get(code).get(j).transactionTime));
								}
								break;
							}
						}
					}
				}
			}
		}
		List<Integer> setOfCode = new ArrayList<>(listOfImportTransactionMap.keySet());
		Collections.sort(setOfCode);
		for (int eachCode : setOfCode) {
			if (typeMap.get(eachCode).totalQuantity != 0) {
				var finalPrice = 0l;
				for (Product eachProduct : listOfImportTransactionMap.get(eachCode)) {
					long totalPrice = (long) (eachProduct.quantity * eachProduct.averageUnitPrice);
					finalPrice += totalPrice;
				}
				var tempQuantity = typeMap.get(eachCode).getTotalQuantity();
				typeMap.get(eachCode).setAverageUnitPrice((double) (finalPrice / tempQuantity));
				stringbuilder.append(typeMap.get(eachCode)).append("\n");
			}
		}
		System.out.println(stringbuilder);
	}

	static class Type {
		public int code, totalQuantity, oldestTime;
		public double averageUnitPrice;
		public long totalPrice;

		public Type(int code, int totalQuantity, long totalPrice, double averageUnitPrice, int oldestTime) {
			super();
			this.code = code;
			this.totalQuantity = totalQuantity;
			this.totalPrice = totalPrice;
			this.averageUnitPrice = averageUnitPrice;
			this.oldestTime = oldestTime;
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

		public long getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(long totalPrice) {
			this.totalPrice = totalPrice;
		}

		public double getAverageUnitPrice() {
			return averageUnitPrice;
		}

		public void setAverageUnitPrice(double averageUnitPrice) {
			this.averageUnitPrice = averageUnitPrice;
		}

		public int getOldestTime() {
			return oldestTime;
		}

		public void setOldestTime(int oldestTime) {
			this.oldestTime = oldestTime;
		}

		@Override
		public String toString() {
			return code + " " + totalQuantity + " " + (int) Math.floor(averageUnitPrice) + " " + oldestTime;
		}
	}

	static class Product {
		public int quantity, transactionTime;
		public long averageUnitPrice;
		public long totalPrice;

		public Product(int quantity, int transactionTime, long averageUnitPrice) {
			super();
			this.quantity = quantity;
			this.transactionTime = transactionTime;
			this.averageUnitPrice = averageUnitPrice;
			this.totalPrice = (long) quantity * averageUnitPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getTransactionTime() {
			return transactionTime;
		}

		public void setTransactionTime(int transactionTime) {
			this.transactionTime = transactionTime;
		}

		public long getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(long totalPrice) {
			this.totalPrice = totalPrice;
		}

		public long getAverageUnitPrice() {
			return averageUnitPrice;
		}

		public void setAverageUnitPrice(long averageUnitPrice) {
			this.averageUnitPrice = averageUnitPrice;
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