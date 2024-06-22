package view;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import view.JPanel.JPanelGraficsNormal;
import view.JPanel.JPanelGraficsUniform;

public class JDialogGrafics extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelGraficsNormal normal;
	private JPanelGraficsUniform uniform;
	
	
	public JDialogGrafics(JFrame frame,ArrayList<Double> list,boolean isNormal) {
		super(frame,"Grafica Uniforme",true);
		this.setSize(900,600);
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
