package enshu2_2019_10;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Paint3 extends Frame implements MouseListener,
										MouseMotionListener,ActionListener {
	int x, y ;
	ArrayList<Figure>objList;
	CheckboxGroup cbg;
	Checkbox c1,c2,c3,c4;
	Button end;
	int mode = 0;
	Figure obj;
	public static void main(String args[]) {
		Paint3 f = new Paint3();
		f.setSize(640,480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
	}
	Paint3(){
		objList = new ArrayList<Figure>();
		
		setLayout(null);
		cbg = new CheckboxGroup();
		c1 = new Checkbox( "ä€" , cbg,true);
		c1.setBounds(560,30,60,30);
		add(c1);
		c2 = new Checkbox( "â~" , cbg,false);
		c2.setBounds(560,60,60,30);
		add(c2);
		c3 = new Checkbox( "éläp" , cbg, false);
		c3.setBounds(560,90,60,30);
		add(c3);
		c4 = new Checkbox( "ê¸" , cbg,false);
		c4.setBounds(560,120,60,30);
		add(c4);
		end = new Button( "èIóπ" );
		end.setBounds (560,300,60,30);
		add(end);

		addMouseListener(this);
		addMouseMotionListener(this);
		
		end.addActionListener(this);
	}
	@Override public void paint(Graphics g) {
		Figure f;
		for (int i = 0; i< objList.size();i++) {
			f = objList.get(i);
			f.paint(g);
		}
		if ( mode >= 1) obj.paint(g) ;
	}
	@Override public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	@Override public void mousePressed(MouseEvent e) {
		Checkbox c;
			x = e.getX();
			y = e.getY();
			c = cbg.getSelectedCheckbox();
			obj = null;
			if(c== c1) {
				mode = 1;
				obj = new Dot();
			} else if(c == c2) {
				mode = 2 ;
				obj = new Circle();
			} else if(c == c3) {
				mode = 2 ;
				obj = new Rect();
			} else if(c == c4) {
				mode = 2 ;
				obj = new Line();
			}
			 if(obj != null) {
				obj.moveto(x,y);
				repaint();
			 }	
	}
	@Override public void mouseReleased(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if(mode ==1)	obj.moveto(x,y);
			else if (mode == 2)	obj.setWH(x - obj.x, y - obj.y);
			if(mode >= 1) {
				objList.add(obj);
				obj = null;
			}
			mode = 0;
			repaint();
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(mode ==1) {
			obj.moveto(x,y);
		} else if (mode == 2) {
			obj.setWH(x - obj.x, y - obj.y);
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}
}