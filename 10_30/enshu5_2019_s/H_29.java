package enshu5_2019_s;

public class H_29 {
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

	}

