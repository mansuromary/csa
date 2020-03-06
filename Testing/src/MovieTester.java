import java.util.ArrayList;

public class MovieTester {
	public static void main(String[] args) {
		Movie aquaMan = new Movie("Aquaman","ADVKIDFAM_**");
		Movie blackPanther = new Movie("Black Panther","ADVADLNOT_**");
		Movie incredibles = new Movie("Incredibles 2","ANIKIDFAM_**");
		
		System.out.println(aquaMan.getMatchCoeff(blackPanther));
		System.out.println(aquaMan.getMatchCoeff(incredibles));
		System.out.println(blackPanther.getMatchCoeff(incredibles));
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(aquaMan);
		list.add(blackPanther);
		list.add(incredibles);
		list.add(new Movie("The Grinch","ANIKIDFAM_**"));
		list.add(new Movie("Bohemian Rhapsody","MUSADLNOT***"));
		list.add(new Movie("Mary Poppins","FANEVEFAM__*"));
		list.add(new Movie("Ralph Breaks the Internet","ANIKIDFAM_**"));
		list.add(new Movie("Small Foot","ANIKIDFAM___"));
		
		ETheater.removeOutliers(list);
		for(Movie m: list)
			System.out.println(m.getName());
	}
}
