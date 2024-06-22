package view.JPanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JPanelGraficsNormal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public JPanelGraficsNormal(ArrayList<Double> listNi) {
		initComponents(listNi);
	}
	
	public void initComponents(ArrayList<Double> listNi) {
		double[] range = getRange(getMin(listNi) ,getMax(listNi));
		int[] count = getCount(range,listNi);
		DefaultCategoryDataset datos = new DefaultCategoryDataset();

		for (int i = 0; i < count.length; i++) {
			datos.setValue(count[i], "Rango",getRound(range[i]) + "-" + getRound(range[i+1]));
		}
		JFreeChart grafico_barra = ChartFactory.createBarChart3D(
				"Representacion de numeros ni", "Rangos", "Cantidad de numeros generados", datos,PlotOrientation.VERTICAL,true,true,false
				);
		ChartPanel chart = new ChartPanel(grafico_barra);
		chart.setPreferredSize(new Dimension(900,500));
		this.add(chart);
		
	}
	
	
	
	public double[] getRange(double min,double max) {
		double[] arrayAux = new double[11];
		arrayAux[0] = min;
		for (int i = 1; i < arrayAux.length; i++) {
			arrayAux[i] = arrayAux[i-1] +(max-min) /(arrayAux.length-1);
		}
		return arrayAux;
	}
	
	public int[] getCount(double[] range, ArrayList<Double> listNi) {
		int[] count = new int[range.length - 1];
			for (int i = 0; i < listNi.size(); i++) {
			if(listNi.get(i) >= range[0] && listNi.get(i) < range[1]){
				count[0]++;
			}else if(listNi.get(i) >= range[1] && listNi.get(i) < range[2]) {
				count[1]++;
			}else if(listNi.get(i) >= range[2] && listNi.get(i) < range[3]) {
				count[2]++;
			}else if(listNi.get(i) >= range[3] && listNi.get(i) < range[4]) {
				count[3]++;
			}else if(listNi.get(i) >= range[4] && listNi.get(i) < range[5]) {
				count[4]++;
			}else if(listNi.get(i) >= range[5] && listNi.get(i) < range[6]) {
				count[5]++;
			}else if(listNi.get(i) >= range[6] && listNi.get(i) < range[7]) {
				count[6]++;
			}else if(listNi.get(i) >= range[7] && listNi.get(i) < range[8]) {
				count[7]++;
			}else if(listNi.get(i) >= range[8] && listNi.get(i) < range[9]) {
				count[8]++;
			}else {
				count[9]++;
			}
		}	
			return count;
	}
	
	public double getMin(ArrayList<Double> list) {
		double min = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i)) {
				min = list.get(i);
			}			
		}
		return min;
	}
	
	public double getMax(ArrayList<Double> list) {
		double max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)) {
				max = list.get(i);
			}			
		}
		return max;
	}
	
	public double getRound(double number) {
		return Math.floor(number * 10000) / 10000;
	}
	
	
	

}
