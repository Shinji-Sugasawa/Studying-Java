package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Line extends Figure {//線クラス
	Line(){}
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
		g.drawLine(x , y , x + w , y + h);//線を描写
	}
}
