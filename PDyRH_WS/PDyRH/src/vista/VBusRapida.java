package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controlador.interfaces.ContDatosBusq;
import controlador.interfaces.ContDatosBusqRap;
import modelo.clases.Persona;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;

public class VBusRapida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVBusquedaRapida;
	private Persona persona;
	private Map<String, Persona> personas;
	private ContDatosBusqRap datos2;
	private Button buttonBusR;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param datos 
	 * @param modal 
	 * @param vPrincipal 
	 * @param modal 
	 * @param vMain 
	 */
	
	

	public VBusRapida(VPrincipal vMain, boolean modal, ContDatosBusq datos) {
		super(vMain);
		this.setModal(true);
		setTitle("Busqueda Rapida");
		setBounds(100, 100, 607, 399);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		buttonBusR = new Button("Buscar");
		buttonBusR.setEnabled(false);
		buttonBusR.setForeground(new Color(255, 255, 255));
		buttonBusR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busRapida(vMain, datos2, datos);
			}
		});
		buttonBusR.setBackground(new Color(122, 42, 42));
		buttonBusR.setBounds(265, 232, 70, 22);
		contentPanel.add(buttonBusR);
		{
			JLabel LabelVBusquedaRapida = new JLabel("Introduce el nombre:");
			LabelVBusquedaRapida.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVBusquedaRapida.setBounds(110, 191, 128, 14);
			contentPanel.add(LabelVBusquedaRapida);
		}
		{
			textVBusquedaRapida = new JTextField();
			textVBusquedaRapida.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					habilitarBoton();
				}
			});
			textVBusquedaRapida.setBounds(248, 188, 201, 20);
			contentPanel.add(textVBusquedaRapida);
			textVBusquedaRapida.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 35, 607, 364);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				volver();
			}
		});
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBackground(new Color(0, 51, 153));
		lblNewLabel_9.setBounds(561, 0, 46, 37);
		contentPanel.add(lblNewLabel_9);
		{
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 607, 37);
			menuBar.setBorderPainted(false);
			menuBar.setBackground(new Color(0, 51, 102));
			contentPanel.add(menuBar);
			
			JMenu menuInsertar = new JMenu("Insertar");
			menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
			menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuInsertar.setBackground(new Color(0, 0, 255));
			menuInsertar.setForeground(new Color(255, 255, 255));
			menuBar.add(menuInsertar);
			
			JMenu menuGestionar = new JMenu("Gestionar");
			menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
			menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuGestionar.setBackground(new Color(0, 0, 255));
			menuGestionar.setForeground(new Color(255, 255, 255));
			menuBar.add(menuGestionar);
			
			JMenu menuComparar = new JMenu("Comparar");
			menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
			menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuComparar.setBackground(new Color(0, 0, 255));
			menuComparar.setForeground(new Color(255, 255, 255));
			menuBar.add(menuComparar);
			
			JMenu menuBusqueda = new JMenu("Busqueda");
			menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
			menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuBusqueda.setBackground(new Color(0, 0, 255));
			menuBusqueda.setForeground(new Color(255, 255, 255));
			menuBar.add(menuBusqueda);
			
			JMenuItem mPersona = new JMenuItem("Persona");
			mPersona.setHorizontalAlignment(SwingConstants.LEFT);
			mPersona.setBackground(new Color(32, 178, 170));
			mPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mPersona.setForeground(Color.BLACK);
			menuBusqueda.add(mPersona);
			
			JMenuItem mRestoHumano = new JMenuItem("Resto Humano");
			mRestoHumano.setHorizontalAlignment(SwingConstants.RIGHT);
			mRestoHumano.setBackground(new Color(32, 178, 170));
			mRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mRestoHumano.setForeground(Color.BLACK);
			menuBusqueda.add(mRestoHumano);
			
			JMenuItem mCaso = new JMenuItem("Caso");
			mCaso.setHorizontalAlignment(SwingConstants.LEFT);
			mCaso.setBackground(new Color(32, 178, 170));
			mCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mCaso.setForeground(Color.BLACK);
			menuBusqueda.add(mCaso);
			
			JMenuItem mBanda = new JMenuItem("Banda");
			mBanda.setHorizontalAlignment(SwingConstants.LEFT);
			mBanda.setBackground(new Color(32, 178, 170));
			mBanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mBanda.setForeground(Color.BLACK);
			menuBusqueda.add(mBanda);
			
			JMenuItem mCriminal = new JMenuItem("Criminales");
			mCriminal.setHorizontalAlignment(SwingConstants.LEFT);
			mCriminal.setBackground(new Color(32, 178, 170));
			mCriminal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mCriminal.setForeground(Color.BLACK);
			menuBusqueda.add(mCriminal);
			
			JMenu menUsuario = new JMenu("Usuario");
			menuBar.add(menUsuario);
			menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
			menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
			menUsuario.setBackground(new Color(0, 0, 255));
			menUsuario.setForeground(new Color(255, 255, 255));
			
			JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
			mCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarSesion();
				}
			});
			mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
			mCerrar.setBackground(new Color(32, 178, 170));
			mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mCerrar.setForeground(Color.BLACK);
			menUsuario.add(mCerrar);
		}
	}
	
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		
	}
	private void busRapida(VPrincipal vMain, ContDatosBusqRap datos2, ContDatosBusq datos) {
		// TODO Auto-generated method stub
		persona = new Persona();
		personas = new TreeMap<>();
		personas = datos2.obtenerPersonas(persona.getNombre());
		
		if(textVBusquedaRapida.getText().equalsIgnoreCase(persona.getNombre())) {
			VListarPersonas listaPer = new VListarPersonas(vMain, true, personas.get(persona.getNombre()), datos);
			this.dispose();
			listaPer.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "No se han encontrado coincidencias");
		}
	}

	
	private void volver() {
		VPrincipal principal = new VPrincipal();
		this.dispose();
		principal.setVisible(true);
	}
	
	private void habilitarBoton() {
		if(!textVBusquedaRapida.getText().isEmpty()) {
			buttonBusR.setEnabled(true);
			buttonBusR.setBackground(new Color(153, 0, 0));
		}else {
			buttonBusR.setEnabled(false);
			buttonBusR.setBackground(new Color(122, 42, 42));
		}
	}
}
