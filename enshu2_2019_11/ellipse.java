package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class ellipse extends Figure {//�ȉ~�N���X
	ellipse(){}


	@Override public void paint(Graphics g) {
		if(color == 4) {			//color�̒l��4�Ȃ��
			g.setColor(Color.green);
		}else if(color == 2) {			//color�̒l��4�Ȃ��
			g.setColor(Color.red);
		}else if(color == 3) {			//color�̒l��4�Ȃ��
			g.setColor(Color.blue);
		}else {						//����ȊO�̒l�̂Ƃ�
			g.setColor(Color.black);
		}
		if(smear == 0) {		//�g���̎l�p��`��
			if(w>0) {				// �}�E�X���E�Ɉړ�
				if(h>0) {				// �}�E�X�����Ɉړ�
					g.drawOval(x - w, y - h, w * 2, h * 2);
				} else {				// �}�E�X����Ɉړ�
					g.drawOval(x - w, y + h, w * 2, -h * 2);
				}
			}else {					// �}�E�X�����Ɉړ�
				if(h<0) {				// �}�E�X����Ɉړ�
					g.drawOval(x + w, y + h, -w * 2, -h * 2);
				}else {				// �}�E�X�����Ɉړ�
					g.drawOval(x + w, y - h, -w * 2, h * 2);
				}
			}
		}else {					//�h��Ԃ����l�p��`��
			if(w>0) {				//�}�E�X���E�Ɉړ�
				if(h>0) {				//�}�E�X�����Ɉړ�
					g.fillOval(x - w, y - h, w * 2, h * 2);
				} else {				// �}�E�X����Ɉړ�
					g.fillOval(x - w, y + h, w * 2, -h * 2);
				}
			}else {					// �}�E�X�����Ɉړ�
				if(h<0) {				// �}�E�X����Ɉړ�
					g.fillOval(x + w, y + h, -w * 2, -h * 2);
				}else {					// �}�E�X�����Ɉړ�
					g.fillOval(x + w, y - h, -w * 2, h * 2);
				}
			}
		}
	}
}
