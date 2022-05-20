package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.DataFactoryGestCaso;
import controlador.interfaces.ContDatosGestCaso;
import excepciones.Excepciones;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;
import javax.swing.JRadioButton;

/**
 * Esta clase representa la ventana de Gestion de casos
 * @autor Gonzalo
 *
 */
public class VGesCaso extends JDialog implements ContDatosGestCaso, ActionListener {
	private static final long serialVersionUID = 1L;

	// <--- Datos BD --->
	ContDatosGestCaso datos = DataFactoryGestCaso.getDatos();

	// <--- Elementos --->
	private static Point point = new Point();
	private JTabbedPane tabbedPane;
	private JPanel contentDatos;
	private JLabel lblCerrar;
	private JSeparator separatorMenu2;
	private JMenuBar menuBar;
	private JLabel lblDni;
	private JSeparator separatorCod;
	private JTextField textCod;
	private JLabel lblNombre;
	private JSeparator separatorNom;
	private JTextField textNom;
	private JLabel lblEstado;
	private JSeparator separatorEstado;
	private JLabel lblFechaIni;
	private JSeparator separatorFechaIni;
	private JTextField textFechaIni;
	private JLabel lblFechaFin;
	private JSeparator separatorFechaFin;
	private JTextField textFechaFin;
	private JLabel imgErtzAO;
	private JPanel contentInvo;
	private JLabel lblCerrar_1;
	private JLabel lblDniInv;
	private JSeparator separatorDniInv;
	private JTextField textDniInv;
	private JLabel lblmp;
	private JSeparator separatorImp;
	private JTextField textImp;
	private JMenu menInsertar;
	private JMenu menInsertar_1;
	private JMenu menComparar;
	private JMenu menComparar_1;
	private JMenu menGestionar;
	private JMenu menGestionar_1;
	private JMenu menBuscar;
	private JMenu menBuscar_1;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mCerrar2;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JSeparator separatorGesCas;
	private JLabel lblGesPer;
	private JLabel lblAnaInv;
	private JSeparator separatorAnaCono;
	private Button buttonAgregar;
	private String[] info;
	private Button buttonMod;
	private Button buttonEliminar;
	private VIniciarSesion padre;
	private ButtonGroup bgEstado;
	private JRadioButton rdbtnCer;
	private JRadioButton rdbtnSR;
	private JRadioButton rdbtnAbi;
	private Caso caso;
	private JTextField textCodResto;
	private JLabel lblCodResto;
	private JSeparator separatorCodResto;
	private JLabel imgErtzAO_1;
	private JSeparator separatorMenu;

	/**
	 * Es el constructor de la venta.
	 * @param padre es la ventana padre de esta.
	 * @param modal es el valor del modal para dasabilitar la ventana anterior
	 * @param caso recibe el caso a modificar
	 * @param infos es la informacion del usuario
	 */
	public VGesCaso(VIniciarSesion padre, boolean modal, Caso caso, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Gestionar caso");
		setBounds(100, 100, 607, 399);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.padre = padre;
		this.caso = caso;

		// <--- Pestaña 1 --->
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlHighlight);
		tabbedPane.setBounds(0, 0, 607, 399);
		getContentPane().add(tabbedPane);

		contentDatos = new JPanel();
		contentDatos.setLayout(null);
		contentDatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentDatos.setBackground(Color.WHITE);
		tabbedPane.addTab("Datos", null, contentDatos, null);

