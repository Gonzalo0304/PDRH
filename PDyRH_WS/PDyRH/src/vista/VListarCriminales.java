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
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VListarCriminales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VListarCriminales dialog = new VListarCriminales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VListarCriminales() {
		setTitle("Listado Criminales");
		setBounds(100, 100, 495, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 469, 37);
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
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);
		
		JMenuItem mPersona = new JMenuItem("Persona");
		mPersona.setHorizontalAlignment(SwingConstants.LEFT);
		mPersona.setBackground(new Color(32, 178, 170));
		mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mPersona.setForeground(Color.BLACK);
		menuBusqueda.add(mPersona);
		
		JMenuItem mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
		mRestoHumano.setBackground(new Color(32, 178, 170));
		mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mRestoHumano.setForeground(Color.BLACK);
		menuBusqueda.add(mRestoHumano);
		
		JMenuItem mCaso = new JMenuItem("Caso");
		mCaso.setHorizontalAlignment(SwingConstants.LEFT);
		mCaso.setBackground(new Color(32, 178, 170));
		mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCaso.setForeground(Color.BLACK);
		menuBusqueda.add(mCaso);
		
		JMenuItem mBanda = new JMenuItem("Banda");
		mBanda.setHorizontalAlignment(SwingConstants.LEFT);
		mBanda.setBackground(new Color(32, 178, 170));
		mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mBanda.setForeground(Color.BLACK);
		menuBusqueda.add(mBanda);
		
		JMenuItem mCriminal = new JMenuItem("Criminales");
		mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
		mCriminal.setBackground(new Color(32, 178, 170));
		mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCriminal.setForeground(Color.BLACK);
		menuBusqueda.add(mCriminal);
		
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
		
		JLabel lblNewLabel = new JLabel("Banda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 67, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(44, 107, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(100, 105, 122, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(245, 107, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 105, 133, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(44, 146, 46, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 144, 122, 20);
		contentPanel.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(245, 147, 46, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(301, 144, 133, 20);
		contentPanel.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("Banda");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(28, 197, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Codigo");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(44, 244, 46, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 242, 122, 20);
		contentPanel.add(textField_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(245, 245, 46, 14);
		contentPanel.add(lblNewLabel_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(301, 242, 133, 20);
		contentPanel.add(textField_6);
		
		JLabel lblSinBanda = new JLabel("Sin Banda");
		lblSinBanda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinBanda.setBounds(28, 298, 82, 14);
		contentPanel.add(lblSinBanda);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Codigo");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(44, 337, 46, 14);
		contentPanel.add(lblNewLabel_1_2_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(100, 335, 122, 20);
		contentPanel.add(textField_8);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nombre");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(245, 337, 46, 14);
		contentPanel.add(lblNewLabel_2_2_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(301, 335, 133, 20);
		contentPanel.add(textField_10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(345, 421, 89, 29);
		contentPanel.add(btnVolver);
	}

}
