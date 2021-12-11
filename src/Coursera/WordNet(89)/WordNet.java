import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordNet {
    private SAP sap;
    private Digraph digraph;
    private Map<Integer, String> synsets = new HashMap<>();
    private Map<String, Set<Integer>> getid = new HashMap<>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        check(synsets, hypernyms);
        In insynsets = new In(synsets);
        while (!insynsets.isEmpty()) {
            String[] line = insynsets.readLine().split(",");
            int id = Integer.parseInt(line[0]);
            String[] nounset = line[1].split(" ");
            String noun = line[1];
            this.synsets.put(id, noun);
            for (String n : nounset) {
                Set<Integer> ids = getid.get(n);
                if (ids == null) {
                    ids = new HashSet<>();
                }
                ids.add(id);
                this.getid.put(n, ids);

            }

        }
        insynsets.close();
        digraph = new Digraph(this.synsets.size());
        boolean[] notroot = new boolean[this.synsets.size()];
        In inhypernyms = new In(hypernyms);
        while (!inhypernyms.isEmpty()) {
            String[] line = inhypernyms.readLine().split(",");
            int synset = Integer.parseInt(line[0]);
            notroot[synset] = true;
            for (int i = 1; i < line.length; i++) {
                digraph.addEdge(synset, Integer.parseInt(line[i]));
            }
        }
        inhypernyms.close();
        DirectedCycle dc = new DirectedCycle(digraph);
        if (dc.hasCycle()) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (boolean root : notroot) {
            if (!root) {
                count++;
            }
        }
        if (count > 1) {
            throw new IllegalArgumentException();
        }
        sap = new SAP(digraph);
    }

    // do unit testing of this class
    public static void main(String[] args) {
    }

    private void check(String a, String b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }


    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return getid.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (getid.containsKey(word)) {
            return true;
        }
        return false;
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null) {
            throw new IllegalArgumentException();
        }
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        SAP sap = new SAP(digraph);
        return sap.length(getid.get(nounA), getid.get(nounB));

    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null) {
            throw new IllegalArgumentException();
        }
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        SAP sap = new SAP(digraph);
        int ancestor = sap.ancestor(getid.get(nounA), getid.get(nounB));
        return synsets.get(ancestor);
    }
}