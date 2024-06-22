package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.JPanel.JPanelNumbers;
import java.awt.Color;
import java.awt.Dimension;

public class View extends JFrame{
	
	private ButtonsPanel buttonP;
	private Table table;
	private JDialogLeastSquares leastSquares;
	private JDialogLinearCongruence linearCongruence;
	private JDialogMultiplicativeCongruence multiplicativeCongruence;
	@SuppressWarnings("unused")
	private JDialogGrafics JDialogGrafics;
	private JPanelNumbers numbers;
	@SuppressWarnings("unused")
	private ActionListener listener;
	public int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public View(ActionListener listener) {
		super("De la generacion de numeros...");
		this.listener = listener;
		this.setSize(width-450, height-200);
//		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		initComponents(listener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(table,BorderLayout.CENTER);
		this.add(buttonP,BorderLayout.WEST);
		this.add(numbers,BorderLayout.SOUTH);
	}


	private void initComponents(ActionListener listener) {
		table = new Table(listener);
		table.setBackground(new Color(91, 91, 91));
//		getContentPane().add(table,BorderLayout.CENTER);
		buttonP = new ButtonsPanel(listener);
		buttonP.lblTittle.setForeground(new Color(255, 255, 255));
		buttonP.setBackground(new Color(91, 91, 91));
		buttonP.setPreferredSize(new Dimension(350,50));
//		getContentPane().add(header,BorderLayout.NORTH);
		numbers = new JPanelNumbers();
		numbers.setBackground(new Color(91, 91, 91));
		numbers.setForeground(new Color(255, 255, 255));
//		getContentPane().add(numbers,BorderLayout.SOUTH);
		leastSquares = new JDialogLeastSquares(this,listener);
		linearCongruence = new JDialogLinearCongruence(this,listener);
		multiplicativeCongruence = new JDialogMultiplicativeCongruence(this,listener);
	}
	
	
	public void initializedJDialogLeastSquares(boolean option) {
		leastSquares.getOption(option);
	}
	
	
	public void initializedJDialogLinearCongruence(boolean option) {
		linearCongruence.getOption(option);
	}
	
	
	
	
	public void initializedJDialogMultiplicativeCongruence(boolean option) {
		multiplicativeCongruence.getOption(option);
	}
	
	
	
	public void validateRadioButtonLeastSquares() {
		leastSquares.valiateRadioButton();
	}
	
	
	public void validateRadioButtonLinearCongruence() {
		linearCongruence.valiateRadioButton();
	}
	
	
	
	public void validateRadioButtonMultiplicativeCongruence() {
		multiplicativeCongruence.valiateRadioButton();
	}
	
	
	/*Valores del JDialog de congruencia lineal*/
	
	public String getTxtSeed() {
		return linearCongruence.getTxtSeed();
	}

	public void setTxtSeed(String txtSeed) {
		this.linearCongruence.setTxtSeed(txtSeed);
	}

	public String getTxtVarK() {
		return linearCongruence.getTxtVarK();
	}

	public void setTxtVarK(String txtVarK) {
		this.linearCongruence.setTxtVarK(txtVarK);
	}

	public String getTxtVarC() {
		return linearCongruence.getTxtVarC();
	}

	public void setTxtVarC(String txtVarC) {
		this.linearCongruence.setTxtVarC(txtVarC);
	}

	public String getTxtVarG() {
		return linearCongruence.getTxtVarG();
	}

	public void setTxtVarG(String txtVarG) {
		this.linearCongruence.setTxtVarG(txtVarG);
	}
	
	
	public String getTxtQuantity() {
		return linearCongruence.getTxtQuantity();
	}

	public void setTxtQuantity(String txtQuantity) {
		this.linearCongruence.setTxtQuantity(txtQuantity);;
	}
	
	
	
	
	
	public boolean isSelectRadioButton() {
		return linearCongruence.isSelectRadioButton() ;
	}
	
	public String getTxtOneUniform() {
		return linearCongruence.getTxtOneUniform();
	}

	public void setTxtOneUniform(String txtOneUniform) {
		this.linearCongruence.setTxtOneUniform(txtOneUniform);
	}
	
	
	
	public String getTxtTwoUniform() {
		return linearCongruence.getTxtTwoUniform();
	}


	public void setTxtTwoUniform(String txtTwoUniform) {
		this.linearCongruence.setTxtTwoUniform(txtTwoUniform);
	}
	
