package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JButton;

public class Cu019 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu019 frame = new Cu019();
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
	public Cu019() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFixture = new JLabel("FIXTURE");
		lblFixture.setBounds(357, 26, 126, 14);
		lblFixture.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblFixture);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(226, 67, 46, 14);
		contentPane.add(lblFecha);
		
		JComboBox comboFecha = new JComboBox();
		comboFecha.setBounds(271, 64, 116, 20);
		contentPane.add(comboFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 118, 433, 186);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Modificaci\u00F3n", "Lugar", "Resultado", "Participante 2", "Participante 1"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(357, 381, 89, 23);
		contentPane.add(btnSalir);
	}
}
