
public class CircleTester {
	public static void main(String[] args) {
		Circle littleC = new Circle(2);
		System.out.println("There is " + Circle.getNumCircles() + " circle(s).");
		Circle bigC = new Circle(10);
		System.out.println("There is " + Circle.getNumCircles() + " circle(s).");
		System.out.println("The area of littleC is " + littleC.getArea());
		System.out.println("The circumference of littleC is " + littleC.getCircumference());
		System.out.println("The diameter of bigC is " + bigC.getDiameter());
		System.out.println("The radius of bigC is " + bigC.getRadis());
		System.out.println(bigC);
	}
}
