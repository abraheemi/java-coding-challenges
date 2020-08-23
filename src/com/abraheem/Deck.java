package com.abraheem;

public class Deck {
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    int DECK_SIZE = 52;
    Card[] cards;

    public Deck(){
        this.cards = new Card[DECK_SIZE];
        int suiteIndex = -1;
        for(int i=0; i<DECK_SIZE; i++){
            if(i%13 == 0){
                suiteIndex++;
            }
            this.cards[i] = new Card(ranks[i%13], suits[i]);
        }
    }

    public void printDeck(){
        //for(int i=0; i<)
    }
}

enum Suits {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS;
}

class Card {
    String rank;
    String suite;

    public Card(String rank, String suite){
        this.rank = rank;
        this.suite = suite;
    }
}