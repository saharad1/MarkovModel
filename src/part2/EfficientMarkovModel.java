package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Runs the markov in a more efficient and unique way.
 */
public class EfficientMarkovModel extends AbstractMarkovModel
{
    HashMap<String, ArrayList<String>> myMap = new HashMap<>();
    private int N;

    /**
     * The order of markov we would use.
     *
     * @param N - Markov's order.
     */
    public EfficientMarkovModel(int N) {
        myRandom = new Random();
        this.N=N;
        markov_num = N;
    }

    /**
     * Creates a map that keeps the data so it could be utilized and increase efficiency in terms of
     * number of calls used.
     */
    public void buildMap (){
        for (int i = 0; i<myText.length()-N; i++){
            String key = myText.substring(i, i + N);
            if(!myMap.containsKey(key)){
                int k=0;
                ArrayList<String> my_list = new ArrayList<>();
                while (myText.indexOf(key,k) != -1 && myText.indexOf(key,k)+key.length() <= myText.length()-1){
                    int index = myText.indexOf(key,k);
                    String mySub = myText.substring(index + key.length(), index + key.length()+1);
                    my_list.add(mySub);
                    k = index+1;
                }
                myMap.put(key, my_list);
            }
        }
    }

    /**
     * Finds the required list.
     *
     * @param key Word to look for.
     * @return The list of all combinations.
     */
    @Override
    public ArrayList<String> getFollows (String key){
        return myMap.get(key);
    }
    /**
     * Sets the Markov's order.
     * @param newN - The new N.
     */
    public void setN(int newN){
        this.N= newN;
    }

    /**
     * Prints the order of the Markov.
     *
     * @return The output which includes the Markov's order.
     */
    @Override
    public String toString(){
        return "EfficientMarkovModel of order " + markov_num;
    }

    /**
     * Generates random text
     *
     * @param numChars The number of chars to be printed.
     * @return The generated passage.
     */
    public String getRandomText(int numChars) {
        buildMap();
        if(N < numChars) {
            StringBuilder sb = new StringBuilder();
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
        else{
            return ("error");
        }
    }
}
