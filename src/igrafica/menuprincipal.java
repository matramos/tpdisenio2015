package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal();
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
	public menuprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gevico");
		setResizable(false);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenPrincipal = new JLabel("Men\u00FA principal");
		lblMenPrincipal.setFont(new Font("Arial",Font.BOLD, 30));
		lblMenPrincipal.setBounds(310, 54, 220, 25);
		contentPane.add(lblMenPrincipal);
		
		JButton btnNewButton = new JButton("Listar Competencias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu003 ventana = new Cu003();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(142, 154, 220, 84);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dar de Baja Usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu012 popup = new Cu012();
				popup.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(485, 154, 208, 84);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar Lugares de Realizaci\u00F3n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu013 ventana = new Cu013();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(142, 264, 220, 84);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modificar Datos de Usuario");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu007 ventana = new Cu007();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(485, 264, 208, 84);
		contentPane.add(btnNewButton_3);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(334, 393, 171, 44);
		contentPane.add(btnCerrarSesin);
	}

}
