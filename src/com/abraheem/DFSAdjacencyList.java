package com.abraheem;

import java.util.LinkedList;
import java.util.Stack;

public class DFSAdjacencyList {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    public DFSAdjacencyList(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int vSrc, int vDest){
        // Add forward edge
        adj[vSrc].add(vDest);
    }

    void prePopulateExample1(){
        // Image example available in images/dfs_example_1.png
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);
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

    private void dfsRecursiveHelper(int v, boolean[] visited){
        visited[v] = true;
        // Print current node
        System.out.print(v + " ");

        int len = adj[v].size();
        for(int i=0; i<len; ++i){
            int n = adj[v].get(i);
            if(!visited[n])
                dfsRecursiveHelper(n, visited);
        }
    }

    // Recursive DFS using an adjacency list
    public void dfsRecursive(int start){
        // v is the starting node
        boolean[] visited = new boolean[vertices];
        dfsRecursiveHelper(start, visited);
        System.out.println();
    }

    // Iterative DFS using an adjacency list
    public void dfsIterative(int start){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        stack.push(start);

        while(!stack.empty()){
            int current = stack.pop();

            if(visited[current])
                continue;

            visited[current] = true;
            System.out.print(current + " ");

            int len = adj[current].size();
            // Iterating backwards gives same output order as recursive method
            for(int i=len-1; i>=0; --i){
//            for(int i=0; i<len; ++i){
                int v = adj[current].get(i);
                if(!visited[v])
                    stack.push(v);
            }
        }
        System.out.println();
    }

}
