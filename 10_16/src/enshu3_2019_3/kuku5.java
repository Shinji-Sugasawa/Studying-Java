package enshu3_2019_3;

public class kuku5 {
	public static void main(String args[]){
		int x,y,v;
		y = 1;
		while(y < 16){
			for(x = 1;x < 16; x++) {
				v = x * y;
				if(v<16) {
					printHex2(v);
				}else {
					printHex2(v);
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
		public static void printHex2(int v) {
			
			printHex(v / 16);
			printHex(v % 16);
			System.out.print(" ");	
			
		}
}

