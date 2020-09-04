package com.abraheem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BFSAdjacencyListTest {
    BFSAdjacencyList graph2Directed;
    BFSAdjacencyList graph4Directed;
    BFSAdjacencyList graph2Undirected;
    BFSAdjacencyList graph4Undirected;

    Integer[] directed2_1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    Integer[] directed4_1 = {0, 1, 2, 3, 4, 5};
    Integer[] undirected2_1 = {3, 0, 6, 7, 1, 2, 10, 11, 4, 5, 8, 9};
    Integer[] undirected4_1 = {1, 0, 2, 3, 4, 5};

    @Before
    public void setUp() throws Exception {
        graph2Directed = new BFSAdjacencyList(12);
        graph4Directed = new BFSAdjacencyList(6);
        graph2Undirected = new BFSAdjacencyList(12);
        graph4Undirected = new BFSAdjacencyList(6);
        graph2Directed.graph2(true);
        graph4Directed.graph4(true);
        graph2Undirected.graph2(false);
        graph4Undirected.graph4(false);
    }

    @Test
    public void bfs() {
        assertArrayEquals(directed2_1, graph2Directed.bfs(0).toArray());
        assertArrayEquals(directed4_1, graph4Directed.bfs(0).toArray());
        assertArrayEquals(undirected2_1, graph2Undirected.bfs(3).toArray());
        assertArrayEquals(undirected4_1, graph4Undirected.bfs(1).toArray());
    }
}