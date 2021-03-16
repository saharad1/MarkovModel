package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Markov by order one.
 */
public class MarkovOne extends AbstractMarkovModel {

    /**
     * The order of markov we would use.
     */
    public MarkovOne() {
        myRandom = new Random();
        markov_num = 1;
    }

    /**
     * Generates random text
     *
     * @param numChars The number of chars to be printed.
     * @return The generated passage.
     */
    public String getRandomText(int numChars) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);

        for(int k=0; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        return sb.toString();
    }


}