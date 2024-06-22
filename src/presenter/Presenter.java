package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Constants;
import model.Manager;
import view.View;

public class Presenter implements ActionListener {
	
	
	private Manager manager;
	private View view;
	private boolean optionValueUniformLinear;
	private boolean optionValueNormalLinear;
	private boolean optionValueUniformMultiplicative;
	private boolean optionValueNormalMultiplicative;
	private boolean optionValueUniformLeastSquares;
	private boolean optionValueNormalLeastSquares;
	
	private Presenter() {
		manager = new Manager();
		view = new View(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constants.GET_MESSAGE_GENERATE_LEASTE_SQUARES:
			view.initializedJDialogLeastSquares(true);
			break;
		case Constants.GET_MESSAGE_GENERATE_LINEAR_CONGRUENCE:
			view.initializedJDialogLinearCongruence(true);
			break;
		case Constants.GET_MESSAGE_GENERATE_MULTIPLICATE_CONGRUENCE:
			view.initializedJDialogMultiplicativeCongruence(true);
			break;
		case Constants.GET_MESSAGE_SELECT_UNIFORM_LEAST_SQUARES:
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
		case Constants.GET_MESSAGE_SELECT_NORMAL_LEAST_SQUARES:
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
		case Constants.GET_MESSAGE_SELECT_UNIFORM_LINEAR_CONGRUENCE:
			view.validateRadioButtonLinearCongruence();
			/*Distribucion uniforme congruencia lineal*/
			optionValueUniformLinear = true;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLinear = false;
			optionValueNormalLeastSquares = false;
			optionValueNormalMultiplicative = false;
			getValuesDistribution();
			break;
		case Constants.GET_MESSAGE_SELECT_NORMAL_LINEAR_CONGRUENCE:
			view.validateRadioButtonLinearCongruence();
			view.validateRadioButtonLinearCongruence();
			/*Distribucion normal congruencia lineal*/
			optionValueUniformLinear = false;
			optionValueUniformLeastSquares = false;
			optionValueUniformMultiplicative = false;
			optionValueNormalLinear = true;
			optionValueNormalLeastSquares = false;
			optionValueNormalMultiplicative = false;
			getValuesDistribution();
			break;
		case Constants.GET_MESSAGE_SELECT_NORMAL_MULTIPLICATIVE_CONGRUENCE:
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
		case Constants.GET_MESSAGE_SELECT_UNIFORM_MULTIPLICATIVE_CONGRUENCE:
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
		case Constants.GET_ADD_LINEAR_CONGRUENCE:
			getValuesLinearCongruence();
			break;
		case Constants.GET_ADD_MULTIPLICATIVE_CONGRUENCE:
			getValuesMultiplicativeCongruence();
			break;
		case Constants.GET_MESSAGE_GENERATE_LEAST_SQUARES:
			getValuesLeastSquares();
			break;
		case Constants.GET_ADD_GENERATE:
			initialiedJDialogGrafics();
			break;
		default:
			break;
		}
		
	}
	
	
	
