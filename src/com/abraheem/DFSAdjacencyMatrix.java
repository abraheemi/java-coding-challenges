package com.abraheem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAdjacencyMatrix {
    private final int vertices; // No. of vertices
    private final int[][] adj;

    DFSAdjacencyMatrix(int numOfVertices){
        vertices = numOfVertices;
        adj = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int vSrc, int vDst){
        adj[vSrc][vDst] = 1;
    }

    public void addEdgeBidirectional(int vSrc, int vDst){
        adj[vSrc][vDst] = 1;
        adj[vDst][vSrc] = 1;
    }

    void graph1(boolean isDirected){
        // Image example available in images/dfs_example_1.png
        // Number of vertices: 5
        if(isDirected) {
            addEdge(0, 1);
            addEdge(0, 2);
            addEdge(0, 3);
            addEdge(0, 4);
        }
        else {
            addEdgeBidirectional(0, 1);
            addEdgeBidirectional(0, 2);
            addEdgeBidirectional(0, 3);
            addEdgeBidirectional(0, 4);
        }
    }

    void graph2(boolean isDirected) {
        // Image example available in images/dfs_example_2.png
        // Number of vertices: 12
        if(isDirected) {
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
            addEdgeBidirectional(0, 1);
            addEdgeBidirectional(0, 2);
            addEdgeBidirectional(0, 3);
            addEdgeBidirectional(1, 4);
            addEdgeBidirectional(1, 5);
            addEdgeBidirectional(4, 8);
            addEdgeBidirectional(4, 9);
            addEdgeBidirectional(3, 6);
            addEdgeBidirectional(3, 7);
            addEdgeBidirectional(6, 10);
            addEdgeBidirectional(6, 11);
        }
    }

    void graph3(boolean isDirected){
        // Image example available in images/dfs_example_3.png
        // Number of vertices: 4
        if(isDirected) {
            addEdge(0, 1);
            addEdge(0, 2);
            addEdge(1, 2);
            addEdge(2, 0);
            addEdge(2, 3);
            addEdge(3, 3);
        }
        else {
            addEdgeBidirectional(0, 1);
            addEdgeBidirectional(0, 2);
            addEdgeBidirectional(1, 2);
            addEdgeBidirectional(2, 3);
            addEdgeBidirectional(3, 3);
        }
    }

    void graph4(boolean isDirected) {
        // Image example available in images/dfs_example_4.png
        // Number of vertices: 6
        if(isDirected) {
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
            addEdgeBidirectional(0, 1);
            addEdgeBidirectional(0, 2);
            addEdgeBidirectional(1, 2);
            addEdgeBidirectional(1, 3);
            addEdgeBidirectional(3, 4);
            addEdgeBidirectional(2, 3);
            addEdgeBidirectional(4, 0);
            addEdgeBidirectional(4, 1);
            addEdgeBidirectional(4, 5);
        }
    }

    private void dfsRecursiveHelper(int current, boolean[] visited, List<Integer> output){
        visited[current] = true; // Mark current vertex as visited
        //System.out.print(current + " ");
        output.add(current);

        // For every node in the graph
        for(int i=0; i<vertices; ++i){
            // If a node is adjacent to current node
            // and has been visited
            if(adj[current][i] == 1 && !visited[i])
                dfsRecursiveHelper(i, visited, output);
        }
    }

    public List<Integer> dfsRecursive(int start){
        List<Integer> output = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        dfsRecursiveHelper(start, visited, output);
        return output;
    }

    // Iterative DFS using an adjacency matrix
    public List<Integer> dfsIterative(int start){
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        stack.push(start);

        while(!stack.empty()){
            int current = stack.pop();

            if(visited[current])
                continue;

            visited[current] = true;
            //System.out.print(current + " ");
            output.add(current);

            int len = adj[current].length;
            // Iterating backwards gives same output order as recursive method
            for(int i=len-1; i>=0; --i){
//            for(int i=0; i<len; ++i){
                if(adj[current][i] == 1 && !visited[i])
                    stack.push(i);
            }
        }
        return output;
    }

}
