package enshu2_2019_11;

import java.io.*;import java.io.*;
import java.awt.*;

public class Dot extends Figure {//丸クラス
	int size ;
	Dot(){
		size = 10;
	}
	@Override public void paint(Graphics g) {
		if(color == 4) {		//colorの値が4ならば
			g.setColor(Color.green);
		}else if(color == 2) {	//colorの値が2ならば
			g.setColor(Color.red);
		}else if(color == 3) {	//colorの値が3ならば
			g.setColor(Color.blue);
		}else {					//それ以外の値のとき
			g.setColor(Color.black);
		}
		if(smear == 0) {		//値が0ならば
			g.drawOval(x - size/2, y - size/2, size,size);//枠線の丸を描写
		}else {					//それ以外のsmearの値のとき
			g.fillOval(x - size/2, y - size/2, size,size);//塗りつぶされた丸を描写
		}
	}
}