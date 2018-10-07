package exe12_17;

import java.awt.*;

public class MyOval extends MyBoundedShape {

	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color, filled);
	}

	public MyOval() {
		super(0, 0, 0, 0, Color.BLACK, false);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		if (super.isFilled() == true){
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}else{
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		}
	}

}
