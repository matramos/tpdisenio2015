package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Cu002 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu002 frame = new Cu002();
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
	public Cu002() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setFont(new Font("Arial",Font.BOLD,18));	
		lblInicioDeSesion.setBounds(346, 80, 209, 33);
		contentPane.add(lblInicioDeSesion);
		
		textField = new JTextField();
		textField.setBounds(333, 201, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(334, 179, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(333, 254, 67, 14);
		contentPane.add(lblContrasea);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu001 ventana = new Cu001();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setBounds(221, 375, 106, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(522, 375, 89, 23);
		contentPane.add(btnIngresar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(333, 279, 150, 20);
		contentPane.add(passwordField);
	}
}
