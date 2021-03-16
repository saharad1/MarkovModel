package part2;

import java.util.*;

/**
 * The class is used for as a super class for the other Markovs.
 */
public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int markov_num ;

    /**
     * Creates the object and declares random.
     */
    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    /**
     * A string whose value is this string, with any leading and trailing white
     * space removed, or this string if it has no leading or
     * trailing white space.
     *
     * @param s The given string.
     */
    final public void setTraining(String s) {
        myText = s.trim();
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
     * Generate passages from the text
     *
     * @param numChars The number of chars to be printed.
     */
    abstract public String getRandomText(int numChars);

    /**
     * Creating a printing format to the markov's objects.
     * @return Fixed format for printing.
     */
    @Override
    public String toString(){
        return "MarkovModel of order " + markov_num;
    }

    /**
     * Takes all the following chars based on the key given.
     * @param key Which is the base for iterating over the text and finding all the characters which stand
     *            right after its.
     * @return Arraylist which contains these chars.
     */
    protected ArrayList<String> getFollows (String key){
        int i=0;
        ArrayList<String> my_list = new ArrayList<>();
        while (myText.indexOf(key,i) != -1 && myText.indexOf(key,i)+key.length() <= myText.length()-1){
            int index = myText.indexOf(key,i);
            String mySub = myText.substring(index + key.length(), index + key.length()+1);
            my_list.add(mySub);
            i = index+1;
        }
        return my_list;
    }
}
