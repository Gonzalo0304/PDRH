package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import controlador.DataFactoryBusqPer;
import controlador.interfaces.ContDatosBusqPer;
import modelo.clases.Persona;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JList;

/**
 * Esta clase representa la ventana de busqueda de persona junto con el controlador de busqueda
 * @autor Elías
 *
 */
public class VBusPer extends JDialog implements ContDatosBusqPer, ActionListener {
	private static final long serialVersionUID = 1L;

	// <--- Datos BD --->
	ContDatosBusqPer datos = DataFactoryBusqPer.getDatos();

	// <--- Elementos --->
	private static Point point = new Point();
	private JTabbedPane tabbedPane;
	private JPanel contentDatos;
	private JLabel lblCerrar;
	private JSeparator separatorMenu;
	private JMenuBar menuBar;
	private JMenuBar menuBar_1;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JLabel lblDni;
	private JSeparator separatorDni;
	private JTextField textDni;
	private JLabel lblNombre;
	private JSeparator separatorNom;
	private JTextField textNombre;
	private JLabel lblApellido;
	private JSeparator separatorApe;
	private JTextField textApellido;
	private JLabel lblMovil;
	private JSeparator separatorMovil;
	private JTextField textMovil;
	private JLabel lblTelf;
	private JSeparator separatorOpc;
	private JTextField textTelf;
	private JLabel lblNac;
	private JSeparator separatorNac;
	private JTextField textNac;
	private JLabel lblFall;
	private JSeparator separatorFall;
	private JTextField textFall;
	private JLabel lblRango;
	private JSeparator separatorRango;
	private JTextField textRango;
	private JLabel lblIniServ;
	private JSeparator separatorIniServ;
	private JTextField textIniServ;
	private JLabel lblFinServ;
	private JSeparator separatorFinServ;
	private JTextField textFinServ;
	private JLabel lblPris;
	private JSeparator separatorPris;
	private JLabel lblFechaDes;
	private JSeparator separatorFechaDes;
	private JTextField textFechaDes;
	private JLabel lblSexo;
	private JSeparator separatorSexo;
	private JTextField textSexo;
	private JLabel lblTP;
	private JSeparator separatorTP;
	private JTextField textTP;
	private JLabel lblLoc;
	private JSeparator separatorLoc;
	private JLabel lblUltUbi;
	private JSeparator separatorUltimaUbi;
	private JTextField textUltUbi;
	private JLabel imgErtzAO;
	private JPanel contentConos;
	private JLabel lblCerrar_1;
	private JSeparator separatorMenu2;
	private JLabel lblRel;
	private JSeparator separatorRel;
	private JTextField textRel;
	private JLabel lblFechaArr;
	private JSeparator separatorFechaArr;
	private JTextField textCP;
	private JTextField textCO;
	private JTextField textAlt;
	private JTextField textEsp;
	private JLabel lblLisCono;
	private JSeparator separatorLisCono;
	private String[] info;
	private Persona per;
	private JLabel lblCP;
	private JSeparator separatorCP;
	private JLabel lblCO;
	private JSeparator separatorCO;
	private JLabel lblAlt;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JSeparator separatorAlt;
	private JLabel lblEsp;
	private JSeparator separatorEsp;
	private ButtonGroup bgPris;
	private VIniciarSesion padre;
	private JPanel panelDes;
	private JTextField textLoc;
	private JLabel lblNomComp;
	private JList<String> list;
	private JPanel panelAgente;
	private JPanel panelCriminal;
	private JLabel lblBusPer;
	private JSeparator separatorBus;
	private Map<String,Conocido> conocidos;
	private int posicion = 0;
	private JLabel imgErtzAO_1;
	
	/**
	 * <h2>Constructor de la ventana
	 * @param padre: Es la ventana de inicio de sesion siendo la principal
	 * @param modal: Sirve para impedir la navegacion de la ventana anterior
	 * @param dni: Es el DNI de la persona que obtiene de la ventana de busqueda.
	 * @param infos: Este parametro recibe los datos del usuario que ha iniciado sesion
	 */
	public VBusPer(VIniciarSesion padre, boolean modal, String dni, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Buscar persona");
		setBounds(350, 150, 506, 690);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.padre = padre;

		// <--- Pestaña 1 --->
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlHighlight);
		tabbedPane.setBounds(0, 0, 506, 690);
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
		contentDatos.add(lblCerrar);

