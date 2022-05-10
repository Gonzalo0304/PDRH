package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import controlador.DataFactoryInsertPer;
import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosInsertPer;
import modelo.ContBDImpleInsertPer;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

import java.awt.Button;

public class VInsPersona extends JDialog implements ActionListener, ContDatosInsertPer {

	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefonoM;
	private JTextField textTelefonoO;
	private JTextField textLocalidad;
	private JTextField textNacimiento;
	private JTextField textFallecimiento;
	private JTextField textFieldRango;
	private JTextField textFieldInServ;
	private JTextField textFieldFinServ;
	private JTextField textFieldFechArresto;
	private JTextField textFieldFechDes;
	private JTextField textFieldUltUbi;
	private JTextField textFieldGenero;
	private JTextField textFieldTipoPelo;
	private JTextField textFieldColorPelo;
	private JTextField textFieldColorOjos;
	private JTextField textFieldAltura;
	private JTextField textFieldEspecifi;
	private JLabel lblRango;
	private JLabel lblInServ;
	private JLabel lblFinServ;
	private JPanel panelAgente;
	private JPanel panelCriminal;
	private JLabel lbPrisionero;
	private JLabel lblFechArresto;
	private JPanel panelDes;
	private JLabel lblNewLabel_8;
	private JLabel lblFechDes;
	private JLabel lblEspecifi;
	private JLabel lblAltura;
	private JLabel lblColorOjos;
	private JLabel lblColorPelo;
	private JLabel lblTipoPelo;
	private JLabel lblGenero;
	private JLabel lblUltUbicacion;
	private JLabel lblNewLabel_9;
	private JLabel FondopanelPrin;
	private Button btnAnadir;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JRadioButton rdbtnAgente;
	private JRadioButton rdbtnDesaparecida;
	private JRadioButton rdbtnCriminal;
	private JRadioButton rdbtnSiPreso;
	private JRadioButton rdbtnNoPreso;
	private ButtonGroup tipo = new ButtonGroup();
	private ButtonGroup preso = new ButtonGroup();
	
	private VIniciarSesion vInicio = null;
	private ContDatosBusq datos;
	private String[] info;
	private Persona per;
	
	ContDatosInsertPer datos2 = DataFactoryInsertPer.getDatos(); 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VInsPersona dialog = new VInsPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.

