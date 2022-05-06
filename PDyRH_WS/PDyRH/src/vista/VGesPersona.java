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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controlador.DataFactoryGestPer;
import controlador.interfaces.ContDatosGestPer;
import modelo.clases.Persona;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VGesPersona extends JDialog implements ContDatosGestPer, ActionListener {
	private static final long serialVersionUID = 1L;

	// <--- Datos BD --->
	ContDatosGestPer datos = DataFactoryGestPer.getDatos();

	// <--- Elementos --->
	private static Point point = new Point();
	private JTabbedPane tabbedPane;
	private JPanel contentDatos;
	private JLabel lblCerrar;
	private JSeparator separator2;
	private JMenuBar menuBar;
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
	private JTextField textLoc;
	private JLabel lblUltUbi;
	private JSeparator separatorUltimaUbi;
	private JTextField textUltUbi;
	private JLabel imgErtzAO;
	private JPanel contentConos;
	private JLabel lblCerrar_1;
	private JSeparator separator2_6;
	private JLabel lblDniCon;
	private JSeparator separatorDniCon;
	private JTextField textDniCon;
	private JLabel lblRel;
	private JSeparator separatorRel;
	private JTextField textRel;
	private JLabel lblFechaArr;
	private JSeparator separatorFechaArr;
	private JTextField textFechaArr;
	private JTextField textCP;
	private JTextField textCO;
	private JTextField textAlt;
	private JTextField textEsp;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenu menuInsertar;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JMenuItem mBanda;
	private JMenuItem mCriminal;
	private JSeparator separatorGesPer;
	private JLabel lblGesPer;
	private JLabel lblAnaCono;
	private JSeparator separatorAnaCono;
	private Button buttonAgregar;
	private JSeparator separator;
	private String info;
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
	private Button buttonMod;
	private Button buttonBaja;
	private ButtonGroup bgPris;
	private String dni;
	private Button buttonFA;
	
	// <--- Ejecuci�n --->
	public VGesPersona(VIniciarSesion padre, boolean modal, String dni, String infos) {
		super(padre);
		this.setModal(modal);
		setBounds(350, 150, 506, 690);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.dni = dni;
		
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

		// Bot�n para cerrar la ventana
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

		separator2 = new JSeparator();
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		separator2.setBounds(0, 36, 502, 2);
		contentDatos.add(separator2);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentDatos.add(menuBar);

		menUsuario = new JMenu(" " + info + " ");
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
		menUsuario.add(mCerrar);

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);

		mPersona = new JMenuItem("Persona");
		mPersona.setHorizontalAlignment(SwingConstants.LEFT);
		mPersona.setBackground(new Color(32, 178, 170));
		mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mPersona.setForeground(Color.BLACK);
		menuBusqueda.add(mPersona);

		mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
		mRestoHumano.setBackground(new Color(32, 178, 170));
		mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mRestoHumano.setForeground(Color.BLACK);
		menuBusqueda.add(mRestoHumano);

		mCaso = new JMenuItem("Caso");
		mCaso.setHorizontalAlignment(SwingConstants.LEFT);
		mCaso.setBackground(new Color(32, 178, 170));
		mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCaso.setForeground(Color.BLACK);
		menuBusqueda.add(mCaso);

		mBanda = new JMenuItem("Banda");
		mBanda.setHorizontalAlignment(SwingConstants.LEFT);
		mBanda.setBackground(new Color(32, 178, 170));
		mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mBanda.setForeground(Color.BLACK);
		menuBusqueda.add(mBanda);

		mCriminal = new JMenuItem("Criminales");
		mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
		mCriminal.setBackground(new Color(32, 178, 170));
		mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCriminal.setForeground(Color.BLACK);
		menuBusqueda.add(mCriminal);
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(26, 77, 81, 28);
		contentDatos.add(lblDni);

		separatorDni = new JSeparator();
		separatorDni.setForeground(SystemColor.controlShadow);
		separatorDni.setBackground(new Color(0, 51, 102));
		separatorDni.setBounds(26, 103, 106, 2);
		contentDatos.add(separatorDni);

		textDni = new JTextField();
		textDni.setToolTipText("");
		textDni.setEditable(false);
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
		textNombre.setToolTipText("");
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
		textApellido.setToolTipText("");
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
		textMovil.setToolTipText("");
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
		textTelf.setToolTipText("");
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
		textNac.setToolTipText("");
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
		textFall.setToolTipText("");
		textFall.setColumns(10);
		textFall.setBounds(26, 565, 187, 20);
		contentDatos.add(textFall);

		lblRango = new JLabel("RANGO");
		lblRango.setForeground(new Color(153, 0, 0));
		lblRango.setVisible(false);
		lblRango.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRango.setBounds(264, 74, 81, 28);
		contentDatos.add(lblRango);

		separatorRango = new JSeparator();
		separatorRango.setForeground(SystemColor.controlShadow);
		separatorRango.setBackground(new Color(153, 0, 0));
		separatorRango.setVisible(false);
		separatorRango.setBounds(264, 100, 106, 2);
		contentDatos.add(separatorRango);

		textRango = new JTextField();
		textRango.setToolTipText("");
		textRango.setVisible(false);
		textRango.setColumns(10);
		textRango.setBounds(264, 116, 187, 20);
		contentDatos.add(textRango);

		lblIniServ = new JLabel("INICIO SERVICIO");
		lblIniServ.setForeground(new Color(153, 0, 0));
		lblIniServ.setVisible(false);
		lblIniServ.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblIniServ.setBounds(264, 132, 106, 28);
		contentDatos.add(lblIniServ);

		separatorIniServ = new JSeparator();
		separatorIniServ.setForeground(SystemColor.controlShadow);
		separatorIniServ.setBackground(new Color(153, 0, 0));
		separatorIniServ.setVisible(false);
		separatorIniServ.setBounds(264, 158, 106, 2);
		contentDatos.add(separatorIniServ);

		textIniServ = new JTextField();
		textIniServ.setToolTipText("");
		textIniServ.setVisible(false);
		textIniServ.setColumns(10);
		textIniServ.setBounds(264, 174, 187, 20);
		contentDatos.add(textIniServ);

		lblFinServ = new JLabel("FIN SERVICIO");
		lblFinServ.setForeground(new Color(153, 0, 0));
		lblFinServ.setVisible(false);
		lblFinServ.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFinServ.setBounds(264, 200, 81, 28);
		contentDatos.add(lblFinServ);

		separatorFinServ = new JSeparator();
		separatorFinServ.setForeground(SystemColor.controlShadow);
		separatorFinServ.setBackground(new Color(153, 0, 0));
		separatorFinServ.setVisible(false);
		separatorFinServ.setBounds(264, 226, 106, 2);
		contentDatos.add(separatorFinServ);

		textFinServ = new JTextField();
		textFinServ.setToolTipText("");
		textFinServ.setVisible(false);
		textFinServ.setColumns(10);
		textFinServ.setBounds(264, 242, 187, 20);
		contentDatos.add(textFinServ);

		lblPris = new JLabel("PRISIONERO");
		lblPris.setForeground(new Color(153, 0, 0));
		lblPris.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPris.setBounds(267, 77, 81, 28);
		lblPris.setVisible(false);
		contentDatos.add(lblPris);

		separatorPris = new JSeparator();
		separatorPris.setForeground(SystemColor.controlShadow);
		separatorPris.setBackground(new Color(153, 0, 0));
		separatorPris.setVisible(false);
		separatorPris.setBounds(267, 103, 106, 2);
		contentDatos.add(separatorPris);

		rdbtnSi = new JRadioButton("S\u00ED");
		rdbtnSi.setOpaque(false);
		rdbtnSi.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSi.setBounds(264, 118, 43, 23);
		rdbtnSi.setVisible(false);
		contentDatos.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setOpaque(false);
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNo.setBounds(338, 118, 43, 23);
		rdbtnNo.setVisible(false);
		contentDatos.add(rdbtnNo);
		
		bgPris = new ButtonGroup();
		bgPris.add(rdbtnSi);
		bgPris.add(rdbtnNo);
		
		lblFechaArr = new JLabel("FECHA ARRESTO");
		lblFechaArr.setForeground(new Color(153, 0, 0));
		lblFechaArr.setVisible(false);
		lblFechaArr.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaArr.setBounds(264, 132, 106, 28);
		contentDatos.add(lblFechaArr);

		separatorFechaArr = new JSeparator();
		separatorFechaArr.setForeground(SystemColor.controlShadow);
		separatorFechaArr.setBackground(new Color(153, 0, 0));
		separatorFechaArr.setVisible(false);
		separatorFechaArr.setBounds(264, 158, 106, 2);
		contentDatos.add(separatorFechaArr);

		textFechaArr = new JTextField();
		textFechaArr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (textFechaArr.getText().isBlank()) {
					buttonFA.setEnabled(false);
				} else {
					buttonFA.setEnabled(true);
				}
			}
		});
		textFechaArr.setToolTipText("");
		textFechaArr.setVisible(false);
		textFechaArr.setColumns(10);
		textFechaArr.setBounds(264, 174, 187, 20);
		contentDatos.add(textFechaArr);
		
		textFechaDes = new JTextField();
		textFechaDes.setToolTipText("");
		textFechaDes.setVisible(false);
		textFechaDes.setColumns(10);
		textFechaDes.setBounds(264, 116, 187, 20);
		contentDatos.add(textFechaDes);

		textTP = new JTextField();
		textTP.setToolTipText("");
		textTP.setVisible(false);
		textTP.setColumns(10);
		textTP.setBounds(264, 300, 187, 20);
		contentDatos.add(textTP);

		textLoc = new JTextField();
		textLoc.setToolTipText("");
		textLoc.setColumns(10);
		textLoc.setBounds(26, 428, 187, 20);
		contentDatos.add(textLoc);

		textUltUbi = new JTextField();
		textUltUbi.setToolTipText("");
		textUltUbi.setVisible(false);
		textUltUbi.setColumns(10);
		textUltUbi.setBounds(264, 174, 187, 20);
		contentDatos.add(textUltUbi);

		separatorLoc = new JSeparator();
		separatorLoc.setForeground(SystemColor.controlShadow);
		separatorLoc.setBackground(new Color(0, 51, 102));
		separatorLoc.setBounds(26, 415, 106, 2);
		contentDatos.add(separatorLoc);

		separatorFechaDes = new JSeparator();
		separatorFechaDes.setForeground(SystemColor.controlShadow);
		separatorFechaDes.setBackground(new Color(153, 0, 0));
		separatorFechaDes.setVisible(false);
		separatorFechaDes.setBounds(264, 103, 106, 2);
		contentDatos.add(separatorFechaDes);

		lblSexo = new JLabel("SEXO");
		lblSexo.setForeground(new Color(153, 0, 0));
		lblSexo.setVisible(false);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSexo.setBounds(264, 207, 81, 28);
		contentDatos.add(lblSexo);

		separatorSexo = new JSeparator();
		separatorSexo.setForeground(SystemColor.controlShadow);
		separatorSexo.setBackground(new Color(153, 0, 0));
		separatorSexo.setVisible(false);
		separatorSexo.setBounds(264, 233, 106, 2);
		contentDatos.add(separatorSexo);

		lblUltUbi = new JLabel("\u00DALTIMA UBI.");
		lblUltUbi.setForeground(new Color(153, 0, 0));
		lblUltUbi.setVisible(false);
		lblUltUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUltUbi.setBounds(264, 135, 106, 28);
		contentDatos.add(lblUltUbi);

		lblLoc = new JLabel("LOCALIDAD");
		lblLoc.setForeground(new Color(0, 51, 102));
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLoc.setBounds(26, 389, 106, 28);
		contentDatos.add(lblLoc);

		separatorUltimaUbi = new JSeparator();
		separatorUltimaUbi.setForeground(SystemColor.controlShadow);
		separatorUltimaUbi.setBackground(new Color(153, 0, 0));
		separatorUltimaUbi.setVisible(false);
		separatorUltimaUbi.setBounds(264, 161, 106, 2);
		contentDatos.add(separatorUltimaUbi);

		lblFechaDes = new JLabel("FECHA DES.");
		lblFechaDes.setForeground(new Color(153, 0, 0));
		lblFechaDes.setVisible(false);
		lblFechaDes.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaDes.setBounds(264, 77, 106, 28);
		contentDatos.add(lblFechaDes);

		lblTP = new JLabel("TIPO PELO");
		lblTP.setForeground(new Color(153, 0, 0));
		lblTP.setVisible(false);
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTP.setBounds(264, 261, 106, 28);
		contentDatos.add(lblTP);

		separatorTP = new JSeparator();
		separatorTP.setForeground(SystemColor.controlShadow);
		separatorTP.setBackground(new Color(153, 0, 0));
		separatorTP.setVisible(false);
		separatorTP.setBounds(264, 287, 106, 2);
		contentDatos.add(separatorTP);

		textSexo = new JTextField();
		textSexo.setToolTipText("");
		textSexo.setVisible(false);
		textSexo.setColumns(10);
		textSexo.setBounds(264, 242, 187, 20);
		contentDatos.add(textSexo);

		textCP = new JTextField();
		textCP.setToolTipText("");
		textCP.setVisible(false);
		textCP.setColumns(10);
		textCP.setBounds(264, 370, 187, 20);
		contentDatos.add(textCP);

		lblCP = new JLabel("COLOR PELO");
		lblCP.setForeground(new Color(153, 0, 0));
		lblCP.setVisible(false);
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCP.setBounds(264, 331, 106, 28);
		contentDatos.add(lblCP);

		separatorCP = new JSeparator();
		separatorCP.setForeground(SystemColor.controlShadow);
		separatorCP.setBackground(new Color(153, 0, 0));
		separatorCP.setVisible(false);
		separatorCP.setBounds(264, 357, 106, 2);
		contentDatos.add(separatorCP);

		textCO = new JTextField();
		textCO.setToolTipText("");
		textCO.setVisible(false);
		textCO.setColumns(10);
		textCO.setBounds(264, 428, 187, 20);
		contentDatos.add(textCO);

		lblCO = new JLabel("COLOR OJOS");
		lblCO.setForeground(new Color(153, 0, 0));
		lblCO.setVisible(false);
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(264, 389, 106, 28);
		contentDatos.add(lblCO);

		separatorCO = new JSeparator();
		separatorCO.setForeground(SystemColor.controlShadow);
		separatorCO.setBackground(new Color(153, 0, 0));
		separatorCO.setVisible(false);
		separatorCO.setBounds(264, 415, 106, 2);
		contentDatos.add(separatorCO);

		textAlt = new JTextField();
		textAlt.setToolTipText("");
		textAlt.setVisible(false);
		textAlt.setColumns(10);
		textAlt.setBounds(264, 497, 187, 20);
		contentDatos.add(textAlt);

		lblAlt = new JLabel("ALTURA");
		lblAlt.setForeground(new Color(153, 0, 0));
		lblAlt.setVisible(false);
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlt.setBounds(264, 458, 106, 28);
		contentDatos.add(lblAlt);

		separatorAlt = new JSeparator();
		separatorAlt.setForeground(SystemColor.controlShadow);
		separatorAlt.setBackground(new Color(153, 0, 0));
		separatorAlt.setVisible(false);
		separatorAlt.setBounds(264, 484, 106, 2);
		contentDatos.add(separatorAlt);

		textEsp = new JTextField();
		textEsp.setToolTipText("");
		textEsp.setVisible(false);
		textEsp.setColumns(10);
		textEsp.setBounds(264, 565, 187, 20);
		contentDatos.add(textEsp);

		lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setForeground(new Color(153, 0, 0));
		lblEsp.setVisible(false);
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEsp.setBounds(264, 526, 106, 28);
		contentDatos.add(lblEsp);

		separatorEsp = new JSeparator();
		separatorEsp.setForeground(SystemColor.controlShadow);
		separatorEsp.setBackground(new Color(153, 0, 0));
		separatorEsp.setVisible(false);
		separatorEsp.setBounds(264, 552, 106, 2);
		contentDatos.add(separatorEsp);

		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		imgErtzAO.setBounds(90, 200, 309, 317);
		contentDatos.add(imgErtzAO);

		separatorGesPer = new JSeparator();
		separatorGesPer.setForeground(new Color(102, 0, 0));
		separatorGesPer.setVisible(false);
		separatorGesPer.setBackground(new Color(153, 0, 0));
		separatorGesPer.setBounds(10, 64, 478, 2);
		contentDatos.add(separatorGesPer);

		lblGesPer = new JLabel("Gesti\u00F3n de Persona");
		lblGesPer.setForeground(SystemColor.textInactiveText);
		lblGesPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGesPer.setBounds(10, 42, 142, 19);
		lblGesPer.setVisible(false);
		contentDatos.add(lblGesPer);

		buttonMod = new Button("MODIFICAR");
		buttonMod.setForeground(Color.WHITE);
		buttonMod.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonMod.setBackground(new Color(153, 0, 0));
		buttonMod.setBounds(124, 610, 89, 28);
		buttonMod.addActionListener(this);
		contentDatos.add(buttonMod);

		buttonBaja = new Button("DAR BAJA");
		buttonBaja.setForeground(Color.WHITE);
		buttonBaja.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonBaja.setBackground(new Color(153, 0, 0));
		buttonBaja.setBounds(264, 610, 89, 28);
		buttonBaja.addActionListener(this);
		contentDatos.add(buttonBaja);
		
		buttonFA = new Button("+");
		buttonFA.setEnabled(false);
		buttonFA.setBounds(457, 174, 20, 20);
		buttonFA.setVisible(false);
		buttonFA.addActionListener(this);
		contentDatos.add(buttonFA);
		
		cargarDatos(dni);

		contentConos = new JPanel();
		contentConos.setLayout(null);
		contentConos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentConos.setBackground(Color.WHITE);
		tabbedPane.addTab("Conocidos", null, contentConos, null);
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				int index = tabbedPane.getSelectedIndex();
				if (index == 1) {
					setBounds(100, 100, 507, 278);
					setLocationRelativeTo(null);
				} else {
					setBounds(350, 150, 506, 690);
					getContentPane().setBounds(350, 150, 506, 690);
					setLocationRelativeTo(null);
				}

			}

		});

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

		// Bot�n para cerrar la ventana
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
		lblCerrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar_1.setForeground(Color.WHITE);
		contentConos.add(lblCerrar_1);

		separator2_6 = new JSeparator();
		separator2_6.setForeground(SystemColor.controlShadow);
		separator2_6.setBackground(new Color(0, 51, 102));
		separator2_6.setBounds(0, 36, 502, 2);
		contentConos.add(separator2_6);

		separator2 = new JSeparator();
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		separator2.setBounds(0, 36, 502, 2);
		contentConos.add(separator2);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentConos.add(menuBar);

		menUsuario = new JMenu(" " + info + " ");
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
		menUsuario.add(mCerrar);

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);

		mPersona = new JMenuItem("Persona");
		mPersona.setHorizontalAlignment(SwingConstants.LEFT);
		mPersona.setBackground(new Color(32, 178, 170));
		mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mPersona.setForeground(Color.BLACK);
		menuBusqueda.add(mPersona);

		mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
		mRestoHumano.setBackground(new Color(32, 178, 170));
		mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mRestoHumano.setForeground(Color.BLACK);
		menuBusqueda.add(mRestoHumano);

		mCaso = new JMenuItem("Caso");
		mCaso.setHorizontalAlignment(SwingConstants.LEFT);
		mCaso.setBackground(new Color(32, 178, 170));
		mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCaso.setForeground(Color.BLACK);
		menuBusqueda.add(mCaso);

		mBanda = new JMenuItem("Banda");
		mBanda.setHorizontalAlignment(SwingConstants.LEFT);
		mBanda.setBackground(new Color(32, 178, 170));
		mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mBanda.setForeground(Color.BLACK);
		menuBusqueda.add(mBanda);

		mCriminal = new JMenuItem("Criminales");
		mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
		mCriminal.setBackground(new Color(32, 178, 170));
		mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCriminal.setForeground(Color.BLACK);
		menuBusqueda.add(mCriminal);

		lblDniCon = new JLabel("DNI");
		lblDniCon.setForeground(new Color(0, 51, 102));
		lblDniCon.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDniCon.setBounds(26, 77, 81, 28);
		contentConos.add(lblDniCon);

		separatorDniCon = new JSeparator();
		separatorDniCon.setForeground(SystemColor.controlShadow);
		separatorDniCon.setBackground(new Color(0, 51, 102));
		separatorDniCon.setBounds(26, 103, 106, 2);
		contentConos.add(separatorDniCon);

		textDniCon = new JTextField();
		textDniCon.setToolTipText("");
		textDniCon.setEditable(false);
		textDniCon.setColumns(10);
		textDniCon.setBounds(26, 116, 187, 20);
		contentConos.add(textDniCon);

		lblRel = new JLabel("RELACI\u00D3N");
		lblRel.setForeground(new Color(153, 0, 0));
		lblRel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRel.setBounds(26, 147, 81, 28);
		contentConos.add(lblRel);

		separatorRel = new JSeparator();
		separatorRel.setForeground(SystemColor.controlShadow);
		separatorRel.setBackground(new Color(153, 0, 0));
		separatorRel.setBounds(26, 173, 106, 2);
		contentConos.add(separatorRel);

		textRel = new JTextField();
		textRel.setToolTipText("");
		textRel.setEditable(false);
		textRel.setColumns(10);
		textRel.setBounds(26, 186, 187, 20);
		contentConos.add(textRel);

		lblAnaCono = new JLabel("A\u00F1adir Conocidos");
		lblAnaCono.setForeground(SystemColor.textInactiveText);
		lblAnaCono.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblAnaCono.setBounds(10, 42, 142, 19);
		contentConos.add(lblAnaCono);

		separatorAnaCono = new JSeparator();
		separatorAnaCono.setForeground(new Color(102, 0, 0));
		separatorAnaCono.setBackground(new Color(153, 0, 0));
		separatorAnaCono.setBounds(10, 64, 478, 2);
		contentConos.add(separatorAnaCono);

		buttonAgregar = new Button("A\u00D1ADIR");
		buttonAgregar.setForeground(Color.WHITE);
		buttonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAgregar.setBackground(new Color(153, 0, 0));
		buttonAgregar.setBounds(310, 136, 89, 28);
		contentConos.add(buttonAgregar);
		
		separator = new JSeparator();
		separator.setForeground(new Color(153, 153, 255));
		separator.setBackground(new Color(153, 153, 204));
		separator.setBounds(0, 251, 502, 2);
		contentConos.add(separator);
	}

	private void cargarDatos(String dni) {
		per = obtenerPersona(dni);
		textDni.setText(dni);
		textNombre.setText(per.getNombre());
		textApellido.setText(per.getApellido());
		textMovil.setText(Integer.toString(per.getTelefonos()[0]));
		textTelf.setText(Integer.toString(per.getTelefonos()[1]));
		textLoc.setText(per.getLocalidad());
		if (per.getFechaNac() != null) {
			textNac.setText(per.getFechaNac().toString());
		}
		if (per.getFechaFal() != null) {
			textFall.setText(per.getFechaFal().toString());
		}
		
		if (per instanceof Agente) {
			lblRango.setVisible(true);
			separatorRango.setVisible(true);
			textRango.setVisible(true);
			textRango.setText(Integer.toString(((Agente) per).getRango()));
			lblIniServ.setVisible(true);
			separatorIniServ.setVisible(true);
			textIniServ.setVisible(true);
			lblFinServ.setVisible(true);
			separatorFinServ.setVisible(true);
			textFinServ.setVisible(true);
			if (((Agente) per).getInicioServ() != null) {
				textIniServ.setText((((Agente) per).getInicioServ()).toString());
			}
			if (((Agente) per).getFinServ() != null) {
				textFinServ.setText((((Agente) per).getFinServ()).toString());
			}
		} else if (per instanceof Criminal) {
			lblPris.setVisible(true);
			separatorPris.setVisible(true);
			rdbtnSi.setVisible(true);
			rdbtnNo.setVisible(true);
			if (((Criminal) per).isPrisionero()) {
				rdbtnSi.setSelected(true);
			} else {
				rdbtnNo.setSelected(true);
			}
			lblFechaArr.setVisible(true);
			separatorFechaArr.setVisible(true);
			textFechaArr.setVisible(true);
			buttonFA.setVisible(true);
		} else if (per instanceof Desaparecida) {
			lblFechaDes.setVisible(true);
			lblUltUbi.setVisible(true);
			lblSexo.setVisible(true);
			lblTP.setVisible(true);
			lblCP.setVisible(true);
			lblCO.setVisible(true);
			lblAlt.setVisible(true);
			lblEsp.setVisible(true);
			separatorFechaDes.setVisible(true);
			separatorUltimaUbi.setVisible(true);
			separatorSexo.setVisible(true);
			separatorTP.setVisible(true);
			separatorCP.setVisible(true);
			separatorCO.setVisible(true);
			separatorAlt.setVisible(true);
			separatorEsp.setVisible(true);
			textFechaDes.setVisible(true);
			textUltUbi.setVisible(true);
			textSexo.setVisible(true);
			textTP.setVisible(true);
			textCP.setVisible(true);
			textCO.setVisible(true);
			textAlt.setVisible(true);
			textEsp.setVisible(true);
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
	public void modificarPersona(Persona per) {
		int movil = 0;
		int opc = 0;
		if (!textMovil.getText().isBlank()) {
			movil = Integer.valueOf(textMovil.getText());
		}
		if (!textTelf.getText().isBlank()) {
			opc = Integer.valueOf(textTelf.getText());
		}
		int[] telfs = {movil,opc};
		
		per.setNombre(textNombre.getText());
		per.setApellido(textApellido.getText());
		per.setTelefonos(telfs);
		per.setLocalidad(textLoc.getText());
		if (!textNac.getText().isBlank()) {
			per.setFechaNac(LocalDate.parse(textNac.getText()));
		}
		if (!textFall.getText().isBlank()) {
			per.setFechaFal(LocalDate.parse(textFall.getText()));
		}
		if (per instanceof Agente) {
			int rango = 0;
			if (!textRango.getText().isBlank()) {
				rango = Integer.parseInt(textRango.getText());
			}
			((Agente) per).setRango(rango);
			if (!textIniServ.getText().isBlank()) {
				((Agente) per).setInicioServ(LocalDate.parse(textIniServ.getText()));
			}
			if (!textFinServ.getText().isBlank()) {
				((Agente) per).setFinServ(LocalDate.parse(textFinServ.getText()));
			}
			
		} else if (per instanceof Criminal) {
			boolean pris = false;
			if (rdbtnSi.isSelected()) {
				pris = true;
			}
			((Criminal) per).setPrisionero(pris);
		} else if (per instanceof Desaparecida) {
			int altura = 0;
			if (!textAlt.getText().isBlank()) {
				altura = Integer.parseInt(textAlt.getText());
			}
			if (!textFechaDes.getText().isBlank()) {
				((Desaparecida) per).setFechaDes(LocalDate.parse(textFechaDes.getText()));
			}
			((Desaparecida) per).setUltimaUbi(textUltUbi.getText());
			((Desaparecida) per).setGenero(textSexo.getText());
			((Desaparecida) per).setTipoPelo(textTP.getText());
			((Desaparecida) per).setColorPelo(textCP.getText());
			((Desaparecida) per).setColorOjos(textCO.getText());
			((Desaparecida) per).setAltura(altura);
			((Desaparecida) per).setEspecificaciones(textEsp.getText());
		} 
		datos.modificarPersona(per);
	}

	@Override
	public void eliminarPersona(String dni) {
		datos.eliminarPersona(dni);
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	@Override
	public void agregarConocido(Conocido cono) {

	}

	@Override
	public Map<String, Conocido> listarConocidos(String dni1) {

		return datos.listarConocidos(dni1);
	}

	@Override
	public void agregarFechaArresto(String dni, LocalDate fecha) {
		datos.agregarFechaArresto(dni, fecha);
	}

	public void cerrar() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonMod)) {
			modificarPersona(per);
		} else if (e.getSource().equals(buttonBaja)) {
			eliminarPersona(dni);
		} else if (e.getSource().equals(buttonFA)) {
			agregarFechaArresto(per.getDni(),LocalDate.parse(textFechaArr.getText()));
		}
		
	}
}
