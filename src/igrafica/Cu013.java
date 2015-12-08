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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cu013 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreLugar;
	private JTextField txtCodigo;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu013 frame = new Cu013(1);
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
	public Cu013(final long id_usuario) {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeLugares = new JLabel("LISTA DE LUGARES DE REALIZACION");
		lblListaDeLugares.setBounds(223, 24, 341, 14);
		lblListaDeLugares.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblListaDeLugares);
		
		JLabel lblNombreDeLugar = new JLabel("Nombre de Lugar:");
		lblNombreDeLugar.setBounds(44, 92, 102, 14);
		contentPane.add(lblNombreDeLugar);
		
		txtNombreLugar = new JTextField();
		txtNombreLugar.setBounds(39, 117, 126, 20);
		contentPane.add(txtNombreLugar);
		txtNombreLugar.setColumns(10);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte Asociado:");
		lblDeporteAsociado.setBounds(39, 170, 89, 14);
		contentPane.add(lblDeporteAsociado);
		
		JComboBox comboDeporteAsociado = new JComboBox();
		comboDeporteAsociado.setBounds(44, 195, 121, 20);
		contentPane.add(comboDeporteAsociado);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(285, 92, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(274, 117, 126, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(162, 236, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCrearLugar = new JButton("Crear Lugar");
		btnCrearLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu014 ventana = new Cu014();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCrearLugar.setBounds(343, 236, 89, 23);
		contentPane.add(btnCrearLugar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal(id_usuario);
				ventana.setVisible(true);
				dispose();
				
			}
		});
		btnCancelar.setBounds(310, 470, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnX.setBounds(342, 317, 58, 23);
		contentPane.add(btnX);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 294, 292, 133);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Eliminar", "Modificar", "Deporte", "Lugar", "Codigo"
			}
		));
		scrollPane.setViewportView(tabla);
		
		JButton btnM = new JButton("M");
		btnM.setBounds(429, 317, 89, 23);
		contentPane.add(btnM);
	}
}