	 * @param b 
	 * @param vInserciones 
	 * 
	 * @param b
	 * @param vInserciones
	 */

	
	/*public VInsPersona() {
		datos1 =  new ContBDImpleInsertPer();
	public VInsPersona(VInserciones inserciones, boolean modal) {
		super(inserciones);
		this.setModal(modal);
		
		setBounds(100, 100, 479, 514);
		datos1 = new ContBDImpleInsertPer();

		setBounds(350, 150, 710, 518);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);

		
		 //Movimiento de la ventana addMouseListener(new MouseAdapter() { public void
		 mousePressed(MouseEvent e) { point.x = e.getX(); point.y = e.getY(); } });
		 addMouseMotionListener(new MouseMotionAdapter() { public void
		 mouseDragged(MouseEvent e) { Point p = getLocation(); setLocation(p.x +
		 e.getX() - point.x, p.y + e.getY() - point.y); } });
		 

		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(84, 102, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNewLabel);

		// JTextField
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textDni.setBounds(132, 100, 192, 20);
		contentPanel.add(textDni);
		textDni.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(72, 133, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textNombre.setBounds(132, 131, 192, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(72, 164, 46, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_2);

		textApellido = new JTextField();
		textApellido.setBounds(132, 162, 192, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Telefono movil ");
		lblNewLabel_3.setBounds(33, 199, 88, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_3);

		textTelefonoM = new JTextField();
		textTelefonoM.setBounds(132, 193, 192, 20);
		contentPanel.add(textTelefonoM);
		textTelefonoM.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Telefono opcional");
		lblNewLabel_4.setBounds(14, 224, 116, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_4);

		textTelefonoO = new JTextField();
		textTelefonoO.setBounds(132, 224, 192, 20);
		contentPanel.add(textTelefonoO);
		textTelefonoO.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Localidad");
		lblNewLabel_5.setBounds(58, 257, 60, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_5);

		textLocalidad = new JTextField();
		textLocalidad.setBounds(132, 255, 192, 20);
		contentPanel.add(textLocalidad);
		textLocalidad.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nacimiento");
		lblNewLabel_6.setBounds(46, 288, 72, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_6);

		textNacimiento = new JTextField();
		textNacimiento.setBounds(132, 286, 192, 20);
		contentPanel.add(textNacimiento);
		textNacimiento.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fallecimiento");
		lblNewLabel_7.setBounds(45, 319, 85, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_7);

		textFallecimiento = new JTextField();
		textFallecimiento.setBounds(132, 317, 192, 20);
		contentPanel.add(textFallecimiento);
		textFallecimiento.setColumns(10);

		// Buttons
		btnAnadir = new Button("A\u00F1adir");
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setBounds(595, 433, 89, 30);
		btnAnadir.addActionListener(this);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnAnadir);

		// RadioButtons
		rdbtnNewRadioButton = new JRadioButton("Agente");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(30, 44, 72, 23);
		tipo.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Desaparecida");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(104, 44, 109, 23);
		tipo.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Criminal");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(215, 44, 109, 23);
		rdbtnNewRadioButton_2.addActionListener(this);
		tipo.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnNewRadioButton_2);

		panelAgente = new JPanel();
		panelAgente.setBounds(334, 74, 300, 389);
		contentPanel.add(panelAgente);
		panelAgente.setLayout(null);
		panelAgente.setVisible(false);
		panelAgente.setOpaque(false);

		panelCriminal = new JPanel();
		panelCriminal.setBounds(334, 83, 310, 299);
		contentPanel.add(panelCriminal);
		panelCriminal.setLayout(null);
		panelCriminal.setVisible(false);
		panelCriminal.setOpaque(false);

		panelDes = new JPanel();
		panelDes.setBounds(334, 74, 350, 325);
		contentPanel.add(panelDes);
		panelDes.setLayout(null);
		panelDes.setVisible(false);
		panelDes.setOpaque(false);

		textFieldRango = new JTextField();
		textFieldRango.setBounds(84, 28, 192, 20);
		panelAgente.add(textFieldRango);
		textFieldRango.setColumns(10);

		// Agente
		lblRango = new JLabel("Rango");
		lblRango.setBounds(28, 28, 46, 18);
		panelAgente.add(lblRango);
		lblRango.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblInServ = new JLabel("Inicio Serv");
		lblInServ.setBounds(10, 61, 60, 14);
		panelAgente.add(lblInServ);
		lblInServ.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldInServ = new JTextField();
		textFieldInServ.setBounds(84, 59, 192, 20);
		panelAgente.add(textFieldInServ);
		textFieldInServ.setColumns(10);

		textFieldFinServ = new JTextField();
		textFieldFinServ.setBounds(84, 90, 192, 20);
		panelAgente.add(textFieldFinServ);
		textFieldFinServ.setColumns(10);

		lblFinServ = new JLabel("Fin Serv");
		lblFinServ.setBounds(20, 92, 50, 14);
		panelAgente.add(lblFinServ);
		lblFinServ.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(144, 31, 46, 14);
		panelAgente.add(lblNewLabel_8);

		lbPrisionero = new JLabel("Prisionero");
		lbPrisionero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrisionero.setBounds(10, 23, 78, 14);
		panelCriminal.add(lbPrisionero);

		lblFechArresto = new JLabel("Fecha Arresto");
		lblFechArresto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechArresto.setBounds(10, 54, 88, 14);
		panelCriminal.add(lblFechArresto);

		textFieldFechArresto = new JTextField();
		textFieldFechArresto.setColumns(10);
		textFieldFechArresto.setBounds(108, 52, 192, 20);
		panelCriminal.add(textFieldFechArresto);

		rdbtnSiPreso = new JRadioButton("Si");
		rdbtnSiPreso.setBounds(108, 20, 40, 23);
		rdbtnSiPreso.setOpaque(false);
		preso.add(rdbtnSiPreso);
		panelCriminal.add(rdbtnSiPreso);

		rdbtnNoPreso = new JRadioButton("No");
		rdbtnNoPreso.setBounds(150, 20, 46, 23);
		rdbtnNoPreso.setOpaque(false);
		preso.add(rdbtnNoPreso);
		panelCriminal.add(rdbtnNoPreso);

		lblFechDes = new JLabel("Fecha Desaparecido");
		lblFechDes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechDes.setBounds(10, 27, 116, 14);
		panelDes.add(lblFechDes);

		textFieldFechDes = new JTextField();
		textFieldFechDes.setColumns(10);
		textFieldFechDes.setBounds(128, 25, 192, 20);
		panelDes.add(textFieldFechDes);

		textFieldUltUbi = new JTextField();
		textFieldUltUbi.setColumns(10);
		textFieldUltUbi.setBounds(128, 56, 192, 20);
		panelDes.add(textFieldUltUbi);

		textFieldGenero = new JTextField();
		textFieldGenero.setColumns(10);
		textFieldGenero.setBounds(128, 87, 192, 20);
		panelDes.add(textFieldGenero);

		textFieldTipoPelo = new JTextField();
		textFieldTipoPelo.setColumns(10);
		textFieldTipoPelo.setBounds(128, 118, 192, 20);
		panelDes.add(textFieldTipoPelo);

		textFieldColorPelo = new JTextField();
		textFieldColorPelo.setColumns(10);
		textFieldColorPelo.setBounds(128, 149, 192, 20);
		panelDes.add(textFieldColorPelo);

		textFieldColorOjos = new JTextField();
		textFieldColorOjos.setColumns(10);
		textFieldColorOjos.setBounds(128, 180, 192, 20);
		panelDes.add(textFieldColorOjos);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(128, 211, 192, 20);
		panelDes.add(textFieldAltura);

		textFieldEspecifi = new JTextField();
		textFieldEspecifi.setColumns(10);
		textFieldEspecifi.setBounds(128, 242, 192, 20);
		panelDes.add(textFieldEspecifi);

		lblEspecifi = new JLabel("Especificaciones");
		lblEspecifi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspecifi.setBounds(26, 244, 100, 14);
		panelDes.add(lblEspecifi);

		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(80, 213, 34, 14);
		panelDes.add(lblAltura);

		lblColorOjos = new JLabel("Color Ojos");
		lblColorOjos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorOjos.setBounds(54, 182, 60, 14);
		panelDes.add(lblColorOjos);

		lblColorPelo = new JLabel("Color Pelo");
		lblColorPelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorPelo.setBounds(54, 149, 72, 14);
		panelDes.add(lblColorPelo);

		lblTipoPelo = new JLabel("Tipo Pelo");
		lblTipoPelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoPelo.setBounds(57, 124, 60, 14);
		panelDes.add(lblTipoPelo);

		lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(68, 89, 46, 14);
		panelDes.add(lblGenero);

		lblUltUbicacion = new JLabel("Ultima Ubicacion");
		lblUltUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUltUbicacion.setBounds(20, 58, 94, 14);
		panelDes.add(lblUltUbicacion);

		FondopanelPrin = new JLabel("");
		FondopanelPrin.setBackground(Color.WHITE);
		FondopanelPrin.setHorizontalAlignment(SwingConstants.CENTER);
		FondopanelPrin.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		FondopanelPrin.setBounds(0, 36, 710, 443);
		contentPanel.add(FondopanelPrin);

		lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				volver();
			}
		});
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBackground(new Color(0, 51, 153));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(664, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);

		// JMenu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 710, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);

		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.WHITE);
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.WHITE);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.WHITE);
		menuBar.add(menuComparar);

		mTotal = new JMenuItem("Total");
		mTotal.setHorizontalAlignment(SwingConstants.LEFT);
		mTotal.setBackground(new Color(32, 178, 170));
		mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mTotal.setForeground(Color.BLACK);
		menuComparar.add(mTotal);

		mEspecifico = new JMenuItem("Especifico");
		mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
		mEspecifico.setBackground(new Color(32, 178, 170));
		mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mEspecifico.setForeground(Color.BLACK);
		menuComparar.add(mEspecifico);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.WHITE);
		menuBar.add(menuBusqueda);

		menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.WHITE);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		textFallecimiento = new JTextField();
		textFallecimiento.setBounds(132, 317, 192, 20);
		contentPanel.add(textFallecimiento);
		textFallecimiento.setColumns(10);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setEnabled(false);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(364, 388, 89, 30);
		contentPanel.add(btnAnadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(364, 434, 89, 30);
		contentPanel.add(btnVolver);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Agente");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(30, 44, 72, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Desaparecida");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(104, 44, 109, 23);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Criminal");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(215, 44, 109, 23);
		contentPanel.add(rdbtnNewRadioButton_2);
	}
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();

	}
	*/
	
