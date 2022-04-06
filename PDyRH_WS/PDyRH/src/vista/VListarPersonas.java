package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VListarPersonas extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VListarPersonas dialog = new VListarPersonas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VListarPersonas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel LabelVListarPersona1 = new JLabel("Nombre persona 1");
			LabelVListarPersona1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVListarPersona1.setBounds(50, 55, 109, 14);
			contentPanel.add(LabelVListarPersona1);
		}
		{
			JLabel LabelVListarPersona2 = new JLabel("Nombre persona 2");
			LabelVListarPersona2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVListarPersona2.setBounds(50, 102, 109, 14);
			contentPanel.add(LabelVListarPersona2);
		}
		{
			JLabel LabelVListarPersona3 = new JLabel("Nombre persona 3");
			LabelVListarPersona3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVListarPersona3.setBounds(50, 147, 109, 14);
			contentPanel.add(LabelVListarPersona3);
		}
		{
			JLabel LabelVListarPersona4 = new JLabel("Nombre persona 4");
			LabelVListarPersona4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			LabelVListarPersona4.setBounds(50, 191, 109, 14);
			contentPanel.add(LabelVListarPersona4);
		}
		{
			JLabel LabelVListarPersonaResult = new JLabel("Resultados: ");
			LabelVListarPersonaResult.setBounds(328, 11, 75, 14);
			contentPanel.add(LabelVListarPersonaResult);
		}
		{
			JButton ButtonVolverVListarPers = new JButton("Volver");
			ButtonVolverVListarPers.setBounds(328, 213, 89, 23);
			contentPanel.add(ButtonVolverVListarPers);
		}
	}

}
