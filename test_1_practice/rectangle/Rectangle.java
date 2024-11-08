package reactangle;

public class Rectangle {
	private Point upoint;
	private Point lpoint;
	//private float width;//寬
	private int id;
	private static int num = 0;
		
	public Rectangle(int x1,int y1,int x2,int y2) {
		num++;
		this.id = num;
		setUpoint(x1,y1);
		setLpoint(x2,y2);
	}
	public Point getUpoint() {
		return upoint;
	}
	public void setUpoint(int x,int y) {
		upoint = new Point(x,y);
	}
	public Point getLpoint() {
		return lpoint;
	}
	public void setLpoint(int x,int y) {
		lpoint = new Point(x,y);
	}

	
	//對每個矩形計算長、寬、周長和面積
	public int getId() {
		return id;
	}
	
	public float getLength() {
		float length;
		if(Math.abs(upoint.getX()-lpoint.getX()) >= Math.abs(upoint.getY()-lpoint.getY())) {
			length = Math.abs(upoint.getX()-lpoint.getX());
		}else {
			length = Math.abs(upoint.getY()-lpoint.getY());
		}
		return length;
	}
	
	public float getWidth() {
		float width;
		if(Math.abs(upoint.getX()-lpoint.getX()) >= Math.abs(upoint.getY()-lpoint.getY())) {
			width = Math.abs(upoint.getY()-lpoint.getY());
		}else {
			width = Math.abs(upoint.getX()-lpoint.getX());
		}
		return width;
	}
	
	
	
	public float caculatePerimeter() {
		return (getLength()+getWidth())*2;
	}
	
	public float caculateArea() {
		return getLength()*getWidth();
	}
	
	public boolean issquare() {
		if(getLength() != getWidth()) {
			return false;
		}else return true;
	}
	
	public void show_recantagle_info() {
		System.out.printf("%d rectangle infomation:\n", getId());
		System.out.printf("up point is ( %d, %d):\n", getUpoint().getX(),getUpoint().getY());
		System.out.printf("low point is ( %d, %d):\n", getLpoint().getX(),getLpoint().getY());
		System.out.printf("the width is %.2f\n", getWidth());
		System.out.printf("the Length is %.2f\n", getLength());
		System.out.printf("the Perimeter is %.2f\n", caculatePerimeter());
		System.out.printf("the Area is %.2f\n", caculateArea());
		if(issquare()) {
			System.out.printf("%d rectangle is a square\n", getId());
		}else {
			System.out.printf("%d rectangle is not a square\n", getId());
		}
	}
	
}
