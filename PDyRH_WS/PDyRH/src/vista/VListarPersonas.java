package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.interfaces.ContDatosBusq;
import modelo.clases.Persona;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class VListarPersonas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel persona1;
	private JLabel persona2;
	private JLabel persona3;
	private JLabel persona4;
	private JLabel LabelResult;
	
	private Persona per;
	private Map<String, Persona> personas;

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
	 * @param datos 
	 * @param persona 
	 * @param modal 
	 * @param vMain 
	 */
	public VListarPersonas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		    persona1 = new JLabel("Nombre persona 1");
		    persona1.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		
		    	}
		    });
			persona1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona1.setBounds(50, 55, 109, 14);
			contentPanel.add(persona1);
		}
		{
			persona2 = new JLabel("Nombre persona 2");
			persona2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona2.setBounds(50, 102, 109, 14);
			contentPanel.add(persona2);
		}
		{
			persona3 = new JLabel("Nombre persona 3");
			persona3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona3.setBounds(50, 147, 109, 14);
			contentPanel.add(persona3);
		}
		{
			persona4 = new JLabel("Nombre persona 4");
			persona4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona4.setBounds(50, 191, 109, 14);
			contentPanel.add(persona4);
		}
		{
			LabelResult = new JLabel("Resultados: ");
			LabelResult.setBounds(328, 11, 75, 14);
			contentPanel.add(LabelResult);
		}
		{
			JButton ButtonVolverVListarPers = new JButton("Volver");
			ButtonVolverVListarPers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			ButtonVolverVListarPers.setBounds(328, 213, 89, 23);
			contentPanel.add(ButtonVolverVListarPers);
		}
	}
	
	public VListarPersonas(VPrincipal vMain, boolean modal, Persona persona, ContDatosBusq datos) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
		    persona1 = new JLabel("Nombre persona 1");
		    persona1.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {

		    	}
		    });
			persona1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona1.setBounds(50, 55, 109, 14);
			contentPanel.add(persona1);
		}
		{
			persona2 = new JLabel("Nombre persona 2");
			persona2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona2.setBounds(50, 102, 109, 14);
			contentPanel.add(persona2);
		}
		{
			persona3 = new JLabel("Nombre persona 3");
			persona3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona3.setBounds(50, 147, 109, 14);
			contentPanel.add(persona3);
		}
		{
			persona4 = new JLabel("Nombre persona 4");
			persona4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			persona4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			persona4.setBounds(50, 191, 109, 14);
			contentPanel.add(persona4);
		}
		{
			LabelResult = new JLabel("Resultados: ");
			LabelResult.setBounds(328, 11, 75, 14);
			contentPanel.add(LabelResult);
		}
		{
			JButton ButtonVolverVListarPers = new JButton("Volver");
			ButtonVolverVListarPers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volver();
				}
			});
			ButtonVolverVListarPers.setBounds(328, 213, 89, 23);
			contentPanel.add(ButtonVolverVListarPers);
			
			
			
		}
	}
	
	private void volver() {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
