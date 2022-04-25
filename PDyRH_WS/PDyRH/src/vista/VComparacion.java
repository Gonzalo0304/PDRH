package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.List;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class VComparacion extends JDialog {
	private ButtonGroup rh = new ButtonGroup();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VComparacion dialog = new VComparacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VComparacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setPreferredSize(new Dimension (360, 330));
		scrollPane.setViewportView(contentPanel);
		
		JButton ButtonVolvervComp = new JButton("Volver");
		ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonVolvervComp.setBounds(300, 225, 105, 23);
		contentPanel.add(ButtonVolvervComp);
		
		JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
		ButtonCompSelVComp.setEnabled(false);
		ButtonCompSelVComp.setBounds(300, 198, 105, 23);
		contentPanel.add(ButtonCompSelVComp);
		
		
		String desaparecidas[] = { "Maria", "Fernando", "Marcos" };
		String restoHumanos[] = { "67", "50", "30" };
		// Creacion de tablas de comparacion
		int posiciontabla = 48;
		int posicioncabecera = 35;
		
		if (desaparecidas.length > 0 && restoHumanos.length > 0) {
			for (int i = 0; i < restoHumanos.length; i++) {
				String datosTabla[][] = new String[desaparecidas.length][2];
				for (int j = 0; j < desaparecidas.length; j++) {
					datosTabla[j][0] = desaparecidas[j];
					datosTabla[j][1] = restoHumanos[j];

				}

				JScrollPane JS = new JScrollPane();
				JS.setBounds(10, posiciontabla, 200, 55);
				posiciontabla = posiciontabla + 100;
				contentPanel.add(JS);

				String cabezera[] = { "Desaparecida", "Precido%" };
				JTable tabla = new JTable(datosTabla, cabezera);
				JS.setViewportView(tabla);
				
				JLabel lblNewLabel_1 = new JLabel("Resto Humano");
				lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, posicioncabecera, 199, 14);
				posicioncabecera = posicioncabecera + 100;
				contentPanel.add(lblNewLabel_1);
				
			}
		} else {

		}

	}
}
