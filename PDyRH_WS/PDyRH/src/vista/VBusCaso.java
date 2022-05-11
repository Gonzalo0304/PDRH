package vista;

import java.awt.Font;
import modelo.clases.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import controlador.DataFactoryBusqCaso;
import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosBusqCaso;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class VBusCaso extends JDialog implements ContDatosBusqCaso{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textFechaIni;
	private JTextField textFechaFin;
	private JTextField textDni1;
	private JTextField textImplicacion1;
	private JTextField textDni2;
	private JTextField textImplicacion2;
	private JTextField textCodigoRH;
	private JRadioButton rdbtnAbierto;
	private JRadioButton rdbtnCerrado;
	private JRadioButton rdbtnSinResolver;
	private ButtonGroup grupo = new ButtonGroup();
	private JLabel lblNomAp1;
	private JLabel lblNomAp2;
	private Button buttonVolver1;
	private Button buttonVolver2;
	private JLabel imagen;
	private JLabel lblCerrar;
	private JTabbedPane tabbedPane;
	
	private Participante part;
	private Caso caso;
	private Persona per;
	private Map<String,Participante> participantes;
	private Map<String, RestoHumano> restos;
	
	ContDatosBusqCaso datos2 = DataFactoryBusqCaso.getDatos();
	
	public VBusCaso(VIniciarSesion vInicio, boolean modal, Caso caso2, String[] info) {
		super(vInicio);
		this.setModal(modal);
		
		setTitle("Buscar Caso");
		setBounds(100, 100, 457, 530);
		getContentPane().setLayout(new CardLayout(0, 0));
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
				cerrar();
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(644, 0, 31, 19);
		contentPanel.add(lblCerrar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_7044780698600");
		tabbedPane.addTab("Datos", null, contentPanel, null);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 53, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(39, 94, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblCodigo = new JLabel("Nombre");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(39, 123, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Fecha Inicio");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(29, 154, 68, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblFechafin = new JLabel("Fecha Final");
		lblFechafin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechafin.setBounds(29, 185, 66, 14);
		contentPanel.add(lblFechafin);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(108, 51, 149, 20);
		contentPanel.add(textCodigo);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(108, 121, 149, 20);
		contentPanel.add(textNombre);
		
		textFechaIni = new JTextField();
		textFechaIni.setColumns(10);
		textFechaIni.setBounds(108, 152, 149, 20);
		contentPanel.add(textFechaIni);
		
		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(108, 183, 149, 20);
		contentPanel.add(textFechaFin);
		
		rdbtnAbierto = new JRadioButton("Abierto");
		grupo.add(rdbtnAbierto);
		rdbtnAbierto.setBounds(91, 91, 68, 23);
		contentPanel.add(rdbtnAbierto);
		
		rdbtnCerrado = new JRadioButton("Cerrado");
		grupo.add(rdbtnCerrado);
		rdbtnCerrado.setBounds(161, 91, 68, 23);
		contentPanel.add(rdbtnCerrado);
		
		rdbtnSinResolver = new JRadioButton("Sin resolver");
		grupo.add(rdbtnSinResolver);
		rdbtnSinResolver.setBounds(244, 91, 109, 23);
		contentPanel.add(rdbtnSinResolver);
		
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
		contentPanel.add(buttonVolver1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Involucrados", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNomAp1 = new JLabel("Nombre y Apellido");
		lblNomAp1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomAp1.setBounds(28, 32, 123, 17);
		panel_1.add(lblNomAp1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(97, 69, 33, 14);
		panel_1.add(lblNewLabel_2);
		
		textDni1 = new JTextField();
		textDni1.setBounds(140, 67, 174, 20);
		panel_1.add(textDni1);
		textDni1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Implicacion:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(55, 105, 77, 14);
		panel_1.add(lblNewLabel_3);
		
		textImplicacion1 = new JTextField();
		textImplicacion1.setBounds(140, 103, 174, 20);
		panel_1.add(textImplicacion1);
		textImplicacion1.setColumns(10);
		
		lblNomAp2 = new JLabel("Nombre y Apellido");
		lblNomAp2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomAp2.setBounds(28, 144, 123, 17);
		panel_1.add(lblNomAp2);
		
		JLabel lblNewLabel_2_1 = new JLabel("DNI:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(97, 172, 33, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Implicacion:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(55, 207, 77, 14);
		panel_1.add(lblNewLabel_3_1);
		
		textDni2 = new JTextField();
		textDni2.setColumns(10);
		textDni2.setBounds(140, 170, 174, 20);
		panel_1.add(textDni2);
		
		textImplicacion2 = new JTextField();
		textImplicacion2.setColumns(10);
		textImplicacion2.setBounds(140, 205, 174, 20);
		panel_1.add(textImplicacion2);
		
		JLabel lblNewLabel_4 = new JLabel("Banda");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(55, 258, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Codigo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(84, 291, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_6 = new JLabel("Resto Humano");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(28, 343, 120, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(84, 385, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		textCodigoRH = new JTextField();
		textCodigoRH.setColumns(10);
		textCodigoRH.setBounds(140, 383, 174, 20);
		panel_1.add(textCodigoRH);
		
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
		panel_1.add(buttonVolver2);
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.EAST);
		imagen.setBounds(10, 63, 413, 362);
		contentPanel.add(imagen);
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:/Users/1dam/Desktop/Reto Final/PGR/Multimedia/ertzAC.png"));
		imagen.setHorizontalAlignment(SwingConstants.EAST);
		imagen.setBounds(0, 37, 607, 362);
		panel_1.add(imagen);
		
		//Datos de caso
		if (caso != null) {
			textCodigo.setText(caso.getCodCaso());
			//Estado de los casos
			estados(caso);
			textNombre.setText(caso.getNombre());
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fechaIni = caso.getFechaIni().format(formateador);
			textFechaIni.setText(fechaIni);
			String fechaFin = caso.getFechaFin().format(formateador);
			textFechaFin.setText(fechaFin);
		}
		
		datosInvolucrados(part);
		nombreCompleto(per, part);
	}
	
	private void datosInvolucrados(Participante part) {
		// TODO Auto-generated method stub
		part = new Participante();
		restos = new TreeMap<>();
		restos = listarInvolucrados(part.getCodCaso());		
		
		if(part!=null) {
			textDni1.setText(part.getDni());
			textImplicacion1.setText(part.getImplicacion());
			textDni2.setText(part.getDni());
			textImplicacion2.setText(part.getImplicacion());
			for (RestoHumano restH : restos.values()) {
				if(restH.getCodCaso().equalsIgnoreCase(part.getCodCaso())) {
					textCodigoRH.setText(restH.getCodResto());
				}
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

	private void nombreCompleto(Persona per, Participante part) {
		// TODO Auto-generated method stub
		per = new Persona();
		caso = new Caso();
		part = new Participante();
		participantes = new TreeMap<>();
		participantes = listarParticipantes(caso.getCodCaso());
		
		for(Participante parti : participantes.values()) {
			if (parti.getDni().equalsIgnoreCase(per.getDni())) {
				lblNomAp1.setText(per.getNombre()+" y "+per.getApellido());
				lblNomAp2.setText(per.getNombre()+" y "+per.getApellido());
			}
		}
	}

	private void estados(Caso caso) {
		// TODO Auto-generated method stub
		String abierto = "abierto";
		String cerrado = "cerrado";
		String sinRe = "sin resolver";
		
		if(caso.getEstado().equalsIgnoreCase(abierto)) {
			rdbtnAbierto.setEnabled(false);
			rdbtnAbierto.setSelected(true);
		}else if(caso.getEstado().equalsIgnoreCase(cerrado)) {
			rdbtnCerrado.setEnabled(false);
			rdbtnCerrado.setSelected(true);
		}else if(caso.getEstado().equalsIgnoreCase(sinRe)){
			rdbtnSinResolver.setEnabled(false);
			rdbtnSinResolver.setSelected(true);
		}
	}
	
	protected void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public Map<String, Participante> listarParticipantes(String codCaso) {
		// TODO Auto-generated method stub
		return datos2.listarParticipantes(codCaso);
	}

	@Override
	public Map<String, RestoHumano> listarInvolucrados(String codCaso) {
		// TODO Auto-generated method stub
		return datos2.listarInvolucrados(codCaso);
	}

}
