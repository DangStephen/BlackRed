/*

created by : Stephi Tyler
date:        9/8/21

*/

public class Card {
	
	private String suit = "";
	private String weight = "";
	
	public String getSuit(){ // returns the suit
		return suit;
	}
	
	public String getWeight(){ // returns weight
		return weight;
	}
	
	public String readCard() { // returns both suit and weight of card
		return this.weight + " " + this.suit;
	}
	
	public String getColor() { // returns color of card
		String color = "";
		
		if (((this.suit.equals("H red"))||(this.suit.equals("D red"))) == true) {
			color = "red";
		}
		else {
			color = "black";
		}
		
		return color;
	}
	
	public void setSuit(String s) { //set the suit of card
		this.suit = s;
	}
	
	public void setWeight(String w) { //set weight of card
		this.weight = w;
	}
	
	public Card createCard(String w, String s) { // creates and returns card object
		Card c = new Card();
		
		c.setSuit(s);
		c.setWeight(w);
		
		return c;
	}
	
	public boolean compareCard(Card c1) { // compares suit and weight of card to check if they are the same
		if ((c1.getWeight() == this.getWeight())&&(c1.getSuit() == this.getSuit())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	    Card c = new Card();
	    c=c.createCard("A","D red");
	    
	    Card b = new Card();
	    b=b.createCard("A", "H red");
	    
	    Card a = new Card();
	    a=a.createCard("A", "H red");
	    
//	    c.getSuit();
//	    c.getWeight();
//	    System.out.println("Card C color "+ c.getColor());
//	    
//	    a.getSuit();
//	    a.getWeight();
//	    System.out.println("Card A color "+ a.getColor());

	    System.out.println("Card A: " + a.getSuit() + " " + a.getWeight());
	    System.out.println("Card B: " + b.getSuit() + " " + b.getWeight());
	    System.out.println("Card C: " + c.getSuit() + " " + c.getWeight());
//	    
//	    System.out.println("...");
//
//	    System.out.println("Card A and B");
	    a.compareCard(b);
//	    System.out.println(a.compareCard(b));
//	    System.out.println("...");
//
//	    System.out.println("Card A and C");
	    a.compareCard(c);
//	    System.out.println(a.compareCard(c));
//	    System.out.println("...");
//
//	    System.out.println("Card B and C");
	    b.compareCard(c);
//	    System.out.println(b.compareCard(c));
//	    System.out.println("...");

	    System.out.println(a.readCard());
	    System.out.println(b.readCard());
	    System.out.println(c.readCard());
	}
	
}
