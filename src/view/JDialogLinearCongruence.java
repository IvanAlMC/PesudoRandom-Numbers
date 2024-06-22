package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import view.JPanel.JPanelLinearCongruence;

public class JDialogLinearCongruence extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelLinearCongruence myJPanel;
	
	
	public JDialogLinearCongruence(JFrame frame,ActionListener listener) {
		super(frame,"Genere sus numeros con el metodo de congruencia lineal",true);
		initComponents(listener);
		this.setLocationRelativeTo(frame);
		this.setSize(520,430);
		this.setLocationRelativeTo(this);
		this.setVisible(false);
		this.setBackground(new Color(91,91,91));
	}


	private void initComponents(ActionListener listener) {
		myJPanel = new JPanelLinearCongruence(listener);
		myJPanel.setBackground(new Color(91,91,91));
		this.add(myJPanel);
	}
	
	public void getOption(boolean option) {
		this.setVisible(option);
	}
	
	
	public void valiateRadioButton() {
		myJPanel.valiateRadioButton();
	}
	

	/*JTextField de cada uno de los parametros del metodo de congruencia lineal*/
	
	public String getTxtSeed() {
		return myJPanel.getTxtSeed();
	}

	public void setTxtSeed(String txtSeed) {
		this.myJPanel.setTxtSeed(txtSeed);
	}

	public String getTxtVarK() {
		return myJPanel.getTxtVarK();
	}

	public void setTxtVarK(String txtVarK) {
		this.myJPanel.setTxtVarK(txtVarK);
	}

	public String getTxtVarC() {
		return myJPanel.getTxtVarC();
	}

	public void setTxtVarC(String txtVarC) {
		this.myJPanel.setTxtVarC(txtVarC);
	}

	public String getTxtVarG() {
		return myJPanel.getTxtVarG();
	}

	public void setTxtVarG(String txtVarG) {
		this.myJPanel.setTxtVarG(txtVarG);
	}
	
	public String getTxtQuantity() {
		return myJPanel.getTxtQuantity();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.myJPanel.setTxtQuantity(txtQuantity);;
	}
	
	
	
	public boolean isSelectRadioButton() {
		return myJPanel.isSelectRadioButton() ;
	}
	
	public boolean isSelectrbtnNormalDistribution() {
		return myJPanel.isSelectrbtnNormalDistribution();
	}
	
	public boolean isSelectrbtnUniformDistribution() {
		return myJPanel.isSelectrbtnUniformDistribution();
	}
	
	
	public String getTxtOneNormal() {
		return myJPanel. getTxtOneNormal();
	}

	public void setTxtOneNormal(String txtOneNormal) {
		this.myJPanel.setTxtOneNormal(txtOneNormal);;
	}
	
	

	public String getTxtTwoNormal() {
		return myJPanel.getTxtTwoNormal();
	}

	public void setTxtTwoNormal(String txtTwoNormal) {
		this.myJPanel.setTxtTwoNormal(txtTwoNormal);;
	}
	
	
	
	
	
	
	public String getTxtOneUniform() {
		return myJPanel.getTxtOneUniform();
	}

	public void setTxtOneUniform(String txtOneUniform) {
		this.myJPanel.setTxtOneUniform(txtOneUniform);
	}

	
	
	
	public String getTxtTwoUniform() {
		return myJPanel.getTxtTwoUniform();
	}


	public void setTxtTwoUniform(String txtTwoUniform) {
		this.myJPanel.setTxtTwoUniform(txtTwoUniform);
	}
	
	
	
	
	
	
	
}
