package igrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class pantallainicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallainicio window = new pantallainicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pantallainicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gevico");
		frame.setResizable(false);
		Image img = new ImageIcon(this.getClass().getResource("/logoTP.png")).getImage();
		
		JPanel pantallaprincipal = new JPanel();
		pantallaprincipal.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(pantallaprincipal);
		pantallaprincipal.setLayout(null);
		
		JLabel lblGevico = new JLabel("GeViCo");
		lblGevico.setBounds(321, 46, 193, 86);
		pantallaprincipal.add(lblGevico);
		lblGevico.setAlignmentX(400);
		lblGevico.setFont(new Font("Arial",Font.BOLD,50));
		
		JLabel lblSistemaDeGestin = new JLabel("Sistema de gesti\u00F3n virtual de competencias deportivas");
		lblSistemaDeGestin.setBounds(249, 128, 346, 14);
		pantallaprincipal.add(lblSistemaDeGestin);
		lblSistemaDeGestin.setAlignmentX(400);
		
		JButton btnIngresarAlSistema = new JButton("Ingresar al sistema");
		btnIngresarAlSistema.setBounds(193, 444, 158, 23);
		pantallaprincipal.add(btnIngresarAlSistema);
		
		JButton btnVerCompetencias = new JButton("Ver competencias");
		btnVerCompetencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu003 ventana = new Cu003();
				ventana.setVisible(true);
				frame.dispose();
			}
		});
		btnVerCompetencias.setBounds(495, 444, 151, 23);
		pantallaprincipal.add(btnVerCompetencias);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(221, 161, 400, 317);
		pantallaprincipal.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img));
		
		JPanel ingresar = new JPanel();
		ingresar.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(ingresar);
		btnIngresarAlSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				Cu002 ventana = new Cu002();
				ventana.setVisible(true);
				frame.dispose();
				ventana.setTitle("Gevico");
				ventana.setResizable(false);
				
				
			}
		});
	}
}
