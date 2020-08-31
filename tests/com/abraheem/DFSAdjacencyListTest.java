package com.abraheem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DFSAdjacencyListTest {
    DFSAdjacencyList graph1Directed;
    DFSAdjacencyList graph2Directed;
    DFSAdjacencyList graph3Directed;
    DFSAdjacencyList graph4Directed;
    DFSAdjacencyList graph1Undirected;
    DFSAdjacencyList graph2Undirected;
    DFSAdjacencyList graph3Undirected;
    DFSAdjacencyList graph4Undirected;
    // Assuming directed graphs
    Integer[] directed1_1 = {0, 1, 2, 3, 4};
    Integer[] directed1_2 = {4};
    Integer[] directed2_1 = {0, 1, 4, 8, 9, 5, 2, 3, 6, 10, 11, 7};
    Integer[] directed2_2 = {3, 6, 10, 11, 7};
    Integer[] directed3_1 = {0, 1, 2, 3};
    Integer[] directed3_2 = {2, 0, 1, 3};
    Integer[] directed4_1 = {2, 3, 4, 0, 1, 5};
    Integer[] directed4_2 = {5};
    // Assuming undirected graphs
    Integer[] undirected1_1 = {1, 0, 2, 3, 4};
    Integer[] undirected2_1 = {5, 1, 0, 2, 3, 6, 10, 11, 7, 4, 8, 9};
    Integer[] undirected3_1 = {3, 2, 0, 1};
    Integer[] undirected4_1 = {2, 0, 1, 3, 4, 5};
    Integer[] undirected4_2 = {5, 4, 0, 1, 2, 3};

    @Before
    public void setUp() throws Exception {
        graph1Directed = new DFSAdjacencyList(5);
        graph2Directed = new DFSAdjacencyList(12);
        graph3Directed = new DFSAdjacencyList(4);
        graph4Directed = new DFSAdjacencyList(6);

        graph1Undirected = new DFSAdjacencyList(5);
        graph2Undirected = new DFSAdjacencyList(12);
        graph3Undirected = new DFSAdjacencyList(4);
        graph4Undirected = new DFSAdjacencyList(6);

        graph1Directed.graph1(true);
        graph2Directed.graph2(true);
        graph3Directed.graph3(true);
        graph4Directed.graph4(true);

        graph1Undirected.graph1(false);
        graph2Undirected.graph2(false);
        graph3Undirected.graph3(false);
        graph4Undirected.graph4(false);
    }

    @Test
    public void dfsRecursive() {
        // Directed graph tests
        assertArrayEquals(directed1_1, graph1Directed.dfsRecursive(0).toArray());
        assertArrayEquals(directed1_2, graph1Directed.dfsRecursive(4).toArray());
        assertArrayEquals(directed2_1, graph2Directed.dfsRecursive(0).toArray());
        assertArrayEquals(directed2_2, graph2Directed.dfsRecursive(3).toArray());
        assertArrayEquals(directed3_1, graph3Directed.dfsRecursive(0).toArray());
        assertArrayEquals(directed3_2, graph3Directed.dfsRecursive(2).toArray());
        assertArrayEquals(directed4_1, graph4Directed.dfsRecursive(2).toArray());
        assertArrayEquals(directed4_2, graph4Directed.dfsRecursive(5).toArray());
        // Undirected graph tests
        assertArrayEquals(undirected1_1, graph1Undirected.dfsRecursive(1).toArray());
        assertArrayEquals(undirected2_1, graph2Undirected.dfsRecursive(5).toArray());
        assertArrayEquals(undirected3_1, graph3Undirected.dfsRecursive(3).toArray());
        assertArrayEquals(undirected4_1, graph4Undirected.dfsRecursive(2).toArray());
        assertArrayEquals(undirected4_2, graph4Undirected.dfsRecursive(5).toArray());
    }

    @Test
    public void dfsIterative() {
        // Directed graph tests
        assertArrayEquals(directed1_1, graph1Directed.dfsIterative(0).toArray());
        assertArrayEquals(directed1_2, graph1Directed.dfsIterative(4).toArray());
        assertArrayEquals(directed2_1, graph2Directed.dfsIterative(0).toArray());
        assertArrayEquals(directed2_2, graph2Directed.dfsIterative(3).toArray());
        assertArrayEquals(directed3_1, graph3Directed.dfsIterative(0).toArray());
        assertArrayEquals(directed3_2, graph3Directed.dfsIterative(2).toArray());
        assertArrayEquals(directed4_1, graph4Directed.dfsIterative(2).toArray());
        assertArrayEquals(directed4_2, graph4Directed.dfsIterative(5).toArray());
        // Undirected graph tests
        assertArrayEquals(undirected1_1, graph1Undirected.dfsIterative(1).toArray());
        assertArrayEquals(undirected2_1, graph2Undirected.dfsIterative(5).toArray());
        assertArrayEquals(undirected3_1, graph3Undirected.dfsIterative(3).toArray());
        assertArrayEquals(undirected4_1, graph4Undirected.dfsIterative(2).toArray());
        assertArrayEquals(undirected4_2, graph4Undirected.dfsIterative(5).toArray());
    }
}