package enshu2_2019_6;

public class ArgsTest6 {
	int no;
	static int count = 0;
	public static void setNo(ArgsTest6 student, int p_no) {
		student.no = p_no;
		student.no++;
		student = new ArgsTest6();
	}
	ArgsTest6(){
		count++;
	}

}
