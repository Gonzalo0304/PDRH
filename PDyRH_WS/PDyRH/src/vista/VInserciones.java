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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VInserciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPersona;
	private JButton btnRestoHumano;
	private JButton btnVolver;

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
	 * @param b 
	 * @param vPrincipal 
	 */
	public VInserciones() {
		setTitle("Insertar");
		setBounds(100, 100, 507, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
			JSeparator separator = new JSeparator();
			separator.setBounds(93, 227, 27, -47);
			separator.setOrientation(SwingConstants.VERTICAL);
			contentPanel.add(separator);
			
			Button btnPersona = new Button("Persona");
			btnPersona.setBackground(new Color(153, 0, 0));
			btnPersona.setForeground(Color.WHITE);
			btnPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarPersona();
				}
			});
			btnPersona.setBounds(89, 128, 123, 49);
			btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnPersona);
			
			Button btnRestoHumano = new Button("Resto Humano");
			btnRestoHumano.setBackground(new Color(153, 0, 0));
			btnRestoHumano.setForeground(Color.WHITE);
			btnRestoHumano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarRestoHumano();
				}
			});
			btnRestoHumano.setBounds(285, 128, 135, 49);
			btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnRestoHumano);
			
			Button btnCaso = new Button("Caso");
			btnCaso.setBackground(new Color(153, 0, 0));
			btnCaso.setForeground(Color.WHITE);
			btnCaso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarCaso();
				}
			});
			btnCaso.setBounds(183, 215, 135, 49);
			btnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnCaso);
			
			Button btnVolver = new Button("Volver");
			btnVolver.setForeground(Color.WHITE);
			btnVolver.setBackground(new Color(153, 0, 0));
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVolver.setBounds(388, 299, 89, 23);
			contentPanel.add(btnVolver);
				
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
				lblNewLabel_9.setBounds(461, 0, 46, 37);
				contentPanel.add(lblNewLabel_9);
				
					JMenuBar menuBar = new JMenuBar();
					menuBar.setBounds(0, 0, 507, 37);
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
					menuGestionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
					menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
					menuGestionar.setBackground(new Color(0, 0, 255));
					menuGestionar.setForeground(new Color(255, 255, 255));
					menuBar.add(menuGestionar);
					
					JMenu menuComparar = new JMenu("Comparar");
					menuComparar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					menuComparar.setHorizontalAlignment(SwingConstants.LEFT);
					menuComparar.setFont(new Font("Dialog", Font.PLAIN, 14));
					menuComparar.setBackground(new Color(0, 51, 102));
					menuComparar.setForeground(new Color(255, 255, 255));
					menuBar.add(menuComparar);
					
					JMenu menuBusqueda = new JMenu("Busqueda");
					menuBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
					menuBusqueda.setFont(new Font("Dialog", Font.PLAIN, 14));
					menuBusqueda.setBackground(new Color(0, 0, 255));
					menuBusqueda.setForeground(new Color(255, 255, 255));
					menuBar.add(menuBusqueda);
					
					JMenu menUsuario = new JMenu("Usuario");
					menUsuario.setHorizontalAlignment(SwingConstants.LEFT);
					menUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
					menUsuario.setBackground(new Color(0, 0, 255));
					menUsuario.setForeground(new Color(255, 255, 255));
					menuBar.add(menUsuario);
					
					JMenuItem mCerrar = new JMenuItem("Cerrar Sesion");
					mCerrar.setHorizontalAlignment(SwingConstants.TRAILING);
					mCerrar.setBackground(new Color(32, 178, 170));
					mCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
					mCerrar.setForeground(Color.BLACK);
					menUsuario.add(mCerrar);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\Reto Final\\PGR\\Multimedia\\ertzAC.png"));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(0, 37, 507, 329);
					contentPanel.add(lblNewLabel);
		
	
	}
	
	public VInserciones(VPrincipal vMain, boolean modal) {
		super(vMain);
		this.setModal(modal);
		
		setTitle("Insertar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnPersona = new JButton("PERSONA");
			btnPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarPersona();
				}
			});
			btnPersona.setBounds(48, 69, 123, 49);
			btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnPersona);
		}
		{
			btnRestoHumano = new JButton("RESTO HUMANO");
			btnRestoHumano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarRestoHumano();
				}
			});
			btnRestoHumano.setBounds(231, 69, 135, 49);
			btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnRestoHumano);
		}
		{
			JButton btnCaso = new JButton("CASO");
			btnCaso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarCaso();
				}
			});
			btnCaso.setBounds(130, 157, 135, 49);
			btnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnCaso);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVolver.setBounds(335, 227, 89, 23);
			contentPanel.add(btnVolver);
		}
		setUndecorated(true);

		
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 434, 37);
			menuBar.setBorderPainted(false);
			menuBar.setBackground(new Color(0, 51, 153));
			menuBar.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
			contentPanel.add(menuBar);
			
			JMenu menuInsertar = new JMenu("Insertar");
			menuInsertar.setHorizontalAlignment(SwingConstants.LEFT);
			menuInsertar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuInsertar.setBackground(new Color(0, 0, 255));
			menuInsertar.setForeground(Color.BLACK);
			menuBar.add(menuInsertar);
			
			JMenu menuGestionar = new JMenu("Gestionar");
			menuGestionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			menuGestionar.setHorizontalAlignment(SwingConstants.LEFT);
			menuGestionar.setFont(new Font("Dialog", Font.PLAIN, 14));
			menuGestionar.setBackground(new Color(0, 0, 255));
			menuGestionar.setForeground(Color.BLACK);
			menuBar.add(menuGestionar);
			
			JMenu menuComparar = new JMenu("Comparar");
			menuComparar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
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
		
			JSeparator separator = new JSeparator();
			separator.setBounds(93, 227, 27, -47);
			separator.setOrientation(SwingConstants.VERTICAL);
			contentPanel.add(separator);
			
			Button btnPersona = new Button("Persona");
			btnPersona.setBackground(new Color(153, 0, 0));
			btnPersona.setForeground(Color.WHITE);
			btnPersona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarPersona();
				}
			});
			btnPersona.setBounds(48, 69, 123, 49);
			btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnPersona);
			
			Button btnRestoHumano = new Button("Resto Humano");
			btnRestoHumano.setBackground(new Color(153, 0, 0));
			btnRestoHumano.setForeground(Color.WHITE);
			btnRestoHumano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarRestoHumano();
				}
			});
			btnRestoHumano.setBounds(231, 69, 135, 49);
			btnRestoHumano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnRestoHumano);
			
			Button btnCaso = new Button("Caso");
			btnCaso.setBackground(new Color(153, 0, 0));
			btnCaso.setForeground(Color.WHITE);
			btnCaso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarCaso();
				}
			});
			btnCaso.setBounds(130, 157, 135, 49);
			btnCaso.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(btnCaso);
			
			Button btnVolver = new Button("Volver");
			btnVolver.setForeground(Color.WHITE);
			btnVolver.setBackground(new Color(153, 0, 0));
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnVolver.setBounds(335, 227, 89, 23);
			contentPanel.add(btnVolver);
		}
	
	
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	private void insertarCaso() {
		// TODO Auto-generated method stub
		VInsCaso caso = new VInsCaso(this, true);
		caso.setVisible(true);
	}
	
	private void insertarRestoHumano() {
		// TODO Auto-generated method stub
		VInsRH restoHumano = new VInsRH(this, true);
		restoHumano.setVisible(true);
	}
	
	private void insertarPersona() {
		// TODO Auto-generated method stub
		VInsPersona persona = new VInsPersona(this, true);
		persona.setVisible(true);
	}
}

