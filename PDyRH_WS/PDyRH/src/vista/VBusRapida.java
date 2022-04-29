package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class VBusRapida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVBusquedaRapida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBusRapida dialog = new VBusRapida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBusRapida() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(335, 227, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}
	
	public VBusRapida(VPrincipal vMain, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(335, 227, 89, 23);
			contentPanel.add(btnNewButton);
		}
	}

}
