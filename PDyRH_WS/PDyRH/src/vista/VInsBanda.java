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

public class VInsBanda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textAmbito;
	private JTextField textFechaIni;
	private JTextField textFechaFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInsBanda dialog = new VInsBanda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInsBanda() {
		setBounds(100, 100, 494, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 478, 37);
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
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 60, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 100, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ambito");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(40, 140, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Inicio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 178, 74, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Final");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(12, 217, 74, 14);
		contentPanel.add(lblNewLabel_4);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(96, 58, 153, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(96, 98, 153, 20);
		contentPanel.add(textNombre);
		
		textAmbito = new JTextField();
		textAmbito.setColumns(10);
		textAmbito.setBounds(96, 138, 153, 20);
		contentPanel.add(textAmbito);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(96, 176, 153, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(96, 215, 153, 20);
		contentPanel.add(textFechaFin);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(345, 140, 89, 37);
		contentPanel.add(btnAnadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(345, 200, 89, 37);
		contentPanel.add(btnVolver);
	}

}