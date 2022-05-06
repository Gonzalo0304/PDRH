package vista;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
=======
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
>>>>>>> d17b25ce5004bb03f4cb31e6dae29236e4b53bd4
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

<<<<<<< HEAD
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.FlowLayout;

public class VIniciarSesion extends JFrame implements ActionListener {
=======
import controlador.DataFactoryIS;
import controlador.interfaces.ControladorDatosIS;


public class VIniciarSesion extends JFrame implements ActionListener,ControladorDatosIS {

	private static final long serialVersionUID = 1L;
	
	// <--- Elementos --->
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private static Point point = new Point();
	private Button buttonIS;
	private JTextField textIdentificador;
	private JButton btnSalir;
	private JButton btnAceptar;
	private JPasswordField contrasena;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param vBusRapida 
	 * @param vPrincipal 
	 */
	public VIniciarSesion() {
	private JLabel lblContra;
	private JLabel lblCerrar;
	private JLabel lblUsuario;
	private JLabel lblIntroUsu;
	private JLabel lblIntroContra;
	private JPanel panelBlanco;
	private JLabel imgErtz;
	private JLabel imgVizIz;
	private JLabel lblPDyRH;
	private JSeparator separator1;
	private JSeparator separator2;
	private JSeparator separator3;
	private JLabel lblInfo;
	private JLabel imgVizDer;
	
	// <--- Datos BD --->
	ControladorDatosIS datos = DataFactoryIS.getDatos();
	
	// <--- Ejecución --->
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new VIniciarSesion();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VIniciarSesion() {
		// <--- Diseño ventana --->
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 336);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		setContentPane(contentPane);
		setUndecorated(true); // Sin borde predeterminado
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
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
		
		buttonIS = new Button("INICIAR SESI\u00D3N");
		buttonIS.addActionListener(this);
		buttonIS.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonIS.setForeground(Color.WHITE);
		buttonIS.setBackground(new Color(153, 0, 0));

		buttonIS.setBounds(341, 252, 126, 31);
		contentPane.add(buttonIS);

		JPanel panelBlanco = new JPanel();

		buttonIS.setBounds(341, 271, 126, 31);
		contentPane.add(buttonIS);
		
		// En caso de textField de Usuario vacío
		lblIntroUsu = new JLabel("Introduce el usuario");
		lblIntroUsu.setVisible(false);
		lblIntroUsu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroUsu.setForeground(new Color(153, 0, 0));
		lblIntroUsu.setBounds(341, 133, 114, 14);
		contentPane.add(lblIntroUsu);
		
		// En caso de textField de Contraseña vacío
		lblIntroContra = new JLabel("Introduce la contrase\u00F1a");
		lblIntroContra.setVisible(false);
		lblIntroContra.setForeground(new Color(153, 0, 0));
		lblIntroContra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroContra.setBounds(341, 226, 136, 14);
		contentPane.add(lblIntroContra);

		panelBlanco = new JPanel();

		panelBlanco.setForeground(new Color(0, 0, 0));
		panelBlanco.setBorder(new LineBorder(SystemColor.controlShadow));
		panelBlanco.setBackground(Color.WHITE);
		panelBlanco.setBounds(0, 0, 319, 336);
		contentPane.add(panelBlanco);
		panelBlanco.setLayout(null);

		JLabel imgErtz = new JLabel("New label");
		imgErtz.setIcon(new ImageIcon(VIniciarSesion.class.getResource("/images/Ertzaintza3.png")));
		imgErtz.setBounds(40, 58, 231, 216);
		panelBlanco.add(imgErtz);

		JLabel imgVizIz = new JLabel("New label");
		imgVizIz.setIcon(new ImageIcon(VIniciarSesion.class.getResource("/images/pais-vasco1.png")));
		imgErtz = new JLabel("New label");
		imgErtz.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\Ertzaintza3.png"));
		imgErtz.setBounds(40, 58, 231, 216);
		panelBlanco.add(imgErtz);

		imgVizIz = new JLabel("New label");
		imgVizIz.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\pais-vasco1.png"));

		imgVizIz.setBounds(-89, 0, 483, 336);
		panelBlanco.add(imgVizIz);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("C\u00F3digo del usuario");
		txtUsuario.setBounds(341, 102, 283, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);


		JLabel lblUsuario = new JLabel("USUARIO");

		lblUsuario = new JLabel("USUARIO");

		lblUsuario.setForeground(SystemColor.controlHighlight);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(341, 63, 81, 28);
		contentPane.add(lblUsuario);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Contrase\u00F1a");
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(341, 195, 283, 31);
		contentPane.add(passwordField);


		JLabel lblCerrar = new JLabel("x");

		
		// Botón para cerrar la ventana
		lblCerrar = new JLabel("x");

		lblCerrar.setBackground(new Color(153, 0, 0));
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setForeground(new Color(0,51,102));
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
		lblCerrar.setBounds(644, 0, 31, 19);
		contentPane.add(lblCerrar);

		JLabel lblContra = new JLabel("CONTRASE\u00D1A");

		lblContra = new JLabel("CONTRASE\u00D1A");

		lblContra.setForeground(SystemColor.controlHighlight);
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContra.setBounds(341, 156, 114, 28);
		contentPane.add(lblContra);

		JLabel lblPDyRH = new JLabel("Personas Desaparecidas y Restos Humanos");
		lblPDyRH.setForeground(SystemColor.activeCaptionBorder);
		lblPDyRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblPDyRH.setBounds(329, 11, 295, 19);
		contentPane.add(lblPDyRH);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(102, 0, 0));
		separator1.setBackground(new Color(153, 0, 0));
		separator1.setBounds(329, 37, 303, 2);
		contentPane.add(separator1);

