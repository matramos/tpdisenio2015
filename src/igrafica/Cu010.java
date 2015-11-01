package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cu010 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txturl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu010 frame = new Cu010();
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
	public Cu010() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image img = new ImageIcon(this.getClass().getResource("/messi.jpg")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblModificarParticipante = new JLabel("MODIFICAR PARTICPANTE");
		lblModificarParticipante.setBounds(248, 30, 257, 14);
		lblModificarParticipante.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblModificarParticipante);
		
		JLabel lblNombrecompetencia = new JLabel("nombreCompetencia");
		lblNombrecompetencia.setBounds(116, 84, 182, 14);
		contentPane.add(lblNombrecompetencia);
		
		JLabel lblCompetencia = new JLabel("Competencia:");
		lblCompetencia.setBounds(28, 84, 78, 14);
		contentPane.add(lblCompetencia);
		
		JLabel lblNombreDelParticipante = new JLabel("Nombre del Participante o Equipo:");
		lblNombreDelParticipante.setBounds(92, 122, 227, 14);
		contentPane.add(lblNombreDelParticipante);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 147, 161, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(90, 192, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(92, 217, 159, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblimagen = new JLabel("");
		lblimagen.setBounds(92, 264, 148, 111);
		contentPane.add(lblimagen);
		lblimagen.setIcon(new ImageIcon(img));
		
		JLabel lblImagenopcional = new JLabel("Imagen(opcional):");
		lblImagenopcional.setBounds(92, 410, 148, 14);
		contentPane.add(lblImagenopcional);
		
		txturl = new JTextField();
		txturl.setBounds(92, 435, 134, 20);
		contentPane.add(txturl);
		txturl.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(276, 434, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(400, 511, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(566, 511, 89, 23);
		contentPane.add(btnCancelar);
		
	}

}

