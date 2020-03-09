/* College Board Lab modified for rm 419*/
import java.awt.Color;
public class Steganography1{

  
  /**
   * Clear the lower (rightmost) two bits in each byte of a pixel.  Each pixel is made up of 3 bytes--one for red, one for blue, and one for green.
   * Set the last two bits of each of these bytes to 0.
   * @param p pixel to be changed
   */
  public static void clearLow(Pixel p) {
	  p.setRed(p.getRed()/4*4);
	  p.setGreen(p.getGreen()/4*4);
	  p.setBlue(p.getBlue()/4*4);
  }
  
 
  /**
   * Set the lower 2 bits of each byte in a pixel to the highest 2 bits of each byte in c
   * @param p pixel to be changed
   * @param c color to be used for modification
   */
  public static void setLow(Pixel p, Color c) {
	  clearLow(p);
	  p.setRed(p.getRed()+(c.getRed()/64));
	  p.setGreen(p.getGreen()+(c.getGreen()/64));
	  p.setBlue(p.getBlue()+(c.getBlue()/64));
  }
  
  /**
    Sets the first two bits of each byte in a Pixel to the last two bits of the byte. 
    Sets the other six bits in each byte to 0. 
  **/
    
  public static void moveLowToHigh(Pixel p) {
	  int r = p.getRed()%4;
	  p.setRed(r*64);
	  int g = p.getGreen()%4;
	  p.setGreen(g*64);
	  int b = p.getBlue()%4;
	  p.setBlue(b*64);
  }
  
  /**
   * Creates a Picture by setting the highest two bits of each pixel's colors
   * to the lowest two bits of each pixel's colors. 
   * The rest of the bits are turned off--they are 0.
   * 
   * @param pic picture with hidden image
   * @return revealed picture
   * 
   */
  public static Picture revealPicture(Picture pic) {
	  Picture p = new Picture(pic);
	  Pixel[][] pixels = p.getPixels2D();
	  for(Pixel[] row: pixels) {
		  for(Pixel pi : row) {
			  moveLowToHigh(pi);
		  }
	  }
	  return p;
  }
  

  /**
   * Determines whether secret can be hidden in source, which is
   * true if the secret will fit inside of source.
   * @param source is not null
   * @param secret is not null
   * @return true if secret can be hidden in source, false otherwise.
   */
  public static boolean canHide(Picture source, Picture secret) {
	  Pixel[][] st = secret.getPixels2D();
	  Pixel[][] s = source.getPixels2D();
	  if(st.length <= s.length && st[0].length <= s[0].length) {
		  return true;
	  }
	  return false;
  }
  

  

  /**
   * Creates a new Picture with data from secret hidden in data from source
   * @param source is not null
   * @param secret is not null
   * @return combined Picture with secret hidden in source
   * precondition: source is same width and height as secret
   */
  public static Picture hidePicture(Picture source, Picture secret) {
	  Picture copy = new Picture(source);
	  Pixel[][] sourceP = copy.getPixels2D();
	  Pixel[][] secretP = secret.getPixels2D();
	  for(int r=0;r<sourceP.length;r++) {
		  for(int c=0;c<sourceP[0].length;c++) {
			  setLow(sourceP[r][c],secretP[r][c].getColor());
		  }
	  }
	  return copy;
  }
   
  
  public static void main(String[] args) {
  
	  Picture beach = new Picture("butterfly1.jpg");
	  
	  /* Check that your clearLow method works correctly. */
	  Pixel pix =new Pixel(beach, 20,30);
	  System.out.println(pix.getColor()); // output java.awt.Color[r=178,g=176,b=179]
	  clearLow(pix);
	  System.out.println(pix.getColor()); //output java.awt.Color[r=176,g=176,b=176]
	  
	  /* Check that your setLow method works correctly. */
	  pix.setColor(new Color(25,100,200));
	  setLow(pix, new Color(255,100,130));
	  System.out.println(pix.getColor()); //output java.awt.Color[r=27,g=101,b=202]
	  
	  
	  /**Check that canHide works properly. **/
	    Picture swan = new Picture("swan.jpg");
	    //swan.explore();
	    Picture gorge = new Picture("gorge.jpg");
	    gorge.explore();
	    System.out.println(canHide(swan, gorge)); //output true;
	    System.out.println(canHide(beach, gorge)); //output false
	    
	    if(canHide(swan, gorge)) {
	      Picture combined1 = hidePicture(swan, gorge);
	      combined1.explore();
	      Picture revealed = revealPicture(combined1);
	      revealed.explore();
	    
	    }
  }
}
