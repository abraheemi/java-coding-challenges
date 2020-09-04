package com.abraheem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSAdjacencyList {
    private final int vertices; // Number of vertices
    private final LinkedList<Integer>[] adj; // Adjacency List

    public BFSAdjacencyList(int numOfVertices) {
        vertices = numOfVertices;
        adj = new LinkedList[numOfVertices];
        for(int i=0; i<numOfVertices; ++i){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int vSrc, int vDst){
        adj[vSrc].add(vDst);
    }

    void graph2(boolean directed) {
        // Image example available in images/dfs_example_2.png
        // Number of vertices: 12
        if(directed) {
            addEdge(0, 1);
            addEdge(0, 2);
            addEdge(0, 3);
            addEdge(1, 4);
            addEdge(1, 5);
            addEdge(4, 8);
            addEdge(4, 9);
            addEdge(3, 6);
            addEdge(3, 7);
            addEdge(6, 10);
            addEdge(6, 11);
        }
        else {
            addEdge(0, 1);
            addEdge(1, 0);
            addEdge(0, 2);
            addEdge(2, 0);
            addEdge(0, 3);
            addEdge(3, 0);
            addEdge(1, 4);
            addEdge(4, 1);
            addEdge(1, 5);
            addEdge(5, 1);
            addEdge(4, 8);
            addEdge(8, 4);
            addEdge(4, 9);
            addEdge(9, 4);
            addEdge(3, 6);
            addEdge(6, 3);
            addEdge(3, 7);
            addEdge(7, 3);
            addEdge(6, 10);
            addEdge(10, 6);
            addEdge(6, 11);
            addEdge(11, 6);
        }
    }

    void graph4(boolean directed) {
        // Image example available in images/dfs_example_4.png
        // Number of vertices: 6
        if(directed) {
            addEdge(0, 1);
            addEdge(0, 2);
            addEdge(1, 2);
            addEdge(1, 3);
            addEdge(3, 4);
            addEdge(2, 3);
            addEdge(4, 0);
            addEdge(4, 1);
            addEdge(4, 5);
        }
        else {
            addEdge(0, 1);
            addEdge(1, 0);
            addEdge(0, 2);
            addEdge(2, 0);
            addEdge(1, 2);
            addEdge(2, 1);
            addEdge(1, 3);
            addEdge(3, 1);
            addEdge(3, 4);
            addEdge(4, 3);
            addEdge(2, 3);
            addEdge(3, 2);
            addEdge(4, 0);
            addEdge(0, 4);
            addEdge(4, 1);
            addEdge(1, 4);
            addEdge(4, 5);
            addEdge(5, 4);
        }
    }

    public List<Integer> bfs(int start){
        List<Integer> output = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            // Remove a vertex from the queue
            int v = queue.poll();
            output.add(v);

            // Loop through all adjacent vertices from the dequeued (polled) vertex v.
            // If a vertex hasn't been visited, then mark as visited and queue it.
            int len = adj[v].size();
//            for(int i=len-1; i>=0; --i){
            for(int i=0; i<len; ++i){
                int next = adj[v].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return output;
    }


}
