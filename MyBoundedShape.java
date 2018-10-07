package exe12_17;

import java.awt.*;

public abstract class MyBoundedShape extends MyShape {

	private boolean filled;

	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color);
		this.filled = filled;
	}


	public MyBoundedShape() {
		super(0, 0, 0, 0, Color.BLACK);
		this.filled = false;
	}

	public boolean isFilled() {
		return filled;
	}

	

	public int getUpperLeftX() {
		return Math.min(super.getX1(), super.getX2());
	}

	public int getUpperLeftY() {
		return Math.min(super.getY1(), super.getY2());
	}

	public int getWidth() {
		return Math.abs(super.getX1() - super.getX2());
	}

	public int getHeight() {
		return Math.abs(super.getY1() - super.getY2());
	}

}
