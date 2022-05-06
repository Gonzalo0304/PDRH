package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VBusRapida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVBusquedaRapida;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @param modal 
	 * @param padre 
	 * @param info 
	 */
	public VBusRapida(VIniciarSesion padre, boolean modal, String[] info) {
		super(padre);
		this.setModal(true);
		
		setTitle("Busqueda Rapida");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 463, 37);
			menuBar.setBorderPainted(false);
			menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
			contentPanel.add(menuBar);
			
			JMenu menuInsertar = new JMenu("Insertar");
			menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
			menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuInsertar.setBackground(new Color(0, 0, 255));
			menuInsertar.setForeground(Color.BLACK);
			menuBar.add(menuInsertar);
			
			JMenu menuGestionar = new JMenu("Gestionar");
			menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
			menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuGestionar.setBackground(new Color(0, 0, 255));
			menuGestionar.setForeground(Color.BLACK);
			menuBar.add(menuGestionar);
			
			JMenu menuComparar = new JMenu("Comparar");
			menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
			menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuComparar.setBackground(new Color(0, 0, 255));
			menuComparar.setForeground(Color.BLACK);
			menuBar.add(menuComparar);
			
			JMenu menuBusqueda = new JMenu("Busqueda");
			menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
			menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuBusqueda.setBackground(new Color(0, 0, 255));
			menuBusqueda.setForeground(Color.BLACK);
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
			menUsuario.setForeground(Color.BLACK);
			
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
		{
			JLabel LabelVBusquedaRapida = new JLabel("Introduce el nombre:");
			LabelVBusquedaRapida.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVBusquedaRapida.setBounds(29, 109, 128, 14);
			contentPanel.add(LabelVBusquedaRapida);
		}
		{
			textVBusquedaRapida = new JTextField();
			textVBusquedaRapida.setBounds(167, 106, 201, 20);
			contentPanel.add(textVBusquedaRapida);
			textVBusquedaRapida.setColumns(10);
		}
		{
			JButton ButtonVBusquedaRapida = new JButton("Buscar");
			ButtonVBusquedaRapida.setFont(new Font("Dialog", Font.PLAIN, 14));
			ButtonVBusquedaRapida.setEnabled(false);
			ButtonVBusquedaRapida.setBounds(177, 137, 89, 23);
			contentPanel.add(ButtonVBusquedaRapida);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnVolver.setBounds(335, 227, 89, 23);
			contentPanel.add(btnVolver);
		}
	}
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	private void cerrarSesion() {
		// TODO Auto-generated method stub
		
	}

}
