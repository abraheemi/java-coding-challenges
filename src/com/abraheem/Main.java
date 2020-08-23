package com.abraheem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    // Complete the hourglassSum function below.
    private static int hourglassSum(int arr_rows, int arr_columns, int[][] arr) {
        int offset = 2;
        int sum = 0, tmpSum = 0;

        int i=0, j=0;
        sum += arr[i][j]+arr[i][j+1]+arr[i][j+2];
        sum += arr[i+1][j+1];
        sum += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
        while(i+offset < arr_rows){
            j=0;
            while(j+offset < arr_columns){
                tmpSum=0;
                tmpSum += arr[i][j]+arr[i][j+1]+arr[i][j+2];
                tmpSum += arr[i+1][j+1];
                tmpSum += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];

                if(sum < tmpSum)
                    sum = tmpSum;
                j++;
            }
            i++;
        }
        return sum;
    }

    private static void hourglassSumCall(){
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println("Biggest Sum = " + hourglassSum(6,6,arr));
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

    static void spiralOrderCall() {
        int[][] matrix = {  {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0)
            System.out.println("Array is empty.");
        int Rows = matrix.length;
        int Cols = matrix[0].length;
        int numOfCells = Rows*Cols;
        boolean[][] visited = new boolean[Rows][Cols];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0;
        int c = 0;
        int direction = 0;

        for (int i = 0; i < numOfCells; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int cr = r + dr[direction];
            int cc = c + dc[direction];
            if (0 <= cr && cr < Rows && 0 <= cc && cc < Cols && !visited[cr][cc]){
                r = cr;
                c = cc;
            } else {
                direction = (direction + 1) % 4;
                r += dr[direction];
                c += dc[direction];
            }
        }
        for(Integer i: ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static List<Integer> spiralMatrix(int[][] matrix){
        List<Integer> printArray = new ArrayList<Integer>();
        int r = 0, c = 0; // Current row and col
        int nr = 0, nc = 0; // Next row and col
        int directionIndex = 0;
        int[] rDirection = {0, 1, 0, -1};
        int[] cDirection = {1, 0, -1, 0};

        if(matrix.length == 0)
            return printArray;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int numOfCells = rows*cols;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<numOfCells; i++){
            printArray.add(matrix[r][c]);
            visited[r][c] = true;
            nr = r + rDirection[directionIndex];
            nc = c + cDirection[directionIndex];
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]){
                r = nr;
                c = nc;
            }
            else{
                directionIndex = (directionIndex + 1) % 4;
                r = r + rDirection[directionIndex];
                c = c + cDirection[directionIndex];
            }
        }

        return printArray;
    }

    private static void spiralMatrixCall(){
        int[][] matrix = {  {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(spiralMatrix(matrix));

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

class BinaryTree {
    Node root;

    public void insert(int val){
        if(root == null){
            root = new Node(val);
        }
        else{
            Node p = root;
            while(true) {
                if (val > p.val) {
                    if(p.right == null){
                        p.right = new Node(val);
                        return;
                    }
                    p = p.right;
                }
                else if(val < p.val){
                    if(p.left == null){
                        p.left = new Node(val);
                        return;
                    }
                    p = p.left;
                }
            }
        }
    }

    public void printPreOrder(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node current){
        if(current != null){
            System.out.print(current.val + " ");
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    public void printPostOrder(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node current){
        if(current != null){
            postOrderTraversal(current.left);
            System.out.print(current.val + " ");
            postOrderTraversal(current.right);
        }
    }

    public void printInOrder(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node current){

    }

    static class Node {
        int val;
        Node right;
        Node left;

        Node(int val){
            this.val = val;
            right = null;
            left = null;
        }
    }
}



class LinkedList {
    private Node head;

    public void insert(int val){
        Node p = head;
        if(p == null){
            head = new Node(val);
            return;
        }
        while (p.next != null){
            p = p.next;
        }
        p.next = new Node(val);
    }

    public void printList(){
        Node p = head;
        if(p == null){
            return;
        }
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

    }

    public int getVal(){
        return head.val;
    }

    public int getHead(){
        return head.val;
    }

    private static class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
}
