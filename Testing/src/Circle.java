
public class Circle {
	private double radius;
	private static int numCircles;
	
	public Circle(double r){
		radius = r;
		numCircles++;
	}
	
	public double getRadis() {
		return radius;
	}
	public double getDiameter() {
		return radius*2;
	}
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public double getCircumference() {
		return 2*Math.PI*radius;
	}
	public static int getNumCircles() {
		return numCircles;
	}
	
	public String toString() {
		return "I am a circle with a radius of " + radius;
	}
}
