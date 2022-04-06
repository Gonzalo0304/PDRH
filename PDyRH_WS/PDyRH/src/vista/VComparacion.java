package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VComparacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VComparacion dialog = new VComparacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VComparacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton ButtonVolvervComp = new JButton("Volver");
		ButtonVolvervComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonVolvervComp.setBounds(319, 227, 105, 23);
		contentPanel.add(ButtonVolvervComp);
		
		JButton ButtonCompSelVComp = new JButton("Comprobar sel.");
		ButtonCompSelVComp.setEnabled(false);
		ButtonCompSelVComp.setBounds(319, 198, 105, 23);
		contentPanel.add(ButtonCompSelVComp);
		
		JRadioButton RadioButton1VComparacion = new JRadioButton("");
		RadioButton1VComparacion.setBounds(177, 72, 27, 21);
		contentPanel.add(RadioButton1VComparacion);
		
		JRadioButton RadioButton2VComparacion = new JRadioButton("");
		RadioButton2VComparacion.setBounds(177, 88, 27, 23);
		contentPanel.add(RadioButton2VComparacion);
		
		JRadioButton RadioButton3VComparacion = new JRadioButton("");
		RadioButton3VComparacion.setBounds(177, 164, 27, 23);
		contentPanel.add(RadioButton3VComparacion);
		
		JRadioButton RadioButton4VComparacion = new JRadioButton("");
		RadioButton4VComparacion.setBounds(177, 182, 27, 23);
		contentPanel.add(RadioButton4VComparacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBounds(10, 50, 161, 61);
		contentPanel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Resto Humano");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		table = new JTable();
		table.setBorder(new LineBorder(SystemColor.scrollbar, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Resto Humano");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 35, 161, 14);
		contentPanel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(Color.BLACK);
		scrollPane_1.setBounds(10, 144, 161, 61);
		contentPanel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Resto Humano");
		lblNewLabel_1_1.setBackground(SystemColor.window);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 130, 161, 14);
		contentPanel.add(lblNewLabel_1_1);
	}
}
