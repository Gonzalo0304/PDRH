package vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.clases.Desaparecida;
import modelo.clases.Persona;
import modelo.clases.RestoHumano;

import javax.swing.JTable;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.Period;

public class VComparacion extends JDialog {
	private static final long serialVersionUID = 1L;
	
	// <--- Elementos --->
	private final JPanel contentPane = new JPanel();
	private JTable tabla;
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JScrollPane JS;
	private RestoHumano rh;
	private Persona des;
	private JMenuBar menuBar;
	private JMenu menuInsertar;
	private JMenu menuGestionar;
	private JMenu menuComparar;
	private JMenu menuBusqueda;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private String[] desaparecidas;
	private String[] restosHumanos;
	private String[] porcentajes;
	
	// <--- Ejecución --->
	public static void main(String[] args) {
		try {
			VComparacion dialog = new VComparacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VComparacion() {

	}
	
	public VComparacion(VIniciarSesion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		setTitle("Comparar");
		setBounds(100, 100, 409, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setUndecorated(true); // Sin borde predeterminado
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

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
				lblCerrar.setForeground(Color.LIGHT_GRAY);
				lblCerrar.setOpaque(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.LIGHT_GRAY);
		lblCerrar.setBounds(377, 2, 31, 19);
		contentPane.add(lblCerrar);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 463, 37);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.add(menuBar);

		menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
		menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuInsertar.setBackground(new Color(0, 0, 255));
		menuInsertar.setForeground(Color.BLACK);
		menuBar.add(menuInsertar);

		menuGestionar = new JMenu("Gestionar");
		menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
		menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuGestionar.setBackground(new Color(0, 0, 255));
		menuGestionar.setForeground(Color.BLACK);
		menuBar.add(menuGestionar);

		menuComparar = new JMenu("Comparar");
		menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
		menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuComparar.setBackground(new Color(0, 0, 255));
		menuComparar.setForeground(Color.BLACK);
		menuBar.add(menuComparar);

		menuBusqueda = new JMenu("Busqueda");
		menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
		menuBusqueda.setBackground(new Color(0, 0, 255));
		menuBusqueda.setForeground(Color.BLACK);
		menuBar.add(menuBusqueda);

		menUsuario = new JMenu("Usuario");
		menuBar.add(menUsuario);
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
		
		desaparecidas[0] = "293w";
		desaparecidas[1] = "843t";
		restosHumanos[0] = "r1";
		restosHumanos[1] = "r2";
		porcentajes[0] = "30";
		porcentajes[1] = "70";
		// Creacion de tablas de comparacion
		int posicion = 48;
		if (desaparecidas.length > 0 && restosHumanos.length > 0) {
			String datosTabla[][] = new String[desaparecidas.length][3];
			for (int j = 0; j < desaparecidas.length; j++) {
				datosTabla[j][0] = desaparecidas[j];
				datosTabla[j][1] = restosHumanos[j];
				datosTabla[j][2] = porcentajes[j];
			}

			JS = new JScrollPane();
			JS.setBounds(10, posicion, 300, 55);
			posicion = posicion + 100;
			contentPane.add(JS);

			String cabecera[] = { "Desaparecida", "Resto Humano", "Parecido%" };
			tabla = new JTable(datosTabla, cabecera);
			JS.setViewportView(tabla);

			tabla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String dni = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);
					String codigo = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);

					// des = datos.buscarPersona(dni)
					// rh = datos.buscarRH(codigo)

					rh = new RestoHumano();
					des = new Desaparecida();

					VComRH vComp = new VComRH(padre, true, rh, des);
					vComp.setVisible(true);
				}
			});
		}

	}

	// <--- Métodos --->
	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
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
		des = new Desaparecida();
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
		if (diasDiff < 0) {
			xFecha = 0;
		}
		// Calcular diferencia de alturas y su valor
		cmDiff = Math.abs(rh.getAltura() - ((Desaparecida) des).getAltura());
		xAltura = (cmDiff - 5) / -2.5f;
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
		if (rh.getEspecificaciones().equalsIgnoreCase(((Desaparecida) des).getEspecificaciones())) {
			res = (xFecha + xAltura + xTotal + 2) * 100 / 14;

		} else {
			res = (xFecha + xAltura + xTotal) * 100 / 12;
		}
		return res;
	}
}