		// Movimiento de la ventana
		contentDatos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		contentDatos.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		// Botón para cerrar la ventana
		lblCerrar = new JLabel("x");
		lblCerrar.setBackground(new Color(153, 0, 0));
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setForeground(Color.BLACK);
				lblCerrar.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setForeground(Color.WHITE);
				lblCerrar.setOpaque(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(573, 2, 31, 19);
		contentDatos.add(lblCerrar);

		// Menú superior
		separatorMenu = new JSeparator();
		separatorMenu.setBackground(Color.DARK_GRAY);
		separatorMenu.setBounds(2, 47, 603, 2);
		contentDatos.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentDatos.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menUsuario.setHorizontalTextPosition(SwingConstants.LEFT);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setForeground(Color.WHITE);
		menuBar.add(menUsuario);

		mCerrar = new JMenuItem("Cerrar Sesión");
		mCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		mCerrar.addActionListener(this);
		mCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		menInsertar = new JMenu("Insertar");
		menInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menInsertar.setBackground(new Color(0, 0, 255));
		menInsertar.setForeground(Color.WHITE);
		menuBar.add(menInsertar);

		mPersona = new JMenuItem("Persona");
		mPersona.addActionListener(this);
		menInsertar.add(mPersona);

		mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.addActionListener(this);
		menInsertar.add(mRestoHumano);

		mCaso = new JMenuItem("Caso");
		mCaso.addActionListener(this);
		menInsertar.add(mCaso);

		menGestionar = new JMenu("Gestionar");
		menGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirGes();
			}
		});
		menGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menGestionar.setBackground(new Color(0, 0, 255));
		menGestionar.setForeground(Color.WHITE);
		menuBar.add(menGestionar);

		menComparar = new JMenu("Comparar");
		menComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirCom();
			}
		});
		menComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menComparar.setBackground(new Color(0, 0, 255));
		menComparar.setForeground(Color.WHITE);
		menuBar.add(menComparar);

		menBuscar = new JMenu("Busqueda");
		menBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirBus();
			}
		});
		menBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		menBuscar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menBuscar.setBackground(new Color(0, 0, 255));
		menBuscar.setForeground(Color.WHITE);
		menuBar.add(menBuscar);

		// Campos de información
		lblDni = new JLabel("C\u00D3DIGO");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(95, 95, 81, 28);
		contentDatos.add(lblDni);

		separatorCod = new JSeparator();
		separatorCod.setForeground(SystemColor.controlShadow);
		separatorCod.setBackground(new Color(0, 51, 102));
		separatorCod.setBounds(95, 121, 106, 2);
		contentDatos.add(separatorCod);

		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setEnabled(false);
		textCod.setColumns(10);
		textCod.setBounds(95, 134, 187, 20);
		contentDatos.add(textCod);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(95, 153, 81, 28);
		contentDatos.add(lblNombre);

		separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(95, 179, 106, 2);
		contentDatos.add(separatorNom);

		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(95, 192, 187, 20);
		contentDatos.add(textNom);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(new Color(0, 51, 102));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setBounds(247, 219, 81, 28);
		contentDatos.add(lblEstado);

		separatorEstado = new JSeparator();
		separatorEstado.setForeground(SystemColor.controlShadow);
		separatorEstado.setBackground(new Color(0, 51, 102));
		separatorEstado.setBounds(247, 245, 106, 2);
		contentDatos.add(separatorEstado);

		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(328, 134, 187, 20);
		contentDatos.add(textFechaIni);

		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(328, 192, 187, 20);
		contentDatos.add(textFechaFin);

		separatorFechaIni = new JSeparator();
		separatorFechaIni.setForeground(new Color(0, 0, 102));
		separatorFechaIni.setBackground(new Color(0, 51, 102));
		separatorFechaIni.setBounds(328, 121, 106, 2);
		contentDatos.add(separatorFechaIni);

		lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setForeground(new Color(0, 51, 102));
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaFin.setBounds(328, 153, 106, 28);
		contentDatos.add(lblFechaFin);

		separatorFechaFin = new JSeparator();
		separatorFechaFin.setForeground(new Color(0, 0, 102));
		separatorFechaFin.setBackground(new Color(0, 51, 102));
		separatorFechaFin.setBounds(328, 179, 106, 2);
		contentDatos.add(separatorFechaFin);

		lblFechaIni = new JLabel("FECHA INICIO");
		lblFechaIni.setForeground(new Color(0, 51, 102));
		lblFechaIni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaIni.setBounds(328, 95, 106, 28);
		contentDatos.add(lblFechaIni);

		separatorGesCas = new JSeparator();
		separatorGesCas.setForeground(new Color(102, 0, 0));
		separatorGesCas.setBackground(new Color(153, 0, 0));
		separatorGesCas.setBounds(12, 73, 580, 2);
		contentDatos.add(separatorGesCas);

		lblGesPer = new JLabel("Gesti\u00F3n de Caso");
		lblGesPer.setForeground(SystemColor.textInactiveText);
		lblGesPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGesPer.setBounds(12, 51, 142, 19);
		contentDatos.add(lblGesPer);

		// Botones de modificación y eliminación
		buttonMod = new Button("MODIFICAR");
		buttonMod.setForeground(Color.WHITE);
		buttonMod.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonMod.setBackground(new Color(153, 0, 0));
		buttonMod.setBounds(188, 308, 89, 28);
		buttonMod.addActionListener(this);
		contentDatos.add(buttonMod);

		buttonEliminar = new Button("DAR BAJA");
		buttonEliminar.setActionCommand("ELIMINAR");
		buttonEliminar.setForeground(Color.WHITE);
		buttonEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonEliminar.setBackground(new Color(153, 0, 0));
		buttonEliminar.setBounds(328, 308, 89, 28);
		buttonEliminar.addActionListener(this);
		contentDatos.add(buttonEliminar);

		// Campos de selección
		rdbtnAbi = new JRadioButton("Abierto");
		rdbtnAbi.setOpaque(false);
		rdbtnAbi.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnAbi.setBounds(212, 255, 67, 23);
		contentDatos.add(rdbtnAbi);

		rdbtnSR = new JRadioButton("SR");
		rdbtnSR.setOpaque(false);
		rdbtnSR.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSR.setBounds(350, 255, 46, 23);
		contentDatos.add(rdbtnSR);

		rdbtnCer = new JRadioButton("Cerrado");
		rdbtnCer.setOpaque(false);
		rdbtnCer.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnCer.setBounds(281, 255, 71, 23);
		contentDatos.add(rdbtnCer);

		bgEstado = new ButtonGroup();
		bgEstado.add(rdbtnAbi);
		bgEstado.add(rdbtnCer);
		bgEstado.add(rdbtnSR);

		// Fondo
		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon(VGesCaso.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO.setBounds(149, 68, 309, 303);
		contentDatos.add(imgErtzAO);

		cargarDatos(caso);

		// <--- Pestaña 2 --->
		contentInvo = new JPanel();
		contentInvo.setLayout(null);
		contentInvo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentInvo.setBackground(Color.WHITE);
		tabbedPane.addTab("Involucrados", null, contentInvo, null);

		// Movimiento de la ventana
		contentInvo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		contentInvo.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		// Botón para cerrar la ventana
		lblCerrar_1 = new JLabel("x");
		lblCerrar_1.setBackground(new Color(153, 0, 0));
		lblCerrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar_1.setForeground(Color.BLACK);
				lblCerrar_1.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar_1.setForeground(Color.WHITE);
				lblCerrar_1.setOpaque(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		lblCerrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar_1.setForeground(Color.WHITE);
		lblCerrar_1.setBounds(573, 2, 31, 19);
		contentInvo.add(lblCerrar_1);

		// Menú superior
		separatorMenu2 = new JSeparator();
		separatorMenu2.setForeground(SystemColor.controlShadow);
		separatorMenu2.setBackground(new Color(0, 51, 102));
		separatorMenu2.setBounds(1, 45, 601, 2);
		contentInvo.add(separatorMenu2);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentInvo.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menUsuario.setHorizontalTextPosition(SwingConstants.LEFT);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setForeground(Color.WHITE);
		menuBar.add(menUsuario);

		mCerrar2 = new JMenuItem("Cerrar Sesión");
		mCerrar2.setHorizontalTextPosition(SwingConstants.CENTER);
		mCerrar2.addActionListener(this);
		mCerrar2.setHorizontalAlignment(SwingConstants.CENTER);
		mCerrar2.setBackground(new Color(32, 178, 170));
		mCerrar2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar2.setForeground(Color.BLACK);
		menUsuario.add(mCerrar2);

		menInsertar_1 = new JMenu("Insertar");
		menInsertar_1.setHorizontalAlignment(SwingConstants.LEFT);
		menInsertar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menInsertar_1.setForeground(Color.WHITE);
		menuBar.add(menInsertar_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirInsertPer();
			}
		});
		menInsertar_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Caso");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirInsertCaso();
			}
		});
		menInsertar_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Resto humano");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirInsertRH();
			}
		});
		menInsertar_1.add(mntmNewMenuItem_2);

		menGestionar_1 = new JMenu("Gestionar");
		menGestionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirGes();
			}
			
		});
		menGestionar_1.setHorizontalAlignment(SwingConstants.LEFT);
		menGestionar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menGestionar_1.setForeground(Color.WHITE);
		menuBar.add(menGestionar_1);

		menComparar_1 = new JMenu("Comparar");
		menComparar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCom();
			}
		});
		menComparar_1.setHorizontalAlignment(SwingConstants.LEFT);
		menComparar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menComparar_1.setForeground(Color.WHITE);
		menuBar.add(menComparar_1);

		menBuscar_1 = new JMenu("Busqueda");
		menBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirBus();
			}
		});
		menBuscar_1.setHorizontalAlignment(SwingConstants.LEFT);
		menBuscar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menBuscar_1.setForeground(Color.WHITE);
		menuBar.add(menBuscar_1);

		// Campos de participante involucrado
		lblDniInv = new JLabel("DNI");
		lblDniInv.setForeground(new Color(0, 51, 102));
		lblDniInv.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDniInv.setBounds(61, 106, 81, 28);
		contentInvo.add(lblDniInv);

		separatorDniInv = new JSeparator();
		separatorDniInv.setForeground(new Color(0, 0, 102));
		separatorDniInv.setBackground(new Color(0, 51, 102));
		separatorDniInv.setBounds(61, 132, 106, 2);
		contentInvo.add(separatorDniInv);

		textDniInv = new JTextField();
		textDniInv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textDniInv.setColumns(10);
		textDniInv.setBounds(61, 145, 187, 20);
		contentInvo.add(textDniInv);

		lblmp = new JLabel("IMPLICACI\u00D3N");
		lblmp.setForeground(new Color(0, 51, 102));
		lblmp.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblmp.setBounds(344, 106, 81, 28);
		contentInvo.add(lblmp);

		separatorImp = new JSeparator();
		separatorImp.setForeground(new Color(0, 0, 102));
		separatorImp.setBackground(new Color(0, 51, 102));
		separatorImp.setBounds(344, 132, 106, 2);
		contentInvo.add(separatorImp);

		textImp = new JTextField();
		textImp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textImp.setColumns(10);
		textImp.setBounds(344, 145, 187, 20);
		contentInvo.add(textImp);

		lblAnaInv = new JLabel(" A\u00F1adir Involucrados");
		lblAnaInv.setForeground(SystemColor.textInactiveText);
		lblAnaInv.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblAnaInv.setBounds(10, 53, 142, 19);
		contentInvo.add(lblAnaInv);

		separatorAnaCono = new JSeparator();
		separatorAnaCono.setForeground(new Color(102, 0, 0));
		separatorAnaCono.setBackground(new Color(153, 0, 0));
		separatorAnaCono.setBounds(10, 75, 582, 2);
		contentInvo.add(separatorAnaCono);

		// Botón para agregar
		buttonAgregar = new Button("A\u00D1ADIR");
		buttonAgregar.setEnabled(false);
		buttonAgregar.setForeground(Color.WHITE);
		buttonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAgregar.setBackground(new Color(153, 0, 0));
		buttonAgregar.setBounds(248, 297, 89, 28);
		buttonAgregar.addActionListener(this);
		contentInvo.add(buttonAgregar);

		// Campo de resto involucrado
		lblCodResto = new JLabel("C\u00D3DIGO RESTO");
		lblCodResto.setForeground(new Color(153, 0, 0));
		lblCodResto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCodResto.setBounds(195, 202, 106, 28);
		contentInvo.add(lblCodResto);

		separatorCodResto = new JSeparator();
		separatorCodResto.setForeground(new Color(102, 0, 0));
		separatorCodResto.setBackground(new Color(153, 0, 0));
		separatorCodResto.setBounds(195, 228, 106, 2);
		contentInvo.add(separatorCodResto);

		textCodResto = new JTextField();
		textCodResto.setColumns(10);
		textCodResto.setBounds(195, 241, 187, 20);
		textCodResto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		contentInvo.add(textCodResto);

		// Fondo
		imgErtzAO_1 = new JLabel("");
		imgErtzAO_1.setIcon(new ImageIcon(VGesCaso.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO_1.setBounds(142, 68, 309, 303);
		contentInvo.add(imgErtzAO_1);
	}

	// <--- Métodos --->
	// Cargar la información
	/**
	 * Muestra los datos de el caso que vamos a modificar. Para el estado del caso primero lo comprueba y luego marca el radiobutton correspondiente y para las fechas comprueba si no estan
	 * en null y si no lo estan las parsea de LocalDate a String.
	 * @param caso envia el dato a gestionar
	 */
	private void cargarDatos(Caso caso) {
		textCod.setText(caso.getCodCaso());
		textNom.setText(caso.getNombre());
		switch (caso.getEstado()) {
		case "Abierto":
			rdbtnAbi.setSelected(true);
			break;
		case "Cerrado":
			rdbtnCer.setSelected(true);
			break;
		case "Sin resolver":
			rdbtnSR.setSelected(true);
			break;
		}
		if (caso.getFechaIni() != null) {
			textFechaIni.setText(caso.getFechaIni().toString());
		}
		if (caso.getFechaFin() != null) {
			textFechaFin.setText(caso.getFechaFin().toString());
		}
	}

	// Abrir ventanas de menú
	/**
	 * Abrir ventana de gestion desde JMenuBar 
	 */
	private void abrirGes() {
		VGestion vBus = new VGestion(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}
	/**
	 * Abrir ventana de comparacion desde JMenuBar 
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Abrir ventana de busqueda desde JMenuBar 
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de resto humano desde JMenuBar 
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info, false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de persona desde JMenuBar 
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de caso desde JMenuBar 
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}

	// Habilitar botón cuando haya texto introducido
	/**
	 * Comprobar si el DNI del involucardo y la implicacion no estan en blanco o el codigo de resto no esta en blaco  si se cumple una de estas dos condiciones habilitar el boton.
	 */
	public void habilitarBoton() {
		if ((!textImp.getText().isBlank() && !textDniInv.getText().isBlank()) || !textCodResto.getText().isBlank()) {
			buttonAgregar.setEnabled(true);
		} else {
			buttonAgregar.setEnabled(false);
		}
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	/**
	 * Cerrar esta ventana y abrir la anterior
	 */
	public void cerrar() {
		VGestion vGest = new VGestion(padre, true, info);
		this.dispose();
		vGest.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
			if (JOptionPane.showConfirmDialog(this,
					"¿Seguro que desea cerrar sesión?",
					"Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				this.dispose();
				padre.setVisible(true);
			}
		} else if (e.getSource().equals(mCerrar2)) {
			if (JOptionPane.showConfirmDialog(this,
					"¿Seguro que desea cerrar sesión?",
					"Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				this.dispose();
				padre.setVisible(true);
			}
		} else if (e.getSource().equals(buttonEliminar)) {
			eliminarCaso(caso.getCodCaso());
		} else if (e.getSource().equals(buttonAgregar)) {
			if (!textCodResto.getText().isBlank()) {
				insertarInvolucrado(textCodResto.getText(), caso.getCodCaso());
			}
			if (!textDniInv.getText().isBlank() && !textImp.getText().isBlank()) {
				if (!comprobarDNI(textDniInv.getText())) {
					JOptionPane.showMessageDialog(this, "El DNI introducido no está registrado en la base de datos.",
							"DNI inexistente.", JOptionPane.ERROR_MESSAGE);
				} else if (listarParticipantes(textCod.getText()).get(textDniInv.getText()) == null) {
					Participante par = new Participante();
					insertarParticipante(par);
				} else {
					JOptionPane.showMessageDialog(this, "El DNI introducido ya es un participante de este caso.",
							"DNI existente.", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
		} else if (e.getSource().equals(buttonMod)) {
			try {
				modificarCaso(caso);
			} catch (DateTimeParseException e1) {
				JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto(yyyy-mm-dd).", "Formato incorrecto",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	/**
	 * Actualiza los datos modificados del caso. Para la fechaIni y la fechaFin si no se han dejado en blanco se parsea a LocalDate. Si la modificacion es exitosa  saldra un JOptionPane
	 * diciendo que la modificacion a sido exitosa y si esta mal introducido avisara con otro
	 * @param caso carga los datos del caso
	 */
	public void modificarCaso(Caso caso) {
		caso.setNombre(textNom.getText());
		caso.setEstado(rbSelect(bgEstado));
		if (!textFechaIni.getText().isBlank()) {
			caso.setFechaIni(LocalDate.parse(textFechaIni.getText()));
		}
		if (!textFechaFin.getText().isBlank()) {
			caso.setFechaFin(LocalDate.parse(textFechaFin.getText()));
		}
		try {
			datos.modificarCaso(caso);
			JOptionPane.showMessageDialog(this, "Modificación realizada con éxito.", "Modificación exitosa",
					JOptionPane.CLOSED_OPTION);
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Carácteres excedidos.", JOptionPane.ERROR_MESSAGE);
		} 
	}

	// Compronar que radio buttón está seleccionado
	/**
	 * Para comprobarlo se van pasando por los RadioRuttons del ButtonGroup y se comprueba si esta seleccionado si lo esta devuelve el texto del radiobuton si no devuelve null
	 * @param bg es el grupo de radiobuttons
	 * @return null devuelve null en caso de no estar ningun radiobutton seleccionado
	 */
	public String rbSelect(ButtonGroup bg) {
		for (Enumeration<AbstractButton> botones = bg.getElements(); botones.hasMoreElements();) {
			AbstractButton boton = botones.nextElement();

			if (boton.isSelected()) {
				return boton.getText();
			}
		}

		return null;
	}

	@Override
	/**
	 * Antes de eliminar un caso se avisara de que es una accion permanente y tendra que comfirmarlo si decide darlo de baja se avisaba con un JOptionPane.
	 * @param codCaso se envia el codigo de caso
	 */
	public void eliminarCaso(String codCaso) {
		if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este caso? Es una acción irreversible.",
				"Confirmar baja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
			datos.eliminarCaso(codCaso);
			;
			JOptionPane.showMessageDialog(this, "Caso eliminado correctamente.", "Baja realizada",
					JOptionPane.CLOSED_OPTION);
			cerrar();
		}
	}

	@Override
	/**
	 * Se insertan en participante el dni de la persona participante y su implicacion. Si se introduce correctamente saldra un JOptionPane indicando que la insercion se ha realizado 
	 * correctamente y si no se a introducido correctamente tambien se mostrar uno diciendo que se ha introducido mal.
	 * @param par se pasa el participante
	 */
	public void insertarParticipante(Participante par) {
		par.setCodCaso(caso.getCodCaso());
		par.setDni(textDniInv.getText());
		par.setImplicacion(textImp.getText());
		try {
			datos.insertarParticipante(par);
			JOptionPane.showMessageDialog(this, "Insercción de persona participante realizada con éxito.",
					"Insercción exitosa", JOptionPane.CLOSED_OPTION);
			textDniInv.setText("");
			textImp.setText("");
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Carácteres excedidos.", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	/**
	 * Si el codigo de resto humano no esta registrado se avisara con un JOptionPane, si esta bien introducido tambien se avisara con un JOptionPane y se limpiaran os cambios para poder 
	 * realizar otra insercion y si el codigo ya esta introducido en un caso este no te dejara introducirlo y se te avisara de esto con un JOptionPane.
	 * @param codResto se pasa el codigo de resto humano
	 * @param codCaso se pasa el codigo de caso
	 */
	public void insertarInvolucrado(String codResto, String codCaso) {
		if (!comprobarCodResto(textCodResto.getText())) {
			JOptionPane.showMessageDialog(this,
					"El código de resto introducido no está registrado en la base de datos.", "Código inexistente.",
					JOptionPane.ERROR_MESSAGE);
		} else if (listarInvolucrados(textCod.getText()).get(textCodResto.getText()) == null) {
			datos.insertarInvolucrado(codResto, codCaso);
			JOptionPane.showMessageDialog(this, "Insercción de resto involucrado realizada con éxito",
					"Insercción exitosa", JOptionPane.CLOSED_OPTION);
			textCod.setText("");
			textCodResto.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "El código introducido ya está involucrado en un caso.",
					"Código existente", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		return datos.listarParticipantes(codCaso);
	}

	@Override
	public boolean comprobarCodResto(String codResto) {
		return datos.comprobarCodResto(codResto);
	}

	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
		return datos.listarInvolucrados(codCaso);
	}
}
