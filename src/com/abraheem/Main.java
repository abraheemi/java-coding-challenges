package com.abraheem;

import com.abraheem.Dependency_Injection.clients.*;
import com.abraheem.Dependency_Injection.services.*;
import com.abraheem.Dependency_Injection.interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static void hourglassSumCall(){
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        Hourglass hourglass = new Hourglass();
        System.out.println("Largest Sum = " + hourglass.largestSum(arr));
    }



    private static void java8LambdaExpressionCall(){
        final String msg = "Java 8 Message: ";
        Java8MsgServiceCall firstMsg = (myMsg) -> System.out.println(msg + myMsg);
        firstMsg.printJava8Msg("Service call");
    }

    static void linkedListCall(){
        LinkedL list = new LinkedL();

        list.insert(3);
        list.insert(5);
        list.insert(1);
        list.printList();
        System.out.println("Head: " + list.getHead());
    }

    static void hashMapCall(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(7, "Seven");
        map.put(2, "Two");
        map.put(1, "One");
        map.put(4, "Four");
        System.out.println(map.get(7));
        System.out.println(map);
    }

    static void binaryTreeCall(){

    }


    private static void spiralMatrixCall(){
        int[][] matrix = {  {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println("Spiral Order: " + spiralMatrix.spiralOrder(matrix));
    }

    static void setsCall(){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(7);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(2);

        //list1.addAll(list2);
        System.out.println(list1);
        int a = list1.indexOf(9);
        System.out.println(a);
    }

    static void boggleCall(){
        char[][] boggleBoard = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};
        String[] dictionaryArray = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
        char[][] boggleBoardSmall = {
                {'S', 'E'},
                {'H', 'E'}
        };
        String[] dictionaryArraySmall = {"SHE", "SEE"};
        Boggle boggle = new Boggle(boggleBoardSmall, dictionaryArraySmall);
        boggle.solve();
    }

    static void trieCall(){
        String[] dictionaryArraySmall = {"SHE", "SEE"};
        Trie trie = new Trie();
        trie.insert(dictionaryArraySmall[0]);
        trie.insert(dictionaryArraySmall[1]);
        if(trie.search("SHE")){
            System.out.println("SHE:    Found");
        }
        if(!trie.search("HE")){
            System.out.println("HE:     Not Found");
        }
    }

    static void deckCall(){
        Deck deck = new Deck();
        deck.printDeck();
        deck.shuffle();
        System.out.println("-------------------------");
        deck.printDeck();
    }

    static void dependencyInjectionCall(){
        Service service = new ServiceA();
        Client client = new ClientA(service);
        client.doSomething();
        ((ClientA) client).setService(new ServiceB());
        client.doSomething();
    }

    static void dfsCall(){
        DFSAdjacencyList graph1 = new DFSAdjacencyList(12);
        DFSAdjacencyMatrix graph2 = new DFSAdjacencyMatrix(12);

        graph1.graph4(false);
        graph2.graph4(false);

//        graph1.graph3(false);
//        graph2.graph3(false);

        System.out.println("DFS recursive using adjacency list:");
        System.out.println(graph1.dfsRecursive(5));
        System.out.println("DFS iterative using adjacency list:");
        System.out.println(graph1.dfsIterative(5));

        System.out.println("DFS recursive using adjacency matrix:");
        System.out.println(graph2.dfsRecursive(5));
//        System.out.println("DFS iterative using adjacency matrix:");
//        System.out.println(graph2.dfsIterative(0));
    }

    static void bfsCall(){
        BFSAdjacencyList bfsGraph = new BFSAdjacencyList(12);
        BFSAdjacencyList bfsGraphUndirected = new BFSAdjacencyList(6);
        bfsGraph.graph2(false);
        bfsGraphUndirected.graph4(false);
        System.out.println("BFS using adjacency list: ");
        System.out.println(bfsGraphUndirected.bfs(1));
    }

    static void dijstraCall(){
        DijkstraAdjacencyList d = new DijkstraAdjacencyList(6);
        d.addEdge(0, 1, 9);
        d.addEdge(0, 2, 6);
        d.addEdge(0, 3, 12);
        d.addEdge(0, 4, 3);
        d.addEdge(2, 1, 2);
        d.addEdge(2, 3, 4);
        d.addEdge(3, 5, 1);
        d.addEdge(4, 5, 12);
        int start = 2;
        System.out.println("Shortest path from node " + start);
        int[] dist = d.shortestPath(start);
        for (int i=0; i< dist.length; ++i){
            System.out.println(start + " --> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        dijstraCall();
    }
}