package part2;

/**
 * The interface of the AbstractMarkovModel.
 */
public interface IMarkovModel {
    /**
     * A string whose value is this string, with any leading and trailing white
     * space removed, or this string if it has no leading or
     * trailing white space.
     * @param text The given string.
     */
    public void setTraining(String text);

    /**
     * Generates random text
     * @param numChars The number of chars to be printed.
     */
    public String getRandomText(int numChars);

    /**
     * Set a different seed for the random sequences.
     * @param seed The num for the random.
     */
    public void setSeed(int seed);
    
}
