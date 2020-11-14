package enshu2_2019_11;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Paint4 extends Frame implements MouseListener,
											MouseMotionListener,ActionListener {
	int x, y;
	ArrayList<Figure>objList;//�`�ʂ���S�I�u�W�F�N�g���Ǘ�����
	CheckboxGroup cbg;//�}�`���j���[
	CheckboxGroup col;//�F���j���[
	CheckboxGroup sme;//�h��Ԃ����j���[
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;//���j���[�v�f
	Button end,und,del;//�I���{�^���A�ꕶ���߂��{�^���A�S�폜�{�^��
	int mode = 0;//�`�ʃ��[�h�i1�F1�_�w��}�`�@2�F2�_�w��}�`�j
	int fill = 0;//�h��Ԃ�fill�i0:�g���@1:�h��Ԃ��}�`�j
	Figure obj;//���ۂɕ`�ʂ���I�u�W�F�N�g
	public static void main(String args[]) {
		Paint4 f = new Paint4();
		f.setSize(1925,1050);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);//�E�B���h�E�̕\��

		if(args.length == 1) f.load(args[0]);//�R�}���h���C�������̃t�@�C���ǂݍ���
	}

	Paint4(){
		objList = new ArrayList<Figure>();

		setLayout(null);
		cbg = new CheckboxGroup();//checkbox�̏W�����쐬
		col = new CheckboxGroup();//checkbox�̏W�����쐬
		sme = new CheckboxGroup();//checkbox�̏W�����쐬
		c1 = new Checkbox( "��" , cbg,true);//�u�ہv���j���[�̍쐬
		c1.setBounds(1840,30,60,30);//�u�ہv���j���[�̍��W�ݒ�
		add(c1);
		c2 = new Checkbox( "�~" , cbg,false);//�u�~�v���j���[�̍쐬
		c2.setBounds(1840,60,60,30);			//�u�~�v���j���[�̍��W�ݒ�
		add(c2);							//�u�~�v���j���[�̒ǉ�
		c9 = new Checkbox( "�ȉ~" , cbg,false);//�u�ȉ~�v���j���[�̍쐬
		c9.setBounds(1840,90,60,30);			//�u�ȉ~�v���j���[�̍��W�ݒ�
		add(c9);							//�u�ȉ~�v���j���[�̒ǉ�
		c3 = new Checkbox( "�l�p" , cbg, false);//�u�l�p�v���j���[�̍쐬
		c3.setBounds(1840,120,60,30);		//�u�l�p�v���j���[�̍��W�ݒ�
		add(c3);							//�u�l�p�v���j���[�̒ǉ�
		c4 = new Checkbox( "��" , cbg,false);//�u���v���j���[�̍쐬
		c4.setBounds(1840,150,60,30);		//�u���v���j���[�̍��W�ݒ�
		add(c4);							//�u���v���j���[�̒ǉ�

		c5 = new Checkbox( "��",col,true); //�u���v���j���[�̍쐬
		c5.setBounds (1840,210,60,30);		//�u���v���j���[�̍��W�ݒ�
		add(c5);							//�u���v���j���[�̒ǉ�
		c6 = new Checkbox( "��" ,col,false); //�u�ԁv���j���[�̍쐬
		c6.setBounds (1840,240,60,30);		//�u�ԁv���j���[�̍��W�ݒ�
		add(c6);							//�u�ԁv���j���[�̒ǉ�
		c7 = new Checkbox( "��" ,col,false); //�u�v���j���[�̍쐬
		c7.setBounds (1840,270,60,30);		//�u�v���j���[�̍��W�ݒ�
		add(c7);							//�u�v���j���[�̒ǉ�
		c8 = new Checkbox( "��" ,col,false);//�u�΁v���j���[�̍쐬
		c8.setBounds (1840,300,60,30);		//�u�΁v���j���[�̍��W�ݒ�
		add(c8);							//�u�΁v���j���[�̒ǉ�

		c10 = new Checkbox( "�g��" ,sme,true);//�u�g���v���j���[�̍쐬
		c10.setBounds (1840,360,60,30);		//�u�g���v���j���[�̍��W�ݒ�
		add(c10);							//�u�g���v���j���[�̒ǉ�
		c11 = new Checkbox( "�h��Ԃ�" ,sme,false);//�u�h��Ԃ��v���j���[�̍쐬
		c11.setBounds (1840,390,80,30);			//�u�h��Ԃ��v���j���[�̍��W�ݒ�
		add(c11);							//�u�h��Ԃ��v���j���[�̒ǉ�

		und = new Button( "�P�߂�" );	//�u�P�߂��v�{�^���̍쐬
		und.setBounds (1845,800,60,30);	//�u�P�߂��v�{�^���̍��W�ݒ�
		add(und);						//�u�P�߂��v�{�^���̒ǉ�
		del = new Button( "�S�폜" );	//�u�S�폜�v�{�^���̍쐬
		del.setBounds (1845,860,60,30);	//�u�S�폜�v�{�^���̍��W�ݒ�
		add(del);						//�u�S�폜�v�{�^���̒ǉ�
		end = new Button( "�I��" );		//�u�I���v�{�^���̍쐬
		end.setBounds (1845,950,60,30);	//�u�I���v�{�^���̍��W�ݒ�
		add(end);						//�u�I���v�{�^���̒ǉ�
		//�}�E�X�����̓o�^
		addMouseListener(this);
		addMouseMotionListener(this);

		end.addActionListener(this);//�I�������̓o�^
		und.addActionListener(this);//�P�߂������̓o�^
		del.addActionListener(this);//�S�폜�����̓o�^
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
		repaint();			//�ĕ`��
	}
	@Override public void paint(Graphics g) {
		Figure f;
		for (int i = 0; i< objList.size();i++) {
			f = objList.get(i);	//i�Ԗڂɕ`�ʂ����}�`���i�[
			f.paint(g);			//�쐬���̐}�`��`��
		}
		if ( mode >= 1) obj.paint(g) ;
	}
	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == end) {		//�I���{�^���̔���
			save("paint.dat");
			System.exit(0);
		}
		else if(e.getSource()==und) {	//�P�߂��{�^���̔���
			objList.remove(objList.size()-1);//objList�Ɋi�[���ꂽ�}�`�́ii-1�j���폜
			repaint();//�ĕ`��
		}
		else if(e.getSource()==del) {	//�S�폜�{�^���̔���
			objList.clear();	//objList�̒��g�����Z�b�g����
			repaint();//�ĕ`��
		}
	}
	@Override public void mousePressed(MouseEvent e) { //�}�E�X�{�^������
		Checkbox c;
		Checkbox d;
		Checkbox a;
		x = e.getX();
		y = e.getY();
		c = cbg.getSelectedCheckbox();	//�I�����ꂽ�`�F�b�N�{�b�N�X�̎擾
		d = col.getSelectedCheckbox();	//�I�����ꂽ�`�F�b�N�{�b�N�X�̎擾
		a = sme.getSelectedCheckbox();	//�I�����ꂽ�`�F�b�N�{�b�N�X�̎擾
		obj = null;//obj�������Q�Ƃ��Ă��Ȃ���Ԃ�

		if(c== c1) {//��
			mode = 1;
			obj = new Dot();
		} else if(c == c2) {//�~
			mode = 2 ;
			obj = new Circle();
		} else if(c == c3) {//�l�p
			mode = 2 ;
			obj = new Rect();
		} else if(c == c4) {//��
			mode = 2 ;
			obj = new Line();
		}else if(c == c9) {//�ȉ~
			mode = 2 ;
			obj = new ellipse();
		}
		if(d == c5) {//��
			obj.setColor(1);//setColor���\�b�h���Ăяo���A������(1)
		}
		else if(d == c6) {//��
			obj.setColor(2);//setColor���\�b�h���Ăяo���A������(2)
		}
		else if(d == c7) {//��
			obj.setColor(3);//setColor���\�b�h���Ăяo���A������(3)
		}
		else if(d == c8) {//��
			obj.setColor(4);//setColor���\�b�h���Ăяo���A������(4)
		}

		if(a == c10) {//�g��
			obj.setSmear(0);//setColor���\�b�h���Ăяo���A������(0)
		}else if(a == c11) {//�h��Ԃ�
			obj.setSmear(1);//setColor���\�b�h���Ăяo���A������(1)
		}

		 if(obj != null) {
			obj.moveto(x,y);
			repaint();//�ĕ`��
		 }
	}
	@Override public void mouseReleased(MouseEvent e) {//�}�E�X�{�^���������ꂽ
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
	@Override public void mouseClicked(MouseEvent e) {}//�N���b�N���ꂽ
	@Override public void mouseEntered(MouseEvent e) {}//Window�ɓ�����
	@Override public void mouseExited(MouseEvent e) {}//Window����o��
	@Override public void mouseDragged(MouseEvent e) {//�{�^�����������܂܈ړ�
		x = e.getX();
		y = e.getY();
		if(mode ==1) {
			obj.moveto(x,y);
		} else if (mode == 2) {
			obj.setWH(x - obj.x, y - obj.y);//���ƍ����̐ݒ�
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}//�ړ�
}
