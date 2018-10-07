package exe12_17;

import java.awt.*;

public abstract class MyShape {

	private int x1; // x-coordinate of first endpoint
	private int y1; // y-coordinate of first endpoint
	private int x2; // x-coordinate of second endpoint
	private int y2; // y-coordinate of second endpoint
	private Color color; // color of this Rectangle

	public MyShape(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public MyShape() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
	}

	

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getY1() {
		return y1;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}
	
	public int getY2() {
		return y2;
	}

	public Color getColor() {
		return color;
	}
	
	public abstract void draw(Graphics g);	

}
