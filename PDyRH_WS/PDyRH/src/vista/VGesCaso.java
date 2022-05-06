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
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.DataFactoryGestCaso;
import controlador.interfaces.ContDatosGestCaso;
import modelo.clases.Caso;
import modelo.clases.Participante;
import modelo.clases.RestoHumano;
import javax.swing.JRadioButton;

public class VGesCaso extends JDialog implements ContDatosGestCaso, ActionListener {
	private static final long serialVersionUID = 1L;

	// <--- Datos BD --->
	ContDatosGestCaso datos = DataFactoryGestCaso.getDatos();

	// <--- Elementos --->
	private static Point point = new Point();
	private JTabbedPane tabbedPane;
	private JPanel contentDatos;
	private JLabel lblCerrar;
	private JSeparator separator2;
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
	private JMenu menUsuario;
	private JMenuItem mCerrar2;
	private JMenuItem mCerrar;
	private JMenu menuInsertar;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JSeparator separatorGesPer;
	private JLabel lblGesPer;
	private JLabel lblAnaInv;
	private JSeparator separatorAnaCono;
	private Button buttonAgregar;
	private String[] info;
	private Button buttonMod;
	private Button buttonEliminar;
	private String dni;
	private VIniciarSesion padre;
	private JSeparator separator1;
	