	public String getTxtOneNormal() {
		return linearCongruence. getTxtOneNormal();
	}

	public void setTxtOneNormal(String txtOneNormal) {
		this.linearCongruence.setTxtOneNormal(txtOneNormal);;
	}
	

	public String getTxtTwoNormal() {
		return linearCongruence.getTxtTwoNormal();
	}

	public void setTxtTwoNormal(String txtTwoNormal) {
		this.linearCongruence.setTxtTwoNormal(txtTwoNormal);;
	}
	
	
	
	public boolean isSelectrbtnNormalDistribution() {
		return linearCongruence.isSelectrbtnNormalDistribution();
	}
	
	public boolean isSelectrbtnUniformDistribution() {
		return linearCongruence. isSelectrbtnUniformDistribution();
	}
	
	
	
	/*Variable JDialog congruencia multiplicativa*/
	
	public String getTxtSeedMultiplicative() {
		return multiplicativeCongruence.getTxtSeed();
	}

	public void setTxtSeedMultiplicative(String txtSeed) {
		this.multiplicativeCongruence.setTxtSeed(txtSeed);;
	}

	public String getTxtVarTMultiplicative() {
		return multiplicativeCongruence.getTxtVarT();
	}

	public void setTxtVarTMultiplicative(String txtVarT) {
		this.multiplicativeCongruence.setTxtVarT(txtVarT);;
	}

	public String getTxtVarGMultiplicative() {
		return multiplicativeCongruence.getTxtVarG();
	}

	public void setTxtVarGMultiplicative(String txtVarG) {
		this.multiplicativeCongruence.setTxtVarG(txtVarG);;
	}
	
	public String getTxtQuantityMultiplicative() {
		return multiplicativeCongruence.getTxtQuantity() ;
	}

	public void setTxtQuantityMultiplicative(String txtQuantity) {
		this.multiplicativeCongruence.setTxtQuantity(txtQuantity);;
	}

	
	public boolean isSelectRadioButtonMultiplicative() {
		return multiplicativeCongruence.isSelectRadioButton();
	}
	
	public boolean isSelectrbtnNormalDistributionMultiplicative() {
		return multiplicativeCongruence.isSelectrbtnNormalDistribution();
	}
	
	public boolean isSelectrbtnUniformDistributionMultiplicative() {
		return multiplicativeCongruence.isSelectrbtnUniformDistribution();
	}

	
	/*Obtener valores distribucion normal y uniforme*/
	

	/*Obtener valores uniforme*/
	
	public String getTxtOneUniformMultiplicative() {
		return multiplicativeCongruence.getTxtOneUniform();
	}

	public void setTxtOneUniformMultiplicative(String txtOneUniform) {
		this.multiplicativeCongruence.setTxtOneUniform(txtOneUniform);;
	}
	
	
	public String getTxtTwoUniformMultiplicative() {
		return multiplicativeCongruence.getTxtTwoUniform();
	}

	public void setTxtTwoUniformMultiplicative(String txtTwoUniform) {
		this.multiplicativeCongruence.setTxtTwoUniform(txtTwoUniform);;
	}
	
	

	/*Obtener get an setter en distribucion normal*/
	
	public String getTxtOneNormalMultiplicative() {
		return multiplicativeCongruence.getTxtOneNormal();
	}

	public void setTxtOneNormalMultiplicative(String txtOneNormal) {
		this.multiplicativeCongruence.setTxtOneNormal(txtOneNormal);
	}
	
	
	
	public String getTxtTwoNormalMultiplicative() {
		return multiplicativeCongruence.getTxtTwoNormal();
	}

	public void setTxtTwoNormalMultiplicative(String txtTwoNormal) {
		this.multiplicativeCongruence.setTxtTwoNormal(txtTwoNormal);;
	}

	
	
	/*
	 * Variable JDialog cuadrados medios
	 * */
	
	
	public String getTxtSeedLeastSquares() {
		return leastSquares.getTxtSeed();
	}
	
	public void setTxtSeedLeastSquares(String txtSeed) {
		this.leastSquares.setTxtSeed(txtSeed);;
	}

	public String getTxtQuantityLeastSquares() {
		return leastSquares.getTxtQuantity();
	}

	public void setTxtQuantityLeastSquares(String txtQuantity) {
		this.leastSquares.setTxtQuantity(txtQuantity);
	}
	
