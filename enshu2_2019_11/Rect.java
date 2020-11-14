package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Rect extends Figure{// 四角クラス
	Rect(){}
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
		if(smear == 0) {		//枠線の四角を描写
			if (w > 0) {			// マウスを右に移動
				if (h>0) {				// マウスを下に移動
					g.drawRect( x, y , w , h);
				}else {					// マウスを上に移動
					g.drawRect( x, y+h, w , -h);
				}
			} else {				// マウスを左に移動
				if (h<0) {				// マウスを上に移動
					g.drawRect( x+w, y+h , -w , -h);
				}else {					// マウスを下に移動
					g.drawRect( x+w, y , -w , h);
				}
			}
		}else {					//塗りつぶした四角を描写
			if (w > 0) {			// マウスを右に移動
				if (h>0) {				// マウスを下に移動
					g.fillRect( x, y , w , h);
				}else {					// マウスを上に移動
					g.fillRect( x, y+h, w , -h);
				}
			} else {				// マウスを左に移動
				if (h<0) {				// マウスを上に移動
					g.fillRect( x+w, y+h , -w , -h);
				}else {					// マウスを下に移動
					g.fillRect( x+w, y , -w , h);
				}
			}
		}
	}
}
