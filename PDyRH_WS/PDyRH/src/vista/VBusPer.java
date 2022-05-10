package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlador.*;
import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosBusqPer;
import modelo.clases.Agente;
import modelo.clases.Conocido;
import modelo.clases.Criminal;
import modelo.clases.Desaparecida;
import modelo.clases.Persona;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class VBusPer extends JDialog implements ContDatosBusqPer{

	private final JPanel contentPanel = new JPanel();
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefonoM;
	private JTextField textTelefonoO;
	private JTextField textLocalidad;
	private JTextField textNacimiento;
	private JTextField textFallecimiento;
	private JTextField textRango;
	private JTextField textInicioServ;
	private JTextField textFinServ;
	private JTextField textFechaArresto;
	private JTextField textPrisionero;
	private JTextField textAltura;
	private JTextField textColorO;
	private JTextField textColorP;
	private JTextField textEspecificaciones;
	private JTextField textFechaDes;
	private JTextField textGenero;
	private JTextField textTipoP;
	private JTextField textUltimaUbi;
	private JTextField textDni1;
	private JTextField textRelacion1;
	private JTextField textDni2;
	private JTextField textRelacion2;
	private JTextField textDni3;
	private JTextField textRelacion3;
	private JLabel lblRango;
	private JLabel lblIni;
	private JLabel lblFechaA;
	private JLabel lblFin;
	private JLabel lblPrisionero;
	private JLabel lblAltura;
	private JLabel lblColorO;
	private JLabel lblColorP;
	private JLabel lblEsp;
	private JLabel lblGenero;
	private JLabel lblTipoP;
	private JLabel lblUltimaUbi;
	private JLabel lblFechaDes;
	
	private JLabel lblNomAp2;
	private JLabel lblNomAp1;
	private JLabel lblNomAp3;
	private Button buttonVolver1;
	private Button buttonVolver2;
	private JLabel imagen;
	
	private Conocido conocido;
	private Map<String,Conocido> conocidos;
	private Persona per;
	ContDatosBusqPer datos2 = DataFactoryBusqPer.getDatos();
	
		
	public VBusPer(VIniciarSesion vInicio, boolean modal, String dni, ContDatosBusq datos) {
		super(vInicio);
		this.setModal(modal);
		setBounds(100, 100, 631, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 0, 0);
		contentPanel.add(tabbedPane);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Datos", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(68, 44, 46, 14);
		panel_2.add(lblNewLabel);

		textDni = new JTextField();
		textDni.setVerifyInputWhenFocusTarget(false);
		textDni.setBounds(127, 42, 158, 20);
		panel_2.add(textDni);
		textDni.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(53, 69, 61, 14);
		panel_2.add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.setBounds(127, 64, 158, 20);
		panel_2.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(53, 96, 61, 14);
		panel_2.add(lblNewLabel_2);

		textApellido = new JTextField();
		textApellido.setBounds(127, 94, 158, 20);
		panel_2.add(textApellido);
		textApellido.setColumns(10);
		
		lblRango = new JLabel("Rango:");
		lblRango.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRango.setBounds(349, 44, 46, 14);
		lblRango.setVisible(false);
		panel_2.add(lblRango);

		textRango = new JTextField();
		textRango.setBounds(415, 42, 158, 20);
		textRango.setVisible(false);
		panel_2.add(textRango);
		textRango.setColumns(10);
		
		lblIni = new JLabel("Inicio Servicio:");
		lblIni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIni.setBounds(312, 69, 95, 14);
		lblIni.setVisible(false);
		panel_2.add(lblIni);

		textInicioServ = new JTextField();
		textInicioServ.setBounds(415, 67, 158, 20);
		textInicioServ.setVisible(false);
		panel_2.add(textInicioServ);
		textInicioServ.setColumns(10);
		
		lblFin = new JLabel("Fin servicio:");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFin.setBounds(322, 96, 75, 14);
		lblFin.setVisible(false);
		panel_2.add(lblFin);

		textFinServ = new JTextField();
		textFinServ.setBounds(415, 96, 158, 20);
		textFinServ.setVisible(false);
		panel_2.add(textFinServ);
		textFinServ.setColumns(10);
		
		lblFechaA = new JLabel("Fechas de arresto:");
		lblFechaA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaA.setBounds(296, 44, 125, 14);
		lblFechaA.setVisible(false);
		panel_2.add(lblFechaA);

		textFechaArresto = new JTextField();
		textFechaArresto.setBounds(415, 42, 158, 20);
		textFechaArresto.setVisible(false);
		panel_2.add(textFechaArresto);
		textFechaArresto.setColumns(10);
		
		lblPrisionero = new JLabel("Prision:");
		lblPrisionero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrisionero.setBounds(359, 69, 46, 14);
		lblPrisionero.setVisible(false);
		panel_2.add(lblPrisionero);

		textPrisionero = new JTextField();
		textPrisionero.setBounds(415, 67, 158, 20);
		textPrisionero.setVisible(false);
		panel_2.add(textPrisionero);
		textPrisionero.setColumns(10);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(352, 44, 53, 14);
		lblAltura.setVisible(false);
		panel_2.add(lblAltura);

		textAltura = new JTextField();
		textAltura.setBounds(415, 42, 158, 20);
		textAltura.setVisible(false);
		panel_2.add(textAltura);
		textAltura.setColumns(10);
		
		lblColorO = new JLabel("Color de ojos:");
		lblColorO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorO.setBounds(322, 96, 107, 14);
		lblColorO.setVisible(false);
		panel_2.add(lblColorO);

		textColorO = new JTextField();
		textColorO.setBounds(415, 96, 158, 20);
		textColorO.setVisible(false);
		panel_2.add(textColorO);
		textColorO.setColumns(10);
		
		lblColorP = new JLabel("Color de Pelo:");
		lblColorP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorP.setBounds(317, 121, 90, 14);
		lblColorP.setVisible(false);
		panel_2.add(lblColorP);

		textColorP = new JTextField();
		textColorP.setBounds(415, 119, 158, 20);
		textColorP.setVisible(false);
		panel_2.add(textColorP);
		textColorP.setColumns(10);
		
		lblEsp = new JLabel("Especificaciones:");
		lblEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEsp.setBounds(300, 146, 107, 14);
		lblEsp.setVisible(false);
		panel_2.add(lblEsp);

		textEspecificaciones = new JTextField();
		textEspecificaciones.setBounds(415, 144, 158, 20);
		textEspecificaciones.setVisible(false);
		panel_2.add(textEspecificaciones);
		textEspecificaciones.setColumns(10);
		
		lblFechaDes = new JLabel("Fecha desaparecido:");
		lblFechaDes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDes.setBounds(291, 171, 130, 14);
		lblFechaDes.setVisible(false);
		panel_2.add(lblFechaDes);

		textFechaDes = new JTextField();
		textFechaDes.setBounds(415, 169, 158, 20);
		textFechaDes.setVisible(false);
		panel_2.add(textFechaDes);
		textFechaDes.setColumns(10);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(349, 194, 61, 14);
		lblGenero.setVisible(false);
		panel_2.add(lblGenero);

		textGenero = new JTextField();
		textGenero.setBounds(415, 196, 158, 20);
		textGenero.setVisible(false);
		panel_2.add(textGenero);
		textGenero.setColumns(10);
		
		lblTipoP = new JLabel("Tipo de pelo:");
		lblTipoP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoP.setBounds(312, 219, 95, 14);
		lblTipoP.setVisible(false);
		panel_2.add(lblTipoP);

		textTipoP = new JTextField();
		textTipoP.setBounds(415, 228, 158, 20);
		textTipoP.setVisible(false);
		panel_2.add(textTipoP);
		textTipoP.setColumns(10);
		
		lblUltimaUbi = new JLabel("Ultima Ubicacion:");
		lblUltimaUbi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUltimaUbi.setBounds(293, 255, 114, 14);
		lblUltimaUbi.setVisible(false);
		panel_2.add(lblUltimaUbi);

		textUltimaUbi = new JTextField();
		textUltimaUbi.setBounds(415, 253, 158, 20);
		textUltimaUbi.setVisible(false);
		panel_2.add(textUltimaUbi);
		textUltimaUbi.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Telefono movil:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(19, 120, 95, 14);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Telefono opcional:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(7, 145, 107, 14);
		panel_2.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Localidad:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(53, 180, 61, 14);
		panel_2.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Nacimiento:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(41, 205, 75, 14);
		panel_2.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Fallecimiento:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(30, 230, 95, 14);
		panel_2.add(lblNewLabel_2_5);

		textTelefonoM = new JTextField();
		textTelefonoM.setBounds(127, 120, 158, 20);
		panel_2.add(textTelefonoM);
		textTelefonoM.setColumns(10);

		textTelefonoO = new JTextField();
		textTelefonoO.setColumns(10);
		textTelefonoO.setBounds(127, 143, 158, 20);
		panel_2.add(textTelefonoO);

		textLocalidad = new JTextField();
		textLocalidad.setBounds(127, 178, 158, 20);
		panel_2.add(textLocalidad);
		textLocalidad.setColumns(10);

		textNacimiento = new JTextField();
		textNacimiento.setColumns(10);
		textNacimiento.setBounds(127, 203, 158, 20);
		panel_2.add(textNacimiento);

		textFallecimiento = new JTextField();
		textFallecimiento.setColumns(10);
		textFallecimiento.setBounds(127, 230, 158, 20);
		panel_2.add(textFallecimiento);

		buttonVolver1 = new Button("Volver");
		buttonVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver1();
			}
		});
		buttonVolver1.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVolver1.setForeground(Color.WHITE);
		buttonVolver1.setBackground(new Color(153, 0, 0));
		buttonVolver1.setBounds(291, 373, 107, 31);
		panel_2.add(buttonVolver1);
		
		per = obtenerPersona(dni);
		if (per != null) {
			per = new Persona();
			textDni.setText(per.getDni());
			textNombre.setText(per.getNombre());
			textApellido.setText(per.getApellido());
			textTelefonoM.setText(per.getTelefonos().toString());
			textTelefonoO.setText(per.getTelefonos().toString());
			textLocalidad.setText(per.getLocalidad());

			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fechaNac = per.getFechaNac().format(formateador);
			String fechaFal = per.getFechaFal().format(formateador);

			textNacimiento.setText(fechaNac);
			textFallecimiento.setText(fechaFal);
			
			if(per instanceof Agente) {
				per = new Agente();
				textDni.setText(per.getDni());
				textNombre.setText(per.getNombre());
				textApellido.setText(per.getApellido());
				textNacimiento.setText(fechaNac);
				textFallecimiento.setText(fechaFal);
				//Mostrar los datos del agente
				mostrarDatosAgente();
				
				textRango.setText(((Agente) per).getRango());
				String inicio = ((Agente) per).getInicioServ().format(formateador);
				String fin = ((Agente) per).getFinServ().format(formateador);
				textInicioServ.setText(inicio);
				textFinServ.setText(fin);
			}else if(per instanceof Criminal) {
				per = new Criminal();
				textDni.setText(per.getDni());
				textNombre.setText(per.getNombre());
				textApellido.setText(per.getApellido());
				//Mostrar datos de Criminal
				ocultarDatosAgente();
				mostrarDatosCriminal();
				
				textFechaArresto.setText(((Criminal) per).getFechasArresto().toString());
				if(((Criminal) per).isPrisionero()) {
					textPrisionero.setText("Si");
				}else {
					textPrisionero.setText("No");
				}
			}else if(per instanceof Desaparecida) {
				per = new Desaparecida();
				textDni.setText(per.getDni());
				textNombre.setText(per.getNombre());
				textApellido.setText(per.getApellido());
				//Mostrar datos de la persona desaparecida
				ocultarDatosCriminal();
				mostrarDatosDesaparecido();
				
				textAltura.setText(Float.toString(((Desaparecida) per).getAltura()));
				textColorO.setText(((Desaparecida) per).getColorOjos());
				textColorP.setText(((Desaparecida) per).getColorPelo());
				textEspecificaciones.setText(((Desaparecida) per).getEspecificaciones());
				
				String fechaDes = ((Desaparecida) per).getFechaDes().format(formateador);
				textFechaDes.setText(fechaDes);
				
				textGenero.setText(((Desaparecida) per).getGenero());
				textTipoP.setText(((Desaparecida) per).getTipoPelo());
				textUltimaUbi.setText(((Desaparecida) per).getUltimaUbi());
			}else {
				ocultarDatosDesaparecido();
			}
		}
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.EAST);
		imagen.setBounds(148, 11, 524, 393);
		panel_2.add(imagen);

			
		JPanel panel = new JPanel();
		tabbedPane.addTab("Conocidos", null, panel, null);
		panel.setLayout(null);

		lblNomAp1 = new JLabel("Nombre y apellidos");
		lblNomAp1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomAp1.setBounds(22, 207, 135, 19);
		panel.add(lblNomAp1);

		JLabel lblNewLabel_4_1_1 = new JLabel("DNI:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(82, 237, 35, 14);
		panel.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Relacion:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(54, 262, 63, 14);
		panel.add(lblNewLabel_5_1_1);

		textDni1 = new JTextField();
		textDni1.setBounds(116, 53, 147, 20);
		panel.add(textDni1);
		textDni1.setColumns(10);

		JLabel lblNewLabl_5 = new JLabel("Relacion:");
		lblNewLabl_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabl_5.setBounds(54, 84, 63, 14);
		panel.add(lblNewLabl_5);

		textRelacion1 = new JTextField();
		textRelacion1.setBounds(116, 80, 147, 20);
		panel.add(textRelacion1);
		textRelacion1.setColumns(10);

		lblNomAp2 = new JLabel("Nombre y apellidos");
		lblNomAp2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomAp2.setBounds(22, 121, 135, 19);
		panel.add(lblNomAp2);

		JLabel lblNewLabel_4_1 = new JLabel("DNI:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(82, 151, 35, 14);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Relacion:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(54, 176, 63, 14);
		panel.add(lblNewLabel_5_1);

		textDni2 = new JTextField();
		textDni2.setColumns(10);
		textDni2.setBounds(116, 149, 147, 20);
		panel.add(textDni2);

		textRelacion2 = new JTextField();
		textRelacion2.setColumns(10);
		textRelacion2.setBounds(116, 174, 147, 20);
		panel.add(textRelacion2);

		lblNomAp3 = new JLabel("Nombre y apellidos");
		lblNomAp3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomAp3.setBounds(22, 207, 135, 19);
		panel.add(lblNomAp3);

		JLabel lblNewLabe = new JLabel("DNI:");
		lblNewLabe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabe.setBounds(82, 237, 35, 14);
		panel.add(lblNewLabe);

		JLabel lblNewLabel_ = new JLabel("Relacion:");
		lblNewLabel_.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_.setBounds(54, 262, 63, 14);
		panel.add(lblNewLabel_);

		textDni3 = new JTextField();
		textDni3.setColumns(10);
		textDni3.setBounds(116, 235, 147, 20);
		panel.add(textDni3);

		textRelacion3 = new JTextField();
		textRelacion3.setColumns(10);
		textRelacion3.setBounds(116, 260, 147, 20);
		panel.add(textRelacion3);

		buttonVolver2 = new Button("Volver");
		buttonVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver2();
			}
		});
		buttonVolver2.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVolver2.setForeground(Color.WHITE);
		buttonVolver2.setBackground(new Color(153, 0, 0));
		buttonVolver2.setBounds(293, 260, 107, 31);
		panel.add(buttonVolver2);

		nombresCompletos(per, datos, datos2, conocido);

		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.EAST);
		imagen.setBounds(0, 0, 432, 363);
		panel.add(imagen);
				
		    
		

	}

	private void ocultarDatosDesaparecido() {
		// TODO Auto-generated method stub
		lblAltura.setVisible(false);
		lblColorO.setVisible(false);
		lblColorP.setVisible(false);
		lblEsp.setVisible(false);
		lblFechaDes.setVisible(false);
		lblGenero.setVisible(false);
		lblTipoP.setVisible(false);
		lblUltimaUbi.setVisible(false);
		
		textAltura.setVisible(false);
		textColorO.setVisible(false);
		textColorP.setVisible(false);
		textEspecificaciones.setVisible(false);
		textFechaDes.setVisible(false);
		textGenero.setVisible(false);
		textTipoP.setVisible(false);
		textUltimaUbi.setVisible(false);
	}

	private void ocultarDatosCriminal() {
		// TODO Auto-generated method stub
		lblPrisionero.setVisible(false);
		lblFechaA.setVisible(false);
		
		textPrisionero.setVisible(false);
		textFechaArresto.setVisible(false);
	}

	private void ocultarDatosAgente() {
		// TODO Auto-generated method stub
		lblRango.setVisible(false);
		lblIni.setVisible(false);
		lblFin.setVisible(false);
		
		textRango.setVisible(false);
		textInicioServ.setVisible(false);
		textFinServ.setVisible(false);
	}

	private void mostrarDatosDesaparecido() {
		// TODO Auto-generated method stub
		lblAltura.setVisible(true);
		lblColorO.setVisible(true);
		lblColorP.setVisible(true);
		lblEsp.setVisible(true);
		lblFechaDes.setVisible(true);
		lblGenero.setVisible(true);
		lblTipoP.setVisible(true);
		lblUltimaUbi.setVisible(true);
		
		textAltura.setVisible(true);
		textColorO.setVisible(true);
		textColorP.setVisible(true);
		textEspecificaciones.setVisible(true);
		textFechaDes.setVisible(true);
		textGenero.setVisible(true);
		textTipoP.setVisible(true);
		textUltimaUbi.setVisible(true);
	}

	private void mostrarDatosCriminal() {
		// TODO Auto-generated method stub
		lblPrisionero.setVisible(true);
		lblFechaA.setVisible(true);
		
		textPrisionero.setVisible(true);
		textFechaArresto.setVisible(true);
	}

	private void mostrarDatosAgente() {
		// TODO Auto-generated method stub
		lblRango.setVisible(true);
		lblIni.setVisible(true);
		lblFin.setVisible(true);
		
		textRango.setVisible(true);
		textInicioServ.setVisible(true);
		textFinServ.setVisible(true);
	}

	private void nombresCompletos(Persona persona, ContDatosBusq datos, ContDatosBusqPer datos2, Conocido conocido) {
		// TODO Auto-generated method stub
		persona = new Persona();
		conocido = new Conocido();
		conocidos = new TreeMap<>();

		conocidos = datos2.listarConocidos(conocido.getDni1());
		
		for (Conocido cono : conocidos.values()) {
			if (cono.getDni1().equalsIgnoreCase(persona.getDni())) {
				lblNomAp1.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp1.getText().equalsIgnoreCase(persona.getNombre())) {
					textDni1.setText(cono.getDni1());
					textRelacion1.setText(cono.getRelacion());
				}
				lblNomAp2.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp2.getText().equalsIgnoreCase(persona.getNombre()) && cono.getDni2().equalsIgnoreCase(persona.getDni())) {
					textDni2.setText(cono.getDni2());
					textRelacion2.setText(cono.getRelacion());
				}
				lblNomAp3.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp3.getText().equalsIgnoreCase(persona.getNombre())) {
					textDni3.setText(cono.getDni2());
					textRelacion3.setText(cono.getRelacion());
				}
			}else {
				JOptionPane.showMessageDialog(this, "No se han encontrado conocidos");
			}
		}
		
	}

	private void volver1() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	private void volver2() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public Persona obtenerPersona(String dni) {
		// TODO Auto-generated method stub
		return datos2.obtenerPersona(dni);
	}

	@Override
	public Map<String, Conocido> listarConocidos(String dni1) {
		// TODO Auto-generated method stub
		return datos2.listarConocidos(dni1);
	}
}
