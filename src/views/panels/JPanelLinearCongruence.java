package views.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.Commands;

public class JPanelLinearCongruence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTittle;
	private JLabel lblSeed;
	private JTextField txtSeed;
	private JLabel lblVarK;
	private JTextField txtVarK;
	private JLabel lblVarC;
	private JTextField txtVarC;
	private JLabel lblVarG;
	private JTextField txtVarG;
	private JRadioButton rbtnNormalDistribution;
	private JRadioButton rbtnUniformDistribution;
	private JPanel panelAuxUniform;
	private JPanel panelAuxNormal;
	private JTextField txtOneUniform;
	private JTextField txtTwoUniform;
	private JTextField txtOneNormal;
	private JTextField txtTwoNormal;
	private JLabel lblNormalDistribution;
	private JLabel lblQuantity;
	private JTextField txtQuantity;
	private JButton btnAdd;

	public JPanelLinearCongruence(ActionListener listener) {
		initComponents(listener);
		this.setBackground(new Color(91,91,91));
	}

	private void initComponents(ActionListener listener) {
		lblTittle = new JLabel("Llene los datos");
		lblTittle.setForeground(Color.white);
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(lblTittle);
		JPanel panelAux = new JPanel();
		panelAux.setPreferredSize(new Dimension(450,200));
		panelAux.setBackground(new Color(91,91,91));
		lblSeed = new JLabel("Ingresar semilla: ");
		lblSeed.setForeground(Color.white);
		lblSeed.setPreferredSize(new Dimension(150,27));
		panelAux.add(lblSeed);
		txtSeed = new JTextField();
		txtSeed.setPreferredSize(new Dimension(200,27));
		panelAux.add(txtSeed);
		lblVarK = new JLabel("Ingresar variable K: ");
		lblVarK.setForeground(Color.white);
		lblVarK.setPreferredSize(new Dimension(150,27));
		panelAux.add(lblVarK);
		txtVarK = new JTextField();
		txtVarK.setPreferredSize(new Dimension(200,27));
		panelAux.add(txtVarK);
		lblVarC = new JLabel("Ingresar variable C: ");
		lblVarC.setForeground(Color.white);
		lblVarC.setPreferredSize(new Dimension(150,27));
		panelAux.add(lblVarC);
		txtVarC = new JTextField();
		txtVarC.setPreferredSize(new Dimension(200,27));
		panelAux.add(txtVarC);
		lblVarG = new JLabel("Ingresar variable G: ");
		lblVarG.setForeground(Color.white);
		lblVarG.setPreferredSize(new Dimension(150,27));
		panelAux.add(lblVarG);
		txtVarG = new JTextField();
		txtVarG.setPreferredSize(new Dimension(200,27));
		panelAux.add(txtVarG);
		lblQuantity = new JLabel("Ingresar la cantidad: ");
		lblQuantity.setForeground(Color.white);
		lblQuantity.setPreferredSize(new Dimension(150,27));
		panelAux.add(lblQuantity);
		txtQuantity = new JTextField();
		txtQuantity.setPreferredSize(new Dimension(200,27));
		panelAux.add(txtQuantity);
		lblNormalDistribution = new JLabel("Eligir distribucion: ");
		lblNormalDistribution.setForeground(Color.white);
		panelAux.add(lblNormalDistribution);
		panelAux.add(getButtonGroup(listener));
		this.add(panelAux);
		panelAuxUniform = new JPanel();
		panelAuxUniform.setPreferredSize(new Dimension(450,75));
		panelAuxNormal = new JPanel();
		panelAuxNormal.setPreferredSize(new Dimension(450,75));
		createOptionsUniform();
		createOptionsNormal();
		btnAdd = new JButton("Generar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Commands.ADD_LINEAR_CONGRUENCE);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorder(new RoundedBorder(10));
		this.add(btnAdd);
	}
	
	public JPanel getButtonGroup(ActionListener listener) {
		JPanel panelAux = new JPanel();
		panelAux.setBackground(new Color(91,91,91));
		rbtnNormalDistribution = new JRadioButton("Distribucion normal");
		rbtnNormalDistribution.setForeground(Color.white);
		rbtnNormalDistribution.setBackground(new Color(91,91,91));
		rbtnNormalDistribution.addActionListener(listener);
		rbtnNormalDistribution.setActionCommand(Commands.SELECT_NORMAL_LINEAR_CONGRUENCE);
		rbtnUniformDistribution = new JRadioButton("Distribucion uniforme");
		rbtnUniformDistribution.setForeground(Color.white);
		rbtnUniformDistribution.setBackground(new Color(91,91,91));
		rbtnUniformDistribution.addActionListener(listener);
		rbtnUniformDistribution.setActionCommand(Commands.SELECT_UNIFORM_LINEAR_CONGRUENCE);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnNormalDistribution);
		group.add(rbtnUniformDistribution);
		panelAux.add(rbtnNormalDistribution);
		panelAux.add(rbtnUniformDistribution);
		return panelAux;
	}

	public void createOptionsUniform() {
		panelAuxUniform.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingresar limite inferior: ");
		lblOne.setPreferredSize(new Dimension(150,27));
		lblOne.setForeground(Color.white);
		panelAuxUniform.add(lblOne);
		txtOneUniform = new JTextField();
		txtOneUniform.setPreferredSize(new Dimension(230,27));
		panelAuxUniform.add(txtOneUniform);
		JLabel lblTwo = new JLabel("Ingresar limite superior: ");
		lblTwo.setPreferredSize(new Dimension(150,27));
		lblTwo.setForeground(Color.white);
		panelAuxUniform.add(lblTwo);
		txtTwoUniform = new JTextField();
		txtTwoUniform.setPreferredSize(new Dimension(230,27));
		panelAuxUniform.add(txtTwoUniform);
		panelAuxUniform.setVisible(false);
		this.add(panelAuxUniform);
	}

	public void createOptionsNormal() {
		panelAuxNormal.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingresar media: ");
		lblOne.setPreferredSize(new Dimension(200,27));
		lblOne.setForeground(Color.white);
		panelAuxNormal.add(lblOne);
		txtOneNormal = new JTextField();
		txtOneNormal.setPreferredSize(new Dimension(200,27));
		panelAuxNormal.add(txtOneNormal);
		JLabel lblTwo = new JLabel("Ingresar desviacion estandar: ");
		lblTwo.setPreferredSize(new Dimension(200,27));
		lblTwo.setForeground(Color.white);
		panelAuxNormal.add(lblTwo);
		txtTwoNormal = new JTextField();
		txtTwoNormal.setPreferredSize(new Dimension(200,27));
		panelAuxNormal.add(txtTwoNormal);
		panelAuxNormal.setVisible(false);
		this.add(panelAuxNormal);
	}

	public void valiateRadioButton() {
		if (rbtnNormalDistribution.isSelected()) {
			getOptionsNormal();
		}
		if (rbtnUniformDistribution.isSelected()) {
			getOptionsUniform();
		}
	}	
	
	public boolean isSelectRadioButton() {
		return rbtnNormalDistribution.isSelected() || rbtnUniformDistribution.isSelected() ? true : false;
	}
	
	public boolean isSelectrbtnNormalDistribution() {
		return rbtnNormalDistribution.isSelected();
	}
	
	public boolean isSelectrbtnUniformDistribution() {
		return rbtnNormalDistribution.isSelected();
	}
	
	public void getOptionsUniform() {
		panelAuxNormal.setVisible(false);
		panelAuxUniform.setVisible(true);
	}

	public void getOptionsNormal() {
		panelAuxUniform.setVisible(false);
		panelAuxNormal.setVisible(true);
	}
	
	public String getTxtSeed() {
		return txtSeed.getText();
	}

	public void setTxtSeed(String txtSeed) {
		this.txtVarK.setText(txtSeed);
	}

	public String getTxtVarK() {
		return txtVarK.getText();
	}

	public void setTxtVarK(String txtVarK) {
		this.txtVarK.setText(txtVarK);
	}

	public String getTxtVarC() {
		return txtVarC.getText();
	}

	public void setTxtVarC(String txtVarC) {
		this.txtVarC.setText(txtVarC);
	}

	public String getTxtVarG() {
		return txtVarG.getText();
	}

	public void setTxtVarG(String txtVarG) {
		this.txtVarG.setText(txtVarG);
	}
	
	public String getTxtQuantity() {
		return txtQuantity.getText();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.txtQuantity.setText(txtQuantity);;
	}
	
	public String getTxtOneUniform() {
		return txtOneUniform.getText();
	}

	public void setTxtOneUniform(String txtOneUniform) {
		this.txtOneUniform.setText(txtOneUniform);;
	}

	public String getTxtTwoUniform() {
		return txtTwoUniform.getText();
	}


	public void setTxtTwoUniform(String txtTwoUniform) {
		this.txtTwoUniform.setText(txtTwoUniform);
	}

	public String getTxtOneNormal() {
		return txtOneNormal.getText();
	}

	public void setTxtOneNormal(String txtOneNormal) {
		this.txtOneNormal.setText(txtOneNormal);;
	}

	public String getTxtTwoNormal() {
		return txtTwoNormal.getText();
	}

	public void setTxtTwoNormal(String txtTwoNormal) {
		this.txtTwoNormal.setText(txtTwoNormal);;
	}
	
	private static class RoundedBorder implements Border {

	    private int radius;

	    @SuppressWarnings("unused")
		RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(x, y, width-1, height-1, radius, radius);	
		}
	}	
}
