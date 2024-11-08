package prime;

public class PRIME {

	public static void main(String[] args) {
		Boolean[] prime = new Boolean[1000];
		prime[0] = false;
		prime[1] = false;
		for(int i = 2; i<1000; i++) {
			prime[i] = true;
		}

		for(int i = 2;i<1000;i++) {
			if(prime[i]) {
				for(int j = i+i;j<1000;j+=i) {
					prime[j]=false;
				}
			}
		}
		
		for(int i =0;i<1000;i++) {
		  if(prime[i]) {
			 System.out.printf("%d ",i);
		  }
		}
	}
}
