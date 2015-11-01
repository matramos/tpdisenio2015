package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cu007 extends JFrame {

	private JPanel contentPane;
	private JTextField apellido;
	private JTextField nombre;
	private JTextField documento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu007 frame = new Cu007();
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
	public Cu007() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarDatosDe = new JLabel("MODIFICAR DATOS DE USUARIO");
		lblModificarDatosDe.setBounds(182, 35, 334, 14);
		lblModificarDatosDe.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblModificarDatosDe);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(66, 97, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(63, 206, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(388, 206, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(63, 253, 86, 17);
		contentPane.add(lblTipoDocumento);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(388, 231, 71, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(63, 281, 46, 14);
		contentPane.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(388, 281, 46, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(63, 322, 46, 14);
		contentPane.add(lblLocalidad);
		
		apellido = new JTextField();
		apellido.setBounds(167, 203, 169, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		JCheckBox chckbxAceptoLosTerminos = new JCheckBox("Acepto los terminos y condiciones");
		chckbxAceptoLosTerminos.setBounds(425, 446, 198, 23);
		contentPane.add(chckbxAceptoLosTerminos);
		
		JComboBox comboDocumento = new JComboBox();
		comboDocumento.setBounds(167, 251, 169, 20);
		contentPane.add(comboDocumento);
		
		JComboBox comboPais = new JComboBox();
		comboPais.setBounds(167, 278, 169, 20);
		contentPane.add(comboPais);
		
		JComboBox comboLocalidad = new JComboBox();
		comboLocalidad.setBounds(167, 319, 169, 20);
		contentPane.add(comboLocalidad);
		
		JComboBox comboProvincia = new JComboBox();
		comboProvincia.setBounds(454, 278, 169, 20);
		contentPane.add(comboProvincia);
		
		nombre = new JTextField();
		nombre.setBounds(454, 203, 169, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		documento = new JTextField();
		documento.setBounds(453, 228, 169, 20);
		contentPane.add(documento);
		documento.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(144, 501, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(424, 501, 113, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setBounds(144, 97, 46, 14);
		contentPane.add(lblemail);
	}

}
