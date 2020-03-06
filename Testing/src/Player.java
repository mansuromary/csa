
public class Player {
	private String name;
	private String sport;
	private Team team;
	private int salary;
	
	public Player(String n, String s, Team t, int m) {
		name = n;
		sport = s;
		team = t;
		salary = m;
	}
	
	public String getName() {
		return name;
	}
	public String getSport() {
		return sport;
	}
	public Team getTeam() {
		return team;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int m) {
		salary = m;
	}
	public void setTeam(Team t) {
		team = t;
	}
	public void setSport(String s) {
		sport = s;
	}
	
	public int compareTo(Player p) {
		if(salary > p.salary) {
			return 1;
		}
		if(salary < p.salary) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return "Player name: " + name + " Sport: " + sport + " Team: " + team + " Salary: " + salary;
	}
}
