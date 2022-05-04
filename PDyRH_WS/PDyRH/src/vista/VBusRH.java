package vista;

import java.awt.BorderLayout;
import java.awt.Button;
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

import controlador.ContDatosRH;
import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosBusqRH;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBusRH extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textCausa;
	private JTextField textFecha;
	private JTextField textUbicacion;
	private JTextField textGenero;
	private JTextField textTipoP;
	private JTextField textColorP;
	private JTextField textAltura;
	private JTextField textEspecificacion;
	private JTextField textCodCaso;
	private JTextField textIdentificacion;
	private JTextField textColorO;
	private Button buttonVolver;
	
	private Persona persona;
	private ContDatosBusqRH datos2;
	
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
<<<<<<< HEAD
	 * @param datos 
	 * @param restoHumano 
	 * @param b 
	 * @param vMain 
	 * @param datos 
	 * @param restoHumano 
	 * @param b 
	 * @param vBusqueda 
=======
>>>>>>> 067cf60c298ca393e3723ac8c37008564151eb24
	 */
	
	
	public VBusRH(VPrincipal vMain, boolean modal, RestoHumano restoHumano, ContDatosBusq datos) {
		super(vMain);
		this.setModal(modal);
		setTitle("Buscar Resto Humano");
		setBounds(100, 100, 461, 451);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 491, 37);
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
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 65, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Causa");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(61, 90, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Fecha");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(61, 115, 46, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblCodigo_2 = new JLabel("Ubicacion");
		lblCodigo_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_2.setBounds(46, 140, 61, 14);
		contentPanel.add(lblCodigo_2);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(61, 165, 46, 14);
		contentPanel.add(lblGenero);
		
		JLabel lblCodigo_3 = new JLabel("Tipo de pelo");
		lblCodigo_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_3.setBounds(30, 190, 87, 14);
		contentPanel.add(lblCodigo_3);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(71, 272, 46, 14);
		contentPanel.add(lblAltura);
		
		JLabel lblColorDePelo = new JLabel("Color de pelo");
		lblColorDePelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorDePelo.setBounds(30, 215, 87, 14);
		contentPanel.add(lblColorDePelo);
		
		JLabel lblEspecificacion = new JLabel("Especificacion");
		lblEspecificacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspecificacion.setBounds(30, 297, 87, 14);
		contentPanel.add(lblEspecificacion);
		
		JLabel lblCodigoDeCaso = new JLabel("Codigo de caso");
		lblCodigoDeCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoDeCaso.setBounds(20, 322, 87, 14);
		contentPanel.add(lblCodigoDeCaso);
		
		JLabel lblIdentificado = new JLabel("Identificado");
		lblIdentificado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdentificado.setBounds(30, 347, 74, 14);
		contentPanel.add(lblIdentificado);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(117, 63, 188, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCausa = new JTextField();
		textCausa.setColumns(10);
		textCausa.setBounds(117, 88, 188, 20);
		contentPanel.add(textCausa);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(117, 113, 188, 20);
		contentPanel.add(textFecha);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(117, 138, 188, 20);
		contentPanel.add(textUbicacion);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(117, 163, 188, 20);
		contentPanel.add(textGenero);
		
		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(117, 188, 188, 20);
		contentPanel.add(textTipoP);
		
		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(117, 213, 188, 20);
		contentPanel.add(textColorP);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(117, 270, 188, 20);
		contentPanel.add(textAltura);
		
		textEspecificacion = new JTextField();
		textEspecificacion.setColumns(10);
		textEspecificacion.setBounds(117, 295, 188, 20);
		contentPanel.add(textEspecificacion);
		
		textCodCaso = new JTextField();
		textCodCaso.setColumns(10);
		textCodCaso.setBounds(117, 320, 188, 20);
		contentPanel.add(textCodCaso);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setColumns(10);
		textIdentificacion.setBounds(117, 345, 188, 20);
		textIdentificacion.setBounds(117, 317, 188, 20);
		contentPanel.add(textIdentificacion);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolver.setBounds(346, 370, 89, 31);
		contentPanel.add(btnVolver);
		
		JLabel lblColorOjos = new JLabel("Color de ojos");
		lblColorOjos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorOjos.setBounds(30, 247, 77, 14);
		contentPanel.add(lblColorOjos);
		
		textColorO = new JTextField();
		textColorO.setBounds(117, 240, 188, 20);
		contentPanel.add(textColorO);
		textColorO.setColumns(10);
		
		if(restoHumano!=null) {
			textCodigo.setText(restoHumano.getCodResto());
			textCausa.setText(restoHumano.getCausa());
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String fecha = restoHumano.getFechaMuerte().format(formateador);
			textFecha.setText(fecha);
			textUbicacion.setText(restoHumano.getUbicacion());
			textGenero.setText(restoHumano.getGenero());
			textTipoP.setText(restoHumano.getTipoPelo());
			textColorP.setText(restoHumano.getColorPelo());
			textColorO.setText(restoHumano.getColorOjos());
			textAltura.setText(Float.toString(restoHumano.getAltura()));
			textEspecificacion.setText(restoHumano.getEspecificaciones());
			textCodCaso.setText(restoHumano.getCodCaso());
			identificado(persona, restoHumano, datos2);
		}
		
		
	}
	
	private void identificado(Persona persona, RestoHumano restoHumano, ContDatosBusqRH datos2) {
		// TODO Auto-generated method stub
		persona = new Persona();
		String idnt = datos2.obtenerIdentificado(persona.getDni());
		
		textIdentificacion.setText(persona.getDni());
		
	}

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
