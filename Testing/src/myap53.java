
public class myap53 {
	public static void main(String[] args) {
		int[][] a = {{5,10,15,20},{25,30,35,40}};
		System.out.println(findZero(a));
	}
	public static boolean findZero(int[][] arr)	{
		for (int row = 0; row <= arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == 0) {
					return true;

				}

			}

		}
		return false;
	}
}
