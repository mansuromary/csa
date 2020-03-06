import java.util.ArrayList;

public class ETheater {
	public static double[] getFitCoefficients(ArrayList<Movie> movies){
		double sum = 0;
		double[] list = new double[movies.size()];
		for(int i = 0;i<movies.size();i++) {
			sum=0;
			for(int j = 0;j<movies.size();j++) {
				if(movies.get(i)!= movies.get(j)) {
					sum += movies.get(i).getMatchCoeff(movies.get(j));
				}
			}
			list[i] = sum/movies.size();
			//prints each value for testing
			System.out.println(movies.get(i).getName() + " " + list[i]);
		}
		return list;
	}
	public static void removeOutliers(ArrayList<Movie> movies){
		double[] list = getFitCoefficients(movies);
		double sum = 0;
		for(int i = 0;i<movies.size();i++) {
			sum = sum + list[i];
		}
		double avg = sum/list.length;
		//prints the avg for testing
		System.out.println(avg/2);
		for(int i = list.length-1;i>=0;i--) {
			if(list[i]<avg/2) {
				movies.remove(i);
			}
		}
	}
}
