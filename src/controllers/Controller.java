package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.Commands;
import models.GeneratorPseudoRandomNumbers;
import views.View;

public class Controller implements ActionListener {
	
	private GeneratorPseudoRandomNumbers manager;
	private View view;
	private boolean optionValueUniformLinear;
	private boolean optionValueNormalLinear;
	private boolean optionValueUniformMultiplicative;
	private boolean optionValueNormalMultiplicative;
	private boolean optionValueUniformLeastSquares;
	private boolean optionValueNormalLeastSquares;
	
	public Controller() {
		manager = new GeneratorPseudoRandomNumbers();
		view = new View(this);
	}
	
	/*
	 * Estos son los respetivos eventos que uniran nuestra 
	 * interfaz graficas con la logica del programa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Commands.GENERATE_LEASTE_SQUARES:
			view.initializedJDialogLeastSquares(true);
			break;
		case Commands.GENERATE_LINEAR_CONGRUENCE:
			view.initializedJDialogLinearCongruence(true);
			break;
		case Commands.GENERATE_MULTIPLICATE_CONGRUENCE:
			view.initializedJDialogMultiplicativeCongruence(true);
			break;
		case Commands.SELECT_UNIFORM_LEAST_SQUARES:
			view.validateRadioButtonLeastSquares();
			/*Distribucion uniforme cuadrados medios*/
			optionValueUniformLeastSquares = true;
			optionValueUniformLinear = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLeastSquares = false;
			optionValueNormalLinear = false;
			optionValueNormalMultiplicative = false;
			getValuesDistributionLeastSquares();
			break;
		case Commands.SELECT_NORMAL_LEAST_SQUARES:
			view.validateRadioButtonLeastSquares();
			/*Distribucion normal cuadrados medios*/
			optionValueNormalLeastSquares = true;
			optionValueNormalLinear = false;
			optionValueNormalMultiplicative = false;
			optionValueUniformLeastSquares = false;
			optionValueUniformLinear = false;
			optionValueUniformMultiplicative = false;
			getValuesDistributionLeastSquares();
			break;
		case Commands.SELECT_UNIFORM_LINEAR_CONGRUENCE:
			view.validateRadioButtonLinearCongruence();
			/*Distribucion uniforme congruencia lineal*/
			optionValueUniformLinear = true;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLinear = false;
			optionValueNormalLeastSquares = false;
			optionValueNormalMultiplicative = false;
			getValuesDistributionLinear();
			break;
		case Commands.SELECT_NORMAL_LINEAR_CONGRUENCE:
			view.validateRadioButtonLinearCongruence();
			view.validateRadioButtonLinearCongruence();
			/*Distribucion normal congruencia lineal*/
			optionValueUniformLinear = false;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLinear = true;
			optionValueNormalLeastSquares = false;
			optionValueNormalMultiplicative = false;
			getValuesDistributionLinear();
			break;
		case Commands.SELECT_NORMAL_MULTIPLICATIVE_CONGRUENCE:
			view.validateRadioButtonMultiplicativeCongruence();
			/*Distribucion normal congruencia multiplicativa*/
			optionValueUniformLinear = false;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLinear = false;
			optionValueNormalLeastSquares = false;
			optionValueNormalMultiplicative = true;
			getValuesDistributionMultiplicative();
			break;
		case Commands.SELECT_UNIFORM_MULTIPLICATIVE_CONGRUENCE:
			view.validateRadioButtonMultiplicativeCongruence();
			/*Distribucion uniforme congruencia multiplicativa*/
			optionValueUniformLinear = false;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = true;
			optionValueNormalMultiplicative = false;
			optionValueNormalLinear = false;
			optionValueNormalLeastSquares = false;
			getValuesDistributionMultiplicative();
			break;
		case Commands.ADD_LINEAR_CONGRUENCE:
			getValuesCongruentialLinear();
			break;
		case Commands.ADD_MULTIPLICATIVE_CONGRUENCE:
			getValuesCongruentialMultiplicative();
			break;
		case Commands.GENERATE_LEAST_SQUARES:
			getValuesMeanSquares();
			break;
		case Commands.ADD_GENERATE_GRAPHIC:
			initialiedJDialogGrafics();
			break;
		default:
			break;
		}
		
	}
	
	/*
	 * Con este metodo obtenemos los valores por el metodo de cuadrados medios
	 */
	public void getValuesMeanSquares() {
		try {
			String seed = view.getSeedLeastSquares();
			boolean isSelect = view.isSelectRadioButtonLeastSquares();
			String[] array = getValuesDistributionLeastSquares();
			String quantity = view.getTxtQuantityLeastSquares();
			String lowerLimit = array[0];
			String upperLimit = array[1];
			if (seed.equals("") || !isSelect || lowerLimit.equals("") || upperLimit.equals("") || quantity.equals("")) {
				view.getMessageErrorEmpty();
			} else {
				try {
					int seedInt = Integer.parseInt(seed);
					if (manager.validateSeedMeanSquares(seedInt)) {
						double lowerLimitInt;
						double upperLimitInt;
						if (isNormalLeastSquares()) {
							lowerLimitInt = Double.parseDouble(lowerLimit);
							upperLimitInt = Double.parseDouble(upperLimit);
						} else {
							lowerLimitInt = Integer.parseInt(lowerLimit);
							upperLimitInt = Integer.parseInt(upperLimit);
						}
						int quantityInt = Integer.parseInt(quantity);
						ArrayList<ArrayList<Double>> listArrayXiAndRi = manager.getNumberListMeanSquares(seedInt,
								quantityInt);
						createMeanSquares(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
					} else {
						view.getMessageErrorLeastSquares();
					}

				} catch (NumberFormatException e) {
					view.getMessageErrorNumberFormatException();
				}
			}
			
		}catch(NullPointerException e) {
			view.getMessageErrorSelectionJButton();
		}
	}
	
	/*
	 * Este metodo valida la generacion se hara por metodo de cuadrados medios
	 * y la distribucion Normal
	 */
	public boolean isNormalLeastSquares() {
		if (optionValueNormalLeastSquares) {
			return true;
		}
		return false;
	}
	
	/*
	 * Con este metodo obtenemos los valores de metodo de congruencial lineal
	 */
	public void getValuesCongruentialLinear() {
		try {
			String seed = view.getSeed();
			String variableK = view.getVariableKLinear();
			String variableC = view.getVariableCLinear();
			String variableG = view.getVariableGLinear();
			boolean isSelect = view.isSelectRadioButton();
			String[] array = getValuesDistributionLinear();
			String quantity = view.getTxtQuantity();
			String lowerLimit = array[0];
			String upperLimit = array[1];
				if (seed.equals("") || variableK.equals("") || variableC.equals("") || variableG.equals("") || !isSelect || lowerLimit.equals("") || upperLimit.equals("") || quantity.equals("")) {
					view.getMessageErrorEmpty();
				} else {
					try {
						int seedInt = Integer.parseInt(seed);
						int variableKInt = Integer.parseInt(variableK);
						int variableCInt = Integer.parseInt(variableC);
						int variableGInt = Integer.parseInt(variableG);
						if(!manager.validateVariableG(variableGInt)) {
							view.getMessageErrorVarG();
						}else {
							double lowerLimitInt;
							double upperLimitInt;
							if (isNormalCongruentialLinear()) {
								lowerLimitInt = Double.parseDouble(lowerLimit);
								upperLimitInt = Double.parseDouble(upperLimit);
							} else {
								lowerLimitInt = Integer.parseInt(lowerLimit);
								upperLimitInt = Integer.parseInt(upperLimit);
							}
							int quantityInt = Integer.parseInt(quantity);
							ArrayList<ArrayList<Double>> listArrayXiAndRi = manager.getNumbersListCongruentialLinear(seedInt, variableKInt, variableCInt, variableGInt, quantityInt);
							createCongruentialLinear(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
						}
					} catch (NumberFormatException e) {
						view.getMessageErrorNumberFormatException();
					} 

				}
		}catch(NullPointerException e) {
			view.getMessageErrorSelectionJButton();
		}
	}

	/*
	 * Este metodo valida la generacion se hara por metodo de Congruencia Linear 
	 * y la distribucion Normal
	 */
	public boolean isNormalCongruentialLinear() {
		if (optionValueNormalLinear) {
			return true;
		}
		return false;
	}

	/*
	 * Este metodo obtiene los valores generados por el metodo de congruencia multiplicativo
	 */
	public void getValuesCongruentialMultiplicative() {
		try {
			String seed = view.getTxtSeedMultiplicative();
			String variableT = view.getVariableTMultiplicative();
			String variableG = view.getVariableGMultiplicative();
			boolean isSelect = view.isSelectRadioButtonMultiplicative();
			String[] array = getValuesDistributionMultiplicative();
			String quantity = view.getTxtQuantityMultiplicative();
			String lowerLimit = array[0];
			String upperLimit = array[1];
			if (seed.equals("") || variableT.equals("") || variableG.equals("") || !isSelect || lowerLimit.equals("") || upperLimit.equals("") || quantity.equals("")) {
				view.getMessageErrorEmpty();
			} else {
				try {
					int seedInt = Integer.parseInt(seed);
					int variableTInt = Integer.parseInt(variableT);
					int variableGInt = Integer.parseInt(variableG);
					if (!manager.validateVariableG(variableGInt)) {
						view.getMessageErrorVarG();
					} else {
						double lowerLimitInt;
						double upperLimitInt;
						if (isNormalCongruentialMultiplicative()) {
							lowerLimitInt = Double.parseDouble(lowerLimit);
							upperLimitInt = Double.parseDouble(upperLimit);
						} else {
							lowerLimitInt = Integer.parseInt(lowerLimit);
							upperLimitInt = Integer.parseInt(upperLimit);
						}
						int quantityInt = Integer.parseInt(quantity);
						ArrayList<ArrayList<Double>> listArrayXiAndRi = manager.getNumbersListCongruentialMultiplicative(seedInt, variableTInt, variableGInt, quantityInt);
						createCongruentialMultiplicative(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
					}
				} catch (NumberFormatException e) {
					view.getMessageErrorNumberFormatException();
				}
			}
		}catch(NullPointerException e) {
			view.getMessageErrorSelectionJButton();
		}
	}
	
	/*
	 * Este metodo valida la generacion se hara por metodo de Congruencia Mutiplicativa 
	 * y la distribucion Normal
	 */
	public boolean isNormalCongruentialMultiplicative() {
		if (optionValueNormalMultiplicative) {
			return true;
		}
		return false;
	}

	/*
	 * Este metodo nos inicia los datos en la tabla por medio de la congruencia lineal
	 */
	public void createCongruentialLinear(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit, double upperLimit) {
		view.initJTable(getNumbersNiLinear(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValuesLinear();
	}

	/*
	 * Este metood nos inicia los datos en la tabla por medio de la congruencia multiplicativa
	 */
	public void createCongruentialMultiplicative(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit, double upperLimit) {
		view.initJTable(getNumbersNiMultiplicative(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValuesMultiplicative();
	}

	/*
	 * Este metodo nos inicia los datos en la tabla por medio de cuadrados medios
	 */
	public void createMeanSquares(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit, double upperLimit) {
		view.initJTable(getNumbersLeastSquares(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValuesLeastSquares();
	}

	/*
	 * Este metodo nos obtinen los numeros Ni generados para la congruencia lineal
	 */
	public ArrayList<ArrayList<Double>> getNumbersNiLinear(double lowerLimit, double upperLimit, ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformLinear) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByUniformDistribution((int) lowerLimit, (int) upperLimit, listArrayXiAndRi.get(1)));
		}
		if (optionValueNormalLinear) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
		}
		return list;
	}

	/*
	 * Este metodo nos obtinen los numeros Ni generados para la congruencia multiplicativa
	 */
	public ArrayList<ArrayList<Double>> getNumbersNiMultiplicative(double lowerLimit, double upperLimit, ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformMultiplicative) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByUniformDistribution((int)lowerLimit, (int)upperLimit, listArrayXiAndRi.get(1)));
			
		}
		if (optionValueNormalMultiplicative) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
	
		}
		return list;
	}
	
	/*
	 * Este metodo nos obtinen los numeros Ni generados para cuadrados medios
	 */
	public ArrayList<ArrayList<Double>> getNumbersLeastSquares(double lowerLimit, double upperLimit, ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformLeastSquares) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByUniformDistribution((int)lowerLimit, (int)upperLimit, listArrayXiAndRi.get(1)));
		}
		if (optionValueNormalLeastSquares) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateByNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
		}
		return list;
	}

	/*
	 * Limipa los valores de la congruencia lineal
	 */
	public void cleanValuesLinear() {
		view.initializedJDialogLinearCongruence(false);
	}

	/*
	 * Limipa los valores de la congruencia multiplicativa
	 */
	public void cleanValuesMultiplicative() {
		view.initializedJDialogMultiplicativeCongruence(false);
	}

	/*
	 * Limipa los valores de cuadrados medios
	 */
	public void cleanValuesLeastSquares() {
		view.initializedJDialogLeastSquares(false);
	}

	/*
	 * Obtiene los valores de la congruencia lineal segun su distribucion
	 */
	public String[] getValuesDistributionLinear() {
		String[] array = new String[2];
		if (optionValueNormalLinear) {
			array[0] = view.getTxtOneNormal();
			array[1] = view.getTxtTwoNormal();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		if (optionValueUniformLinear) {
			array[0] = view.getTxtOneUniform();
			array[1] = view.getTxtTwoUniform();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		return array;
	}

	/*
	 * Obtiene los valores de la congruencia multiplicativa segun su distribucion
	 */
	public String[] getValuesDistributionMultiplicative() {
		String[] array = new String[2];
		if (optionValueNormalMultiplicative) {
			array[0] = view.getTxtOneNormalMultiplicative();
			array[1] = view.getTxtTwoNormalMultiplicative();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		if (optionValueUniformMultiplicative) {
			array[0] = view.getTxtOneUniformMultiplicative();
			array[1] = view.getTxtTwoUniformMultiplicative();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		return array;
	}

	/*
	 * Obtiene los valores de cuadrados medios segun su distribucion
	 */
	public String[] getValuesDistributionLeastSquares() {
		String[] array = new String[2];
		if (optionValueNormalLeastSquares) {
			array[0] = view.getTxtOneNormalLeastSquares();
			array[1] = view.getTxtTwoNormalLeastSquares();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		if (optionValueUniformLeastSquares) {
			array[0] = view.getTxtOneUniformLeastSquares();
			array[1] = view.getTxtTwoUniformLeastSquares();
			if (array[0] != null || array[1] != null) {
				return array;
			}
		}
		return array;
	}
	
	/*
	 * Inicia el grafico
	 */
	public void initialiedJDialogGrafics() {
		int quantity = view.quantityValues();
		if(quantity > 1) {
			if(optionValueNormalLinear || optionValueNormalMultiplicative || optionValueNormalLeastSquares) {
				view. initializedJDialogGrafics(view.getValues(),true);
			}else {
				view.initializedJDialogGrafics(view.getValues(),false);
			}	
		}else {
			view.getMessageErrorLittleQuantity();
		}
	}
}
