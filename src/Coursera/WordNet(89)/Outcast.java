import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private WordNet wordnet;

    public Outcast(WordNet wordnet)   // constructor takes a WordNet object
    {
        this.wordnet = wordnet;
    }


    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
    // see test client below

    public String outcast(String[] nouns) {
        int longest = Integer.MAX_VALUE;
        String oc = "";
        for (int i = 0; i < nouns.length; i++)
            for (int j = i + 1; j < nouns.length; j++) {
                int distance = wordnet.distance(nouns[i], nouns[j]);
                if (distance > longest) {
                    longest = distance;
                    oc = nouns[j];
                }
            }
        return oc;
    }  // given an array of WordNet nouns, return an outcast
}