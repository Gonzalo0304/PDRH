package vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.FlowLayout;


public class TablaCom {
	public JFrame ventana;
	
	private JTable tabla;
	
	private String [][] datos= {{"Fernando", "67"},
								{"Maria", "20"},};
	
	private String [] cabezera= {"Desaparecida", "Parecido%"};
	
		public TablaCom() {
			ventana=new JFrame("Tablas");
			ventana.setLayout(new FlowLayout());
			
			ventana.setSize(700,100);
			set_table();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);
			
		}
		
		public void set_table() {
			tabla= new JTable(datos, cabezera);
			JScrollPane JS= new JScrollPane(tabla);
			JS.setPreferredSize(new Dimension(400,50));
			ventana.add(JS);
		}
		
		public static void main(String[] args) {
			TablaCom table = new TablaCom(); 
		}
}
