package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;

import controlador.DataFactoryInsertCaso;
import controlador.interfaces.ContDatosInsertCaso;
import modelo.clases.Caso;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VInsCaso extends JDialog implements ContDatosInsertCaso, ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Point point = new Point();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textFechaIni;
	private JTextField textFechaFin;
	private Button btnAnadir;
	private ButtonGroup estado = new ButtonGroup();
	private JRadioButton rdbtnAbierto;
	private JRadioButton rdbtnCerrado;
	private JRadioButton rdbtnSinResolver;
	private VIniciarSesion padre;
	private String[] info;
	private Caso caso;
	private JLabel lblCerrar;
	private JMenuBar menuBar;
	private JMenu menInsertar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenu menUsuario;
	private JMenu menComparar;
	private JMenuItem mCerrar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private JSeparator separator;

	ContDatosInsertCaso datos = DataFactoryInsertCaso.getDatos();
	private JLabel imgErtzAO;
	
	public VInsCaso(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
		super(padre);
		this.setModal(modal);
		setTitle("Bustionar");
		setBounds(100, 100, 607, 399);
		contentPanel.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		info = infos;
		this.padre = padre;
		
		// Movimiento de la ventana
		contentPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		contentPanel.addMouseMotionListener(new MouseMotionAdapter() {
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
		contentPanel.add(lblCerrar);

		// Menú superior
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(2, 47, 603, 2);
		contentPanel.add(separator);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 51, 102));
		menuBar.setBounds(2, 2, 603, 45);
		contentPanel.add(menuBar);

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
		
		btnAnadir = new Button("A\u00D1ADIR");
		btnAnadir.addActionListener(this);
		btnAnadir.setEnabled(false);
		btnAnadir.setForeground(new Color(255, 255, 255));
		btnAnadir.setBounds(247, 328, 87, 28);
		btnAnadir.setBackground(new Color(153, 0, 0));
		contentPanel.add(btnAnadir);
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(88, 153, 157, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		rdbtnAbierto = new JRadioButton("Abierto");
		rdbtnAbierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnAbierto.setBackground(new Color(255, 255, 255));
		rdbtnAbierto.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnAbierto.setBounds(158, 273, 87, 23);
		estado.add(rdbtnAbierto);
		contentPanel.add(rdbtnAbierto);
		rdbtnAbierto.setOpaque(false);
		
		rdbtnCerrado = new JRadioButton("Cerrado");
		rdbtnCerrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnCerrado.setBackground(new Color(255, 255, 255));
		rdbtnCerrado.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnCerrado.setBounds(233, 273, 87, 23);
		estado.add(rdbtnCerrado);
		contentPanel.add(rdbtnCerrado);
		rdbtnCerrado.setOpaque(false);
		
		rdbtnSinResolver = new JRadioButton("Sin resolver");
		rdbtnSinResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarBoton();
			}
		});
		rdbtnSinResolver.setBackground(new Color(255, 255, 255));
		rdbtnSinResolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnSinResolver.setBounds(320, 273, 115, 23);
		estado.add(rdbtnSinResolver);
		contentPanel.add(rdbtnSinResolver);
		rdbtnSinResolver.setOpaque(false);
		
		textNombre = new JTextField();
		textNombre.setBounds(88, 207, 157, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(321, 153, 157, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(321, 207, 157, 20);
		contentPanel.add(textFechaFin);
		
		JLabel lblDni = new JLabel("C\u00D3DIGO");
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDni.setBounds(88, 114, 81, 28);
		contentPanel.add(lblDni);
		
		JSeparator separatorCod = new JSeparator();
		separatorCod.setForeground(SystemColor.controlShadow);
		separatorCod.setBackground(new Color(0, 51, 102));
		separatorCod.setBounds(88, 140, 106, 2);
		contentPanel.add(separatorCod);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(88, 172, 81, 28);
		contentPanel.add(lblNombre);
		
		JSeparator separatorNom = new JSeparator();
		separatorNom.setForeground(SystemColor.controlShadow);
		separatorNom.setBackground(new Color(0, 51, 102));
		separatorNom.setBounds(88, 198, 106, 2);
		contentPanel.add(separatorNom);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(new Color(0, 51, 102));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setBounds(240, 238, 81, 28);
		contentPanel.add(lblEstado);
		
		JSeparator separatorEstado = new JSeparator();
		separatorEstado.setForeground(SystemColor.controlShadow);
		separatorEstado.setBackground(new Color(0, 51, 102));
		separatorEstado.setBounds(240, 264, 106, 2);
		contentPanel.add(separatorEstado);
		
		JSeparator separatorFechaIni = new JSeparator();
		separatorFechaIni.setForeground(new Color(0, 0, 102));
		separatorFechaIni.setBackground(new Color(0, 51, 102));
		separatorFechaIni.setBounds(321, 140, 106, 2);
		contentPanel.add(separatorFechaIni);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setForeground(new Color(0, 51, 102));
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaFin.setBounds(321, 172, 106, 28);
		contentPanel.add(lblFechaFin);
		
		JSeparator separatorFechaFin = new JSeparator();
		separatorFechaFin.setForeground(new Color(0, 0, 102));
		separatorFechaFin.setBackground(new Color(0, 51, 102));
		separatorFechaFin.setBounds(321, 198, 106, 2);
		contentPanel.add(separatorFechaFin);
		
		JLabel lblFechaIni = new JLabel("FECHA INICIO");
		lblFechaIni.setForeground(new Color(0, 51, 102));
		lblFechaIni.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaIni.setBounds(321, 114, 106, 28);
		contentPanel.add(lblFechaIni);
		
		JSeparator separatorGesCas = new JSeparator();
		separatorGesCas.setForeground(new Color(102, 0, 0));
		separatorGesCas.setBackground(new Color(153, 0, 0));
		separatorGesCas.setBounds(12, 82, 580, 2);
		contentPanel.add(separatorGesCas);
		
		JLabel lblGesPer = new JLabel("Inserci\u00F3n de Caso");
		lblGesPer.setForeground(SystemColor.textInactiveText);
		lblGesPer.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblGesPer.setBounds(12, 60, 142, 19);
		contentPanel.add(lblGesPer);
		
		imgErtzAO = new JLabel("");
		imgErtzAO.setIcon(new ImageIcon(VInsCaso.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAO.setBounds(140, 85, 309, 303);
		contentPanel.add(imgErtzAO);
		
	}
	
	private void cerrar() {
		VInserciones insercion = new VInserciones(padre,true,info);
		this.dispose();
		insercion.setVisible(true);
	}
	
	private void habilitarBoton() {
		if (!textCodigo.getText().isEmpty() && (rdbtnAbierto.isSelected() || rdbtnCerrado.isSelected() || rdbtnSinResolver.isSelected())) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}
	}
	
	private void limpiar() {
		textCodigo.setText("");
		rdbtnAbierto.setSelected(false);
		rdbtnCerrado.setSelected(false);
		rdbtnSinResolver.setSelected(false);
		textNombre.setText("");
		textFechaIni.setText("");
		textFechaFin.setText("");
		
	}
	private LocalDate stringDate(String string) {
		LocalDate nacimiento = LocalDate.parse(string);
		return nacimiento;
	}
	

	// Abrir ventanas de menú
	private void abrirGes() {
		VGestion vBus = new VGestion(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre, true, info);
		this.dispose();
		vCom.setVisible(true);
	}

	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre, true, info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre, true, null, info,false);
		this.dispose();
		vInsRH.setVisible(true);
	}

	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre, true, info);
		this.dispose();
		vInsPer.setVisible(true);
	}

	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre, true, info);
		this.dispose();
		vInsCaso.setVisible(true);
	}

	@Override
	public void altaCaso(Caso caso) {
		caso = new Caso();
		LocalDate fechaIni = null;
		LocalDate fechaFin = null;
		if(!textFechaIni.getText().isEmpty()) {
			fechaIni = stringDate(textFechaIni.getText());		
		}else if(!textFechaFin.getText().isEmpty()) {
			fechaFin = stringDate(textFechaFin.getText());
		}
		
		caso.setCodCaso(textCodigo.getText());
		if(rdbtnAbierto.isSelected()) {
			caso.setEstado(rdbtnAbierto.getText());
		}else if(rdbtnCerrado.isSelected()) {
			caso.setEstado(rdbtnCerrado.getText());
		}else if(rdbtnSinResolver.isSelected()) {
			caso.setEstado(rdbtnSinResolver.getText());
		}
		caso.setNombre(textNombre.getText());
		caso.setFechaIni(fechaIni);
		caso.setFechaFin(fechaFin);
		datos.altaCaso(caso);
		JOptionPane.showMessageDialog(this, "Inserción realizada con éxito.","Inserción exitosa",JOptionPane.CLOSED_OPTION);
		limpiar();
	}

	@Override
	public boolean comprobarCodCaso(String codCaso) {
		return datos.comprobarCodCaso(codCaso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAnadir)) {
			if (comprobarCodCaso(textCodigo.getText())) {
				JOptionPane.showMessageDialog(this, "El código introducido ya ha sido registrado.","Código existente",JOptionPane.ERROR_MESSAGE);
			} else {
				altaCaso(caso);
			}
		} else if (e.getSource().equals(mCerrar)) {
			this.dispose();
			padre.setVisible(true);
		} else if (e.getSource().equals(mCaso)) {
			abrirInsertCaso();
		} else if (e.getSource().equals(mPersona)) {
			abrirInsertPer();
		} else if (e.getSource().equals(mRestoHumano)) {
			abrirInsertRH();
		} 
		
	}
}
