package com.abraheem;

public class BinaryTree {
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
