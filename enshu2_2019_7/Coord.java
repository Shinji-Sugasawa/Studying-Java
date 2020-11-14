package enshu2_2019_7;

import java.awt.*;
import java.awt.Graphics;
public class Coord {
	int x,y;
	Coord(){
		x = y = 0;
		System.out.println(" x= " + x +" y= "+y);
	}
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public void moveto(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics g) {}
}
