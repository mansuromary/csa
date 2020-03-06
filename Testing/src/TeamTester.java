
public class TeamTester {
	public static void main(String[] args) {
		Team Dolphins = new Team("Dolphins","football");
		Team Cowboys = new Team("Cowboys", "football");
		Player p1 = new Player("Dan Marino", "football", Dolphins, 10000000);
		Player p2 = new Player("Ryan Tannehill", "football", Dolphins, 10000000);
		Player p3 = new Player("Tony Ramo", "football", Cowboys, 10000000);
		
		Dolphins.setWins(2);
		Dolphins.setLosses(2);
		Cowboys.setWins(4);
		Cowboys.setLosses(1);
		
		System.out.println("Perecent Of Wins for Dolphins: " + Dolphins.getPercentOfGamesWon());
		System.out.println("Perecent Of Wins for Cowboys: " + Cowboys.getPercentOfGamesWon());
		
		Dolphins.resetWinsAndLosses();
		System.out.println(Dolphins);
		
		System.out.println(p1);
		System.out.println(p2);
		
		p2.setSalary(20000000);
		
		p3.compareTo(p1);
	}
}