		// Menú superior
		separatorMenu = new JSeparator();
		separatorMenu.setForeground(SystemColor.controlShadow);
		separatorMenu.setBackground(new Color(0, 51, 102));
		separatorMenu.setBounds(0, 36, 502, 2);
		contentDatos.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentDatos.add(menuBar);

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

		lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(26, 77, 81, 28);
		contentDatos.add(lblDni);

		// Campos de información de persona
		separatorDni = new JSeparator();
		separatorDni.setForeground(SystemColor.controlShadow);
		separatorDni.setBackground(new Color(0, 51, 102));
		separatorDni.setBounds(26, 103, 106, 2);
		contentDatos.add(separatorDni);

		textDni = new JTextField();
		textDni.setEnabled(false);
		textDni.setColumns(10);
		textDni.setBounds(26, 116, 187, 20);
		contentDatos.add(textDni);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(26, 135, 81, 28);
		contentDatos.add(lblNombre);

		separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(26, 161, 106, 2);
		contentDatos.add(separatorNom);

		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		textNombre.setBounds(26, 174, 187, 20);
		contentDatos.add(textNombre);

		lblApellido = new JLabel("APELLIDO");
		lblApellido.setForeground(new Color(0, 51, 102));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblApellido.setBounds(26, 203, 81, 28);
		contentDatos.add(lblApellido);

		separatorApe = new JSeparator();
		separatorApe.setForeground(SystemColor.controlShadow);
		separatorApe.setBackground(new Color(0, 51, 102));
		separatorApe.setBounds(26, 229, 106, 2);
		contentDatos.add(separatorApe);

		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setColumns(10);
		textApellido.setBounds(26, 242, 187, 20);
		contentDatos.add(textApellido);

		lblMovil = new JLabel("TEL\u00C9FONO M\u00D3VIL");
		lblMovil.setForeground(new Color(0, 51, 102));
		lblMovil.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMovil.setBounds(26, 261, 106, 28);
		contentDatos.add(lblMovil);

		separatorMovil = new JSeparator();
		separatorMovil.setForeground(SystemColor.controlShadow);
		separatorMovil.setBackground(new Color(0, 51, 102));
		separatorMovil.setBounds(26, 287, 106, 2);
		contentDatos.add(separatorMovil);

		textMovil = new JTextField();
		textMovil.setEnabled(false);
		textMovil.setColumns(10);
		textMovil.setBounds(26, 300, 187, 20);
		contentDatos.add(textMovil);

		lblTelf = new JLabel("TEL\u00C9FONO OPC.");
		lblTelf.setForeground(new Color(0, 51, 102));
		lblTelf.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelf.setBounds(26, 331, 106, 28);
		contentDatos.add(lblTelf);

		separatorOpc = new JSeparator();
		separatorOpc.setForeground(SystemColor.controlShadow);
		separatorOpc.setBackground(new Color(0, 51, 102));
		separatorOpc.setBounds(26, 357, 106, 2);
		contentDatos.add(separatorOpc);

		textTelf = new JTextField();
		textTelf.setEnabled(false);
		textTelf.setColumns(10);
		textTelf.setBounds(26, 370, 187, 20);
		contentDatos.add(textTelf);

		lblNac = new JLabel("NACIMIENTO");
		lblNac.setForeground(new Color(0, 51, 102));
		lblNac.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNac.setBounds(26, 458, 81, 28);
		contentDatos.add(lblNac);

		separatorNac = new JSeparator();
		separatorNac.setForeground(SystemColor.controlShadow);
		separatorNac.setBackground(new Color(0, 51, 102));
		separatorNac.setBounds(26, 484, 106, 2);
		contentDatos.add(separatorNac);

		textNac = new JTextField();
		textNac.setEnabled(false);
		textNac.setColumns(10);
		textNac.setBounds(26, 497, 187, 20);
		contentDatos.add(textNac);

		lblFall = new JLabel("FALLECIMIENTO");
		lblFall.setForeground(new Color(0, 51, 102));
		lblFall.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFall.setBounds(26, 526, 106, 28);
		contentDatos.add(lblFall);

