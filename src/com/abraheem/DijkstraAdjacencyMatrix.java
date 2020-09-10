package com.abraheem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAdjacencyMatrix {
    private final int vertices; // Number of vertices
    private int[][] adj; // Adjacency List
    private Set<Integer> visited;
    PriorityQueue<Integer> pQueue;
    int[] dist;

    public DijkstraAdjacencyMatrix(int numOfVertices) {
        vertices = numOfVertices;
        dist = new int[numOfVertices];
        visited = new HashSet<Integer>();
        pQueue = new PriorityQueue<Integer>(numOfVertices);
        adj = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int vSrc, int vDst, int weight){
        adj[vSrc][vDst] = weight;
    }

    public int[] shortestPath(int start){
        // All nodes start with dist = infinity from start node
        for(int i=0; i<vertices; ++i)
            dist[i] = Integer.MAX_VALUE;

        // Add start node to priority queue.
        // Weight starts as 0
        pQueue.add(start);
        dist[start] = 0;

        // Loop until all vertices are visited
        while (!pQueue.isEmpty()){
            // Remove the min distance node from priority queue
            int minVal = pQueue.poll();
            // Mark node as visited
            visited.add(minVal);
            // Now process all neighbor nodes from current node
            shortestPathHelper(minVal);
        }
        return dist;
    }

    private void shortestPathHelper(int current){
        //int edgeDist = -1;
        int newDist = -1;
        int len = adj[current].length;

        // Traverse all neighbors of current
        for(int i=0; i<len; ++i){
            int cost = adj[current][i];
            // If current node is not visited
            if(!visited.contains(current)){
                newDist = dist[current] + cost;
                // If new distance is lower in cost,
                // make it current distance
                if(newDist < dist[current]) {
                    dist[current] = newDist;
                    // Finally, add current node to priority queue
                    pQueue.add(current);
                }
            }
        }
    }
}
