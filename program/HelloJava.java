package program;

public class HelloJava {
	public static void sub(int y) {

		for(int x = 1;x<10;x++) {
			if(x * y < 10) {
				System.out.print(" "+ x * y+ " ");
			}else {
				System.out.print(x*y+" ");
			}
		}
	}

	public static void main (String args[]) {

		for(int i = 1; i<10 ; i++) {
			sub(i);
			System.out.println();
		}
	}

}
