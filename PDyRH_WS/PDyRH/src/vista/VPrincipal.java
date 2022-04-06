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

public class VPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
	 */
	public VPrincipal() {
		setTitle("Principal");
		setBounds(100, 100, 416, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnInsertar = new JButton("INSERTAR");
			btnInsertar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnInsertar.setBounds(38, 75, 123, 55);
			contentPanel.add(btnInsertar);
		}
		
		JButton btnBusqueda = new JButton("BUSQUEDA");
		btnBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqueda.setBounds(212, 75, 123, 55);
		contentPanel.add(btnBusqueda);
		
		JButton btnGestionar = new JButton("GESTIONAR");
		btnGestionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGestionar.setBounds(38, 161, 123, 55);
		contentPanel.add(btnGestionar);
		
		JButton btnComparar = new JButton("COMPARAR");
		btnComparar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnComparar.setBounds(212, 161, 123, 55);
		contentPanel.add(btnComparar);
		
		JButton btnBusqRapida = new JButton("Busqueda rapida");
		btnBusqRapida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBusqRapida.setBounds(231, 239, 147, 23);
		contentPanel.add(btnBusqRapida);
		
		{
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
			
			JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
			mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
			mCerrar.setBackground(new Color(32, 178, 170));
			mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mCerrar.setForeground(Color.BLACK);
			menUsuario.add(mCerrar);
		}
	}

}
