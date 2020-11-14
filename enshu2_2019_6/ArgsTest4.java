package enshu2_2019_6;

public class ArgsTest4 {
	int no;
	public static void main(String args[]) {
		int i = 1832999;
		ArgsTest4 kodai = new ArgsTest4();
		kodai.setNo(i);
		System.out.println("1: no = " + kodai.no+" i = "+ i);
		kodai.setNo(1832888);
		System.out.println("2: no = " + kodai.no + " i = " + i);
	}
	public void setNo(int no) {
		this.no = no;
		//no++;
	}


}