	public void getValuesLinearCongruence() {
		
		try {
			String seed = view.getTxtSeed();
			String varK = view.getTxtVarK();
			String varC = view.getTxtVarC();
			String varG = view.getTxtVarG();
			boolean isSelect = view.isSelectRadioButton();
			String[] array = getValuesDistribution();
			String quantity = view.getTxtQuantity();
			String lowerLimit = array[0];
			String upperLimit = array[1];
				if (seed.equals("") || varK.equals("") || varC.equals("") || varG.equals("") || !isSelect
						|| lowerLimit.equals("") || upperLimit.equals("") || quantity.equals("")) {
					view.getMessageErrorEmpty();
				} else {
					try {
						int seedInt = Integer.parseInt(seed);
						int varKInt = Integer.parseInt(varK);
						int varCInt = Integer.parseInt(varC);
						int varGInt = Integer.parseInt(varG);
						if(!manager.isValidVarG(varGInt)) {
							view.getMessageErrorVarG();
						}else {
							double lowerLimitInt;
							double upperLimitInt;
							if (isNormalLinearCongruence()) {
								lowerLimitInt = Double.parseDouble(lowerLimit);
								upperLimitInt = Double.parseDouble(upperLimit);
							} else {
								lowerLimitInt = Integer.parseInt(lowerLimit);
								upperLimitInt = Integer.parseInt(upperLimit);
							}
							int quantityInt = Integer.parseInt(quantity);
							ArrayList<ArrayList<Double>> listArrayXiAndRi = manager
									.calculateLinearCongruentialMethodNumbers(seedInt, varKInt, varCInt, varGInt, quantityInt);
							createLinearCongruence(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
						}
					} catch (NumberFormatException e) {
						view.getMessageErrorNumberFormatException();
					} 

				}
		}catch(NullPointerException e) {
			view.getMessageErrorSelectionJButton();
		}
	}

	public boolean isNormalLinearCongruence() {
		if (optionValueNormalLinear) {
			return true;
		}
		return false;
	}

	public void getValuesMultiplicativeCongruence() {
		
		try {
			String seed = view.getTxtSeedMultiplicative();
			String varT = view.getTxtVarTMultiplicative();
			String varG = view.getTxtVarGMultiplicative();
			boolean isSelect = view.isSelectRadioButtonMultiplicative();
			String[] array = getValuesDistributionMultiplicative();
			String quantity = view.getTxtQuantityMultiplicative();
			String lowerLimit = array[0];
			String upperLimit = array[1];
			if (seed.equals("") || varT.equals("") || varG.equals("") || !isSelect || lowerLimit.equals("")
					|| upperLimit.equals("") || quantity.equals("")) {
				view.getMessageErrorEmpty();
			} else {
				try {
					int seedInt = Integer.parseInt(seed);
					int varTInt = Integer.parseInt(varT);
					int varGInt = Integer.parseInt(varG);
					if (!manager.isValidVarG(varGInt)) {
						view.getMessageErrorVarG();
					} else {
						double lowerLimitInt;
						double upperLimitInt;
						if (isNormalMultiplicativeCongruence()) {
							lowerLimitInt = Double.parseDouble(lowerLimit);
							upperLimitInt = Double.parseDouble(upperLimit);
						} else {
							lowerLimitInt = Integer.parseInt(lowerLimit);
							upperLimitInt = Integer.parseInt(upperLimit);
						}
						int quantityInt = Integer.parseInt(quantity);
						ArrayList<ArrayList<Double>> listArrayXiAndRi = manager
								.calculateCongruentialMultiplicativeMethodNumbers(seedInt, varTInt, varGInt, quantityInt);
						createMultiplicativeCongruence(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
					}
				} catch (NumberFormatException e) {
					view.getMessageErrorNumberFormatException();
				}

			}
		}catch(NullPointerException e) {
			view.getMessageErrorSelectionJButton();
		}
	
	}
	

	
	
	public boolean isNormalMultiplicativeCongruence() {
		if (optionValueNormalMultiplicative) {
			return true;
		}
		return false;

	}

	public void getValuesLeastSquares() {
		try {
			String seed = view.getTxtSeedLeastSquares();
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
					if (manager.isValidSeedMeanSquaresMethod(seedInt)) {
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
						ArrayList<ArrayList<Double>> listArrayXiAndRi = manager.calculateByMeanSquaresMethod(seedInt,
								quantityInt);
						createLeastSquares(listArrayXiAndRi, lowerLimitInt, upperLimitInt);
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

	public boolean isNormalLeastSquares() {
		if (optionValueNormalLeastSquares) {
			return true;
		}
		return false;

	}

	
	
	public void createLinearCongruence(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit,
			double upperLimit) {
		view.initJTable(getNumbersNi(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValues();
	}

	public void createMultiplicativeCongruence(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit,
			double upperLimit) {
		view.initJTable(getNumbersNiMultiplicative(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValuesMultiplicative();
	}

	public void createLeastSquares(ArrayList<ArrayList<Double>> listArrayXiAndRi, double lowerLimit, double upperLimit) {
		view.initJTable(getNumbersLeastSquares(lowerLimit, upperLimit, listArrayXiAndRi));
		cleanValuesLeastSquares();
	}

	public ArrayList<ArrayList<Double>> getNumbersNi(double lowerLimit, double upperLimit,
			ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformLinear) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateUniformDistribution((int) lowerLimit, (int) upperLimit, listArrayXiAndRi.get(1)));
			
		}
		if (optionValueNormalLinear) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
		
		}
		return list;
	}

	public ArrayList<ArrayList<Double>> getNumbersNiMultiplicative(double lowerLimit, double upperLimit,
			ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformMultiplicative) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateUniformDistribution((int)lowerLimit, (int)upperLimit, listArrayXiAndRi.get(1)));
			
		}
		if (optionValueNormalMultiplicative) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
	
		}
		return list;
	}

	

	public ArrayList<ArrayList<Double>> getNumbersLeastSquares(double lowerLimit, double upperLimit,
			ArrayList<ArrayList<Double>> listArrayXiAndRi) {
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(listArrayXiAndRi.get(0));
		list.add(listArrayXiAndRi.get(1));
		if (optionValueUniformLeastSquares) {
			view.setLblWriteOne("limite inferior");
			view.setLblWriteTwo("limite superior");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateUniformDistribution((int)lowerLimit, (int)upperLimit, listArrayXiAndRi.get(1)));
			
		}
		if (optionValueNormalLeastSquares) {
			view.setLblWriteOne("Media");
			view.setLblWriteTwo("Desviacion");
			view.setLblReadOne(String.valueOf(lowerLimit));
			view.setLblReadTwo(String.valueOf(upperLimit));
			list.add(manager.calculateNormalDistribution(lowerLimit, upperLimit, listArrayXiAndRi.get(1)));
		}
		return list;
	}

	public void cleanValues() {
		view.initializedJDialogLinearCongruence(false);
	}

	public void cleanValuesMultiplicative() {
		view.initializedJDialogMultiplicativeCongruence(false);
	}

	public void cleanValuesLeastSquares() {
		view.initializedJDialogLeastSquares(false);
	}

	public String[] getValuesDistribution() {
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
	
	
	public void initialiedJDialogGrafics() {
		int quantity = view.quantityValues() ;
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
	
	
	
	
	public static void main(String[] args) {
		new Presenter();
	}

	

}
