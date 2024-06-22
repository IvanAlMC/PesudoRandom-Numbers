package model;

import java.util.ArrayList;

import umontreal.ssj.probdist.NormalDist;

public class Manager {

	/*
	 * x0 es la semilla de la aplicacion, g es una variable y t es un punto de una
	 * ecuacion de una recta lineal
	 *
	 * Trabajaremos con la siguiente ecuacion a = 8t+3
	 * 
	 */

	public float calculateCongruentialMultiplicativeMethodNumberXI(float xo, float t, float g) {
		float a = 8 * t + 3;
		// int m = (int) Math.pow(2,g);
		float m = calculateVarM(g);
		return (a * xo) % m;
	}

	public float calculateVarM(float g) {
		return (int) Math.pow(2, g);
	}

	public double calculateCongruentialMethodNumberRI(float value, float g) {
		float m = calculateVarM(g);
		double number = (double) value / (m - 1);
		return number;
	}

	public ArrayList<ArrayList<Double>> calculateCongruentialMultiplicativeMethodNumbers(float xo, float t, float g,
			int quantity) {
		int count = 1;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		float actualXi = calculateCongruentialMultiplicativeMethodNumberXI(xo, t, g);
		list.add(new ArrayList<Double>());
		list.get(0).add((double) actualXi);
		double actualRi = calculateCongruentialMethodNumberRI(actualXi, g);
		list.add(new ArrayList<Double>());
		list.get(1).add(actualRi);
		while (quantity > count) {
			actualXi = calculateCongruentialMultiplicativeMethodNumberXI(actualXi, t, g);
			list.get(0).add((double) actualXi);
			actualRi = calculateCongruentialMethodNumberRI(actualXi, g);
			list.get(1).add(actualRi);
			count++;
		}
		return list;
	}

	
	
	
	
	/*
	 * Xo es la semilla del metodo de congruencia lineal
	 * 
	 */

	public float calculateLinearCongruenceMethodNumberXI(float Xo, int k, int c, int g) {
		float a = 1 + 2 * k;
		float m = calculateVarM(g);
		return (a * Xo + c) % m;
	}

	public ArrayList<ArrayList<Double>> calculateLinearCongruentialMethodNumbers(int xo, int k, int c, int g,
			int quantity) {
		int count = 1;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		float actualXi = calculateLinearCongruenceMethodNumberXI(xo, k, c, g);
		list.add(new ArrayList<Double>());
		list.get(0).add((double) actualXi);
		double actualRi = calculateCongruentialMethodNumberRI(actualXi, g);
		list.add(new ArrayList<Double>());
		list.get(1).add(actualRi);
		while (quantity > count) {
			actualXi = calculateLinearCongruenceMethodNumberXI(actualXi, k, c, g);
			list.get(0).add((double) actualXi);
			actualRi = calculateCongruentialMethodNumberRI(actualXi, g);
			list.get(1).add(actualRi);
			count++;
		}
		return list;
	}

	public boolean validateData(int xo, int g, int t) {
		return xo >= 0 && g >= 0 && t >= 0 ? true : false;
	}

	public ArrayList<ArrayList<Double>> calculateByMeanSquaresMethod(int xo, int quantity) {
		int aux = xo;
		ArrayList<ArrayList<Double>> list = new ArrayList<ArrayList<Double>>();
		list.add(new ArrayList<Double>());
		int count = 1;
		list.add(new ArrayList<Double>());
		while (quantity >= count) {
			list.get(0).add((double) aux);
			int lengthOne = String.valueOf(aux).length();
			int number = (int) Math.pow(aux, 2);
			int lengthTwo = String.valueOf(number).length();
			int primerc = (lengthTwo - lengthOne) / 2;
			int result = Integer.parseInt(String.valueOf(number).substring(primerc, primerc + lengthOne));
			aux = result;
			double numberTwo = result / Math.pow(10, lengthOne);
			list.get(1).add(numberTwo);
			count++;
		}
		return list;
	}

	public ArrayList<Double> calculateUniformDistribution(int lowerLimit, int upperLimit, ArrayList<Double> listRi) {
		ArrayList<Double> listNiUniformDistribution = new ArrayList<Double>();
		for (int i = 0; i < listRi.size(); i++) {
			double aux = (double) (lowerLimit + (upperLimit - lowerLimit) * listRi.get(i));
			listNiUniformDistribution.add(aux);
		}
		return listNiUniformDistribution;
	}

	public ArrayList<Double> calculateNormalDistribution(double lowerLimit, double upperLimit,
			ArrayList<Double> listRi) {
		ArrayList<Double> listNiNormalDistribution = new ArrayList<Double>();
		NormalDist dist = new NormalDist(lowerLimit, upperLimit);
		for (int i = 0; i < listRi.size(); i++) {
			listNiNormalDistribution.add(dist.inverseF(listRi.get(i)));
		}
		return listNiNormalDistribution;
	}

	public boolean isValidSeedMeanSquaresMethod(int seed) {
		if ((String.valueOf(seed).length() >= 3) && seed % 2 == 0) {
			return true;
		}
		return false;
	}

	public boolean isValidVarG(int varG) {
		return varG > 0 ? true : false;
	}

	public int getMax(int length) {
		String aux = "";
		for (int i = 0; i < length; i++) {
			aux += "9";
		}
		return Integer.parseInt(aux);
	}

}
