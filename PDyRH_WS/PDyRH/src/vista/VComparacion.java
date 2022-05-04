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
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VComparacion extends JDialog {
	private ButtonGroup rh = new ButtonGroup();
	private VIniciarSesion vInicio = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JButton ButtonVolvervComp;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param modal 
	 * @param vMain 
	 */
	public VComparacion(VPrincipal vMain, boolean modal) {
		super(vMain);
		this.setModal(modal);
		
		setTitle("Comparar");
		setBounds(100, 100, 409, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
		
		ButtonVolvervComp = new JButton("Volver");
		ButtonVolvervComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonVolvervComp.setBounds(262, 232, 105, 23);
		ButtonVolvervComp.setBounds(300, 225, 105, 23);
		contentPanel.add(ButtonVolvervComp);
		
		JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
		ButtonCompSelVComp.setEnabled(false);
		ButtonCompSelVComp.setBounds(262, 198, 105, 23);
		contentPanel.add(ButtonCompSelVComp);
		
		JRadioButton RadioButton1VComparacion = new JRadioButton("");
		RadioButton1VComparacion.setBounds(177, 96, 27, 21);
		contentPanel.add(RadioButton1VComparacion);
		
		JRadioButton RadioButton2VComparacion = new JRadioButton("");
		RadioButton2VComparacion.setBounds(177, 120, 27, 23);
		contentPanel.add(RadioButton2VComparacion);
		
		JRadioButton RadioButton3VComparacion = new JRadioButton("");
		RadioButton3VComparacion.setBounds(177, 211, 27, 23);
		contentPanel.add(RadioButton3VComparacion);
		
		JRadioButton RadioButton4VComparacion = new JRadioButton("");
		RadioButton4VComparacion.setBounds(177, 237, 27, 23);
		contentPanel.add(RadioButton4VComparacion);
			
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
	
	public VComparacion(VIniciarSesion vInicio, boolean modal) {
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

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();

	}
}

