package views;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import views.panels.JPanelGraficsNormal;
import views.panels.JPanelGraficsUniform;

public class JDialogGrafics extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelGraficsNormal normal;
	private JPanelGraficsUniform uniform;
	
	public JDialogGrafics(JFrame frame,ArrayList<Double> list,boolean isNormal) {
		super(frame,"Grafica",true);
		this.setSize(900,600);
		this.setBackground(new Color(91,91,91));
		this.setLocationRelativeTo(frame);
		initComponents(list,isNormal);
		this.setVisible(true);
	
	}
	
	private void initComponents(ArrayList<Double> list,boolean isNormal) {
		if(isNormal) {
			normal = new JPanelGraficsNormal(list);
			this.add(normal);
		}else {
			uniform = new JPanelGraficsUniform(list);
			this.add(uniform);
		}
	}
}
