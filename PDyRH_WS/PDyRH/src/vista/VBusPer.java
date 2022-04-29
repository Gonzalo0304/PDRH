package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBusPer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefonoM;
	private JTextField textTelefonoO;
	private JTextField textLocalidad;
	private JTextField textNacimiento;
	private JTextField textFallecimiento;
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
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JButton btnVolver1;
	private JButton btnVolver2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusPer dialog = new VBusPer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBusPer() {
		setBounds(100, 100, 447, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			contentPanel.add(tabbedPane, "name_19326072116700");
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Datos", null, panel, null);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("DNI:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel.setBounds(68, 44, 46, 14);
				panel.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setBounds(127, 42, 158, 20);
				panel.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_1.setBounds(68, 69, 61, 14);
				panel.add(lblNewLabel_1);
				
				textField_1 = new JTextField();
				textField_1.setBounds(127, 67, 158, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Apellido:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2.setBounds(68, 95, 61, 14);
				panel.add(lblNewLabel_2);
				
				textField_2 = new JTextField();
				textField_2.setBounds(127, 94, 158, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_2_1 = new JLabel("Telefono movil:");
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2_1.setBounds(19, 120, 95, 14);
				panel.add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_2_2 = new JLabel("Telefono opcional:");
				lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2_2.setBounds(7, 145, 107, 14);
				panel.add(lblNewLabel_2_2);
				
				JLabel lblNewLabel_2_3 = new JLabel("Localidad:");
				lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2_3.setBounds(53, 180, 61, 14);
				panel.add(lblNewLabel_2_3);
				
				JLabel lblNewLabel_2_4 = new JLabel("Nacimiento:");
				lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2_4.setBounds(41, 205, 75, 14);
				panel.add(lblNewLabel_2_4);
				
				JLabel lblNewLabel_2_5 = new JLabel("Fallecimiento:");
				lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2_5.setBounds(30, 230, 95, 14);
				panel.add(lblNewLabel_2_5);
				
				textField_3 = new JTextField();
				textField_3.setBounds(127, 120, 158, 20);
				panel.add(textField_3);
				textField_3.setColumns(10);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(127, 145, 158, 20);
				panel.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setBounds(127, 178, 158, 20);
				panel.add(textField_5);
				textField_5.setColumns(10);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(127, 203, 158, 20);
				panel.add(textField_6);
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(127, 228, 158, 20);
				panel.add(textField_7);
				
				btnVolver1 = new JButton("Volver");
				btnVolver1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volver1();
					}
				});
				btnVolver1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnVolver1.setBounds(317, 282, 89, 31);
				panel.add(btnVolver1);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Conocidos", null, panel, null);
				panel.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("Nombre y apellidos");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(22, 25, 135, 19);
				panel.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("DNI:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_4.setBounds(82, 55, 35, 14);
				panel.add(lblNewLabel_4);
				
				textField_8 = new JTextField();
				textField_8.setBounds(116, 53, 147, 20);
				panel.add(textField_8);
				textField_8.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Relacion:");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_5.setBounds(54, 84, 63, 14);
				panel.add(lblNewLabel_5);
				
				textField_9 = new JTextField();
				textField_9.setBounds(116, 80, 147, 20);
				panel.add(textField_9);
				textField_9.setColumns(10);
				
				JLabel lblNewLabel_3_1 = new JLabel("Nombre y apellidos");
				lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_3_1.setBounds(22, 121, 135, 19);
				panel.add(lblNewLabel_3_1);
				
				JLabel lblNewLabel_4_1 = new JLabel("DNI:");
				lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_4_1.setBounds(82, 151, 35, 14);
				panel.add(lblNewLabel_4_1);
				
				JLabel lblNewLabel_5_1 = new JLabel("Relacion:");
				lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_5_1.setBounds(54, 176, 63, 14);
				panel.add(lblNewLabel_5_1);
				
				textField_10 = new JTextField();
				textField_10.setColumns(10);
				textField_10.setBounds(116, 149, 147, 20);
				panel.add(textField_10);
				
				textField_11 = new JTextField();
				textField_11.setColumns(10);
				textField_11.setBounds(116, 174, 147, 20);
				panel.add(textField_11);
				
				JLabel lblNewLabel_3_1_1 = new JLabel("Nombre y apellidos");
				lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_3_1_1.setBounds(22, 207, 135, 19);
				panel.add(lblNewLabel_3_1_1);
				
				JLabel lblNewLabel_4_1_1 = new JLabel("DNI:");
				lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_4_1_1.setBounds(82, 237, 35, 14);
				panel.add(lblNewLabel_4_1_1);
				
				JLabel lblNewLabel_5_1_1 = new JLabel("Relacion:");
				lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_5_1_1.setBounds(54, 262, 63, 14);
				panel.add(lblNewLabel_5_1_1);
				
				textField_12 = new JTextField();
				textField_12.setColumns(10);
				textField_12.setBounds(116, 235, 147, 20);
				panel.add(textField_12);
				
				textField_13 = new JTextField();
				textField_13.setColumns(10);
				textField_13.setBounds(116, 260, 147, 20);
				panel.add(textField_13);
				
				btnVolver2 = new JButton("Volver");
				btnVolver2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						volver2();
					}
				});
				btnVolver2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnVolver2.setBounds(317, 288, 89, 25);
				panel.add(btnVolver2);
			}
		}
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
