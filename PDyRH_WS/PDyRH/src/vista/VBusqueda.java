package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
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
	private Map<String, Caso> casos;
	private Map<String, Persona> personas;
	private Map<String, RestoHumano> restos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusqueda dialog = new VBusqueda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBusqueda(VIniciarSesion vInicio, boolean modal) {
		super(vInicio);
		this.setModal(modal);
		setTitle("Introducir Identificador");
		setBounds(100, 100, 465, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textVBusqueda = new JTextField();
			textVBusqueda.setBounds(201, 119, 205, 20);
			contentPanel.add(textVBusqueda);
			textVBusqueda.setColumns(10);
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 463, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.BLACK);
		menuBar.add(menuInsertar);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.BLACK);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.BLACK);
		menuBar.add(menuComparar);
		
		JMenuItem mTotal = new JMenuItem("Total");
		mTotal.setHorizontalAlignment(SwingConstants.LEFT);
		mTotal.setBackground(new Color(32, 178, 170));
		mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mTotal.setForeground(Color.BLACK);
		menuComparar.add(mTotal);
		
		JMenuItem mEspecifico = new JMenuItem("Especifico");
		mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
		mEspecifico.setBackground(new Color(32, 178, 170));
		mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mEspecifico.setForeground(Color.BLACK);
		menuComparar.add(mEspecifico);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		rdbtnPersona = new JRadioButton("Persona");
		grupo.add(rdbtnPersona);
		JRadioButton rdbtnPersona = new JRadioButton("Persona");
		rdbtnPersona.setFocusPainted(false);
		rdbtnPersona.setIgnoreRepaint(true);
		rdbtnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPersona.setBounds(10, 44, 85, 23);
		contentPanel.add(rdbtnPersona);
		
		rdbtnRestoHumano = new JRadioButton("Resto Humano");
		grupo.add(rdbtnRestoHumano);
		rdbtnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRestoHumano.setBounds(107, 44, 109, 23);
		contentPanel.add(rdbtnRestoHumano);
		
		rdbtnCaso = new JRadioButton("Caso");
		grupo.add(rdbtnCaso);
		JRadioButton rdbtnCaso = new JRadioButton("Caso");
		rdbtnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCaso.setBounds(249, 44, 74, 23);
		contentPanel.add(rdbtnCaso);
		
		JLabel lblNewLabel = new JLabel("Introduce el Identificador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 120, 175, 14);
		contentPanel.add(lblNewLabel);
		
		btnVolver = new JButton("Volver");
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(350, 246, 89, 31);
		contentPanel.add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setEnabled(true);
	}

	public VBusqueda() {
		setTitle("Introducir Identificador");
		setBounds(100, 100, 465, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textVBusqueda = new JTextField();
			textVBusqueda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			textVBusqueda.setBounds(201, 119, 205, 20);
			contentPanel.add(textVBusqueda);
			textVBusqueda.setColumns(10);
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 463, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.BLACK);
		menuBar.add(menuInsertar);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.BLACK);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.BLACK);
		menuBar.add(menuComparar);
		
		JMenuItem mTotal = new JMenuItem("Total");
		mTotal.setHorizontalAlignment(SwingConstants.LEFT);
		mTotal.setBackground(new Color(32, 178, 170));
		mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mTotal.setForeground(Color.BLACK);
		menuComparar.add(mTotal);
		
		JMenuItem mEspecifico = new JMenuItem("Especifico");
		mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
		mEspecifico.setBackground(new Color(32, 178, 170));
		mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mEspecifico.setForeground(Color.BLACK);
		menuComparar.add(mEspecifico);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		rdbtnPersona = new JRadioButton("Persona");
		grupo.add(rdbtnPersona);
		rdbtnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPersona.setBounds(10, 44, 85, 23);
		contentPanel.add(rdbtnPersona);
		
		rdbtnRestoHumano = new JRadioButton("Resto Humano");
		grupo.add(rdbtnRestoHumano);
		rdbtnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRestoHumano.setBounds(107, 44, 109, 23);
		contentPanel.add(rdbtnRestoHumano);
		
		rdbtnCaso = new JRadioButton("Caso");
		grupo.add(rdbtnCaso);
		rdbtnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCaso.setBounds(249, 44, 74, 23);
		contentPanel.add(rdbtnCaso);
		
		JLabel lblNewLabel = new JLabel("Introduce el Identificador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 120, 175, 14);
		contentPanel.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(350, 246, 89, 31);
		contentPanel.add(btnVolver);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscar.setBounds(178, 172, 89, 31);
		contentPanel.add(btnBuscar);
	}
	
	public VBusqueda(VPrincipal vMain, boolean modal, ContDatosBusq datos) {
		super(vMain);
		this.setModal(modal);
		setTitle("Introducir Identificador");
		setBounds(100, 100, 465, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textVBusqueda = new JTextField();
			textVBusqueda.setBounds(201, 119, 205, 20);
			contentPanel.add(textVBusqueda);
			textVBusqueda.setColumns(10);
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 463, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPanel.add(menuBar);
		
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.BLACK);
		menuBar.add(menuInsertar);
		
		JMenu menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.BLACK);
		menuBar.add(menuGestionar);
		
		JMenu menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.BLACK);
		menuBar.add(menuComparar);
		
		JMenuItem mTotal = new JMenuItem("Total");
		mTotal.setHorizontalAlignment(SwingConstants.LEFT);
		mTotal.setBackground(new Color(32, 178, 170));
		mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mTotal.setForeground(Color.BLACK);
		menuComparar.add(mTotal);
		
		JMenuItem mEspecifico = new JMenuItem("Especifico");
		mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
		mEspecifico.setBackground(new Color(32, 178, 170));
		mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mEspecifico.setForeground(Color.BLACK);
		menuComparar.add(mEspecifico);
		
		JMenu menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);
		
		JMenu menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		
		JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		rdbtnPersona = new JRadioButton("Persona");
		grupo.add(rdbtnPersona);
		JRadioButton rdbtnPersona = new JRadioButton("Persona");
		rdbtnPersona.setFocusPainted(false);
		rdbtnPersona.setIgnoreRepaint(true);
		rdbtnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPersona.setBounds(10, 44, 85, 23);
		contentPanel.add(rdbtnPersona);
		
		rdbtnRestoHumano = new JRadioButton("Resto Humano");
		grupo.add(rdbtnRestoHumano);
		rdbtnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRestoHumano.setBounds(107, 44, 109, 23);
		contentPanel.add(rdbtnRestoHumano);
		
		rdbtnCaso = new JRadioButton("Caso");
		grupo.add(rdbtnCaso);
		JRadioButton rdbtnCaso = new JRadioButton("Caso");
		rdbtnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCaso.setBounds(249, 44, 74, 23);
		contentPanel.add(rdbtnCaso);
		
		JLabel lblNewLabel = new JLabel("Introduce el Identificador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 120, 175, 14);
		contentPanel.add(lblNewLabel);
		
		btnVolver = new JButton("Volver");
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(350, 246, 89, 31);
		contentPanel.add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busqueda(vMain,datos);
			}
		});
		btnBuscar.setEnabled(true);
	}
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	
	private void busqueda(VPrincipal vMain, ContDatosBusq datos) {
		// TODO Auto-generated method stub
		Caso caso = new Caso();
		String codigo = caso.getCodCaso();
		
		Persona persona = new Persona();
		String dni = persona.getDni();
		
		RestoHumano resto = new RestoHumano();
		String codR = resto.getCodResto();
		
		if(rdbtnCaso.isSelected() && textVBusqueda.getText().equals(codigo)) {
			datos.buscarCaso(codigo);
			VBusCaso ventCaso = new VBusCaso(vMain, true, casos.get(codigo), datos);
			ventCaso.setVisible(true);
		}else if(rdbtnPersona.isSelected() && textVBusqueda.getText().equals(dni)){
			datos.comprobarDNI(dni);
			VBusPer ventPer = new VBusPer(vMain, true, personas.get(dni), datos);
			ventPer.setVisible(true);
		}else if(rdbtnRestoHumano.isSelected() && textVBusqueda.getText().equals(codR)) {
			datos.buscarRH(codR);
			VBusRH ventRH = new VBusRH(vMain, true, restos.get(codR), datos);
			ventRH.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(this, "El identificador introducido no esta registrado",  "Error!!", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
