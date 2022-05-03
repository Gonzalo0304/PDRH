package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;
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

public class VBusPer extends JDialog {

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
	private JLabel lblNomAp2;
	private JLabel lblNomAp1;
	private JLabel lblNomAp3;
	private Button buttonVolver1;
	private Button buttonVolver2;
	
	private ContDatosBusqPer datos2;
	private Conocido conocido;
	private Map<String,Conocido> conocidos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusCaso dialog = new VBusCaso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param datos 
	 * @param persona 
	 * @param b 
	 * @param vMain 
	 */
	public VBusPer() {
		setBounds(100, 100, 449, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setVisible(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane, "name_19326072116700");
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
		lblNewLabel_1.setBounds(68, 69, 61, 14);
		panel_2.add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.setBounds(127, 67, 158, 20);
		panel_2.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(68, 95, 61, 14);
		panel_2.add(lblNewLabel_2);

		textApellido = new JTextField();
		textApellido.setBounds(127, 94, 158, 20);
		panel_2.add(textApellido);
		textApellido.setColumns(10);

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
		textTelefonoO.setBounds(127, 145, 158, 20);
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
		textFallecimiento.setBounds(127, 228, 158, 20);
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
		buttonVolver1.setBounds(293, 260, 107, 31);
		panel_2.add(buttonVolver1);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Conocidos", null, panel, null);
		panel.setLayout(null);

		lblNomAp1 = new JLabel("Nombre y apellidos");
		lblNomAp1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomAp1.setBounds(22, 25, 135, 19);
		panel.add(lblNomAp1);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(82, 55, 35, 14);
		panel.add(lblNewLabel_4);

		textDni1 = new JTextField();
		textDni1.setBounds(116, 53, 147, 20);
		panel.add(textDni1);
		textDni1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Relacion:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(54, 84, 63, 14);
		panel.add(lblNewLabel_5);

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

		JLabel lblNewLabel_4_1_1 = new JLabel("DNI:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(82, 237, 35, 14);
		panel.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Relacion:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(54, 262, 63, 14);
		panel.add(lblNewLabel_5_1_1);

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
			
		
	}
	
	public VBusPer(VPrincipal vMain, boolean modal, Persona persona, ContDatosBusq datos) {
		super(vMain);
		this.setModal(modal);
		setBounds(100, 100, 447, 745);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane, "name_19326072116700");
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
		lblNewLabel_1.setBounds(68, 69, 61, 14);
		panel_2.add(lblNewLabel_1);

		textNombre = new JTextField();
		textNombre.setBounds(127, 67, 158, 20);
		panel_2.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(68, 95, 61, 14);
		panel_2.add(lblNewLabel_2);

		textApellido = new JTextField();
		textApellido.setBounds(127, 94, 158, 20);
		panel_2.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblRango = new JLabel("Rango:");
		lblRango.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRango.setBounds(19, 120, 95, 14);
		lblRango.setVisible(false);
		panel_2.add(lblRango);

		textRango = new JTextField();
		textRango.setBounds(127, 120, 158, 20);
		textRango.setVisible(false);
		panel_2.add(textRango);
		textRango.setColumns(10);
		
		JLabel lblIni = new JLabel("Inicio Servicio:");
		lblIni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIni.setBounds(7, 145, 107, 14);
		lblIni.setVisible(false);
		panel_2.add(lblIni);

		textInicioServ = new JTextField();
		textInicioServ.setBounds(127, 145, 158, 20);
		textInicioServ.setVisible(false);
		panel_2.add(textInicioServ);
		textInicioServ.setColumns(10);
		
		JLabel lblFin = new JLabel("Fin servicio:");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFin.setBounds(53, 180, 61, 14);
		lblFin.setVisible(false);
		panel_2.add(lblFin);

		textFinServ = new JTextField();
		textFinServ.setBounds(127, 178, 158, 20);
		textFinServ.setVisible(false);
		panel_2.add(textFinServ);
		textFinServ.setColumns(10);
		
		JLabel lblFechaA = new JLabel("Fechas de arresto:");
		lblFechaA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaA.setBounds(19, 120, 95, 14);
		lblFechaA.setVisible(false);
		panel_2.add(lblFechaA);

		textFechaArresto = new JTextField();
		textFechaArresto.setBounds(127, 120, 158, 20);
		textFechaArresto.setVisible(false);
		panel_2.add(textFechaArresto);
		textFechaArresto.setColumns(10);
		
		JLabel lblPrisionero = new JLabel("Prision:");
		lblPrisionero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrisionero.setBounds(7, 145, 107, 14);
		lblPrisionero.setVisible(false);
		panel_2.add(lblPrisionero);

		textPrisionero = new JTextField();
		textPrisionero.setBounds(127, 145, 158, 20);
		textPrisionero.setVisible(false);
		panel_2.add(textPrisionero);
		textPrisionero.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltura.setBounds(19, 120, 95, 14);
		lblAltura.setVisible(false);
		panel_2.add(lblAltura);

		textAltura = new JTextField();
		textAltura.setBounds(127, 120, 158, 20);
		textAltura.setVisible(false);
		panel_2.add(textAltura);
		textAltura.setColumns(10);
		
		JLabel lblColorO = new JLabel("Color de ojos:");
		lblColorO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorO.setBounds(7, 145, 107, 14);
		lblColorO.setVisible(false);
		panel_2.add(lblColorO);

		textColorO = new JTextField();
		textColorO.setBounds(127, 145, 158, 20);
		textColorO.setVisible(false);
		panel_2.add(textColorO);
		textColorO.setColumns(10);
		
		JLabel lblColorP = new JLabel("Color de Pelo:");
		lblColorP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColorP.setBounds(53, 180, 61, 14);
		lblColorP.setVisible(false);
		panel_2.add(lblColorP);

		textColorP = new JTextField();
		textColorP.setBounds(127, 178, 158, 20);
		textColorP.setVisible(false);
		panel_2.add(textColorP);
		textColorP.setColumns(10);
		
		JLabel lblEsp = new JLabel("Especificaciones:");
		lblEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEsp.setBounds(41, 205, 75, 14);
		lblEsp.setVisible(false);
		panel_2.add(lblEsp);

		textEspecificaciones = new JTextField();
		textEspecificaciones.setBounds(127, 203, 158, 20);
		textEspecificaciones.setVisible(false);
		panel_2.add(textEspecificaciones);
		textEspecificaciones.setColumns(10);
		
		JLabel lblFechaDes = new JLabel("Fecha desaparecido:");
		lblFechaDes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDes.setBounds(41, 205, 75, 14);
		lblFechaDes.setVisible(false);
		panel_2.add(lblFechaDes);

		textFechaDes = new JTextField();
		textFechaDes.setBounds(127, 228, 158, 20);
		textFechaDes.setVisible(false);
		panel_2.add(textFechaDes);
		textFechaDes.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenero.setBounds(30, 230, 95, 14);
		lblGenero.setVisible(false);
		panel_2.add(lblGenero);

		textGenero = new JTextField();
		textGenero.setBounds(127, 67, 158, 20);
		textGenero.setVisible(false);
		panel_2.add(textGenero);
		textGenero.setColumns(10);
		
		JLabel lblTipoP = new JLabel("Tipo de pelo:");
		lblTipoP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoP.setBounds(68, 69, 61, 14);
		lblTipoP.setVisible(false);
		panel_2.add(lblTipoP);

		textTipoP = new JTextField();
		textTipoP.setBounds(127, 67, 158, 20);
		textTipoP.setVisible(false);
		panel_2.add(textTipoP);
		textTipoP.setColumns(10);
		
		JLabel lblUltimaUbi = new JLabel("Ultima Ubicacion:");
		lblUltimaUbi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUltimaUbi.setBounds(68, 69, 61, 14);
		lblUltimaUbi.setVisible(false);
		panel_2.add(lblUltimaUbi);

		textUltimaUbi = new JTextField();
		textUltimaUbi.setBounds(127, 67, 158, 20);
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
		textTelefonoO.setBounds(127, 145, 158, 20);
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
		textFallecimiento.setBounds(127, 228, 158, 20);
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
		buttonVolver1.setBounds(293, 260, 107, 31);
		panel_2.add(buttonVolver1);

		if (persona != null) {
			textDni.setText(persona.getDni());
			textNombre.setText(persona.getNombre());
			textApellido.setText(persona.getApellido());
			textTelefonoM.setText(persona.getTelefonos().toString());
			textTelefonoO.setText(persona.getTelefonos().toString());
			textLocalidad.setText(persona.getLocalidad());

			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String fechaNac = persona.getFechaNac().format(formateador);
			String fechaFal = persona.getFechaFal().format(formateador);

			textNacimiento.setText(fechaNac);
			textFallecimiento.setText(fechaFal);
			
			if(persona instanceof Agente) {
				textDni.setText(persona.getDni());
				textNombre.setText(persona.getNombre());
				textApellido.setText(persona.getApellido());
				
				ocultarDatosPersona();
				mostrarDatosAgente();
				
				textRango.setText(((Agente) persona).getRango());
				String inicio = ((Agente) persona).getInicioServ().format(formateador);
				String fin = ((Agente) persona).getFinServ().format(formateador);
				textInicioServ.setText(inicio);
				textFinServ.setText(fin);
			}else if(persona instanceof Criminal) {
				textDni.setText(persona.getDni());
				textNombre.setText(persona.getNombre());
				textApellido.setText(persona.getApellido());
				
				ocultarDatosPersona();
				mostrarDatosCriminal();
				
				textFechaArresto.setText(((Criminal) persona).getFechasArresto().toString());
				if(((Criminal) persona).isPrisionero()) {
					textPrisionero.setText("Si");
				}else {
					textPrisionero.setText("No");
				}
			}else if(persona instanceof Desaparecida) {
				textDni.setText(persona.getDni());
				textNombre.setText(persona.getNombre());
				textApellido.setText(persona.getApellido());
				
				ocultarDatosPersona();
				mostrarDatosDesaparecido();
				
				textAltura.setText(Float.toString(((Desaparecida) persona).getAltura()));
				textColorO.setText(((Desaparecida) persona).getColorOjos());
				textColorP.setText(((Desaparecida) persona).getColorPelo());
				textEspecificaciones.setText(((Desaparecida) persona).getEspecificaciones());
				
				String fechaDes = ((Desaparecida) persona).getFechaDes().format(formateador);
				textFechaDes.setText(fechaDes);
				
				textGenero.setText(((Desaparecida) persona).getGenero());
				textTipoP.setText(((Desaparecida) persona).getTipoPelo());
				textUltimaUbi.setText(((Desaparecida) persona).getUltimaUbi());
			}
		}

		JPanel panel = new JPanel();
		tabbedPane.addTab("Conocidos", null, panel, null);
		panel.setLayout(null);

		lblNomAp1 = new JLabel("Nombre y apellidos");
		lblNomAp1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomAp1.setBounds(22, 25, 135, 19);
		panel.add(lblNomAp1);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(82, 55, 35, 14);
		panel.add(lblNewLabel_4);

		textDni1 = new JTextField();
		textDni1.setBounds(116, 53, 147, 20);
		panel.add(textDni1);
		textDni1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Relacion:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(54, 84, 63, 14);
		panel.add(lblNewLabel_5);

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

		JLabel lblNewLabel_4_1_1 = new JLabel("DNI:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(82, 237, 35, 14);
		panel.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Relacion:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1_1.setBounds(54, 262, 63, 14);
		panel.add(lblNewLabel_5_1_1);

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

		nombresCompletos(persona, datos, datos2, conocido);
	}

	private void mostrarDatosDesaparecido() {
		// TODO Auto-generated method stub
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
		textPrisionero.setVisible(true);
		textFechaArresto.setVisible(true);
	}

	private void mostrarDatosAgente() {
		// TODO Auto-generated method stub
		textRango.setVisible(true);
		textInicioServ.setVisible(true);
		textFinServ.setVisible(true);
	}

	private void ocultarDatosPersona() {
		// TODO Auto-generated method stub
		textNacimiento.setVisible(false);
		textTelefonoM.setVisible(false);
		textTelefonoO.setVisible(false);
		textLocalidad.setVisible(false);
	}

	private void nombresCompletos(Persona persona, ContDatosBusq datos, ContDatosBusqPer datos2, Conocido conocido) {
		// TODO Auto-generated method stub
		persona = new Persona();
		persona = datos.buscarPersona(persona.getDni());
		conocidos = new TreeMap<>();
		conocidos = datos2.conocidos(persona.getDni());
		
		for (Conocido cono : conocidos.values()) {
			if (cono.getDni().equalsIgnoreCase(persona.getDni())) {
				lblNomAp1.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp1.getText().equalsIgnoreCase(persona.getNombre()) && cono.getDni().equalsIgnoreCase(persona.getDni())) {
					textDni1.setText(cono.getDni());
					textRelacion1.setText(cono.getRelacion());
				}
				lblNomAp2.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp2.getText().equalsIgnoreCase(persona.getNombre()) && cono.getDni().equalsIgnoreCase(persona.getDni())) {
					textDni2.setText(cono.getDni());
					textRelacion2.setText(cono.getRelacion());
				}
				lblNomAp3.setText(persona.getNombre()+" y "+persona.getApellido());
				if (lblNomAp3.getText().equalsIgnoreCase(persona.getNombre()) && cono.getDni().equalsIgnoreCase(persona.getDni())) {
					textDni3.setText(cono.getDni());
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
}