		separatorFall = new JSeparator();
		separatorFall.setForeground(SystemColor.controlShadow);
		separatorFall.setBackground(new Color(0, 51, 102));
		separatorFall.setBounds(26, 552, 106, 2);
		contentDatos.add(separatorFall);

		textFall = new JTextField();
		textFall.setEnabled(false);
		textFall.setColumns(10);
		textFall.setBounds(26, 565, 187, 20);
		contentDatos.add(textFall);

		bgPris = new ButtonGroup();

		separatorLoc = new JSeparator();
		separatorLoc.setForeground(SystemColor.controlShadow);
		separatorLoc.setBackground(new Color(0, 51, 102));
		separatorLoc.setBounds(26, 415, 106, 2);
		contentDatos.add(separatorLoc);

		lblLoc = new JLabel("LOCALIDAD");
		lblLoc.setForeground(new Color(0, 51, 102));
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLoc.setBounds(26, 389, 106, 28);
		contentDatos.add(lblLoc);

		textLoc = new JTextField();
		textLoc.setEnabled(false);
		textLoc.setText((String) null);
		textLoc.setColumns(10);
		textLoc.setBounds(26, 428, 187, 19);
		contentDatos.add(textLoc);

		// Campos de información de criminal
		panelCriminal = new JPanel();
		panelCriminal.setBounds(248, 74, 218, 531);
		contentDatos.add(panelCriminal);
		panelCriminal.setLayout(null);
		panelCriminal.setOpaque(false);
		panelCriminal.setVisible(false);
		
		lblPris = new JLabel("PRISIONERO");
		lblPris.setBounds(23, 0, 81, 28);
		panelCriminal.add(lblPris);
		lblPris.setForeground(new Color(153, 0, 0));
		lblPris.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorPris = new JSeparator();
		separatorPris.setBounds(23, 26, 106, 2);
		panelCriminal.add(separatorPris);
		separatorPris.setForeground(SystemColor.controlShadow);
		separatorPris.setBackground(new Color(153, 0, 0));

		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setEnabled(false);
		rdbtnSi.setBounds(20, 41, 43, 23);
		panelCriminal.add(rdbtnSi);
		rdbtnSi.setOpaque(false);
		rdbtnSi.setFont(new Font("Tahoma", Font.BOLD, 11));
		bgPris.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setEnabled(false);
		rdbtnNo.setBounds(94, 41, 43, 23);
		panelCriminal.add(rdbtnNo);
		rdbtnNo.setOpaque(false);
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		bgPris.add(rdbtnNo);

		lblFechaArr = new JLabel("FECHA ARRESTO");
		lblFechaArr.setBounds(20, 55, 106, 28);
		panelCriminal.add(lblFechaArr);
		lblFechaArr.setForeground(new Color(153, 0, 0));
		lblFechaArr.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorFechaArr = new JSeparator();
		separatorFechaArr.setBounds(23, 81, 106, 2);
		panelCriminal.add(separatorFechaArr);
		separatorFechaArr.setForeground(SystemColor.controlShadow);
		separatorFechaArr.setBackground(new Color(153, 0, 0));
		
		// Campos de información de desaparecida
		panelDes = new JPanel();
		panelDes.setBounds(248, 76, 218, 529);
		contentDatos.add(panelDes);
		panelDes.setLayout(null);
		panelDes.setOpaque(false);
		panelDes.setVisible(false);

		textFechaDes = new JTextField();
		textFechaDes.setEnabled(false);
		textFechaDes.setBounds(21, 39, 187, 20);
		panelDes.add(textFechaDes);
		textFechaDes.setColumns(10);

		textTP = new JTextField();
		textTP.setEnabled(false);
		textTP.setBounds(21, 223, 187, 20);
		panelDes.add(textTP);
		textTP.setColumns(10);

		textUltUbi = new JTextField();
		textUltUbi.setEnabled(false);
		textUltUbi.setBounds(21, 97, 187, 20);
		panelDes.add(textUltUbi);
		textUltUbi.setColumns(10);

