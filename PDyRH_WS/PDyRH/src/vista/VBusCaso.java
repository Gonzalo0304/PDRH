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

import controlador.DataFactoryBusqCaso;
import controlador.interfaces.ContDatosBusqCaso;
import modelo.clases.RestoHumano;
import modelo.clases.Caso;
import modelo.clases.Participante;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;


/**
 * Esta clase representa la ventana de busqueda de caso junto con el controlador de busqueda
 * @autor Elías
 *
 */

public class VBusCaso extends JDialog implements ContDatosBusqCaso, ActionListener {
	private static final long serialVersionUID = 1L;

	// <--- Datos BD --->
	ContDatosBusqCaso datos = DataFactoryBusqCaso.getDatos();

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
	private JLabel lblCod;
	private JSeparator separatorCod;
	private JTextField textCod;
	private JLabel lblNombre;
	private JSeparator separatorNom;
	private JTextField textNombre;
	private JLabel lblEstado;
	private JSeparator separatorEstado;
	private JTextField textEstado;
	private JLabel lblNac;
	private JSeparator separatorNac;
	private JTextField textNac;
	private JLabel lblFall;
	private JSeparator separatorFall;
	private JTextField textFall;
	private JLabel imgErtzAO;
	private JPanel contentConos;
	private JLabel lblCerrar_1;
	private JSeparator separatorMenu2;
	private JLabel lblImp;
	private JSeparator separatorImp;
	private JTextField textImp;
	private JLabel lblLisInv;
	private JSeparator separatorLisCono;
	private String[] info;
	private Caso caso;
	private VIniciarSesion padre;
	private JLabel lblNomComp;
	private JLabel lblBusPer;
	private JSeparator separatorBus;
	private Map<String, Participante> participantes;
	private Map<String, RestoHumano> involucrados;
	private int posicion = 0;
	private JLabel lblPer;
	private JTextField textCodResto;
	private JSeparator separatorPer;
	private JSeparator separatorRes;
	private JLabel lblRes;
	private JLabel imgErtzAO_1;


	/**
	 * Constructor de la ventana de Busqueda de Caso
	 *
	 * @param padre: Es la ventana de inicio de sesion siendo la principal
	 * @param modal: Sirve para impedir la navegacion de la ventana anterior
	 * @param cas: Es la variable que contiene la clase Caso que obtiene de la clase busqueda
	 * @param infos: Este parametro recibe los datos del usuario que ha iniciado sesion
	 */

