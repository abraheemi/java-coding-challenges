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

    private int minDist(){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i=0; i<vertices; ++i){
            if(!visited.contains(i) && dist[i] <= min){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int[] shortestPath(int start){
        // All nodes start with dist = infinity from start node
        for(int i=0; i<vertices; ++i)
            dist[i] = Integer.MAX_VALUE;

        // Add start node to priority queue.
        // Weight starts as 0
        //pQueue.add(start);
        dist[start] = 0;

        // Traverse all vertices
        for(int j=0; j<vertices; ++j) {

            int md = minDist();
            visited.add(md);
            // Update dist value of adjacent vertices
            for (int i = 0; i < vertices; ++i) {

                // Update dist[] only if:
                // 1. current node is not visited
                // 2. matrix position is not empty (0)
                // 3. current distance is not Infinite (not reachable)
                // 4. i through md is smaller than current value of dist[i]
                int cost = adj[md][i];
                if (!visited.contains(i) &&
                        cost != 0 &&
                        dist[md] != Integer.MAX_VALUE &&
                        dist[md] + cost < dist[i]) {
                    dist[i] = dist[md] + cost;
                }
            }
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
            if(adj[current][i] != 0 && !visited.contains(i)){
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
