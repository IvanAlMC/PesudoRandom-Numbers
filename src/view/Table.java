package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Constants;

public class Table extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scroll;

	public Table(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		this.add(Box.createVerticalStrut(500));
		table = new JTable(new Object[0][3], Constants.HEADERS);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(177,240,250));
//		table.getTableHeader().setBackground(Color.BLACK);
		table.setOpaque(false);
		table.setBackground(new Color(255,255,255));
		scroll = new JScrollPane(table);
		scroll.setVisible(true);
		scroll.setBackground(new Color(255,255,255));
		this.add(scroll);
	}

	public void initJTable(ArrayList<ArrayList<Double>> list) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] nameColumns = Constants.HEADERS;
		getColumns(model, nameColumns);
		getRows(model, list);
		table.setModel(model);
	}

	private void getColumns(DefaultTableModel model, Object[] nameColumns) {
		for (Object object : nameColumns) {
			model.addColumn(object);
		}
	}

	private void getRows(DefaultTableModel model, ArrayList<ArrayList<Double>> list) {
		ArrayList<Double> listDoubleXi = list.get(0);
		ArrayList<Double> listDoubleRI = list.get(1);
		ArrayList<Double> listDoubleNI = list.get(2);
		for (int i = 0; i < listDoubleXi.size(); i++) {
			Object[] arrayInt = { listDoubleXi.get(i), listDoubleRI.get(i), listDoubleNI.get(i) };
			model.addRow(arrayInt);
		}
	}

	public int quantityValues() {
		int count = 0;
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 2) != null) {
				list.add((Double) table.getValueAt(i, 2));
				count++;
			} 
		}
		return count;
	}

	public ArrayList<Double> getValues() {
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 2) != null) {
				list.add((Double) table.getValueAt(i, 2));
			} 
		}
		return list;

	}

}
