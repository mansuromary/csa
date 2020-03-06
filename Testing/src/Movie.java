
public class Movie {
	private String name,features;
	public Movie(String n, String f){
	name=n;
	features=f;
	}
	public String getName(){return name;}
	public double getMatchCoeff(Movie other){
		double c = 0;
		for(int i = 0;i<this.features.length();i=i+3) {
			String feat = this.features.substring(i,i+3);
			if(other.features.contains(feat)) {c++;}
		}
		return c / (this.features.length()/3);
	}
}
