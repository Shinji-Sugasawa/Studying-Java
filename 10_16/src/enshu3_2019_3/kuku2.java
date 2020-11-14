package enshu3_2019_3;

public class kuku2 {
	
	public static void main(String args[]){
		int x,y,v,w;
		y = 1;
		while(y < 10){
			for(x = 1;x < 10; x++) {
				v = x * y;
				if(v < 10)   System.out.print(" " + v + " ");
				else if(v < 16)  System.out.print(" "+(char)('A'+ v - 10)+" ");
				else {
					w = v / 16;
					v = v % 16;
					if(w < 10) System.out.print(w);
					else     System.out.print((char)('A'+ w - 10));
					if(v < 10) System.out.print( v + " ");
					else     System.out.print((char)('A' + v - 10)+" ");
				}
			}
			System.out.println();
			y++ ;
		}
	}
}



