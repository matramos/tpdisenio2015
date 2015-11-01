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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class Cu014 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDeporte;
	private JTextField txtNombre;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu014 frame = new Cu014();
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
	public Cu014() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDarDeAlta = new JLabel("DAR DE ALTA LUGAR DE REALIZACION");
		lblDarDeAlta.setBounds(227, 39, 348, 14);
		lblDarDeAlta.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblDarDeAlta);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(58, 105, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(100, 102, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(58, 133, 46, 14);
		contentPane.add(lblDeporte);
		
		txtDeporte = new JTextField();
		txtDeporte.setBounds(100, 130, 86, 20);
		contentPane.add(txtDeporte);
		txtDeporte.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(210, 129, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(374, 105, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(420, 102, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 204, 242, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Deporte", "Eliminar"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnX = new JButton("X");
		btnX.setBounds(286, 230, 61, 23);
		contentPane.add(btnX);
		
		JLabel lblReglamentoopcional = new JLabel("Reglamento(opcional):");
		lblReglamentoopcional.setBounds(361, 313, 120, 14);
		contentPane.add(lblReglamentoopcional);
		
		JTextPane txtReglamento = new JTextPane();
		txtReglamento.setBounds(288, 338, 287, 181);
		contentPane.add(txtReglamento);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(210, 530, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(417, 530, 89, 23);
		contentPane.add(btnCancelar);
	}

}
