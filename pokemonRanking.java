import java.io.*;
import java.util.*;

//100 done
public class pokemonRanking {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		var quantityOfPokemon = reader.nextInt();
		List<Pokemon> listOfPokemon = new ArrayList<>();
		for (int i = 0; i < quantityOfPokemon; i++) {
			var id = reader.nextInt();
			String name = reader.next();
			var attack = reader.nextInt();
			var defense = reader.nextInt();
			var agility = reader.nextInt();
			var luck = reader.nextInt();
			double power = (double) (attack + defense + agility + luck) / 4;
			Pokemon pokemon = new Pokemon(id, name, attack, defense, agility, luck, power);
			listOfPokemon.add(pokemon);
		}
		Collections.sort(listOfPokemon, (pokemon1, pokemon2) -> {
			var comparePower = Double.compare(pokemon2.power, pokemon1.power);
			if (comparePower == 0) {
				var compareAttack = Integer.compare(pokemon2.attack, pokemon1.attack);
				if (compareAttack == 0) {
					return Integer.compare(pokemon1.id, pokemon2.id);
				}
				return compareAttack;
			}
			return comparePower;
		});
		var tempPower = listOfPokemon.get(0).power;
		stringBuilder.append(1).append(" ").append(listOfPokemon.get(0).toString()).append("\n");
		for (int i = 1; i < quantityOfPokemon; i++) {
			if (listOfPokemon.get(i).power == tempPower) {
				stringBuilder.append("-").append(" ");
			} else {
				stringBuilder.append(i + 1).append(" ");
				tempPower = listOfPokemon.get(i).power;
			}
			stringBuilder.append(listOfPokemon.get(i).toString()).append("\n");
		}
		System.out.println(stringBuilder);
	}

	static class Pokemon {
		public int id, attack, defense, agility, luck;
		public double power;
		public String name;

		public Pokemon(int id, String name, int attack, int defense, int agility, int luck, double power) {
			super();
			this.id = id;
			this.attack = attack;
			this.defense = defense;
			this.agility = agility;
			this.luck = luck;
			this.name = name;
			this.power = power;
		}

		@Override
		public String toString() {
			return (id + " " + name + " " + (int) Math.round(power)).toString();
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
