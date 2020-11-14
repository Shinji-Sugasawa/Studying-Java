package enshu2_2019_11;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Paint4 extends Frame implements MouseListener,
											MouseMotionListener,ActionListener {
	int x, y;
	ArrayList<Figure>objList;//描写する全オブジェクトを管理する
	CheckboxGroup cbg;//図形メニュー
	CheckboxGroup col;//色メニュー
	CheckboxGroup sme;//塗りつぶしメニュー
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;//メニュー要素
	Button end,und,del;//終了ボタン、一文字戻しボタン、全削除ボタン
	int mode = 0;//描写モード（1：1点指定図形　2：2点指定図形）
	int fill = 0;//塗りつぶしfill（0:枠線　1:塗りつぶし図形）
	Figure obj;//実際に描写するオブジェクト
	public static void main(String args[]) {
		Paint4 f = new Paint4();
		f.setSize(1925,1050);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);//ウィンドウの表示

		if(args.length == 1) f.load(args[0]);//コマンドライン引数のファイル読み込み
	}

	Paint4(){
		objList = new ArrayList<Figure>();

		setLayout(null);
		cbg = new CheckboxGroup();//checkboxの集合を作成
		col = new CheckboxGroup();//checkboxの集合を作成
		sme = new CheckboxGroup();//checkboxの集合を作成
		c1 = new Checkbox( "丸" , cbg,true);//「丸」メニューの作成
		c1.setBounds(1840,30,60,30);//「丸」メニューの座標設定
		add(c1);
		c2 = new Checkbox( "円" , cbg,false);//「円」メニューの作成
		c2.setBounds(1840,60,60,30);			//「円」メニューの座標設定
		add(c2);							//「円」メニューの追加
		c9 = new Checkbox( "楕円" , cbg,false);//「楕円」メニューの作成
		c9.setBounds(1840,90,60,30);			//「楕円」メニューの座標設定
		add(c9);							//「楕円」メニューの追加
		c3 = new Checkbox( "四角" , cbg, false);//「四角」メニューの作成
		c3.setBounds(1840,120,60,30);		//「四角」メニューの座標設定
		add(c3);							//「四角」メニューの追加
		c4 = new Checkbox( "線" , cbg,false);//「線」メニューの作成
		c4.setBounds(1840,150,60,30);		//「線」メニューの座標設定
		add(c4);							//「線」メニューの追加

		c5 = new Checkbox( "黒",col,true); //「黒」メニューの作成
		c5.setBounds (1840,210,60,30);		//「黒」メニューの座標設定
		add(c5);							//「黒」メニューの追加
		c6 = new Checkbox( "赤" ,col,false); //「赤」メニューの作成
		c6.setBounds (1840,240,60,30);		//「赤」メニューの座標設定
		add(c6);							//「赤」メニューの追加
		c7 = new Checkbox( "青" ,col,false); //「青」メニューの作成
		c7.setBounds (1840,270,60,30);		//「青」メニューの座標設定
		add(c7);							//「青」メニューの追加
		c8 = new Checkbox( "緑" ,col,false);//「緑」メニューの作成
		c8.setBounds (1840,300,60,30);		//「緑」メニューの座標設定
		add(c8);							//「緑」メニューの追加

		c10 = new Checkbox( "枠線" ,sme,true);//「枠線」メニューの作成
		c10.setBounds (1840,360,60,30);		//「枠線」メニューの座標設定
		add(c10);							//「枠線」メニューの追加
		c11 = new Checkbox( "塗りつぶし" ,sme,false);//「塗りつぶし」メニューの作成
		c11.setBounds (1840,390,80,30);			//「塗りつぶし」メニューの座標設定
		add(c11);							//「塗りつぶし」メニューの追加

		und = new Button( "１つ戻す" );	//「１つ戻す」ボタンの作成
		und.setBounds (1845,800,60,30);	//「１つ戻す」ボタンの座標設定
		add(und);						//「１つ戻す」ボタンの追加
		del = new Button( "全削除" );	//「全削除」ボタンの作成
		del.setBounds (1845,860,60,30);	//「全削除」ボタンの座標設定
		add(del);						//「全削除」ボタンの追加
		end = new Button( "終了" );		//「終了」ボタンの作成
		end.setBounds (1845,950,60,30);	//「終了」ボタンの座標設定
		add(end);						//「終了」ボタンの追加
		//マウス処理の登録
		addMouseListener(this);
		addMouseMotionListener(this);

		end.addActionListener(this);//終了処理の登録
		und.addActionListener(this);//１つ戻す処理の登録
		del.addActionListener(this);//全削除処理の登録
	}
	public void save(String fname) {
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		} catch(IOException e) {
		}
	}
	@SuppressWarnings("unchecked")
	public void load(String fname) {
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			objList = (ArrayList<Figure>)ois.readObject();
			ois.close();
			fis.close();
		} catch(IOException e) {
		} catch(ClassNotFoundException e) {
		}
		repaint();			//再描写
	}
	@Override public void paint(Graphics g) {
		Figure f;
		for (int i = 0; i< objList.size();i++) {
			f = objList.get(i);	//i番目に描写した図形を格納
			f.paint(g);			//作成中の図形を描写
		}
		if ( mode >= 1) obj.paint(g) ;
	}
	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == end) {		//終了ボタンの判定
			save("paint.dat");
			System.exit(0);
		}
		else if(e.getSource()==und) {	//１つ戻すボタンの判定
			objList.remove(objList.size()-1);//objListに格納された図形の（i-1）を削除
			repaint();//再描写
		}
		else if(e.getSource()==del) {	//全削除ボタンの判定
			objList.clear();	//objListの中身をリセットする
			repaint();//再描写
		}
	}
	@Override public void mousePressed(MouseEvent e) { //マウスボタン押下
		Checkbox c;
		Checkbox d;
		Checkbox a;
		x = e.getX();
		y = e.getY();
		c = cbg.getSelectedCheckbox();	//選択されたチェックボックスの取得
		d = col.getSelectedCheckbox();	//選択されたチェックボックスの取得
		a = sme.getSelectedCheckbox();	//選択されたチェックボックスの取得
		obj = null;//objを何も参照していない状態に

		if(c== c1) {//丸
			mode = 1;
			obj = new Dot();
		} else if(c == c2) {//円
			mode = 2 ;
			obj = new Circle();
		} else if(c == c3) {//四角
			mode = 2 ;
			obj = new Rect();
		} else if(c == c4) {//線
			mode = 2 ;
			obj = new Line();
		}else if(c == c9) {//楕円
			mode = 2 ;
			obj = new ellipse();
		}
		if(d == c5) {//黒
			obj.setColor(1);//setColorメソッドを呼び出し、引数は(1)
		}
		else if(d == c6) {//赤
			obj.setColor(2);//setColorメソッドを呼び出し、引数は(2)
		}
		else if(d == c7) {//青
			obj.setColor(3);//setColorメソッドを呼び出し、引数は(3)
		}
		else if(d == c8) {//緑
			obj.setColor(4);//setColorメソッドを呼び出し、引数は(4)
		}

		if(a == c10) {//枠線
			obj.setSmear(0);//setColorメソッドを呼び出し、引数は(0)
		}else if(a == c11) {//塗りつぶし
			obj.setSmear(1);//setColorメソッドを呼び出し、引数は(1)
		}

		 if(obj != null) {
			obj.moveto(x,y);
			repaint();//再描写
		 }
	}
	@Override public void mouseReleased(MouseEvent e) {//マウスボタンが離された
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
	@Override public void mouseClicked(MouseEvent e) {}//クリックされた
	@Override public void mouseEntered(MouseEvent e) {}//Windowに入った
	@Override public void mouseExited(MouseEvent e) {}//Windowから出た
	@Override public void mouseDragged(MouseEvent e) {//ボタンを押したまま移動
		x = e.getX();
		y = e.getY();
		if(mode ==1) {
			obj.moveto(x,y);
		} else if (mode == 2) {
			obj.setWH(x - obj.x, y - obj.y);//幅と高さの設定
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}//移動
}
