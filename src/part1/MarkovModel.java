package part1;

import java.util.ArrayList;
import java.util.Random;
/**
 * Creates the markov model by the given number.
 */
public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int N;
    /**
     * The order of markov we would use.
     *
     * @param N - Markov's order.
     */
    public MarkovModel(int N) {

        myRandom = new Random();
        this.N=N;
    }
    /**
     * Sets the Markov's order.
     *
     * @param newN - The new N.
     */
    public void setN(int newN){
        this.N= newN;
    }
    /**
     * Set a different seed for the random sequences.
     *
     * @param seed The num for the random.
     */
    public void setSeed(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }
    /**
     * Generates random text
     *
     * @param numChars The number of chars to be printed.
     * @return The generated passage.
     */
    public String getRandomText(int numChars) {
        StringBuilder sb = new StringBuilder();
        if(N < numChars) {
            int index = myRandom.nextInt(myText.length() - N);
            String key = myText.substring(index, index + N);
            sb.append(key);

            for (int k = 0; k < numChars - N; k++) {
                ArrayList<String> follows = getFollows(key);
                if (follows.size() == 0) {
                    break;
                }
                index = myRandom.nextInt(follows.size());
                String next = follows.get(index);
                sb.append(next);
                key = key.substring(1) + next;
            }

            return sb.toString();
        }
        else
            return ("error");

    }
    /**
     * Takes all the following chars based on the key given.
     *
     * @param key Which is the base for iterating over the text and finding all the characters which stand
     *            right after its.
     * @return Arraylist which contains these chars.
     */
    public ArrayList<String> getFollows (String key){
        int i=0;
        ArrayList<String> my_list = new ArrayList<>();
        while (myText.indexOf(key,i) != -1 && myText.indexOf(key,i)+key.length() <= myText.length()-1){
            int index = myText.indexOf(key,i);
            String mySub = myText.substring(index + key.length(), index + key.length()+1);
            my_list.add(mySub);
            i = index +1;
        }
        return my_list;
    }
}