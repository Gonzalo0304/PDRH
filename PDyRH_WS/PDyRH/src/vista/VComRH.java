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

public class VComRH extends JDialog implements ContDatosCompEsp, ActionListener {
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
	private JSeparator separatorMenu;
	private JMenuBar menuBar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private Button button;
	private JLabel lblFecha;
	private JSeparator separatorFecha;
	private JLabel lblUbi;
	private JSeparator separatorUbi;
	private JLabel lblGen;
	private JLabel lblTP;
	private JSeparator separatorSexo;
	private JSeparator separatorTP;
	private JLabel lblCP;
	private JSeparator separatorCP;
	private JLabel lblAlt;
	private JSeparator separatorAlt;
	private JLabel lblEsp;
	private JSeparator separatorEsp;
	private JLabel lblFecha_1;
	private JSeparator separatorFecha2;
	private JLabel lblUbi_1;
	private JSeparator separatorUbi2;
	private JLabel lblGen_1;
	private JSeparator separatorSexo2;
	private JLabel lblTP_1;
	private JSeparator separatorTP2;
	private JLabel lblCP_1;
	private JSeparator separatorCP2;
	private JLabel lblAlt_1;
	private JSeparator separatorAlt2;
	private JLabel lblEsp_1;
	private JSeparator separatorEsp2;
	private JLabel lblRestoHumano;
	private JSeparator separatorRH;
	private JLabel lblDesaparecida;
	private JSeparator separatorDes;
	private JLabel lblCO;
	private JSeparator separatorCO;
	private JLabel lblCO2;
	private JSeparator separatorCO2;
	private JLabel imgErtzAC;
	private RestoHumano resto;
	private Persona des;
	private VIniciarSesion padre;
	private String[] info;

	// <--- Datos BD --->
	ContDatosCompEsp datos = DataFactoryCompEsp.getDatos();

