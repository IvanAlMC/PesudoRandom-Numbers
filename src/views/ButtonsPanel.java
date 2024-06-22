package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import models.Commands;

public class ButtonsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JLabel lblTittle;
	public JButton btnOne;
	public JButton btnTwo;
	public JButton btnThree;
	public JButton btnGenerateGraph;

	public ButtonsPanel( ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents( ActionListener listener) {
		this.add(Box.createVerticalStrut(80));
		lblTittle = new JLabel("Seleccione el metodo");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(lblTittle);
		this.add(Box.createVerticalStrut(80));
		JPanel panelAux = new JPanel();
		panelAux.setBackground(new Color(255, 255, 255));
		panelAux.setLayout(new BoxLayout(panelAux,BoxLayout.Y_AXIS));
		panelAux.add(Box.createVerticalStrut(30));
		panelAux.setPreferredSize(new Dimension(250, 340));
		panelAux.setBorder(new RoundedBorder(10));
		btnOne = new JButton("    Minimos cuadrados    ");
		btnOne.addActionListener(listener);
		btnOne.setActionCommand(Commands.GENERATE_LEASTE_SQUARES);
		btnOne.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOne.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnOne.setBorder(new RoundedBorder(10));
		panelAux.add(btnOne); 
		panelAux.add(Box.createVerticalStrut(30));
		btnTwo = new JButton("    Congruencia lineal    ");
		btnTwo.addActionListener(listener);
		btnTwo.setActionCommand(Commands.GENERATE_LINEAR_CONGRUENCE);
		btnTwo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTwo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTwo.setBorder(new RoundedBorder(10));
		panelAux.add(btnTwo);
		panelAux.add(Box.createVerticalStrut(30));
		btnThree = new JButton("Congruencia multiplicativa");
		btnThree.addActionListener(listener);
		btnThree.setActionCommand(Commands.GENERATE_MULTIPLICATE_CONGRUENCE);
		btnThree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThree.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnThree.setBorder(new RoundedBorder(10));
		panelAux.add(btnThree);
		panelAux.add(Box.createVerticalStrut(30));
		btnGenerateGraph = new JButton("      Generar Grafica     ");
		btnGenerateGraph.addActionListener(listener);
		btnGenerateGraph.setActionCommand(Commands.ADD_GENERATE_GRAPHIC);
		btnGenerateGraph.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerateGraph.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGenerateGraph.setBorder(new RoundedBorder(10));
		panelAux.add(btnGenerateGraph);
		panelAux.add(Box.createVerticalStrut(30));
		panelAux.setBorder(new TitledBorder("Metodos de generacion"));
		this.add(panelAux);
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
