
public class MagicSquare{
	public static boolean checkRows(int[][] square) {
		int sum1 = 0;
		int sum2 = 0;
		for(int c = 0;c<square[0].length;c++) {
			sum1+=square[0][c];
		}
		for(int r = 1;r<square.length;r++) {
			for(int c = 0;c<square[0].length;c++) {
				sum2 += square[r][c];
			}
			if(sum2!=sum1) {return false;}
			sum2 = 0;
		}
		return true;
	}
	public static boolean checkCols(int[][] square) {
		int sum1 = 0;
		int sum2 = 0;
		for(int r = 0;r<square.length;r++) {
			sum1+=square[r][0];
		}
		for(int c = 1;c<square[0].length;c++) {
			for(int r = 0;r<square.length;r++) {
				sum2+=square[r][c];
			}
			if(sum2!=sum1) {return false;}
			sum2 = 0;
		}
		return true;
	}
//	public static boolean checkDiagonals(int[][] square) {
//		for(int r = 0;r<square.length;r++) {
//			for(int c = 0;c<square[0].length;c++) {
//				
//			}
//		}
//	}
}
