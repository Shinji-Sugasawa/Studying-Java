package enshu5_2019_s;

public class H_30 {
	int no;
	String name;
	int year;
	int grade;
	int department ;
	public void setNo(int p_no) {
		no = p_no;
		department = p_no;
		department = (p_no/1000)%10;
	}
	public int getNo() {
		return no;
	}
	public void setYear(int p_year) {
		year = p_year;
	}
	public int getYear() {
		return year;
	}
	public void setGrade(int p_grade) {
		grade = p_grade;
	}
	public int getGrade() {
		return grade;
	}
	public void setName(String p_name) {
		name = p_name;
	}
	public String getName(){
		return name;
	}

}
