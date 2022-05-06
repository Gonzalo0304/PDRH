package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VComRH extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFechaRHVComRH;
	private JTextField textUbiRHVComRH;
	private JTextField textGeneroRHVComRH;
	private JTextField textAlturaRHVComRH;
	private JTextField textColorPeloRHVComRH;
	private JTextField textTipoPeloRHVComRH;
	private JTextField textEspecificRHVComRH;
	private JTextField textEspecificDesVComRH;
	private JTextField textFAlturaDesVComRH;
	private JTextField textColorPeloDesVComRH;
	private JTextField textTipoPeloDesVComRH;
	private JTextField textGeneroDesVComRH;
	private JTextField textUbicacionDesVComRH;
	private JTextField textFechaDesVComRH;
	private JButton ButtonVolverVCom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VComRH dialog = new VComRH();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VComRH() {
		setBounds(100, 100, 503, 397);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 491, 37);
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
			mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
			mCerrar.setBackground(new Color(32, 178, 170));
			mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			mCerrar.setForeground(Color.BLACK);
			menUsuario.add(mCerrar);
		}
		{
			JLabel lblNewLabel = new JLabel("Fecha:");
			lblNewLabel.setBounds(61, 102, 36, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ubicacion:");
			lblNewLabel_1.setBounds(51, 138, 49, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("G\u00E9nero:");
			lblNewLabel_2.setBounds(51, 163, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tipo de pelo:");
			lblNewLabel_3.setBounds(35, 187, 62, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color de pelo:");
			lblNewLabel_4.setBounds(26, 212, 71, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Altura:");
			lblNewLabel_5.setBounds(61, 237, 36, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Especificaciones:");
			lblNewLabel_6.setBounds(16, 262, 81, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Especificaciones:");
			lblNewLabel_6.setBounds(244, 259, 81, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Altura:");
			lblNewLabel_5.setBounds(279, 234, 36, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color de pelo:");
			lblNewLabel_4.setBounds(254, 203, 71, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tipo de pelo:");
			lblNewLabel_3.setBounds(263, 178, 62, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("G\u00E9nero:");
			lblNewLabel_2.setBounds(279, 153, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ubicacion:");
			lblNewLabel_1.setBounds(270, 122, 49, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Fecha:");
			lblNewLabel.setBounds(283, 91, 36, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Resto humano");
			lblNewLabel_7.setBounds(139, 63, 71, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Desaparecida");
			lblNewLabel_8.setBounds(355, 63, 81, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			textFechaRHVComRH = new JTextField();
			textFechaRHVComRH.setBounds(107, 99, 127, 20);
			contentPanel.add(textFechaRHVComRH);
			textFechaRHVComRH.setColumns(10);
		}
		{
			textUbiRHVComRH = new JTextField();
			textUbiRHVComRH.setColumns(10);
			textUbiRHVComRH.setBounds(107, 132, 127, 20);
			contentPanel.add(textUbiRHVComRH);
		}
		{
			textGeneroRHVComRH = new JTextField();
			textGeneroRHVComRH.setColumns(10);
			textGeneroRHVComRH.setBounds(107, 160, 127, 20);
			contentPanel.add(textGeneroRHVComRH);
		}
		{
			textAlturaRHVComRH = new JTextField();
			textAlturaRHVComRH.setColumns(10);
			textAlturaRHVComRH.setBounds(107, 231, 127, 20);
			contentPanel.add(textAlturaRHVComRH);
		}
		{
			textColorPeloRHVComRH = new JTextField();
			textColorPeloRHVComRH.setColumns(10);
			textColorPeloRHVComRH.setBounds(107, 209, 127, 20);
			contentPanel.add(textColorPeloRHVComRH);
		}
		{
			textTipoPeloRHVComRH = new JTextField();
			textTipoPeloRHVComRH.setColumns(10);
			textTipoPeloRHVComRH.setBounds(107, 184, 127, 20);
			contentPanel.add(textTipoPeloRHVComRH);
		}
		{
			textEspecificRHVComRH = new JTextField();
			textEspecificRHVComRH.setColumns(10);
			textEspecificRHVComRH.setBounds(107, 259, 127, 20);
			contentPanel.add(textEspecificRHVComRH);
		}
		{
			textEspecificDesVComRH = new JTextField();
			textEspecificDesVComRH.setColumns(10);
			textEspecificDesVComRH.setBounds(329, 256, 127, 20);
			contentPanel.add(textEspecificDesVComRH);
		}
		{
			textFAlturaDesVComRH = new JTextField();
			textFAlturaDesVComRH.setColumns(10);
			textFAlturaDesVComRH.setBounds(329, 231, 127, 20);
			contentPanel.add(textFAlturaDesVComRH);
		}
		{
			textColorPeloDesVComRH = new JTextField();
			textColorPeloDesVComRH.setColumns(10);
			textColorPeloDesVComRH.setBounds(329, 206, 127, 20);
			contentPanel.add(textColorPeloDesVComRH);
		}
		{
			textTipoPeloDesVComRH = new JTextField();
			textTipoPeloDesVComRH.setColumns(10);
			textTipoPeloDesVComRH.setBounds(329, 181, 127, 20);
			contentPanel.add(textTipoPeloDesVComRH);
		}
		{
			textGeneroDesVComRH = new JTextField();
			textGeneroDesVComRH.setColumns(10);
			textGeneroDesVComRH.setBounds(329, 150, 127, 20);
			contentPanel.add(textGeneroDesVComRH);
		}
		{
			textUbicacionDesVComRH = new JTextField();
			textUbicacionDesVComRH.setColumns(10);
			textUbicacionDesVComRH.setBounds(329, 119, 127, 20);
			contentPanel.add(textUbicacionDesVComRH);
		}
		{
			textFechaDesVComRH = new JTextField();
			textFechaDesVComRH.setColumns(10);
			textFechaDesVComRH.setBounds(329, 88, 127, 20);
			contentPanel.add(textFechaDesVComRH);
		}
		
		JButton ButtonIdentificVCom = new JButton("Identificar");
		ButtonIdentificVCom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ButtonIdentificVCom.setBounds(121, 302, 89, 32);
		contentPanel.add(ButtonIdentificVCom);
		
		ButtonVolverVCom = new JButton("Volver");
		ButtonVolverVCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		ButtonVolverVCom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ButtonVolverVCom.setBounds(347, 302, 89, 32);
		contentPanel.add(ButtonVolverVCom);
	}
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
