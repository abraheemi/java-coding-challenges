package com.abraheem;

import java.lang.reflect.Array;
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

    private static void java8Example(){
        final String msg = "Java 8 MSG ";
        Java8MsgServiceCall firstMsg = myMsg ->
                System.out.println(msg + myMsg);
        firstMsg.printJava8Msg("Method call");
    }

    interface Java8MsgServiceCall {
        void printJava8Msg(String msg);
    }

    static void linkedListCall(){
        LinkedList list = new LinkedList();

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

    static void dfsCall(){
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

    private static void recursion(StringBuffer letters, int recNum){
        System.out.println("Level: " + recNum + " ==> Letters: " + letters.toString());
        recNum++;
        if(recNum == 3)
            return;
        else if (recNum == 1){
            letters.append('D');
            recursion(letters, recNum);
        }
        else if(recNum == 2){
            letters.append('E');
            recursion(letters, recNum);
        }

        letters.deleteCharAt(letters.length() - 1);
    }

    static void recursionCall(){
        StringBuffer letters = new StringBuffer();
        letters.append('A');
        letters.append('B');
        letters.append('C');
        int recNum = 0;
        recursion(letters, recNum);
        System.out.println(letters.toString());
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

    public static void main(String[] args) {
        //dfsCall();
        trieCall();

    }
}