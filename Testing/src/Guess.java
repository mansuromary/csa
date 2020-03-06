
public class Guess extends Sequence{
	static int guesses = 0;
	
	public Guess() {
		super(true);
		guesses++;
	}
	
	public String toString() {
		return "Guess: 2 3 4 5";
	}
	
	public static int numOfGuesses() {
		return guesses;
	}
}
