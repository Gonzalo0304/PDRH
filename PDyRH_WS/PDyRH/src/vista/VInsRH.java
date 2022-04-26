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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInsRH extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textCausa;
	private JTextField textFecha;
	private JTextField textUbicacion;
	private JTextField textTipoP;
	private JTextField textColorP;
	private JTextField textAltura;
	private JTextField textEspecificaciones;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * @param modal 
	 * @param inserciones 
	 */
	public VInsRH(VInserciones inserciones, boolean modal) {
		super(inserciones);
		this.setModal(modal);
		
		setTitle("Insertar Resto Humano");
		setBounds(100, 100, 479, 465);
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
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 73, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCausa = new JLabel("Causa");
		lblCausa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCausa.setBounds(61, 106, 46, 14);
		contentPanel.add(lblCausa);
		
		JLabel lblCodigo = new JLabel("Fecha");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(61, 141, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUbicacion.setBounds(46, 166, 61, 14);
		contentPanel.add(lblUbicacion);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(61, 203, 46, 14);
		contentPanel.add(lblGenero);
		
		JLabel lblTipoDePelo = new JLabel("Tipo de pelo");
		lblTipoDePelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDePelo.setBounds(36, 236, 71, 14);
		contentPanel.add(lblTipoDePelo);
		
		JLabel lblNewLabel_6 = new JLabel("Color de pelo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(36, 271, 85, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Altura");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(65, 296, 52, 14);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Especificaciones");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_2.setBounds(22, 327, 95, 14);
		contentPanel.add(lblNewLabel_6_2);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(125, 71, 180, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCausa = new JTextField();
		textCausa.setColumns(10);
		textCausa.setBounds(125, 104, 180, 20);
		contentPanel.add(textCausa);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(125, 135, 180, 20);
		contentPanel.add(textFecha);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(125, 164, 180, 20);
		contentPanel.add(textUbicacion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Hombre", "Mujer"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(125, 195, 180, 22);
		contentPanel.add(comboBox);
		
		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(125, 234, 180, 20);
		contentPanel.add(textTipoP);
		
		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(125, 265, 180, 20);
		contentPanel.add(textColorP);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(125, 294, 180, 20);
		contentPanel.add(textAltura);
		
		textEspecificaciones = new JTextField();
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(125, 325, 180, 20);
		contentPanel.add(textEspecificaciones);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(348, 287, 89, 32);
		contentPanel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(348, 327, 89, 32);
		contentPanel.add(btnVolver);
	}
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
