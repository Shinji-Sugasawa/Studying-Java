package enshu5_2019_s;

public class CitStudent2 {
	int no;
	String name;
	int year;
	int grade;
	int department;
	CitStudent2(){
		no = year = grade = department = 0;
		name = "";
	}
	CitStudent2(int p_no,String p_name){
		no = p_no;
		name = p_name;
		year = grade = department = 0;
	}
	public void setNo(int p_no) {
		no = p_no;
	}
	public int getNo() {
		return no;
	}
}

