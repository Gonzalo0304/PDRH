package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBusCaso extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnVolver1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusCaso dialog = new VBusCaso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBusCaso() {
		setTitle("Buscar Caso");
		setBounds(100, 100, 457, 530);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_7044780698600");
		tabbedPane.addTab("Datos", null, contentPanel, null);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 53, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(39, 94, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblCodigo = new JLabel("Nombre");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(39, 123, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Fecha Inicio");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(29, 154, 68, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblFechafin = new JLabel("Fecha Final");
		lblFechafin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechafin.setBounds(29, 185, 66, 14);
		contentPanel.add(lblFechafin);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(108, 51, 149, 20);
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 121, 149, 20);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 152, 149, 20);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 183, 149, 20);
		contentPanel.add(textField_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Abierto");
		rdbtnNewRadioButton.setBounds(91, 91, 68, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cerrado");
		rdbtnNewRadioButton_1.setBounds(161, 91, 68, 23);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Sin resolver");
		rdbtnNewRadioButton_2.setBounds(244, 91, 109, 23);
		contentPanel.add(rdbtnNewRadioButton_2);
		
		btnVolver1 = new JButton("Volver");
		btnVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver1();
			}
		});
		btnVolver1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver1.setBounds(309, 207, 89, 29);
		contentPanel.add(btnVolver1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Involucrados", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 32, 123, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(97, 69, 33, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 67, 174, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Implicacion:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(55, 105, 77, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 103, 174, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre y Apellido");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(28, 144, 123, 17);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("DNI:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(97, 172, 33, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Implicacion:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(55, 207, 77, 14);
		panel_1.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(140, 170, 174, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(140, 205, 174, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_4 = new JLabel("Banda");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(55, 258, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Codigo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(84, 291, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(140, 289, 174, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Resto Humano");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(28, 343, 120, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(84, 385, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(140, 383, 174, 20);
		panel_1.add(textField_9);
		
		JButton btnVolver2 = new JButton("Volver");
		btnVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver2();
			}
		});
		btnVolver2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver2.setBounds(337, 427, 89, 25);
		panel_1.add(btnVolver2);
	}
	
	private void volver1() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	private void volver2() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
