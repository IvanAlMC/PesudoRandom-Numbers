package view.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelNumbers extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblWriteOne;
	private JLabel lblWriteTwo;
	private JLabel lblReadOne;
	private JLabel lblReadTwo;
	
	
	public JPanelNumbers() {
		this.setLayout(new GridLayout(2,1));
		initComponents();
	}


	private void initComponents() {
		lblWriteOne = new JLabel("Dato 1: ");
		lblWriteOne.setForeground(Color.white);
		this.add(lblWriteOne);
		lblReadOne = new JLabel();
		lblReadOne.setForeground(Color.white);
		this.add(lblReadOne);
		lblWriteTwo = new JLabel("Dato 2: ");
		lblWriteTwo.setForeground(Color.white);
		this.add(lblWriteTwo);
		lblReadTwo = new JLabel();
		lblReadTwo.setForeground(Color.white);
		this.add(lblReadTwo);
		
	}


	public String getLblWriteOne() {
		return lblWriteOne.getText();
	}



	public void setLblWriteOne(String lblWriteOne) {
		this.lblWriteOne.setText(lblWriteOne);;
	}


	public String getLblWriteTwo() {
		return lblWriteTwo.getText();
	}


	public void setLblWriteTwo(String lblWriteTwo) {
		this.lblWriteTwo.setText(lblWriteTwo);;
	}
	
	
	public String getLblReadOne() {
		return lblReadOne.getText();
	}


	public void setLblReadOne(String lblReadOne) {
		this.lblReadOne.setText(lblReadOne);;
	}


	public String getLblReadTwo() {
		return lblReadTwo.getText();
	}


	public void setLblReadTwo(String lblReadTwo) {
		this.lblReadTwo.setText(lblReadTwo);;
	}
	
	
	

}
