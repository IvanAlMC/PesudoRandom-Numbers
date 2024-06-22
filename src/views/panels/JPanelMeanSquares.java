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

public class JPanelMeanSquares extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblSeed;
	private JTextField txtSeed;
	private JLabel lblNormalDistribution;
	private JLabel lblTittle;
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
	
	
	public JPanelMeanSquares(ActionListener listener) {
		this.setBackground(new Color(91,91,91));
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		lblTittle = new JLabel("Llene los datos");
		lblTittle.setForeground(Color.white);
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(lblTittle);
		JPanel panelAux = new JPanel();
		panelAux.setPreferredSize(new Dimension(400, 120));
		panelAux.setBackground(new Color(91,91,91));
		lblSeed = new JLabel("Ingresar semilla:");
		lblSeed.setPreferredSize(new Dimension(150, 30));
		lblSeed.setForeground(Color.white);
		panelAux.add(lblSeed);
		txtSeed = new JTextField();
		txtSeed.setPreferredSize(new Dimension(200,30));
		panelAux.add(txtSeed);
		lblQuantity = new JLabel("Ingresar cantidad: ");
		lblQuantity.setPreferredSize(new Dimension(150, 30));
		lblQuantity.setForeground(Color.white);
		panelAux.add(lblQuantity);
		txtQuantity = new JTextField();
		txtQuantity.setPreferredSize(new Dimension(200, 30));
		panelAux.add(txtQuantity);
		lblNormalDistribution = new JLabel("Eligir distribucion");
		lblNormalDistribution.setForeground(Color.white);
		panelAux.add(lblNormalDistribution);
		panelAux.add(getButtonGroup(listener));
		this.add(panelAux);
		panelAuxUniform = new JPanel();
		panelAuxUniform.setPreferredSize(new Dimension(400,75));
		panelAuxUniform.setBackground(new Color(91,91,91));
		panelAuxNormal = new JPanel();
		panelAuxNormal.setPreferredSize(new Dimension(400,75));
		panelAuxNormal.setBackground(new Color(91,91,91));
		createOptionsUniform();
		createOptionsNormal();
		btnAdd = new JButton("Generar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Commands.GENERATE_LEAST_SQUARES);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorder(new RoundedBorder(10));
		this.add(btnAdd);
	}
	
	public JPanel getButtonGroup(ActionListener listener) {
		JPanel panelAux = new JPanel();
		rbtnNormalDistribution =new JRadioButton("Distribucion normal");
		rbtnNormalDistribution.setForeground(Color.white);
		rbtnNormalDistribution.addActionListener(listener);
		rbtnNormalDistribution.setActionCommand(Commands.SELECT_NORMAL_LEAST_SQUARES);
		rbtnNormalDistribution.setBackground(new Color(91,91,91));
		rbtnUniformDistribution =new JRadioButton("Distribucion uniforme");
		rbtnUniformDistribution.setForeground(Color.white);
		rbtnUniformDistribution.addActionListener(listener);
		rbtnUniformDistribution.setActionCommand(Commands.SELECT_UNIFORM_LEAST_SQUARES);
		rbtnUniformDistribution.setBackground(new Color(91,91,91));
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnNormalDistribution);
		group.add(rbtnUniformDistribution);
		panelAux.add(rbtnNormalDistribution);
		panelAux.add(rbtnUniformDistribution);
		panelAux.setBackground(new Color(91,91,91));
		return panelAux;
	}

	public void valiateRadioButton() {
		if(rbtnNormalDistribution.isSelected()) {
			getOptionsNormal() ;
		}if(rbtnUniformDistribution.isSelected()) {
			getOptionsUniform();
		}
	}
	
	public void createOptionsUniform() {
		JLabel lblOne = new JLabel("Ingresar limite inferior: ");
		lblOne.setPreferredSize(new Dimension(150, 30));
		lblOne.setForeground(Color.white);
		panelAuxUniform.add(lblOne);
		txtOneUniform = new JTextField();
		txtOneUniform.setPreferredSize(new Dimension(150, 30));
		panelAuxUniform.add(txtOneUniform);
		JLabel lblTwo= new JLabel("Ingresar limite superior: ");
		lblTwo.setPreferredSize(new Dimension(150, 30));
		lblTwo.setForeground(Color.white);
		panelAuxUniform.add(lblTwo);
		txtTwoUniform = new JTextField();
		txtTwoUniform.setPreferredSize(new Dimension(150, 30));
		panelAuxUniform.add(txtTwoUniform);
		panelAuxUniform.setVisible(false);
		this.add(panelAuxUniform);
	}
	
	public void createOptionsNormal() {
		JLabel lblOne = new JLabel("Ingresar media: ");
		lblOne.setPreferredSize(new Dimension(170, 30));
		lblOne.setForeground(Color.white);
		panelAuxNormal.add(lblOne);
		txtOneNormal = new JTextField();
		txtOneNormal.setPreferredSize(new Dimension(120,30));
		panelAuxNormal.add(txtOneNormal);
		JLabel lblTwo = new JLabel("Ingresar desviacion estandar:");
		lblTwo.setPreferredSize(new Dimension(170, 30));
		lblTwo.setForeground(Color.white);
		panelAuxNormal.add(lblTwo);
		txtTwoNormal = new JTextField();
		txtTwoNormal.setPreferredSize(new Dimension(120,30));
		panelAuxNormal.add(txtTwoNormal);
		panelAuxNormal.setVisible(false);
		this.add(panelAuxNormal);
	}

	public void getOptionsUniform() {
		panelAuxNormal.setVisible(false);
		panelAuxUniform.setVisible(true);
	}
	
	public void getOptionsNormal() {
		panelAuxUniform.setVisible(false);
		panelAuxNormal.setVisible(true);
	}

	public void getOption(boolean option) {
		this.setVisible(option);
	}
	
	public String getTxtSeed() {
		return txtSeed.getText();
	}

	public void setTxtSeed(String txtSeed) {
		this.txtSeed.setText(txtSeed);;
	}

	public String getTxtQuantity() {
		return txtQuantity.getText();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.txtQuantity.setText(txtQuantity);
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