	// <--- Ejecución --->
	public VGesCaso(VIniciarSesion padre, boolean modal, Caso caso, String[] infos) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 607, 399);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.padre = padre;
		
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
		separator2.setBounds(1, 45, 601, 2);
		contentDatos.add(separator2);

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

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuInsertar.setForeground(Color.WHITE);
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuGestionar.setForeground(Color.WHITE);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuComparar.setForeground(Color.WHITE);
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBusqueda.setForeground(Color.WHITE);
		menuBar.add(menuBusqueda);
		
		lblDni = new JLabel("C\u00D3DIGO");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(76, 94, 81, 28);
		contentDatos.add(lblDni);

		separatorCod = new JSeparator();
		separatorCod.setForeground(SystemColor.controlShadow);
		separatorCod.setBackground(new Color(0, 51, 102));
		separatorCod.setBounds(76, 120, 106, 2);
		contentDatos.add(separatorCod);

		textCod = new JTextField();
		textCod.setToolTipText("");
		textCod.setEditable(false);
		textCod.setEnabled(false);
		textCod.setColumns(10);
		textCod.setBounds(76, 133, 187, 20);
		contentDatos.add(textCod);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(76, 152, 81, 28);
		contentDatos.add(lblNombre);

		separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(76, 178, 106, 2);
		contentDatos.add(separatorNom);

		textNom = new JTextField();
		textNom.setToolTipText("");
		textNom.setColumns(10);
		textNom.setBounds(76, 191, 187, 20);
		contentDatos.add(textNom);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(new Color(0, 51, 102));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setBounds(76, 220, 81, 28);
		contentDatos.add(lblEstado);

		separatorEstado = new JSeparator();
		separatorEstado.setForeground(SystemColor.controlShadow);
		separatorEstado.setBackground(new Color(0, 51, 102));
		separatorEstado.setBounds(76, 246, 106, 2);
		contentDatos.add(separatorEstado);
		
		textFechaIni = new JTextField();
		textFechaIni.setToolTipText("");
		textFechaIni.setVisible(false);
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(314, 170, 187, 20);
		contentDatos.add(textFechaIni);

		textFechaFin = new JTextField();
		textFechaFin.setToolTipText("");
		textFechaFin.setVisible(false);
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(314, 228, 187, 20);
		contentDatos.add(textFechaFin);

		separatorFechaIni = new JSeparator();
		separatorFechaIni.setForeground(new Color(0, 0, 102));
		separatorFechaIni.setBackground(new Color(0, 51, 102));
		separatorFechaIni.setVisible(false);
		separatorFechaIni.setBounds(314, 157, 106, 2);
		contentDatos.add(separatorFechaIni);

		lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setForeground(new Color(0, 51, 102));
		lblFechaFin.setVisible(false);
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaFin.setBounds(314, 189, 106, 28);
		contentDatos.add(lblFechaFin);

		separatorFechaFin = new JSeparator();
		separatorFechaFin.setForeground(new Color(0, 0, 102));
		separatorFechaFin.setBackground(new Color(0, 51, 102));
		separatorFechaFin.setVisible(false);
		separatorFechaFin.setBounds(314, 215, 106, 2);
		contentDatos.add(separatorFechaFin);

		lblFechaIni = new JLabel("FECHA INICIO");
		lblFechaIni.setForeground(new Color(0, 51, 102));
		lblFechaIni.setVisible(false);
		lblFechaIni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaIni.setBounds(314, 131, 106, 28);
		contentDatos.add(lblFechaIni);

		separatorGesPer = new JSeparator();
		separatorGesPer.setForeground(new Color(102, 0, 0));
		separatorGesPer.setVisible(false);
		separatorGesPer.setBackground(new Color(153, 0, 0));
		separatorGesPer.setBounds(12, 73, 580, 2);
		contentDatos.add(separatorGesPer);

		lblGesPer = new JLabel("Gesti\u00F3n de Caso");
		lblGesPer.setForeground(SystemColor.textInactiveText);
		lblGesPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGesPer.setBounds(12, 51, 142, 19);
		lblGesPer.setVisible(false);
		contentDatos.add(lblGesPer);

		buttonMod = new Button("MODIFICAR");
		buttonMod.setForeground(Color.WHITE);
		buttonMod.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonMod.setBackground(new Color(153, 0, 0));
		buttonMod.setBounds(169, 307, 89, 28);
		buttonMod.addActionListener(this);
		contentDatos.add(buttonMod);

		buttonEliminar = new Button("DAR BAJA");
		buttonEliminar.setActionCommand("ELIMINAR");
		buttonEliminar.setForeground(Color.WHITE);
		buttonEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonEliminar.setBackground(new Color(153, 0, 0));
		buttonEliminar.setBounds(309, 307, 89, 28);
		buttonEliminar.addActionListener(this);
		contentDatos.add(buttonEliminar);
				
				JRadioButton rdbtnAbi = new JRadioButton("Abierto");
				rdbtnAbi.setOpaque(false);
				rdbtnAbi.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnAbi.setBounds(76, 255, 67, 23);
				contentDatos.add(rdbtnAbi);
				
				JRadioButton rdbtnSR = new JRadioButton("SR");
				rdbtnSR.setOpaque(false);
				rdbtnSR.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnSR.setBounds(214, 255, 46, 23);
				contentDatos.add(rdbtnSR);
				
				JRadioButton rdbtnCer = new JRadioButton("Cerrado");
				rdbtnCer.setOpaque(false);
				rdbtnCer.setFont(new Font("Tahoma", Font.BOLD, 11));
				rdbtnCer.setBounds(145, 255, 71, 23);
				contentDatos.add(rdbtnCer);
				
						imgErtzAO = new JLabel("");
						imgErtzAO.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
						imgErtzAO.setBounds(125, 68, 309, 303);
						contentDatos.add(imgErtzAO);
		
		cargarDatos(dni);

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

		separator2 = new JSeparator();
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		separator2.setBounds(1, 45, 601, 2);
		contentInvo.add(separator2);

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

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuInsertar.setForeground(Color.WHITE);
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuGestionar.setForeground(Color.WHITE);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuComparar.setForeground(Color.WHITE);
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBusqueda.setForeground(Color.WHITE);
		menuBar.add(menuBusqueda);

		lblDniInv = new JLabel("DNI");
		lblDniInv.setForeground(new Color(0, 51, 102));
		lblDniInv.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDniInv.setBounds(62, 151, 81, 28);
		contentInvo.add(lblDniInv);

		separatorDniInv = new JSeparator();
		separatorDniInv.setForeground(new Color(0, 0, 102));
		separatorDniInv.setBackground(new Color(0, 51, 102));
		separatorDniInv.setBounds(62, 177, 106, 2);
		contentInvo.add(separatorDniInv);

		textDniInv = new JTextField();
		textDniInv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textDniInv.setToolTipText("");
		textDniInv.setColumns(10);
		textDniInv.setBounds(62, 190, 187, 20);
		contentInvo.add(textDniInv);

		lblmp = new JLabel("IMPLICACI\u00D3N");
		lblmp.setForeground(new Color(0, 51, 102));
		lblmp.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblmp.setBounds(345, 151, 81, 28);
		contentInvo.add(lblmp);

		separatorImp = new JSeparator();
		separatorImp.setForeground(new Color(0, 0, 102));
		separatorImp.setBackground(new Color(0, 51, 102));
		separatorImp.setBounds(345, 177, 106, 2);
		contentInvo.add(separatorImp);

		textImp = new JTextField();
		textImp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textImp.setToolTipText("");
		textImp.setColumns(10);
		textImp.setBounds(345, 190, 187, 20);
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

		buttonAgregar = new Button("A\u00D1ADIR");
		buttonAgregar.setForeground(Color.WHITE);
		buttonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAgregar.setBackground(new Color(153, 0, 0));
		buttonAgregar.setBounds(248, 268, 89, 28);
		buttonAgregar.setEnabled(false);
		buttonAgregar.addActionListener(this);
		contentInvo.add(buttonAgregar);
		
		JLabel imgErtzAO_1 = new JLabel("");
		imgErtzAO_1.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		imgErtzAO_1.setBounds(142, 68, 309, 303);
		contentInvo.add(imgErtzAO_1);
	}

	private void cargarDatos(String dni) {
		
	}
	
	public void habilitarBoton() {
		if (!textImp.getText().isBlank() && !textDniInv.getText().isBlank()) {
			buttonAgregar.setEnabled(true);
		} else {
			buttonAgregar.setEnabled(false);
		}
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	public void cerrar() {
		VGestion vGest = new VGestion(padre,true,info);
		this.dispose();
		vGest.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void modificarCaso(Caso caso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCaso(String codCaso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarParticipante(Participante par) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarInvolucrado(String codResto, String codCaso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buscarRH(String codResto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
		// TODO Auto-generated method stub
		return null;
	}
}
