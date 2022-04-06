package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VInsPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefonoM;
	private JTextField textTelefonoO;
	private JTextField textLocalidad;
	private JTextField textNacimiento;
	private JTextField textFallecimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsPersona dialog = new VInsPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsPersona() {
		setBounds(100, 100, 479, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Agente");
		chckbxNewCheckBox.setBounds(33, 39, 97, 23);
		contentPanel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxDesaparecida = new JCheckBox("Desaparecida");
		chckbxDesaparecida.setBounds(132, 39, 97, 23);
		contentPanel.add(chckbxDesaparecida);
		
		JCheckBox chckbxCriminal = new JCheckBox("Criminal");
		chckbxCriminal.setBounds(261, 39, 97, 23);
		contentPanel.add(chckbxCriminal);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 463, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.BLACK);
		menuBar.add(menuInsertar);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.BLACK);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.BLACK);
		menuBar.add(menuComparar);
		
		JMenuItem mTotal = new JMenuItem("Total");
		mTotal.setHorizontalAlignment(SwingConstants.LEFT);
		mTotal.setBackground(new Color(32, 178, 170));
		mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mTotal.setForeground(Color.BLACK);
		menuComparar.add(mTotal);
		
		JMenuItem mEspecifico = new JMenuItem("Especifico");
		mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
		mEspecifico.setBackground(new Color(32, 178, 170));
		mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mEspecifico.setForeground(Color.BLACK);
		menuComparar.add(mEspecifico);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(84, 102, 46, 14);
		contentPanel.add(lblNewLabel);
		
		textDni = new JTextField();
		textDni.setBounds(132, 100, 192, 20);
		contentPanel.add(textDni);
		textDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(72, 144, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(132, 142, 192, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(72, 184, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textApellido = new JTextField();
		textApellido.setBounds(132, 182, 192, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono movil ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(33, 227, 88, 14);
		contentPanel.add(lblNewLabel_3);
		
		textTelefonoM = new JTextField();
		textTelefonoM.setBounds(132, 225, 192, 20);
		contentPanel.add(textTelefonoM);
		textTelefonoM.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono opcional");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(14, 266, 116, 14);
		contentPanel.add(lblNewLabel_4);
		
		textTelefonoO = new JTextField();
		textTelefonoO.setBounds(132, 264, 192, 20);
		contentPanel.add(textTelefonoO);
		textTelefonoO.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Localidad");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(58, 309, 60, 14);
		contentPanel.add(lblNewLabel_5);
		
		textLocalidad = new JTextField();
		textLocalidad.setBounds(132, 307, 192, 20);
		contentPanel.add(textLocalidad);
		textLocalidad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nacimiento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(46, 353, 72, 14);
		contentPanel.add(lblNewLabel_6);
		
		textNacimiento = new JTextField();
		textNacimiento.setBounds(132, 350, 192, 20);
		contentPanel.add(textNacimiento);
		textNacimiento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fallecimiento");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(33, 396, 85, 14);
		contentPanel.add(lblNewLabel_7);
		
		textFallecimiento = new JTextField();
		textFallecimiento.setBounds(132, 393, 192, 20);
		contentPanel.add(textFallecimiento);
		textFallecimiento.setColumns(10);
		
		JButton btnAnadir = new JButton("AÑadir");
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(364, 388, 89, 30);
		contentPanel.add(btnAnadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(364, 434, 89, 30);
		contentPanel.add(btnVolver);
	}
}
