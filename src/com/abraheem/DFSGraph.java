package com.abraheem;

import java.util.LinkedList;

public class DFSGraph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    public DFSGraph(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
        //prePopulateGraph();
    }

    public void addEdge(int vSrc, int vDest){
        // Add forward edge
        adj[vSrc].add(vDest);
    }

    void prePopulateExample1(){
        // Image example available in images/dfs_example_1.png
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 1);
        addEdge(3, 4);
        addEdge(4, 4);
    }

    void prePopulateExample2() {
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

    private void DFSRec(int v, boolean[] visited){
        visited[v] = true;
        // Print current node
        System.out.print(v + " ");

        int len = adj[v].size();
        for(int i=0; i<len; ++i){
            int n = adj[v].get(i);
            if(!visited[n])
                DFSRec(n, visited);
        }
    }

    public void DFS(int v){ // v is the starting node
        boolean[] visited = new boolean[vertices];
        DFSRec(v, visited);
        System.out.println();
    }
}
