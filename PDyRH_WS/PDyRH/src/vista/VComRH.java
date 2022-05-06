package vista;

import java.awt.BorderLayout;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import controlador.DataFactoryCompEsp;
import controlador.interfaces.ContDatosCompEsp;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;
import modelo.clases.Desaparecida;

import javax.swing.ImageIcon;

public class VComRH extends JDialog implements ContDatosCompEsp {
	private static final long serialVersionUID = 1L;
	
	// <--- Elementos --->
	private JPanel contentPane = new JPanel();
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JTextField textFECHA;
	private JTextField textUbi;
	private JTextField textGen;
	private JTextField textTP;
	private JTextField textCP;
	private JTextField textAlt;
	private JTextField textEsp;
	private JTextField textFecha2;
	private JTextField textUbi2;
	private JTextField textGen2;
	private JTextField textTP2;
	private JTextField textCP2;
	private JTextField textAlt2;
	private JTextField textEsp2;
	private JTextField textCO;
	private JTextField textCO2;
	private JSeparator separator2_5;
	private JMenuBar menuBar;
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
	private Button button;
	private JLabel lblFecha;
	private JSeparator separator2;
	private JLabel lblUbi;
	private JSeparator separator2_1;
	private JLabel lblGen;
	private JLabel lblTP;
	private JSeparator separator2_2;
	private JSeparator separator2_1_1;
	private JLabel lblCP;
	private JSeparator separator2_3;
	private JLabel lblAlt;
	private JSeparator separator2_1_2;
	private JLabel lblEsp;
	private JSeparator separator2_2_1;
	private JLabel lblFecha_1;
	private JSeparator separator2_4;
	private JLabel lblUbi_1;
	private JSeparator separator2_1_3;
	private JLabel lblGen_1;
	private JSeparator separator2_2_2;
	private JLabel lblTP_1;
	private JSeparator separator2_1_1_1;
	private JLabel lblCP_1;
	private JSeparator separator2_3_1;
	private JLabel lblAlt_1;
	private JSeparator separator2_1_2_1;
	private JLabel lblEsp_1;
	private JSeparator separator2_2_1_1;
	private JLabel lblRestoHumano;
	private JSeparator separator1;
	private JLabel lblDesaparecida;
	private JSeparator separator1_1;
	private JLabel lblCO;
	private JSeparator separator2_2_1_2;
	private JLabel lblCO2;
	private JSeparator separator2_2_1_1_1;
	private JLabel lblNewLabel;
	private RestoHumano resto;
	private Persona des;

	// <--- Datos BD --->
	ContDatosCompEsp datos = DataFactoryCompEsp.getDatos();

	public VComRH(VIniciarSesion padre, boolean modal, String dni, String codigo, String info) {
		super(padre);
		this.setModal(modal);
		setBounds(350, 150, 503, 627);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		// Movimiento de la ventana
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
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
		contentPane.add(lblCerrar);
		
		separator2_5 = new JSeparator();
		separator2_5.setBounds(0, 36, 502, 2);
		separator2_5.setForeground(SystemColor.controlShadow);
		separator2_5.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_5);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPane.add(menuBar);

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

