package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VBusBanda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textAmbito;
	private JTextField textFechaIni;
	private JTextField textFechaFin;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusBanda dialog = new VBusBanda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBusBanda() {
		setTitle("Buscar Banda");
		setBounds(100, 100, 433, 415);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 89, 46, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Nombre");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(35, 116, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblAmbito = new JLabel("Ambito");
		lblAmbito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmbito.setBounds(35, 149, 46, 14);
		contentPanel.add(lblAmbito);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaInicio.setBounds(13, 180, 68, 14);
		contentPanel.add(lblFechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaFinal.setBounds(13, 211, 68, 14);
		contentPanel.add(lblFechaFinal);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(99, 85, 163, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(99, 114, 163, 20);
		contentPanel.add(textNombre);
		
		textAmbito = new JTextField();
		textAmbito.setColumns(10);
		textAmbito.setBounds(99, 147, 163, 20);
		contentPanel.add(textAmbito);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(99, 178, 163, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(99, 209, 163, 20);
		contentPanel.add(textFechaFin);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Codigo", "Nombre", "Ambito"},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(84, 299, 150, 48);
		contentPanel.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Bandas Relacionadas");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(84, 284, 150, 14);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(318, 334, 89, 31);
		contentPanel.add(btnVolver);
	}

}
