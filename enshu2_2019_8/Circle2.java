package enshu2_2019_8;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class Circle2 extends Figure {
	int size;
	Circle2(){
		//System.out.print("�~�̑傫���́H: ");		
		//Scanner scan = new Scanner(System.in);
		//size = scan.nextInt();
		size = 150;
		//System.out.println("Circle2�N���X�F�Ԃ̉~");	
	}
	@Override public void paint (Graphics g) {
		g.setColor(Color.red);
		g.drawOval(x - size/2, y - size/2, size,size);
	}
}
