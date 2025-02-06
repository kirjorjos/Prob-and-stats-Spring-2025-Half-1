package Pokemon;

public class TestPokemon {
	
	public static void main(String[] args) {
		Charmander charmanderSteve = new Charmander();
		
		charmanderSteve.getHp();
		
		Stadium tester = new Stadium();
		
		Pikachu ummhmm = new Pikachu();
		
		Pokemon winner = tester.battle(charmanderSteve, ummhmm);
		
		System.out.println("This winner is:");
		if (winner.equals(charmanderSteve)) {
			System.out.println("Charmander");
		} else {
			System.out.println("Pikachu");
		}
	}
}
