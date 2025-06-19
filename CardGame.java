// Garret Clark
// 6-18-25
// This is a card Game w/ OOD, which displays the player's cards and checks for pairs. 

// package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {

	// Data structures to hold cards
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {
        // Use try-with-resources for Scanner
        try (Scanner input = new Scanner(new File("cards.txt"))) {
            while (input.hasNext()) {
                String[] fields = input.nextLine().split(",");
                Card newCard = new Card(fields[0], fields[1].trim(),
                        Integer.parseInt(fields[2].trim()), fields[3]);
                deckOfCards.add(newCard);
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        // Use Collections.shuffle for shuffling
        Collections.shuffle(deckOfCards);

        // Deal the player 5 cards (always remove from index 0)
        for (int i = 0; i < 5; i++) {
            playerCards.add(deckOfCards.remove(0));
        }

        System.out.println("players cards");
        for (Card c : playerCards)
            System.out.println(c);

        // Find and display the player's most valuable card using streams
        playerCards.stream()
            .max((c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()))
            .ifPresent(mostValuable -> System.out.println("Most valuable card: " + mostValuable));

        System.out.println("pairs is " + checkFor2Kind());
    }

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
