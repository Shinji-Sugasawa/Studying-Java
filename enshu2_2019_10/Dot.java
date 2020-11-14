package enshu2_2019_10;

import java.awt.Graphics;

class Dot extends Figure {
	int size ;
	Dot(){
		size = 10;
	}		
	@Override public void paint(Graphics g) {
		g.drawOval(x - size/2, y - size/2, size,size);
	}
}