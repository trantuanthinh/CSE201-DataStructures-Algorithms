import java.io.*;
import java.util.*;

//100 done
public class theHighestProfitableProduct {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfProduct = reader.nextInt();
		var quantityOfProfitableProduct = reader.nextInt();
		List<Product> listOfProduct = new ArrayList<>();
		for (var i = 0; i < quantityOfProduct; i++) {
			var id = reader.nextInt();
			String name = reader.next();
			var cost = reader.nextInt();
			var price = reader.nextInt();
			var quantityOfSale = reader.nextLong();
			long totalProfit = (cost - price) * quantityOfSale;
			Product product = new Product(id, name, totalProfit);
			listOfProduct.add(product);
		}
		Collections.sort(listOfProduct, (product1, product2) -> {
			int compareTotalProfit = Long.compare(product2.totalProfit, product1.totalProfit);
			if (compareTotalProfit == 0) {
				return Integer.compare(product1.id, product2.id);
			}
			return compareTotalProfit;
		});
		if (quantityOfProfitableProduct == quantityOfProduct) {
			for (Product student : listOfProduct) {
				stringBuilder.append(student).append("\n");
			}
		} else {
			var pivotIndex = quantityOfProfitableProduct - 1;
			var pivotTotalProfit = listOfProduct.get(pivotIndex).totalProfit;
			while (Long.compare(pivotTotalProfit, listOfProduct.get(pivotIndex + 1).totalProfit) == 0L) {
				pivotIndex++;
				if (pivotIndex == 0) {
					break;
				}
			}
			if (pivotIndex != 0) {
				for (int i = 0; i <= pivotIndex; i++) {
					stringBuilder.append(listOfProduct.get(i)).append("\n");
				}
			}
		}
		System.out.println(stringBuilder);
	}

	static class Product {
		public int id;
		public long totalProfit;
		public String name;

		public Product(int id, String name, long totalProfit) {
			super();
			this.id = id;
			this.name = name;
			this.totalProfit = totalProfit;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public long getTotalProfit() {
			return totalProfit;
		}

		public void setTotalProfit(long totalProfit) {
			this.totalProfit = totalProfit;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return id + " " + name + " " + totalProfit;
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