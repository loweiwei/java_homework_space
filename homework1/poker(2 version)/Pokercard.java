package java_hw1_7_31_shufflinganddealingofcard;
import java.util.Random;

public class Pokercard {

	public static void main(String[] args) {
		deckofcard allcard = new deckofcard();
		
		allcard.suffle();
		card[] hand5_1 = new card[5];
		card[] hand5_2 = new card[5];
		hand5_1 = allcard.given_five_card();
		hand5_2 = allcard.given_five_card();
		System.out.printf("\n<hand5_1>\n");
		for(int i = 0;i<5;i++) {
			System.out.printf("%s\n",hand5_1[i]);
		}
		System.out.printf("\n<hand5_2>\n");
		for(int i = 0;i<5;i++) {
			System.out.printf("%s\n",hand5_2[i]);
		}
		System.out.printf("\n<hand1 suit and face caculate:>");
		handcardevaluator evaluator1 = new handcardevaluator(hand5_1);
		evaluator1.showfaceandsuitnumber();
		
		System.out.printf("\n\n<hand2 suit and face caculate:>");
		handcardevaluator evaluator2 = new handcardevaluator(hand5_2);
		evaluator2.showfaceandsuitnumber();
		
		if( evaluator1.thebiggestcard() > evaluator2.thebiggestcard()) {
			System.out.printf("\n\n{hand5_1 is bigger than hand5_2}\n");
		}else if(evaluator1.thebiggestcard() < evaluator2.thebiggestcard()) {
			System.out.printf("\n\n{hand5_2 is bigger than hand5_1}\n");
		}else {
			System.out.printf("\n\n{hand5_2 is as large as hand5_1}\n");
		}
	}
}





class card{
	private String face;
	private String suit;
	
	public card(String face,String suit) {
		this.face = face;
		this.suit = suit;
	};
	
	public String toString() {
		return face + " of " + suit;
	}
	
	public String getsuit() {
		return suit;
	}
	public String getface() {
		return face;
	}
}





//發牌 洗牌 配排
class deckofcard{
	private int max_size = 52;
	private card[] deck = new card[max_size];
	private int givencard = 0;
	private Random rand = new Random();
	public deckofcard() {
		givencard = 0;
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        
        for(int i = 0;i<max_size;i++) {
        	deck[i] = new card(faces[i%13],suits[i%4]);
        }
	}
	
	public void suffle() {
		givencard = 0;
		int randnum;
		card temp ;
		for(int i = 0;i<max_size;i++) {
			randnum = rand.nextInt(52);
			
			temp = deck[i];
			deck[i] = deck[randnum];
			deck[randnum] = temp;
		}
	}
	
	public card give_one_card() {
		if(givencard < max_size) {
			return deck[givencard++];
		}else {
			return null;
		}
		
	}
	public card[] given_five_card() {
		card[] five_card = new card[5];
		int i = 0;
		while( givencard<max_size &&i<5) {
			five_card[i] = deck[givencard];
			i++;
			givencard++;
		}
		if(givencard>=max_size) {
			return null;
		}
		return five_card;
	
	}
	
}





class handcardevaluator{
	private card[] handcard5 = new card[5];
	private int[] face_count = new int[13];
	private int[] suit_count = new int[4];
	
	
	String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
	public handcardevaluator(card[] handcard) {
		 
		handcard5 = handcard;
		for(int i=0;i<5;i++) {
			for(int j = 0;j<13;j++) {
				if(handcard5[i].getface() == faces[j]) {
					face_count[j]++;
					break;
				}
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j = 0;j<4;j++) {
				if(handcard5[i].getsuit() == suits[j]) {
					suit_count[j]++;
					break;
				}
			}
		}
	}
	
	public void showfaceandsuitnumber() {
		System.out.printf("\n<ALL 5 FACES>:\n");
		for(int i = 0;i<13;i++) {
			if(face_count[i]>0) {
				
				System.out.printf("%s * %d ||", faces[i],face_count[i]);
			}
		}
		
		System.out.printf("\n<ALL 5 SUIT>:\n");
		for(int i = 0;i<4;i++) {
			if(suit_count[i]>0) {
				System.out.printf(" %s * %d ||", suits[i],suit_count[i]);
			}
		}
	}
	
	public int a_pair() {
		int count = 0;
		for(int i = 0;i<13;i++) {
			if(face_count[i]==2) {
				count++;
			}
		}
		if(count != 1) {
			return 0;
		}
		return 1;
	}
	
	public int two_pair() {
		int count = 0;
		for(int i = 0;i<13;i++) {
			if(face_count[i]==2) {
				count++;
			}
		}
		if(count != 2) {
			return 0;
		}
		return 2;
	}
	
	public int three_of_a_kind() {
		int count = 0;
		for(int i = 0;i<13;i++) {
			if(face_count[i] == 3) {
				count = 1;
				break;
			}
		}
		if(count !=1) {
			return 0;
		}
		return 3;
	}
	
	public int four_of_a_kind() {
		
		int count = 0;
		for(int i = 0;i<13;i++) {
			if(face_count[i] >=1) {
				count ++;
				if(count ==5) {
					return 4;
				}
			}
			else {
				count = 0;
			}
		}
		return 0;
	}
	
	public int a_flush() {
		for(int i = 0;i<4;i++) {
			if(suit_count[i] ==5) {
				return 5;
			}
		}
		return 0;
	}
	
	public int a_straight() {
		
		if(three_of_a_kind() == 4) {
			if(a_pair() == 1) {
				return 6;
			}
		}
		return 0;
	}
	
	public int a_full_house() {
		for(int i = 0;i<13;i++) {
			if(face_count[i] ==4) {
				return 7;
			}
		}
		return 0;
	}
	
	
	public int thebiggestcard() {
		if(a_full_house() == 7) {
			System.out.printf("a_full_house\n");
			return 7;
		}else if(a_straight() == 6) {
			System.out.printf("a_straight\n");
			return 6;
		}else if(a_flush() == 5) {
			System.out.printf("a_flush\n");
			return 5;
		}else if(four_of_a_kind() == 4) {
			System.out.printf("four_of_a_kind\n");
			return 4;
		}else if(three_of_a_kind() == 3) {
			System.out.printf("three_of_a_kind\n");
			return 3;
		}else if(two_pair() == 2) {
			System.out.printf("two_pair\n");
			return 2;
		}else if(a_pair() == 1) {
			System.out.printf("a_pair\n");
			return 1;
		}
		return -1;
	}
}

