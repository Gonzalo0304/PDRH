package vista;

import java.awt.BorderLayout;

<<<<<<<HEAD
import javax.swing.ButtonGroup;
import javax.swing.JButton;=======>>>>>>>d17b25ce5004bb03f4cb31e6dae29236e4b53bd4
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;<<<<<<<HEAD
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;=======>>>>>>>d17b25ce5004bb03f4cb31e6dae29236e4b53bd4
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
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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



public class VComparacion extends JDialog {
	private ButtonGroup rh = new ButtonGroup();
	private VIniciarSesion vInicio = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JButton ButtonVolvervComp;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param modal
	 * @param vMain
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
		private JMenu menuInsertar;
		private JMenu menuGestionar;
		private JMenu menuComparar;
		private JMenu menuBusqueda;
		private JMenu menUsuario;
		private JMenuItem mCerrar;
		private Map<String, RestoHumano> restos = new TreeMap<>();
		private Map<String, Persona> desaparecidas = new TreeMap<>();
		private List<Comparacion> comparados = new ArrayList<>();
		Comparacion comp;
		float porcentaje;
		private JPanel panel;
		private JPanel panel1;
		private JLabel lblND;
		private JSeparator separator;
		private JLabel lblImgErtzAC;
		private JLabel lblComparacinPdyrh;
		private JSeparator separator1;
		private String[] info;
		private VIniciarSesion padre;

		// <--- Datos BD --->
		ContDatosComp datos = DataFactoryComp.getDatos();

		// <--- Ejecución --->
	public VComparacion(VIniciarSesion padre, boolean modal, String[] infos) {
		super(padre);

		this.setModal(modal);
		setTitle("Comparar");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setPreferredSize(new Dimension (360, 330));
		scrollPane.setViewportView(contentPanel);

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true); // Sin borde predeterminado
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
		
		separator1 = new JSeparator();
		separator1.setForeground(new Color(102, 0, 0));
		separator1.setBackground(new Color(153, 0, 0));
		separator1.setBounds(24, 82, 559, 2);
		contentPane.add(separator1);
		
		lblComparacinPdyrh = new JLabel("Comparaci\u00F3n PDyRH");
		lblComparacinPdyrh.setForeground(SystemColor.textInactiveText);
		lblComparacinPdyrh.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblComparacinPdyrh.setBounds(24, 60, 151, 19);
		contentPane.add(lblComparacinPdyrh);
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(573, 2, 31, 19);
		contentPane.add(lblCerrar);
		
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(2, 47, 603, 2);
		contentPane.add(separator);
		
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

		
		ButtonVolvervComp = new JButton("Volver");
		ButtonVolvervComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonVolvervComp.setBounds(262, 232, 105, 23);
		ButtonVolvervComp.setBounds(300, 225, 105, 23);
		contentPanel.add(ButtonVolvervComp);
		
		JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
		ButtonCompSelVComp.setEnabled(false);
		ButtonCompSelVComp.setBounds(262, 198, 105, 23);
		contentPanel.add(ButtonCompSelVComp);
		
		JRadioButton RadioButton1VComparacion = new JRadioButton("");
		RadioButton1VComparacion.setBounds(177, 96, 27, 21);
		contentPanel.add(RadioButton1VComparacion);
		
		JRadioButton RadioButton2VComparacion = new JRadioButton("");
		RadioButton2VComparacion.setBounds(177, 120, 27, 23);
		contentPanel.add(RadioButton2VComparacion);
		
		JRadioButton RadioButton3VComparacion = new JRadioButton("");
		RadioButton3VComparacion.setBounds(177, 211, 27, 23);
		contentPanel.add(RadioButton3VComparacion);
		
		JRadioButton RadioButton4VComparacion = new JRadioButton("");
		RadioButton4VComparacion.setBounds(177, 237, 27, 23);
		contentPanel.add(RadioButton4VComparacion);
			
		String desaparecidas[] = { "Maria", "Fernando", "Marcos" };
		String restoHumanos[] = { "67", "50", "30" };
		// Creacion de tablas de comparacion
		int posiciontabla = 48;
		int posicioncabecera = 35;
		
