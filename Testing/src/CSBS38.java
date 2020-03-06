import java.util.ArrayList;

public class CSBS38 {
	public static void main(String[] args) {
//		ArrayList<String> test = new ArrayList<String>();
//		test.add("the");
//		test.add("computer");
//		test.add("ruled");
//		test.add("everyone");
//		test.add(1,"x");
//		test.add(1,"y");
//		makeList2(test);
//		System.out.println(test);
		int[] a1 = {2,999,999,4,6,999,1,999,8,999};
		int[] a2 = {999};
		banish(a1,a2);
		for(int i = 0;i<a1.length;i++) {
			System.out.print(a1[i] + ", ");
		}
	}
	public static void makeList2(ArrayList<String> s){
	    int size = s.size();
	    int pos = 0;
	    int increment = 0;
	    for(int i = 0;i<size;i++){
	        for(int j = 0;j<i;j++){
	            s.add(pos,s.get(pos));
	        }
	        increment ++;
	        pos+=increment;
	    }

	}
	
	public static void banish(int[] a1, int[] a2) {
		for(int i = 0;i<a2.length;i++) {
			 for(int j = 0;j<a1.length;j++) {
				 if(a1[j] == a2[i]) {
					 for(int k = j;k<a1.length-1;k++) {
						 a1[k] = a1[k+1];
						 a1[a1.length-1] = 0;
					 }
					 j--;
				 }
			 }
		}
	}
}
