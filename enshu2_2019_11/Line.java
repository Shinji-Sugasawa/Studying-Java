package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Line extends Figure {//���N���X
	Line(){}
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
		g.drawLine(x , y , x + w , y + h);//����`��
	}
}
