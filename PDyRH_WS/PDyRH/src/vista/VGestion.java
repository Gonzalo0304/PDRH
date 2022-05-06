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
	private JMenu menuInsertar;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JLabel lblID;
	private Button buttonBuscar;
	private JRadioButton RadioButtonPersonaVGestion;
	private JRadioButton RadioButtonRHVGestion;
	private JRadioButton RadioButtonCasoVGestion;
	private final JPanel contentPane = new JPanel();
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JSeparator separator;
	private JSeparator separatorID;
	private JSeparator separatorPer;
	private JSeparator separatorRH;
	private JSeparator separatorCaso;
	private JSeparator separator1;
	private JLabel lblGestin;
	private Panel panel_2;
	private Panel panel;
	private JLabel imgErtzAC;
	private ButtonGroup bgTipo;
	private VIniciarSesion padre;
	private boolean esta;
	private String info;
	
	// <--- Datos BD --->
	ContDatosBusq datos = DataFactoryBusq.getDatos();

	// <--- Ejecución --->
	public VGestion(VIniciarSesion padre, boolean modal, String infos) {
		super(padre);
		this.setModal(modal);
		setTitle("Gestionar");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		info = infos;
		
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

		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(2, 47, 603, 2);
		contentPane.add(separator);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPane.add(menuBar);

		menUsuario = new JMenu(" " + info + " ");
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

		separator1 = new JSeparator();
		separator1.setForeground(new Color(102, 0, 0));
		separator1.setBackground(new Color(153, 0, 0));
		separator1.setBounds(22, 81, 561, 2);
		contentPane.add(separator1);

		lblGestin = new JLabel("Men\u00FA de Gesti\u00F3n");
		lblGestin.setForeground(SystemColor.textInactiveText);
		lblGestin.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGestin.setBounds(22, 59, 118, 19);
		contentPane.add(lblGestin);

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

		buttonBuscar = new Button("Buscar");
		buttonBuscar.setBounds(258, 307, 98, 28);
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setBackground(new Color(153, 0, 0));
		buttonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBuscar.setEnabled(false);
		buttonBuscar.addActionListener(this);
		contentPane.add(buttonBuscar);

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

		imgErtzAC = new JLabel("");
		imgErtzAC
				.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		imgErtzAC.setBounds(151, 83, 318, 290);
		contentPane.add(imgErtzAC);
	}

	@Override
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}

	@Override
	public boolean buscarRH(String codResto) {
		return datos.buscarRH(codResto);
	}

	@Override
	public Caso buscarCaso(String codCaso) {
		return datos.buscarCaso(codCaso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
			cerrar();
		} else if (e.getSource().equals(buttonBuscar)) {
			comprobarBus(info);
		}
	}

	private void comprobarBus(String info) {
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
					vGesPer.setVisible(true);
				} else {
					esta = false;
				}
				break;
			case "Resto Humano":
				if (buscarRH(textID.getText())) {
					VBusRH vGesRH = new VBusRH(padre, true, textID.getText());
					vGesRH.setVisible(true);
				} else {
					esta = false;
				}
				break;
			case "Caso":
				if (buscarCaso(textID.getText()) != null) {
					VGesCaso vGesCaso = new VGesCaso(padre, true, buscarCaso(textID.getText()));
					vGesCaso.setVisible(true);
				} else {
					esta = false;
				}
				break;
			}
			if (!esta) {
				JOptionPane.showMessageDialog(this, "El identificador introduccido no es correcto.",
						"ID erroneo.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cerrar() {
		this.dispose();
	}

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
