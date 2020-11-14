package enshu2_2019_8;

import java.util.*;
import java.awt.*;
import java.awt.event.*;


class Paint2 extends Frame implements MouseListener,MouseMotionListener{
	int x, y ;
	ArrayList<Figure>objList;
	Figure obj;
	public static void main(String args[]) {
		Paint2 f = new Paint2();
		f.setSize(640,480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
		Coord c = new Circle();
		Coord d = c;
		c.x = 100;
		System.out.println("c.x = " + c.x);
		System.out.println("d.x = " + d.x);
	}

	int count = 1;
	Paint2(){
		objList = new ArrayList<Figure>();

		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override public void paint(Graphics g) {
		Figure f;
		for (int i = 0; i< objList.size();i++) {
			f = objList.get(i);
			f.paint(g);
		}
		if ( obj != null) obj.paint(g) ;
	}
	@Override public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(count>5) {
				objList.remove(0);
			}
			if(count %2==0) {
				obj = new Circle();
				//System.out.println("100");
			}
			else{
				obj = new Circle2();
				//System.out.println("150");
			}
			System.out.println("Count :"+count);
			obj.moveto(x,y);
			objList.add(0,obj);
			repaint();
	}
	@Override public void mouseReleased(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(count>5) {
				objList.remove(0);
			}
			obj.moveto(x,y);
			objList.add(obj);
			obj = null;
			repaint();
			count++;
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if (obj != null) obj.moveto(x,y);
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}
}