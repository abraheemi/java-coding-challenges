package com.abraheem;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSAlgorithm {
    private int v; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    public DFSAlgorithm(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]){
        visited[v] = true;
        // Print current node
        System.out.println(v + " ");


    }

}
