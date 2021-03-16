package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Markov by order four.
 */
public class MarkovFour extends AbstractMarkovModel {

    /**
     * The order of markov we would use in this case four.
     */
    public MarkovFour() {
        myRandom = new Random();
        markov_num=4;
    }
    /**
     * Generates random text
     *
     * @param numChars The number of chars to be printed.
     * @return The generated passage.
     */
    public String getRandomText(int numChars) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index, index+4);
        sb.append(key);

        for(int k=0; k < numChars-4; k++){
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

}