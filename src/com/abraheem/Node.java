package com.abraheem;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    public int node;
    public int cost;
    public boolean visited;
    public Node predecessor;

    public Node(){}

    public Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        // returns -1 if node1.cost<node2.cost
        // returns 1 if node1.cost>node2.cost
        // returns 0 if they are equal
        return Integer.compare(node1.cost, node2.cost);
    }
}
