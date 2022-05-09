package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controlador.ContDatosInsertCaso;
import controlador.DataFactoryInsertCaso;
import controlador.interfaces.ContDatosBusq;
import modelo.ContBDImpleInsertCaso;
import modelo.clases.Caso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;

public class VInsCaso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textFechaIni;
	private JTextField textFechaFin;
	private Button btnAnadir;
	private ButtonGroup estado = new ButtonGroup();
	private VIniciarSesion vInicio = null;
	private JRadioButton rdbtnAbierto;
	private JRadioButton rdbtnCerrado;
	private JRadioButton rdbtnSinResolver;
	private ContDatosBusq datos;
	private String[] info;
	
	ContDatosInsertCaso datos1 = (ContDatosInsertCaso) DataFactoryInsertCaso.getDatos();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VInsCaso dialog = new VInsCaso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * Create the dialog.
	 * @param modal 
	 * @param vInserciones 
	 */
	/*public VInsCaso() {
		
		setBounds(100, 100, 449, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		btnAnadir = new Button("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}

		});
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(new Color(255, 255, 255));
		btnAnadir.setBounds(334, 279, 83, 32);
		btnAnadir.setBackground(new Color(122, 42, 42));
		contentPanel.add(btnAnadir);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(52, 80, 46, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(52, 123, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblCodigo = new JLabel("Nombre");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(52, 161, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Fecha Inicio");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(35, 196, 73, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaFinal.setBounds(35, 232, 73, 14);
		contentPanel.add(lblFechaFinal);
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(120, 81, 157, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnAbierto.setBackground(new Color(255, 255, 255));
		rdbtnAbierto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAbierto.setBounds(108, 120, 73, 23);
		estado.add(rdbtnAbierto);
		contentPanel.add(rdbtnAbierto);
		rdbtnAbierto.setOpaque(false);
		
		rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnCerrado.setBackground(new Color(255, 255, 255));
		rdbtnCerrado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCerrado.setBounds(183, 120, 73, 23);
		estado.add(rdbtnCerrado);
		contentPanel.add(rdbtnCerrado);
		rdbtnCerrado.setOpaque(false);
		
		rdbtnSinResolver = new JRadioButton("Sin resolver");
		rdbtnSinResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnSinResolver.setBackground(new Color(255, 255, 255));
		rdbtnSinResolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSinResolver.setBounds(270, 120, 93, 23);
		estado.add(rdbtnSinResolver);
		contentPanel.add(rdbtnSinResolver);
		rdbtnSinResolver.setOpaque(false);
		
		textNombre = new JTextField();
		textNombre.setBounds(120, 159, 157, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(120, 194, 157, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(120, 230, 157, 20);
		contentPanel.add(textFechaFin);
		
		JLabel lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				volver();
			}
		});
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBackground(new Color(0, 51, 153));
		lblNewLabel_9.setBounds(404, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setForeground(Color.WHITE);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(Color.BLUE);
		menuBar.add(menuInsertar);
		
		JMenuItem mnitInsPer = new JMenuItem("Persona");
		menuInsertar.add(mnitInsPer);
		
		JMenuItem mnitInsRH = new JMenuItem("Resto Humano");
		menuInsertar.add(mnitInsRH);
		
		JMenuItem mnitInsCaso = new JMenuItem("Caso");
		menuInsertar.add(mnitInsCaso);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setForeground(Color.WHITE);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(Color.BLUE);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setForeground(Color.WHITE);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 51, 102));
		menuBar.add(menuComparar);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setForeground(Color.WHITE);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(Color.BLUE);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setForeground(Color.WHITE);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(Color.BLUE);
		menuBar.add(menUsuario);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setForeground(Color.BLACK);
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setBackground(new Color(32, 178, 170));
		menUsuario.add(mCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 36, 450, 300);
		contentPanel.add(lblNewLabel_1);
		
	}
	*/
	public VInsCaso(VIniciarSesion vInicio, boolean modal) {
		super(vInicio);
		this.setModal(modal);
		
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		btnAnadir = new Button("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}

		});
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(new Color(255, 255, 255));
		btnAnadir.setBounds(456, 321, 120, 48);
		btnAnadir.setBackground(new Color(122, 42, 42));
		contentPanel.add(btnAnadir);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(163, 113, 46, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(163, 156, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblCodigo = new JLabel("Nombre");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(163, 194, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Fecha Inicio");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(146, 229, 73, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaFinal.setBounds(146, 265, 73, 14);
		contentPanel.add(lblFechaFinal);
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(231, 114, 157, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnAbierto.setBackground(new Color(255, 255, 255));
		rdbtnAbierto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAbierto.setBounds(219, 153, 73, 23);
		estado.add(rdbtnAbierto);
		contentPanel.add(rdbtnAbierto);
		rdbtnAbierto.setOpaque(false);
		
		rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnCerrado.setBackground(new Color(255, 255, 255));
		rdbtnCerrado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCerrado.setBounds(294, 153, 73, 23);
		estado.add(rdbtnCerrado);
		contentPanel.add(rdbtnCerrado);
		rdbtnCerrado.setOpaque(false);
		
		rdbtnSinResolver = new JRadioButton("Sin resolver");
		rdbtnSinResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnSinResolver.setBackground(new Color(255, 255, 255));
		rdbtnSinResolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSinResolver.setBounds(381, 153, 93, 23);
		estado.add(rdbtnSinResolver);
		contentPanel.add(rdbtnSinResolver);
		rdbtnSinResolver.setOpaque(false);
		
		textNombre = new JTextField();
		textNombre.setBounds(231, 192, 157, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(231, 227, 157, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(231, 263, 157, 20);
		contentPanel.add(textFechaFin);
		
		JLabel lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				volver();
			}
		});
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBackground(new Color(0, 51, 153));
		lblNewLabel_9.setBounds(561, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 607, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setForeground(Color.WHITE);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(Color.BLUE);
		menuBar.add(menuInsertar);
		
		JMenuItem mnitInsPer = new JMenuItem("Persona");
		mnitInsPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		menuInsertar.add(mnitInsPer);
		
		JMenuItem mnitInsRH = new JMenuItem("Resto Humano");
		mnitInsRH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		menuInsertar.add(mnitInsRH);
		
		JMenuItem mnitInsCaso = new JMenuItem("Caso");
		mnitInsCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		menuInsertar.add(mnitInsCaso);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestionar();
			}
		});
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setForeground(Color.WHITE);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(Color.BLUE);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comparar();
			}
		});
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setForeground(Color.WHITE);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 51, 102));
		menuBar.add(menuComparar);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setForeground(Color.WHITE);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(Color.BLUE);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setForeground(Color.WHITE);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(Color.BLUE);
		menuBar.add(menUsuario);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setForeground(Color.BLACK);
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setBackground(new Color(32, 178, 170));
		menUsuario.add(mCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 36, 607, 363);
		contentPanel.add(lblNewLabel_1);
		
	}
	
	private void volver() {
		VInserciones insercion = new VInserciones(vInicio, true, info[0]);
		this.dispose();
		insercion.setVisible(true);
	}
	
	private void habilitarBoton() {
		if (!textCodigo.getText().isEmpty() && (rdbtnAbierto.isSelected() || rdbtnCerrado.isSelected() || rdbtnSinResolver.isSelected())) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}
	}
	
	private void insertarCaso() {
		Caso cas = new Caso();
		cas.setCodCaso(textCodigo.getText());
		if(rdbtnAbierto.isSelected()) {
			cas.setEstado(rdbtnAbierto.getText());
		}else if(rdbtnCerrado.isSelected()) {
			cas.setEstado(rdbtnCerrado.getText());
		}else if(rdbtnSinResolver.isSelected()) {
			cas.setEstado(rdbtnSinResolver.getText());
		}
		cas.setNombre(textNombre.getText());
		cas.setFechaIni(stringDate(textFechaIni.getText()));
		cas.setFechaFin(stringDate(textFechaFin.getText()));
		((ContBDImpleInsertCaso)datos1).altaCaso(cas);
		limpiar();
	}
	
	private void limpiar() {
		textCodigo.setText("");
		rdbtnAbierto.setSelected(false);
		rdbtnCerrado.setSelected(false);
		rdbtnSinResolver.setSelected(false);
		textFechaIni.setText("");
		textFechaFin.setText("");
		
	}
	private LocalDate stringDate(String string) {
		LocalDate nacimiento = LocalDate.parse(string);
		return nacimiento;
	}
	
	private void VinsertarCaso() {
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
}
