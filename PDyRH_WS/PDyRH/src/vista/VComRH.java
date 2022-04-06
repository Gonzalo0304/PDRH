package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		setBounds(100, 100, 516, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Fecha:");
			lblNewLabel.setBounds(61, 52, 36, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ubicacion:");
			lblNewLabel_1.setBounds(48, 77, 49, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("G\u00E9nero:");
			lblNewLabel_2.setBounds(57, 102, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tipo de pelo:");
			lblNewLabel_3.setBounds(32, 127, 62, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color de pelo:");
			lblNewLabel_4.setBounds(32, 152, 71, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Altura:");
			lblNewLabel_5.setBounds(67, 177, 36, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Especificaciones:");
			lblNewLabel_6.setBounds(22, 203, 81, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Especificaciones:");
			lblNewLabel_6.setBounds(247, 203, 81, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Altura:");
			lblNewLabel_5.setBounds(292, 177, 36, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color de pelo:");
			lblNewLabel_4.setBounds(257, 152, 71, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tipo de pelo:");
			lblNewLabel_3.setBounds(257, 127, 62, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("G\u00E9nero:");
			lblNewLabel_2.setBounds(282, 102, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Ubicacion:");
			lblNewLabel_1.setBounds(273, 77, 49, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Fecha:");
			lblNewLabel.setBounds(286, 52, 36, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Resto humano");
			lblNewLabel_7.setBounds(137, 23, 71, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Desaparecida");
			lblNewLabel_8.setBounds(359, 23, 81, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			textFechaRHVComRH = new JTextField();
			textFechaRHVComRH.setBounds(107, 49, 127, 20);
			contentPanel.add(textFechaRHVComRH);
			textFechaRHVComRH.setColumns(10);
		}
		{
			textUbiRHVComRH = new JTextField();
			textUbiRHVComRH.setColumns(10);
			textUbiRHVComRH.setBounds(107, 74, 127, 20);
			contentPanel.add(textUbiRHVComRH);
		}
		{
			textGeneroRHVComRH = new JTextField();
			textGeneroRHVComRH.setColumns(10);
			textGeneroRHVComRH.setBounds(107, 99, 127, 20);
			contentPanel.add(textGeneroRHVComRH);
		}
		{
			textAlturaRHVComRH = new JTextField();
			textAlturaRHVComRH.setColumns(10);
			textAlturaRHVComRH.setBounds(107, 174, 127, 20);
			contentPanel.add(textAlturaRHVComRH);
		}
		{
			textColorPeloRHVComRH = new JTextField();
			textColorPeloRHVComRH.setColumns(10);
			textColorPeloRHVComRH.setBounds(107, 149, 127, 20);
			contentPanel.add(textColorPeloRHVComRH);
		}
		{
			textTipoPeloRHVComRH = new JTextField();
			textTipoPeloRHVComRH.setColumns(10);
			textTipoPeloRHVComRH.setBounds(107, 124, 127, 20);
			contentPanel.add(textTipoPeloRHVComRH);
		}
		{
			textEspecificRHVComRH = new JTextField();
			textEspecificRHVComRH.setColumns(10);
			textEspecificRHVComRH.setBounds(107, 202, 127, 20);
			contentPanel.add(textEspecificRHVComRH);
		}
		{
			textEspecificDesVComRH = new JTextField();
			textEspecificDesVComRH.setColumns(10);
			textEspecificDesVComRH.setBounds(329, 202, 127, 20);
			contentPanel.add(textEspecificDesVComRH);
		}
		{
			textFAlturaDesVComRH = new JTextField();
			textFAlturaDesVComRH.setColumns(10);
			textFAlturaDesVComRH.setBounds(329, 174, 127, 20);
			contentPanel.add(textFAlturaDesVComRH);
		}
		{
			textColorPeloDesVComRH = new JTextField();
			textColorPeloDesVComRH.setColumns(10);
			textColorPeloDesVComRH.setBounds(329, 149, 127, 20);
			contentPanel.add(textColorPeloDesVComRH);
		}
		{
			textTipoPeloDesVComRH = new JTextField();
			textTipoPeloDesVComRH.setColumns(10);
			textTipoPeloDesVComRH.setBounds(329, 124, 127, 20);
			contentPanel.add(textTipoPeloDesVComRH);
		}
		{
			textGeneroDesVComRH = new JTextField();
			textGeneroDesVComRH.setColumns(10);
			textGeneroDesVComRH.setBounds(329, 99, 127, 20);
			contentPanel.add(textGeneroDesVComRH);
		}
		{
			textUbicacionDesVComRH = new JTextField();
			textUbicacionDesVComRH.setColumns(10);
			textUbicacionDesVComRH.setBounds(329, 74, 127, 20);
			contentPanel.add(textUbicacionDesVComRH);
		}
		{
			textFechaDesVComRH = new JTextField();
			textFechaDesVComRH.setColumns(10);
			textFechaDesVComRH.setBounds(329, 49, 127, 20);
			contentPanel.add(textFechaDesVComRH);
		}
		
		JButton ButtonIdentificVCom = new JButton("Identificar");
		ButtonIdentificVCom.setBounds(82, 228, 89, 23);
		contentPanel.add(ButtonIdentificVCom);
		
		JButton ButtonVolverVCom = new JButton("Volver");
		ButtonVolverVCom.setBounds(316, 228, 89, 23);
		contentPanel.add(ButtonVolverVCom);
	}
}
