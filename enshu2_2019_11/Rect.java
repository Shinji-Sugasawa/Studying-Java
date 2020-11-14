package enshu2_2019_11;

import java.io.*;
import java.awt.*;

public class Rect extends Figure{// �l�p�N���X
	Rect(){}
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
		if(smear == 0) {		//�g���̎l�p��`��
			if (w > 0) {			// �}�E�X���E�Ɉړ�
				if (h>0) {				// �}�E�X�����Ɉړ�
					g.drawRect( x, y , w , h);
				}else {					// �}�E�X����Ɉړ�
					g.drawRect( x, y+h, w , -h);
				}
			} else {				// �}�E�X�����Ɉړ�
				if (h<0) {				// �}�E�X����Ɉړ�
					g.drawRect( x+w, y+h , -w , -h);
				}else {					// �}�E�X�����Ɉړ�
					g.drawRect( x+w, y , -w , h);
				}
			}
		}else {					//�h��Ԃ����l�p��`��
			if (w > 0) {			// �}�E�X���E�Ɉړ�
				if (h>0) {				// �}�E�X�����Ɉړ�
					g.fillRect( x, y , w , h);
				}else {					// �}�E�X����Ɉړ�
					g.fillRect( x, y+h, w , -h);
				}
			} else {				// �}�E�X�����Ɉړ�
				if (h<0) {				// �}�E�X����Ɉړ�
					g.fillRect( x+w, y+h , -w , -h);
				}else {					// �}�E�X�����Ɉړ�
					g.fillRect( x+w, y , -w , h);
				}
			}
		}
	}
}
