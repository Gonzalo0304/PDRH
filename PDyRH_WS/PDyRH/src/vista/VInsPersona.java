package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.DataFactoryInsertPer;
import controlador.interfaces.ContDatosInsertPer;
import excepciones.Excepciones;
import modelo.clases.Agente;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VInsPersona extends JDialog implements ActionListener, ContDatosInsertPer {
	private static final long serialVersionUID = 1L;
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
	private JTextField textFieldTipoPelo;
	private JTextField textFieldColorPelo;
	private JTextField textFieldColorOjos;
	private JTextField textFieldAltura;
	private JTextField textFieldEspecifi;
	private JPanel panelAgente;
	private JComboBox<Object> comboBox;
	private JPanel panelCriminal;
	private JPanel panelDes;
	private Button btnAnadir;
	private JSeparator separatorMenu;
	private JMenuBar menuBar;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JRadioButton rdbtnAge;
	private JRadioButton rdbtnDes;
	private JRadioButton rdbtnCri;
	private JRadioButton rdbtnSiPreso;
	private JRadioButton rdbtnNoPreso;
	private ButtonGroup tipo = new ButtonGroup();
	private ButtonGroup preso = new ButtonGroup();
	private static Point point = new Point();
	private VIniciarSesion padre;
	private String[] info;
	private JLabel lblCerrar;

	ContDatosInsertPer datos = DataFactoryInsertPer.getDatos();
	private JLabel lblRango;
	private JSeparator separatorRango;
	private JLabel lblIniServ;
	private JSeparator separatorIniServ;
	private JLabel lblFinServ;
	private JSeparator separatorFinServ;
	private JLabel lblPris;
	private JSeparator separatorPris;
	private JLabel lblFechaArr;
	private JSeparator separatorFechaArr;
	private JLabel lblErrorDni;
	private JLabel lblApellido;
	private JLabel lblMovil;
	private JLabel lblLoc;
	private JSeparator separatorLoc;
	private JSeparator separatorFall;
	private JLabel lblFall;
	private JSeparator separatorNac;
	private JLabel lblNac;
	private JSeparator separatorOpc;
	private JLabel lblTelf;
	private JSeparator separatorMovil;
	private JSeparator separatorApe;
	private JSeparator separatorNom;
	private JLabel lblNombre;
	private JSeparator separatorDni;
	private JLabel lblDni;
	private JLabel imgErtzAC;
	private JSeparator separatorFechaDes;
	private JLabel lblSexo;
	private JSeparator separatorSexo;
	private JLabel lblUltUbi;
	private JSeparator separatorUltimaUbi;
	private JLabel lblFechaDes;
	private JLabel lblTP;
	private JSeparator separatorTP;
	private JLabel lblCP;
	private JSeparator separatorCP;
	private JLabel lblCO;
	private JSeparator separatorCO;
	private JLabel lblAlt;
	private JSeparator separatorAlt;
	private JLabel lblEsp;
	private JSeparator separatorEsp;

	public VInsPersona(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Insertar persona");
		setBounds(350, 150, 503, 627);
		contentPanel.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		this.padre = padre;
		info = infos;

		// Movimiento de la ventana
		contentPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		// Botón para cerrar la ventana
		lblCerrar = new JLabel("x");
		lblCerrar.setBounds(470, 2, 31, 19);
		lblCerrar.setBackground(new Color(153, 0, 0));
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setForeground(new Color(0, 51, 102));
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
		contentPanel.add(lblCerrar);

		// Menú superior
		separatorMenu = new JSeparator();
		separatorMenu.setForeground(SystemColor.controlShadow);
		separatorMenu.setBackground(new Color(0, 51, 102));
		separatorMenu.setBounds(0, 36, 502, 2);
		contentPanel.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		mCerrar.addActionListener(this);
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

		// JTextField
		textDni = new JTextField();
		textDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (verificarDNI()) {
					btnAnadir.setEnabled(false);
					lblErrorDni.setVisible(true);
				} else {
					lblErrorDni.setVisible(false);
				}
			}
		});
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textDni.setBounds(30, 110, 192, 20);
		contentPanel.add(textDni);
		textDni.setColumns(10);

		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textNombre.setBounds(30, 171, 192, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(30, 234, 192, 20);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);

		textTelefonoM = new JTextField();
		textTelefonoM.setBounds(30, 298, 192, 20);
		contentPanel.add(textTelefonoM);
		textTelefonoM.setColumns(10);

		textTelefonoO = new JTextField();
		textTelefonoO.setBounds(30, 358, 192, 20);
		contentPanel.add(textTelefonoO);
		textTelefonoO.setColumns(10);

		textLocalidad = new JTextField();
		textLocalidad.setBounds(30, 425, 192, 20);
		contentPanel.add(textLocalidad);
		textLocalidad.setColumns(10);

		textNacimiento = new JTextField();
		textNacimiento.setBounds(30, 494, 192, 20);
		contentPanel.add(textNacimiento);
		textNacimiento.setColumns(10);

		textFallecimiento = new JTextField();
		textFallecimiento.setBounds(30, 562, 192, 20);
		contentPanel.add(textFallecimiento);
		textFallecimiento.setColumns(10);

		// Buttons
		btnAnadir = new Button("A\u00F1adir");
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setBounds(212, 588, 87, 29);
		btnAnadir.addActionListener(this);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnAnadir);

		// RadioButtons
		rdbtnAge = new JRadioButton("Agente");
		rdbtnAge.setForeground(new Color(0, 51, 102));
		rdbtnAge.setBackground(Color.WHITE);
		rdbtnAge.setBounds(74, 44, 87, 23);
		tipo.add(rdbtnAge);
		rdbtnAge.addActionListener(this);
		rdbtnAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(rdbtnAge);

		rdbtnDes = new JRadioButton("Desaparecida");
		rdbtnDes.setForeground(new Color(0, 51, 102));
		rdbtnDes.setBackground(Color.WHITE);
		rdbtnDes.setBounds(191, 44, 126, 23);
		tipo.add(rdbtnDes);
		rdbtnDes.addActionListener(this);
		rdbtnDes.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(rdbtnDes);

		rdbtnCri = new JRadioButton("Criminal");
		rdbtnCri.setForeground(new Color(0, 51, 102));
		rdbtnCri.setBackground(Color.WHITE);
		rdbtnCri.setBounds(330, 44, 109, 23);
		rdbtnCri.addActionListener(this);
		tipo.add(rdbtnCri);
		rdbtnCri.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPanel.add(rdbtnCri);

		panelDes = new JPanel();
		panelDes.setBounds(256, 74, 237, 526);
		contentPanel.add(panelDes);
		panelDes.setLayout(null);
		panelDes.setVisible(false);
		panelDes.setOpaque(false);

		textFieldFechDes = new JTextField();
		textFieldFechDes.setColumns(10);
		textFieldFechDes.setBounds(20, 36, 192, 20);
		panelDes.add(textFieldFechDes);

		textFieldUltUbi = new JTextField();
		textFieldUltUbi.setColumns(10);
		textFieldUltUbi.setBounds(20, 98, 192, 20);
		panelDes.add(textFieldUltUbi);

		textFieldTipoPelo = new JTextField();
		textFieldTipoPelo.setColumns(10);
		textFieldTipoPelo.setBounds(20, 224, 192, 20);
		panelDes.add(textFieldTipoPelo);

		textFieldColorPelo = new JTextField();
		textFieldColorPelo.setColumns(10);
		textFieldColorPelo.setBounds(20, 283, 192, 20);
		panelDes.add(textFieldColorPelo);

		textFieldColorOjos = new JTextField();
		textFieldColorOjos.setColumns(10);
		textFieldColorOjos.setBounds(20, 350, 192, 20);
		panelDes.add(textFieldColorOjos);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(20, 419, 192, 20);
		panelDes.add(textFieldAltura);

		textFieldEspecifi = new JTextField();
		textFieldEspecifi.setColumns(10);
		textFieldEspecifi.setBounds(20, 486, 192, 20);
		panelDes.add(textFieldEspecifi);

		separatorFechaDes = new JSeparator();
		separatorFechaDes.setForeground(SystemColor.controlShadow);
		separatorFechaDes.setBackground(new Color(153, 0, 0));
		separatorFechaDes.setBounds(20, 26, 106, 2);
		panelDes.add(separatorFechaDes);

		lblSexo = new JLabel("SEXO");
		lblSexo.setForeground(new Color(153, 0, 0));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSexo.setBounds(20, 122, 81, 28);
		panelDes.add(lblSexo);

		separatorSexo = new JSeparator();
		separatorSexo.setForeground(SystemColor.controlShadow);
		separatorSexo.setBackground(new Color(153, 0, 0));
		separatorSexo.setBounds(20, 148, 106, 2);
		panelDes.add(separatorSexo);

		lblUltUbi = new JLabel("\u00DALTIMA UBI.");
		lblUltUbi.setForeground(new Color(153, 0, 0));
		lblUltUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUltUbi.setBounds(20, 58, 106, 28);
		panelDes.add(lblUltUbi);

		separatorUltimaUbi = new JSeparator();
		separatorUltimaUbi.setForeground(SystemColor.controlShadow);
		separatorUltimaUbi.setBackground(new Color(153, 0, 0));
		separatorUltimaUbi.setBounds(20, 84, 106, 2);
		panelDes.add(separatorUltimaUbi);

		lblFechaDes = new JLabel("FECHA DES.");
		lblFechaDes.setForeground(new Color(153, 0, 0));
		lblFechaDes.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaDes.setBounds(20, 0, 106, 28);
		panelDes.add(lblFechaDes);

		lblTP = new JLabel("TIPO PELO");
		lblTP.setForeground(new Color(153, 0, 0));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTP.setBounds(20, 184, 106, 28);
		panelDes.add(lblTP);

		separatorTP = new JSeparator();
		separatorTP.setForeground(SystemColor.controlShadow);
		separatorTP.setBackground(new Color(153, 0, 0));
		separatorTP.setBounds(20, 210, 106, 2);
		panelDes.add(separatorTP);

		lblCP = new JLabel("COLOR PELO");
		lblCP.setForeground(new Color(153, 0, 0));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCP.setBounds(20, 244, 106, 28);
		panelDes.add(lblCP);

		separatorCP = new JSeparator();
		separatorCP.setForeground(SystemColor.controlShadow);
		separatorCP.setBackground(new Color(153, 0, 0));
		separatorCP.setBounds(20, 270, 106, 2);
		panelDes.add(separatorCP);

		lblCO = new JLabel("COLOR OJOS");
		lblCO.setForeground(new Color(153, 0, 0));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(20, 312, 106, 28);
		panelDes.add(lblCO);

		separatorCO = new JSeparator();
		separatorCO.setForeground(SystemColor.controlShadow);
		separatorCO.setBackground(new Color(153, 0, 0));
		separatorCO.setBounds(20, 338, 106, 2);
		panelDes.add(separatorCO);

		lblAlt = new JLabel("ALTURA");
		lblAlt.setForeground(new Color(153, 0, 0));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlt.setBounds(20, 381, 106, 28);
		panelDes.add(lblAlt);

		separatorAlt = new JSeparator();
		separatorAlt.setForeground(SystemColor.controlShadow);
		separatorAlt.setBackground(new Color(153, 0, 0));
		separatorAlt.setBounds(20, 407, 106, 2);
		panelDes.add(separatorAlt);

		lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setForeground(new Color(153, 0, 0));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEsp.setBounds(20, 449, 106, 28);
		panelDes.add(lblEsp);

		separatorEsp = new JSeparator();
		separatorEsp.setForeground(SystemColor.controlShadow);
		separatorEsp.setBackground(new Color(153, 0, 0));
		separatorEsp.setBounds(20, 475, 106, 2);
		panelDes.add(separatorEsp);
		
		comboBox = new JComboBox<Object>();
		comboBox.setBounds(20, 161, 180, 22);
		panelDes.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Hombre", "Mujer"}));

		lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(30, 74, 81, 28);
		contentPanel.add(lblDni);

		separatorDni = new JSeparator();
		separatorDni.setForeground(SystemColor.controlShadow);
		separatorDni.setBackground(new Color(0, 51, 102));
		separatorDni.setBounds(30, 100, 106, 2);
		contentPanel.add(separatorDni);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(30, 132, 81, 28);
		contentPanel.add(lblNombre);

		separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(30, 158, 106, 2);
		contentPanel.add(separatorNom);

		lblApellido = new JLabel("APELLIDO");
		lblApellido.setForeground(new Color(0, 51, 102));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellido.setBounds(30, 200, 81, 28);
		contentPanel.add(lblApellido);

		separatorApe = new JSeparator();
		separatorApe.setForeground(SystemColor.controlShadow);
		separatorApe.setBackground(new Color(0, 51, 102));
		separatorApe.setBounds(30, 226, 106, 2);
		contentPanel.add(separatorApe);

		lblMovil = new JLabel("TEL\u00C9FONO M\u00D3VIL");
		lblMovil.setForeground(new Color(0, 51, 102));
		lblMovil.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMovil.setBounds(30, 259, 106, 28);
		contentPanel.add(lblMovil);

		separatorMovil = new JSeparator();
		separatorMovil.setForeground(SystemColor.controlShadow);
		separatorMovil.setBackground(new Color(0, 51, 102));
		separatorMovil.setBounds(30, 285, 106, 2);
		contentPanel.add(separatorMovil);

		lblTelf = new JLabel("TEL\u00C9FONO OPC.");
		lblTelf.setForeground(new Color(0, 51, 102));
		lblTelf.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelf.setBounds(30, 319, 106, 28);
		contentPanel.add(lblTelf);

		separatorOpc = new JSeparator();
		separatorOpc.setForeground(SystemColor.controlShadow);
		separatorOpc.setBackground(new Color(0, 51, 102));
		separatorOpc.setBounds(30, 344, 106, 2);
		contentPanel.add(separatorOpc);

		lblNac = new JLabel("NACIMIENTO");
		lblNac.setForeground(new Color(0, 51, 102));
		lblNac.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNac.setBounds(30, 455, 81, 28);
		contentPanel.add(lblNac);

		separatorNac = new JSeparator();
		separatorNac.setForeground(SystemColor.controlShadow);
		separatorNac.setBackground(new Color(0, 51, 102));
		separatorNac.setBounds(30, 481, 106, 2);
		contentPanel.add(separatorNac);

		lblFall = new JLabel("FALLECIMIENTO");
		lblFall.setForeground(new Color(0, 51, 102));
		lblFall.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFall.setBounds(30, 523, 106, 28);
		contentPanel.add(lblFall);

		separatorFall = new JSeparator();
		separatorFall.setForeground(SystemColor.controlShadow);
		separatorFall.setBackground(new Color(0, 51, 102));
		separatorFall.setBounds(30, 549, 106, 2);
		contentPanel.add(separatorFall);

		separatorLoc = new JSeparator();
		separatorLoc.setForeground(SystemColor.controlShadow);
		separatorLoc.setBackground(new Color(0, 51, 102));
		separatorLoc.setBounds(30, 412, 106, 2);
		contentPanel.add(separatorLoc);

		lblLoc = new JLabel("LOCALIDAD");
		lblLoc.setForeground(new Color(0, 51, 102));
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLoc.setBounds(30, 386, 106, 28);
		contentPanel.add(lblLoc);

		panelAgente = new JPanel();
		panelAgente.setBounds(256, 71, 237, 400);
		contentPanel.add(panelAgente);
		panelAgente.setLayout(null);
		panelAgente.setVisible(false);
		panelAgente.setOpaque(false);

		textFieldRango = new JTextField();
		textFieldRango.setBounds(20, 39, 192, 20);
		panelAgente.add(textFieldRango);
		textFieldRango.setColumns(10);

		textFieldInServ = new JTextField();
		textFieldInServ.setBounds(20, 100, 192, 20);
		panelAgente.add(textFieldInServ);
		textFieldInServ.setColumns(10);

		textFieldFinServ = new JTextField();
		textFieldFinServ.setBounds(20, 160, 192, 20);
		panelAgente.add(textFieldFinServ);
		textFieldFinServ.setColumns(10);

		lblRango = new JLabel("RANGO");
		lblRango.setForeground(new Color(153, 0, 0));
		lblRango.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRango.setBounds(20, 0, 81, 28);
		panelAgente.add(lblRango);

		separatorRango = new JSeparator();
		separatorRango.setForeground(SystemColor.controlShadow);
		separatorRango.setBackground(new Color(153, 0, 0));
		separatorRango.setBounds(20, 26, 106, 2);
		panelAgente.add(separatorRango);

		lblIniServ = new JLabel("INICIO SERVICIO");
		lblIniServ.setForeground(new Color(153, 0, 0));
		lblIniServ.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblIniServ.setBounds(20, 63, 106, 28);
		panelAgente.add(lblIniServ);

		separatorIniServ = new JSeparator();
		separatorIniServ.setForeground(SystemColor.controlShadow);
		separatorIniServ.setBackground(new Color(153, 0, 0));
		separatorIniServ.setBounds(20, 89, 106, 2);
		panelAgente.add(separatorIniServ);

		lblFinServ = new JLabel("FIN SERVICIO");
		lblFinServ.setForeground(new Color(153, 0, 0));
		lblFinServ.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFinServ.setBounds(20, 126, 81, 28);
		panelAgente.add(lblFinServ);

		separatorFinServ = new JSeparator();
		separatorFinServ.setForeground(SystemColor.controlShadow);
		separatorFinServ.setBackground(new Color(153, 0, 0));
		separatorFinServ.setBounds(20, 152, 106, 2);
		panelAgente.add(separatorFinServ);

		panelCriminal = new JPanel();
		panelCriminal.setBounds(256, 74, 237, 316);
		contentPanel.add(panelCriminal);
		panelCriminal.setLayout(null);
		panelCriminal.setVisible(false);
		panelCriminal.setOpaque(false);

		textFieldFechArresto = new JTextField();
		textFieldFechArresto.setColumns(10);
		textFieldFechArresto.setBounds(18, 97, 192, 20);
		panelCriminal.add(textFieldFechArresto);

		rdbtnSiPreso = new JRadioButton("S\u00ED");
		rdbtnSiPreso.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSiPreso.setBounds(18, 36, 40, 23);
		rdbtnSiPreso.setOpaque(false);
		preso.add(rdbtnSiPreso);
		panelCriminal.add(rdbtnSiPreso);

		rdbtnNoPreso = new JRadioButton("No");
		rdbtnNoPreso.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNoPreso.setBounds(83, 36, 46, 23);
		rdbtnNoPreso.setOpaque(false);
		preso.add(rdbtnNoPreso);
		panelCriminal.add(rdbtnNoPreso);

		lblPris = new JLabel("PRISIONERO");
		lblPris.setForeground(new Color(153, 0, 0));
		lblPris.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPris.setBounds(21, 0, 81, 28);
		panelCriminal.add(lblPris);

		separatorPris = new JSeparator();
		separatorPris.setForeground(SystemColor.controlShadow);
		separatorPris.setBackground(new Color(153, 0, 0));
		separatorPris.setBounds(21, 26, 106, 2);
		panelCriminal.add(separatorPris);

		lblFechaArr = new JLabel("FECHA ARRESTO");
		lblFechaArr.setForeground(new Color(153, 0, 0));
		lblFechaArr.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaArr.setBounds(18, 58, 106, 28);
		panelCriminal.add(lblFechaArr);

		separatorFechaArr = new JSeparator();
		separatorFechaArr.setForeground(SystemColor.controlShadow);
		separatorFechaArr.setBackground(new Color(153, 0, 0));
		separatorFechaArr.setBounds(21, 84, 106, 2);
		panelCriminal.add(separatorFechaArr);
		
		lblErrorDni = new JLabel("DNI INV\u00C1LIDO");
		lblErrorDni.setForeground(new Color(153, 0, 0));
		lblErrorDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorDni.setBounds(138, 132, 81, 14);
		lblErrorDni.setVisible(false);
		contentPanel.add(lblErrorDni);
		
		imgErtzAC = new JLabel("");
		imgErtzAC.setIcon(new ImageIcon(VInsPersona.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(93, 174, 309, 317);
		contentPanel.add(imgErtzAC);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAnadir)) {
			if (comprobarDNI(textDni.getText())) {
				JOptionPane.showMessageDialog(this, "El DNI introducido ya ha sido introducido.", "DNI existente.",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if ((!textTelefonoM.getText().isBlank() && textTelefonoM.getText().length() != 9) || (!textTelefonoO.getText().isBlank() && textTelefonoO.getText().length() != 9)) {
						JOptionPane.showMessageDialog(this,"El teléfono debe tener 9 dígitos.","Telf. incorrecto",JOptionPane.ERROR_MESSAGE);
					} else {
						Persona per = null;
						altaPersona(per);
						JOptionPane.showMessageDialog(this, "Persona registrada correctamente.","Inserción éxitosa",JOptionPane.CLOSED_OPTION);
					}
				} catch (DateTimeParseException e1) {
					JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto(yyyy-mm-dd).", "Formato incorrecto",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Los números deben ser dígitos sin espacios.","Formato erroneo",JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource().equals(rdbtnAge)) {
			panelAgente.setVisible(true);
			panelCriminal.setVisible(false);
			panelDes.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		} else if (e.getSource().equals(rdbtnDes)) {
			panelDes.setVisible(true);
			panelCriminal.setVisible(false);
			panelAgente.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		} else if (e.getSource().equals(rdbtnCri)) {
			panelCriminal.setVisible(true);
			panelAgente.setVisible(false);
			panelDes.setVisible(false);
			rdbtnSiPreso.setSelected(false);
			rdbtnNoPreso.setSelected(false);
		} else if (e.getSource().equals(mCerrar)) {
			if (JOptionPane.showConfirmDialog(this,
					"¿Seguro que desea cerrar sesión?",
					"Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				this.dispose();
				padre.setVisible(true);
			}
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
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
		comboBox.setSelectedIndex(-1);
		textFieldTipoPelo.setText("");
		textFieldColorPelo.setText("");
		textFieldColorOjos.setText("");
		textFieldAltura.setText("");
		textFieldEspecifi.setText("");
		rdbtnAge.setSelected(false);
		rdbtnDes.setSelected(false);
		rdbtnCri.setSelected(false);
		rdbtnSiPreso.setSelected(false);
		rdbtnNoPreso.setSelected(false);

	}

	private void habilitarBoton() {
		if (!verificarDNI() && !textNombre.getText().isEmpty()) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}

	}

	private void cerrar() {
		VInserciones insercion = new VInserciones(padre, true, info);
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

	// Abrir ventanas de menú
	private void abrirGes() {
		VGestion vBus = new VGestion(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info,false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}
	
	private boolean verificarDNI() {
		char[] letraC = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'}; 
		String nifnie = textDni.getText();
		String soloNum = "";
		char letra = 0;
		int modulo;
		if ((nifnie.length() == 9 && Character.isLetter(nifnie.charAt(8))) || (nifnie.length() == 10 && nifnie.charAt(8) == '-' && Character.isLetter(nifnie.charAt(9)))) {
			soloNum	= nifnie.substring(0,8);
			for (int i = 0; i < soloNum.length(); i++) {
				if (Character.isLetter(soloNum.charAt(i))) {
					return true;
				}
			}
			if (nifnie.length() == 9) { 
				letra = Character.toUpperCase(nifnie.charAt(8));
			} else {
				letra = Character.toUpperCase(nifnie.charAt(9));
			} 
		} else if ((nifnie.length() == 10 && Character.isLetter(nifnie.charAt(0)) && Character.isLetter(nifnie.charAt(9)))|| (nifnie.length() == 11 && nifnie.charAt(9) == '-'  && Character.isLetter(nifnie.charAt(0)) && Character.isLetter(nifnie.charAt(10)))) {
			soloNum = nifnie.substring(1,9);
			for (int i = 0; i < soloNum.length(); i++) {
				if (Character.isLetter(soloNum.charAt(i))) { 
					return true;
				}
			}
			if (nifnie.length() == 10) {
				letra = Character.toUpperCase(nifnie.charAt(9));
			}else {
				letra = Character.toUpperCase(nifnie.charAt(10));
			}
			switch (Character.toUpperCase(nifnie.charAt(0))) {
			case 'X':
				nifnie = nifnie.replace("X","0");
				nifnie = nifnie.replace("x","0");
				break;
			case 'Y':
				nifnie = nifnie.replace("Y","1");
				nifnie = nifnie.replace("y","1");
				break;
			case 'Z':
				nifnie = nifnie.replace("Z","2");
				nifnie = nifnie.replace("z","2");
				break;
			default:
				return true;
			}
			soloNum = nifnie.substring(0,9);
		} else {
			return true;
		}
		modulo = Integer.parseInt(soloNum)%23;
		if (letraC[modulo] != letra) {
			return true;
		}
		return false;
	}

	@Override
	public void altaPersona(Persona per) {
		int telefonoM = 0;
		int telefonoO = 0;
		LocalDate fechaNac = null;
		LocalDate fechaFall = null;
		if (rdbtnAge.isSelected()) {
			per = new Agente();
			LocalDate fechaIni = null;
			LocalDate fechaFin = null;

			if (!textFieldInServ.getText().isBlank()) {
				fechaIni = LocalDate.parse(textFieldInServ.getText());
			}

			if (!textFieldFinServ.getText().isBlank()) {
				fechaFin = LocalDate.parse(textFieldFinServ.getText());
			}

			((Agente) per).setRango(stringInt(textFieldRango.getText()));
			((Agente) per).setInicioServ(fechaIni);
			((Agente) per).setFinServ(fechaFin);
		} else if (rdbtnDes.isSelected()) {
			per = new Desaparecida();
			int altura = 0;
			LocalDate fechaDes = null;

			if (!textFieldFechDes.getText().isEmpty()) {
				fechaDes = LocalDate.parse(textFieldFechDes.getText());
			}

			if (!textFieldAltura.getText().isEmpty()) {
				altura = stringInt(textFieldAltura.getText());
			}

			((Desaparecida) per).setFechaDes(fechaDes);
			((Desaparecida) per).setUltimaUbi(textFieldUltUbi.getText());
			if (comboBox.getSelectedItem() == "Hombre") {
				((Desaparecida) per).setGenero("H");
			}else if (comboBox.getSelectedItem() == "Mujer") {
				((Desaparecida) per).setGenero("M");
			}
			((Desaparecida) per).setTipoPelo(textFieldTipoPelo.getText());
			((Desaparecida) per).setColorPelo(textFieldColorPelo.getText());
			((Desaparecida) per).setColorOjos(textFieldColorOjos.getText());
			((Desaparecida) per).setAltura(altura);
			((Desaparecida) per).setEspecificaciones(textFieldEspecifi.getText());
		} else if (rdbtnCri.isSelected()) {
			per = new Criminal();
			LocalDate arrDate = null;

			if (rdbtnSiPreso.isSelected()) {
				((Criminal) per).setPrisionero(true);
			} else {
				((Criminal) per).setPrisionero(false);
			}
			ArrayList<LocalDate> arrest = new ArrayList<LocalDate>();
			if (!textFieldFechArresto.getText().isBlank()) {
				arrDate = LocalDate.parse(textFieldFechArresto.getText());
			}
			arrest.add(arrDate);
			((Criminal) per).setFechasArresto(arrest);
		} else {
			per = new Persona();
		}

		if (!textNacimiento.getText().isEmpty()) {
			fechaNac = stringDate(textNacimiento.getText());
		}
		if (!textFallecimiento.getText().isEmpty()) {
			fechaFall = stringDate(textFallecimiento.getText());
		}

		if (!textTelefonoM.getText().isEmpty()) {
			telefonoM = stringInt(textTelefonoM.getText());
		}
		if (!textTelefonoO.getText().isEmpty()) {
			telefonoO = stringInt(textTelefonoO.getText());
		}

		int[] telf = { telefonoM, telefonoO };
		per.setDni(textDni.getText());
		per.setNombre(textNombre.getText());
		per.setApellido(textApellido.getText());
		per.setTelefonos(telf);
		per.setLocalidad(textLocalidad.getText());
		per.setFechaNac(fechaNac);
		per.setFechaFal(fechaFall);
		try {
			datos.altaPersona(per);
			limpiar();
			habilitarBoton();
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Carácteres excedidos", JOptionPane.ERROR_MESSAGE);
		} 
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}
}
