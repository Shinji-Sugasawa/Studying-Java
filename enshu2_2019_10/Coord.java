package enshu2_2019_10;

class Coord {
	int x,y;
	Coord(){
		x = y = 0;
	}
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public void moveto(int x,int y) {
		this.x = x;
		this.y = y;
	}
}