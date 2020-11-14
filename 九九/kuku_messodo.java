package enshu2_2019_2;

public class kuku_messodo {
	public static void main(String args[]) {
		int x,k,y,z;


		System.out.print("  ");

		for(k=1;k<10;k++) {
			if(k==9) {
				System.out.println("  " +k );
				break;
			}
			System.out.print("  "+ k);
		}

		for(k=0;k<29;k++) {
		System.out.print("-");
		}
		z = 1;

		for(z=1;z<10;z++) {
			System.out.println();
			System.out.print(" "+z);
			System.out.print("|");

			sub(z);
			sub(z);

		}


	}
			public static void sub(int z) {
				int x;
			for(x=1;x<10;x++) {
				if(x>=z) {
					if(x*z<10) {
						System.out.print(" "+ x*z+" ");
					}else {
						System.out.print( x*z + " ");
					}
					}else {
						System.out.print("   ");
					}
				}
			}
		}




