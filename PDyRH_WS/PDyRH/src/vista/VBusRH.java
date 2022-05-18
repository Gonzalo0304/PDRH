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

import controlador.DataFactoryBusqRH;
import controlador.interfaces.ContDatosBusqRH;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VBusRH extends JDialog implements ActionListener, ContDatosBusqRH {

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
	private JSeparator separatorMenu;
	private JLabel lblCausa;
	private JSeparator separatorCausa;
	private JLabel lblCod;
	private JSeparator separatorCod;
	private JLabel lblInsRH;
	private JSeparator separatorInsRH;
	private JSeparator separatorCO;
	private JLabel lblFecha_1;
	private JSeparator separatorFecha;
	private JLabel imgErtzAC;
	private JLabel lblUbi_1;
	private JLabel lblGen_1;
	private JSeparator separatorUbi;
	private RestoHumano rh;
	private String cod;
	private JSeparator separatorSexo;
	private JLabel lblTP_1;
	private JSeparator separatorTP;
	private JLabel lblCP_1;
	private JSeparator separatorCP;
	private JLabel lblAlt_1;
	private JSeparator separatorAlt;
	private JLabel lblEsp_1;
	private JSeparator separatorEsp;
	private JLabel lblCO2;

	ContDatosBusqRH datos = DataFactoryBusqRH.getDatos();
	private JTextField textSexo;

	public VBusRH(VIniciarSesion padre, boolean modal, String codigo, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setBounds(350, 150, 503, 627);
		setTitle("PDyRH: Buscar RH");
		contentPanel.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		this.padre = padre;
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
		contentPanel.add(lblCerrar);

		// Menú superior
		separatorMenu = new JSeparator();
		separatorMenu.setBounds(0, 36, 502, 2);
		separatorMenu.setForeground(SystemColor.controlShadow);
		separatorMenu.setBackground(new Color(0, 51, 102));
		contentPanel.add(separatorMenu);

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
		textCodigo.setEditable(false);
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(45, 159, 180, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);

		textCausa = new JTextField();
		textCausa.setEditable(false);
		textCausa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCausa.setColumns(10);
		textCausa.setBounds(45, 245, 180, 20);
		contentPanel.add(textCausa);

		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(45, 337, 180, 20);
		contentPanel.add(textFecha);

		textUbicacion = new JTextField();
		textUbicacion.setEditable(false);
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(45, 422, 180, 20);
		contentPanel.add(textUbicacion);

		textTipoP = new JTextField();
		textTipoP.setEditable(false);
		textTipoP.setColumns(10);
		textTipoP.setBounds(269, 159, 180, 20);
		contentPanel.add(textTipoP);

		textColorP = new JTextField();
		textColorP.setEditable(false);
		textColorP.setColumns(10);
		textColorP.setBounds(269, 247, 180, 20);
		contentPanel.add(textColorP);

		textColorO = new JTextField();
		textColorO.setEditable(false);
		textColorO.setColumns(10);
		textColorO.setBounds(269, 334, 180, 20);
		contentPanel.add(textColorO);

		textAltura = new JTextField();
		textAltura.setEditable(false);
		textAltura.setColumns(10);
		textAltura.setBounds(269, 420, 180, 20);
		contentPanel.add(textAltura);

		textEspecificaciones = new JTextField();
		textEspecificaciones.setEditable(false);
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(269, 515, 180, 20);
		contentPanel.add(textEspecificaciones);

		lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setForeground(new Color(0, 51, 102));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFecha_1.setBounds(45, 298, 81, 28);
		contentPanel.add(lblFecha_1);

		separatorFecha = new JSeparator();
		separatorFecha.setForeground(new Color(0, 51, 102));
		separatorFecha.setBackground(new Color(0, 0, 51));
		separatorFecha.setBounds(45, 324, 106, 2);
		contentPanel.add(separatorFecha);

		lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setForeground(new Color(0, 51, 102));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUbi_1.setBounds(45, 383, 81, 28);
		contentPanel.add(lblUbi_1);

		separatorUbi = new JSeparator();
		separatorUbi.setForeground(new Color(0, 51, 102));
		separatorUbi.setBackground(new Color(0, 0, 51));
		separatorUbi.setBounds(45, 409, 106, 2);
		contentPanel.add(separatorUbi);

		lblGen_1 = new JLabel("SEXO");
		lblGen_1.setForeground(new Color(0, 51, 102));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblGen_1.setBounds(45, 474, 81, 28);
		contentPanel.add(lblGen_1);

		separatorSexo = new JSeparator();
		separatorSexo.setForeground(new Color(0, 51, 102));
		separatorSexo.setBackground(new Color(0, 0, 51));
		separatorSexo.setBounds(45, 500, 106, 2);
		contentPanel.add(separatorSexo);

		lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setForeground(new Color(0, 51, 102));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTP_1.setBounds(269, 120, 81, 28);
		contentPanel.add(lblTP_1);

		separatorTP = new JSeparator();
		separatorTP.setForeground(new Color(0, 51, 102));
		separatorTP.setBackground(new Color(0, 0, 51));
		separatorTP.setBounds(269, 146, 106, 2);
		contentPanel.add(separatorTP);

		lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setForeground(new Color(0, 51, 102));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCP_1.setBounds(269, 211, 106, 28);
		contentPanel.add(lblCP_1);

		separatorCP = new JSeparator();
		separatorCP.setForeground(new Color(0, 51, 102));
		separatorCP.setBackground(new Color(0, 0, 51));
		separatorCP.setBounds(269, 237, 106, 2);
		contentPanel.add(separatorCP);

		lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setForeground(new Color(0, 51, 102));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlt_1.setBounds(269, 381, 81, 28);
		contentPanel.add(lblAlt_1);

		separatorAlt = new JSeparator();
		separatorAlt.setForeground(new Color(0, 51, 102));
		separatorAlt.setBackground(new Color(0, 0, 51));
		separatorAlt.setBounds(269, 407, 106, 2);
		contentPanel.add(separatorAlt);

		lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setForeground(new Color(0, 51, 102));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEsp_1.setBounds(269, 476, 106, 28);
		contentPanel.add(lblEsp_1);

		separatorEsp = new JSeparator();
		separatorEsp.setForeground(new Color(0, 51, 102));
		separatorEsp.setBackground(new Color(0, 0, 51));
		separatorEsp.setBounds(269, 502, 106, 2);
		contentPanel.add(separatorEsp);

		lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(0, 51, 102));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(269, 298, 106, 28);
		contentPanel.add(lblCO2);

		separatorCO = new JSeparator();
		separatorCO.setForeground(new Color(0, 51, 102));
		separatorCO.setBackground(new Color(0, 0, 51));
		separatorCO.setBounds(269, 324, 106, 2);
		contentPanel.add(separatorCO);

		lblCausa = new JLabel("CAUSA");
		lblCausa.setForeground(new Color(0, 51, 102));
		lblCausa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCausa.setBounds(45, 206, 81, 28);
		contentPanel.add(lblCausa);

		separatorCausa = new JSeparator();
		separatorCausa.setForeground(new Color(0, 51, 102));
		separatorCausa.setBackground(new Color(0, 0, 51));
		separatorCausa.setBounds(45, 232, 106, 2);
		contentPanel.add(separatorCausa);

		lblCod = new JLabel("C\u00D3DIGO");
		lblCod.setForeground(new Color(0, 51, 102));
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCod.setBounds(45, 123, 81, 28);
		contentPanel.add(lblCod);

		separatorCod = new JSeparator();
		separatorCod.setForeground(new Color(0, 51, 102));
		separatorCod.setBackground(new Color(0, 0, 51));
		separatorCod.setBounds(45, 149, 106, 2);
		contentPanel.add(separatorCod);

		lblInsRH = new JLabel("B\u00FAsqueda de Resto Humano");
		lblInsRH.setForeground(SystemColor.textInactiveText);
		lblInsRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblInsRH.setBounds(25, 48, 209, 24);
		contentPanel.add(lblInsRH);

		separatorInsRH = new JSeparator();
		separatorInsRH.setForeground(new Color(102, 0, 0));
		separatorInsRH.setBackground(new Color(153, 0, 0));
		separatorInsRH.setBounds(25, 70, 457, 2);
		contentPanel.add(separatorInsRH);

		imgErtzAC = new JLabel("");
		imgErtzAC.setIcon(new ImageIcon(VInsRH.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(91, 178, 309, 317);
		contentPanel.add(imgErtzAC);

		textSexo = new JTextField();
		textSexo.setEditable(false);
		textSexo.setColumns(10);
		textSexo.setBounds(45, 515, 180, 20);
		contentPanel.add(textSexo);

		cargarDatos();
	}

	private void cargarDatos() {
		rh = obtenerRH(cod);
		textCodigo.setText(rh.getCodResto());
		if (rh.getFechaMuerte() != null) {
			textFecha.setText(rh.getFechaMuerte().toString());
		}
		if (rh.getGenero().equalsIgnoreCase("M")) {
			textSexo.setText("Mujer");
		} else {
			textSexo.setText("Hombre");
		}
		textCausa.setText(rh.getCausa());
		textColorO.setText(rh.getColorOjos());
		textColorP.setText(rh.getColorPelo());
		textEspecificaciones.setText(rh.getEspecificaciones());
		textTipoP.setText(rh.getTipoPelo());
		textUbicacion.setText(rh.getUbicacion());
	}

	private void cerrar() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
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

	@Override
	public RestoHumano obtenerRH(String codResto) {
		return datos.obtenerRH(codResto);
	}

	@Override
	public String obtenerIdentificado(String codResto) {
		return datos.obtenerIdentificado(codResto);
	}
}
