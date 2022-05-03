package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import modelo.clases.Persona;
import modelo.clases.RestoHumano;

import javax.swing.ImageIcon;

public class VComRH extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JTextField textFECHA;
	private JTextField textUbi;
	private JTextField textGen;
	private JTextField textTP;
	private JTextField textCP;
	private JTextField textAlt;
	private JTextField textEsp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textCO;
	private JTextField textCO2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VComRH dialog = new VComRH();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VComRH() {
		setBounds(350, 150, 503, 627);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);

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
		contentPane.setLayout(null);

		JSeparator separator2_5 = new JSeparator();
		separator2_5.setBounds(0, 36, 502, 2);
		separator2_5.setForeground(SystemColor.controlShadow);
		separator2_5.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_5);
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		contentPane.add(lblCerrar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPane.add(menuBar);

		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));

		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);

		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);

		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);

		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);

		JMenuItem mPersona = new JMenuItem("Persona");
		mPersona.setHorizontalAlignment(SwingConstants.LEFT);
		mPersona.setBackground(new Color(32, 178, 170));
		mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mPersona.setForeground(Color.BLACK);
		menuBusqueda.add(mPersona);

		JMenuItem mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
		mRestoHumano.setBackground(new Color(32, 178, 170));
		mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mRestoHumano.setForeground(Color.BLACK);
		menuBusqueda.add(mRestoHumano);

		JMenuItem mCaso = new JMenuItem("Caso");
		mCaso.setHorizontalAlignment(SwingConstants.LEFT);
		mCaso.setBackground(new Color(32, 178, 170));
		mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCaso.setForeground(Color.BLACK);
		menuBusqueda.add(mCaso);

		JMenuItem mBanda = new JMenuItem("Banda");
		mBanda.setHorizontalAlignment(SwingConstants.LEFT);
		mBanda.setBackground(new Color(32, 178, 170));
		mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mBanda.setForeground(Color.BLACK);
		menuBusqueda.add(mBanda);

		JMenuItem mCriminal = new JMenuItem("Criminales");
		mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
		mCriminal.setBackground(new Color(32, 178, 170));
		mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCriminal.setForeground(Color.BLACK);
		menuBusqueda.add(mCriminal);

		Button button = new Button("IDENTIFICAR");
		button.setBounds(397, 592, 96, 24);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(153, 0, 0));
		contentPane.add(button);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(26, 77, 81, 28);
		lblFecha.setForeground(new Color(0, 51, 102));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(26, 103, 106, 2);
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2);

		textFECHA = new JTextField();
		textFECHA.setBounds(26, 116, 187, 20);
		textFECHA.setEditable(false);
		textFECHA.setToolTipText("");
		textFECHA.setColumns(10);
		contentPane.add(textFECHA);

		JLabel lblUbi = new JLabel("UBICACI\u00D3N");
		lblUbi.setBounds(26, 135, 81, 28);
		lblUbi.setForeground(new Color(0, 51, 102));
		lblUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi);

		JSeparator separator2_1 = new JSeparator();
		separator2_1.setBounds(26, 161, 106, 2);
		separator2_1.setForeground(SystemColor.controlShadow);
		separator2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1);

		textUbi = new JTextField();
		textUbi.setBounds(26, 174, 187, 20);
		textUbi.setEnabled(false);
		textUbi.setEditable(false);
		textUbi.setToolTipText("");
		textUbi.setColumns(10);
		contentPane.add(textUbi);

		JLabel lblGen = new JLabel("SEXO");
		lblGen.setBounds(26, 203, 81, 28);
		lblGen.setForeground(new Color(0, 51, 102));
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen);

		JSeparator separator2_2 = new JSeparator();
		separator2_2.setBounds(26, 229, 106, 2);
		separator2_2.setForeground(SystemColor.controlShadow);
		separator2_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2);

		textGen = new JTextField();
		textGen.setBounds(26, 242, 187, 20);
		textGen.setEditable(false);
		textGen.setToolTipText("");
		textGen.setColumns(10);
		contentPane.add(textGen);

		JLabel lblTP = new JLabel("TIPO DE PELO");
		lblTP.setBounds(26, 261, 81, 28);
		lblTP.setForeground(new Color(0, 51, 102));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP);

		JSeparator separator2_1_1 = new JSeparator();
		separator2_1_1.setBounds(26, 287, 106, 2);
		separator2_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_1);

		textTP = new JTextField();
		textTP.setBounds(26, 300, 187, 20);
		textTP.setEditable(false);
		textTP.setToolTipText("");
		textTP.setColumns(10);
		contentPane.add(textTP);

		JLabel lblCP = new JLabel("COLOR DE PELO");
		lblCP.setBounds(26, 331, 106, 28);
		lblCP.setForeground(new Color(0, 51, 102));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP);

		JSeparator separator2_3 = new JSeparator();
		separator2_3.setBounds(26, 357, 106, 2);
		separator2_3.setForeground(SystemColor.controlShadow);
		separator2_3.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_3);

		textCP = new JTextField();
		textCP.setBounds(26, 370, 187, 20);
		textCP.setEditable(false);
		textCP.setToolTipText("");
		textCP.setColumns(10);
		contentPane.add(textCP);

		JLabel lblAlt = new JLabel("ALTURA");
		lblAlt.setBounds(26, 458, 81, 28);
		lblAlt.setForeground(new Color(0, 51, 102));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt);

		JSeparator separator2_1_2 = new JSeparator();
		separator2_1_2.setBounds(26, 484, 106, 2);
		separator2_1_2.setForeground(SystemColor.controlShadow);
		separator2_1_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_2);

		textAlt = new JTextField();
		textAlt.setBounds(26, 497, 187, 20);
		textAlt.setEditable(false);
		textAlt.setToolTipText("");
		textAlt.setColumns(10);
		contentPane.add(textAlt);

		JLabel lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setBounds(26, 526, 106, 28);
		lblEsp.setForeground(new Color(0, 51, 102));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp);

		JSeparator separator2_2_1 = new JSeparator();
		separator2_2_1.setBounds(26, 552, 106, 2);
		separator2_2_1.setForeground(SystemColor.controlShadow);
		separator2_2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2_1);

		textEsp = new JTextField();
		textEsp.setBounds(26, 565, 187, 20);
		textEsp.setEditable(false);
		textEsp.setToolTipText("");
		textEsp.setColumns(10);
		contentPane.add(textEsp);

		JLabel lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setBounds(264, 74, 81, 28);
		lblFecha_1.setForeground(new Color(153, 0, 0));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha_1);

		JSeparator separator2_4 = new JSeparator();
		separator2_4.setBounds(264, 100, 106, 2);
		separator2_4.setForeground(SystemColor.controlShadow);
		separator2_4.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_4);

		textField = new JTextField();
		textField.setBounds(264, 113, 187, 20);
		textField.setEditable(false);
		textField.setToolTipText("");
		textField.setColumns(10);
		contentPane.add(textField);

		JLabel lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setBounds(264, 132, 81, 28);
		lblUbi_1.setForeground(new Color(153, 0, 0));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi_1);

		JSeparator separator2_1_3 = new JSeparator();
		separator2_1_3.setBounds(264, 158, 106, 2);
		separator2_1_3.setForeground(SystemColor.controlShadow);
		separator2_1_3.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_3);

		textField_1 = new JTextField();
		textField_1.setBounds(264, 171, 187, 20);
		textField_1.setEditable(false);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JLabel lblGen_1 = new JLabel("SEXO");
		lblGen_1.setBounds(264, 200, 81, 28);
		lblGen_1.setForeground(new Color(153, 0, 0));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen_1);

		JSeparator separator2_2_2 = new JSeparator();
		separator2_2_2.setBounds(264, 226, 106, 2);
		separator2_2_2.setForeground(SystemColor.controlShadow);
		separator2_2_2.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_2);

		textField_2 = new JTextField();
		textField_2.setBounds(264, 239, 187, 20);
		textField_2.setEditable(false);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		JLabel lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setBounds(264, 258, 81, 28);
		lblTP_1.setForeground(new Color(153, 0, 0));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP_1);

		JSeparator separator2_1_1_1 = new JSeparator();
		separator2_1_1_1.setBounds(264, 284, 106, 2);
		separator2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_1_1);

		textField_3 = new JTextField();
		textField_3.setBounds(264, 297, 187, 20);
		textField_3.setEditable(false);
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		contentPane.add(textField_3);

		JLabel lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setBounds(264, 328, 106, 28);
		lblCP_1.setForeground(new Color(153, 0, 0));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP_1);

		JSeparator separator2_3_1 = new JSeparator();
		separator2_3_1.setBounds(264, 354, 106, 2);
		separator2_3_1.setForeground(SystemColor.controlShadow);
		separator2_3_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_3_1);

		textField_4 = new JTextField();
		textField_4.setBounds(264, 367, 187, 20);
		textField_4.setEditable(false);
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		contentPane.add(textField_4);

		JLabel lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setBounds(264, 458, 81, 28);
		lblAlt_1.setForeground(new Color(153, 0, 0));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt_1);

		JSeparator separator2_1_2_1 = new JSeparator();
		separator2_1_2_1.setBounds(264, 484, 106, 2);
		separator2_1_2_1.setForeground(SystemColor.controlShadow);
		separator2_1_2_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_2_1);

		textField_5 = new JTextField();
		textField_5.setBounds(264, 497, 187, 20);
		textField_5.setEditable(false);
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		contentPane.add(textField_5);

		JLabel lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setBounds(264, 526, 106, 28);
		lblEsp_1.setForeground(new Color(153, 0, 0));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp_1);

		JSeparator separator2_2_1_1 = new JSeparator();
		separator2_2_1_1.setBounds(264, 552, 106, 2);
		separator2_2_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_1_1);

		textField_6 = new JTextField();
		textField_6.setBounds(264, 565, 187, 20);
		textField_6.setEditable(false);
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		contentPane.add(textField_6);

		JLabel lblRestoHumano = new JLabel("Resto Humano");
		lblRestoHumano.setBounds(66, 48, 106, 19);
		lblRestoHumano.setForeground(new Color(0, 51, 102));
		lblRestoHumano.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblRestoHumano);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(54, 67, 126, 2);
		separator1.setForeground(new Color(0, 51, 102));
		separator1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator1);

		JLabel lblDesaparecida = new JLabel("Desaparecida");
		lblDesaparecida.setBounds(303, 48, 96, 19);
		lblDesaparecida.setForeground(new Color(153, 0, 0));
		lblDesaparecida.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblDesaparecida);

		JSeparator separator1_1 = new JSeparator();
		separator1_1.setBounds(287, 67, 126, 2);
		separator1_1.setForeground(new Color(153, 0, 0));
		separator1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator1_1);

		JLabel lblCO = new JLabel("COLOR DE OJOS");
		lblCO.setForeground(new Color(0, 51, 102));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(26, 389, 106, 28);
		contentPane.add(lblCO);

		JSeparator separator2_2_1_2 = new JSeparator();
		separator2_2_1_2.setForeground(SystemColor.controlShadow);
		separator2_2_1_2.setBackground(new Color(0, 51, 102));
		separator2_2_1_2.setBounds(26, 415, 106, 2);
		contentPane.add(separator2_2_1_2);

		textCO = new JTextField();
		textCO.setToolTipText("");
		textCO.setEditable(false);
		textCO.setColumns(10);
		textCO.setBounds(26, 428, 187, 20);
		contentPane.add(textCO);

		JLabel lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(153, 0, 0));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(264, 386, 106, 28);
		contentPane.add(lblCO2);

		JSeparator separator2_2_1_1_1 = new JSeparator();
		separator2_2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1_1.setBackground(new Color(153, 0, 0));
		separator2_2_1_1_1.setBounds(264, 412, 106, 2);
		contentPane.add(separator2_2_1_1_1);

		textCO2 = new JTextField();
		textCO2.setToolTipText("");
		textCO2.setEditable(false);
		textCO2.setColumns(10);
		textCO2.setBounds(264, 425, 187, 20);
		contentPane.add(textCO2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 200, 309, 317);
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		contentPane.add(lblNewLabel);
	}

	public VComRH(VIniciarSesion padre, boolean modal, RestoHumano rh, Persona des) {
		super(padre);
		this.setModal(modal);
		setBounds(350, 150, 503, 627);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);

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
		contentPane.setLayout(null);

		JSeparator separator2_5 = new JSeparator();
		separator2_5.setBounds(0, 36, 502, 2);
		separator2_5.setForeground(SystemColor.controlShadow);
		separator2_5.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_5);
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		contentPane.add(lblCerrar);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 502, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPane.add(menuBar);

		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));

		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);

		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGestionar);

		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuComparar);

		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(new Color(255, 255, 255));
		menuBar.add(menuBusqueda);

		JMenuItem mPersona = new JMenuItem("Persona");
		mPersona.setHorizontalAlignment(SwingConstants.LEFT);
		mPersona.setBackground(new Color(32, 178, 170));
		mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mPersona.setForeground(Color.BLACK);
		menuBusqueda.add(mPersona);

		JMenuItem mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
		mRestoHumano.setBackground(new Color(32, 178, 170));
		mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mRestoHumano.setForeground(Color.BLACK);
		menuBusqueda.add(mRestoHumano);

		JMenuItem mCaso = new JMenuItem("Caso");
		mCaso.setHorizontalAlignment(SwingConstants.LEFT);
		mCaso.setBackground(new Color(32, 178, 170));
		mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCaso.setForeground(Color.BLACK);
		menuBusqueda.add(mCaso);

		JMenuItem mBanda = new JMenuItem("Banda");
		mBanda.setHorizontalAlignment(SwingConstants.LEFT);
		mBanda.setBackground(new Color(32, 178, 170));
		mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mBanda.setForeground(Color.BLACK);
		menuBusqueda.add(mBanda);

		JMenuItem mCriminal = new JMenuItem("Criminales");
		mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
		mCriminal.setBackground(new Color(32, 178, 170));
		mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCriminal.setForeground(Color.BLACK);
		menuBusqueda.add(mCriminal);

		Button button = new Button("IDENTIFICAR");
		button.setBounds(397, 592, 96, 24);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(153, 0, 0));
		contentPane.add(button);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(26, 77, 81, 28);
		lblFecha.setForeground(new Color(0, 51, 102));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(26, 103, 106, 2);
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2);

		textFECHA = new JTextField();
		textFECHA.setBounds(26, 116, 187, 20);
		textFECHA.setEditable(false);
		textFECHA.setToolTipText("");
		textFECHA.setColumns(10);
		contentPane.add(textFECHA);

		JLabel lblUbi = new JLabel("UBICACI\u00D3N");
		lblUbi.setBounds(26, 135, 81, 28);
		lblUbi.setForeground(new Color(0, 51, 102));
		lblUbi.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi);

		JSeparator separator2_1 = new JSeparator();
		separator2_1.setBounds(26, 161, 106, 2);
		separator2_1.setForeground(SystemColor.controlShadow);
		separator2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1);

		textUbi = new JTextField();
		textUbi.setBounds(26, 174, 187, 20);
		textUbi.setEnabled(false);
		textUbi.setEditable(false);
		textUbi.setToolTipText("");
		textUbi.setColumns(10);
		contentPane.add(textUbi);

		JLabel lblGen = new JLabel("SEXO");
		lblGen.setBounds(26, 203, 81, 28);
		lblGen.setForeground(new Color(0, 51, 102));
		lblGen.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen);

		JSeparator separator2_2 = new JSeparator();
		separator2_2.setBounds(26, 229, 106, 2);
		separator2_2.setForeground(SystemColor.controlShadow);
		separator2_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2);

		textGen = new JTextField();
		textGen.setBounds(26, 242, 187, 20);
		textGen.setEditable(false);
		textGen.setToolTipText("");
		textGen.setColumns(10);
		contentPane.add(textGen);

		JLabel lblTP = new JLabel("TIPO DE PELO");
		lblTP.setBounds(26, 261, 81, 28);
		lblTP.setForeground(new Color(0, 51, 102));
		lblTP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP);

		JSeparator separator2_1_1 = new JSeparator();
		separator2_1_1.setBounds(26, 287, 106, 2);
		separator2_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_1);

		textTP = new JTextField();
		textTP.setBounds(26, 300, 187, 20);
		textTP.setEditable(false);
		textTP.setToolTipText("");
		textTP.setColumns(10);
		contentPane.add(textTP);

		JLabel lblCP = new JLabel("COLOR DE PELO");
		lblCP.setBounds(26, 331, 106, 28);
		lblCP.setForeground(new Color(0, 51, 102));
		lblCP.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP);

		JSeparator separator2_3 = new JSeparator();
		separator2_3.setBounds(26, 357, 106, 2);
		separator2_3.setForeground(SystemColor.controlShadow);
		separator2_3.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_3);

		textCP = new JTextField();
		textCP.setBounds(26, 370, 187, 20);
		textCP.setEditable(false);
		textCP.setToolTipText("");
		textCP.setColumns(10);
		contentPane.add(textCP);

		JLabel lblAlt = new JLabel("ALTURA");
		lblAlt.setBounds(26, 458, 81, 28);
		lblAlt.setForeground(new Color(0, 51, 102));
		lblAlt.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt);

		JSeparator separator2_1_2 = new JSeparator();
		separator2_1_2.setBounds(26, 484, 106, 2);
		separator2_1_2.setForeground(SystemColor.controlShadow);
		separator2_1_2.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_1_2);

		textAlt = new JTextField();
		textAlt.setBounds(26, 497, 187, 20);
		textAlt.setEditable(false);
		textAlt.setToolTipText("");
		textAlt.setColumns(10);
		contentPane.add(textAlt);

		JLabel lblEsp = new JLabel("ESPECIFICACIONES");
		lblEsp.setBounds(26, 526, 106, 28);
		lblEsp.setForeground(new Color(0, 51, 102));
		lblEsp.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp);

		JSeparator separator2_2_1 = new JSeparator();
		separator2_2_1.setBounds(26, 552, 106, 2);
		separator2_2_1.setForeground(SystemColor.controlShadow);
		separator2_2_1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator2_2_1);

		textEsp = new JTextField();
		textEsp.setBounds(26, 565, 187, 20);
		textEsp.setEditable(false);
		textEsp.setToolTipText("");
		textEsp.setColumns(10);
		contentPane.add(textEsp);

		JLabel lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setBounds(264, 74, 81, 28);
		lblFecha_1.setForeground(new Color(153, 0, 0));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblFecha_1);

		JSeparator separator2_4 = new JSeparator();
		separator2_4.setBounds(264, 100, 106, 2);
		separator2_4.setForeground(SystemColor.controlShadow);
		separator2_4.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_4);

		textField = new JTextField();
		textField.setBounds(264, 113, 187, 20);
		textField.setEditable(false);
		textField.setToolTipText("");
		textField.setColumns(10);
		contentPane.add(textField);

		JLabel lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setBounds(264, 132, 81, 28);
		lblUbi_1.setForeground(new Color(153, 0, 0));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblUbi_1);

		JSeparator separator2_1_3 = new JSeparator();
		separator2_1_3.setBounds(264, 158, 106, 2);
		separator2_1_3.setForeground(SystemColor.controlShadow);
		separator2_1_3.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_3);

		textField_1 = new JTextField();
		textField_1.setBounds(264, 171, 187, 20);
		textField_1.setEditable(false);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JLabel lblGen_1 = new JLabel("SEXO");
		lblGen_1.setBounds(264, 200, 81, 28);
		lblGen_1.setForeground(new Color(153, 0, 0));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblGen_1);

		JSeparator separator2_2_2 = new JSeparator();
		separator2_2_2.setBounds(264, 226, 106, 2);
		separator2_2_2.setForeground(SystemColor.controlShadow);
		separator2_2_2.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_2);

		textField_2 = new JTextField();
		textField_2.setBounds(264, 239, 187, 20);
		textField_2.setEditable(false);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		JLabel lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setBounds(264, 258, 81, 28);
		lblTP_1.setForeground(new Color(153, 0, 0));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblTP_1);

		JSeparator separator2_1_1_1 = new JSeparator();
		separator2_1_1_1.setBounds(264, 284, 106, 2);
		separator2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_1_1);

		textField_3 = new JTextField();
		textField_3.setBounds(264, 297, 187, 20);
		textField_3.setEditable(false);
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		contentPane.add(textField_3);

		JLabel lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setBounds(264, 328, 106, 28);
		lblCP_1.setForeground(new Color(153, 0, 0));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblCP_1);

		JSeparator separator2_3_1 = new JSeparator();
		separator2_3_1.setBounds(264, 354, 106, 2);
		separator2_3_1.setForeground(SystemColor.controlShadow);
		separator2_3_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_3_1);

		textField_4 = new JTextField();
		textField_4.setBounds(264, 367, 187, 20);
		textField_4.setEditable(false);
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		contentPane.add(textField_4);

		JLabel lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setBounds(264, 458, 81, 28);
		lblAlt_1.setForeground(new Color(153, 0, 0));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblAlt_1);

		JSeparator separator2_1_2_1 = new JSeparator();
		separator2_1_2_1.setBounds(264, 484, 106, 2);
		separator2_1_2_1.setForeground(SystemColor.controlShadow);
		separator2_1_2_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_1_2_1);

		textField_5 = new JTextField();
		textField_5.setBounds(264, 497, 187, 20);
		textField_5.setEditable(false);
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		contentPane.add(textField_5);

		JLabel lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setBounds(264, 526, 106, 28);
		lblEsp_1.setForeground(new Color(153, 0, 0));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(lblEsp_1);

		JSeparator separator2_2_1_1 = new JSeparator();
		separator2_2_1_1.setBounds(264, 552, 106, 2);
		separator2_2_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator2_2_1_1);

		textField_6 = new JTextField();
		textField_6.setBounds(264, 565, 187, 20);
		textField_6.setEditable(false);
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		contentPane.add(textField_6);

		JLabel lblRestoHumano = new JLabel("Resto Humano");
		lblRestoHumano.setBounds(66, 48, 106, 19);
		lblRestoHumano.setForeground(new Color(0, 51, 102));
		lblRestoHumano.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblRestoHumano);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(54, 67, 126, 2);
		separator1.setForeground(new Color(0, 51, 102));
		separator1.setBackground(new Color(0, 51, 102));
		contentPane.add(separator1);

		JLabel lblDesaparecida = new JLabel("Desaparecida");
		lblDesaparecida.setBounds(303, 48, 96, 19);
		lblDesaparecida.setForeground(new Color(153, 0, 0));
		lblDesaparecida.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		contentPane.add(lblDesaparecida);

		JSeparator separator1_1 = new JSeparator();
		separator1_1.setBounds(287, 67, 126, 2);
		separator1_1.setForeground(new Color(153, 0, 0));
		separator1_1.setBackground(new Color(153, 0, 0));
		contentPane.add(separator1_1);

		JLabel lblCO = new JLabel("COLOR DE OJOS");
		lblCO.setForeground(new Color(0, 51, 102));
		lblCO.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO.setBounds(26, 389, 106, 28);
		contentPane.add(lblCO);

		JSeparator separator2_2_1_2 = new JSeparator();
		separator2_2_1_2.setForeground(SystemColor.controlShadow);
		separator2_2_1_2.setBackground(new Color(0, 51, 102));
		separator2_2_1_2.setBounds(26, 415, 106, 2);
		contentPane.add(separator2_2_1_2);

		textCO = new JTextField();
		textCO.setToolTipText("");
		textCO.setEditable(false);
		textCO.setColumns(10);
		textCO.setBounds(26, 428, 187, 20);
		contentPane.add(textCO);

		JLabel lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(153, 0, 0));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(264, 386, 106, 28);
		contentPane.add(lblCO2);

		JSeparator separator2_2_1_1_1 = new JSeparator();
		separator2_2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1_1.setBackground(new Color(153, 0, 0));
		separator2_2_1_1_1.setBounds(264, 412, 106, 2);
		contentPane.add(separator2_2_1_1_1);

		textCO2 = new JTextField();
		textCO2.setToolTipText("");
		textCO2.setEditable(false);
		textCO2.setColumns(10);
		textCO2.setBounds(264, 425, 187, 20);
		contentPane.add(textCO2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(90, 200, 309, 317);
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		contentPane.add(lblNewLabel);
	}

	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