	public VComRH(VIniciarSesion padre, boolean modal, String dni, String codigo, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Comparación específica");
		setBounds(350, 150, 503, 627);
		contentPane.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		this.padre = padre;
		info = infos;

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

		// Menú superior
		separatorMenu = new JSeparator();
		separatorMenu.setBounds(0, 36, 502, 2);
		separatorMenu.setForeground(SystemColor.controlShadow);
		separatorMenu.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPane.add(menuBar);

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

		// Botón para identificar
		button = new Button("IDENTIFICAR");
		button.setBounds(397, 592, 96, 24);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(153, 0, 0));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				agregarIdentificado(codigo, dni);
			}

		});
		contentPane.add(button);

		// Campos de información
		lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(36, 78, 81, 28);
		lblFecha.setForeground(new Color(0, 51, 102));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha);

		separatorFecha = new JSeparator();
		separatorFecha.setBounds(36, 104, 106, 2);
		separatorFecha.setForeground(SystemColor.controlShadow);
		separatorFecha.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorFecha);

		textFECHA = new JTextField();
		textFECHA.setBounds(36, 117, 187, 20);
		textFECHA.setEditable(false);
		textFECHA.setColumns(10);
		contentPane.add(textFECHA);

		lblUbi = new JLabel("UBICACI\u00D3N");
		lblUbi.setBounds(36, 136, 81, 28);
		lblUbi.setForeground(new Color(0, 51, 102));
		lblUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi);

		separatorUbi = new JSeparator();
		separatorUbi.setBounds(36, 162, 106, 2);
		separatorUbi.setForeground(SystemColor.controlShadow);
		separatorUbi.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorUbi);

		textUbi = new JTextField();
		textUbi.setBounds(36, 175, 187, 20);
		textUbi.setEditable(false);
		textUbi.setColumns(10);
		contentPane.add(textUbi);

		lblGen = new JLabel("SEXO");
		lblGen.setBounds(36, 204, 81, 28);
		lblGen.setForeground(new Color(0, 51, 102));
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen);

		separatorSexo = new JSeparator();
		separatorSexo.setBounds(36, 230, 106, 2);
		separatorSexo.setForeground(SystemColor.controlShadow);
		separatorSexo.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorSexo);

		textGen = new JTextField();
		textGen.setBounds(36, 243, 187, 20);
		textGen.setEditable(false);
		textGen.setColumns(10);
		contentPane.add(textGen);

		lblTP = new JLabel("TIPO DE PELO");
		lblTP.setBounds(36, 262, 81, 28);
		lblTP.setForeground(new Color(0, 51, 102));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP);

		separatorTP = new JSeparator();
		separatorTP.setBounds(36, 288, 106, 2);
		separatorTP.setForeground(SystemColor.controlShadow);
		separatorTP.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorTP);

		textTP = new JTextField();
		textTP.setBounds(36, 301, 187, 20);
		textTP.setEditable(false);
		textTP.setColumns(10);
		contentPane.add(textTP);

		lblCP = new JLabel("COLOR DE PELO");
		lblCP.setBounds(36, 332, 106, 28);
		lblCP.setForeground(new Color(0, 51, 102));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP);

		separatorCP = new JSeparator();
		separatorCP.setBounds(36, 358, 106, 2);
		separatorCP.setForeground(SystemColor.controlShadow);
		separatorCP.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorCP);

		textCP = new JTextField();
		textCP.setBounds(36, 371, 187, 20);
		textCP.setEditable(false);
		textCP.setColumns(10);
		contentPane.add(textCP);

		lblAlt = new JLabel("ALTURA");
		lblAlt.setBounds(36, 459, 81, 28);
		lblAlt.setForeground(new Color(0, 51, 102));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt);

		separatorAlt = new JSeparator();
		separatorAlt.setBounds(36, 485, 106, 2);
		separatorAlt.setForeground(SystemColor.controlShadow);
		separatorAlt.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorAlt);

		textAlt = new JTextField();
		textAlt.setBounds(36, 498, 187, 20);
		textAlt.setEditable(false);
		textAlt.setColumns(10);
		contentPane.add(textAlt);

		lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setBounds(36, 527, 106, 28);
		lblEsp.setForeground(new Color(0, 51, 102));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp);

		separatorEsp = new JSeparator();
		separatorEsp.setBounds(36, 553, 106, 2);
		separatorEsp.setForeground(SystemColor.controlShadow);
		separatorEsp.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorEsp);

		textEsp = new JTextField();
		textEsp.setBounds(36, 566, 187, 20);
		textEsp.setEditable(false);
		textEsp.setColumns(10);
		contentPane.add(textEsp);

		lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setBounds(274, 75, 81, 28);
		lblFecha_1.setForeground(new Color(153, 0, 0));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha_1);

		separatorFecha2 = new JSeparator();
		separatorFecha2.setBounds(274, 101, 106, 2);
		separatorFecha2.setForeground(SystemColor.controlShadow);
		separatorFecha2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorFecha2);

		textFecha2 = new JTextField();
		textFecha2.setBounds(274, 114, 187, 20);
		textFecha2.setEditable(false);
		textFecha2.setColumns(10);
		contentPane.add(textFecha2);

		lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setBounds(274, 133, 81, 28);
		lblUbi_1.setForeground(new Color(153, 0, 0));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi_1);

		separatorUbi2 = new JSeparator();
		separatorUbi2.setBounds(274, 159, 106, 2);
		separatorUbi2.setForeground(SystemColor.controlShadow);
		separatorUbi2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorUbi2);

		textUbi2 = new JTextField();
		textUbi2.setBounds(274, 172, 187, 20);
		textUbi2.setEditable(false);
		textUbi2.setColumns(10);
		contentPane.add(textUbi2);

		lblGen_1 = new JLabel("SEXO");
		lblGen_1.setBounds(274, 201, 81, 28);
		lblGen_1.setForeground(new Color(153, 0, 0));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen_1);

		separatorSexo2 = new JSeparator();
		separatorSexo2.setBounds(274, 227, 106, 2);
		separatorSexo2.setForeground(SystemColor.controlShadow);
		separatorSexo2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorSexo2);

		textGen2 = new JTextField();
		textGen2.setBounds(274, 240, 187, 20);
		textGen2.setEditable(false);
		textGen2.setColumns(10);
		contentPane.add(textGen2);

		lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setBounds(274, 259, 81, 28);
		lblTP_1.setForeground(new Color(153, 0, 0));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP_1);

		separatorTP2 = new JSeparator();
		separatorTP2.setBounds(274, 285, 106, 2);
		separatorTP2.setForeground(SystemColor.controlShadow);
		separatorTP2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorTP2);

		textTP2 = new JTextField();
		textTP2.setBounds(274, 298, 187, 20);
		textTP2.setEditable(false);
		textTP2.setColumns(10);
		contentPane.add(textTP2);

		lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setBounds(274, 329, 106, 28);
		lblCP_1.setForeground(new Color(153, 0, 0));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP_1);

		separatorCP2 = new JSeparator();
		separatorCP2.setBounds(274, 355, 106, 2);
		separatorCP2.setForeground(SystemColor.controlShadow);
		separatorCP2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorCP2);

		textCP2 = new JTextField();
		textCP2.setBounds(274, 368, 187, 20);
		textCP2.setEditable(false);
		textCP2.setColumns(10);
		contentPane.add(textCP2);

		lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setBounds(274, 459, 81, 28);
		lblAlt_1.setForeground(new Color(153, 0, 0));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt_1);

		separatorAlt2 = new JSeparator();
		separatorAlt2.setBounds(274, 485, 106, 2);
		separatorAlt2.setForeground(SystemColor.controlShadow);
		separatorAlt2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorAlt2);

		textAlt2 = new JTextField();
		textAlt2.setBounds(274, 498, 187, 20);
		textAlt2.setEditable(false);
		textAlt2.setColumns(10);
		contentPane.add(textAlt2);

		lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setBounds(274, 527, 106, 28);
		lblEsp_1.setForeground(new Color(153, 0, 0));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp_1);

		separatorEsp2 = new JSeparator();
		separatorEsp2.setBounds(274, 553, 106, 2);
		separatorEsp2.setForeground(SystemColor.controlShadow);
		separatorEsp2.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorEsp2);

		textEsp2 = new JTextField();
		textEsp2.setBounds(274, 566, 187, 20);
		textEsp2.setEditable(false);
		textEsp2.setColumns(10);
		contentPane.add(textEsp2);

		lblRestoHumano = new JLabel("Resto Humano");
		lblRestoHumano.setBounds(76, 49, 106, 19);
		lblRestoHumano.setForeground(new Color(0, 51, 102));
		lblRestoHumano.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblRestoHumano);

		separatorRH = new JSeparator();
		separatorRH.setBounds(64, 68, 126, 2);
		separatorRH.setForeground(new Color(0, 51, 102));
		separatorRH.setBackground(new Color(0, 51, 102));
		contentPane.add(separatorRH);

		lblDesaparecida = new JLabel("Desaparecida");
		lblDesaparecida.setBounds(313, 49, 96, 19);
		lblDesaparecida.setForeground(new Color(153, 0, 0));
		lblDesaparecida.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblDesaparecida);

		separatorDes = new JSeparator();
		separatorDes.setBounds(297, 68, 126, 2);
		separatorDes.setForeground(new Color(153, 0, 0));
		separatorDes.setBackground(new Color(153, 0, 0));
		contentPane.add(separatorDes);

		lblCO = new JLabel("COLOR DE OJOS");
		lblCO.setForeground(new Color(0, 51, 102));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(36, 390, 106, 28);
		contentPane.add(lblCO);

		separatorCO = new JSeparator();
		separatorCO.setForeground(SystemColor.controlShadow);
		separatorCO.setBackground(new Color(0, 51, 102));
		separatorCO.setBounds(36, 416, 106, 2);
		contentPane.add(separatorCO);

		textCO = new JTextField();
		textCO.setEditable(false);
		textCO.setColumns(10);
		textCO.setBounds(36, 429, 187, 20);
		contentPane.add(textCO);

		lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(153, 0, 0));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(274, 387, 106, 28);
		contentPane.add(lblCO2);

		separatorCO2 = new JSeparator();
		separatorCO2.setForeground(SystemColor.controlShadow);
		separatorCO2.setBackground(new Color(153, 0, 0));
		separatorCO2.setBounds(274, 413, 106, 2);
		contentPane.add(separatorCO2);

		textCO2 = new JTextField();
		textCO2.setEditable(false);
		textCO2.setColumns(10);
		textCO2.setBounds(274, 426, 187, 20);
		contentPane.add(textCO2);

		cargarDatos(dni, codigo);
		// Fondo
		imgErtzAC = new JLabel("");
		imgErtzAC.setBounds(90, 200, 309, 317);
		imgErtzAC.setIcon(new ImageIcon(VComRH.class.getResource("/imagenes/ertzAC.png")));
		contentPane.add(imgErtzAC);
	}

	// <--- Métodos --->
	// Cargar la información en los campos de texto
	private void cargarDatos(String dni, String codigo) {
		des = obtenerPersona(dni);
		resto = obtenerRH(codigo);
		
		if (resto.getFechaMuerte() != null) {
			textFECHA.setText(resto.getFechaMuerte().toString());
		}
		textUbi.setText(resto.getUbicacion());
		textGen.setText(resto.getGenero());
		textTP.setText(resto.getTipoPelo());
		textCP.setText(resto.getColorPelo());
		textCO.setText(resto.getColorOjos());
		textAlt.setText(String.valueOf(resto.getAltura()));
		textEsp.setText(resto.getEspecificaciones());
		if (((Desaparecida) des).getFechaDes() != null) {
			textFecha2.setText(((Desaparecida) des).getFechaDes().toString());
		}
		textUbi2.setText(((Desaparecida) des).getUltimaUbi());
		textGen2.setText(((Desaparecida) des).getGenero());
		textTP2.setText(((Desaparecida) des).getTipoPelo());
		textCP2.setText(((Desaparecida) des).getColorPelo());
		textCO2.setText(((Desaparecida) des).getColorOjos());
		textAlt2.setText(String.valueOf(((Desaparecida) des).getAltura()));
		textEsp2.setText(((Desaparecida) des).getEspecificaciones());
	}

	private void cerrar() {
		VComparacion vComp = new VComparacion(padre, true, info);
		this.dispose();
		vComp.setVisible(true);
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
		if (JOptionPane.showConfirmDialog(this,
				"¿Seguro que desea identificar a este resto? Es una acción irreversible.", "Confirmar identificación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
			datos.agregarIdentificado(codResto, dni);
			button.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Resto identificado correctamente.", "Identificación realizada",
					JOptionPane.CLOSED_OPTION);
		}
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
}
