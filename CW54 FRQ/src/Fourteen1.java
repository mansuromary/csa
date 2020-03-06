import java.util.ArrayList;
import java.util.List;

public class Fourteen1 {
	public static String scrambleWord(String word){
		String result = "";
		boolean canScramble = true;
		if(word.length()<2) {
			canScramble = false;
		}
		if(canScramble) {
			for(int i = 0;i<word.length()-1;i++) {
				if(word.substring(i,i+1).equals("A") && !word.substring(i+1,i+2).equals("A")){
					result+=word.substring(i+1,i+2)+word.substring(i,i+1);
					i++;
					if(i+1==word.length()-1) {
						result+=word.substring(i+1,i+2);
					}
				}
				else {
					result+=word.substring(i,i+1);
					if(i+1==word.length()-1) {
						result+=word.substring(i+1,i+2);
					}
				}
			}
		}
		else {
			return word;
		}
		return result;
	}
	public static void scrambleOrRemove(List<String> wordList){
		for(int i = wordList.size()-1;i>=0;i--) {
			if(scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
				wordList.remove(i);
			}
			else {
				wordList.set(i, scrambleWord(wordList.get(i)));
			}
		}
	}
	public static void main(String[] args){
		
		String[] testCases = {"TAN", "ABRACADBRA", "WHOA","AARDVARK","EGGS","A",""};
		//USE A FOR EACH LOOP TO TEST YOUR CODE...
		ArrayList<String> a = new ArrayList<String>();
		//USE A FOR EACH LOOP TO LOOP THROUGH THE ARRAY AND ADD THE ELEMENTS TO a
		for(String s:testCases){
			a.add(s);
		}
		//WRITE THE LINE OF CODE THAT WILL REMOVE ANY WORDS THAT DON'T SCRAMBLE AS
		//DESCRIBED IN THE QUESTION
		//
		scrambleOrRemove(a);
		System.out.println(a); //EXPECTED OUTPUT: [TNA, BARCADABRA, ARADVRAK]
	}
}
