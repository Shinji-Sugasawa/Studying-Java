package enshu3_2019_3;

public class kuku3 {
	
	public static void main(String args[]){
		int x,y,v,w;
		y = 1;
		while(y < 10){
			for(x = 1;x < 10; x++) {
				v = x * y;
				
				if (v<16) {
					System.out.print(" ");
					printHex(v);
					System.out.print(" ");
				}
				
				else {
					w = v / 16;
					v = v % 16;
					 printHex(w);

						printHex(v);
						System.out.print(" ");
					    
					}
				}
			System.out.println();
			y++;
		}
	}

		public static void printHex(int v) {
			if(v<10) System.out.print(v);
			else     System.out.print((char)('A' + v - 10));
		}
}