		if (desaparecidas.length > 0 && restoHumanos.length > 0) {
			for (int i = 0; i < restoHumanos.length; i++) {
				String datosTabla[][] = new String[desaparecidas.length][2];
				for (int j = 0; j < desaparecidas.length; j++) {
					datosTabla[j][0] = desaparecidas[j];
					datosTabla[j][1] = restoHumanos[j];

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuInsertar.setForeground(Color.WHITE);
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuGestionar.setForeground(Color.WHITE);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuComparar.setForeground(Color.WHITE);
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBusqueda.setForeground(Color.WHITE);
		menuBar.add(menuBusqueda);

		// Creacion de tablas de comparacion
		restos = obtenerRHs();
		desaparecidas = datos.obtenerDesaparecidas();

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

				JScrollPane JS = new JScrollPane();
				JS.setBounds(10, posiciontabla, 200, 55);
				posiciontabla = posiciontabla + 100;
				contentPanel.add(JS);

				String cabezera[] = { "Desaparecida", "Precido%" };
				JTable tabla = new JTable(datosTabla, cabezera);

			if (comparados.size() > 0) {
				String datosTabla[][] = new String[comparados.size()][3];
				for (int i = 0; i < comparados.size(); i++) {
					datosTabla[i][0] = comparados.get(i).getDni();
					datosTabla[i][1] = comparados.get(i).getCodResto();
					datosTabla[i][2] = String.format("%.2f",comparados.get(i).getPorcentaje());
				}
				int posicion = 20 + (comparados.size() * 19);
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
						vComp.setVisible(true);
					}
				});
			} else {
				panel1 = new JPanel();
				panel1.setBackground(new Color(153, 0, 0));
				panel1.setBounds(93, 99, 402, 210);
				contentPane.add(panel1);
				panel1.setLayout(null);
				

				JLabel lblNewLabel_1 = new JLabel("Resto Humano");
				lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, posicioncabecera, 199, 14);
				posicioncabecera = posicioncabecera + 100;
				contentPanel.add(lblNewLabel_1);
				

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

	}

		public VComparacion(VIniciarSesion vInicio, boolean modal) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			scrollPane.setBounds(0, 0, 434, 261);
			getContentPane().add(scrollPane);

			JPanel contentPanel = new JPanel();
			contentPanel.setLayout(null);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.setPreferredSize(new Dimension(360, 330));
			scrollPane.setViewportView(contentPanel);

			JButton ButtonVolvervComp = new JButton("Volver");
			ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
			ButtonVolvervComp.setBounds(300, 225, 105, 23);
			contentPanel.add(ButtonVolvervComp);

			JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
			ButtonCompSelVComp.setEnabled(false);
			ButtonCompSelVComp.setBounds(300, 198, 105, 23);
			contentPanel.add(ButtonCompSelVComp);

			String desaparecidas[] = { "Maria", "Fernando", "Marcos" };
			String restoHumanos[] = { "67", "50", "30" };
			// Creacion de tablas de comparacion
			int posiciontabla = 48;
			int posicioncabecera = 35;

			if (desaparecidas.length > 0 && restoHumanos.length > 0) {
				for (int i = 0; i < restoHumanos.length; i++) {
					String datosTabla[][] = new String[desaparecidas.length][2];
					for (int j = 0; j < desaparecidas.length; j++) {
						datosTabla[j][0] = desaparecidas[j];
						datosTabla[j][1] = restoHumanos[j];

					}

					JScrollPane JS = new JScrollPane();
					JS.setBounds(10, posiciontabla, 200, 55);
					posiciontabla = posiciontabla + 100;
					contentPanel.add(JS);

					String cabezera[] = { "Desaparecida", "Precido%" };
					JTable tabla = new JTable(datosTabla, cabezera);
					JS.setViewportView(tabla);

					JLabel lblNewLabel_1 = new JLabel("Resto Humano");
					lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setBounds(10, posicioncabecera, 199, 14);
					posicioncabecera = posicioncabecera + 100;
					contentPanel.add(lblNewLabel_1);

				}
			} else {

			}
		}

	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();

		
		lblImgErtzAC = new JLabel("");
		lblImgErtzAC.setIcon(new ImageIcon("C:\\Users\\haize\\OneDrive\\Documentos\\GitHub\\PDRH\\Multimedia\\ertzAC.png"));
		lblImgErtzAC.setBounds(151, 83, 318, 290);
		contentPane.add(lblImgErtzAC);
	}

		// <--- Métodos --->
		private void cerrar() {
			VPrincipal vMain = new VPrincipal(padre, true, info);
			this.dispose();
			vMain.setVisible(true);
		}

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
			diasDiff = Period.between(fechaDes, fechaM).getDays();
			xFecha = (diasDiff - 14) / -7;
			if (diasDiff < 0 || xFecha < 0) {
				xFecha = 0;
			}
			// Calcular diferencia de alturas y su valor
			cmDiff = Math.abs(rh.getAltura() - ((Desaparecida) des).getAltura());
			xAltura = (cmDiff - 5) / -2.5f;
			if (xAltura < 0) {
				xAltura = 0;
			}
			for (int i = 0; i < rhCar1.length; i++) {
				if (rhCar1[i].equalsIgnoreCase(desCar1[i])) {
					xTotal++;
				}
			}
			for (int i = 0; i < rhCar2.length; i++) {
				if (rhCar2[i].equalsIgnoreCase(desCar2[i])) {
					xTotal += 2;
				}
			}
			// Calcular el porcentaje + especificaciones
			float res;
			if (rh.getEspecificaciones() != null
					&& rh.getEspecificaciones().equalsIgnoreCase(((Desaparecida) des).getEspecificaciones())) {
				res = (xFecha + xAltura + xTotal + 2) * 100 / 14;

			} else {
				res = (xFecha + xAltura + xTotal) * 100 / 12;
			}
			return res;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(mCerrar)) {
				this.dispose();
				padre.setVisible(true);
			}
		}

		@Override
		public Map<String, RestoHumano> obtenerRHs() {
			return datos.obtenerRHs();
		}

		@Override
		public Map<String, Persona> obtenerDesaparecidas() {
			return datos.obtenerDesaparecidas();
		}

	@Override
	public String obtenerIdentificado(String codResto) {
		return null;
	}
}