		button = new Button("IDENTIFICAR");
		button.setBounds(397, 592, 96, 24);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(153, 0, 0));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				agregarIdentificado(codigo,dni);
			}
			
		});
		contentPane.add(button);

		lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(26, 77, 81, 28);
		lblFecha.setForeground(new Color(0, 51, 102));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha);

		separator2 = new JSeparator();
		separator2.setBounds(26, 103, 106, 2);
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2);

		textFECHA = new JTextField();
		textFECHA.setBounds(26, 116, 187, 20);
		textFECHA.setEditable(false);
		textFECHA.setToolTipText("");
		textFECHA.setColumns(10);
		contentPane.add(textFECHA);

		lblUbi = new JLabel("UBICACI\u00D3N");
		lblUbi.setBounds(26, 135, 81, 28);
		lblUbi.setForeground(new Color(0, 51, 102));
		lblUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi);

		separator2_1 = new JSeparator();
		separator2_1.setBounds(26, 161, 106, 2);
		separator2_1.setForeground(SystemColor.controlShadow);
		separator2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1);

		textUbi = new JTextField();
		textUbi.setBounds(26, 174, 187, 20);
		textUbi.setEditable(false);
		textUbi.setToolTipText("");
		textUbi.setColumns(10);
		contentPane.add(textUbi);

		lblGen = new JLabel("SEXO");
		lblGen.setBounds(26, 203, 81, 28);
		lblGen.setForeground(new Color(0, 51, 102));
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen);

		separator2_2 = new JSeparator();
		separator2_2.setBounds(26, 229, 106, 2);
		separator2_2.setForeground(SystemColor.controlShadow);
		separator2_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2);

		textGen = new JTextField();
		textGen.setBounds(26, 242, 187, 20);
		textGen.setEditable(false);
		textGen.setToolTipText("");
		textGen.setColumns(10);
		contentPane.add(textGen);

		lblTP = new JLabel("TIPO DE PELO");
		lblTP.setBounds(26, 261, 81, 28);
		lblTP.setForeground(new Color(0, 51, 102));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP);

		separator2_1_1 = new JSeparator();
		separator2_1_1.setBounds(26, 287, 106, 2);
		separator2_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_1);

		textTP = new JTextField();
		textTP.setBounds(26, 300, 187, 20);
		textTP.setEditable(false);
		textTP.setToolTipText("");
		textTP.setColumns(10);
		contentPane.add(textTP);

		lblCP = new JLabel("COLOR DE PELO");
		lblCP.setBounds(26, 331, 106, 28);
		lblCP.setForeground(new Color(0, 51, 102));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP);

		separator2_3 = new JSeparator();
		separator2_3.setBounds(26, 357, 106, 2);
		separator2_3.setForeground(SystemColor.controlShadow);
		separator2_3.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_3);

		textCP = new JTextField();
		textCP.setBounds(26, 370, 187, 20);
		textCP.setEditable(false);
		textCP.setToolTipText("");
		textCP.setColumns(10);
		contentPane.add(textCP);

		lblAlt = new JLabel("ALTURA");
		lblAlt.setBounds(26, 458, 81, 28);
		lblAlt.setForeground(new Color(0, 51, 102));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt);

		separator2_1_2 = new JSeparator();
		separator2_1_2.setBounds(26, 484, 106, 2);
		separator2_1_2.setForeground(SystemColor.controlShadow);
		separator2_1_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_2);

		textAlt = new JTextField();
		textAlt.setBounds(26, 497, 187, 20);
		textAlt.setEditable(false);
		textAlt.setToolTipText("");
		textAlt.setColumns(10);
		contentPane.add(textAlt);

		lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setBounds(26, 526, 106, 28);
		lblEsp.setForeground(new Color(0, 51, 102));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp);

		separator2_2_1 = new JSeparator();
		separator2_2_1.setBounds(26, 552, 106, 2);
		separator2_2_1.setForeground(SystemColor.controlShadow);
		separator2_2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2_1);

		textEsp = new JTextField();
		textEsp.setBounds(26, 565, 187, 20);
		textEsp.setEditable(false);
		textEsp.setToolTipText("");
		textEsp.setColumns(10);
		contentPane.add(textEsp);

		lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setBounds(264, 74, 81, 28);
		lblFecha_1.setForeground(new Color(153, 0, 0));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha_1);

		separator2_4 = new JSeparator();
		separator2_4.setBounds(264, 100, 106, 2);
		separator2_4.setForeground(SystemColor.controlShadow);
		separator2_4.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_4);

		textFecha2 = new JTextField();
		textFecha2.setBounds(264, 113, 187, 20);
		textFecha2.setEditable(false);
		textFecha2.setToolTipText("");
		textFecha2.setColumns(10);
		contentPane.add(textFecha2);

		lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setBounds(264, 132, 81, 28);
		lblUbi_1.setForeground(new Color(153, 0, 0));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi_1);

		separator2_1_3 = new JSeparator();
		separator2_1_3.setBounds(264, 158, 106, 2);
		separator2_1_3.setForeground(SystemColor.controlShadow);
		separator2_1_3.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_3);

		textUbi2 = new JTextField();
		textUbi2.setBounds(264, 171, 187, 20);
		textUbi2.setEditable(false);
		textUbi2.setToolTipText("");
		textUbi2.setColumns(10);
		contentPane.add(textUbi2);

		lblGen_1 = new JLabel("SEXO");
		lblGen_1.setBounds(264, 200, 81, 28);
		lblGen_1.setForeground(new Color(153, 0, 0));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen_1);

		separator2_2_2 = new JSeparator();
		separator2_2_2.setBounds(264, 226, 106, 2);
		separator2_2_2.setForeground(SystemColor.controlShadow);
		separator2_2_2.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_2);

		textGen2 = new JTextField();
		textGen2.setBounds(264, 239, 187, 20);
		textGen2.setEditable(false);
		textGen2.setToolTipText("");
		textGen2.setColumns(10);
		contentPane.add(textGen2);

		lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setBounds(264, 258, 81, 28);
		lblTP_1.setForeground(new Color(153, 0, 0));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP_1);

		separator2_1_1_1 = new JSeparator();
		separator2_1_1_1.setBounds(264, 284, 106, 2);
		separator2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_1_1);

		textTP2 = new JTextField();
		textTP2.setBounds(264, 297, 187, 20);
		textTP2.setEditable(false);
		textTP2.setToolTipText("");
		textTP2.setColumns(10);
		contentPane.add(textTP2);

		lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setBounds(264, 328, 106, 28);
		lblCP_1.setForeground(new Color(153, 0, 0));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP_1);

		separator2_3_1 = new JSeparator();
		separator2_3_1.setBounds(264, 354, 106, 2);
		separator2_3_1.setForeground(SystemColor.controlShadow);
		separator2_3_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_3_1);

		textCP2 = new JTextField();
		textCP2.setBounds(264, 367, 187, 20);
		textCP2.setEditable(false);
		textCP2.setToolTipText("");
		textCP2.setColumns(10);
		contentPane.add(textCP2);

		lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setBounds(264, 458, 81, 28);
		lblAlt_1.setForeground(new Color(153, 0, 0));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt_1);

		separator2_1_2_1 = new JSeparator();
		separator2_1_2_1.setBounds(264, 484, 106, 2);
		separator2_1_2_1.setForeground(SystemColor.controlShadow);
		separator2_1_2_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_2_1);

		textAlt2 = new JTextField();
		textAlt2.setBounds(264, 497, 187, 20);
		textAlt2.setEditable(false);
		textAlt2.setToolTipText("");
		textAlt2.setColumns(10);
		contentPane.add(textAlt2);

		lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setBounds(264, 526, 106, 28);
		lblEsp_1.setForeground(new Color(153, 0, 0));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp_1);

		separator2_2_1_1 = new JSeparator();
		separator2_2_1_1.setBounds(264, 552, 106, 2);
		separator2_2_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_1_1);

		textEsp2 = new JTextField();
		textEsp2.setBounds(264, 565, 187, 20);
		textEsp2.setEditable(false);
		textEsp2.setToolTipText("");
		textEsp2.setColumns(10);
		contentPane.add(textEsp2);

		lblRestoHumano = new JLabel("Resto Humano");
		lblRestoHumano.setBounds(66, 48, 106, 19);
		lblRestoHumano.setForeground(new Color(0, 51, 102));
		lblRestoHumano.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblRestoHumano);

		separator1 = new JSeparator();
		separator1.setBounds(54, 67, 126, 2);
		separator1.setForeground(new Color(0, 51, 102));
		separator1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator1);

		lblDesaparecida = new JLabel("Desaparecida");
		lblDesaparecida.setBounds(303, 48, 96, 19);
		lblDesaparecida.setForeground(new Color(153, 0, 0));
		lblDesaparecida.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblDesaparecida);

		separator1_1 = new JSeparator();
		separator1_1.setBounds(287, 67, 126, 2);
		separator1_1.setForeground(new Color(153, 0, 0));
		separator1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator1_1);

		lblCO = new JLabel("COLOR DE OJOS");
		lblCO.setForeground(new Color(0, 51, 102));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(26, 389, 106, 28);
		contentPane.add(lblCO);

		separator2_2_1_2 = new JSeparator();
		separator2_2_1_2.setForeground(SystemColor.controlShadow);
		separator2_2_1_2.setBackground(new Color(0, 51, 102));
		separator2_2_1_2.setBounds(26, 415, 106, 2);
		contentPane.add(separator2_2_1_2);

		textCO = new JTextField();
		textCO.setToolTipText("");
		textCO.setEditable(false);
		textCO.setColumns(10);
		textCO.setBounds(26, 428, 187, 20);
		contentPane.add(textCO);

		lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(153, 0, 0));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(264, 386, 106, 28);
		contentPane.add(lblCO2);

		separator2_2_1_1_1 = new JSeparator();
		separator2_2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1_1.setBackground(new Color(153, 0, 0));
		separator2_2_1_1_1.setBounds(264, 412, 106, 2);
		contentPane.add(separator2_2_1_1_1);

		textCO2 = new JTextField();
		textCO2.setToolTipText("");
		textCO2.setEditable(false);
		textCO2.setColumns(10);
		textCO2.setBounds(264, 425, 187, 20);
		contentPane.add(textCO2);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 200, 309, 317);
		lblNewLabel.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		contentPane.add(lblNewLabel);
		
		cargarDatos(dni,codigo);
	}

	private void cargarDatos(String dni, String codigo) {
		des = obtenerPersona(dni);
		resto = obtenerRH(codigo);
		
		textFECHA.setText(resto.getFechaMuerte().toString());
		textUbi.setText(resto.getUbicacion());
		textGen.setText(resto.getGenero());
		textTP.setText(resto.getTipoPelo());
		textCP.setText(resto.getColorPelo());
		textCO.setText(resto.getColorOjos());
		textAlt.setText(String.valueOf(resto.getAltura()));
		textEsp.setText(resto.getEspecificaciones());
		textFecha2.setText(((Desaparecida) des).getFechaDes().toString());
		textUbi2.setText(((Desaparecida) des).getUltimaUbi());
		textGen2.setText(((Desaparecida) des).getGenero());
		textTP2.setText(((Desaparecida) des).getTipoPelo());
		textCP2.setText(((Desaparecida) des).getColorPelo());
		textCO2.setText(((Desaparecida) des).getColorOjos());
		textAlt2.setText(String.valueOf(((Desaparecida) des).getAltura()));
		textEsp2.setText(((Desaparecida) des).getEspecificaciones());
	}

	private void cerrar() {
		this.dispose();
	}

	@Override
	public RestoHumano obtenerRH(String codResto) {
		return datos.obtenerRH(codResto);
	}

	@Override
	public Persona obtenerPersona(String dni) {
		return datos.obtenerPersona(dni);
	}

	@Override
	public void agregarIdentificado(String codResto, String dni) {
		if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea identificar a este resto? Es una acción irreversible.", "Confirmar identificación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
			datos.agregarIdentificado(codResto, dni);
			button.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Resto identificado correctamente.","Identificación realizada",JOptionPane.CLOSED_OPTION);
		}
	}
}
