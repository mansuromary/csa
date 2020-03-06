public class MoreMethods {
	public static void main(String[] args) {
		fiveOrMore("Homework");
		fiveOrMore("Six");
		twoAtATime("Happy");
		twoAtATime("School");
		System.out.println(equal2("duck","duck","goose"));
		System.out.println(equal2("duck","duck","duck"));
		System.out.println(equal2("duck","","goose"));
		System.out.println(inOrder("barn", "ball"));
		System.out.println(inOrder("ball", "barn"));
		System.out.println(inOrder("barn", "barn"));
	}
	
	public static void fiveOrMore(String s) {
		int len = s.length();
		if(len<5) {
			System.out.println(s);
		}
		else {
			for(int i =0;i<len;i++) {
				System.out.println(s.substring(i,i+1));
			}
		}
	}
	
	public static void twoAtATime(String s) {
		int len = s.length();
		if(len%2!=0) {
			System.out.println("I can't print 2 at a time.");
		}
		else {
			for(int i=0;i<len;i+=2) {
				System.out.println(s.substring(i,i+2));
			}
		}
	}
	
	public static boolean equal2(String s1,String s2,String s3) {
		if(s1.equals(s2)) {
			if(s1.equals(s3) || s2.equals(s3)) {
					return false;
			}
		}
		else if(s1.equals(s3)) {
			if(s1.equals(s2) || s2.equals(s3)) {
					return false;
			}
		}
		else if(s2.equals(s3)) {
			if(s1.equals(s3) || s2.equals(s3)) {
					return false;
			}
		}
		else {
			return false;
		}
		return true;
	}
	
	public static String inOrder(String a,String b) {
		if(a.compareTo(b)<0) {
			return a + "\t" + b;
		}
		return b + "\t" + a;
	}
}
