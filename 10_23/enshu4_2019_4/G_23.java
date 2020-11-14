package enshu4_2019_4;

public class G_23 {
	public static void main (String args[]) {
		CItStudent kodai = new CItStudent();
		kodai.no=1832999;
		kodai.name="H‘å@‘¾˜Y";
		kodai.year= 2;
		kodai.grade= 80;
		showGrade(kodai);
	}
	public static void showGrade(CItStudent data) {
		
		System.out.println("NO: " +data.no+"" + data.name+""+data.grade);
	}		
}
