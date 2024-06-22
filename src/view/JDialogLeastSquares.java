package view;

import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

import view.JPanel.JPanelLeastSquares;
import java.awt.Color;

public class JDialogLeastSquares extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelLeastSquares JPanel;
	
	public JDialogLeastSquares(JFrame frame,ActionListener listener) {
		super(frame,"Genere sus numeros con el metodo de minimos cuadrados",true);
		 initComponents(listener);
		this.setLocationRelativeTo(frame);
		this.setSize(500,340);
		this.setLocationRelativeTo(this);
		this.setVisible(false);
	
	}

	private void initComponents(ActionListener listener) {
		JPanel = new JPanelLeastSquares(listener);
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
	
	
	/*Obtener datos*/
	
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

	
/*Obtener get an setter en distribucion uniforme*/
	
	
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
	

	/*Obtener get an setter en distribucion normal*/
	
	
	
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
