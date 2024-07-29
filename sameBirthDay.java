import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

//100 done
public class sameBirthDay {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();
	static DecimalFormat decimalFormat = new DecimalFormat("00");

	public static void main(String[] args) {
		int quantityOfStudent = reader.nextInt();
		Hashtable<Integer, BirthDay> birthDayMap = new Hashtable<>();
		for (var i = 0; i < quantityOfStudent; i++) {
			var day = reader.nextInt();
			var month = reader.nextInt();
			var year = reader.nextInt();
			var birthDayDate = year * 10000 + month * 100 + day;
			if (!birthDayMap.containsKey(birthDayDate)) {
				String formattedDate = decimalFormat.format(day) + "/" + decimalFormat.format(month) + "/" + year;
				BirthDay birthDay = new BirthDay(day, month, year, 1, formattedDate);
				birthDayMap.put(birthDayDate, birthDay);
			} else {
				var tempCount = birthDayMap.get(birthDayDate).getCount();
				birthDayMap.get(birthDayDate).setCount(tempCount + 1);
			}
		}
		List<BirthDay> listOfBirthDay = new ArrayList<>(birthDayMap.values());
		Collections.sort(listOfBirthDay, Comparator.comparing(BirthDay::getYear).thenComparing(BirthDay::getMonth)
				.thenComparing(BirthDay::getDay));
		for (BirthDay eachBirthDay : listOfBirthDay) {
			stringBuilder.append(eachBirthDay).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static class BirthDay {
		public int day, month, year, count;
		public String formattedDate;

		public BirthDay(int day, int month, int year, int count, String formattedDate) {
			super();
			this.day = day;
			this.month = month;
			this.year = year;
			this.count = count;
			this.formattedDate = formattedDate;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return formattedDate + " " + count;
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
