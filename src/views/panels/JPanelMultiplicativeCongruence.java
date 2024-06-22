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

public class JPanelMultiplicativeCongruence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTittle;
	private JLabel lblSeed;
	private JTextField txtSeed;
	private JLabel lblVarT;
	private JTextField txtVarT;
	private JLabel lblVarG;
	private JTextField txtVarG;
	private JLabel lblNormalDistribution;
	private JRadioButton rbtnNormalDistribution;
	private JRadioButton rbtnUniformDistribution;
	private JPanel panelAuxUniform;
	private JPanel panelAuxNormal;
	private JTextField txtOneUniform;
	private JTextField txtTwoUniform;
	private JTextField txtOneNormal;
	private JTextField txtTwoNormal;
	private JLabel lblQuantity;
	private JTextField txtQuantity;
	private JButton btnAdd;
	
	public JPanelMultiplicativeCongruence(ActionListener listener) {
		this.setBackground(new Color(91,91,91));
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		lblTittle = new JLabel("Llenar los datos: ");
		lblTittle.setForeground(Color.white);
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(lblTittle);
		JPanel panelAux = new JPanel();
		panelAux.setPreferredSize(new Dimension(430,200));
		panelAux.setBackground(new Color(91,91,91));
		lblSeed = new JLabel("Ingresar semilla: ");
		lblSeed.setForeground(Color.white);
		lblSeed.setPreferredSize(new Dimension(150,30));
		panelAux.add(lblSeed);
		txtSeed = new JTextField();
		txtSeed.setPreferredSize(new Dimension(200,30));
		panelAux.add(txtSeed);
		lblVarT = new JLabel("Ingresar variable T: ");
		lblVarT.setForeground(Color.white);
		lblVarT.setPreferredSize(new Dimension(150,30));
		panelAux.add(lblVarT);
		txtVarT = new JTextField();
		txtVarT.setPreferredSize(new Dimension(200,30));
		panelAux.add(txtVarT);
		lblVarG = new JLabel("Ingresar variable G: ");
		lblVarG.setForeground(Color.white);
		lblVarG.setPreferredSize(new Dimension(150,30));
		panelAux.add(lblVarG);
		txtVarG = new JTextField();
		txtVarG.setPreferredSize(new Dimension(200,30));
		panelAux.add(txtVarG);
		lblQuantity = new JLabel("Ingresa la cantidad: ");
		lblQuantity.setForeground(Color.white);
		lblQuantity.setPreferredSize(new Dimension(150,30));
		panelAux.add(lblQuantity);
		txtQuantity = new JTextField();
		txtQuantity.setPreferredSize(new Dimension(200,30));
		panelAux.add(txtQuantity);
		lblNormalDistribution = new JLabel("Eligir la distribucion: ");
		lblNormalDistribution.setForeground(Color.white);
		panelAux.add(lblNormalDistribution);
		panelAux.add(getButtonGroup(listener));
		this.add(panelAux);
		panelAuxUniform = new JPanel();
		panelAuxUniform.setPreferredSize(new Dimension(420,75));
		panelAuxNormal = new JPanel();
		panelAuxNormal.setPreferredSize(new Dimension(420,75));
		createOptionsUniform();
		createOptionsNormal();	
		btnAdd = new JButton("Generar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Commands.ADD_MULTIPLICATIVE_CONGRUENCE);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorder(new RoundedBorder(10));
		this.add(btnAdd);
	}
	
	public JPanel getButtonGroup(ActionListener listener) {
		JPanel panelAux = new JPanel();
		rbtnNormalDistribution = new JRadioButton("Distribucion normal");
		rbtnNormalDistribution.setForeground(Color.white);
		rbtnNormalDistribution.setBackground(new Color(91,91,91));
		rbtnNormalDistribution.addActionListener(listener);
		rbtnNormalDistribution.setActionCommand(Commands.SELECT_NORMAL_MULTIPLICATIVE_CONGRUENCE);
		rbtnUniformDistribution = new JRadioButton("Distribucion uniforme");
		rbtnUniformDistribution.setBackground(new Color(91,91,91));
		rbtnUniformDistribution.setForeground(Color.white);
		rbtnUniformDistribution.addActionListener(listener);
		rbtnUniformDistribution.setActionCommand(Commands.SELECT_UNIFORM_MULTIPLICATIVE_CONGRUENCE);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnNormalDistribution);
		group.add(rbtnUniformDistribution);
		panelAux.add(rbtnNormalDistribution);
		panelAux.add(rbtnUniformDistribution);
		panelAux.setBackground(new Color(91,91,91));
		return panelAux;
	}
	
	public void createOptionsUniform() {
		panelAuxUniform.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingresar limite inferior: ");
		lblOne.setPreferredSize(new Dimension(150,30));
		lblOne.setForeground(Color.white);
		panelAuxUniform.add(lblOne);
		txtOneUniform = new JTextField();
		txtOneUniform.setPreferredSize(new Dimension(200,30));
		panelAuxUniform.add(txtOneUniform);
		JLabel lblTwo = new JLabel("Ingresar limite superior: ");
		lblTwo.setForeground(Color.white);
		lblTwo.setPreferredSize(new Dimension(150,30));
		panelAuxUniform.add(lblTwo);
		txtTwoUniform = new JTextField();
		txtTwoUniform.setPreferredSize(new Dimension(200,30));
		panelAuxUniform.add(txtTwoUniform);
		panelAuxUniform.setVisible(false);
		this.add(panelAuxUniform);
	}

	public void createOptionsNormal() {
		panelAuxNormal.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingresar media: ");
		lblOne.setPreferredSize(new Dimension(200,30));
		lblOne.setForeground(Color.white);
		panelAuxNormal.add(lblOne);
		txtOneNormal = new JTextField();
		txtOneNormal.setPreferredSize(new Dimension(170,30));
		panelAuxNormal.add(txtOneNormal);
		JLabel lblTwo = new JLabel("Ingresar desviacion estandar: ");
		lblTwo.setForeground(Color.white);
		lblTwo.setPreferredSize(new Dimension(200,30));
		panelAuxNormal.add(lblTwo);
		txtTwoNormal = new JTextField();
		txtTwoNormal.setPreferredSize(new Dimension(170,30));
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
		this.txtSeed.setText(txtSeed);;
	}

	public String getTxtVarT() {
		return txtVarT.getText();
	}

	public void setTxtVarT(String txtVarT) {
		this.txtVarT.setText(txtVarT);;
	}

	public String getTxtVarG() {
		return txtVarG.getText();
	}

	public void setTxtVarG(String txtVarG) {
		this.txtVarG.setText(txtVarG);;
	}
	
	public String getTxtQuantity() {
		return txtQuantity.getText();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.txtQuantity.setText(txtQuantity);;
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
		this.txtTwoUniform.setText(txtTwoUniform);;
	}
	
	public String getTxtOneNormal() {
		return txtOneNormal.getText();
	}

	public void setTxtOneNormal(String txtOneNormal) {
		this.txtOneNormal.setText(txtOneNormal);
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
