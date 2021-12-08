import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Node {
    private String name;
    private LinkedList < Edge > edgeList;

    public Node(String name) {
        this.name = name;
        edgeList = new LinkedList < > ();
    }

    public String getName() {
        return name;
    }

    public LinkedList < Edge > getEdges() {
        return edgeList;
    }



}

class Edge {
    private int weight;
    private Node destVertex;

    public Edge(Node dest, int w) {
        this.destVertex = dest;

    }

    public Edge(Node dest) {
        this.destVertex = dest;
        this.weight = 1;
    }

    public int getWeight() {
        return weight;
    }

    public Node getDestVertex() {
        return destVertex;
    }
}

class Graph {
    private HashSet < Node > nodes;

    public Graph() {
        nodes = new HashSet < > ();
    }

    public void AddEdge(Node v1, Node v2) {
        v1.getEdges().add(new Edge(v2));
        v2.getEdges().add(new Edge(v1));
    }

    public void AddVertex(Node v) {
        nodes.add(v);
    }

    public void printGraph() {
        for (Node v: nodes) {
            System.out.print("vertex name: " + v.getName() + ":\n");
            for (Edge e: v.getEdges()) {
                System.out.print("destVertex: " + e.getDestVertex().getName() + ", weight: " + e.getWeight() + "\n");
            }
            System.out.print("\n");
        }
    }
    boolean isconnected(Node v, Node w){
        for(Edge e:v.getEdges()){
            if(e.getDestVertex() == w){
                return true;
            }
        }
        return false;
    }



}

public class Undigraph {
    public static void main(String[] args) {
        Graph gr = new Graph();

        // nodes
        Node v0 = new Node("0");
        Node v1 = new Node("1");
        Node v2 = new Node("2");
        Node v3 = new Node("3");
        Node v4 = new Node("5");

        gr.AddVertex(v0);
        gr.AddVertex(v1);
        gr.AddVertex(v2);
        gr.AddVertex(v3);
        gr.AddVertex(v4);

        // edges
        gr.AddEdge(v0, v1);
        gr.AddEdge(v1, v2);
        gr.AddEdge(v2, v0);
        gr.AddEdge(v2, v3);
        gr.AddEdge(v3, v2);
        if(gr.isconnected(v4,v1)){
            System.out.println("True");
        } else {
            System.out.println("no");
        }


    }
}