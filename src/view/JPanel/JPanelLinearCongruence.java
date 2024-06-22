package view.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Constants;

public class JPanelLinearCongruence extends JPanel {

	/**
	 * 
	 */
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
		this.setLayout(new GridBagLayout());
		initComponents(listener);
		this.setBackground(new Color(91,91,91));
	}

	private void initComponents(ActionListener listener) {
		lblTittle = new JLabel("Llene los datos por favor: ");
		lblTittle.setForeground(Color.white);
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(lblTittle, getGbc(0, 0,18));
		JPanel panelAux = new JPanel();
		panelAux.setBackground(new Color(91,91,91));
		panelAux.setLayout((new GridLayout(6, 1)));
		lblSeed = new JLabel("Ingrese la semilla: ");
		lblSeed.setForeground(Color.white);
		panelAux.add(lblSeed);
		txtSeed = new JTextField();
		panelAux.add(txtSeed);
		lblVarK = new JLabel("Ingrese la variable K: ");
		lblVarK.setForeground(Color.white);
		panelAux.add(lblVarK);
		txtVarK = new JTextField();
		panelAux.add(txtVarK);
		lblVarC = new JLabel("Ingresa la variable C: ");
		lblVarC.setForeground(Color.white);
		panelAux.add(lblVarC);
		txtVarC = new JTextField();
		panelAux.add(txtVarC);
		lblVarG = new JLabel("Ingresa la variable G: ");
		lblVarG.setForeground(Color.white);
		panelAux.add(lblVarG);
		txtVarG = new JTextField();
		panelAux.add(txtVarG);
		lblQuantity = new JLabel("Ingrese la cantidad de numeros a generar: ");
		lblQuantity.setForeground(Color.white);
		panelAux.add(lblQuantity);
		txtQuantity = new JTextField();
		panelAux.add(txtQuantity);
		lblNormalDistribution = new JLabel("Elija la distribucion: ");
		lblNormalDistribution.setForeground(Color.white);
		panelAux.add(lblNormalDistribution);
		panelAux.add(getButtonGroup(listener));
		this.add(panelAux, getGbc(0, 1,0));
		panelAuxUniform = new JPanel();
		panelAuxNormal = new JPanel();
		createOptionsUniform();
		createOptionsNormal();
		btnAdd = new JButton("Generar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.GET_ADD_LINEAR_CONGRUENCE);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorder(new RoundedBorder(10));
		this.add(btnAdd,getGbc(0,3,0));

	}
	
	


	public JPanel getButtonGroup(ActionListener listener) {
		JPanel panelAux = new JPanel();
		panelAux.setBackground(new Color(91,91,91));
		panelAux.setLayout(new GridLayout(2,1));
		rbtnNormalDistribution = new JRadioButton("Distribucion normal");
		rbtnNormalDistribution.setForeground(Color.white);
		rbtnNormalDistribution.setBackground(new Color(91,91,91));
		rbtnNormalDistribution.addActionListener(listener);
		rbtnNormalDistribution.setActionCommand(Constants.GET_MESSAGE_SELECT_NORMAL_LINEAR_CONGRUENCE);
		rbtnUniformDistribution = new JRadioButton("Distribucion uniforme");
		rbtnUniformDistribution.setForeground(Color.white);
		rbtnUniformDistribution.setBackground(new Color(91,91,91));
		rbtnUniformDistribution.addActionListener(listener);
		rbtnUniformDistribution.setActionCommand(Constants.GET_MESSAGE_SELECT_UNIFORM_LINEAR_CONGRUENCE);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnNormalDistribution);
		group.add(rbtnUniformDistribution);
		panelAux.add(rbtnNormalDistribution);
		panelAux.add(rbtnUniformDistribution);
		return panelAux;
	}

	public GridBagConstraints getGbc(int x, int y,int low) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(0,0,low,0);
		return gbc;

	}

	public void createOptionsUniform() {
		panelAuxUniform.setLayout(new GridLayout(2, 1));
		panelAuxUniform.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingrese el limite inferior: ");
		lblOne.setForeground(Color.white);
		panelAuxUniform.add(lblOne);
		txtOneUniform = new JTextField();
		panelAuxUniform.add(txtOneUniform);
		JLabel lblTwo = new JLabel("Ingrese el limite superior: ");
		lblTwo.setForeground(Color.white);
		panelAuxUniform.add(lblTwo);
		txtTwoUniform = new JTextField();
		panelAuxUniform.add(txtTwoUniform);
		panelAuxUniform.setVisible(false);
		this.add(panelAuxUniform, getGbc(0, 2,0));
	}

	public void createOptionsNormal() {
		panelAuxNormal.setLayout(new GridLayout(2, 1));
		panelAuxNormal.setBackground(new Color(91,91,91));
		JLabel lblOne = new JLabel("Ingrese la media: ");
		lblOne.setForeground(Color.white);
		panelAuxNormal.add(lblOne);
		txtOneNormal = new JTextField();
		panelAuxNormal.add(txtOneNormal);
		JLabel lblTwo = new JLabel("Ingrese la desviacion estandar: ");
		lblTwo.setForeground(Color.white);
		panelAuxNormal.add(lblTwo);
		txtTwoNormal = new JTextField();
		panelAuxNormal.add(txtTwoNormal);
		panelAuxNormal.setVisible(false);
		this.add(panelAuxNormal, getGbc(0, 2,0));
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
	
	/*Obtener datos de congruencia lineal*/

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
	
	
	/*Obtener get an setter en distribucion uniforme*/
	
	
	
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

	/*Obtener get an setter en distribucion normal*/
	
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
