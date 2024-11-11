package poker;

public class Card {

	private String face;
	private String suit;
	
	
	public Card(String face,String suit) {
		this.suit = suit;
		this.face = face;
	}


	public String toString() {
		return face +" of "+suit;
	}
	
	public String getFace() {
		return face;
	}


	public void setFace(String face) {
		this.face = face;
	}


	public String getSuit() {
		return suit;
	}


	public void setSuit(String suit) {
		this.suit = suit;
	}

}
