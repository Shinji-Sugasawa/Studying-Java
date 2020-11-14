package hello;

public class Mul5 {
	public static void main(String args[]) {
		int j=0;
		for(int i=1 ; i <= 100 ; i++) {
			if(i % 5 == 0) {
				j++;
				if(j<10) {
					if(i<10) {
						System.out.print("   "+i);
					}else if(i>=100){
						System.out.print(" "+i);
					}else {
						System.out.print("  "+i);
					}
				}else {
					if(i<10) {
						System.out.println("   "+i);
					}else if(i>=100){
						System.out.println(" "+i);
					}else {
						System.out.println("  "+i);
					}
					j=0;
				}
			}
		}
	}
}
