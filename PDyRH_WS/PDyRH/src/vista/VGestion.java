package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class VGestion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVGestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VGestion dialog = new VGestion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VGestion() {
		setBounds(100, 100, 499, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textVGestion = new JTextField();
		textVGestion.setBounds(195, 122, 226, 20);
		contentPanel.add(textVGestion);
		textVGestion.setColumns(10);
		
		JLabel LabelVGestion = new JLabel("Introduce el identificador:");
		LabelVGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelVGestion.setBounds(39, 125, 160, 14);
		contentPanel.add(LabelVGestion);
		
		JButton ButtonBuscarVGestion = new JButton("Buscar");
		ButtonBuscarVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonBuscarVGestion.setEnabled(false);
		ButtonBuscarVGestion.setBounds(173, 153, 98, 28);
		contentPanel.add(ButtonBuscarVGestion);
		
		JRadioButton RadioButtonPersonaVGestion = new JRadioButton("Persona");
		RadioButtonPersonaVGestion.setSelected(true);
		RadioButtonPersonaVGestion.setBounds(39, 25, 87, 23);
		contentPanel.add(RadioButtonPersonaVGestion);
		
		JRadioButton RadioButtonRHVGestion = new JRadioButton("Resto Humano");
		RadioButtonRHVGestion.setBounds(128, 25, 109, 23);
		contentPanel.add(RadioButtonRHVGestion);
		
		JRadioButton RadioButtonBandaVGestion = new JRadioButton("Banda");
		RadioButtonBandaVGestion.setBounds(249, 25, 68, 23);
		contentPanel.add(RadioButtonBandaVGestion);
		
		JRadioButton RadioButtonCasoVGestion = new JRadioButton("Caso");
		RadioButtonCasoVGestion.setBounds(336, 25, 109, 23);
		contentPanel.add(RadioButtonCasoVGestion);
		
		JButton ButtonVolverVGestion = new JButton("Volver");
		ButtonVolverVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonVolverVGestion.setBounds(384, 227, 89, 23);
		contentPanel.add(ButtonVolverVGestion);
	}
	
	public VGestion(VPrincipal vMain, boolean modal) {
		setBounds(100, 100, 499, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textVGestion = new JTextField();
		textVGestion.setBounds(195, 122, 226, 20);
		contentPanel.add(textVGestion);
		textVGestion.setColumns(10);
		
		JLabel LabelVGestion = new JLabel("Introduce el identificador:");
		LabelVGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelVGestion.setBounds(39, 125, 160, 14);
		contentPanel.add(LabelVGestion);
		
		JButton ButtonBuscarVGestion = new JButton("Buscar");
		ButtonBuscarVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonBuscarVGestion.setEnabled(false);
		ButtonBuscarVGestion.setBounds(173, 153, 98, 28);
		contentPanel.add(ButtonBuscarVGestion);
		
		JRadioButton RadioButtonPersonaVGestion = new JRadioButton("Persona");
		RadioButtonPersonaVGestion.setSelected(true);
		RadioButtonPersonaVGestion.setBounds(39, 25, 87, 23);
		contentPanel.add(RadioButtonPersonaVGestion);
		
		JRadioButton RadioButtonRHVGestion = new JRadioButton("Resto Humano");
		RadioButtonRHVGestion.setBounds(128, 25, 109, 23);
		contentPanel.add(RadioButtonRHVGestion);
		
		JRadioButton RadioButtonBandaVGestion = new JRadioButton("Banda");
		RadioButtonBandaVGestion.setBounds(249, 25, 68, 23);
		contentPanel.add(RadioButtonBandaVGestion);
		
		JRadioButton RadioButtonCasoVGestion = new JRadioButton("Caso");
		RadioButtonCasoVGestion.setBounds(336, 25, 109, 23);
		contentPanel.add(RadioButtonCasoVGestion);
		
		JButton ButtonVolverVGestion = new JButton("Volver");
		ButtonVolverVGestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonVolverVGestion.setBounds(384, 227, 89, 23);
		contentPanel.add(ButtonVolverVGestion);
	}
}
