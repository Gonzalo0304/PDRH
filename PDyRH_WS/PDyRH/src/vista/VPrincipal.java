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

import controlador.interfaces.ContDatosBusq;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JMenuItem mCerrar;
	private JButton btnInsertar;
	private JButton btnBusqueda;
	private VIniciarSesion vInicio;
	private ContDatosBusq datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VPrincipal dialog = new VPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param modal
	 * @param vIniciarSesion
	 */
	
	public VPrincipal() {
		setTitle("Principal");
		setBounds(100, 100, 416, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vInsertar();
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsertar.setBounds(38, 75, 123, 55);
		contentPanel.add(btnInsertar);

		btnBusqueda = new JButton("BUSQUEDA");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBusqueda(datos);
			}
		});
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqueda.setBounds(212, 75, 123, 55);
		contentPanel.add(btnBusqueda);

		JButton btnGestionar = new JButton("GESTIONAR");
		btnGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vGestionar();
			}
		});
		btnGestionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGestionar.setBounds(38, 161, 123, 55);
		contentPanel.add(btnGestionar);

		JButton btnComparar = new JButton("COMPARAR");
		btnComparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vComparar();
			}
		});
		btnComparar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnComparar.setBounds(212, 161, 123, 55);
		contentPanel.add(btnComparar);

		JButton btnBusqRapida = new JButton("Busqueda rapida");
		btnBusqRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBusquedaRapida(datos);
			}
		});
		btnBusqRapida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqRapida.setBounds(231, 239, 147, 23);
		contentPanel.add(btnBusqRapida);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		menuBar.setBounds(0, 0, 400, 37);
		contentPanel.add(menuBar);

		JMenu menUsuario = new JMenu("Usuario");
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		menuBar.add(menUsuario);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);

	}


	public VPrincipal(VIniciarSesion vInicio, boolean modal, ContDatosBusq datos) {
		super(vInicio);
		this.setModal(true);

		setTitle("Principal");
		setBounds(100, 100, 416, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vInsertar();
			}
		});
		btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsertar.setBounds(38, 75, 123, 55);
		contentPanel.add(btnInsertar);

		btnBusqueda = new JButton("BUSQUEDA");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBusqueda(datos);
			}
		});
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqueda.setBounds(212, 75, 123, 55);
		contentPanel.add(btnBusqueda);

		JButton btnGestionar = new JButton("GESTIONAR");
		btnGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vGestionar();
			}
		});
		btnGestionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGestionar.setBounds(38, 161, 123, 55);
		contentPanel.add(btnGestionar);

		JButton btnComparar = new JButton("COMPARAR");
		btnComparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vComparar();
			}
		});
		btnComparar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnComparar.setBounds(212, 161, 123, 55);
		contentPanel.add(btnComparar);

		JButton btnBusqRapida = new JButton("Busqueda rapida");
		btnBusqRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBusquedaRapida(datos);
			}
		});
		btnBusqRapida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqRapida.setBounds(231, 239, 147, 23);
		contentPanel.add(btnBusqRapida);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		menuBar.setBounds(0, 0, 400, 37);
		contentPanel.add(menuBar);

		JMenu menUsuario = new JMenu("Usuario");
		menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		menUsuario.setBackground(new Color(0, 0, 255));
		menUsuario.setForeground(Color.BLACK);
		menuBar.add(menUsuario);

		mCerrar = new JMenuItem("Cerrar Sesion");
		mCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
		mCerrar.setBackground(new Color(32, 178, 170));
		mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mCerrar.setForeground(Color.BLACK);
		menUsuario.add(mCerrar);
	}

	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	private void vInsertar() {
		// TODO Auto-generated method stub
		VInserciones inserciones = new VInserciones(vInicio, true);
		inserciones.setVisible(true);
	}


	private void vBusqueda() {
		// TODO Auto-generated method stub
		VBusqueda busqueda = new VBusqueda(vInicio, true);
	}

	
	private void vBusqueda(ContDatosBusq datos) {
		// TODO Auto-generated method stub
		VBusqueda busqueda = new VBusqueda(this, true, datos);

		busqueda.setVisible(true);
	}

	private void vGestionar() {
		// TODO Auto-generated method stub
		VGestion gestionar = new VGestion(vInicio, true);
		gestionar.setVisible(true);
	}

	private void vComparar() {
		// TODO Auto-generated method stub
		VComparacion comparar = new VComparacion(vInicio, true);
		comparar.setVisible(true);
	}

	
	private void vBusquedaRapida(ContDatosBusq datos) {
		// TODO Auto-generated method stub
		VBusRapida busRapida = new VBusRapida(this, true, datos);
		busRapida.setVisible(true);
	}

}
