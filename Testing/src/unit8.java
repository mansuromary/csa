
public class unit8 {
	public static void main(String[] args) {
		int[][] mat = {{10, 15, 20, 25},{30, 35, 40, 45},{50, 55, 60, 65}};
		for (int[] row : mat) {
			for (int j = 0; j < row.length; j += 2) {
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
	}
}
