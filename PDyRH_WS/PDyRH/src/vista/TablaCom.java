package vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;


public class TablaCom {
	public JFrame ventana;
	
	private String [][] datos= {{"Fernando", "67"},
								{"Maria", "20"},};
	
	private String [] cabezera= {"Desaparecida", "Parecido%"};
	
		public TablaCom() {
			ventana=new JFrame("Tablas");
			
			ventana.setSize(700,319);
			set_table();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.getContentPane().setLayout(null);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 684, 280);
			ventana.getContentPane().add(tabbedPane);
			
			JPanel panel = new JPanel();
			tabbedPane.addTab("New tab", null, panel, null);
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("New tab", null, panel_1, null);
			ventana.setVisible(true);
			
		}
		
		public void set_table() {
		}
		
		public static void main(String[] args) {
			TablaCom table = new TablaCom(); 
		}
}
