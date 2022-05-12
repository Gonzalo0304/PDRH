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

import controlador.DataFactoryRH;
import controlador.interfaces.ContDatosRH;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VInsRH extends JDialog implements ActionListener, ContDatosRH {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textCausa;
	private JTextField textFecha;
	private JTextField textUbicacion;
	private JTextField textTipoP;
	private JTextField textColorP;
	private JTextField textAltura;
	private JTextField textEspecificaciones;
	private Button btnAnadir;
	private JComboBox<Object> comboBox;
	private JTextField textColorO;
	private VIniciarSesion padre;
	private String[] info;
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
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JSeparator separator2_5;
	private JLabel lblCausa;
	private JSeparator separator2;
	private JLabel lblCod;
	private JSeparator separator2_1;
	private JLabel lblInsRH;
	private JLabel lblGestRH;
	private JSeparator separatorInsRH;
	private Button btnBaja;
	private Button btnMod;
	private JSeparator separator2_2_1_1_1;
	private JLabel lblFecha_1;
	private JSeparator separator2_4;
	private JLabel imgErtzAC;
	private JLabel lblUbi_1;
	private JLabel lblGen_1;
	private JSeparator separator2_1_3;
	private RestoHumano rh;
	private String cod;
	private JSeparator separator2_2_2;
	private JLabel lblTP_1;
	private JSeparator separator2_1_1_1;
	private JLabel lblCP_1;
	private JSeparator separator2_3_1;
	private JLabel lblAlt_1;
	private JSeparator separator2_1_2_1;
	private JLabel lblEsp_1;
	private JSeparator separator2_2_1_1;
	private JLabel lblCO2;
	private boolean esGes;

	ContDatosRH datos = DataFactoryRH.getDatos();

	public VInsRH(VIniciarSesion padre, boolean modal, String codigo, String[] infos, boolean esGes) {
		// <--- Dise�o de ventana --->
		super(padre);
		this.setModal(modal);
		setBounds(350, 150, 503, 627);
		contentPanel.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		this.padre = padre;
		this.esGes = esGes;
		info = infos;
		cod = codigo;

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
		contentPanel.add(lblCerrar);

		// Men� superior
		separator2_5 = new JSeparator();
		separator2_5.setBounds(0, 36, 502, 2);
		separator2_5.setForeground(SystemColor.controlShadow);
		separator2_5.setBackground(new Color(0, 51, 102));
		contentPanel.add(separator2_5);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);

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

		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(47, 119, 180, 20);
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
		textCausa.setBounds(47, 205, 180, 20);
		contentPanel.add(textCausa);

		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(47, 297, 180, 20);
		contentPanel.add(textFecha);

		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(47, 382, 180, 20);
		contentPanel.add(textUbicacion);

		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Hombre", "Mujer" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(47, 473, 180, 22);
		contentPanel.add(comboBox);

		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(271, 119, 180, 20);
		contentPanel.add(textTipoP);

		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(271, 207, 180, 20);
		contentPanel.add(textColorP);

		textColorO = new JTextField();
		textColorO.setColumns(10);
		textColorO.setBounds(271, 294, 180, 20);
		contentPanel.add(textColorO);

		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(271, 380, 180, 20);
		contentPanel.add(textAltura);

		textEspecificaciones = new JTextField();
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(271, 475, 180, 20);
		contentPanel.add(textEspecificaciones);

		btnAnadir = new Button("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (obtenerRH(textCodigo.getText()) == null) {
					rh = new RestoHumano();
					altaRH(rh);
				} else {
					JOptionPane.showMessageDialog(padre, "Este resto humano ya ha sido introducido.",
							"C�digo existente.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAnadir.setBackground(new Color(153, 0, 0));
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setEnabled(false);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(210, 532, 87, 28);
		contentPanel.add(btnAnadir);

		lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setForeground(new Color(0, 51, 102));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFecha_1.setBounds(47, 258, 81, 28);
		contentPanel.add(lblFecha_1);

		separator2_4 = new JSeparator();
		separator2_4.setForeground(new Color(0, 51, 102));
		separator2_4.setBackground(new Color(0, 0, 51));
		separator2_4.setBounds(47, 284, 106, 2);
		contentPanel.add(separator2_4);

		lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setForeground(new Color(0, 51, 102));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUbi_1.setBounds(47, 343, 81, 28);
		contentPanel.add(lblUbi_1);

		separator2_1_3 = new JSeparator();
		separator2_1_3.setForeground(new Color(0, 51, 102));
		separator2_1_3.setBackground(new Color(0, 0, 51));
		separator2_1_3.setBounds(47, 369, 106, 2);
		contentPanel.add(separator2_1_3);

		lblGen_1 = new JLabel("SEXO");
		lblGen_1.setForeground(new Color(0, 51, 102));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblGen_1.setBounds(47, 434, 81, 28);
		contentPanel.add(lblGen_1);

		separator2_2_2 = new JSeparator();
		separator2_2_2.setForeground(new Color(0, 51, 102));
		separator2_2_2.setBackground(new Color(0, 0, 51));
		separator2_2_2.setBounds(47, 460, 106, 2);
		contentPanel.add(separator2_2_2);

		lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setForeground(new Color(0, 51, 102));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTP_1.setBounds(271, 80, 81, 28);
		contentPanel.add(lblTP_1);

		separator2_1_1_1 = new JSeparator();
		separator2_1_1_1.setForeground(new Color(0, 51, 102));
		separator2_1_1_1.setBackground(new Color(0, 0, 51));
		separator2_1_1_1.setBounds(271, 106, 106, 2);
		contentPanel.add(separator2_1_1_1);

		lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setForeground(new Color(0, 51, 102));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCP_1.setBounds(271, 171, 106, 28);
		contentPanel.add(lblCP_1);

		separator2_3_1 = new JSeparator();
		separator2_3_1.setForeground(new Color(0, 51, 102));
		separator2_3_1.setBackground(new Color(0, 0, 51));
		separator2_3_1.setBounds(271, 197, 106, 2);
		contentPanel.add(separator2_3_1);

		lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setForeground(new Color(0, 51, 102));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlt_1.setBounds(271, 341, 81, 28);
		contentPanel.add(lblAlt_1);

		separator2_1_2_1 = new JSeparator();
		separator2_1_2_1.setForeground(new Color(0, 51, 102));
		separator2_1_2_1.setBackground(new Color(0, 0, 51));
		separator2_1_2_1.setBounds(271, 367, 106, 2);
		contentPanel.add(separator2_1_2_1);

		lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setForeground(new Color(0, 51, 102));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEsp_1.setBounds(271, 436, 106, 28);
		contentPanel.add(lblEsp_1);

		separator2_2_1_1 = new JSeparator();
		separator2_2_1_1.setForeground(new Color(0, 51, 102));
		separator2_2_1_1.setBackground(new Color(0, 0, 51));
		separator2_2_1_1.setBounds(271, 462, 106, 2);
		contentPanel.add(separator2_2_1_1);

		lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(0, 51, 102));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(271, 258, 106, 28);
		contentPanel.add(lblCO2);

		separator2_2_1_1_1 = new JSeparator();
		separator2_2_1_1_1.setForeground(new Color(0, 51, 102));
		separator2_2_1_1_1.setBackground(new Color(0, 0, 51));
		separator2_2_1_1_1.setBounds(271, 284, 106, 2);
		contentPanel.add(separator2_2_1_1_1);

		lblCausa = new JLabel("CAUSA");
		lblCausa.setForeground(new Color(0, 51, 102));
		lblCausa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCausa.setBounds(47, 166, 81, 28);
		contentPanel.add(lblCausa);

		separator2 = new JSeparator();
		separator2.setForeground(new Color(0, 51, 102));
		separator2.setBackground(new Color(0, 0, 51));
		separator2.setBounds(47, 192, 106, 2);
		contentPanel.add(separator2);

		lblCod = new JLabel("C\u00D3DIGO");
		lblCod.setForeground(new Color(0, 51, 102));
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCod.setBounds(47, 83, 81, 28);
		contentPanel.add(lblCod);

		separator2_1 = new JSeparator();
		separator2_1.setForeground(new Color(0, 51, 102));
		separator2_1.setBackground(new Color(0, 0, 51));
		separator2_1.setBounds(47, 109, 106, 2);
		contentPanel.add(separator2_1);

		lblInsRH = new JLabel("Inserci\u00F3n de Resto Humano");
		lblInsRH.setForeground(SystemColor.textInactiveText);
		lblInsRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblInsRH.setBounds(25, 48, 209, 24);
		contentPanel.add(lblInsRH);

		lblGestRH = new JLabel("Gesti\u00F3n de Resto Humano");
		lblGestRH.setForeground(SystemColor.textInactiveText);
		lblGestRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGestRH.setBounds(25, 48, 209, 24);
		contentPanel.add(lblGestRH);

		separatorInsRH = new JSeparator();
		separatorInsRH.setForeground(new Color(102, 0, 0));
		separatorInsRH.setBackground(new Color(153, 0, 0));
		separatorInsRH.setBounds(25, 70, 457, 2);
		contentPanel.add(separatorInsRH);

		imgErtzAC = new JLabel("");
		imgErtzAC.setIcon(new ImageIcon(VInsRH.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(91, 178, 309, 317);
		contentPanel.add(imgErtzAC);

		btnMod = new Button("Modificar");
		btnMod.setForeground(Color.WHITE);
		btnMod.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMod.setBackground(new Color(153, 0, 0));
		btnMod.setBounds(146, 532, 87, 28);
		btnMod.addActionListener(this);
		contentPanel.add(btnMod);

		btnBaja = new Button("Dar Baja");
		btnBaja.setForeground(Color.WHITE);
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBaja.setBackground(new Color(153, 0, 0));
		btnBaja.setBounds(277, 532, 87, 28);
		btnBaja.addActionListener(this);
		contentPanel.add(btnBaja);

		if (!esGes) {
			btnMod.setVisible(false);
			btnBaja.setVisible(false);
			lblGestRH.setVisible(false);
		} else {
			btnAnadir.setVisible(false);
			textCodigo.setEnabled(false);
			lblInsRH.setVisible(false);
			cargarDatos();
		}
	}

	private void cargarDatos() {
		rh = obtenerRH(cod);
		textCodigo.setText(rh.getCodResto());
		if (rh.getFechaMuerte() != null) {
			textFecha.setText(rh.getFechaMuerte().toString());
		}
		if (rh.getGenero() != null) {
			if (rh.getGenero().equalsIgnoreCase("H")) {
				comboBox.setSelectedItem("Hombre");
			}
			if (rh.getGenero().equalsIgnoreCase("M")) {
				comboBox.setSelectedItem("Mujer");
			}

		}
		textCausa.setText(rh.getCausa());
		textColorO.setText(rh.getColorOjos());
		textColorP.setText(rh.getColorPelo());
		textEspecificaciones.setText(rh.getEspecificaciones());
		textTipoP.setText(rh.getTipoPelo());
		textUbicacion.setText(rh.getUbicacion());
	}

	private void cerrar() {
		if (!esGes) {
			VInserciones insertar = new VInserciones(padre, true, info);
			this.dispose();
			insertar.setVisible(true);
		} else {
			VGestion vGes = new VGestion(padre, true, info);
			this.dispose();
			vGes.setVisible(true);
		}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
			this.dispose();
			padre.setVisible(true);
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
		} else if (e.getSource().equals(btnMod)) {
			modificarRH(rh);
		} else if (e.getSource().equals(btnBaja)) {
			eliminarRH(cod);
		}
	}

	// Abrir ventanas de men�
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
		VInsRH vInsRH = new VInsRH(padre, true, null, info, false);
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

	@Override
	public void altaRH(RestoHumano rh) {
		rh = registrarDatos();
		datos.altaRH(rh);
		JOptionPane.showMessageDialog(this, "Inserci�n realizada con �xito.", "Inserci�n exitosa.",
				JOptionPane.CLOSED_OPTION);
		limpiar();
		habilitarBoton();
	}

	private RestoHumano registrarDatos() {
		LocalDate fechaMuer = null;
		int altura = 0;
		if (!textFecha.getText().isBlank()) {
			fechaMuer = stringDate(textFecha.getText());
		}

		if (!textAltura.getText().isBlank()) {
			altura = stringInt(textAltura.getText());
		}

		rh.setCodResto(textCodigo.getText());
		rh.setCausa(textCausa.getText());
		rh.setFechaMuerte(fechaMuer);
		rh.setUbicacion(textUbicacion.getText());
		if (comboBox.getSelectedItem() == "Hombre") {
			rh.setGenero("H");
		} else if (comboBox.getSelectedItem() == "Mujer") {
			rh.setGenero("M");
		}
		rh.setTipoPelo(textTipoP.getText());
		rh.setColorPelo(textColorP.getText());
		rh.setColorOjos(textColorO.getText());
		rh.setAltura(altura);
		rh.setEspecificaciones(textEspecificaciones.getText());

		return rh;
	}

	@Override
	public void modificarRH(RestoHumano rh) {
		rh = registrarDatos();
		datos.modificarRH(rh);
		JOptionPane.showMessageDialog(this, "Modificaci�n realizada con �xito.", "Modificaci�n exitosa.",
				JOptionPane.CLOSED_OPTION);
	}

	@Override
	public void eliminarRH(String codResto) {
		datos.eliminarRH(codResto);
	}

	@Override
	public RestoHumano obtenerRH(String codResto) {
		return datos.obtenerRH(codResto);
	}
}