		separatorFechaDes = new JSeparator();
		separatorFechaDes.setBounds(21, 26, 106, 2);
		panelDes.add(separatorFechaDes);
		separatorFechaDes.setForeground(SystemColor.controlShadow);
		separatorFechaDes.setBackground(new Color(153, 0, 0));

		lblSexo = new JLabel("SEXO");
		lblSexo.setBounds(21, 130, 81, 28);
		panelDes.add(lblSexo);
		lblSexo.setForeground(new Color(153, 0, 0));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorSexo = new JSeparator();
		separatorSexo.setBounds(21, 156, 106, 2);
		panelDes.add(separatorSexo);
		separatorSexo.setForeground(SystemColor.controlShadow);
		separatorSexo.setBackground(new Color(153, 0, 0));

		lblUltUbi = new JLabel("\u00DALTIMA UBI.");
		lblUltUbi.setBounds(21, 58, 106, 28);
		panelDes.add(lblUltUbi);
		lblUltUbi.setForeground(new Color(153, 0, 0));
		lblUltUbi.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorUltimaUbi = new JSeparator();
		separatorUltimaUbi.setBounds(21, 84, 106, 2);
		panelDes.add(separatorUltimaUbi);
		separatorUltimaUbi.setForeground(SystemColor.controlShadow);
		separatorUltimaUbi.setBackground(new Color(153, 0, 0));

		lblFechaDes = new JLabel("FECHA DES.");
		lblFechaDes.setBounds(21, 0, 106, 28);
		panelDes.add(lblFechaDes);
		lblFechaDes.setForeground(new Color(153, 0, 0));
		lblFechaDes.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblTP = new JLabel("TIPO PELO");
		lblTP.setBounds(21, 184, 106, 28);
		panelDes.add(lblTP);
		lblTP.setForeground(new Color(153, 0, 0));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorTP = new JSeparator();
		separatorTP.setBounds(21, 210, 106, 2);
		panelDes.add(separatorTP);
		separatorTP.setForeground(SystemColor.controlShadow);
		separatorTP.setBackground(new Color(153, 0, 0));

		textSexo = new JTextField();
		textSexo.setEnabled(false);
		textSexo.setBounds(21, 165, 187, 20);
		panelDes.add(textSexo);
		textSexo.setColumns(10);

		textCP = new JTextField();
		textCP.setEnabled(false);
		textCP.setBounds(21, 293, 187, 20);
		panelDes.add(textCP);
		textCP.setColumns(10);

		lblCP = new JLabel("COLOR PELO");
		lblCP.setBounds(21, 254, 106, 28);
		panelDes.add(lblCP);
		lblCP.setForeground(new Color(153, 0, 0));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorCP = new JSeparator();
		separatorCP.setBounds(21, 280, 106, 2);
		panelDes.add(separatorCP);
		separatorCP.setForeground(SystemColor.controlShadow);
		separatorCP.setBackground(new Color(153, 0, 0));

		textCO = new JTextField();
		textCO.setEnabled(false);
		textCO.setBounds(21, 351, 187, 20);
		panelDes.add(textCO);
		textCO.setColumns(10);

		lblCO = new JLabel("COLOR OJOS");
		lblCO.setBounds(21, 312, 106, 28);
		panelDes.add(lblCO);
		lblCO.setForeground(new Color(153, 0, 0));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorCO = new JSeparator();
		separatorCO.setBounds(21, 338, 106, 2);
		panelDes.add(separatorCO);
		separatorCO.setForeground(SystemColor.controlShadow);
		separatorCO.setBackground(new Color(153, 0, 0));

		textAlt = new JTextField();
		textAlt.setEnabled(false);
		textAlt.setBounds(21, 420, 187, 20);
		panelDes.add(textAlt);
		textAlt.setColumns(10);

		lblAlt = new JLabel("ALTURA");
		lblAlt.setBounds(21, 381, 106, 28);
		panelDes.add(lblAlt);
		lblAlt.setForeground(new Color(153, 0, 0));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorAlt = new JSeparator();
		separatorAlt.setBounds(21, 407, 106, 2);
		panelDes.add(separatorAlt);
		separatorAlt.setForeground(SystemColor.controlShadow);
		separatorAlt.setBackground(new Color(153, 0, 0));

