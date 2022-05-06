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

import controlador.interfaces.ContDatosBusq;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VInserciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VIniciarSesion vInicio = null;
	private ContDatosBusq datos;
	private String[] info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInserciones dialog = new VInserciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 * @param b 
	 * @param vPrincipal 
	 */
	public VInserciones() {
		setTitle("Insertar");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);

		JSeparator separator = new JSeparator();
		separator.setBounds(93, 227, 27, -47);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPanel.add(separator);

		Button btnPersona = new Button("Persona");
		btnPersona.setBackground(new Color(153, 0, 0));
		btnPersona.setForeground(Color.WHITE);
		btnPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		btnPersona.setBounds(88, 139, 168, 67);
		btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnPersona);

		Button btnRestoHumano = new Button("Resto Humano");
		btnRestoHumano.setBackground(new Color(153, 0, 0));
		btnRestoHumano.setForeground(Color.WHITE);
		btnRestoHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		btnRestoHumano.setBounds(349, 139, 168, 67);
		btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnRestoHumano);

		Button btnCaso = new Button("Caso");
		btnCaso.setBackground(new Color(153, 0, 0));
		btnCaso.setForeground(Color.WHITE);
		btnCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		btnCaso.setBounds(231, 238, 168, 67);
		btnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnCaso);

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
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
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
		menuComparar.setBackground(new Color(0, 51, 102));
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
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));
		menuBar.add(menUsuario);

		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 37, 607, 362);
		contentPanel.add(lblNewLabel);

	}

	public VInserciones(VIniciarSesion vInicio, boolean modal, String info) {
		super(vInicio);
		this.setModal(modal);

		setTitle("Insertar");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);

		JSeparator separator = new JSeparator();
		separator.setBounds(93, 227, 27, -47);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPanel.add(separator);

		Button btnPersona = new Button("Persona");
		btnPersona.setBackground(new Color(153, 0, 0));
		btnPersona.setForeground(Color.WHITE);
		btnPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		btnPersona.setBounds(93, 140, 168, 67);
		btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnPersona);

		Button btnRestoHumano = new Button("Resto Humano");
		btnRestoHumano.setBackground(new Color(153, 0, 0));
		btnRestoHumano.setForeground(Color.WHITE);
		btnRestoHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		btnRestoHumano.setBounds(340, 140, 168, 67);
		btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnRestoHumano);

		Button btnCaso = new Button("Caso");
		btnCaso.setBackground(new Color(153, 0, 0));
		btnCaso.setForeground(Color.WHITE);
		btnCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		btnCaso.setBounds(221, 239, 168, 67);
		btnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPanel.add(btnCaso);

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
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
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
		menuComparar.setBackground(new Color(0, 51, 102));
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
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));
		menuBar.add(menUsuario);

		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 37, 607, 362);
		contentPanel.add(lblNewLabel);
	}
	
	
	
	private void volver() {
		VPrincipal principal = new VPrincipal(vInicio, true, info);
		this.dispose();
		principal.setVisible(true);
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