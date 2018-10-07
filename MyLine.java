package exe12_17;

import java.awt.*;

public class MyLine extends MyShape{
	
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}
	
	public MyLine(){
		super(0, 0, 0, 0, Color.BLACK);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
	}
}
