package part1;
import java.util.Random;
/**
 * Markov by order zero.
 */
public class MarkovZero {
    private String myText;
	private Random myRandom;
	/**
	 * The order of markov we would use.
	 */
	public MarkovZero() {
		myRandom = new Random();
	}
	/**
	 * Set a different seed for the random sequences.
	 *
	 * @param seed The num for the random.
	 */
	public void setSeed(int seed){
		myRandom = new Random(seed);
	}
	/**
	 * A string whose value is this string, with any leading and trailing white
	 * space removed, or this string if it has no leading or
	 * trailing white space.
	 *
	 * @param s The given string.
	 */
	public void setTraining(String s){
		myText = s.trim();
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