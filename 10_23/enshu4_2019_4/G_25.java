package enshu4_2019_4;

public class G_25 {
	
	public static void main (String args[]) {
		CItStudent kodai = new CItStudent();
		kodai.no=1832999;
		kodai.name="工大　太郎";
		kodai.year= 2;
		kodai.grade=80;
		kodai.department = (kodai.no/1000)%10;
		
		showGrade(kodai);
	}
	public static void showGrade(CItStudent data) {
		
		System.out.print("NO: " +data.no+"" + data.name+"　"+data.grade);//+""+data.department);
		if(data.department == 1) {
			System.out.print("　情報工学科");
		}
		else {
			System.out.print("　情報ネットワーク学科");
		}
	
	}
}