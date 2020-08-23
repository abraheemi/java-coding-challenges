package com.abraheem;

public class LinkedList {
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
