package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class VGestion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVGestion;
	private JButton ButtonVolverVGestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VGestion dialog = new VGestion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public VGestion(VPrincipal vMain, boolean modal) {
		super(vMain);
		this.setModal(modal);
		
		setTitle("Introducir identificador");
		setBounds(100, 100, 467, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		textVGestion = new JTextField();
		textVGestion.setBounds(195, 122, 226, 20);
		contentPanel.add(textVGestion);
		textVGestion.setColumns(10);
		
		JLabel LabelVGestion = new JLabel("Introduce el identificador:");
		LabelVGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelVGestion.setBounds(39, 125, 160, 14);
		contentPanel.add(LabelVGestion);
		
		JButton ButtonBuscarVGestion = new JButton("Buscar");
		ButtonBuscarVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonBuscarVGestion.setEnabled(false);
		ButtonBuscarVGestion.setBounds(170, 170, 98, 28);
		contentPanel.add(ButtonBuscarVGestion);
		
		JRadioButton RadioButtonPersonaVGestion = new JRadioButton("Persona");
		RadioButtonPersonaVGestion.setRolloverEnabled(false);
		RadioButtonPersonaVGestion.setBounds(39, 65, 87, 23);
		contentPanel.add(RadioButtonPersonaVGestion);
		
		JRadioButton RadioButtonRHVGestion = new JRadioButton("Resto Humano");
		RadioButtonRHVGestion.setBounds(128, 65, 109, 23);
		contentPanel.add(RadioButtonRHVGestion);
		
		JRadioButton RadioButtonBandaVGestion = new JRadioButton("Banda");
		RadioButtonBandaVGestion.setBounds(247, 65, 68, 23);
		contentPanel.add(RadioButtonBandaVGestion);
		
		JRadioButton RadioButtonCasoVGestion = new JRadioButton("Caso");
		RadioButtonCasoVGestion.setBounds(331, 65, 109, 23);
		contentPanel.add(RadioButtonCasoVGestion);
		
		ButtonVolverVGestion = new JButton("Volver");
		ButtonVolverVGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		ButtonVolverVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonVolverVGestion.setBounds(352, 227, 89, 23);
		contentPanel.add(ButtonVolverVGestion);
	}
	
	public VGestion() {
		setTitle("Introducir identificador");
		setBounds(100, 100, 467, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setRequestFocusEnabled(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		textVGestion = new JTextField();
		textVGestion.setBounds(195, 122, 226, 20);
		contentPanel.add(textVGestion);
		textVGestion.setColumns(10);
		
		JLabel LabelVGestion = new JLabel("Introduce el identificador:");
		LabelVGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelVGestion.setBounds(39, 125, 160, 14);
		contentPanel.add(LabelVGestion);
		
		JButton ButtonBuscarVGestion = new JButton("Buscar");
		ButtonBuscarVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonBuscarVGestion.setEnabled(false);
		ButtonBuscarVGestion.setBounds(170, 170, 98, 28);
		contentPanel.add(ButtonBuscarVGestion);
		
		JRadioButton RadioButtonPersonaVGestion = new JRadioButton("Persona");
		RadioButtonPersonaVGestion.setHideActionText(true);
		RadioButtonPersonaVGestion.setIgnoreRepaint(true);
		RadioButtonPersonaVGestion.setBounds(39, 65, 87, 23);
		contentPanel.add(RadioButtonPersonaVGestion);
		
		JRadioButton RadioButtonRHVGestion = new JRadioButton("Resto Humano");
		RadioButtonRHVGestion.setBounds(128, 65, 109, 23);
		contentPanel.add(RadioButtonRHVGestion);
		
		JRadioButton RadioButtonBandaVGestion = new JRadioButton("Banda");
		RadioButtonBandaVGestion.setBounds(247, 65, 68, 23);
		contentPanel.add(RadioButtonBandaVGestion);
		
		JRadioButton RadioButtonCasoVGestion = new JRadioButton("Caso");
		RadioButtonCasoVGestion.setBounds(331, 65, 109, 23);
		contentPanel.add(RadioButtonCasoVGestion);
		
		JButton ButtonVolverVGestion = new JButton("Volver");
		ButtonVolverVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonVolverVGestion.setBounds(352, 227, 89, 23);
		contentPanel.add(ButtonVolverVGestion);
	}
	

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
