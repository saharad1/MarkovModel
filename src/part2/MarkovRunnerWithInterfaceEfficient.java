package part2;

import util.SEFileUtil;

/**
 * The class is use to generate random text with greater efficiency.
 *
 */
public class MarkovRunnerWithInterfaceEfficient {
    /**
     * Generates the passages
     *
     * @param markov object which is implemented from the interface.
     * @param text the text that we use for the program.
     * @param size num of chars.
     * @param seed generates random sequences.
     */
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setSeed(seed);
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }

    /**
     * Prints the required output.
     *
     * @param s Passage to print.
     */
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    /**
     * Creates the required environment to run the model.
     *
     * @param trainingFilePath path of the file
     * @param seed generates random sequences.
     */
    public void testHashMap(String trainingFilePath, int seed){
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        EfficientMarkovModel emFive = new EfficientMarkovModel(5);
        runModel(emFive, st, size, seed);
    }


    public static void main (String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Please pass two arguments: 1.input_file 2.seed");
            System.exit(1);
        }
        MarkovRunnerWithInterfaceEfficient markov = new MarkovRunnerWithInterfaceEfficient();
        try {
            markov.testHashMap(args[0], Integer.parseInt(args[1]));
        }
        catch (Exception NumberFormatException) {
            System.out.println("The second argument must be an integer");
            System.exit(1);
        }
    }

}
