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

public class JPanelLeastSquares extends JPanel {

	/**
	 * 
	 */
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
	
	
	public JPanelLeastSquares(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(91,91,91));
		initComponents(listener);
	}
	
	

	private void initComponents(ActionListener listener) {
		lblTittle = new JLabel("Llene los campos favor: ");
		lblTittle.setForeground(Color.white);
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(lblTittle,getGbc(0,0,20));
		JPanel panelAux = new JPanel();
		panelAux.setBackground(new Color(91,91,91));
		panelAux.setLayout((new GridLayout(3,1)));
		lblSeed = new JLabel("Ingrese su semilla:");
		lblSeed.setForeground(Color.white);
		panelAux.add(lblSeed);
		txtSeed = new JTextField();
		panelAux.add(txtSeed);
		lblQuantity = new JLabel("Ingrese cantidad de n°s a generar: ");
		lblQuantity.setForeground(Color.white);
		panelAux.add(lblQuantity);
		txtQuantity = new JTextField();
		panelAux.add(txtQuantity);
		lblNormalDistribution = new JLabel("Elija la distribucion: ");
		lblNormalDistribution.setForeground(Color.white);
		panelAux.add(lblNormalDistribution);
		panelAux.add(getButtonGroup(listener));
		this.add(panelAux,getGbc(0,1,0));
		panelAuxUniform = new JPanel();
		panelAuxUniform.setBackground(new Color(91,91,91));
		panelAuxNormal = new JPanel();
		panelAuxNormal.setBackground(new Color(91,91,91));
		createOptionsUniform();
		createOptionsNormal();
		btnAdd = new JButton("Generar");
		btnAdd.addActionListener(listener);
		btnAdd.setActionCommand(Constants.GET_MESSAGE_GENERATE_LEAST_SQUARES);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorder(new RoundedBorder(10));
		this.add(btnAdd,getGbc(0,5,3));
		
	}
	
	public GridBagConstraints getGbc(int x,int y,int low) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(0,0,low,0);
		return gbc;
		
	}
	
	public JPanel getButtonGroup(ActionListener listener) {
		JPanel panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(2,1));
		rbtnNormalDistribution =new JRadioButton("Distribucion normal");
		rbtnNormalDistribution.setForeground(Color.white);
		rbtnNormalDistribution.addActionListener(listener);
		rbtnNormalDistribution.setActionCommand(Constants.GET_MESSAGE_SELECT_NORMAL_LEAST_SQUARES);
		rbtnNormalDistribution.setBackground(new Color(91,91,91));
		rbtnUniformDistribution =new JRadioButton("Distribucion uniforme");
		rbtnUniformDistribution.setForeground(Color.white);
		rbtnUniformDistribution.addActionListener(listener);
		rbtnUniformDistribution.setActionCommand(Constants.GET_MESSAGE_SELECT_UNIFORM_LEAST_SQUARES);
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
		panelAuxUniform.setLayout(new  GridLayout(2,1));
		JLabel lblOne = new JLabel("Ingrese el limite inferior: ");
		lblOne.setForeground(Color.white);
		panelAuxUniform.add(lblOne);
		txtOneUniform = new JTextField();
		panelAuxUniform.add(txtOneUniform);
		JLabel lblTwo= new JLabel("Ingrese el limite superior: ");
		lblTwo.setForeground(Color.white);
		panelAuxUniform.add(lblTwo);
		txtTwoUniform = new JTextField();
		panelAuxUniform.add(txtTwoUniform);
		panelAuxUniform.setVisible(false);
		this.add(panelAuxUniform,getGbc(0,2,0));
	}
	

	public void createOptionsNormal() {
		panelAuxNormal.setLayout(new GridLayout(2, 1));
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
	
	/*Obtener datos*/
	
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
		this.txtTwoUniform.setText(txtTwoUniform);;
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
