
public class HW19 {
	public static int[] collapsePairs(int[] a){
	    int[] arr = new int[a.length];
	    int c = 0;
	    for(int i = 0;i<a.length-1;i+=2){
	        if((a[i]+a[i+1])%2 == 0){
	            arr[c] = a[i]+a[i+1];
	            c+=2;
	        }
	        else{
	            arr[c+1] = a[i]+a[i+1];
	            c++;
	        }
	    }
	    return arr;
	}
	public static void main(String[] args) {
		int[] test = {0,0,-1,-1,-1,5,5,5,0,0};
		int[] p = collapsePairs(test);
		for(int i = 0;i<p.length;i++) {
			System.out.println(p[i]);
		}
	}
}
