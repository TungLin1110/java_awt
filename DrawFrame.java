package exe12_17;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFrame extends JFrame {

	private JButton undo;				//A button to undo the last shape drawn.
	private JButton clear;				//A button to clear all shapes from the drawing.
	private JComboBox<String> colorChooser;		//A combo box for selecting the color from the 13 predefined colors.
	private JComboBox<String> shapeChooser;		//A combo box for selecting the shape to draw.
	private JCheckBox filledCheck;			//A checkbox that specifies whether a shape should be filled or unfilled.
	
	private JLabel statusLabel;	
	private JPanel Menu;
	private DrawPanel panel;

	private final static String[] shapes = { "Line", "Oval", "Rectangle" };
	private final static String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
			"Magneta", "Orange", "Pink", "Red", "White", "Yellow" };
	private final static Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };

	public DrawFrame() {

		super("Java Drawing");

		statusLabel = new JLabel();
		add(statusLabel, BorderLayout.SOUTH);

		panel = new DrawPanel(statusLabel);
		add(panel, BorderLayout.CENTER);


		setButtons();
		setHandler();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}

	private void setButtons(){
		Menu = new JPanel(new FlowLayout());
		undo = new JButton("Undo");
		Menu.add(undo);
		clear = new JButton("Clear");
		Menu.add(clear);
		colorChooser = new JComboBox<>(colorNames);
		colorChooser.setMaximumRowCount(13);
		Menu.add(colorChooser);
		shapeChooser = new JComboBox<>(shapes);
		shapeChooser.setMaximumRowCount(3);
		Menu.add(shapeChooser);	
		filledCheck = new JCheckBox("Filled");
		Menu.add(filledCheck);
		add(Menu, BorderLayout.NORTH);
	}
	private void setHandler(){
		ActionsHandler AH = new ActionsHandler();
		undo.addActionListener(AH);
		clear.addActionListener(AH);
		ItemsHandler IH = new ItemsHandler();
		colorChooser.addItemListener(IH);
		shapeChooser.addItemListener(IH);
		filledCheck.addItemListener(IH);
	}
	private class ActionsHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == undo)			
				panel.clearLastShape();
			else if(e.getSource() == clear)
				panel.clearDrawing();
		}
	}
	
	private class ItemsHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == filledCheck){
				if (filledCheck.isSelected()) {
					panel.setFilledShape(true);
				} else
					panel.setFilledShape(false);
			}
			else if(e.getStateChange() == ItemEvent.SELECTED){
				if(e.getSource() == colorChooser){
					panel.setCurrentColor(colors[colorChooser.getSelectedIndex()]);			
				}
				else if(e.getSource() == shapeChooser){
					if (shapeChooser.getSelectedIndex() == 0){
						panel.setShapeType(0);
					}else if (shapeChooser.getSelectedIndex() == 1){
						panel.setShapeType(1);
					}else if (shapeChooser.getSelectedIndex() == 2){
						panel.setShapeType(2);
					}
				}
			}
		}	
	}
}

