package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Circle extends Figure{//円クラス
	Circle(){}
	@Override public void paint(Graphics g) {
		if(color == 4) {			//colorの値が4ならば
			g.setColor(Color.green);
		}else if(color == 2) {			//colorの値が2ならば
			g.setColor(Color.red);
		}else if(color == 3) {			//colorの値が3ならば
			g.setColor(Color.blue);
		}else {						//それ以外の値のとき
			g.setColor(Color.black);
		}
		int r = (int)Math.sqrt((double)(w * w + h * h));//半径
		if(smear == 0) {
			g.drawOval(x - r, y - r, r * 2, r * 2);//枠線の円を描写
		}else {
			g.fillOval(x - r, y - r, r * 2, r * 2);//塗りつぶされた円を描写
		}
	}
}
