package enshu2_2019_6;

public class ArgsTestMain {
	public static void main(String args[]) {
		int i = 1832999;
		ArgsTest6 kodai = new ArgsTest6();
		ArgsTest6.setNo(kodai,i);
		System.out.println("1: no = " + kodai.no + " i = " + i+" count = "+ArgsTest6.count);
		ArgsTest6.setNo(kodai,1832888);
		System.out.println("2: no = " + kodai.no + " i = " + i+" count = "+ArgsTest6.count);
		//ArgsTest6.setNo(kodai,1832888);
		//System.out.println("2: no = " + kodai.no + " i = " + i+" count = "+ArgsTest6.count);
	}

}