		JSeparator separator2 = new JSeparator();
		lblPDyRH = new JLabel("Personas Desaparecidas y Restos Humanos");
		lblPDyRH.setForeground(SystemColor.activeCaptionBorder);
		lblPDyRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblPDyRH.setBounds(329, 24, 295, 19);
		contentPane.add(lblPDyRH);

		separator1 = new JSeparator();
		separator1.setForeground(new Color(102, 0, 0));
		separator1.setBackground(new Color(153, 0, 0));
		separator1.setBounds(329, 50, 303, 2);
		contentPane.add(separator1);

		separator2 = new JSeparator();
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(SystemColor.controlHighlight);
		separator2.setBounds(341, 89, 114, 2);
		contentPane.add(separator2);


		JSeparator separator3 = new JSeparator();
		separator3 = new JSeparator();
		separator3.setForeground(SystemColor.controlShadow);
		separator3.setBackground(SystemColor.controlHighlight);
		separator3.setBounds(341, 182, 114, 2);
		contentPane.add(separator3);

		JLabel lblInfo = new JLabel("El uso no autorizado de esta aplicaci\u00F3n queda totalmente prohibido.");
		lblInfo = new JLabel("El uso no autorizado de esta aplicaci\u00F3n queda totalmente prohibido.");
		lblInfo.setForeground(SystemColor.controlHighlight);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblInfo.setBounds(431, 308, 244, 28);
		contentPane.add(lblInfo);

		JLabel imgVizDer = new JLabel("New label");
		imgVizDer.setIcon(new ImageIcon(VIniciarSesion.class.getResource("/images/pais-vasco1A.png")));
		imgVizDer.setBounds(-89, 0, 723, 336);
		contentPane.add(imgVizDer);
	}

	protected void cerrar() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonIS)) {
			
		}
	}
}

		imgVizDer = new JLabel("New label");
		imgVizDer.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\pais-vasco1A.png"));
		imgVizDer.setBounds(-89, 0, 723, 336);
		contentPane.add(imgVizDer);
	}
	
	// <--- Métodos --->
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonIS)) {
			verificar();
		}
		
	}
	
	// Cerrar la ventana
	public void cerrar() {
		this.dispose();
	}
	
	// Comprobar los datos introducidos
	private void verificar() {
		boolean vacio = false;
		lblIntroUsu.setVisible(false);
		lblIntroContra.setVisible(false);
		
		if (txtUsuario.getText().isBlank()) {
			lblIntroUsu.setVisible(true);
			vacio = true;
		}
		if (new String(passwordField.getPassword()).isBlank()) {
			lblIntroContra.setVisible(true);
			vacio = true;
		}
		if (!vacio) {
			String[] info = new String[3];
			info = comprobarCredenciales(txtUsuario.getText());
			if (info == null) {
				JOptionPane.showMessageDialog(this, "Los datos introducidos no son correctos.", "Identificación fallida.", JOptionPane.ERROR_MESSAGE);
			} else {
				VPrincipal main = new VPrincipal(this,true,info);
				this.dispose();
				main.setVisible(true);
			}
		}
		txtUsuario.setText("");
		passwordField.setText("");
	}

	@Override
	public String[] comprobarCredenciales(String usuario) {
		String[] info = new String[3];
		info = datos.comprobarCredenciales(usuario);
		if (info != null) {
			if (info[1].equals(new String(passwordField.getPassword()))) {
				return datos.comprobarCredenciales(usuario);
			}
		}
		return null;
	}
}

