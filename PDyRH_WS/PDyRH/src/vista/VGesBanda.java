package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class VGesBanda extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textDNIMiembrovGesbanda;
	private JTextField textRolMiembrovGesbanda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VGesBanda dialog = new VGesBanda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VGesBanda() {
		setBounds(100, 100, 450, 320);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 281);
		getContentPane().add(tabbedPane);
		
		JPanel contentPanelDatosVGesBanda = new JPanel();
		tabbedPane.addTab("Datos", null, contentPanelDatosVGesBanda, null);
		contentPanelDatosVGesBanda.setLayout(null);
		contentPanelDatosVGesBanda.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton ButtonVolverVGesBanda = new JButton("Volver");
		ButtonVolverVGesBanda.setBounds(335, 227, 89, 23);
		contentPanelDatosVGesBanda.add(ButtonVolverVGesBanda);
		
		JButton ButtonBajaVGesBanda = new JButton("Dar baja");
		ButtonBajaVGesBanda.setBounds(335, 193, 89, 23);
		contentPanelDatosVGesBanda.add(ButtonBajaVGesBanda);
		
		JButton ButtonModVGesBanda = new JButton("Modificar");
		ButtonModVGesBanda.setBounds(335, 159, 89, 23);
		contentPanelDatosVGesBanda.add(ButtonModVGesBanda);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(76, 28, 46, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(76, 53, 46, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C1mbito:");
		lblNewLabel_2.setBounds(76, 78, 46, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha inicio:");
		lblNewLabel_3.setBounds(63, 103, 59, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha final:");
		lblNewLabel_4.setBounds(63, 128, 59, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Bandas relacionadas:");
		lblNewLabel_5.setBounds(20, 153, 102, 14);
		contentPanelDatosVGesBanda.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 25, 86, 20);
		contentPanelDatosVGesBanda.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 50, 86, 20);
		contentPanelDatosVGesBanda.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 75, 86, 20);
		contentPanelDatosVGesBanda.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 100, 86, 20);
		contentPanelDatosVGesBanda.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(132, 125, 86, 20);
		contentPanelDatosVGesBanda.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(132, 150, 86, 20);
		contentPanelDatosVGesBanda.add(textField_5);
		
		JButton ButtonMasVGesBanda = new JButton("+");
		ButtonMasVGesBanda.setBounds(227, 149, 41, 23);
		contentPanelDatosVGesBanda.add(ButtonMasVGesBanda);
		
		JPanel contentPanelMiembrosVGesBanda = new JPanel();
		tabbedPane.addTab("Miembros", null, contentPanelMiembrosVGesBanda, null);
		contentPanelMiembrosVGesBanda.setLayout(null);
		contentPanelMiembrosVGesBanda.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(46, 108, 46, 14);
		contentPanelMiembrosVGesBanda.add(lblDni);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rol:");
		lblNewLabel_1_1.setBounds(46, 133, 46, 14);
		contentPanelMiembrosVGesBanda.add(lblNewLabel_1_1);
		
		textDNIMiembrovGesbanda = new JTextField();
		textDNIMiembrovGesbanda.setColumns(10);
		textDNIMiembrovGesbanda.setBounds(102, 105, 207, 20);
		contentPanelMiembrosVGesBanda.add(textDNIMiembrovGesbanda);
		
		textRolMiembrovGesbanda = new JTextField();
		textRolMiembrovGesbanda.setColumns(10);
		textRolMiembrovGesbanda.setBounds(102, 130, 207, 20);
		contentPanelMiembrosVGesBanda.add(textRolMiembrovGesbanda);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(318, 185, 89, 23);
		contentPanelMiembrosVGesBanda.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(318, 219, 89, 23);
		contentPanelMiembrosVGesBanda.add(btnNewButton_1);
	}
}
