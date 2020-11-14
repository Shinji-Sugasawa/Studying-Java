package enshu2_2019_10;

import java.awt.Graphics;

class Rect extends Figure {
	Rect(){}
	@Override public void paint(Graphics g) {
		g.drawRect( x, y , w , h);
	}
}