	public VBusCaso(VIniciarSesion padre, boolean modal, Caso cas, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Buscar caso");
		setBounds(350, 150, 506, 690);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.padre = padre;
		caso = cas;

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

		lblCod = new JLabel("C\u00D3DIGO");
		lblCod.setForeground(new Color(0, 51, 102));
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCod.setBounds(151, 106, 81, 28);
		contentDatos.add(lblCod);

		// Campos de información de persona
		separatorCod = new JSeparator();
		separatorCod.setForeground(SystemColor.controlShadow);
		separatorCod.setBackground(new Color(0, 51, 102));
		separatorCod.setBounds(151, 132, 106, 2);
		contentDatos.add(separatorCod);

		textCod = new JTextField();
		textCod.setEnabled(false);
		textCod.setColumns(10);
		textCod.setBounds(151, 145, 187, 20);
		contentDatos.add(textCod);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(151, 205, 81, 28);
		contentDatos.add(lblNombre);

		separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(151, 231, 106, 2);
		contentDatos.add(separatorNom);

		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setColumns(10);
		textNombre.setBounds(151, 244, 187, 20);
		contentDatos.add(textNombre);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(new Color(0, 51, 102));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setBounds(151, 308, 81, 28);
		contentDatos.add(lblEstado);

		separatorEstado = new JSeparator();
		separatorEstado.setForeground(SystemColor.controlShadow);
		separatorEstado.setBackground(new Color(0, 51, 102));
		separatorEstado.setBounds(151, 334, 106, 2);
		contentDatos.add(separatorEstado);

		textEstado = new JTextField();
		textEstado.setEnabled(false);
		textEstado.setColumns(10);
		textEstado.setBounds(151, 347, 187, 20);
		contentDatos.add(textEstado);

		lblNac = new JLabel("INICIO");
		lblNac.setForeground(new Color(0, 51, 102));
		lblNac.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNac.setBounds(151, 420, 81, 28);
		contentDatos.add(lblNac);

		separatorNac = new JSeparator();
		separatorNac.setForeground(SystemColor.controlShadow);
		separatorNac.setBackground(new Color(0, 51, 102));
		separatorNac.setBounds(151, 446, 106, 2);
		contentDatos.add(separatorNac);

		textNac = new JTextField();
		textNac.setEnabled(false);
		textNac.setColumns(10);
		textNac.setBounds(151, 459, 187, 20);
		contentDatos.add(textNac);

		lblFall = new JLabel("FIN");
		lblFall.setForeground(new Color(0, 51, 102));
		lblFall.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFall.setBounds(151, 536, 106, 28);
		contentDatos.add(lblFall);

		separatorFall = new JSeparator();
		separatorFall.setForeground(SystemColor.controlShadow);
		separatorFall.setBackground(new Color(0, 51, 102));
		separatorFall.setBounds(151, 562, 106, 2);
		contentDatos.add(separatorFall);

		textFall = new JTextField();
		textFall.setEnabled(false);
		textFall.setColumns(10);
		textFall.setBounds(151, 575, 187, 20);
		contentDatos.add(textFall);

		// Fondo
		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon(VGesPersona.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO.setBounds(89, 206, 309, 317);
		contentDatos.add(imgErtzAO);

		separatorBus = new JSeparator();
		separatorBus.setForeground(new Color(102, 0, 0));
		separatorBus.setBackground(new Color(153, 0, 0));
		separatorBus.setBounds(10, 64, 478, 2);
		contentDatos.add(separatorBus);
		
		lblBusPer = new JLabel("B\u00FAsqueda de Caso");
		lblBusPer.setForeground(SystemColor.textInactiveText);
		lblBusPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblBusPer.setBounds(10, 42, 160, 19);
		contentDatos.add(lblBusPer);

		cargarDatos(caso);

		// <--- Pestaña 2 --->
		contentConos = new JPanel();
		contentConos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentConos.setBackground(Color.WHITE);
		tabbedPane.addTab("Involucrados", null, contentConos, null);

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
		
		// Mostrar Involucrados
		participantes = listarParticipantes(caso.getCodCaso());
		for (Participante par : participantes.values()) {
			if (posicion == 0) {
				lblPer = new JLabel("PERSONAS");
				lblPer.setForeground(new Color(0, 51, 102));
				lblPer.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblPer.setBounds(20, 77, 71, 14);
				contentConos.add(lblPer);
				
				separatorPer = new JSeparator();
				separatorPer.setBounds(21, 92, 106, 2);
				separatorPer.setForeground(SystemColor.controlShadow);
				separatorPer.setBackground(new Color(0, 51, 102));
				contentConos.add(separatorPer);
			}
			lblImp = new JLabel("IMPLICACI\u00D3N");
			lblImp.setBounds(25, 104 + posicion, 81, 28);
			lblImp.setForeground(new Color(153, 0, 0));
			lblImp.setFont(new Font("Tahoma", Font.BOLD, 10));
			contentConos.add(lblImp);
			
			separatorImp = new JSeparator();
			separatorImp.setBounds(25, 128 + posicion, 106, 2);
			separatorImp.setForeground(SystemColor.controlShadow);
			separatorImp.setBackground(new Color(153, 0, 0));
			contentConos.add(separatorImp);
			
			textImp = new JTextField();
			textImp.setEditable(false);
			textImp.setBounds(25, 138 + posicion, 187, 20);
			textImp.setColumns(10);
			textImp.setText(par.getImplicacion());
			contentConos.add(textImp);
			
			lblNomComp = new JLabel(par.getNomComp());
			lblNomComp.setBounds(23, 99 + posicion, 438, 14);
			lblNomComp.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNomComp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					abrirBusPer(par.getDni());
				}
			});
			contentConos.add(lblNomComp);
			
