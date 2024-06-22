package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import view.JPanel.JPanelMultiplicativeCongruence;

public class JDialogMultiplicativeCongruence extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelMultiplicativeCongruence JPanel;

	
	
	public JDialogMultiplicativeCongruence(JFrame frame,ActionListener listener) {
		super(frame,"Genere sus numeros con el metodo de congruencia multiplicativa",true);
		initComponents(listener);
		this.setLocationRelativeTo(frame);
		this.setSize(500,400);
		this.setLocationRelativeTo(this);
		this.setVisible(false);
		this.setBackground(new Color(91,91,91));
	}



	private void initComponents(ActionListener listener) {
		JPanel = new JPanelMultiplicativeCongruence(listener);
		this.add(JPanel);
	}
	
	public void getOption(boolean option) {
		this.setVisible(option);
	}
	
	
	public void valiateRadioButton() {
		JPanel.valiateRadioButton();
	}
	
	
	/*Obtener valores */
	
	public String getTxtSeed() {
		return JPanel.getTxtSeed();
	}

	public void setTxtSeed(String txtSeed) {
		this.JPanel.setTxtSeed(txtSeed);;
	}

	public String getTxtVarT() {
		return JPanel.getTxtVarT();
	}

	public void setTxtVarT(String txtVarT) {
		this.JPanel.setTxtVarT(txtVarT);;
	}

	public String getTxtVarG() {
		return JPanel.getTxtVarG();
	}

	public void setTxtVarG(String txtVarG) {
		this.JPanel.setTxtVarG(txtVarG);;
	}
	
	public String getTxtQuantity() {
		return JPanel.getTxtQuantity() ;
	}

	public void setTxtQuantity(String txtQuantity) {
		this.JPanel.setTxtQuantity(txtQuantity);;
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

	
	
	/*Obtener valores uniforme*/
	
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
		this.JPanel.setTxtOneNormal(txtOneNormal);
	}
	
	
	
	public String getTxtTwoNormal() {
		return JPanel.getTxtTwoNormal();
	}

	public void setTxtTwoNormal(String txtTwoNormal) {
		this.JPanel.setTxtTwoNormal(txtTwoNormal);;
	}


	

}
