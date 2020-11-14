package program;

public class pi {
	public static void main (String args[]) {
		double k = 1.0;
		double pi =0.0;
		for(int i = 1;i<=100000;i++) {
			pi = 4*k;
			System.out.println(" "+ i +" : "+ pi);
			if(i % 2 == 0) {
				k += 1.0 / ( 2.0 * i + 1.0);
			} else {
				k -= 1.0 / ( 2.0 * i + 1.0);
			}
		}
	}
}
