package enshu_1;

public class kuku_jisaku {
	public static void main(String args[]) {
		int i,j,keisan;
		System.out.println("     1  2  3  4  5  6  7  8  9 ");
		System.out.println("-------------------------------");
		
		for(i=1;i<10;i++) {
			System.out.print(" " +i);
			System.out.print("|");
			
			for(j=1;j<10;j++) {
			
				keisan=i*j;
				
				if(keisan / 10 == 0) {
					System.out.print(" ");
				}
				
				
				System.out.print(" " +keisan );
			}
			System.out.println("");
				
			
		}
	}

}


