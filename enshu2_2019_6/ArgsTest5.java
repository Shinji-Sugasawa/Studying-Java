package enshu2_2019_6;

public class ArgsTest5 {
	int no;
	public static void main(String args[]) {
		int i = 1832999;
		ArgsTest5 kodai = new ArgsTest5();
		setNo(kodai,i);
		
		System.out.println("1: no = " + kodai.no+" i = "+ i);
		
		setNo(kodai,1832888);
		
		System.out.println("2: no = " + kodai.no + " i = " + i);
	}
	public static void setNo(ArgsTest5 student ,int no) {
		student.no = no;
		student.no++;
		student = new ArgsTest5();
		student.no = 1832777;
	
	}
	


}
