package enshu2_2019_8;

import java.awt.*;
import java.awt.Color;
import java.util.Scanner;

public class Circle extends Figure {
	int size ;
	Circle(){
		//System.out.print("�l�p�`�̑傫���́H: ");		
		//Scanner scan = new Scanner(System.in);
		//size = scan.nextInt();
		size = 200;
		//System.out.println("Circle�N���X�F�̉~");
	}		
	@Override public void paint (Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(x - size/2, y - size/2, size,size);
	}
}
