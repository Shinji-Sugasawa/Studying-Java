package hello;

import java.util.Arrays;

public class Cards {

	//�J�[�h�f�[�^���i�[����z��//
	private int cards[];

	//�i�[�����J�[�h�f�[�^�̖���//
	private int num;

	//�f�[�^���i�����j//
	private String name;

	//���Ŏw�肳�ꂽ�����̃J�[�h���i�[�ł���悤�ɏ�������//
	public Cards(int n, String name) {
		cards = new int[n];
		num = 0;
		this.name = name;
	}

	//�J�[�h�f�[�^card��ǉ�����Bcard�͂P�`�T�Q�B//
	public void addCard(int card) {
		cards[num] = card;
		num++;
	}

	//index�Ԗڂ̃J�[�h��Ԃ��B�Ԓl�͂P�`�T�Q�B//
	public int getCard(int index) {
		return cards[index];
	}
	public void printCards() {		//�ۑ�R�i�P�j
		System.out.println();
		System.out.print("3(1):printCards():");
		for(int i= 0;i<cards.length;i++) {
			System.out.print(cards[i]+" ");
		}
		System.out.println();
	}
	public void printNumbers() {	//�ۑ�R�i�Q�j
		System.out.print("3(2):printNumbers():");
		for(int i=0;i<cards.length;i++) {

			if(cards[i] % 13 == 1) {
				System.out.print(" A");
			}else if( cards[i] % 13 == 10) {
				System.out.print(" T");
			}else if( cards[i] % 13 == 11) {
				System.out.print(" J");
			}else if( cards[i] % 13 == 12) {
				System.out.print(" Q");
			}else if( cards[i] % 13 == 0) {
				System.out.print(" K");
			}else{
				int suuji =cards[i]%13;
				System.out.print(" "+suuji);
			}
		}
		System.out.println();
	}
	public String getNumber(int index) {		//�ۑ�R�i�R�j
		//String str;
		if(cards[index] % 13 == 1) {
			name ="A";
			//str ="A";
		}else if( cards[index] % 13 == 10) {
			name ="T";
			//str ="A";
		}else if( cards[index] % 13 == 11) {
			name ="J";
			//str ="A";
		}else if( cards[index] % 13 == 12) {
			name = "Q";
			//str ="A";
		}else if( cards[index] % 13 == 0) {
			name = "K";
			//str ="A";
		}else{
			int suuji;
			suuji = cards[index] % 13 ;
			name = String.valueOf(suuji);
		}
		return name;
		//return str;
	}
	public String getSuitsNumber(int index) {//
		String suit ,number;
		if(cards[index] <= 13) {
			suit ="S";
		}else if(cards[index]<=26 ) {
			suit ="H";
		}else if(cards[index]<=39) {
			suit ="D";
		}else{
			suit ="C";
		}
		if(cards[index] % 13 == 1) {
			number ="A";
		}else if( cards[index] % 13 == 10) {
			number ="T";
		}else if( cards[index] % 13 == 11) {
			number ="J";
		}else if( cards[index] % 13 == 12) {
			number = "Q";
		}else if( cards[index] % 13 == 0) {
			number = "K";
		}else{
			int suuji;
			suuji = cards[index] % 13 ;
			number = String.valueOf(suuji);
		}
		String suitsnum =suit+number;


		return suitsnum;

	}
	public String printSuitsNumber(int index) {//�ۑ�R�i�T�j
		String suit,number;
		if(cards[index] <= 13) {
			suit ="S";
		}else if(cards[index]<=26 ) {
			suit ="H";
		}else if(cards[index]<=39) {
			suit ="D";
		}else{
			suit ="C";
		}
		if(cards[index] % 13 == 1) {
			number ="A";
		}else if( cards[index] % 13 == 10) {
			number ="T";
		}else if( cards[index] % 13 == 11) {
			number ="J";
		}else if( cards[index] % 13 == 12) {
			number = "Q";
		}else if( cards[index] % 13 == 0) {
			number = "K";
		}else{
			int suuji;
			suuji = cards[index] % 13 ;
			number = String.valueOf(suuji);
		}
		String suitsnum =suit+number;

		return suitsnum;
	}
	public int maxNumber() {
		int number = 1;
		for(int i = 0;i <cards.length;i++) {
			number = cards[i] % 13;
			if(number == 0) {
				number = 13;
				break;
			}
		}
		return number;
	}
	public void reverse() {		//�ۑ�S�i�Q�j
		System.out.println();
		System.out.print("4(2):public void reverse():");
		for(int i = 0;i <cards.length/2;i++) {
			int card = cards[i];
			cards[i] = cards[cards.length-1-i];
			cards[cards.length-1-i] = card;
		}
		for(int i = 0;i<cards.length;i++) {
			System.out.print(" "+cards[i]);
		}
		System.out.println();
	}

	public int removeFirst(){		//�ۑ�4�i3�j
		System.out.print("4(3):public void removeFirst():");
		int number = cards[0];
		for(int i = 0;i <cards.length;i++) {
			if(cards[i] == cards[cards.length-1]) {
				cards[cards.length-1] = 0;
			}else {
				cards[i] = cards[i+1];
			}
			System.out.print(" "+cards[i]);
		}
		return number;
	}

	public static void main(String args[]) {
		Cards cards = new Cards(5,"��D");	//�u�����̃J�[�h�v�̕ۑ��̈�����B
		cards.addCard(1);		//0���ڂ̓X�y�[�hA
		cards.addCard(15);		//1���ڂ̓n�[�g�Q	�ۑ�P
		cards.addCard(31);		//2���ڂ̓_�C���T	�ۑ�P
		cards.addCard(49);		//3���ڂ̓N���u�P�O	�ۑ�P
		cards.addCard(52);		//4���ڂ̓N���uK	�ۑ�P

		for(int i = 0;i <5;i++) {		//�ۑ�Q
			if(i == 0) {
				System.out.print(" 2  : ");
			}
			int card = cards.getCard(i);
			System.out.print(card+" ");
		}

		cards.printCards(); 				//�ۑ�R�i�P�j

		cards.printNumbers();				//�ۑ�R�i�Q�j

		for(int i = 0;i<5;i++) {			//�ۑ�R�i�R�j
			String str2 = cards.getNumber(i);
			if(i == 0) {
				System.out.print("3(3):getNumber():");
			}
			System.out.print(str2+" ");

		}

		for(int i =0;i<5;i++) {				//�ۑ�R�i�S�j
			String str3 = cards.getSuitsNumber(i);
			if(i == 0) {
				System.out.println();
				System.out.print("3(4):getSuitsNumber():");
			}
			System.out.print(str3+" ");

		}

		for(int i = 0;i<5;i++) {				//�ۑ�R�i�T�j
			if(i ==0) {
				System.out.println();
				System.out.print("3(5):printSuitsNumber():");
			}
			String str4 =cards.printSuitsNumber(i);
			System.out.print(str4+" ");
			if(i==4) {
				System.out.println();
			}
		}

		int number = cards.maxNumber();//�ۑ�S�i�P�j
		System.out.print("4(1):maxNumber():"+number);

		cards.reverse();		//�ۑ�S�i�Q�j

		cards.removeFirst();		//�ۑ�S�i�R�j

	}

}