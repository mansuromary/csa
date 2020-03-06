import java.util.ArrayList;

public class HW47 {
	public static void main(String[] args) {
		String[][] s = {{"a","c","b"}};
		int[] r = {1,5,5,4,3,1,2,2,2,2,6,1,3,3,5,5,5,5};
		int[] r2 = {1,2,2,3,3,3,4,5,6};
		int[] n = {2,4,5,2,3,4,6};
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("test");
		list.add("cab");
		System.out.println(sortDigits(4152));
		System.out.println(lastWord(s));
		System.out.println(consecutive3(n));
		System.out.println(howMany("t","testtesttest"));
		changeList(list,"ab");
		System.out.println(list);
		System.out.println(longestRun(r));
	}
	
	public static void addNumber(ArrayList<Integer> list, int a) {
		for(int i = 0; i<list.size();i++) {
            if(a<list.get(i)) {
            	list.add(i,a);
            	return;
            }
        }
        list.add(a);
	}
	
	public static ArrayList<Integer> sortDigits(int number){
		int num = number;
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(num!=0) {
			addNumber(a, num%10);
			num /= 10;
		}
		
		return a;
	}
	
	public static String lastWord(String[][] words) {
		String last = words[0][0];
		for(String[] i: words) {
			for(String w : i) {
				if(w.compareTo(last)>=0) {
					last = w;
				}
			}
		}
		return last;
	}
	
	public static boolean consecutive3(int[] nums) {
		boolean consecutive = false;
		for(int i = 0;i<nums.length-3;i++) {
			if(nums[i] + 1 == nums[i+1] && nums[i+1] + 1 == nums[i+2]) {
				consecutive = true;;
			}
		}
		return consecutive;
	}
	
	public static int howMany(String s,String str) {
		String a = str;
		int c = 0;
		while(a.contains(s)) {
			c++;
			int start = a.indexOf(s);
			a = a.substring(start+s.length());
		}
		return c;
	}
	
	public static void changeList(ArrayList<String>a,String s) {
		for(int i = a.size()-1;i>=0;i--) {
			if(a.get(i).substring(0,s.length()).equals(s) || a.get(i).substring(a.get(i).length()-s.length()).equals(s)) {
				a.remove(i);
			}
		}
	}
	
	public static int longestRun(int[] a) {
		int c = 1;
		int run = a[0];
		int maxRun = 1;
		int pos = -1;
		for(int i = 1;i<a.length;i++) {
			if(run == a[i]) {
				c++;
			}
			else {
				if(c>maxRun) {
					maxRun = c;
					pos = i-c;
				}
				run = a[i];
				c=1;
			}
		}
		return pos;
	}
}
