package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import java.awt.Button;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class VPrincipal extends JDialog implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	// <--- Elementos --->
	private JPanel contentPane;
	private static Point point = new Point();
	private JMenuItem mCerrar;
	private JLabel lblCerrar;
	private JPanel panelInsert;
	private Button buttonBR;
	private JPanel panelGest;
	private JLabel lblComparar;
	private JLabel imgGest;
	private JMenu menUsuario;
	private JLabel imgInsert;
	private JLabel lblInsert;
	private JLabel lblGestionar;
	private JPanel panelBus;
	private JLabel imgBuscar;
	private JLabel lblBuscar;
	private JPanel panelComp;
	private JLabel imgComparar;
	private JLabel imgErtzAC;
	private VIniciarSesion padre;
	private JSeparator separator;
	private JMenuBar menuBar;
	private JSeparator separator1_1;
	private JSeparator separator1_1_1;
	private JSeparator separator1_1_2;
	private JSeparator separator1_1_3;
	private String[] info;
	
	public VPrincipal(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño ventana --->
		super(padre);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\Ertzaintza3.png"));
		setBackground(Color.WHITE);
		setBounds(100, 100, 607, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.GRAY);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		this.setModal(modal);
		contentPane.setLayout(null);
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
		contentPane.add(lblCerrar);
		
		// Menú superior
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(2, 47, 603, 2);
		contentPane.add(separator);
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPane.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menUsuario.setHorizontalTextPosition(SwingConstants.LEFT);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setBackground(Color.DARK_GRAY);
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
		
		// Botónes principales
		panelInsert = new JPanel();
		panelInsert.setBorder(null);
		panelInsert.setBackground(SystemColor.control);
		panelInsert.setBounds(102, 59, 150, 143);
		contentPane.add(panelInsert);
		panelInsert.setLayout(null);
		
		imgInsert = new JLabel("New label");
		imgInsert.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/la2(1).png")));
		imgInsert.setBounds(40, 11, 73, 80);
		panelInsert.add(imgInsert);
		
		lblInsert = new JLabel("INSERTAR");
		lblInsert.setFont(new Font("Verdana", Font.BOLD, 14));
		lblInsert.setForeground(new Color(0, 51, 102));
		lblInsert.setBounds(27, 102, 90, 14);
		panelInsert.add(lblInsert);
		
		separator1_1 = new JSeparator();
		separator1_1.setBounds(0, 141, 150, 2);
		panelInsert.add(separator1_1);
		separator1_1.setForeground(new Color(102, 0, 0));
		separator1_1.setBackground(new Color(153, 0, 0));
		
		panelGest = new JPanel();
		panelGest.setBorder(null);
		panelGest.setBackground(SystemColor.control);
		panelGest.setBounds(358, 59, 150, 143);
		contentPane.add(panelGest);
		panelGest.setLayout(null);
		
		imgGest = new JLabel("New label");
		imgGest.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/eng2(1).png")));
		imgGest.setBounds(39, 11, 73, 80);
		panelGest.add(imgGest);
		
		lblGestionar = new JLabel("GESTIONAR");
		lblGestionar.setForeground(new Color(0, 51, 102));
		lblGestionar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblGestionar.setBounds(29, 102, 100, 14);
		panelGest.add(lblGestionar);
		
		separator1_1_1 = new JSeparator();
		separator1_1_1.setForeground(new Color(102, 0, 0));
		separator1_1_1.setBackground(new Color(153, 0, 0));
		separator1_1_1.setBounds(0, 141, 150, 2);
		panelGest.add(separator1_1_1);
		
		// En caso de ser un agente inhabilitar insercción y gestión
		if (info[2].equalsIgnoreCase("agente")) {
			panelInsert.setBackground(Color.GRAY);
			lblInsert.setForeground(Color.LIGHT_GRAY);
			imgInsert.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/lapB.png")));
			panelGest.setBackground(Color.GRAY);
			lblGestionar.setForeground(Color.LIGHT_GRAY);
			imgGest.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/engB.png")));
		}else {
			panelInsert.addMouseListener(this);
			panelGest.addMouseListener(this);
		}
		
		panelBus = new JPanel();
		panelBus.setLayout(null);
		panelBus.setBorder(null);
		panelBus.setBackground(SystemColor.control);
		panelBus.setBounds(102, 238, 150, 143);
		panelBus.addMouseListener(this);
		contentPane.add(panelBus);
		
		imgBuscar = new JLabel("New label");
		imgBuscar.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/lu2(1).png")));
		imgBuscar.setBounds(40, 11, 73, 80);
		panelBus.add(imgBuscar);
		
		lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setForeground(new Color(0, 51, 102));
		lblBuscar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBuscar.setBounds(40, 102, 73, 14);
		panelBus.add(lblBuscar);
		
		separator1_1_2 = new JSeparator();
		separator1_1_2.setBounds(0, 141, 150, 2);
		panelBus.add(separator1_1_2);
		separator1_1_2.setForeground(new Color(102, 0, 0));
		separator1_1_2.setBackground(new Color(153, 0, 0));
		
		panelComp = new JPanel();
		panelComp.setLayout(null);
		panelComp.setBorder(null);
		panelComp.setBackground(SystemColor.control);
		panelComp.setBounds(358, 238, 150, 143);
		panelComp.addMouseListener(this);
		contentPane.add(panelComp);
		
		imgComparar = new JLabel("New label");
		imgComparar.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/co2(1).png")));
		imgComparar.setBounds(43, 11, 73, 80);
		panelComp.add(imgComparar);
		
		lblComparar = new JLabel("COMPARAR");
		lblComparar.setForeground(new Color(0, 51, 102));
		lblComparar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblComparar.setBounds(30, 102, 90, 14);
		panelComp.add(lblComparar);
		
		separator1_1_3 = new JSeparator();
		separator1_1_3.setBounds(0, 141, 150, 2);
		panelComp.add(separator1_1_3);
		separator1_1_3.setForeground(new Color(102, 0, 0));
		separator1_1_3.setBackground(new Color(153, 0, 0));
		
		buttonBR = new Button("Busq. rap.");
		buttonBR.setFocusable(false);
		buttonBR.addActionListener(this);
		buttonBR.setForeground(new Color(255, 255, 255));
		buttonBR.setBackground(new Color(153, 0, 0));
		buttonBR.setBounds(527, 367, 70, 22);
		contentPane.add(buttonBR);
		
		// Fondo
		imgErtzAC = new JLabel("New label");
		imgErtzAC.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(151, 83, 309, 290);
		contentPane.add(imgErtzAC);
	}

	// <--- Métodos --->
	// Cerrar la ventana
	private void cerrar() {
		this.dispose();
		padre.setVisible(true);
	}
	// Abrir ventanas
	private void vInsertar() {
		panelInsert.setBackground(SystemColor.controlShadow);
		imgInsert.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/laAO.png")));
		lblInsert.setForeground(new Color(0, 0, 51));
		VInserciones inserciones = new VInserciones(padre, true, info);
		this.dispose();
		inserciones.setVisible(true);
	}

	private void vBusqueda() {
		panelBus.setBackground(SystemColor.controlShadow);
		imgBuscar.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/luAO.png")));
		lblBuscar.setForeground(new Color(0, 0, 51));
		VBusqueda busqueda = new VBusqueda(padre, true, info);
		this.dispose();
		busqueda.setVisible(true);
	}

	private void vGestionar() {
		panelGest.setBackground(SystemColor.controlShadow);
		imgGest.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/engAO.png")));
		lblGestionar.setForeground(new Color(0, 0, 51));
		VGestion gestionar = new VGestion(padre, true, info);
		this.dispose();
		gestionar.setVisible(true);
	}

	private void vComparar() {
		panelComp.setBackground(SystemColor.controlShadow);
		imgComparar.setIcon(new ImageIcon(VPrincipal.class.getResource("/imagenes/coAO.png")));
		lblComparar.setForeground(new Color(0, 0, 51));
		VComparacion comparar = new VComparacion(padre, true, info);
		this.dispose();
		comparar.setVisible(true);
	}
	
	private void vBusRapida() {
		VBusRapida busRap = new VBusRapida(padre, true, info);
		this.dispose();
		busRap.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
			cerrar();
		}else if (e.getSource().equals(buttonBR)) {
			vBusRapida();
		}
	}
	
	// Eventos de ratón
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(panelInsert)) {
			vInsertar();
		}else if (e.getSource().equals(panelGest)) {
			vGestionar();
		}else if (e.getSource().equals(panelBus)) {
			vBusqueda();
		}else if (e.getSource().equals(panelComp)) {
			vComparar();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(panelInsert)) {
			vInsertar();
		}else if (e.getSource().equals(panelGest)) {
			vGestionar();
		}else if (e.getSource().equals(panelBus)) {
			vBusqueda();
		}else if (e.getSource().equals(panelComp)) {
			vComparar();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		((JComponent) e.getSource()).setBackground(SystemColor.control);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		((JComponent) e.getSource()).setBorder(new LineBorder(Color.DARK_GRAY));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JComponent) e.getSource()).setBorder(null);
	}
}
