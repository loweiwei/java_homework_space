package reactangle;


public class Point {

	private int X;
	private int Y;
	
	public Point() {
		this.X = 0;
		this.Y = 0;
	}
	public Point(int x,int y) {
		setX(x);
		setY(y);
	}
	//
	public int getX() {
		return X;
	}
	public void setX(int x) {
		if(x<=20 && x>0) {
			this.X = x;
		}else {
			System.out.printf("x is out of range\n");
		}
	}
	//
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		if(y<=20 && y>0) {
			this.Y = y;
		}else {
			System.out.printf("y is out of range\n");
		}
	}
	//
	public static double distance(Point a, Point b) {
		
		double distance = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
		return distance;

	}
	
}
