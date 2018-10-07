package exe12_17;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawPanel extends JPanel {

	//variables in DrawPanel

	private MyShape[] shapes;		//An array shapes of type MyShape that will store all the shapes the user draws.
	private int shapeCount;			//An integer shapeCount that counts the number of shapes in the array.
	private int shapeType;			//An integer shapeType that determines the type of shape to draw.
	private MyShape currentShape;		//A MyShape currentShape that represents the current shape the user is drawing.
	private Color currentColor;		//A Color currentColor that represents the current drawing color.
	private boolean filledShape;		//A boolean filledShape that determines whether to draw a filled shape.
	private JLabel statusLabel;		//A JLabel statusLabel that represents the status bar. The status bar will display 
						//the coordinates of the current mouse position.
	
	/*
	Overridden method paintComponent that draws the shapes in the array. 
	Use instance variable shapeCount to determine how many shapes to draw.
	Method paintComponent should also call currentShape's draw method, provided that currentShape is not null.
	*/

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
		}
		
		this.paintCurrentShape(g);
		
	}
	public void paintCurrentShape(Graphics g){
		if (currentShape != null) {		
			this.currentShape.draw(g);	
		}	
	}



	public void setShapeType(int ST) {		//Set methods for the shapeType.
		this.shapeType = ST;
	}

	public void setCurrentColor(Color CC) {		//Set methods for the currentColor.
		this.currentColor = CC;
	}

	public void setFilledShape(boolean FS) {	//Set methods for the filledShape.
		this.filledShape = FS;
	}
	
	public void setCurrentShape(MyShape CS) {	//Set methods for the currentShape.
		this.currentShape = CS;
	}
	

	/*
	Methods clearLastShape and clearDrawing should call repaint (inherited from JPanel) 
	to refresh the drawing on the DrawPanel by indicating that the system should call method paintComponent.
	*/
	
	public void clearLastShape() {			//Method clearLastShape should clear the last shape drawn by 
		if (shapeCount > 0)			//decrementing instance variable shapeCount.
			shapeCount--;			//Ensure that shapeCount is never less than zero.
		repaint();
	}

	public void clearDrawing() {			//Method clearDrawing should remove all the shapes in the current 
		shapeCount = 0;				//drawing by setting shapeCount to zero.
		repaint();
	}


	/*
	Create a single inner class that both extends MouseAdapter and 
	implements MouseMotionListener to handle all mouse events in one class.
	*/
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {
			
		//override method mousePressed so that it assigns currentShape a new 
		//shape of the type specified by shapeType and initializes both points to the mouse position. 		
		@Override
		public void mousePressed(MouseEvent e) {
			switch(shapeType)
			{
				case 0 : currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);break;
				case 1 : currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);break;
				case 2 : currentShape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);break;
				default : throw new IndexOutOfBoundsException("no this shape");
			}
		}

		//override method mouseReleased to finish drawing the current shape and place it in the array.
		@Override
		public void mouseReleased(MouseEvent e) {
			currentShape.setX2(e.getX());		//Set the second point of currentShape to the current mouse position 
			currentShape.setY2(e.getY());
			shapes[shapeCount++] = currentShape;	//and add currentShape to the array.
			currentShape = null;			//Set currentShape to null and 
			repaint();				//call method repaint to update the drawing with the new shape.
		}

		//Override method mouseMoved to set the text of the statusLabel so that it displays the mouse coordinates
		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("At [%d, %d]", e.getX(), e.getY()));
		}

		//override method mouseDragged so that it sets the second point of the currentShape 
		//to the current mouse position and calls method repaint.
		@Override
		public void mouseDragged(MouseEvent e) {
			currentShape.setX2(e.getX());
			currentShape.setY2(e.getY());
			repaint();
			statusLabel.setText(String.format("%d: %d:", e.getX(), e.getY()));
		}

	}
	/*
	Create a constructor for DrawPanel that has a single JLabel parameter. 
	In the constructor, initialize statusLabel with the value passed to the parameter. 
	Also initialize array shapes with 100 entries, shapeCount to 0, shapeType to the value that represents a line, 
	currentShape to null and currentColor to Color.BLACK. 
	The constructor should then set the background color of the DrawPanel to Color.WHITE and 
	register the MouseListener and MouseMotionListener so the JPanel properly handles mouse events.
	*/
	public DrawPanel(JLabel status) {
		statusLabel = status;
		shapeCount = 0;
		shapeType = 0;
		currentShape = null;
		currentColor = Color.BLACK;
		filledShape = false;
		initlabel();
		inithandler();
	}
	
	private void initlabel(){
		shapes = new MyShape[100];
		setBackground(Color.WHITE);
	}
	
	private void inithandler(){
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
}
