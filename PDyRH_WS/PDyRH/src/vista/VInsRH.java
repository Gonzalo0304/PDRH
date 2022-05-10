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

import controlador.DataFactoryRH;
import controlador.interfaces.ContDatosRH;
import modelo.clases.RestoHumano;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VInsRH extends JDialog implements ActionListener, ContDatosRH {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textCausa;
	private JTextField textFecha;
	private JTextField textUbicacion;
	private JTextField textTipoP;
	private JTextField textColorP;
	private JTextField textAltura;
	private JTextField textEspecificaciones;
	private Button btnAnadir;
	private JComboBox<Object> comboBox;
	private JTextField textColorO;
	private VIniciarSesion padre;
	private String[] info;
	private JMenuBar menuBar;
	private JMenu menUsuario;
	private JMenuItem mCerrar;
	private JMenu menInsertar;
	private JMenu menComparar;
	private JMenu menGestionar;
	private JMenu menBuscar;
	private JMenuItem mPersona;
	private JMenuItem mRestoHumano;
	private JMenuItem mCaso;
	private static Point point = new Point();
	private JLabel lblCerrar;
	private JSeparator separator2_5;
	
	ContDatosRH datos = DataFactoryRH.getDatos();
	private JLabel lblCausa;
	private JSeparator separator2;
	private JLabel lblCod;
	private JSeparator separator2_1;
	private JLabel lblInsRH;
	private JSeparator separatorInsRH;
	
	public VInsRH(VIniciarSesion padre, boolean modal, String[] infos) {
		// <--- Diseño de ventana --->
				super(padre);
				this.setModal(modal);
				setBounds(350, 150, 503, 627);
				getContentPane().setLayout(new BorderLayout());
				contentPanel.setBackground(Color.WHITE);
				contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
				getContentPane().add(contentPanel, BorderLayout.CENTER);
				setUndecorated(true);
				setLocationRelativeTo(null);
				contentPanel.setLayout(null);
				this.padre = padre;
				info = infos;
				
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
				lblCerrar.setBounds(470, 2, 31, 19);
				lblCerrar.setBackground(new Color(153, 0, 0));
				lblCerrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						lblCerrar.setForeground(new Color(0, 51, 102));
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
				contentPanel.add(lblCerrar);
				
				// Menú superior
				separator2_5 = new JSeparator();
				separator2_5.setBounds(0, 36, 502, 2);
				separator2_5.setForeground(SystemColor.controlShadow);
				separator2_5.setBackground(new Color(0, 51, 102));
				contentPanel.add(separator2_5);

				menuBar = new JMenuBar();
				menuBar.setBounds(0, 1, 502, 37);
				menuBar.setBorderPainted(false);
				menuBar.setBackground(new Color(0, 51, 102));
				contentPanel.add(menuBar);

				menUsuario = new JMenu(" " + info[0] + " ");
				menuBar.add(menUsuario);
				menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
				menUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				menUsuario.setBackground(new Color(0, 0, 255));
				menUsuario.setForeground(new Color(255, 255, 255));

				mCerrar = new JMenuItem("Cerrar Sesion");
				mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
				mCerrar.setBackground(new Color(32, 178, 170));
				mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				mCerrar.setForeground(Color.BLACK);
				mCerrar.addActionListener(this);
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
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCodigo.setBounds(47, 119, 180, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textCausa = new JTextField();
		textCausa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textCausa.setColumns(10);
		textCausa.setBounds(47, 189, 180, 20);
		contentPanel.add(textCausa);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(47, 259, 180, 20);
		contentPanel.add(textFecha);
		
		textUbicacion = new JTextField();
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(47, 333, 180, 20);
		contentPanel.add(textUbicacion);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Hombre", "Mujer"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(47, 403, 180, 22);
		contentPanel.add(comboBox);
		
		textTipoP = new JTextField();
		textTipoP.setColumns(10);
		textTipoP.setBounds(47, 475, 180, 20);
		contentPanel.add(textTipoP);
		
		textColorP = new JTextField();
		textColorP.setColumns(10);
		textColorP.setBounds(271, 119, 180, 20);
		contentPanel.add(textColorP);
		
		textColorO = new JTextField();
		textColorO.setColumns(10);
		textColorO.setBounds(271, 184, 180, 20);
		contentPanel.add(textColorO);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(271, 259, 180, 20);
		contentPanel.add(textAltura);
		
		textEspecificaciones = new JTextField();
		textEspecificaciones.setColumns(10);
		textEspecificaciones.setBounds(271, 333, 180, 20);
		contentPanel.add(textEspecificaciones);
		
		btnAnadir = new Button("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (obtenerRH(textCodigo.getText()) == null) {
					RestoHumano rh = new RestoHumano();
					altaRH(rh);
				} else {
					JOptionPane.showMessageDialog(padre,"Este resto humano ya ha sido introducido.","Código existente.",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAnadir.setBackground(new Color(122, 42, 42));
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setEnabled(false);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnadir.setBounds(204, 562, 87, 28);
		contentPanel.add(btnAnadir);
		
		JLabel lblFecha_1 = new JLabel("FECHA");
		lblFecha_1.setForeground(new Color(153, 0, 0));
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFecha_1.setBounds(47, 220, 81, 28);
		contentPanel.add(lblFecha_1);
		
		JSeparator separator2_4 = new JSeparator();
		separator2_4.setForeground(SystemColor.controlShadow);
		separator2_4.setBackground(new Color(153, 0, 0));
		separator2_4.setBounds(47, 246, 106, 2);
		contentPanel.add(separator2_4);
		
		JLabel lblUbi_1 = new JLabel("UBICACI\u00D3N");
		lblUbi_1.setForeground(new Color(153, 0, 0));
		lblUbi_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUbi_1.setBounds(47, 294, 81, 28);
		contentPanel.add(lblUbi_1);
		
		JSeparator separator2_1_3 = new JSeparator();
		separator2_1_3.setForeground(SystemColor.controlShadow);
		separator2_1_3.setBackground(new Color(153, 0, 0));
		separator2_1_3.setBounds(47, 320, 106, 2);
		contentPanel.add(separator2_1_3);
		
		JLabel lblGen_1 = new JLabel("SEXO");
		lblGen_1.setForeground(new Color(153, 0, 0));
		lblGen_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblGen_1.setBounds(47, 364, 81, 28);
		contentPanel.add(lblGen_1);
		
		JSeparator separator2_2_2 = new JSeparator();
		separator2_2_2.setForeground(SystemColor.controlShadow);
		separator2_2_2.setBackground(new Color(153, 0, 0));
		separator2_2_2.setBounds(47, 390, 106, 2);
		contentPanel.add(separator2_2_2);
		
		JLabel lblTP_1 = new JLabel("TIPO DE PELO");
		lblTP_1.setForeground(new Color(153, 0, 0));
		lblTP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTP_1.setBounds(47, 436, 81, 28);
		contentPanel.add(lblTP_1);
		
		JSeparator separator2_1_1_1 = new JSeparator();
		separator2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_1_1_1.setBackground(new Color(153, 0, 0));
		separator2_1_1_1.setBounds(47, 462, 106, 2);
		contentPanel.add(separator2_1_1_1);
		
		JLabel lblCP_1 = new JLabel("COLOR DE PELO");
		lblCP_1.setForeground(new Color(153, 0, 0));
		lblCP_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCP_1.setBounds(271, 83, 106, 28);
		contentPanel.add(lblCP_1);
		
		JSeparator separator2_3_1 = new JSeparator();
		separator2_3_1.setForeground(SystemColor.controlShadow);
		separator2_3_1.setBackground(new Color(153, 0, 0));
		separator2_3_1.setBounds(271, 109, 106, 2);
		contentPanel.add(separator2_3_1);
		
		JLabel lblAlt_1 = new JLabel("ALTURA");
		lblAlt_1.setForeground(new Color(153, 0, 0));
		lblAlt_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlt_1.setBounds(271, 220, 81, 28);
		contentPanel.add(lblAlt_1);
		
		JSeparator separator2_1_2_1 = new JSeparator();
		separator2_1_2_1.setForeground(SystemColor.controlShadow);
		separator2_1_2_1.setBackground(new Color(153, 0, 0));
		separator2_1_2_1.setBounds(271, 246, 106, 2);
		contentPanel.add(separator2_1_2_1);
		
		JLabel lblEsp_1 = new JLabel("ESPECIFICACIONES");
		lblEsp_1.setForeground(new Color(153, 0, 0));
		lblEsp_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEsp_1.setBounds(271, 294, 106, 28);
		contentPanel.add(lblEsp_1);
		
		JSeparator separator2_2_1_1 = new JSeparator();
		separator2_2_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1.setBackground(new Color(153, 0, 0));
		separator2_2_1_1.setBounds(271, 320, 106, 2);
		contentPanel.add(separator2_2_1_1);
		
		JLabel lblCO2 = new JLabel("COLOR DE OJOS");
		lblCO2.setForeground(new Color(153, 0, 0));
		lblCO2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCO2.setBounds(271, 148, 106, 28);
		contentPanel.add(lblCO2);
		
		JSeparator separator2_2_1_1_1 = new JSeparator();
		separator2_2_1_1_1.setForeground(SystemColor.controlShadow);
		separator2_2_1_1_1.setBackground(new Color(153, 0, 0));
		separator2_2_1_1_1.setBounds(271, 174, 106, 2);
		contentPanel.add(separator2_2_1_1_1);
		
		lblCausa = new JLabel("CAUSA");
		lblCausa.setForeground(new Color(153, 0, 0));
		lblCausa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCausa.setBounds(47, 150, 81, 28);
		contentPanel.add(lblCausa);
		
		separator2 = new JSeparator();
		separator2.setForeground(SystemColor.controlShadow);
		separator2.setBackground(new Color(153, 0, 0));
		separator2.setBounds(47, 176, 106, 2);
		contentPanel.add(separator2);
		
		lblCod = new JLabel("C\u00D3DIGO");
		lblCod.setForeground(new Color(153, 0, 0));
		lblCod.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCod.setBounds(47, 83, 81, 28);
		contentPanel.add(lblCod);
		
		separator2_1 = new JSeparator();
		separator2_1.setForeground(SystemColor.controlShadow);
		separator2_1.setBackground(new Color(153, 0, 0));
		separator2_1.setBounds(47, 109, 106, 2);
		contentPanel.add(separator2_1);
		
		lblInsRH = new JLabel("Inserci\u00F3n de Resto Humano");
		lblInsRH.setForeground(SystemColor.textInactiveText);
		lblInsRH.setFont(new Font("Nirmala UI", Font.BOLD, 14));
		lblInsRH.setBounds(25, 48, 209, 24);
		contentPanel.add(lblInsRH);
		
		separatorInsRH = new JSeparator();
		separatorInsRH.setForeground(new Color(102, 0, 0));
		separatorInsRH.setBackground(new Color(153, 0, 0));
		separatorInsRH.setBounds(25, 70, 457, 2);
		contentPanel.add(separatorInsRH);
		
		JLabel imgErtzAC = new JLabel("");
		imgErtzAC.setIcon(new ImageIcon(VInsRH.class.getResource("/imagenes/ertzAC.png")));
		imgErtzAC.setBounds(91, 178, 309, 317);
		contentPanel.add(imgErtzAC);
	}
	
	
	private void cerrar() {
		VInserciones insertar = new VInserciones(padre, true, info);
		this.dispose();
		insertar.setVisible(true);
		
	}
	
	private LocalDate stringDate(String string) {
		LocalDate nacimiento = LocalDate.parse(string);
		return nacimiento;
	}
	
	private int stringInt(String string) {
		int altura = Integer.parseInt(string);
		return altura;
	}
	
	private void habilitarBoton() {
		if (!textCodigo.getText().isEmpty() && !textCausa.getText().isEmpty()) {
			btnAnadir.setEnabled(true);
			btnAnadir.setBackground(new Color(153, 0, 0));
		} else {
			btnAnadir.setEnabled(false);
			btnAnadir.setBackground(new Color(122, 42, 42));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mCerrar)) {
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
	
	// Abrir ventanas de menú
	private void abrirGes() {
		VGestion vBus = new VGestion(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirCom() {
		VComparacion vCom = new VComparacion(padre,true,info);
		this.dispose();
		vCom.setVisible(true);
	}

	private void abrirBus() {
		VBusqueda vBus = new VBusqueda(padre,true,info);
		this.dispose();
		vBus.setVisible(true);
	}

	private void abrirInsertRH() {
		VInsRH vInsRH = new VInsRH(padre,true,info);
		this.dispose();
		vInsRH.setVisible(true);
	}

	private void abrirInsertPer() {
		VInsPersona vInsPer = new VInsPersona(padre,true,info);
		this.dispose();
		vInsPer.setVisible(true);		
	}

	private void abrirInsertCaso() {
		VInsCaso vInsCaso = new VInsCaso(padre,true,info);
		this.dispose();
		vInsCaso.setVisible(true);
	}	
	
	private void limpiar() {
		textCodigo.setText("");
		textCausa.setText("");
		textFecha.setText("");
		textUbicacion.setText("");
		comboBox.setSelectedIndex(0);
		textTipoP.setText("");
		textColorP.setText("");
		textColorO.setText("");
		textAltura.setText("");
		textEspecificaciones.setText("");
	}


	@Override
	public void altaRH(RestoHumano rh) {
		LocalDate fechaMuer = null;
		int altura = 0;
		if(!textFecha.getText().isBlank()) {
			fechaMuer = stringDate(textFecha.getText());
		}
		
		if(!textAltura.getText().isBlank()) {
			altura = stringInt(textAltura.getText());
		}
		
		rh.setCodResto(textCodigo.getText());
		rh.setCausa(textCausa.getText());
		rh.setFechaMuerte(fechaMuer);
		rh.setUbicacion(textUbicacion.getText());
		if (comboBox.getSelectedItem() == "Hombre") {
			rh.setGenero("H");
		}else if (comboBox.getSelectedItem() == "Mujer") {
			rh.setGenero("M");
		}
		rh.setTipoPelo(textTipoP.getText());
		rh.setColorPelo(textColorP.getText());
		rh.setColorOjos(textColorO.getText());
		rh.setAltura(altura);
		rh.setEspecificaciones(textEspecificaciones.getText());
		JOptionPane.showMessageDialog(this, "Inserción realizada con éxito.","Inserción exitosa.",JOptionPane.CLOSED_OPTION);
		datos.altaRH(rh);
		limpiar();
		habilitarBoton();
	}


	@Override
	public void modificarRH(RestoHumano rh) {
	}


	@Override
	public void eliminarRH(String codResto) {
	}


	@Override
	public RestoHumano obtenerRH(String codResto) {
		return datos.obtenerRH(codResto);
	}
}
