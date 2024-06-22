package models;

import java.util.ArrayList;

import umontreal.ssj.probdist.NormalDist;

public class GeneratorPseudoRandomNumbers {
	
	/*
	 * Este metodo generara una lista de numeros por medio de Cuadrados Medios
	 * teneiendo en cuenta la ecuacion dada en clase
	 * Y se añade a una lista
	 */
	public ArrayList<ArrayList<Double>> getNumberListMeanSquares(int actual_x, int quantity) {
		int aux = actual_x;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(new ArrayList<Double>());
		int count = 1;
		list.add(new ArrayList<Double>());
		while (quantity >= count) {
			list.get(0).add((double) aux);
			int lengthOne = String.valueOf(aux).length();
			int number = (int) Math.pow(aux, 2);
			int lengthTwo = String.valueOf(number).length();
			int first_c = (lengthTwo - lengthOne) / 2;
			int result = Integer.parseInt(String.valueOf(number).substring(first_c, first_c + lengthOne));
			aux = result;
			double numberTwo = result / Math.pow(10, lengthOne);
			list.get(1).add(numberTwo);
			count++;
		}
		return list;
	}
	
	/*
	 * Con este metodo se busca calcular la variable m
	 * con la ecuacion 2^g
	 */
	public float getVariableM(float variable_g) {
		return (int) Math.pow(2, variable_g);
	}
	
	/*
	 * Este metodo busca validar que la variable g
	 * sea mayor que 0
	 */
	public boolean validateVariableG(int varG) {
		return varG > 0 ? true : false;
	}
	
	
	/*
	 * Este metodo busca calcular los respectivos Xi
	 * Con variables de entrada como el actual Xn (este comienza desde X0)
	 * la variable k, la variable c y la variable g vistas en clase para realizar dicho calculo
	 * esto con la ecuacion ((a*x)+c)%m
	 */
	public float calculateXiCongruentialLinear(float actual_X, int variable_k, int variable_c, int variable_g) {
		float variable_a = 1 + 2 * variable_k;
		float variable_m = getVariableM(variable_g);
		return (variable_a * actual_X + variable_c) % variable_m;
	}
	
	/*
	 * Este metodo busca calcular los respectivos Ri
	 * teniendo en cuenta la entrada del valor actual de Xn y la variable g
	 * para calcular m, y con esto aplicar la formula (Xn/(m-1))
	 */
	public double calculateRiCongruential(float value_x, float variable_g) {
		float variable_m = getVariableM(variable_g);
		double number = (double) value_x / (variable_m - 1);
		return number;
	}
	
	/*
	 * Este metodo generara una lista de numeros por medio de Congruencial lineal
	 * teneiendo en cuenta la ecuacion dada en clase
	 * Y se añade a una lista
	 */
	public ArrayList<ArrayList<Double>> getNumbersListCongruentialLinear(int actual_x, int actual_k, int actual_c, int actual_g, int quantity) {
		int count = 1;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		float actualXi = calculateXiCongruentialLinear(actual_x, actual_k, actual_c, actual_g);
		list.add(new ArrayList<Double>());
		list.get(0).add((double) actualXi);
		double actualRi = calculateRiCongruential(actualXi, actual_g);
		list.add(new ArrayList<Double>());
		list.get(1).add(actualRi);
		while (quantity > count) {
			actualXi = calculateXiCongruentialLinear(actualXi, actual_k, actual_c, actual_g);
			list.get(0).add((double) actualXi);
			actualRi = calculateRiCongruential(actualXi, actual_g);
			list.get(1).add(actualRi);
			count++;
		}
		return list;
	}
	
	/*
	 * Este metodo busca calcular los Xi, por medio de parametros como
	 * el actual X, donde se comienza con X0, la variable t y la variable g
	 * para luego obtener la variable a y la variable m vistas en clase,
	 * para finalmente, hacer el calculo por medio de la ecuacion (a*Xn)%m
	 */
	public float calculateXiCongruentialMultiplicative(float actual_X, float variable_t, float variable_g) {
		float variable_a = 8 * variable_t + 3;
		float variable_m = getVariableM(variable_g);
		return (variable_a * actual_X) % variable_m;
	}

	/*
	 * Este metodo generara la lista de numeros por medio de Congruencial Multiplicativo
	 * teneiendo en cuenta la ecuacion dada en clase
	 * Y se añade a una lista
	 */
	public ArrayList<ArrayList<Double>> getNumbersListCongruentialMultiplicative(float actual_x, float variable_t, float variable_g, int quantity) {
		int count = 1;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		float actualXi = calculateXiCongruentialMultiplicative(actual_x, variable_t, variable_g);
		list.add(new ArrayList<Double>());
		list.get(0).add((double) actualXi);
		double actualRi = calculateRiCongruential(actualXi, variable_g);
		list.add(new ArrayList<Double>());
		list.get(1).add(actualRi);
		while (quantity > count) {
			actualXi = calculateXiCongruentialMultiplicative(actualXi, variable_t, variable_g);
			list.get(0).add((double) actualXi);
			actualRi = calculateRiCongruential(actualXi, variable_g);
			list.get(1).add(actualRi);
			count++;
		}
		return list;
	}

	/*
	 * Metodo el cual nos va generar las numeros pseudoaletorios por medio
	 * de una distribucion uniforme, teniendo en cuenta los limites que se pasan por parametros
	 * por medio de la ecuacion (a+(b-a)*Ri
	 */
	public ArrayList<Double> calculateByUniformDistribution(int lowerLimit, int upperLimit, ArrayList<Double> listRi) {
		ArrayList<Double> listNiUniformDistribution = new ArrayList<Double>();
		for (int i = 0; i < listRi.size(); i++) {
			double aux = (double) (lowerLimit + (upperLimit - lowerLimit) * listRi.get(i));
			listNiUniformDistribution.add(aux);
		}
		return listNiUniformDistribution;
	}

	/*
	 * Metodo el cual nos va generar las numeros pseudoaletorios por medio
	 * de una distribucion normal, teniendo en cuenta la media y la desviacion estandar
	 * que se pasan por parametros
	 */
	public ArrayList<Double> calculateByNormalDistribution(double media, double standardDistribution, ArrayList<Double> listRi) {
		ArrayList<Double> listNiNormalDistribution = new ArrayList<Double>();
		NormalDist dist = new NormalDist(media, standardDistribution);
		for (int i = 0; i < listRi.size(); i++) {
			listNiNormalDistribution.add(dist.inverseF(listRi.get(i)));
		}
		return listNiNormalDistribution;
	}

	/*
	 * Este metodo validar la semilla de los metodos cuadrados cuando un usuario lo ingrese
	 * la cual debe tener por lo menos 3 digitos y ser par
	 */
	public boolean validateSeedMeanSquares(int seed) {
		if ((String.valueOf(seed).length() >= 3) && seed % 2 == 0) {
			return true;
		}
		return false;
	}
}
