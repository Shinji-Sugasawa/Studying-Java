package houteisiki;

public class Newton {

	double func_y(double x) {

        return Math.pow(x, 3)+ x -1.0;//求めたい方程式
	}
	double func_z(double x) {

		return 3.0*x*x + 1.0;
	}
	double syori(double a, double eps) {
		int i = 1;
		double b = .0;

		while(0<i) {
			b = a-func_y(a) / func_z(a);

        	System.out.println( i+ ":" + b );//計算出力

			if( Math.abs( b - a ) < eps) {

	        	System.out.println("\n近似解" + b );//結果表示
				break;
			}
			else{
				a = b;
			}
			i++;
		}
		return b;
	}
	public static void main (String[] args){
        Newton kai = new Newton();

        double eps = 0.0001;//許容誤差 //例0.000001;
        double a = 1.0;

        double ans = kai.syori(a, eps);// 解を計算(初期値, 収束条件)
    }
}