			posicion = posicion + 76;
		}
		involucrados = listarInvolucrados(caso.getCodCaso());
		int pos = posicion;
		for (RestoHumano res : involucrados.values()) {
			if (posicion == pos) {
				lblRes = new JLabel("RESTOS");
				lblRes.setForeground(new Color(0, 51, 102));
				lblRes.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblRes.setBounds(20, posicion + 94, 71, 14);
				contentConos.add(lblRes);
				
				separatorRes = new JSeparator();
				separatorRes.setBounds(21, 108 + posicion, 106, 2);
				separatorRes.setForeground(SystemColor.controlShadow);
				separatorRes.setBackground(new Color(0, 51, 102));
				contentConos.add(separatorRes);
			}
			textCodResto = new JTextField(res.getCodResto());
			textCodResto.setBounds(23, 115 + posicion, 187, 20);
			textCodResto.setEditable(false);
			textCodResto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					abrirBusRH(res.getCodResto());
				}
			});
			contentConos.add(textCodResto);
			
			posicion = posicion + 30;
		}
		
		lblLisInv = new JLabel("Lista Involucrados");
		lblLisInv.setBounds(10, 42, 142, 19);
		lblLisInv.setForeground(SystemColor.textInactiveText);
		lblLisInv.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentConos.add(lblLisInv);

		separatorLisCono = new JSeparator();
		separatorLisCono.setBounds(10, 64, 464, 2);
		separatorLisCono.setForeground(new Color(102, 0, 0));
		separatorLisCono.setBackground(new Color(153, 0, 0));
		contentConos.add(separatorLisCono);
		
		imgErtzAO_1 = new JLabel("");
		imgErtzAO_1.setIcon(new ImageIcon(VBusCaso.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO_1.setBounds(96, 210, 309, 317);
		contentConos.add(imgErtzAO_1);
	}

	/**
	 * Metodo para cargar los datos de caso.
	 *
	 * @param cas: variable que contiene los datos la clase caso y se utilizara para recoger la informacion de sus atributos.
	 *
	 * Muestra los datos que contiene la clase caso en los textField(campos) y  
	 * en las fechas se controla que si no esta vacio que muestre la informacion en su campo correspondiente.
	 */
	// Cargar la información
	private void cargarDatos(Caso cas) {
		textCod.setText(cas.getCodCaso());
		textNombre.setText(cas.getNombre());
		textEstado.setText(cas.getEstado());
		if (cas.getFechaIni() != null) {
			textNac.setText(cas.getFechaIni().toString());
		}
		if (cas.getFechaFin() != null) {
			textFall.setText(cas.getFechaFin().toString());
		}
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
	
	// Abrir ventanas de menú
	/**
	 *  Metodo para abrir la ventana de Gestion.
	 * Se realiza al pulsar en la barra de menú el botón 'Gestionar'.
	 */
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
	 * Metodo para abrir la ventana de insercion de restos humanos.
	 *
	 * Funciona al pulsar en la barra de menu el boton 'Insertar' en la que
	 * Despliegara tres opciones para pulsar y este método se realiza en 'Resto Humano'
	 */

	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre,true,null,info,false);
		this.dispose();
		vInsRH.setVisible(true);
	}


	/**
	 * Método para abrir la ventana de inserción de personas.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar' y en 'Persona'.
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre,true,info);
		this.dispose();
		vInsPer.setVisible(true);		
	}

	/**
	 *Metodo para abrir la ventana de insercion de casos.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar' y en 'Caso'.
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre,true,info);
		this.dispose();
		vInsCaso.setVisible(true);
	}	

	/**
	 * Metodo para abrir la ventana que muestra los datos de la persona.
	 *
	 * @param dni: esta variable contiene el dni de la clase Persona.
	 *
	 * Funciona al pulsar el nombre de la persona que aparece en la pestaña de involucrados.
	 */
	private void abrirBusPer(String dni) {
		VBusPer vBusPer = new VBusPer(padre, true, dni, info);
		this.dispose();
		vBusPer.setVisible(true);
	}
	

	/**
	 * Metodo para abrir la ventana que muestra los datos de los restos humanos
	 *
	 * @param codigo: esta variable contiene el codigo del resto humano que recibe del constructor.
	 *
	 * Funciona al pulsar el código del resto que aparece en la pestaña involucrada para visualizar la información.
	 */

	private void abrirBusRH(String codigo) {
		VBusRH vBusRH = new VBusRH(padre, true, codigo, info);
		this.dispose();
		vBusRH.setVisible(true);
	}

	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		return datos.listarParticipantes(codCaso);
	}

	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
		return datos.listarInvolucrados(codCaso);
	}
}
