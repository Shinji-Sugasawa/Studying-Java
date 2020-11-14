package enshu2_2019_2;

import java.awt.print.Printable;

public class kuku {
	public static void main(String args[]) {
		int x,k,y;
		
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
		
		System.out.println();
		
		for(y=1;y<10;y++) {
			System.out.println();
			System.out.print(" "+y);
			System.out.print("|");
		
			for(x=1;x<10;x++) {
				if(x>=y) {
					if(x*y<10) {
						System.out.print(" "+ x*y+" ");
					}else {
						System.out.print( x*y + " ");
					}
					}else {
						System.out.print("   ");
					}
				}
			}
		}
	}

				