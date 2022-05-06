package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controlador.DataFactoryBusq;
import controlador.interfaces.ContDatosBusq;
import modelo.clases.*;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Map;
import java.awt.event.ActionEvent;


public class VBusqueda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVBusqueda;
	private VIniciarSesion vInicio = null;
	private JButton btnBuscar;
	private JRadioButton rdbtnPersona;
	private JRadioButton rdbtnRestoHumano;
	private JRadioButton rdbtnCaso;
	private JButton btnVolver;
	private ButtonGroup grupo = new ButtonGroup();
	private JLabel imagen;
	private Button buttonBuscar;
	
	private Map<String, Caso> casos;
	private Map<String, Persona> personas;
	private Map<String, RestoHumano> restos;
	private ContDatosBusq datos;
	private String[] info;
	
	ContDatosBusq datos2 = DataFactoryBusq.getDatos();

	public VBusqueda(VIniciarSesion vInicio, boolean modal, ContDatosBusq datos, String info) {
		super(vInicio);
		this.setModal(modal);
		setTitle("Introducir Identificador");
		setBounds(100, 100, 465, 327);
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		{
			textVBusqueda = new JTextField();
			textVBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (!textVBusqueda.getText().isBlank()) {
						btnBuscar.setEnabled(true);
					} else {
						btnBuscar.setEnabled(false);
					}
				}
			});
			textVBusqueda.setBounds(201, 119, 205, 20);
			contentPanel.add(textVBusqueda);
			textVBusqueda.setColumns(10);
			textVBusqueda.setBounds(201, 119, 205, 20);
			contentPanel.add(textVBusqueda);
			textVBusqueda.setColumns(10);
		}
		
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
		
		rdbtnPersona = new JRadioButton("Persona");
		grupo.add(rdbtnPersona);
		JRadioButton rdbtnPersona = new JRadioButton("Persona");
		rdbtnPersona.setBackground(Color.WHITE);
		rdbtnPersona.setFocusPainted(false);
		rdbtnPersona.setIgnoreRepaint(true);
		rdbtnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPersona.setBounds(10, 44, 85, 23);
		contentPanel.add(rdbtnPersona);
		
		rdbtnRestoHumano = new JRadioButton("Resto Humano");
		rdbtnRestoHumano.setBackground(Color.WHITE);
		grupo.add(rdbtnRestoHumano);
		rdbtnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRestoHumano.setBounds(107, 44, 109, 23);
		contentPanel.add(rdbtnRestoHumano);
		
		rdbtnCaso = new JRadioButton("Caso");
		grupo.add(rdbtnCaso);
		JRadioButton rdbtnCaso = new JRadioButton("Caso");
		rdbtnCaso.setBackground(Color.WHITE);
		rdbtnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCaso.setBounds(249, 44, 74, 23);
		contentPanel.add(rdbtnCaso);
		
		JLabel lblNewLabel = new JLabel("Introduce el Identificador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 120, 175, 14);
		contentPanel.add(lblNewLabel);
		
		btnVolver = new JButton("Volver");
		
		buttonBuscar = new Button("Buscar");
		buttonBuscar.setBounds(237, 197, 98, 28);
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda(vInicio,datos);
			}
		});
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setBackground(new Color(153, 0, 0));
		buttonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBuscar.setEnabled(false);
		contentPanel.add(buttonBuscar);
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setBounds(0, 37, 607, 362);
		contentPanel.add(imagen);
	}

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	public boolean comprobarDNI(String dni) {
		return datos.comprobarDNI(dni);
	}
	
	public boolean buscarRH(String codResto) {
		return datos.buscarRH(codResto);
	}


	public Caso buscarCaso(String codCaso) {
		return datos.buscarCaso(codCaso);
	}
	
	private void busqueda(VIniciarSesion vInicio, ContDatosBusq datos) {
		// TODO Auto-generated method stub
	
		if(rdbtnCaso.isSelected() && buscarCaso(textVBusqueda.getText())!= null) {
			VBusCaso ventCaso = new VBusCaso(vInicio, true, textVBusqueda.getText(), datos);
			ventCaso.setVisible(true);
		}else if(rdbtnPersona.isSelected() && comprobarDNI(textVBusqueda.getText())){
			VBusPer ventPer = new VBusPer(vInicio, true, textVBusqueda.getText(), datos);
			ventPer.setVisible(true);
		}else if(rdbtnRestoHumano.isSelected() && buscarRH(textVBusqueda.getText())) {
			VBusRH ventRH = new VBusRH(vInicio, true, textVBusqueda.getText(), datos);
			ventRH.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "El identificador introducido no esta registrado",  "Error!!", JOptionPane.ERROR_MESSAGE);
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
