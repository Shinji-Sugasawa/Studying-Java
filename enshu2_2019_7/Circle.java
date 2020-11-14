package enshu2_2019_7;
import java.awt.*;
import java.awt.Graphics;

public class Circle extends Coord {
	int color, size;
	Circle(){
		//System.out.println("Coord");
	color = 0;
	size = 100;
	}
	@Override public void paint(Graphics g) {
		g.drawOval(x - size/2, y - size/2,size,size);
	}
	//@Override public void move(int dx,int dy) {
		//x -= dx;
		//y -= dy;
	//}
}
