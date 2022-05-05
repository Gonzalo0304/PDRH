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

import controlador.ContDatosInsertPer;
import controlador.ContDatosRH;
import modelo.ContBDImpleInsertPer;
import modelo.ContBDImpleRH;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VInsRH extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textCausa;
	private JTextField textFecha;
	private JTextField textUbicacion;
	private JTextField textTipoP;
	private JTextField textColorP;
	private JTextField textAltura;
	private JTextField textEspecificaciones;
	private JButton btnAnadir;
	private JComboBox comboBox;
	private JTextField textColorO;
	private ContDatosRH datos1;
	private VIniciarSesion vInicio = null;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VInsRH dialog = new VInsRH();
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
	 * @param inserciones 
	 */
	
	/*public VInsRH() {
		
		setTitle("Insertar Resto Humano");
		setBounds(100, 100, 479, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 70, 46, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCausa = new JLabel("Causa");
		lblCausa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCausa.setBounds(61, 106, 46, 14);
		contentPanel.add(lblCausa);
		
		JLabel lblCodigo = new JLabel("Fecha");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(61, 141, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUbicacion.setBounds(46, 166, 61, 14);
		contentPanel.add(lblUbicacion);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(61, 203, 46, 14);
		contentPanel.add(lblGenero);
		
		JLabel lblTipoDePelo = new JLabel("Tipo de pelo");
		lblTipoDePelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDePelo.setBounds(36, 236, 71, 14);
		contentPanel.add(lblTipoDePelo);
		
		JLabel lblNewLabel_6 = new JLabel("Color de pelo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(36, 271, 85, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Altura");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(65, 331, 52, 14);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Especificaciones");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_2.setBounds(22, 362, 95, 14);
		contentPanel.add(lblNewLabel_6_2);
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(125, 71, 180, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCausa = new JTextField();
		textCausa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCausa.setColumns(10);
		textCausa.setBounds(125, 104, 180, 20);
		contentPanel.add(textCausa);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 135, 180, 20);
		contentPanel.add(textFecha);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(125, 164, 180, 20);
		contentPanel.add(textUbicacion);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Hombre", "Mujer"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(125, 195, 180, 22);
		contentPanel.add(comboBox);
		
		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(125, 234, 180, 20);
		contentPanel.add(textTipoP);
		
		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(125, 265, 180, 20);
		contentPanel.add(textColorP);
		
		textColorO = new JTextField();
		textColorO.setColumns(10);
		textColorO.setBounds(125, 296, 180, 20);
		contentPanel.add(textColorO);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(125, 329, 180, 20);
		contentPanel.add(textAltura);
		
		textEspecificaciones = new JTextField();
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(125, 360, 180, 20);
		contentPanel.add(textEspecificaciones);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaRH();
			}
		});
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setEnabled(false);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(346, 368, 89, 32);
		contentPanel.add(btnAnadir);
		
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
		lblNewLabel_9.setBounds(433, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 479, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertar();
			}
		});
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		menuInsertar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Resto Humano");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		menuInsertar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Caso");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		menuInsertar.add(mntmNewMenuItem_2);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestionar();
			}
		});
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comparar();
			}
		});
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("Color de ojos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(36, 298, 81, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 36, 479, 386);
		contentPanel.add(lblNewLabel_2);
	}
	*/
	public VInsRH(VIniciarSesion vInicio, boolean modal) {
		super(vInicio);
		this.setModal(modal);
		
		setTitle("Insertar Resto Humano");
		setBounds(100, 100, 479, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 70, 46, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCausa = new JLabel("Causa");
		lblCausa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCausa.setBounds(61, 106, 46, 14);
		contentPanel.add(lblCausa);
		
		JLabel lblCodigo = new JLabel("Fecha");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(61, 141, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUbicacion.setBounds(46, 166, 61, 14);
		contentPanel.add(lblUbicacion);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(61, 203, 46, 14);
		contentPanel.add(lblGenero);
		
		JLabel lblTipoDePelo = new JLabel("Tipo de pelo");
		lblTipoDePelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDePelo.setBounds(36, 236, 71, 14);
		contentPanel.add(lblTipoDePelo);
		
		JLabel lblNewLabel_6 = new JLabel("Color de pelo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(36, 271, 85, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Altura");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(65, 331, 52, 14);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Especificaciones");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_2.setBounds(22, 362, 95, 14);
		contentPanel.add(lblNewLabel_6_2);
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(125, 71, 180, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCausa = new JTextField();
		textCausa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCausa.setColumns(10);
		textCausa.setBounds(125, 104, 180, 20);
		contentPanel.add(textCausa);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 135, 180, 20);
		contentPanel.add(textFecha);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(125, 164, 180, 20);
		contentPanel.add(textUbicacion);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Hombre", "Mujer"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(125, 195, 180, 22);
		contentPanel.add(comboBox);
		
		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(125, 234, 180, 20);
		contentPanel.add(textTipoP);
		
		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(125, 265, 180, 20);
		contentPanel.add(textColorP);
		
		textColorO = new JTextField();
		textColorO.setColumns(10);
		textColorO.setBounds(125, 296, 180, 20);
		contentPanel.add(textColorO);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(125, 329, 180, 20);
		contentPanel.add(textAltura);
		
		textEspecificaciones = new JTextField();
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(125, 360, 180, 20);
		contentPanel.add(textEspecificaciones);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaRH();
			}
		});
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setEnabled(false);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(343, 389, 114, 45);
		contentPanel.add(btnAnadir);
		
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
		lblNewLabel_9.setBounds(433, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 479, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Persona");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		menuInsertar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Resto Humano");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		menuInsertar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Caso");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		menuInsertar.add(mntmNewMenuItem_2);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestionar();
			}
		});
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comparar();
			}
		});
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("Color de ojos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(36, 298, 81, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 36, 479, 424);
		contentPanel.add(lblNewLabel_2);
	}
	
	
	private void volver() {
		VInserciones insertar = new VInserciones(vInicio, true);
		this.dispose();
		insertar.setVisible(true);
		
	}
	
	private void altaRH() {
		RestoHumano rh = new RestoHumano();
		rh.setCodResto(textCodigo.getText());
		rh.setCausa(textCausa.getText());
		rh.setFechaMuerte(stringDate(textFecha.getText()));
		rh.setUbicacion(textUbicacion.getText());
		rh.setGenero(comboBox.getSelectedItem().toString());
		rh.setTipoPelo(textTipoP.getText());
		rh.setColorPelo(textColorP.getText());
		rh.setColorOjos(textColorO.getText());
		rh.setAltura(stringInt(textAltura.getText()));
		rh.setEspecificaciones(textEspecificaciones.getText());
		((ContBDImpleRH) datos1).altaRH(rh);
		limpiar();
		habilitarBoton();
	}
	
	private LocalDate stringDate(String string) {
		LocalDate nacimiento = LocalDate.parse(string);
		return nacimiento;
	}
	
	private int stringInt(String string) {
		int altura = Integer.parseInt(string);
		return altura;
	}
	
	private void habilitarBoton() {
		if (!textCodigo.getText().isEmpty() && !textCausa.getText().isEmpty()) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}
	}
	
	private void insertarCaso() {
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
		VGestion gestion = new VGestion(vInicio, true);
		this.dispose();
		gestion.setVisible(true);
	}
	
	private void comparar() {
		VComparacion comparacion = new VComparacion(vInicio, true);
		this.dispose();
		comparacion.setVisible(true);
	}

	private void buscar() {
		VBusqueda busqueda = new VBusqueda(vInicio, true);
		this.dispose();
		busqueda.setVisible(true);
	}
	
	private void insertar() {
		VInserciones insertar = new VInserciones(vInicio, true);
		this.dispose();
		insertar.setVisible(true);
	}
	
	private void limpiar() {
		textCodigo.setText("");
		textCausa.setText("");
		textFecha.setText("");
		textUbicacion.setText("");
		comboBox.setSelectedIndex(0);
		textTipoP.setText("");
		textColorP.setText("");
		textColorO.setText("");
		textAltura.setText("");
		textEspecificaciones.setText("");
	}
}
