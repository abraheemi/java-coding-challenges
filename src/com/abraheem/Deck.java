package com.abraheem;

import java.util.Random;

public class Deck {
    //String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    //String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    Rank[] ranks = new Rank[13];
    Suit[] suits = new Suit[4];
    int DECK_SIZE = 52;
    Card[] cards;

    public Deck(){
        cards = new Card[DECK_SIZE];
        initRanksAndSuites();
        int suiteIndex = -1;
        for(int i=0; i<DECK_SIZE; i++){
            if(i%13 == 0)
                suiteIndex++;
            cards[i] = new Card(ranks[i%13], suits[suiteIndex]);
        }
    }

    private void initRanksAndSuites(){
        System.arraycopy(Rank.values(), 0, ranks, 0, Rank.values().length);
        System.arraycopy(Suit.values(), 0, suits, 0, Suit.values().length);
    }

    public void printDeck(){
        for(int i=0; i<DECK_SIZE; i++){
            System.out.println(cards[i].rank + " of " + cards[i].suite);
        }
    }

    public void shuffle(){
        Random rand = new Random();
        for(int i=0; i<DECK_SIZE; i++) {
            int r = rand.nextInt(DECK_SIZE - i);

            Card tmp = cards[r];
            cards[r] = cards[i];
            cards[i] = tmp;
        }
    }
}

class Card {
    Rank rank;
    Suit suite;

    public Card(Rank rank, Suit suite){
        this.rank = rank;
        this.suite = suite;
    }
}

enum Suit {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS;
}

enum Rank {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;
}