package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Circle extends Figure{//‰~ƒNƒ‰ƒX
	Circle(){}
	@Override public void paint(Graphics g) {
		if(color == 4) {			//color‚Ì’l‚ª4‚È‚ç‚Î
			g.setColor(Color.green);
		}else if(color == 2) {			//color‚Ì’l‚ª2‚È‚ç‚Î
			g.setColor(Color.red);
		}else if(color == 3) {			//color‚Ì’l‚ª3‚È‚ç‚Î
			g.setColor(Color.blue);
		}else {						//‚»‚êˆÈŠO‚Ì’l‚Ì‚Æ‚«
			g.setColor(Color.black);
		}
		int r = (int)Math.sqrt((double)(w * w + h * h));//”¼Œa
		if(smear == 0) {
			g.drawOval(x - r, y - r, r * 2, r * 2);//˜gü‚Ì‰~‚ğ•`Ê
		}else {
			g.fillOval(x - r, y - r, r * 2, r * 2);//“h‚è‚Â‚Ô‚³‚ê‚½‰~‚ğ•`Ê
		}
	}
}
