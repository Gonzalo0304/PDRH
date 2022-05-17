package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.SystemColor;

public class VInserciones extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VIniciarSesion padre;
	private JSeparator separatorMenu;
	private Button btnPersona;
	private Button btnRestoHumano;
	private Button btnCaso;
	private JMenuBar menuBar;
	private String[] info;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JLabel imgErtzAO;
	private JLabel lblBus;
	private JSeparator separatorIns;
	private static Point point = new Point();
	private JLabel lblCerrar;

	/**
	 * Es el constructor de la venta.
	 * @param padre es la ventana padre de esta.
	 * @param modal es el valor del modal para dasabilitar la ventana anterior
	 * @param infos es la informacion del usuario
	 */
	public VInserciones(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Insertar");
		setBounds(100, 100, 607, 399);
		contentPanel.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		info = infos;
		this.padre = padre;
		
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
		contentPanel.add(lblCerrar);
		
		// Menú superior y título
		separatorMenu = new JSeparator();
		separatorMenu.setBackground(Color.DARK_GRAY);
		separatorMenu.setBounds(2, 47, 603, 2);
		contentPanel.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPanel.add(menuBar);

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

		btnPersona = new Button("PERSONA");
		btnPersona.setBackground(new Color(153, 0, 0));
		btnPersona.setForeground(Color.WHITE);
		btnPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		btnPersona.setBounds(93, 153, 168, 42);
		btnPersona.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(btnPersona);

		btnRestoHumano = new Button("RESTO HUMANO");
		btnRestoHumano.setBackground(new Color(153, 0, 0));
		btnRestoHumano.setForeground(Color.WHITE);
		btnRestoHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		btnRestoHumano.setBounds(340, 153, 168, 42);
		btnRestoHumano.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(btnRestoHumano);

		btnCaso = new Button("CASO");
		btnCaso.setBackground(new Color(153, 0, 0));
		btnCaso.setForeground(Color.WHITE);
		btnCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		btnCaso.setBounds(221, 252, 168, 42);
		btnCaso.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(btnCaso);
		
		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon(VInserciones.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO.setBounds(155, 85, 309, 303);
		contentPanel.add(imgErtzAO);
		
		lblBus = new JLabel("Men\u00FA de Inserci\u00F3n");
		lblBus.setForeground(SystemColor.textInactiveText);
		lblBus.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblBus.setBounds(24, 60, 132, 19);
		contentPanel.add(lblBus);
		
		separatorIns = new JSeparator();
		separatorIns.setForeground(new Color(102, 0, 0));
		separatorIns.setBackground(new Color(153, 0, 0));
		separatorIns.setBounds(24, 82, 561, 2);
		contentPanel.add(separatorIns);
	}
	
	//Metodos para cerrar y abrir otras ventanas de inserciones
	/**
	 * Cierra la ventana actual y abre la anterior
	 */
	private void cerrar() {
		VPrincipal principal = new VPrincipal(padre, true, info);
		this.dispose();
		principal.setVisible(true);
	}
	
	/**
	 * Cierra la ventana actual y abre la ventana de insercion de casos
	 */
	private void insertarCaso() {
		VInsCaso caso = new VInsCaso(padre, true, info);
		this.dispose();
		caso.setVisible(true);
	}
	
	/**
	 * Cierra la ventana actual y abre la ventana de insercion de restos humanos
	 */
	private void insertarRestoHumano() {
		VInsRH restoHumano = new VInsRH(padre, true, null, info,false);
		this.dispose();
		restoHumano.setVisible(true);
	}

	/**
	 * Cierra la ventana actual y abre la ventana de insercion de personas
	 */
	private void insertarPersona() {
		VInsPersona persona = new VInsPersona(padre, true, info);
		this.dispose();
		persona.setVisible(true);
	}
	
	//Eventos
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
	 * Abrir ventana de gestion desde JMenuBar 
	 */
	private void abrirGes() {
		VGestion vBus = new VGestion(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}
	
	/**
	 * Abrir ventana de comparacion desde JMenuBar 
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre,true,info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Abrir ventana de busqueda desde JMenuBar 
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de restos humanos desde JMenuBar 
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre,true,null,info,false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de personas desde JMenuBar 
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre,true,info);
		this.dispose();
		vInsPer.setVisible(true);		
	}

	/**
	 * Abrir ventana de insercion de casos desde JMenuBar 
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre,true,info);
		this.dispose();
		vInsCaso.setVisible(true);
	}
}