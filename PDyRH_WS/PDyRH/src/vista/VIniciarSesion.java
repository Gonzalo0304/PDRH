package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VIniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textIdentificador;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIniciarSesion frame = new VIniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VIniciarSesion() {
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbIdentificador = new JLabel("IDENTIFICADOR");
		lbIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbIdentificador.setBounds(36, 53, 131, 33);
		contentPane.add(lbIdentificador);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasena.setBounds(36, 119, 131, 20);
		contentPane.add(lblContrasena);
		
		textIdentificador = new JTextField();
		textIdentificador.setBounds(177, 61, 188, 20);
		contentPane.add(textIdentificador);
		textIdentificador.setColumns(10);
		
		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(177, 121, 188, 20);
		contentPane.add(textContrasena);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAceptar.setBounds(80, 211, 89, 33);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.setBounds(231, 211, 89, 33);
		contentPane.add(btnSalir);
	}
}
