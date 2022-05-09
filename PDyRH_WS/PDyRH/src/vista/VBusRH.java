package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
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
import controlador.DataFactoryBusqRH;
import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosBusqRH;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBusRH extends JDialog implements ContDatosBusqRH{

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
	private JLabel imagen;
	private JLabel lblCerrar;
	
	private Persona persona;
	private RestoHumano resto;
	private ContDatosBusq datos;
	private VIniciarSesion vInicio;
	private String[] info;
	ContDatosBusqRH datos2 = DataFactoryBusqRH.getDatos();
	
	public VBusRH(VIniciarSesion vInicio, boolean modal, String codResto, ContDatosBusq datos) {
		super(vInicio);
		this.setModal(modal);
		setTitle("Buscar Resto Humano");
		setBounds(350, 150, 499, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
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
				volver();
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(644, 0, 31, 19);
		contentPanel.add(lblCerrar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 499, 37);
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
		textCodCaso.setBounds(114, 345, 188, 20);
		contentPanel.add(textCodCaso);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setColumns(10);
		textIdentificacion.setBounds(117, 345, 188, 20);
		textIdentificacion.setBounds(117, 317, 188, 20);
		contentPanel.add(textIdentificacion);
		
		JLabel lblColorOjos = new JLabel("Color de ojos");
		lblColorOjos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorOjos.setBounds(30, 247, 77, 14);
		contentPanel.add(lblColorOjos);
		
		textColorO = new JTextField();
		textColorO.setBounds(117, 240, 188, 20);
		contentPanel.add(textColorO);
		textColorO.setColumns(10);
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setBounds(0, 37, 499, 423);
		contentPanel.add(imagen);
		
		resto = obtenerRH(codResto);
		
		if(resto!=null) {
			textCodigo.setText(resto.getCodResto());
			textCausa.setText(resto.getCausa());
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fecha = resto.getFechaMuerte().format(formateador);
			textFecha.setText(fecha);
			textUbicacion.setText(resto.getUbicacion());
			textGenero.setText(resto.getGenero());
			textTipoP.setText(resto.getTipoPelo());
			textColorP.setText(resto.getColorPelo());
			textColorO.setText(resto.getColorOjos());
			textAltura.setText(Float.toString(resto.getAltura()));
			textEspecificacion.setText(resto.getEspecificaciones());
			textCodCaso.setText(resto.getCodCaso());

			String idnt = obtenerIdentificado(codResto);
			textIdentificacion.setText(idnt);
		}
		
		
	}
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
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

	@Override
	public String obtenerIdentificado(String codResto) {
		// TODO Auto-generated method stub
		return datos2.obtenerIdentificado(codResto);
	}

	@Override
	public RestoHumano obtenerRH(String codResto) {
		// TODO Auto-generated method stub
		return datos2.obtenerRH(codResto);
	}
}
