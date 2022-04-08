package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VComparacion extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton ButtonVolvervComp = new JButton("Volver");
		ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonVolvervComp.setBounds(319, 227, 105, 23);
		contentPanel.add(ButtonVolvervComp);

		JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
		ButtonCompSelVComp.setEnabled(false);
		ButtonCompSelVComp.setBounds(319, 198, 105, 23);
		contentPanel.add(ButtonCompSelVComp);

		JRadioButton RadioButton1VComparacion = new JRadioButton("");
		RadioButton1VComparacion.setBounds(215, 72, 27, 21);
		contentPanel.add(RadioButton1VComparacion);

		JRadioButton RadioButton2VComparacion = new JRadioButton("");
		RadioButton2VComparacion.setBounds(215, 88, 27, 23);
		contentPanel.add(RadioButton2VComparacion);

		JRadioButton RadioButton3VComparacion = new JRadioButton("");
		RadioButton3VComparacion.setBounds(215, 164, 27, 23);
		contentPanel.add(RadioButton3VComparacion);

		JRadioButton RadioButton4VComparacion = new JRadioButton("");
		RadioButton4VComparacion.setBounds(215, 182, 27, 23);
		contentPanel.add(RadioButton4VComparacion);

		JLabel lblNewLabel_1 = new JLabel("Resto Humano");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 35, 199, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Resto Humano");
		lblNewLabel_1_1.setBackground(SystemColor.window);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 135, 199, 14);
		contentPanel.add(lblNewLabel_1_1);

		String desaparecidas[] = { "Maria", "Fernando" };
		String restoHumanos[] = { "67", "50" };
		// Creacion de tablas de comparacion
		int posicion = 48;
		if (desaparecidas.length > 0 && restoHumanos.length > 0) {
			for (int i = 0; i < restoHumanos.length; i++) {
				String datosTabla[][] = new String[desaparecidas.length][2];
				for (int j = 0; j < desaparecidas.length; j++) {
					datosTabla[j][0] = desaparecidas[j];
					datosTabla[j][1] = restoHumanos[j];
				}

				JScrollPane JS = new JScrollPane();
				JS.setBounds(10, posicion, 200, 55);
				posicion = posicion + 100;
				contentPanel.add(JS);

				String cabezera[] = { "Desaparecida", "Precido%" };
				JTable tabla = new JTable(datosTabla, cabezera);
				JS.setViewportView(tabla);
				
			}
		} else {

		}

	}
}
