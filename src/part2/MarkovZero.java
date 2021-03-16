package part2;
import java.util.Random;

/**
 * Markov by order zero.
 */
public class MarkovZero extends AbstractMarkovModel {
	/**
	 * The order of markov we would use.
	 */
	public MarkovZero() {
		myRandom = new Random();
		markov_num = 0;
	}
	/**
	 * Generates random text
	 *
	 * @param numChars The number of chars to be printed.
	 * @return The generated passage.
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));

		}
		
		return sb.toString();
	}
}