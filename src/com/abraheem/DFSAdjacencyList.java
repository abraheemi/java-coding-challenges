package com.abraheem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSAdjacencyList {
    private final int vertices; // Number of vertices
    private final LinkedList<Integer>[] adj; // Adjacency List

    public DFSAdjacencyList(int numOfVertices) {
        vertices = numOfVertices;
        adj = new LinkedList[numOfVertices];
        for(int i=0; i<numOfVertices; ++i){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int vSrc, int vDst){
        adj[vSrc].add(vDst);
    }

    void graph1(boolean isDirected){
        // Image example available in images/dfs_example_1.png
        // Number of vertices: 5
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(0, 4);

        if(!isDirected)  {
            addEdge(1, 0);
            addEdge(2, 0);
            addEdge(3, 0);
            addEdge(4, 0);
        }
    }

    void graph2(boolean isDirected) {
        // Image example available in images/dfs_example_2.png
        // Number of vertices: 12
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

        if(!isDirected) {
            addEdge(1, 0);
            addEdge(2, 0);
            addEdge(3, 0);
            addEdge(4, 1);
            addEdge(5, 1);
            addEdge(8, 4);
            addEdge(9, 4);
            addEdge(6, 3);
            addEdge(7, 3);
            addEdge(10, 6);
            addEdge(11, 6);
        }
    }

    void graph3(boolean isDirected){
        // Image example available in images/dfs_example_3.png
        // Number of vertices: 4
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        if(!isDirected) {
            addEdge(1, 0);
            addEdge(2, 0);
            addEdge(2, 1);
            addEdge(3, 2);
            addEdge(3, 3);
        }
    }

    // 5 4 3 1 0 2
    void graph4(boolean isDirected) {
        // Image example available in images/dfs_example_4.png
        // Number of vertices: 6
            addEdge(0, 1);
            addEdge(0, 2);
            addEdge(1, 2);
            addEdge(1, 3);
            addEdge(3, 4);
            addEdge(2, 3);
            addEdge(4, 0);
            addEdge(4, 1);
            addEdge(4, 5);

        if(!isDirected) {
            addEdge(1, 0);
            addEdge(2, 0);
            addEdge(2, 1);
            addEdge(3, 1);
            addEdge(4, 3);
            addEdge(3, 2);
            addEdge(0, 4);
            addEdge(1, 4);
            addEdge(5, 4);
        }
    }

    private void dfsRecursiveHelper(int current, boolean[] visited, List<Integer> output){
        visited[current] = true;
        //System.out.print(current + " ");
        output.add(current);

        int len = adj[current].size();
        for(int i=0; i<len; ++i){
            int v = adj[current].get(i);
            if(!visited[v])
                dfsRecursiveHelper(v, visited, output);
        }
    }

    // Recursive DFS using an adjacency list
    public List<Integer> dfsRecursive(int start){
        List<Integer> output = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        dfsRecursiveHelper(start, visited, output);
        return output;
    }

    // Iterative DFS using an adjacency list
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

            int len = adj[current].size();
            // Iterating backwards gives same output order as recursive method
            for(int i=len-1; i>=0; --i){
//            for(int i=0; i<len; ++i){
                int v = adj[current].get(i);
                if(!visited[v])
                    stack.push(v);
            }
        }
        return output;
    }

}
