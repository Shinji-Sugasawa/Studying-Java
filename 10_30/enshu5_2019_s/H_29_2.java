package enshu5_2019_s;

public class H_29_2 {
	public static void main (String args[]) {
		H_29 kodai = new H_29();
		kodai .setNo(1832999);
		kodai .name = "H‘å@‘¾˜Y";
		kodai.year = 2;
		kodai.grade = 80;
		
		showGrade(kodai);	
	}
	public static void showGrade(H_29 data) {
		System.out.print("No: " +data.getNo()+" "+data.name+" "+data.grade+" "+data.department);	
	} 
}
