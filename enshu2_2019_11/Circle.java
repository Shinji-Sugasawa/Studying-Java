package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Circle extends Figure{//�~�N���X
	Circle(){}
	@Override public void paint(Graphics g) {
		if(color == 4) {			//color�̒l��4�Ȃ��
			g.setColor(Color.green);
		}else if(color == 2) {			//color�̒l��2�Ȃ��
			g.setColor(Color.red);
		}else if(color == 3) {			//color�̒l��3�Ȃ��
			g.setColor(Color.blue);
		}else {						//����ȊO�̒l�̂Ƃ�
			g.setColor(Color.black);
		}
		int r = (int)Math.sqrt((double)(w * w + h * h));//���a
		if(smear == 0) {
			g.drawOval(x - r, y - r, r * 2, r * 2);//�g���̉~��`��
		}else {
			g.fillOval(x - r, y - r, r * 2, r * 2);//�h��Ԃ��ꂽ�~��`��
		}
	}
}
