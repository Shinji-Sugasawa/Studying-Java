package enshu2_2019_11;

import java.io.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class Figure extends Coord implements Serializable{//���W/�`�ʂ���
	int color,smear;	//�}�`�̐F�Ɠh��Ԃ�
	int w,h;	//�}�`�̕��ƍ���
	Figure(){
		color = smear = 0;
		w = h = 0;
	}
	public void paint(Graphics g) {}//�@���̃N���X�ł͋�@�I�[�o�[���C�h�p
	public void setWH(int w, int h) {//2�_�w��̐}�`�p
		this.w = w;
		this.h = h;
	}
	public void setColor(int c) {	//�}�`�̐F�t���p
		color = c;
	}
	public void setSmear(int c) {  	//�@�}�`�̓h��Ԃ��p
		smear = c;
	}
}
