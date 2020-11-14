package enshu5_2019_s;

public class H_28_2 {
	public static void main (String args[]) {
		CitStudent2 kodai = new CitStudent2();
		kodai.setNo(1832999);
		kodai.name = "H‘å@‘¾˜Y";
		kodai.year = 2;
		kodai.grade = 80;
		showGrade(kodai);	
	}
	public static void showGrade(CitStudent2 data) {
		System.out.println("No: " +data.getNo()+""+data.name+""+data.grade);
	}

}


