package vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controlador.DataFactoryComp;
import controlador.interfaces.ContDatosComp;
import modelo.clases.Comparacion;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

import javax.swing.JTable;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
/**
 * Esta clase representa la comparacion de los restos humanos y desaparecidos junto con el controlador de comparacion
 * @author Elias
 *
 */
public class VComparacion extends JDialog implements ActionListener, ContDatosComp {
	private static final long serialVersionUID = 1L;

	// <--- Elementos --->
	private final JPanel contentPane = new JPanel();
	private JTable tabla;
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JScrollPane JS;
	private JMenuBar menuBar;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private Map<String, RestoHumano> restos = new TreeMap<>();
	private Map<String, Persona> desaparecidas = new TreeMap<>();
	private List<Comparacion> comparados = new ArrayList<>();
	Comparacion comp;
	float porcentaje;
	private JPanel panel;
	private JPanel panel1;
	private JLabel lblND;
	private JSeparator separatorMenu;
	private JLabel lblImgErtzAC;
	private JLabel lblComparacinPdyrh;
	private JSeparator separatorComp;
	private String[] info;
	private VIniciarSesion padre;
	
	// <--- Datos BD --->
	ContDatosComp datos = DataFactoryComp.getDatos();

	/**
	 * Constructor de la ventana 
	 *
	 * @param padre: Es la ventana de inicio de sesion siendo la principal
	 * @param modal: Sirve para impedir la navegacion de la ventana anterior
	 * @param infos: Este parametro recibe los datos del usuario que ha iniciado sesion
	 */
	public VComparacion(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("PDyRH: Comparar");
		setBounds(100, 100, 607, 399);
		contentPane.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true); 
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		info = infos;
		this.padre = padre;

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
		lblCerrar.setBackground(new Color(153, 0, 0));
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setForeground(Color.BLACK);
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
		lblCerrar.setBounds(573, 2, 31, 19);
		contentPane.add(lblCerrar);
		
		// Menú superior y título
		separatorComp = new JSeparator();
		separatorComp.setForeground(new Color(102, 0, 0));
		separatorComp.setBackground(new Color(153, 0, 0));
		separatorComp.setBounds(24, 82, 559, 2);
		contentPane.add(separatorComp);
		
		lblComparacinPdyrh = new JLabel("Comparaci\u00F3n PDyRH");
		lblComparacinPdyrh.setForeground(SystemColor.textInactiveText);
		lblComparacinPdyrh.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblComparacinPdyrh.setBounds(24, 60, 151, 19);
		contentPane.add(lblComparacinPdyrh);
		
		separatorMenu = new JSeparator();
		separatorMenu.setBackground(Color.DARK_GRAY);
		separatorMenu.setBounds(2, 47, 603, 2);
		contentPane.add(separatorMenu);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPane.add(menuBar);

		menUsuario = new JMenu(" " + info[0] + " ");
		menUsuario.setHorizontalTextPosition(SwingConstants.LEFT);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		menUsuario.setForeground(Color.WHITE);
		menuBar.add(menUsuario);

		mCerrar = new JMenuItem("Cerrar Sesión");
		mCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		mCerrar.addActionListener(this);
		mCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

		menInsertar = new JMenu("Insertar");
		menInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menInsertar.setBackground(new Color(0, 0, 255));
		menInsertar.setForeground(Color.WHITE);
		menuBar.add(menInsertar);

		mPersona = new JMenuItem("Persona");
		mPersona.addActionListener(this);
		menInsertar.add(mPersona);

		mRestoHumano = new JMenuItem("Resto Humano");
		mRestoHumano.addActionListener(this);
		menInsertar.add(mRestoHumano);

		mCaso = new JMenuItem("Caso");
		mCaso.addActionListener(this);
		menInsertar.add(mCaso);

