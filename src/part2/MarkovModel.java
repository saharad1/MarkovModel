package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Creates the markov model by the given number.
 */
public class MarkovModel extends AbstractMarkovModel {
    private int N;

    /**
     * The order of markov we would use.
     *
     * @param N - Markov's order.
     */
    public MarkovModel(int N) {

        myRandom = new Random();
        this.N=N;
        markov_num = N;
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

}