	public VInsPersona(VIniciarSesion vInicio, boolean modal) {
		super(vInicio);
		this.setModal(modal);

		setBounds(350, 150, 710, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);

		/*
		 * // Movimiento de la ventana addMouseListener(new MouseAdapter() { public void
		 * mousePressed(MouseEvent e) { point.x = e.getX(); point.y = e.getY(); } });
		 * addMouseMotionListener(new MouseMotionAdapter() { public void
		 * mouseDragged(MouseEvent e) { Point p = getLocation(); setLocation(p.x +
		 * e.getX() - point.x, p.y + e.getY() - point.y); } });
		 */

		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(84, 102, 46, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(lblNewLabel);

		// JTextField
		textDni = new JTextField();
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textDni.setBounds(132, 100, 192, 20);
		contentPanel.add(textDni);
		textDni.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(72, 133, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textNombre.setBounds(132, 131, 192, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(72, 164, 46, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_2);

		textApellido = new JTextField();
		textApellido.setBounds(132, 162, 192, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Telefono movil ");
		lblNewLabel_3.setBounds(33, 199, 88, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_3);

		textTelefonoM = new JTextField();
		textTelefonoM.setBounds(132, 193, 192, 20);
		contentPanel.add(textTelefonoM);
		textTelefonoM.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Telefono opcional");
		lblNewLabel_4.setBounds(14, 224, 116, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_4);

		textTelefonoO = new JTextField();
		textTelefonoO.setBounds(132, 224, 192, 20);
		contentPanel.add(textTelefonoO);
		textTelefonoO.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Localidad");
		lblNewLabel_5.setBounds(58, 257, 60, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_5);

		textLocalidad = new JTextField();
		textLocalidad.setBounds(132, 255, 192, 20);
		contentPanel.add(textLocalidad);
		textLocalidad.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nacimiento");
		lblNewLabel_6.setBounds(46, 288, 72, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_6);

		textNacimiento = new JTextField();
		textNacimiento.setBounds(132, 286, 192, 20);
		contentPanel.add(textNacimiento);
		textNacimiento.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Fallecimiento");
		lblNewLabel_7.setBounds(45, 319, 85, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(lblNewLabel_7);

		textFallecimiento = new JTextField();
		textFallecimiento.setBounds(132, 317, 192, 20);
		contentPanel.add(textFallecimiento);
		textFallecimiento.setColumns(10);

		// Buttons
		btnAnadir = new Button("A\u00F1adir");
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setBounds(568, 388, 116, 40);
		btnAnadir.addActionListener(this);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnAnadir);


		// RadioButtons
		rdbtnAgente = new JRadioButton("Agente");
		rdbtnAgente.setBackground(Color.WHITE);
		rdbtnAgente.setBounds(30, 44, 72, 23);
		tipo.add(rdbtnAgente);
		rdbtnAgente.addActionListener(this);
		rdbtnAgente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnAgente);

		rdbtnDesaparecida = new JRadioButton("Desaparecida");
		rdbtnDesaparecida.setBackground(Color.WHITE);
		rdbtnDesaparecida.setBounds(104, 44, 109, 23);
		tipo.add(rdbtnDesaparecida);
		rdbtnDesaparecida.addActionListener(this);
		rdbtnDesaparecida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnDesaparecida);

		rdbtnCriminal = new JRadioButton("Criminal");
		rdbtnCriminal.setBackground(Color.WHITE);
		rdbtnCriminal.setBounds(215, 44, 109, 23);
		rdbtnCriminal.addActionListener(this);
		tipo.add(rdbtnCriminal);
		rdbtnCriminal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(rdbtnCriminal);

		panelAgente = new JPanel();
		panelAgente.setBounds(334, 74, 300, 389);
		contentPanel.add(panelAgente);
		panelAgente.setLayout(null);
		panelAgente.setVisible(false);
		panelAgente.setOpaque(false);

		panelCriminal = new JPanel();
		panelCriminal.setBounds(334, 83, 310, 299);
		contentPanel.add(panelCriminal);
		panelCriminal.setLayout(null);
		panelCriminal.setVisible(false);
		panelCriminal.setOpaque(false);

		panelDes = new JPanel();
		panelDes.setBounds(334, 74, 350, 325);
		contentPanel.add(panelDes);
		panelDes.setLayout(null);
		panelDes.setVisible(false);
		panelDes.setOpaque(false);

		textFieldRango = new JTextField();
		textFieldRango.setBounds(84, 28, 192, 20);
		panelAgente.add(textFieldRango);
		textFieldRango.setColumns(10);

		// Agente
		lblRango = new JLabel("Rango");
		lblRango.setBounds(28, 28, 46, 18);
		panelAgente.add(lblRango);
		lblRango.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblInServ = new JLabel("Inicio Serv");
		lblInServ.setBounds(10, 61, 60, 14);
		panelAgente.add(lblInServ);
		lblInServ.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textFieldInServ = new JTextField();
		textFieldInServ.setBounds(84, 59, 192, 20);
		panelAgente.add(textFieldInServ);
		textFieldInServ.setColumns(10);

		textFieldFinServ = new JTextField();
		textFieldFinServ.setBounds(84, 90, 192, 20);
		panelAgente.add(textFieldFinServ);
		textFieldFinServ.setColumns(10);

		lblFinServ = new JLabel("Fin Serv");
		lblFinServ.setBounds(20, 92, 50, 14);
		panelAgente.add(lblFinServ);
		lblFinServ.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(144, 31, 46, 14);
		panelAgente.add(lblNewLabel_8);

		lbPrisionero = new JLabel("Prisionero");
		lbPrisionero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrisionero.setBounds(10, 23, 78, 14);
		panelCriminal.add(lbPrisionero);

		lblFechArresto = new JLabel("Fecha Arresto");
		lblFechArresto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechArresto.setBounds(10, 54, 88, 14);
		panelCriminal.add(lblFechArresto);

		textFieldFechArresto = new JTextField();
		textFieldFechArresto.setColumns(10);
		textFieldFechArresto.setBounds(108, 52, 192, 20);
		panelCriminal.add(textFieldFechArresto);

		rdbtnSiPreso = new JRadioButton("Si");
		rdbtnSiPreso.setBounds(108, 20, 40, 23);
		rdbtnSiPreso.setOpaque(false);
		preso.add(rdbtnSiPreso);
		panelCriminal.add(rdbtnSiPreso);

		rdbtnNoPreso = new JRadioButton("No");
		rdbtnNoPreso.setBounds(150, 20, 46, 23);
		rdbtnNoPreso.setOpaque(false);
		preso.add(rdbtnNoPreso);
		panelCriminal.add(rdbtnNoPreso);

		lblFechDes = new JLabel("Fecha Desaparecido");
		lblFechDes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechDes.setBounds(10, 27, 116, 14);
		panelDes.add(lblFechDes);

		textFieldFechDes = new JTextField();
		textFieldFechDes.setColumns(10);
		textFieldFechDes.setBounds(128, 25, 192, 20);
		panelDes.add(textFieldFechDes);

		textFieldUltUbi = new JTextField();
		textFieldUltUbi.setColumns(10);
		textFieldUltUbi.setBounds(128, 56, 192, 20);
		panelDes.add(textFieldUltUbi);

		textFieldGenero = new JTextField();
		textFieldGenero.setColumns(10);
		textFieldGenero.setBounds(128, 87, 192, 20);
		panelDes.add(textFieldGenero);

		textFieldTipoPelo = new JTextField();
		textFieldTipoPelo.setColumns(10);
		textFieldTipoPelo.setBounds(128, 118, 192, 20);
		panelDes.add(textFieldTipoPelo);

		textFieldColorPelo = new JTextField();
		textFieldColorPelo.setColumns(10);
		textFieldColorPelo.setBounds(128, 149, 192, 20);
		panelDes.add(textFieldColorPelo);

		textFieldColorOjos = new JTextField();
		textFieldColorOjos.setColumns(10);
		textFieldColorOjos.setBounds(128, 180, 192, 20);
		panelDes.add(textFieldColorOjos);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(128, 211, 192, 20);
		panelDes.add(textFieldAltura);

		textFieldEspecifi = new JTextField();
		textFieldEspecifi.setColumns(10);
		textFieldEspecifi.setBounds(128, 242, 192, 20);
		panelDes.add(textFieldEspecifi);

		lblEspecifi = new JLabel("Especificaciones");
		lblEspecifi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspecifi.setBounds(26, 244, 100, 14);
		panelDes.add(lblEspecifi);

		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(80, 213, 34, 14);
		panelDes.add(lblAltura);

		lblColorOjos = new JLabel("Color Ojos");
		lblColorOjos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorOjos.setBounds(54, 182, 60, 14);
		panelDes.add(lblColorOjos);

		lblColorPelo = new JLabel("Color Pelo");
		lblColorPelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorPelo.setBounds(54, 149, 72, 14);
		panelDes.add(lblColorPelo);

		lblTipoPelo = new JLabel("Tipo Pelo");
		lblTipoPelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoPelo.setBounds(57, 124, 60, 14);
		panelDes.add(lblTipoPelo);

		lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(68, 89, 46, 14);
		panelDes.add(lblGenero);

		lblUltUbicacion = new JLabel("Ultima Ubicacion");
		lblUltUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUltUbicacion.setBounds(20, 58, 94, 14);
		panelDes.add(lblUltUbicacion);

		FondopanelPrin = new JLabel("");
		FondopanelPrin.setBackground(Color.WHITE);
		FondopanelPrin.setHorizontalAlignment(SwingConstants.CENTER);
		FondopanelPrin.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		FondopanelPrin.setBounds(0, 36, 710, 443);
		contentPanel.add(FondopanelPrin);

		lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				volver();
			}
		});
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBackground(new Color(0, 51, 153));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(664, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);

