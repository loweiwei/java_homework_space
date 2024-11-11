package poker;
import java.util.Random;
public class DeckOfCards {
	Random random = new Random();
	private final int max_size = 52;
	private Card[] deck=new Card[max_size];
	private int givencard = 0;
	private static final String[] faces= {"ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
	private static final String[] suits = {"HEARTS","DIMONDS","CLUBS","SPARES"};
	public DeckOfCards() {
		givencard = 0;
		for(int i = 0;i<max_size;i++) {
			deck[i] = new Card(faces[i%13],suits[i%4]);
		}
	}
	public void suffling() {
		givencard = 0;
		for(int i =0;i<max_size;i++) {
			int k = random.nextInt(52);
			Card temp = deck[k];
			deck[k] = deck[i];
			deck[i] = temp;
		}
	}
	public Card give_one_card() {
		if(givencard>=max_size) {
			return null;
		}
		return deck[givencard++];
	}
	public Card[] given_five_card() {
		Card[] hand5 = new Card[5];
		int count = 0;
		for(int i = 0;i<5;i++) {
			if(givencard >= 52) {
				System.out.printf("have no card for five card\n");
				return null;
			}else {
				hand5[i] = deck[givencard++];
			}
		}
		return hand5;
		
	}
	
	public int evaluator(Card[] target) {
		int[] facecount = new int[faces.length];
		int[] suitcount = new int[suits.length];
		for(int i =0;i<target.length;i++) {
			for(int j = 0;j<faces.length;j++) {
				if(target[i].getFace() == faces[j]) {
					facecount[j] ++;
				}
			}
			for(int j = 0;j<suits.length;j++) {
				if(target[i].getSuit() == suits[j]) {
					suitcount[j] ++;
				}
			}
		}
		System.out.printf("{face count}\n");
		for(int j = 0;j<faces.length;j++) {
			if(facecount[j] != 0) {
				System.out.printf("%s *%d\n", faces[j],facecount[j]);
			}
		}
		
		System.out.printf("{suit count}\n");
		for(int j = 0;j<suits.length;j++) {
			if(suitcount[j] != 0) {
				System.out.printf("%s *%d\n", suits[j],suitcount[j]);
			}
		}
		return card_math(facecount,suitcount);
	}
	public int card_math(int[] facecount,int[] suitcount) {
		int count = 0;
		int count2 = 0;
		boolean apair = false,twopair = false ,threeofkind =false,fourofkind = false,aflush = false,astraight = false,afullhouse = false;
		
		for(int i : facecount) {
			if( i ==1) {
				count2++;
			}else {
				count2 = 0;
			}
			if(i == 2) {
				count++;
			}if(i == 3) {
				threeofkind = true;
			}if(i == 4) {
				fourofkind = true;
			}
			
		}
		for(int j:suitcount) {
			if(j == 5) {
				aflush = true;
			}
		}
		if(count2 == 5) {
			astraight = true;
		}
		if(count == 1) {
			apair = true;
		}
		if(count ==2) {
			twopair = true;
		}
		if(apair && threeofkind) {
			afullhouse = true;
		}
		
		
		if(fourofkind) {
			System.out.printf("[fourofkind]\n");
			return 8;
		}else if(aflush) {
			System.out.printf("[aflush]\n");
			return 7;
		}else if(afullhouse) {
			System.out.printf("[afullhouse]\n");
			return 6;
		}else if(astraight) {
			System.out.printf("[astraight]\n");
			return 5;
		}else if(threeofkind) {
			System.out.printf("[threeofkind]\n");
			return 3;
		}else if(twopair) {
			System.out.printf("[twopair]\n");
			return 2;
		}else if(apair) {
			System.out.printf("[apair]\n");
			return 1;
		}else {
			System.out.printf("[no match]\n");
			return -1;
		}
	}

}
