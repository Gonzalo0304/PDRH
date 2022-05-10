package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VInserciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VIniciarSesion padre;
	private JSeparator separator;
	private Button btnPersona;
	private Button btnRestoHumano;
	private Button btnCaso;
	private JLabel lblNewLabel_9;
	private JMenuBar menuBar;
	private JMenu menuInsertar;
	private String[] info;
	private JMenuItem mnitInsPer;
	private JMenuItem mnitInsRH;
	private JMenuItem mnitInsCaso;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JLabel lblNewLabel;

	public VInserciones(VIniciarSesion padre, boolean modal, String[] infos) {
		super(padre);
		this.setModal(modal);
		this.padre = padre;
		info = infos;

		setTitle("Insertar");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);

		separator = new JSeparator();
		separator.setBounds(93, 227, 27, -47);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPanel.add(separator);

		btnPersona = new Button("Persona");
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

		btnRestoHumano = new Button("Resto Humano");
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

		btnCaso = new Button("Caso");
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

		lblNewLabel_9 = new JLabel("x");
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

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 607, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		contentPanel.add(menuBar);

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(new Color(255, 255, 255));
		menuBar.add(menuInsertar);

		mnitInsPer = new JMenuItem("Persona");
		mnitInsPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		menuInsertar.add(mnitInsPer);

		mnitInsRH = new JMenuItem("Resto Humano");
		mnitInsRH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarRestoHumano();
			}
		});
		menuInsertar.add(mnitInsRH);

		mnitInsCaso = new JMenuItem("Caso");
		mnitInsCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarCaso();
			}
		});
		menuInsertar.add(mnitInsCaso);

		menuGestionar = new JMenu("Gestionar");
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

		menuComparar = new JMenu("Comparar");
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

		menuBusqueda = new JMenu("Busqueda");
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

		menUsuario = new JMenu("Usuario");
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(new Color(255, 255, 255));
		menuBar.add(menUsuario);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 37, 607, 362);
		contentPanel.add(lblNewLabel);
	}

	private void volver() {
		VPrincipal principal = new VPrincipal(padre, true, info);
		this.dispose();
		principal.setVisible(true);
	}

	private void insertarCaso() {
		VInsCaso caso = new VInsCaso(padre, true, info);
		this.dispose();
		caso.setVisible(true);

	}

	private void insertarRestoHumano() {
		VInsRH restoHumano = new VInsRH(padre, true, info);
		this.dispose();
		restoHumano.setVisible(true);

	}

	private void insertarPersona() {
		VInsPersona persona = new VInsPersona(padre, true, info);
		this.dispose();
		persona.setVisible(true);
	}

	private void gestionar() {
		VGestion gestion = new VGestion(padre, true, info);
		this.dispose();
		gestion.setVisible(true);
	}

	private void comparar() {
		VComparacion comparacion = new VComparacion(padre, true, info);
		this.dispose();
		comparacion.setVisible(true);
	}

	private void buscar() {
		VBusqueda busqueda = new VBusqueda(padre, true, info);
		this.dispose();
		busqueda.setVisible(true);
	}
}