	public boolean isSelectRadioButtonLeastSquares() {
		return leastSquares.isSelectRadioButton();
	}
	
	public boolean isSelectrbtnNormalDistributionLeastSquares() {
		return leastSquares.isSelectrbtnNormalDistribution();
	}
	
	public boolean isSelectrbtnUniformDistributionLeastSquares() {
		return leastSquares.isSelectrbtnUniformDistribution();
	}

/*Obtener get an setter en distribucion uniforme*/
	
	
	public String getTxtOneUniformLeastSquares() {
		return leastSquares.getTxtOneUniform();
	}
	

	public void setTxtOneUniformLeastSquares(String txtOneUniform) {
		this.leastSquares.setTxtOneUniform(txtOneUniform);;
	}

	public String getTxtTwoUniformLeastSquares() {
		return leastSquares.getTxtTwoUniform();
	}

	public void setTxtTwoUniformLeastSquares(String txtTwoUniform) {
		this.leastSquares.setTxtTwoUniform(txtTwoUniform);;
	}
	

	/*Obtener get an setter en distribucion normal*/
	
	
	
	public String getTxtOneNormalLeastSquares() {
		return leastSquares.getTxtOneNormal();
	}


	public void setTxtOneNormalLeastSquares(String txtOneNormal) {
		this.leastSquares.setTxtOneNormal(txtOneNormal);;
	}
	

	public String getTxtTwoNormalLeastSquares() {
		return leastSquares.getTxtTwoNormal();
	}

	public void setTxtTwoNormalLeastSquares(String txtTwoNormal) {
		this.leastSquares.setTxtTwoNormal(txtTwoNormal);;
	}


	
	
	
	
	/*
	 * 
	 * Generar errores
	 * */
	
	public void getMessageErrorEmpty() {
		JOptionPane.showMessageDialog(this, "Existen algunos valores vacios por favor llene correctamente","error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorEmptyRadioButtonUniform() {
		JOptionPane.showMessageDialog(this, "Por favor llene los limites","error",JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void getMessageErrorNumberFormatException() {
		JOptionPane.showMessageDialog(this, "Por favor ingrese solo numeros","error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorLeastSquares() {
		JOptionPane.showMessageDialog(this, "El numero debe tener 3 cifras o mas y debe ser par","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorVarG() {
		JOptionPane.showMessageDialog(this, "La variable debe ser mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorLimit() {
		JOptionPane.showMessageDialog(this, "El limite inferior debe tener un numero menor","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void getMessageErrorLittleQuantity() {
		JOptionPane.showMessageDialog(this, "Se debe tener mas de 1 dato generado","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorGraficsNormal() {
		JOptionPane.showMessageDialog(this, "Los datos no son de distribucion normal","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void getMessageErrorSelectionJButton() {
		JOptionPane.showMessageDialog(this, "Por favor de seleccionar otra vez la opcion a elegir en el radio button","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	/*Jtable metodo*/

	public void initJTable(ArrayList<ArrayList<Double>> list) {
		table.initJTable(list);
	}

	public int quantityValues() {

		return table.quantityValues();
		
		
	}
	
	
	public ArrayList<Double> getValues() {
		return table.getValues();
	}
	
	
	/*Graficas*/
	
	public void initializedJDialogGrafics(ArrayList<Double> list,boolean isNormal) {
		JDialogGrafics = new JDialogGrafics(this,list,isNormal);
	}
	
	/*
	 * Metodos del panel numeros
	 * */
	

	public String getLblWriteOne() {
		return numbers.getLblWriteOne();
	}



	public void setLblWriteOne(String lblWriteOne) {
		this.numbers.setLblWriteOne(lblWriteOne);;
	}


	public String getLblWriteTwo() {
		return numbers.getLblWriteTwo();
	}


	public void setLblWriteTwo(String lblWriteTwo) {
		this.numbers.setLblWriteTwo(lblWriteTwo);;
	}
	
	
	public String getLblReadOne() {
		return numbers.getLblReadOne();
	}


	public void setLblReadOne(String lblReadOne) {
		this.numbers.setLblReadOne(lblReadOne);;
	}


	public String getLblReadTwo() {
		return numbers.getLblReadTwo();
	}


	public void setLblReadTwo(String lblReadTwo) {
		this.numbers.setLblReadTwo(lblReadTwo);
	}
	
	
	
}
