package houteisiki;

public class Nibunhou {

	double func_y(double x){
        return Math.pow(x, 3)+ x -1.0;//求めたい方程式
    }//Math.pow(x.指数)　＜＝ xの指数乗を表している。

    double syori(double a, double b, double eps){
        int i=1;
        double c=.0;

        while(Math.abs(a-b)>eps) {

        	c = (a+b)/2.0;
        	System.out.println( i+ ":" +c );//計算回数出力

            if(func_y(c) * func_y(a)<0) {
            	b = c;
            }
            else {
            	a = c;
            	}
            i++;

        }
        return c;
    }

        public static void main (String[] args) {
            Nibunhou kai = new Nibunhou();

            double eps = 0.0001;//許容誤差 //例0.000001;
            double a = 0.0, b = 1.0;

            double ans = kai.syori(a, b, eps);//(初期値,許容誤差)

    		System.out.println("\n近似解:" +ans);// 結果表示
        }
}