		menGestionar = new JMenu("Gestionar");
		menGestionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirGes();
			}
		});
		menGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menGestionar.setBackground(new Color(0, 0, 255));
		menGestionar.setForeground(Color.WHITE);
		menuBar.add(menGestionar);

		menComparar = new JMenu("Comparar");
		menComparar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirCom();
			}
		});
		menComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menComparar.setBackground(new Color(0, 0, 255));
		menComparar.setForeground(Color.WHITE);
		menuBar.add(menComparar);

		menBuscar = new JMenu("Busqueda");
		menBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				abrirBus();
			}
		});
		menBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		menBuscar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menBuscar.setBackground(new Color(0, 0, 255));
		menBuscar.setForeground(Color.WHITE);
		menuBar.add(menBuscar);

		// Creacion de tablas de comparacion
		restos = listarRHs();
		desaparecidas = listarDesaparecidas();

		if (!restos.isEmpty() && !desaparecidas.isEmpty()) {
			for (RestoHumano r : restos.values()) {
				for (Persona d : desaparecidas.values()) {
					porcentaje = calcularPor(r, d);
					if (porcentaje > 54.99) {
						comp = new Comparacion();
						comp.setCodResto(r.getCodResto());
						comp.setDni(d.getDni());
						comp.setPorcentaje(porcentaje);
						comparados.add(comp);
					}
				}
			}

			if (comparados.size() > 0) {
				String datosTabla[][] = new String[comparados.size()][3];
				for (int i = 0; i < comparados.size(); i++) {
					datosTabla[i][0] = comparados.get(i).getDni();
					datosTabla[i][1] = comparados.get(i).getCodResto();
					datosTabla[i][2] = String.format("%.2f",comparados.get(i).getPorcentaje());
				}

				int posicion = 16 + (comparados.size() * 17);
				JS = new JScrollPane();
				JS.setBounds(55, 100, 450, posicion);
				posicion = posicion + 100;
				contentPane.add(JS);

				String cabecera[] = { "Desaparecida", "Resto Humano", "Parecido (%)" };
				tabla = new JTable(datosTabla, cabecera);
				tabla.getTableHeader().setOpaque(false);
				tabla.getTableHeader().setBackground(new Color(0, 51, 102));
				tabla.getTableHeader().setForeground(Color.WHITE);
				JS.setViewportView(tabla);

				tabla.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String dni = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);
						String codigo = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);

						VComRH vComp = new VComRH(padre, true, dni, codigo, info);
						cer();
						vComp.setVisible(true);
					}
				});
			} else {
				// No hay restos y desaparecidos que coincidan lo suficiente
				panel1 = new JPanel();
				panel1.setBackground(new Color(153, 0, 0));
				panel1.setBounds(93, 99, 402, 210);
				contentPane.add(panel1);
				panel1.setLayout(null);
				
				lblND = new JLabel("NO HAY COINCIDENCIAS");
				lblND.setForeground(Color.WHITE);
				lblND.setBackground(Color.WHITE);
				lblND.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblND.setBounds(90, 90, 294, 37);
				panel1.add(lblND);
				
				panel = new JPanel();
				panel.setBackground(new Color(102, 0, 0));
				panel.setBounds(104, 111, 402, 210);
				contentPane.add(panel);
			}
		} else {
			// No hay datos en la BD
			panel1 = new JPanel();
			panel1.setBackground(new Color(153, 0, 0));
			panel1.setBounds(93, 99, 402, 210);
			contentPane.add(panel1);
			panel1.setLayout(null);
			
			lblND = new JLabel("NO HAY DATOS");
			lblND.setForeground(Color.WHITE);
			lblND.setBackground(Color.WHITE);
			lblND.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblND.setBounds(131, 97, 147, 22);
			panel1.add(lblND);
			
			panel = new JPanel();
			panel.setBackground(new Color(102, 0, 0));
			panel.setBounds(104, 111, 402, 210);
			contentPane.add(panel);
		}
		
		// Fondo
		lblImgErtzAC = new JLabel("");
		lblImgErtzAC.setIcon(new ImageIcon(VComparacion.class.getResource("/imagenes/ertzAC.png")));
		lblImgErtzAC.setBounds(144, 82, 318, 290);
		contentPane.add(lblImgErtzAC);
	}

	// <--- Métodos --->
	/**
	 * 
	 */
	private void cerrar() {
		VPrincipal vMain = new VPrincipal(padre,true,info);
		this.dispose();
		vMain.setVisible(true);
	}
	
	// Calcular porcentaje entre resto humano y persona desaparecida
	/**
	 * Metodo para calcular el porcentaje entre resto humano y persona desaparecida
	 * 
	 * @param rh: Esta variable contiene los datos de la clase de RestoHumano
	 * @param des: Esta variable contiene los datos de la persona desaparecida
	 * 
	 * <li>float xAltura: Sirve para poder diferenciar la altura de las dos clases
	 * <li>float xFecha: Sirve para diferenciar las fechas
	 * <li>int diasDiff: Se utiliza para obtener los dias
	 * <li>int cmDiff: Se utiliza para calcular la altura de las dos clases
	 * <li>float xTotal: Contiene el valor total de la altura
	 * <li>LocalDate fechaM: Contiene la fecha muerte del resto humano
	 * <li>LocalDate fechaDes: Contiene la fecha de desaparicion
	 * <li>String[] rhCar1: contiene la ubicacion y el tipo de pelo del resto humano
	 * <li>String[] rhCar2: contiene el genero, el color de pelo y color de ojos
	 * <li>String[] desCar1: contiene los atributos al igual que rhCar1
	 * <li>String[] desCar2: contiene los atributos al igual que rhCar2
	 * <li> float res: Calcula el porcentaje
	 * 
	 * Su funcion es encontrar las coincidencias que hay entre una persona desaparecida y un resto humano
	 * y si la informacion coincide se calcula el porcentaje que hay entre los dos.
	 * 
	 * @return Devuelve el porcentaje 
	 */
	private float calcularPor(RestoHumano rh, Persona des) {
		// <--- Variables --->
		float xAltura;
		float xFecha;
		int diasDiff;
		int cmDiff;
		float xTotal = 0;
		LocalDate fechaM;
		LocalDate fechaDes;
		String[] rhCar1 = { rh.getUbicacion(), rh.getTipoPelo() };
		String[] rhCar2 = { rh.getGenero(), rh.getColorPelo(), rh.getColorOjos() };
		String[] desCar1 = { ((Desaparecida) des).getUltimaUbi(), ((Desaparecida) des).getTipoPelo() };
		String[] desCar2 = { ((Desaparecida) des).getGenero(), ((Desaparecida) des).getColorPelo(),
				((Desaparecida) des).getColorOjos() };

		// <--- Procesos --->
		// Calcular diferencia de fechas y su valor
		fechaM = rh.getFechaMuerte();
		fechaDes = ((Desaparecida) des).getFechaDes();
		if (fechaDes != null &&  fechaM != null) {
			diasDiff = Period.between(fechaDes, fechaM).getDays();
			xFecha = (diasDiff - 14) / -7;
			if (diasDiff < 0 || xFecha < 0) {
				xFecha = 0;
			}
		} else {
			xFecha = 0;
		}
		// Calcular diferencia de alturas y su valor
		if (rh.getAltura() != 0 && ((Desaparecida) des).getAltura() != 0) {
			cmDiff = Math.abs(rh.getAltura() - ((Desaparecida) des).getAltura());
			xAltura = (cmDiff - 5) / -2.5f;
			if (xAltura < 0) {
				xAltura = 0;
			}
		} else {
			xAltura = 0;
		}
		for (int i = 0; i < rhCar1.length; i++) {
			if (!rhCar1[i].isBlank()) {
				if (rhCar1[i].equalsIgnoreCase(desCar1[i])) {
					xTotal++;
				}
			}
		}
		for (int i = 0; i < rhCar2.length; i++) {
			if (rhCar2[i] != null && !rhCar2[i].isBlank()) {
				if (rhCar2[i].equalsIgnoreCase(desCar2[i])) {
					xTotal += 2;
				}
			}
		}
		// Calcular el porcentaje + especificaciones
		float res;
		if (rh.getEspecificaciones() != null && rh.getEspecificaciones().equalsIgnoreCase(((Desaparecida) des).getEspecificaciones())) {
			res = (xFecha + xAltura + xTotal + 2) * 100 / 14;

		} else {
			res = (xFecha + xAltura + xTotal) * 100 / 12;
		}
		return res;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
			if (JOptionPane.showConfirmDialog(this,
					"¿Seguro que desea cerrar sesión?",
					"Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				this.dispose();
				padre.setVisible(true);
			}
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
		}
	}
	
	// Abrir ventanas de menú
	/**
	 * Metodo para abrir la ventana de Gestion. Se realiza al pulsar en la barra de
	 * menú el botón 'Gestionar'.
	 */
	private void abrirGes() {
		VGestion vBus = new VGestion(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Metodo para abrir la ventana de Comparacion. Se realiza al pulsar en la barra
	 * de menú el botón 'Comparar'.
	 */
	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	/**
	 * Método para abrir la ventana de Busqueda. Se realiza al pulsar en la barra de
	 * menú el botón 'Busqueda'.
	 */
	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	/**
	 * Metodo para abrir la ventana de insercion de restos humanos.
	 *
	 * Funciona al pulsar en la barra de menu el boton 'Insertar' en la que
	 * Despliegara tres opciones para pulsar y este método se realiza en 'Resto
	 * Humano'
	 */
	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info, false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	/**
	 * Método para abrir la ventana de inserción de personas.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar' y este método
	 * se realiza en 'Persona'.
	 */
	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	/**
	 * Metodo para abrir la ventana de insercion de casos.
	 *
	 * Al igual que el metodo anterior funciona al pulsar 'Insertar' y este método
	 * se realiza en 'Caso'.
	 */
	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}
	
	@Override
	public Map<String, RestoHumano> listarRHs() {
		return datos.listarRHs();
	}

	@Override
	public Map<String, Persona> listarDesaparecidas() {
		return datos.listarDesaparecidas();
	}

	@Override
	public String obtenerIdentificado(String codResto) {
		return null;
	}
	/**
	 * Metodo para cerrar la ventana al pulsar alguna columna de la tabla
	 */
	public void cer() {
		this.dispose();
	}
}