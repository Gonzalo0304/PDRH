package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;

public class VGesPersona extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textDniConoVGesPersona;
	private JTextField textRolConoVGesPersona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VGesPersona dialog = new VGesPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VGesPersona() {
		setBounds(100, 100, 450, 354);
		getContentPane().setLayout(new CardLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(tabbedPane, "name_90876980053500");
			{
				JPanel contentPanel = new JPanel();
				tabbedPane.addTab("Datos", null, contentPanel, null);
				contentPanel.setLayout(null);
				contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				{
					JButton ButtonVolverVGesBanda = new JButton("Volver");
					ButtonVolverVGesBanda.setBounds(335, 227, 89, 23);
					contentPanel.add(ButtonVolverVGesBanda);
				}
				{
					JButton ButtonBajaVGesBanda = new JButton("Dar baja");
					ButtonBajaVGesBanda.setBounds(335, 193, 89, 23);
					contentPanel.add(ButtonBajaVGesBanda);
				}
				{
					JButton ButtonModificarVGesBanda = new JButton("Modificar");
					ButtonModificarVGesBanda.setBounds(335, 159, 89, 23);
					contentPanel.add(ButtonModificarVGesBanda);
				}
				{
					JLabel lblNewLabel = new JLabel("DNI:");
					lblNewLabel.setBounds(92, 29, 28, 14);
					contentPanel.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Nombre:");
					lblNewLabel_1.setBounds(74, 54, 46, 14);
					contentPanel.add(lblNewLabel_1);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Apellido:");
					lblNewLabel_2.setBounds(74, 79, 46, 14);
					contentPanel.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Telefono movil:");
					lblNewLabel_3.setBounds(47, 104, 73, 14);
					contentPanel.add(lblNewLabel_3);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Telefono opcional:");
					lblNewLabel_4.setBounds(31, 129, 89, 14);
					contentPanel.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("Localidad:");
					lblNewLabel_5.setBounds(72, 154, 48, 14);
					contentPanel.add(lblNewLabel_5);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("Nacimiento:");
					lblNewLabel_6.setBounds(64, 179, 56, 14);
					contentPanel.add(lblNewLabel_6);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Fallecimiento:");
					lblNewLabel_7.setBounds(55, 204, 65, 14);
					contentPanel.add(lblNewLabel_7);
				}
				{
					textField = new JTextField();
					textField.setColumns(10);
					textField.setBounds(130, 26, 86, 20);
					contentPanel.add(textField);
				}
				{
					textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(130, 51, 86, 20);
					contentPanel.add(textField_1);
				}
				{
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(130, 76, 86, 20);
					contentPanel.add(textField_2);
				}
				{
					textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(130, 101, 86, 20);
					contentPanel.add(textField_3);
				}
				{
					textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(130, 126, 86, 20);
					contentPanel.add(textField_4);
				}
				{
					textField_5 = new JTextField();
					textField_5.setColumns(10);
					textField_5.setBounds(130, 151, 86, 20);
					contentPanel.add(textField_5);
				}
				{
					textField_6 = new JTextField();
					textField_6.setColumns(10);
					textField_6.setBounds(130, 176, 86, 20);
					contentPanel.add(textField_6);
				}
				{
					textField_7 = new JTextField();
					textField_7.setColumns(10);
					textField_7.setBounds(130, 201, 86, 20);
					contentPanel.add(textField_7);
				}
			}
			{
				JPanel contentPanel = new JPanel();
				contentPanel.setLayout(null);
				contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				tabbedPane.addTab("Conocidos", null, contentPanel, null);
				{
					JButton ButtonVolverConoVGesPersona = new JButton("Volver");
					ButtonVolverConoVGesPersona.setBounds(330, 221, 89, 23);
					contentPanel.add(ButtonVolverConoVGesPersona);
				}
				{
					JLabel lblNewLabel = new JLabel("DNI:");
					lblNewLabel.setBounds(67, 119, 28, 14);
					contentPanel.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Rol:");
					lblNewLabel_1.setBounds(67, 144, 28, 14);
					contentPanel.add(lblNewLabel_1);
				}
				{
					textDniConoVGesPersona = new JTextField();
					textDniConoVGesPersona.setColumns(10);
					textDniConoVGesPersona.setBounds(105, 116, 211, 20);
					contentPanel.add(textDniConoVGesPersona);
				}
				{
					textRolConoVGesPersona = new JTextField();
					textRolConoVGesPersona.setColumns(10);
					textRolConoVGesPersona.setBounds(105, 141, 211, 20);
					contentPanel.add(textRolConoVGesPersona);
				}
				{
					JButton ButtonAñadirConoVGesPersona = new JButton("A\u00F1adir");
					ButtonAñadirConoVGesPersona.setEnabled(false);
					ButtonAñadirConoVGesPersona.setBounds(330, 187, 89, 23);
					contentPanel.add(ButtonAñadirConoVGesPersona);
				}
			}
		}
	}

}
