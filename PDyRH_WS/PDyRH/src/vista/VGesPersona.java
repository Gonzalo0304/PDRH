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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controlador.DataFactoryGestPer;
import controlador.interfaces.ContDatosGestPer;
import excepciones.Excepciones;
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
	private JSeparator separatorMenu;
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
	private JSeparator separatorMenu2;
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
	private JMenuItem mCerrar2;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JSeparator separatorGesPer;
	private JLabel lblGesPer;
	private JLabel lblAnaCono;
	private JSeparator separatorAnaCono;
	private Button buttonAgregar;
	private JSeparator separator;
	private String[] info;
	private Persona per;
	private Conocido con;
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
	private VIniciarSesion padre;

	public VGesPersona(VIniciarSesion padre, boolean modal, String dni, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Gestionar persona");
		setBounds(350, 150, 506, 690);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		info = infos;
		this.dni = dni;
		this.padre = padre;

		// <--- Pestaña 1 --->
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlHighlight);
		tabbedPane.setBounds(0, 0, 506, 690);
		getContentPane().add(tabbedPane);

		bgPris = new ButtonGroup();

		cargarDatos(dni);

		// <--- Pestaña 2 --->
		contentConos = new JPanel();
		contentConos.setLayout(null);
		contentConos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentConos.setBackground(Color.WHITE);
		tabbedPane.addTab("Conocidos", null, contentConos, null);
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Cambiar el tamaño de la ventana para cada pestaña
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
		lblCerrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar_1.setForeground(Color.WHITE);
		contentConos.add(lblCerrar_1);

		// Menú superior
		separatorMenu2 = new JSeparator();
		separatorMenu2.setForeground(SystemColor.controlShadow);
		separatorMenu2.setBackground(new Color(0, 51, 102));
		separatorMenu2.setBounds(0, 36, 502, 2);
		contentConos.add(separatorMenu2);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentConos.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));

		mCerrar2 = new JMenuItem("Cerrar Sesion");
		mCerrar2.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar2.setBackground(new Color(32, 178, 170));
		mCerrar2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar2.setForeground(Color.BLACK);
		mCerrar2.addActionListener(this);
		menUsuario.add(mCerrar2);

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

		// Campos de información de conocido
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
		textDniCon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
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
		textRel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});

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

		// Botón de agregar conocido
		buttonAgregar = new Button("A\u00D1ADIR");
		buttonAgregar.setForeground(Color.WHITE);
		buttonAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAgregar.setBackground(new Color(153, 0, 0));
		buttonAgregar.setBounds(310, 136, 89, 28);
		buttonAgregar.setEnabled(false);
		buttonAgregar.addActionListener(this);
		contentConos.add(buttonAgregar);

		separator = new JSeparator();
		separator.setForeground(new Color(153, 153, 255));
		separator.setBackground(new Color(153, 153, 204));
		separator.setBounds(0, 251, 502, 2);
		contentConos.add(separator);
		
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
										separatorMenu.setBounds(0, 36, 502, 2);
										separatorMenu.setForeground(SystemColor.controlShadow);
										separatorMenu.setBackground(new Color(0, 51, 102));
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
																																																																								textFall.setColumns(10);
																																																																								textFall.setBounds(26, 565, 187, 20);
																																																																								contentDatos.add(textFall);
																																																																								
																																																																										// Campos de información de agente
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
																																																																																										textFinServ.setVisible(false);
																																																																																										textFinServ.setColumns(10);
																																																																																										textFinServ.setBounds(264, 242, 187, 20);
																																																																																										contentDatos.add(textFinServ);
																																																																																										
																																																																																												// Campos de información de criminal
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
																																																																																																								textFechaArr.setVisible(false);
																																																																																																								textFechaArr.setColumns(10);
																																																																																																								textFechaArr.setBounds(264, 174, 187, 20);
																																																																																																								contentDatos.add(textFechaArr);
																																																																																																								
																																																																																																										// Campos de información de desaparecida
																																																																																																										textFechaDes = new JTextField();
																																																																																																										textFechaDes.setVisible(false);
																																																																																																										textFechaDes.setColumns(10);
																																																																																																										textFechaDes.setBounds(264, 116, 187, 20);
																																																																																																										contentDatos.add(textFechaDes);
																																																																																																										
																																																																																																												textTP = new JTextField();
																																																																																																												textTP.setVisible(false);
																																																																																																												textTP.setColumns(10);
																																																																																																												textTP.setBounds(264, 300, 187, 20);
																																																																																																												contentDatos.add(textTP);
																																																																																																												
																																																																																																														textLoc = new JTextField();
																																																																																																														textLoc.setColumns(10);
																																																																																																														textLoc.setBounds(26, 428, 187, 20);
																																																																																																														contentDatos.add(textLoc);
																																																																																																														
																																																																																																																textUltUbi = new JTextField();
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
																																																																																																																																						textSexo.setVisible(false);
																																																																																																																																						textSexo.setColumns(10);
																																																																																																																																						textSexo.setBounds(264, 242, 187, 20);
																																																																																																																																						contentDatos.add(textSexo);
																																																																																																																																						
																																																																																																																																								textCP = new JTextField();
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
																																																																																																																																																														
																																																																																																																																																																// Fondo
																																																																																																																																																																imgErtzAO = new JLabel("");
																																																																																																																																																																imgErtzAO.setIcon(new ImageIcon(VGesPersona.class.getResource("/imagenes/ertzAC.png")));
																																																																																																																																																																imgErtzAO.setBounds(90, 200, 309, 317);
																																																																																																																																																																contentDatos.add(imgErtzAO);
																																																																																																																																																																
																																																																																																																																																																		// Título
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
																																																																																																																																																																				
																																																																																																																																																																						// Botón de modificación y eliminación
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
	}

	// Cargar la información
	/**
	 * Carga los datos de la persona que se busca para gestionar la persona. En funcion del tipo buscado mostrara unos campos u otros.
	 * @param dni se manda el dni introducido en la pestaña de gestion
	 */
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

	// Habilitar botón si hay un dni y una relación introducidas
	/**
	 * Habilitar botón si hay un dni y una relación introducidas 
	 */
	public void habilitarBoton() {
		if (!textRel.getText().isBlank() && !textDniCon.getText().isBlank()) {
			buttonAgregar.setEnabled(true);
		} else {
			buttonAgregar.setEnabled(false);
		}
	}

	@Override
	public Persona obtenerPersona(String dni) {
		return datos.obtenerPersona(dni);
	}

	@Override
	/**
	 * Modifica la persona introducida. Comprueba si los int o LoacalDate estan vacios si estan vacios las variables que se usan para parsearlos se dejan a 0 o null y si estan llenos se 
	 * parsea de String a LocalDate o String a int. Si la modificacion es realizada con exito se notificara aocn un JOptionPane.</br></br>
	 * 
	 * <h3><--Variables-->
	 * <li>int movil: se usa para dejar a 0 el campo de movil y si es necesario parsear los datos introducidos.
	 * <li>int opc: se usa para dejar a 0 el campo de movil y si es necesario parsear los datos introducidos.
	 * <li>int rango: se usa para parsear el rango introducido a int.
	 * <li>boolean pris: se usa para si el radiobutton de preso si se guarde true.
	 * <lI>int altura: se usa para parsear de String a int la altura.
	 */
	public void modificarPersona(Persona per) {
		int movil = 0;
		int opc = 0;
		try {
			if (!textMovil.getText().isBlank()) {
				movil = Integer.valueOf(textMovil.getText());
			}
			if (!textTelf.getText().isBlank()) {
				opc = Integer.valueOf(textTelf.getText());
			}
			int[] telfs = { movil, opc };

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
			JOptionPane.showMessageDialog(this, "Modificación realizada con éxito.", "Modificación exitosa",
					JOptionPane.CLOSED_OPTION);
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Carácteres excedidos", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	/**
	 * Se pedira confirmacion para eliminar a una persona y si se elimina del todo se notificara con un JOptionPane
	 */
	public void eliminarPersona(String dni) {
		if (JOptionPane.showConfirmDialog(this,
				"¿Seguro que desea dar de baja a esta persona? Es una acción irreversible.", "Confirmar baja",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
			datos.eliminarPersona(dni);
			JOptionPane.showMessageDialog(this, "Persona eliminada correctamente.", "Baja realizada",
					JOptionPane.CLOSED_OPTION);
			cerrar();
		}
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	@Override
	/**
	 * Agrega un conocido a una persona lo primero que hace es comprobar el dni y si esta bien introducido añade a conocidos el dni de la persona y de su conocido y el tipo de relacion. Si
	 * la relacion se añade con exito se notificara con un JOptionPane.
	 */
	public void agregarConocido(Conocido cono) {
		Map<String, Conocido> conocidos = listarConocidos(dni);
		if (conocidos.get(textDniCon.getText()) == null && comprobarDNI(textDniCon.getText())) {
			cono = new Conocido();
			cono.setDni1(dni);
			cono.setDni2(textDniCon.getText());
			cono.setRelacion(textRel.getText());
			try {
				datos.agregarConocido(cono);
			} catch (Excepciones e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Carácteres excedidos", JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(this, "Conocido añadido con exito.", "Insercción realizada",
					JOptionPane.CLOSED_OPTION);
			textDniCon.setText("");
			textRel.setText("");
		} else if (conocidos.get(textDniCon.getText()) != null) {
			JOptionPane.showMessageDialog(this, "El DNI introducido pertenece ya a un conocido de esta persona.",
					"DNI existente.", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "El DNI introducido no está registrado en la base de datos.",
					"DNI inexistente.", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Map<String, Conocido> listarConocidos(String dni1) {
		return datos.listarConocidos(dni1);
	}

	@Override
	public void agregarFechaArresto(String dni, LocalDate fecha) {
		try {
			datos.agregarFechaArresto(dni, fecha);
			JOptionPane.showMessageDialog(this, "Fecha agregada correctamente.", "Insercción realizada",
					JOptionPane.CLOSED_OPTION);
			textFechaArr.setText("");
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Fecha existente.", JOptionPane.ERROR_MESSAGE);
		} 
	}

	/**
	 * Cierra la ventana actual y abre la anterior
	 */
	public void cerrar() {
		VGestion vGest = new VGestion(padre, true, info);
		this.dispose();
		vGest.setVisible(true);
	}

	// Abrir ventanas de menú
	/**
	 * Abrir ventana de gestion desde JMenuBar 
	 */
	private void abrirGes() {
		VGestion vBus = new VGestion(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Abrir ventana de comparacion desde JMenuBar 
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Abrir ventana de busqueda desde JMenuBar 
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de restos humanos desde JMenuBar 
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info, false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de personas desde JMenuBar 
	 */	
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de casos desde JMenuBar 
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonMod)) {
			try {
				if ((!textMovil.getText().isBlank() && textMovil.getText().length() != 9) || (!textTelf.getText().isBlank() && textTelf.getText().length() != 9)) {
					JOptionPane.showMessageDialog(this,"El teléfono debe tener 9 dígitos.","Telf. incorrecto",JOptionPane.ERROR_MESSAGE);
				} else {
					modificarPersona(per);
				}
			
			} catch (DateTimeParseException e1) {
				JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto(yyyy-mm-dd).", "Formato incorrecto",
						JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Los números deben ser dígitos sin espacios.","Formato erroneo",JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource().equals(buttonBaja)) {
			eliminarPersona(dni);
		} else if (e.getSource().equals(buttonFA)) {
			try {
				agregarFechaArresto(per.getDni(), LocalDate.parse(textFechaArr.getText()));
			} catch (DateTimeParseException e1) {
				JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto(yyyy-mm-dd).", "Formato incorrecto",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource().equals(buttonAgregar)) {
			agregarConocido(con);
		} else if (e.getSource().equals(mCerrar)) {
			if (JOptionPane.showConfirmDialog(this,
					"¿Seguro que desea cerrar sesión?",
					"Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				this.dispose();
				padre.setVisible(true);
			}
		} else if (e.getSource().equals(mCerrar2)) {
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
}
