package com.company;

public class Poker {

    public static void main (String[] args) {

        String[] deck = createDeck();
        //printDeck(deck);
        shuffleDeck(deck);
        //printDeck(deck);
        handleCards(deck,5);
    }

    public static String[] createDeck () {
        String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suit = {"♥","♠","♣","♦"};
        String[] card = new String[rank.length*suit.length];
        for (int i=0; i<rank.length; i++) {
            for(int j=0; j<suit.length; j++) {
                card[suit.length*i+j]=suit[j]+rank[i];
            }
        }
        return card;
    }

    public static String[] shuffleDeck (String[] card) {
        String buffer;
        for (int i=0; i<card.length; i++) {
            int rnd = (int) (Math.random()*(card.length));
            buffer = card[i];
            card[i] = card[rnd];
            card[rnd] = buffer;
        }
        return card;
    }

    public static void handleCards (String[] card, int n) {
//		System.out.println();
        for (int i=0; i<n; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(card[n*i+j]+" ");
            }
            System.out.println();
        }
    }

    public static void printDeck(String[] card){
        for (int i=0; i<card.length; i++) {
            System.out.print(card[i]+" ");
        }
        System.out.println();
    }
}
