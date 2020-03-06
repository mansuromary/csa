import java.util.Scanner;

public class Sequence {
	int[] arr;
	
	public boolean contains(int a) {
		for(int i=0;i<4;i++) {
			if(arr[i] == a) {
				return true;
			}
		}
		return false;
	}
	
	public Sequence(boolean a) {
		arr = new int[4];
		if(!a) {
			for(int i = 0;i<4;i++) {
				int r = (int)(Math.random()*(7-1)+1);
				while(contains(r) == true) {
					r = (int)(Math.random()*(7-1)+1);
				}
				arr[i] = r;
			}
		}
		if(a) {
			System.out.println("Type in four numbers to be put into the array");
			for(int i = 0;i<4;i++) {
				Scanner kb = new Scanner(System.in);
				arr[i] = kb.nextInt();
			}
		}
	}
	
	public int[] getSequence() {
		return arr;
	}
	
	public String toString() {
		return "" + arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3];
	}
}