		// JMenu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 710, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);

		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.WHITE);
		menuBar.add(menuInsertar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		menuInsertar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Resto Humano");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		menuInsertar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Caso");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		menuInsertar.add(mntmNewMenuItem_2);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				gestionar();
			}
		});
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.WHITE);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				comparar();
			}
		});
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.WHITE);
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				buscar();
			}
		});
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.WHITE);
		menuBar.add(menuBusqueda);

		menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.WHITE);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAnadir)) {
			altaPersona();
		}
		if (e.getSource().equals(rdbtnAgente)) {
			panelAgente.setVisible(true);
			panelCriminal.setVisible(false);
			panelDes.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		} else if (e.getSource().equals(rdbtnDesaparecida)) {
			panelDes.setVisible(true);
			panelCriminal.setVisible(false);
			panelAgente.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		} else if (e.getSource().equals(rdbtnCriminal)) {
			panelCriminal.setVisible(true);
			panelAgente.setVisible(false);
			panelDes.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		}

	}

	private void altaPersona() {
		per = new Persona();
		if (rdbtnAgente.isSelected() && per instanceof Agente) {
			String telefonos[] = { textTelefonoM.getText(), textTelefonoO.getText() };
			int telf[] = new int[telefonos.length];
			for (int i = 0; i < telefonos.length; i++) {
				telf[i] = Integer.parseInt(telefonos[i]);
			}
			per.setDni(textDni.getText());
			per.setNombre(textNombre.getText());
			per.setApellido(textApellido.getText());
			per.setTelefonos(telf);
			per.setLocalidad(textLocalidad.getText());
			per.setFechaNac(stringDate(textNacimiento.getText()));
			per.setFechaFal(stringDate(textFallecimiento.getText()));
			((Agente) per).setRango(stringInt(textFieldRango.getText()));
			((Agente) per).setInicioServ(stringDate(textFieldInServ.getText()));
			((Agente) per).setFinServ(stringDate(textFieldFinServ.getText()));
			datos2.altaPersona(per);
			limpiar();
			habilitarBoton();

		} else if (rdbtnDesaparecida.isSelected() && per instanceof Desaparecida) {

			String telefonos[] = { textTelefonoM.getText(), textTelefonoO.getText() };
			int telf[] = new int[telefonos.length];
			for (int i = 0; i < telefonos.length; i++) {
				telf[i] = Integer.parseInt(telefonos[i]);
			}
			per.setDni(textDni.getText());
			per.setNombre(textNombre.getText());
			per.setApellido(textApellido.getText());
			per.setTelefonos(telf);
			per.setLocalidad(textLocalidad.getText());
			per.setFechaNac(stringDate(textNacimiento.getText()));
			per.setFechaFal(stringDate(textFallecimiento.getText()));
			((Desaparecida) per).setFechaDes(stringDate(textFieldFechDes.getText()));
			((Desaparecida) per).setUltimaUbi(textFieldUltUbi.getText());
			((Desaparecida) per).setGenero(textFieldGenero.getText());
			((Desaparecida) per).setTipoPelo(textFieldTipoPelo.getText());
			((Desaparecida) per).setColorPelo(textFieldColorPelo.getText());
			((Desaparecida) per).setColorOjos(textFieldColorOjos.getText());
			((Desaparecida) per).setAltura(stringInt(textFieldAltura.getText()));
			((Desaparecida) per).setEspecificaciones(textFieldEspecifi.getText());
			datos2.altaPersona(per);
			limpiar();
			habilitarBoton();

		} else if (rdbtnCriminal.isSelected() && per instanceof Criminal) {
			String telefonos[] = { textTelefonoM.getText(), textTelefonoO.getText() };
			String arrDate = textFieldFechArresto.getText();
			ArrayList<LocalDate> arrest = new ArrayList<LocalDate>();
			arrest.add(LocalDate.parse(arrDate));
			int telf[] = new int[telefonos.length];
			for (int i = 0; i < telefonos.length; i++) {
				telf[i] = Integer.parseInt(telefonos[i]);
			}

			per.setDni(textDni.getText());
			per.setNombre(textNombre.getText());
			per.setApellido(textApellido.getText());
			per.setTelefonos(telf);
			per.setLocalidad(textLocalidad.getText());
			per.setFechaNac(stringDate(textNacimiento.getText()));
			per.setFechaFal(stringDate(textFallecimiento.getText()));
			((Criminal) per).setFechasArresto(arrest);
			datos2.altaPersona(per);
			limpiar();
			habilitarBoton();

		}

	}

	private void limpiar() {
		textDni.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textTelefonoM.setText("");
		textTelefonoO.setText("");
		textLocalidad.setText("");
		textNacimiento.setText("");
		textFallecimiento.setText("");
		textFieldRango.setText("");
		textFieldInServ.setText("");
		textFieldFinServ.setText("");
		textFieldFechArresto.setText("");
		textFieldFechDes.setText("");
		textFieldUltUbi.setText("");
		textFieldGenero.setText("");
		textFieldTipoPelo.setText("");
		textFieldColorPelo.setText("");
		textFieldColorOjos.setText("");
		textFieldAltura.setText("");
		textFieldEspecifi.setText("");
		rdbtnAgente.setSelected(false);
		rdbtnDesaparecida.setSelected(false);
		rdbtnCriminal.setSelected(false);
		rdbtnSiPreso.setSelected(false);
		rdbtnNoPreso.setSelected(false);

	}

	private void habilitarBoton() {
		if (textDni.getText().length()==9 && !textNombre.getText().isEmpty()) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}

	}


	private void volver() {
		VInserciones insercion = new VInserciones(vInicio, true, info);
		this.dispose();
		insercion.setVisible(true);
	}


	private LocalDate stringDate(String string) {
		LocalDate nacimiento = LocalDate.parse(string);
		return nacimiento;
	}

	private int stringInt(String string) {
		int altura = Integer.parseInt(string);
		return altura;
	}
	
	private void insertarCaso() {
		VInsCaso caso = new VInsCaso(vInicio, true);
		this.dispose();
		caso.setVisible(true);
		
	}
	
	private void insertarRestoHumano() {
		VInsRH restoHumano = new VInsRH(vInicio, true);
		this.dispose();
		restoHumano.setVisible(true);
		
	}
	
	private void insertarPersona() {
		VInsPersona persona = new VInsPersona(vInicio, true);
		this.dispose();
		persona.setVisible(true);
	}
	
	private void gestionar() {
		VGestion gestion = new VGestion(vInicio, true, info[0]);
		this.dispose();
		gestion.setVisible(true);
	}
	
	private void comparar() {
		VComparacion comparacion = new VComparacion(vInicio, true, info[0]);
		this.dispose();
		comparacion.setVisible(true);
	}

	private void buscar() {
		VBusqueda busqueda = new VBusqueda(vInicio, true, datos, info[0]);
		this.dispose();
		busqueda.setVisible(true);
	}

	@Override
	public void altaPersona(Persona per) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobarDNI(String dni) {
		// TODO Auto-generated method stub
		return datos2.comprobarDNI(dni);
	}
}
