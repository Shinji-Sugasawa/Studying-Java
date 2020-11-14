package enshu3_2019_3;

public class F_21 {
	public static void main(String args[]){
		int x,y,v;
		y = 1;
		while(y < 16){
			for(x = 1;x < 16; x++) {
				v = x * y;
				if(v<16) {
					printHex3(v,3);
					System.out.print(" ");
				}else {
					printHex3(v,3);
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
		public static void printHex2(int v) {
			
			printHex(v / 16);
			//System.out.println();
			printHex(v % 16);
			System.out.print(" ");	
		}
		public static void printHex3 (int v,int n) {
			int i,x = 1,w;
			for ( i=1; i<n; i++) x=x*16;
			for(i=0;i<n;i++) {
				//System.out.println("x="+x);//‰Û‘èE20
				w = v / x;
				//System.out.println();
				v = v % x;
				printHex(w);
				x = x / 16;
			}
		}
}



