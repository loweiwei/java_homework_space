package poker;

public class Card_test {

	public static void main(String[] args) {
		DeckOfCards myvcard = new DeckOfCards();
		Card[] handfive =new Card[5];
		Card[] handfive2 =new Card[5];
		
		myvcard.suffling();
		for(int i = 0;i<52;i++) {
			System.out.printf("[%d] %s\n",i+1,myvcard.give_one_card() );
		}
		myvcard.suffling();
		handfive =myvcard.given_five_card();
		handfive2 =myvcard.given_five_card();
		System.out.printf("<handfive evaluate:>\n");
		int a = myvcard.evaluator(handfive);
		
		System.out.printf("\n\n<handfive2 evaluate:>\n");
		int b = myvcard.evaluator(handfive2);
		System.out.printf("compare two hand:\n");
		
		if(a>b) {
			System.out.printf("handfivebig\n");
		}else if(a<b) {
			System.out.printf("handfive2big\n");
		}else if(a == b) {
			System.out.printf("same\n");
		}

	}

}
