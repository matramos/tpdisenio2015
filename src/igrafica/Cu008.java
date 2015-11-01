package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Cu008 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu008 frame = new Cu008();
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
	public Cu008() {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDeCompetencia = new JLabel("LISTADO DE COMPETENCIA");
		lblListadoDeCompetencia.setBounds(226, 34, 293, 14);
		lblListadoDeCompetencia.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblListadoDeCompetencia);
		
		JLabel lblCompetencia = new JLabel("Competencia");
		lblCompetencia.setBounds(57, 98, 68, 14);
		contentPane.add(lblCompetencia);
		
		JLabel lblCompe = new JLabel("compe");
		lblCompe.setBounds(140, 98, 46, 14);
		contentPane.add(lblCompe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 147, 181, 110);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"E-Mail", "Nombre de Equipo o Participante"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(271, 150, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(394, 150, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnAgregarParticipante = new JButton("Agregar Participante");
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu009 ventana = new Cu009();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnAgregarParticipante.setBounds(57, 327, 143, 23);
		contentPane.add(btnAgregarParticipante);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 400, 89, 23);
		contentPane.add(btnVolver);
	}

}
