package com.abraheem;

import java.util.Stack;

public class DFSAdjacencyMatrix {
    private int vertices; // No. of vertices
    private int edges; // No. of edges
    private int[][] adj;

    DFSAdjacencyMatrix(int v, int e){
        vertices = v;
        edges = e;
        adj = new int[v][v];
    }

    // Bidirectional graph example
    void prePopulateExample1(){
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(0, 4);
    }

    // Directional graph example
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

    // Bidirectional graph example
    void prePopulateExample3() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 5);
    }

    public void addEdge(int start, int e){
        // Considering a bidirectional edge;
        // otherwise, only the first assignment is needed
        adj[start][e] = 1;
        //adj[e][start] = 1;
    }

    private void dfsRecursiveHelper(int cv, boolean[] visited){
        System.out.print(cv + " ");
        visited[cv] = true; // Mark current vertex as visited
        // For every node in the graph
        for(int i=0; i<vertices; ++i){
            // If a node is adjacent to current node
            // and has been visited
            if(adj[cv][i] == 1 && !visited[i])
                dfsRecursiveHelper(i, visited);
        }
    }

    public void dfsRecursive(int start){
        boolean[] visited = new boolean[vertices];
        dfsRecursiveHelper(start, visited);
        System.out.println();
    }

    // Iterative DFS using an adjacency matrix
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

            int len = adj[current].length;
            // Iterating backwards gives same output order as recursive method
            for(int i=len-1; i>=0; --i){
//            for(int i=0; i<len; ++i){
                if(adj[current][i] == 1 && !visited[i])
                    stack.push(i);
            }
        }
        System.out.println();
    }

}
