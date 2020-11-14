package enshu2_2019_11;

import java.io.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class Figure extends Coord implements Serializable{//座標/描写する
	int color,smear;	//図形の色と塗りつぶし
	int w,h;	//図形の幅と高さ
	Figure(){
		color = smear = 0;
		w = h = 0;
	}
	public void paint(Graphics g) {}//　このクラスでは空　オーバーライド用
	public void setWH(int w, int h) {//2点指定の図形用
		this.w = w;
		this.h = h;
	}
	public void setColor(int c) {	//図形の色付け用
		color = c;
	}
	public void setSmear(int c) {  	//　図形の塗りつぶし用
		smear = c;
	}
}