		textEsp = new JTextField();
		textEsp.setEnabled(false);
		textEsp.setBounds(21, 488, 187, 20);
		panelDes.add(textEsp);
		textEsp.setColumns(10);

		lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setBounds(21, 449, 106, 28);
		panelDes.add(lblEsp);
		lblEsp.setForeground(new Color(153, 0, 0));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorEsp = new JSeparator();
		separatorEsp.setBounds(21, 475, 106, 2);
		panelDes.add(separatorEsp);
		separatorEsp.setForeground(SystemColor.controlShadow);
		separatorEsp.setBackground(new Color(153, 0, 0));

		// Campos de información de agente
		panelAgente = new JPanel();
		panelAgente.setBounds(248, 74, 218, 207);
		contentDatos.add(panelAgente);
		panelAgente.setLayout(null);
		panelAgente.setOpaque(false);
		panelAgente.setVisible(false);
		
		lblRango = new JLabel("RANGO");
		lblRango.setBounds(21, 0, 81, 28);
		panelAgente.add(lblRango);
		lblRango.setForeground(new Color(153, 0, 0));
		lblRango.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorRango = new JSeparator();
		separatorRango.setBounds(21, 26, 106, 2);
		panelAgente.add(separatorRango);
		separatorRango.setForeground(SystemColor.controlShadow);
		separatorRango.setBackground(new Color(153, 0, 0));

		textRango = new JTextField();
		textRango.setEnabled(false);
		textRango.setBounds(21, 42, 187, 20);
		panelAgente.add(textRango);
		textRango.setColumns(10);

		lblIniServ = new JLabel("INICIO SERVICIO");
		lblIniServ.setBounds(21, 58, 106, 28);
		panelAgente.add(lblIniServ);
		lblIniServ.setForeground(new Color(153, 0, 0));
		lblIniServ.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorIniServ = new JSeparator();
		separatorIniServ.setBounds(21, 84, 106, 2);
		panelAgente.add(separatorIniServ);
		separatorIniServ.setForeground(SystemColor.controlShadow);
		separatorIniServ.setBackground(new Color(153, 0, 0));

		textIniServ = new JTextField();
		textIniServ.setEnabled(false);
		textIniServ.setBounds(21, 100, 187, 20);
		panelAgente.add(textIniServ);
		textIniServ.setColumns(10);

		lblFinServ = new JLabel("FIN SERVICIO");
		lblFinServ.setBounds(21, 126, 81, 28);
		panelAgente.add(lblFinServ);
		lblFinServ.setForeground(new Color(153, 0, 0));
		lblFinServ.setFont(new Font("Tahoma", Font.BOLD, 10));

		separatorFinServ = new JSeparator();
		separatorFinServ.setBounds(21, 152, 106, 2);
		panelAgente.add(separatorFinServ);
		separatorFinServ.setForeground(SystemColor.controlShadow);
		separatorFinServ.setBackground(new Color(153, 0, 0));

		textFinServ = new JTextField();
		textFinServ.setEnabled(false);
		textFinServ.setBounds(21, 168, 187, 20);
		panelAgente.add(textFinServ);
		textFinServ.setColumns(10);

