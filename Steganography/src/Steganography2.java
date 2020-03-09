
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Steganography class for Activity 4
 * modified for rm 419
 *
 * Only the additional methods are included in this class.
 */
public class Steganography2 {

    /**
      * Takes a string consisting of capital letters and spaces and
      * encodes the string into an arraylist of integers.
      * The integers are 1-26 for A-Z, and 27 for space.
	* The last element in the list MUST BE 0
      * The arraylist of integers is returned.
      * @param s string consisting of capital letters and spaces
      * @return arraylist containing integer encoding of s
      */
     public static ArrayList<Integer> encodeString(String s) {
    	 ArrayList<Integer> intList = new ArrayList<Integer>();
         String str = "/ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
         for (int i = 0; i < s.length(); i++) {
        	 intList.add(str.indexOf(s.substring(i, i + 1)));
         }
         intList.add(0);
         return intList;
     }
     
     /**
       * Returns the string represented by the codes arraylist.
       * 1-26 = A-Z, 27 = space (Integers in [1,27])
       * @param codes encoded string
       * @return decoded string
       */

     public static String decodeString(ArrayList<Integer> codes) {
    	 String str = "/ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
         String s = "";
         for (int i: codes) {
             s += str.substring(i,i+1);
         }
         return s;
     }
     
     /**
       * Given a number from 0 to 63, creates and returns an
       * int array of 3 ints consisting of the integers
       * representing the pairs of bits in the number from right to left.

Any number from 0-63 can be represented with 6 bits.  Each element in the array represents the integer value of a pair of bits.  Here is an example:
     num = 30  which is 011110 in binary.  
     01= 1, 11=3, 10=2  so the array would be {1,3,2}

       * @param num number to be broken up
       * @return bit pairs in number
       */
     private static int[] getBitPairs(int num) {
    	 int[] pairs = new int[3];
    	 pairs[0] = num/16;
    	 pairs[1] = num/4%4;
    	 pairs[2] = num%4;
    	 return pairs;
     }

/**Sets the two lowest bits of each byte in p to the corresponding int in arr.
     * The first value in the array is used in the red byte, 
     * second value is used in the green byte, and the third
     * value is used in the blue byte.
     * @param p isn't null
     * @param arr is an array of 3 elements. 
     */
    public static void setLow(Pixel p, int[] arr) {
    	Steganography1.clearLow(p);
    	p.setRed(p.getRed()+arr[0]);
    	p.setGreen(p.getGreen()+arr[1]);
    	p.setBlue(p.getBlue()+arr[2]);
    }




    /*Calculates and returns the integer hidden in the p.  The
     * last two bits of each color byte in p hold part of a six bit number.
     * The highest two bits are in red, the middle bits are in green, and
     * the lowest bits are in blue.
     */
    public static int calcValue(Pixel p) {
    	int sum = 0;
    	int[] bits = new int[3];
    	bits[0] = p.getRed()%4;
    	bits[1] = p.getGreen()%4;
    	bits[2] =  p.getBlue()%4;
    	sum += bits[0]*16 + bits[1]*4 + bits[2]*1;
    	return sum;
    }
    /**
     * Hide a string (must be only capital letters and spaces) in a
     * picture.
     * The string always starts in the upper left corner.
     * @param source picture to hide string in
     * @param s string to hide
     * @return pic with hidden string
     */
    public static Picture hideText(Picture source, String s) {
    	Picture copy = new Picture(source);
        Pixel[][] p = copy.getPixels2D();
        ArrayList<Integer> str = encodeString(s);
        int pos = 0;
        for (Pixel[] r : p) {
        	for (Pixel c : r) {
                if (pos < str.size()) {
                    int[] arr = getBitPairs(str.get(pos));
                    setLow(c, arr);
                    pos++;
                }
            }
        }
        return copy;
    }
    
    /**
      * Returns a string hidden in the picture
      * @param source picture with hidden string
      * @return revealed string
      */

    public static String revealText(Picture source) {
        Picture copy = new Picture(source);
        Pixel[][] p = copy.getPixels2D();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0;i < p.length;i++) {
        	for (int j = 0;i < p[0].length;j++) {
                int a = calcValue(p[i][j]);
                if (a == 0) {
                	return decodeString(intList);
                }
                else {
                	intList.add(a);
                }
            }
        }
        return decodeString(intList);
    }

    public static void main(String[] args) {
       //Activity 4.4 
       Picture beach = new Picture("beach.jpg");
       beach.explore();
       Picture hiddenText = hideText(beach,"THIS IS A TEST");
       hiddenText.explore();
       String reveal = revealText(hiddenText);
       if(reveal.equals("THIS IS A TEST"))
       {
           System.out.println("It worked!");
       }
       else 
       {
           System.out.println("Something went wrong!");
       }
    }
}
