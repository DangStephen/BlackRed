/*

created by : Stephi Tyler
date:        9/8/21

*/

import java.util.Scanner;
import java.util.Random;

public class BlackRed {
	
	public static boolean headsOrTails() {
		Random rand = new Random();
		int r = rand.nextInt(2); // flip a coin to see who goes first
		
		if (r == 0) {
			System.out.println("Heads");
			return true;
		}
		else {
			System.out.println("Tails");
			return false;
		}
	}
	
	public static void emptyPile(Deck out, Deck in) { //removes cards from outDeck to inDeck in order
		for(int i=out.size()-1; i>=0; i--) {
			in.add(out.get(out.size()-1));
			out.remove(out.size()-1);
		}
	}
	
	public static boolean checkColor(Deck p) { // checks to see if last card in is a different color than previous
		if (p.get(p.size()-1).getColor() != p.get(p.size()-2).getColor()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean somethingThere (Deck p) { //checks to see if there is something in the shard pile
		if (p.size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean lastCard (Deck p) { //checks to see if there is only one card left in the deck
		if (p.size()== 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void playGame(String x) {

		Deck d = new Deck();
		d=d.createDeck();
		d=d.shuffle();
		
		Deck player1 = new Deck();
		player1 = d.deal();
		
		Deck computer = new Deck();
		computer = d;
		
		Deck pile = new Deck();
		
		Deck pHolder = new Deck();
		
		Deck goesFirst = new Deck();
		
		Deck goesSecond = new Deck();
		
		int c = 0; // counter for switching player if c is odd goesFirst is computer
		
		boolean ht = headsOrTails();
		
		if (((ht == true) && (x.equals("h")||x.equals("H"))) || ((ht == false) && (x.equals("t")||x.equals("T")))) {
			System.out.println("You play first.");
			goesFirst = player1;
			goesSecond = computer;
		}
		else {
			System.out.println("Computer play first.");
			goesFirst = computer;
			goesSecond = player1;
			c++; // insuring counter shows odd when computer is goesFirst
		}
		
		while(goesFirst.size()>=0||goesSecond.size()>=0) {	// continues the game until one deck is empty or player quits
			Scanner play = new Scanner(System.in);
			String y = "";						// check to see if goesFirst is the player if it is ask if they want to continue to play
			
			System.out.println("Draw a Card or Quit? D/Q"); // no matter whether it is player who goes first or computer ask player if they would still like to play
			y = play.nextLine();
				
			if(y.equals("D")||y.equals("d")) { 				// if y is d game continues
				if(c%2 == 0) {								// goesFirst is player 
					System.out.println("YOU Have " + Integer.toString(goesFirst.size()) + " cards.");  // prints out the number of cards player has
					System.out.println("COMPUTER Has " + Integer.toString(goesSecond.size()) + " cards."); //prints out the number of cards computer has
				}
				else {										// goesSecond is player
					System.out.println("YOU Have " + Integer.toString(goesSecond.size()) + " cards.");  // prints out the number of cards player has
					System.out.println("COMPUTER Has " + Integer.toString(goesFirst.size()) + " cards."); //prints out the number of cards computer has
				}
				if (somethingThere(pile)==true) {				// checks to see if there is a card on the pile

					System.out.println("Top of pile: "+(pile.get(pile.size()-1)).readCard()); // card on the top of pile
					
					if (lastCard(goesFirst)==true) {			// checks to see if goesFirst is on their last card they are
						pile.add(goesFirst.get(0));				// adds card to pile from goesFirst deck
						goesFirst.remove(0);					// removes card from goesFirst deck
						if (checkColor(pile)==false) {			// checks if new card added to pile changed color from previous card on the pile in this case no so stays on the pile and goesFirst is out of cards
							if(c%2 == 0) {						// checks to see if winner is computer or player
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
								System.out.println("YOU Have " + Integer.toString(goesFirst.size()) + " cards.");  // prints out the number of cards player has
								System.out.println("COMPUTER Has " + Integer.toString(goesSecond.size()) + " cards."); //prints out the number of cards computer has
								System.out.println("YOU WIN :D");//if counter "c" is even player wins
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
								System.out.println("YOU Have " + Integer.toString(goesSecond.size()) + " cards.");  // prints out the number of cards player has
								System.out.println("COMPUTER Has " + Integer.toString(goesFirst.size()) + " cards."); //prints out the number of cards computer has
								System.out.println("You Lose :(");//if counter "c" is odd computer wins
							}
							break;								// breaks loop
						}
						else {									// goesFirst changed the color at the top of the pile
							if (c%2==0) {
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
							}
							emptyPile(pile,goesFirst);			// moves all cards from pile to goesFirst deck
							pHolder = goesFirst;				// switches turns using a place holder to hold current instance of goesFirst deck
							goesFirst= goesSecond;				// switches the deck that goesSecond to current goesFirst deck
							goesSecond= pHolder;				// brings previous instance of goesFirst deck to the goesSecond
							c++;								// update counter
						}
					}
					else { 										// not goesFirst last card
						pile.add(goesFirst.get(0));				// adds card to pile from goesFirst deck
						goesFirst.remove(0);					// removes card from goesFirst deck
						if (checkColor(pile)==false) {			// checks to see if added card changed color of previous card on the top of the pile in this case no so card stays
							if (c%2==0) {
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
							}
							System.out.println("Pile Has " + Integer.toString(pile.size()) + " cards.");
							pHolder = goesFirst;				// switches turns using a place holder to hold current instance of goesFirst deck
							goesFirst= goesSecond;				// switches the deck that goesSecond to current goesFirst deck
							goesSecond= pHolder;				// brings previous instance of goesFirst deck to the goesSecond
							c++;								// update counter
						}
						else {									// the card added to pile did change the card color on the top of the pile
							if (c%2==0) {
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
							}
							emptyPile(pile,goesFirst);			// all the cards from pile are added to the goesFirst deck
							pHolder = goesFirst;				// switches turns using a place holder to hold current instance of goesFirst deck
							goesFirst= goesSecond;				// switches the deck that goesSecond to current goesFirst deck
							goesSecond= pHolder;				// brings previous instance of goesFirst deck to the goesSecond
							c++;								// update counter
						}
					}
				}
				else {											// there is nothing on the pile and goesFirst turn
					if (lastCard(goesFirst)==true) {			// confirms if this is goesFirst last Card
						pile.add(goesFirst.get(0));				// adds to the pile from goesFirst deck
						goesFirst.remove(0);					// removes card from goesFirst deck
						if(c%2 == 0) {							// checks to see if winner is computer or player
							System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							System.out.println("YOU Have " + Integer.toString(goesFirst.size()) + " cards.");  // prints out the number of cards player has
							System.out.println("COMPUTER Has " + Integer.toString(goesSecond.size()) + " cards."); //prints out the number of cards computer has
							System.out.println("YOU WIN :D");	// if counter "c" is even player wins
						}
						else {
							System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer goesFirst card printed out
							System.out.println("YOU Have " + Integer.toString(goesSecond.size()) + " cards.");  // prints out the number of cards player has
							System.out.println("COMPUTER Has " + Integer.toString(goesFirst.size()) + " cards."); //prints out the number of cards computer has
							System.out.println("YOU LOSE :(");	// if counter "c" is odd computer wins
						}
						break;									// breaks loop
					}
					else {										// not goesFirst last Card
						pile.add(goesFirst.get(0));				// adds to the pile from goesFirst deck
						goesFirst.remove(0);					// removes card from goesFirst deck
						if (lastCard(goesSecond)==true) {		// confirms that the goesSecond is on their last card
							if (c%2==0) {
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
							}
							pile.add(goesSecond.get(0));		// adds card to pile from goesSecond deck
							goesSecond.remove(0);				// removes card from goesSecond deck
							if (checkColor(pile)==false) {		// the last card from goesSecond does did not change the color on the top of the pile so it stays
								if(c%2 == 0) {							// checks to see if winner is computer or player
									System.out.println("COMPUTER added 2nd: "+(pile.get(pile.size()-1)).readCard()); // computer as goesSecond card printed out
									System.out.println("YOU Have " + Integer.toString(goesFirst.size()) + " cards.");  // prints out the number of cards player has
									System.out.println("COMPUTER Has " + Integer.toString(goesSecond.size()) + " cards."); //prints out the number of cards computer has
									System.out.println("YOU LOSE :(");	// if counter "c" is even computer wins because in this case we are checking position from goesSecond prospective
								}
								else {
									System.out.println("YOU added 2nd: "+(pile.get(pile.size()-1)).readCard()); // player as goesSecond card printed out
									System.out.println("YOU Have " + Integer.toString(goesSecond.size()) + " cards.");  // prints out the number of cards player has
									System.out.println("COMPUTER Has " + Integer.toString(goesFirst.size()) + " cards."); //prints out the number of cards computer has
									System.out.println("YOU WIN :D");	// if counter "c" is odd player wins because in this case we are checking position from goesSecond prospective
								}
								break;
							}
							else {								// goesSecond Card did change the color at the top of the pile
								if (c%2==0) {
								System.out.println("COMPUTER added 2nd: "+(pile.get(pile.size()-1)).readCard()); // computer as goesSecond card printed out
								}
								else {
								System.out.println("YOU added 2nd: "+(pile.get(pile.size()-1)).readCard()); // player as goesSecond card printed out
								}
								emptyPile(pile,goesSecond);		// all the cards from pile are added to the goesSecond deck also no switch because already set to goesSecond
							}
						}
						else {									// not goesSecond last card
							if (c%2==0) {
								System.out.println("YOU added 1st: "+(pile.get(pile.size()-1)).readCard()); // player as goesFirst card printed out
							}
							else {
								System.out.println("COMPUTER added 1st: "+(pile.get(pile.size()-1)).readCard()); // computer as goesFirst card printed out
							}
							pile.add(goesSecond.get(0));		// adds card to pile from goesSecond deck
							goesSecond.remove(0);				// removes card from goesSecond deck
							if (checkColor(pile)==false) {		// the last card on top of pile from goesSecond does did not change the color on the top of the pile so it stays again no switch because other person goesFirst
								if (c%2==0) {
									System.out.println("COMPUTER added 2nd: "+(pile.get(pile.size()-1)).readCard()); // computer as goesSecond card printed out
									}
								else {
									System.out.println("YOU added 2nd: "+(pile.get(pile.size()-1)).readCard()); // player as goesSecond card printed out
									}
								System.out.println("Pile Has " + Integer.toString(pile.size()) + " cards.");
							}
							else {								// the last card on top of pile from goesSecond did change the color on the top of the pile
								if (c%2==0) {
									System.out.println("COMPUTER added 2nd: "+(pile.get(pile.size()-1)).readCard()); // computer as goesSecond card printed out
									}
								else {
									System.out.println("YOU added 2nd: "+(pile.get(pile.size()-1)).readCard()); // player as goesSecond card printed out
									}
								emptyPile(pile,goesSecond);		// all the cards from pile are added to the goesSecond deck also no switch because already set to goesSecond
							}
						}
					}
				}
			}
			else if (y.equals("Q")||y.equals("q")){ 			// player does not want to play
				System.out.println("You Lose. X(");
				break;
			}
			else { 												// player did not make a proper choice
				System.out.println("Sorry not an option. Draw a Card or Quit? D/Q");
				y = play.nextLine();
			}
		}
	}
	
	public static void main (String[] args) {
		System.out.println("Welcome to Black Red! \n How to play: \n A deck of cards is shuffle and split into two even decks.\n One player plays a card then the other player plays a card. \n If the last player plays a card that is a differnt color than previously played they must pick up the pile. \n The first player to empty thier hand wins! ");
		
		Scanner wyltp = new Scanner(System.in); // getting confirmation that player would like to continue

		System.out.println("Would you like to play? Y/N ");
		
		String s = wyltp.nextLine();
		
		if (s.equals("y") || s.contentEquals("Y")) { //games start
			System.out.println("Let's Go!");
			
			Scanner headOrTails = new Scanner(System.in); //retrieves guest for h/t
			System.out.println("Heads or tails? H/T");
			String x = headOrTails.nextLine();
			
			while (!(x.equals("h")||x.equals("H")||x.equals("t")||x.equals("T"))) { //checks for valid entry
					System.out.println("Sorry not an option. Heads or tails? H/T");
					x = headOrTails.nextLine();
			}
			playGame(x); //results of h/t are passed on to start game algorithm
			
		}
		else {
			System.out.println("Okay. :("); //player didn't want to play
		}
		
		
	}
	
}


