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
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class VInserciones extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VInserciones dialog = new VInserciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VInserciones() {
		setTitle("Insertar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("PERSONA");
			btnNewButton.setBounds(48, 69, 123, 49);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnRestoHumano = new JButton("RESTO HUMANO");
			btnRestoHumano.setBounds(231, 69, 135, 49);
			btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnRestoHumano);
		}
		{
			JButton btnBanda = new JButton("BANDA");
			btnBanda.setBounds(48, 159, 123, 49);
			btnBanda.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnBanda);
		}
		{
			JButton btnPersona = new JButton("CASO");
			btnPersona.setBounds(231, 159, 135, 49);
			btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnPersona);
		}
		{
			JButton btnNewButton_1 = new JButton("Volver");
			btnNewButton_1.setBounds(335, 227, 89, 23);
			contentPanel.add(btnNewButton_1);
		}
		
		{
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 434, 37);
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
			
			JMenuItem mTotal = new JMenuItem("Total");
			mTotal.setHorizontalAlignment(SwingConstants.LEFT);
			mTotal.setBackground(new Color(32, 178, 170));
			mTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mTotal.setForeground(Color.BLACK);
			menuComparar.add(mTotal);
			
			JMenuItem mEspecifico = new JMenuItem("Especifico");
			mEspecifico.setHorizontalAlignment(SwingConstants.LEFT);
			mEspecifico.setBackground(new Color(32, 178, 170));
			mEspecifico.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mEspecifico.setForeground(Color.BLACK);
			menuComparar.add(mEspecifico);
			
			JMenu menuBusqueda = new JMenu("Busqueda");
			menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
			menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuBusqueda.setBackground(new Color(0, 0, 255));
			menuBusqueda.setForeground(Color.BLACK);
			menuBar.add(menuBusqueda);
			
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
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(93, 227, 27, -47);
			separator.setOrientation(SwingConstants.VERTICAL);
			contentPanel.add(separator);
		}
	
	}
}

