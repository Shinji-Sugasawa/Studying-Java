package enshu2_2019_11;

import java.io.*;import java.io.*;
import java.awt.*;

public class Dot extends Figure {//�ۃN���X
	int size ;
	Dot(){
		size = 10;
	}
	@Override public void paint(Graphics g) {
		if(color == 4) {		//color�̒l��4�Ȃ��
			g.setColor(Color.green);
		}else if(color == 2) {	//color�̒l��2�Ȃ��
			g.setColor(Color.red);
		}else if(color == 3) {	//color�̒l��3�Ȃ��
			g.setColor(Color.blue);
		}else {					//����ȊO�̒l�̂Ƃ�
			g.setColor(Color.black);
		}
		if(smear == 0) {		//�l��0�Ȃ��
			g.drawOval(x - size/2, y - size/2, size,size);//�g���̊ۂ�`��
		}else {					//����ȊO��smear�̒l�̂Ƃ�
			g.fillOval(x - size/2, y - size/2, size,size);//�h��Ԃ��ꂽ�ۂ�`��
		}
	}
}