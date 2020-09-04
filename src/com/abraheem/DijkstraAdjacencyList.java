package com.abraheem;

import java.util.*;

public class DijkstraAdjacencyList {
    private final int vertices; // Number of vertices
    private final LinkedList<Node>[] adj; // Adjacency List
    private Set<Integer> visited;
    PriorityQueue<Node> pQueue;
    int dist[];

    public DijkstraAdjacencyList(int numOfVertices) {
        vertices = numOfVertices;
        dist = new int[numOfVertices];
        visited = new HashSet<Integer>();
        pQueue = new PriorityQueue<Node>(numOfVertices, new Node());

        adj = new LinkedList[numOfVertices];
        for(int i=0; i<numOfVertices; ++i){
            adj[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int vSrc, int vDst){
        //adj[vSrc].add(vDst);
    }

    public List<Node> shortestPath(){


        return null;
    }
}

class Node implements Comparator<Node> {
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