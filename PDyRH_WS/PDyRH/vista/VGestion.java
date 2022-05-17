package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controlador.DataFactoryBusq;
import controlador.interfaces.ContDatosBusq;
import modelo.clases.Caso;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VGestion extends JDialog implements ActionListener, ContDatosBusq {
	private static final long serialVersionUID = 1L;

	// <--- Elementos --->
	private JTextField textID;
	private JMenuBar menuBar;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JLabel lblID;
	private Button buttonBuscar;
	private JRadioButton RadioButtonPersonaVGestion;
	private JRadioButton RadioButtonRHVGestion;
	private JRadioButton RadioButtonCasoVGestion;
	private final JPanel contentPane = new JPanel();
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JSeparator separatorMenu;
	private JSeparator separatorID;
	private JSeparator separatorPer;
	private JSeparator separatorRH;
	private JSeparator separatorCaso;
	private JSeparator separatorGest;
	private JLabel lblGestin;
	private Panel panel_2;
	private Panel panel;
	private JLabel imgErtzAC;
	private ButtonGroup bgTipo;
	private VIniciarSesion padre;
	private boolean esta;
	private String[] info;

	// <--- Datos BD --->
	ContDatosBusq datos = DataFactoryBusq.getDatos();

	/**
	 * @param padre es la ventana padre de esta.
	 * @param modal es el valor del modal para dasabilitar la ventana anterior
	 * @param infos es la informacion del usuario
	 */
	public VGestion(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Gestionar");
		setBounds(100, 100, 607, 399);
		contentPane.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
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
		separatorMenu = new JSeparator();
		separatorMenu.setBackground(Color.DARK_GRAY);
		separatorMenu.setBounds(2, 47, 603, 2);
		contentPane.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPane.add(menuBar);

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

		separatorGest = new JSeparator();
		separatorGest.setForeground(new Color(102, 0, 0));
		separatorGest.setBackground(new Color(153, 0, 0));
		separatorGest.setBounds(22, 81, 561, 2);
		contentPane.add(separatorGest);

		lblGestin = new JLabel("Men\u00FA de Gesti\u00F3n");
		lblGestin.setForeground(SystemColor.textInactiveText);
		lblGestin.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGestin.setBounds(22, 59, 118, 19);
		contentPane.add(lblGestin);

		// Decoración
		panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(133, 178, 348, 82);
		contentPane.add(panel_2);

		separatorID = new JSeparator();
		separatorID.setBounds(51, 30, 241, 2);
		panel_2.add(separatorID);
		separatorID.setForeground(new Color(102, 0, 0));
		separatorID.setBackground(new Color(153, 0, 0));

		// Campo a rellenar
		textID = new JTextField();
		textID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!textID.getText().isBlank()) {
					buttonBuscar.setEnabled(true);
				} else {
					buttonBuscar.setEnabled(false);
				}
			}
		});
		textID.setBounds(51, 43, 241, 28);
		textID.setColumns(10);
		panel_2.add(textID);

		lblID = new JLabel("INTRODUCE EL IDENTIFICADOR ");
		lblID.setBounds(51, 11, 241, 14);
		panel_2.add(lblID);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(new Color(0, 51, 102));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Botón de busqueda
		buttonBuscar = new Button("Buscar");
		buttonBuscar.setBounds(258, 307, 98, 28);
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setBackground(new Color(153, 0, 0));
		buttonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBuscar.setEnabled(false);
		buttonBuscar.addActionListener(this);
		contentPane.add(buttonBuscar);

		// Selección de tipo
		separatorPer = new JSeparator();
		separatorPer.setBounds(113, 134, 61, 2);
		contentPane.add(separatorPer);
		separatorPer.setForeground(new Color(0, 0, 51));
		separatorPer.setBackground(new Color(0, 51, 102));

		separatorRH = new JSeparator();
		separatorRH.setBounds(267, 134, 109, 2);
		contentPane.add(separatorRH);
		separatorRH.setForeground(new Color(0, 0, 51));
		separatorRH.setBackground(new Color(0, 51, 102));

		separatorCaso = new JSeparator();
		separatorCaso.setBounds(456, 134, 39, 2);
		contentPane.add(separatorCaso);
		separatorCaso.setForeground(new Color(0, 0, 51));
		separatorCaso.setBackground(new Color(0, 51, 102));

		RadioButtonPersonaVGestion = new JRadioButton("Persona");
		RadioButtonPersonaVGestion.setBounds(91, 113, 83, 23);
		contentPane.add(RadioButtonPersonaVGestion);
		RadioButtonPersonaVGestion.setForeground(new Color(0, 51, 102));
		RadioButtonPersonaVGestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		RadioButtonPersonaVGestion.setOpaque(false);
		RadioButtonPersonaVGestion.setRolloverEnabled(false);

		RadioButtonRHVGestion = new JRadioButton("Resto Humano");
		RadioButtonRHVGestion.setBounds(246, 113, 132, 23);
		contentPane.add(RadioButtonRHVGestion);
		RadioButtonRHVGestion.setForeground(new Color(0, 51, 102));
		RadioButtonRHVGestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		RadioButtonRHVGestion.setOpaque(false);

		RadioButtonCasoVGestion = new JRadioButton("Caso");
		RadioButtonCasoVGestion.setBounds(434, 113, 83, 23);
		contentPane.add(RadioButtonCasoVGestion);
		RadioButtonCasoVGestion.setForeground(new Color(0, 51, 102));
		RadioButtonCasoVGestion.setFont(new Font("Tahoma", Font.BOLD, 13));
		RadioButtonCasoVGestion.setOpaque(false);

		bgTipo = new ButtonGroup();
		bgTipo.add(RadioButtonPersonaVGestion);
		bgTipo.add(RadioButtonRHVGestion);
		bgTipo.add(RadioButtonCasoVGestion);

		panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(130, 176, 354, 86);
		contentPane.add(panel);

		// Fondo
		imgErtzAC = new JLabel("");
		imgErtzAC.setIcon(new ImageIcon(VGestion.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(151, 83, 318, 290);
		contentPane.add(imgErtzAC);
	}

	// Métodos
	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	@Override
	public boolean comprobarCodResto(String codResto) {
		return datos.comprobarCodResto(codResto);
	}

	@Override
	public Caso obtenerCaso(String codCaso) {
		return datos.obtenerCaso(codCaso);
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
		} else if (e.getSource().equals(buttonBuscar)) {
			comprobarBus(info);
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
	 * Abrir ventana de gestion
	 */
	private void abrirGes() {
		VGestion vGes = new VGestion(padre, true, info);
		this.dispose();
		vGes.setVisible(true);
	}

	/**
	 * Abrir ventana de comparacion
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Abrir ventana de busqueda
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de resto humano
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info, false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de persona
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	/**
	 * Abrir ventana de insercion de caso
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}

	// Abrir ventanas de gestión
	/**
	 * 
	 * @param info pasar la informacion del usuario
	 */
	private void comprobarBus(String[] info) {
		esta = true;
		String selec = rbSeleccionado(bgTipo);
		if (selec == null) {
			JOptionPane.showMessageDialog(this, "No ha seleccionado que tipo de busqueda desea hacer.",
					"Sin selección.", JOptionPane.ERROR_MESSAGE);
		} else {
			switch (selec) {
			case "Persona":
				if (comprobarDNI(textID.getText())) {
					VGesPersona vGesPer = new VGesPersona(padre, true, textID.getText(), info);
					this.dispose();
					vGesPer.setVisible(true);
				} else {
					esta = false;
				}
				break;
			case "Resto Humano":
				if (comprobarCodResto(textID.getText())) {
					VInsRH vGesRH = new VInsRH(padre, true, textID.getText(), info,true);
					this.dispose();
					vGesRH.setVisible(true);
				} else {
					esta = false;
				}
				break;
			case "Caso":
				if (obtenerCaso(textID.getText()) != null) {
					VGesCaso vGesCaso = new VGesCaso(padre, true, obtenerCaso(textID.getText()), info);
					this.dispose();
					vGesCaso.setVisible(true);
				} else {
					esta = false;
				}
				break;
			}
			if (!esta) {
				JOptionPane.showMessageDialog(this, "El identificador introduccido no es correcto.", "ID erroneo.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Cerrar la venta actual y abrir la anterior.
	 */
	private void cerrar() {
		VPrincipal vMain = new VPrincipal(padre, true, info);
		this.dispose();
		vMain.setVisible(true);
	}

	// Comprobar que radio button está seleccionado
	public String rbSeleccionado(ButtonGroup bg) {
		for (Enumeration<AbstractButton> botones = bg.getElements(); botones.hasMoreElements();) {
			AbstractButton boton = botones.nextElement();

			if (boton.isSelected()) {
				return boton.getText();
			}
		}

		return null;
	}
}
