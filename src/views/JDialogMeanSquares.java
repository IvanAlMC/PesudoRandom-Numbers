package views;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

import views.panels.JPanelMeanSquares;

import java.awt.Color;

public class JDialogMeanSquares extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelMeanSquares JPanel;
	
	public JDialogMeanSquares(JFrame frame,ActionListener listener) {
		super(frame,"Minimos cuadrados",true);
		initComponents(listener);
		this.setLocationRelativeTo(frame);
		this.setSize(470,340);
		this.setLocationRelativeTo(this);
		this.setVisible(false);
	
	}

	private void initComponents(ActionListener listener) {
		JPanel = new JPanelMeanSquares(listener);
		JPanel.setForeground(new Color(255, 255, 255));
		JPanel.setBackground(new Color(91, 91, 91));
		getContentPane().add(JPanel);
	}
	
	public void getOption(boolean option) {
		this.setVisible(option);
	}
	
	public void valiateRadioButton() {
		JPanel.valiateRadioButton();
	}
	
	public String getTxtSeed() {
		return JPanel.getTxtSeed();
	}
	
	public void setTxtSeed(String txtSeed) {
		this.JPanel.setTxtSeed(txtSeed);;
	}

	public String getTxtQuantity() {
		return JPanel.getTxtQuantity();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.JPanel.setTxtQuantity(txtQuantity);
	}
	
	public boolean isSelectRadioButton() {
		return JPanel.isSelectRadioButton();
	}
	
	public boolean isSelectrbtnNormalDistribution() {
		return JPanel.isSelectrbtnNormalDistribution();
	}
	
	public boolean isSelectrbtnUniformDistribution() {
		return JPanel.isSelectrbtnUniformDistribution();
	}

	public String getTxtOneUniform() {
		return JPanel.getTxtOneUniform();
	}
	
	public void setTxtOneUniform(String txtOneUniform) {
		this.JPanel.setTxtOneUniform(txtOneUniform);;
	}

	public String getTxtTwoUniform() {
		return JPanel.getTxtTwoUniform();
	}

	public void setTxtTwoUniform(String txtTwoUniform) {
		this.JPanel.setTxtTwoUniform(txtTwoUniform);;
	}
	
	public String getTxtOneNormal() {
		return JPanel.getTxtOneNormal();
	}

	public void setTxtOneNormal(String txtOneNormal) {
		this.JPanel.setTxtOneNormal(txtOneNormal);;
	}
	
	public String getTxtTwoNormal() {
		return JPanel.getTxtTwoNormal();
	}

	public void setTxtTwoNormal(String txtTwoNormal) {
		this.JPanel.setTxtTwoNormal(txtTwoNormal);;
	}
}
