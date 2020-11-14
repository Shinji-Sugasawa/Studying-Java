package enshu5_2019_s;

public class H_30_2 {
	public static void main (String args[]) {
		H_30 kodai = new H_30();
		kodai.setNo(1832999);
		kodai.setName ("H‘å@‘¾˜Y");
		kodai.setYear (2);
		kodai.setGrade (80);
		showGrade(kodai);	
	}
	public static void showGrade(H_30 data) {
		System.out.print("No: " +data.getNo()+" "+data.getName()+" "+data.getGrade()+" "+data.department);	
	} 
}