		// Fondo
		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon(VGesPersona.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO.setBounds(90, 200, 309, 317);
		contentDatos.add(imgErtzAO);

		separatorBus = new JSeparator();
		separatorBus.setForeground(new Color(102, 0, 0));
		separatorBus.setBackground(new Color(153, 0, 0));
		separatorBus.setBounds(10, 64, 478, 2);
		contentDatos.add(separatorBus);
		
		lblBusPer = new JLabel("B\u00FAsqueda de Persona");
		lblBusPer.setForeground(SystemColor.textInactiveText);
		lblBusPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblBusPer.setBounds(10, 42, 160, 19);
		contentDatos.add(lblBusPer);

		cargarDatos(dni);

		// <--- Pestaña 2 --->
		contentConos = new JPanel();
		contentConos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentConos.setBackground(Color.WHITE);
		tabbedPane.addTab("Conocidos", null, contentConos, null);

		// Movimiento de la ventana
		contentConos.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		contentConos.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});

		// Botón para cerrar la ventana
		lblCerrar_1 = new JLabel("x");
		lblCerrar_1.setBounds(470, 2, 31, 19);
		lblCerrar_1.setBackground(new Color(153, 0, 0));
		lblCerrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar_1.setForeground(new Color(0, 51, 102));
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
		contentConos.setLayout(null);
		lblCerrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar_1.setForeground(Color.WHITE);
		contentConos.add(lblCerrar_1);

		// Menú superior
		separatorMenu2 = new JSeparator();
		separatorMenu2.setBounds(0, 36, 502, 2);
		separatorMenu2.setForeground(SystemColor.controlShadow);
		separatorMenu2.setBackground(new Color(0, 51, 102));
		contentConos.add(separatorMenu2);

		menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 1, 502, 37);
		menuBar_1.setBorderPainted(false);
		menuBar_1.setBackground(new Color(0, 51, 102));
		contentConos.add(menuBar_1);

		menUsuario = new JMenu(" " + info[0] + " ");
		menuBar_1.add(menUsuario);
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
		menuBar_1.add(menInsertar);

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
		menuBar_1.add(menGestionar);

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
		menuBar_1.add(menComparar);

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
		menuBar_1.add(menBuscar);
		
		// Mostrar conocidos
		conocidos = listarConocidos(dni);
		for (Conocido con : conocidos.values()) {
			lblRel = new JLabel("RELACI\u00D3N");
			lblRel.setBounds(20, 86 + posicion, 81, 28);
			lblRel.setForeground(new Color(153, 0, 0));
			lblRel.setFont(new Font("Tahoma", Font.BOLD, 10));
			contentConos.add(lblRel);
			
			separatorRel = new JSeparator();
			separatorRel.setBounds(20, 112 + posicion, 106, 2);
			separatorRel.setForeground(SystemColor.controlShadow);
			separatorRel.setBackground(new Color(153, 0, 0));
			contentConos.add(separatorRel);
			
			textRel = new JTextField();
			textRel.setEditable(false);
			textRel.setBounds(20, 125 + posicion, 187, 20);
			textRel.setColumns(10);
			textRel.setText(con.getRelacion());
			contentConos.add(textRel);
			
			lblNomComp = new JLabel(con.getNomComp());
			lblNomComp.setBounds(18, 81 + posicion, 438, 14);
			lblNomComp.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNomComp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					abrirBusPer(con.getDni2());
				}
			});
			contentConos.add(lblNomComp);
			
			posicion = posicion + 85;
		}
		lblLisCono = new JLabel("Lista Conocidos");
		lblLisCono.setBounds(10, 42, 142, 19);
		lblLisCono.setForeground(SystemColor.textInactiveText);
		lblLisCono.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentConos.add(lblLisCono);

		separatorLisCono = new JSeparator();
		separatorLisCono.setBounds(10, 64, 464, 2);
		separatorLisCono.setForeground(new Color(102, 0, 0));
		separatorLisCono.setBackground(new Color(153, 0, 0));
		contentConos.add(separatorLisCono);
		
		imgErtzAO_1 = new JLabel("");
		imgErtzAO_1.setIcon(new ImageIcon(VBusPer.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO_1.setBounds(97, 178, 309, 317);
		contentConos.add(imgErtzAO_1);

	}

	/**
	 * Metodo para cargar los datos de la persona
	 *  
	 * @param dni: Esta variable contiene el dni que recibe del constructor.
	 * String[] fechasArresto: Sirve para intercambiar de ArrayList a un Array normal, además de cambiarlo a un String ya que es LocalDate. Tambien para recorrer las fechas de arresto que contiene la clase criminal.
	 * per: Esta variable contiene el método del controlador que obtiene la persona con el dni que se encuentra en el constructor.
	 *
	 * En los TextField(campos) muestra la informacion que contiene la clase Persona.
	 * Además se controla que si la persona es un agente, criminal o desaparecida,
	 * mostrara los datos que contiene las diferentes clases con sus campos correspondientes
	 * y se visualiza con sus respectivos paneles.
	 */
	// Cargar la información
	private void cargarDatos(String dni) {
		per = obtenerPersona(dni);
		textDni.setText(dni);
		textNombre.setText(per.getNombre());
		textApellido.setText(per.getApellido());
		textMovil.setText(Integer.toString(per.getTelefonos()[0]));
		textTelf.setText(Integer.toString(per.getTelefonos()[1]));
		if (per.getFechaNac() != null) {
			textNac.setText(per.getFechaNac().toString());
		}
		if (per.getFechaFal() != null) {
			textFall.setText(per.getFechaFal().toString());
		}

		if (per instanceof Agente) {
			panelAgente.setVisible(true);
			textRango.setText(Integer.toString(((Agente) per).getRango()));
			if (((Agente) per).getInicioServ() != null) {
				textIniServ.setText((((Agente) per).getInicioServ()).toString());
			}
			if (((Agente) per).getFinServ() != null) {
				textFinServ.setText((((Agente) per).getFinServ()).toString());
			}
		} else if (per instanceof Criminal) {
			panelCriminal.setVisible(true);
			if (((Criminal) per).isPrisionero()) {
				rdbtnSi.setSelected(true);
			} else {
				rdbtnNo.setSelected(true);
			}
			
			String[] fechasArresto = new String[((Criminal) per).getFechasArresto().size()];
			for (int i = 0; i < fechasArresto.length; i++) {
				fechasArresto[i] = ((Criminal) per).getFechasArresto().get(i).toString();
			}
			
			list = new JList<String>(fechasArresto);
			list.setBounds(60, 85, 141, 120);
			panelCriminal.add(list);
		} else if (per instanceof Desaparecida) {
			panelDes.setVisible(true);
			if (((Desaparecida) per).getFechaDes() != null) {
				textFechaDes.setText(((Desaparecida) per).getFechaDes().toString());
			}
			textUltUbi.setText(((Desaparecida) per).getUltimaUbi());
			textSexo.setText(((Desaparecida) per).getGenero());
			textTP.setText(((Desaparecida) per).getTipoPelo());
			textCP.setText(((Desaparecida) per).getColorPelo());
			textCO.setText(((Desaparecida) per).getColorOjos());
			textAlt.setText(Integer.toString(((Desaparecida) per).getAltura()));
			textEsp.setText(((Desaparecida) per).getEspecificaciones());
		}
	}

	@Override
	public Persona obtenerPersona(String dni) {
		return datos.obtenerPersona(dni);
	}

	@Override
	public Map<String, Conocido> listarConocidos(String dni1) {
		return datos.listarConocidos(dni1);
	}

	/**
	 * Metodo para cerrar la ventana y volver a la ventana de busqueda
	 */
	public void cerrar() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
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
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
		} 
	}
	/**
	 * Metodo para abrir la ventana de Gestion.
	 * Se realiza al pulsar en la barra de menú el botón 'Gestionar'.
	 */
	// Abrir ventanas de menú
	private void abrirGes() {
		VGestion vBus = new VGestion(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Metodo para abrir la ventana de Comparacion.
	 * Se realiza al pulsar en la barra de menú el botón 'Comparar'.
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre,true,info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Método para abrir la ventana de Busqueda.
	 * Se realiza al pulsar en la barra de menú el botón 'Busqueda'.
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Método para abrir la ventana de inserción de personas.
	 *
	 * Funciona al pulsar en la barra de menu el boton 'Insertar' en la que
	 * Despliegara tres opciones para pulsar y este método se realiza en 'Resto Humano'.
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre,true,null,info,false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Método para abrir la ventana de inserción de personas.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar'
	 * y este método se realiza en 'Persona'.
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre,true,info);
		this.dispose();
		vInsPer.setVisible(true);		
	}

	/**
	 *  Metodo para abrir la ventana de insercion de casos.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar' y en 'Caso'.
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre,true,info);
		this.dispose();
		vInsCaso.setVisible(true);
	}	
	
	/**
	 * Método para abrir la ventana de búsqueda de persona.
	 *
	 * @param dni: Esta variable contiene el dni de la clase.
	 *
	 * Funciona al hacer clic en el nombre y apellido de la persona en la pestaña de conocidos,
	 * y mostrara la informacion de esa persona en la siguiente ventana.
	 */
	private void abrirBusPer(String dni) {
		VBusPer vBusPer = new VBusPer(padre, true, dni, info);
		this.dispose();
		vBusPer.setVisible(true);
	}
}
