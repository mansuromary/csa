
public class Team {
	private String name;
	private int wins;
	private int losses;
	private String sport;

	public Team(String n, String s){
		name = n;
		sport = s;
		wins = 0;
		losses = 0;
	}

	public void addAnotherWin(){
		wins++;
	}
	public void addAnotherLoss(){
		losses++;
	}
	public void setWins(int s) {
		wins = s;
	}
	public void setLosses(int l) {
		losses = l;
	}

	public int getNumWins(){
		return wins;
	}
	public int getNumLosses(){
		return losses;
	}
	public String getName(){
		return name;
	}
	public void resetWinsAndLosses(){
		wins = 0;
		losses = 0;
	}
	public int getPercentOfGamesWon(){
		return wins/losses*100;
	}
	public boolean equals(Team t){
		if(t.getPercentOfGamesWon() == getPercentOfGamesWon()) {
			return true;
		}
		return false;
	}
	public int compareTo(Team t){
		if(getPercentOfGamesWon() > t.getPercentOfGamesWon()) {
			return 1;
		}
		if(getPercentOfGamesWon() < t.getPercentOfGamesWon()) {
			return -1;
		}
		return 0;
	}
	public String toString(){
		return "Team: " + name + "Sport: " +  sport + " Wins: " + wins + " Losses: " + losses;
	}
}