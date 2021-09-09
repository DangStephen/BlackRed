/*

created by : Stephi Tyler
date:        9/8/21

*/

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck createDeck() {
		 Deck d = new Deck(); // a Deck is an ArrayList of Card
		      
		Card c = new Card(); // calls Card Object and has to create a card for each suit and weight combination
			

			String s = "";
			String w = "";
			
		for (int i=0; i<=3;) { // create a loop that sets the suits giving capping out at 4 options
			
			if(i==0) {
				s = "H red";
			}
			else if(i==1) {
				s = "S black";
			}
			else if(i==2) {
				s = "D red";
			}
			else {
				s = "C black";
			}
			
			for (int j=0; j<=12;) { // create another loop that sets the weight capping out at 13 options
				if (j == 0) { // ensures that each suit has an Ace
					w="A";
					c=c.createCard(w, s);
					d.add(c);
					j++;
				}
				else if (j>0 && j<=9) { // creates a range for the numeric weights to ensure all values between 2-10
					int y = j+1;
					w= Integer.toString(y);
					c=c.createCard(w, s);
					d.add(c);
					j++;
				}
				else if (j == 10) {// ensures each suit has a Jack
					w="J";
					c=c.createCard(w, s);
					d.add(c);
					j++;
				}
				else if (j == 11) { //ensures each suit has a Queen
					w="Q";
					c=c.createCard(w, s);
					d.add(c);
					j++;
					}
				else { // ensures each suit has a King
					w="K";
					c=c.createCard(w, s);
					d.add(c);
					i++;
					j++;
					}
				}
			}
		return d; // returns a completed deck in order by suit and weight
		}
	
	public void add(Card c) { // enables adding a card to a deck
		deck.add(c);
	}
	
	public Card get(int i) { // enables getting a card from a deck
		return deck.get(i);
	}
	
	public int size() { //gives the number of cards in a deck
		return deck.size();
	}
	
	public void remove(int i) { // removes a card from a deck
		deck.remove(i);
	}
	
	public Deck shuffle() { // this allow you to create a complete shuffled deck
		Deck shuffleDeck = new Deck(); //creates an empty deck
		
		Deck d = new Deck(); //create a completed ordered deck
		d=d.createDeck();
		
		Random rand = new Random();
		
		while (d.size()>0) { // creates a loop that stops once the ordered deck is empty
			int r = rand.nextInt(d.size()); // selects random card from ordered deck
			
			shuffleDeck.add(d.get(r)); // adds random card to empty deck
			d.remove(r); // removes random card from ordered deck
		}
		return shuffleDeck; // returns completed shuffled deck
	}
	
	public Deck deal() { // Takes a deck and returns half of the deck
		Deck x= new Deck(); // create new deck
		int half = (this.size()/2); // figure out how many cards would be half
		for(int i=0; i<(half); i++) { // loops for the amount that would be half or orginial deck
			x.add(this.get(0)); // adds card to new deck
			this.remove(0); // removes card from original deck
		}
		return x; // return new deck with half of original decks cards
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deck d = new Deck();
		d=d.createDeck();

//		System.out.println((d.get(0)).readCard());
//		System.out.println((d.get(1)).readCard());
//		
//	    System.out.println((d.get(0)).compareCard((d.get(1))));
//
//		System.out.println((d.get(0)).getColor());
//		System.out.println((d.get(1)).getColor());
//		
//		System.out.println("deck before shuffle :");
//		for(int i=0; i<d.size(); i++) {
//			System.out.println((d.get(i)).readCard());
//		}
//		System.out.println(d.size());
		
		d=d.shuffle();
		
//		System.out.println((d.get(0)).readCard());
//		System.out.println((d.get(1)).readCard());
//		
//		System.out.println((d.get(0)).compareCard((d.get(1))));
//
//		System.out.println((d.get(0)).getColor());
//		System.out.println((d.get(1)).getColor());
//		
//		System.out.println("deck after shuffle :");
//		for(int i=0; i<d.size(); i++) {
//			System.out.println((d.get(i)).readCard());
//		}
//		System.out.println(d.size());
		
		Deck player1 = new Deck();
		
		player1= d.deal();
		
		System.out.println("player1 hand :");
		for(int i=0; i<player1.size(); i++) {
			System.out.println((player1.get(i)).readCard());
		}
		
		Deck player2 = new Deck();
		
		player2 = d;
		
		System.out.println("player2 hand :");
		for(int i=0; i<player2.size(); i++) {
			System.out.println((player2.get(i)).readCard());
		}
		
	}

}
