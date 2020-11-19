package com.abraheem;

public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root; // Pointer for traversal
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'A';
            if(node.children[index] == null){
                TrieNode newNode = new TrieNode();
                node.children[index] = newNode;
            }
            node = node.children[index]; // Get next node in Trie
        }
        node.isEnd = true;
        node.frequency++;
    }

    public boolean search(String word){
        TrieNode node = searchNode(word);
        if(node == null)
            return false;
        else{
            return node.isEnd;
        }
    }

    public boolean startsWith(String prefix){
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word){
        TrieNode node = root;
        int len = word.length();
        for(int i=0; i<len; i++){
            char c = word.charAt(i);
            int index = c - 'A';
            if(node.children[index] != null)
                node = node.children[index];
            else
                return null;
        }

        if(node == root)
            return null;
        return node;
    }
}

class TrieNode{
    int ALPHABET_SIZE = 26;
    TrieNode[] children;
    boolean isEnd; // Represents end of a valid word
    int frequency;

    TrieNode(){
        children = new TrieNode[ALPHABET_SIZE];
        frequency = 0;
    }
}
