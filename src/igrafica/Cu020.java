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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DTO.CompetenciaDTO;
import DTO.ParticipanteDTO;
import gestores.GestorCompetencias;

public class Cu020 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CompetenciaDTO compe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu020 frame = new Cu020((long) 1);
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
	public Cu020(final long id_competencia) {
		//BUSCAMOS LA COMPETENCIA
		compe = GestorCompetencias.getCompetencia(id_competencia);
		System.out.println(compe.getEstado().getNombre());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setTitle("Gevico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBsquedaDeCompetencias = new JLabel("Competencia: ");
		lblBsquedaDeCompetencias.setFont(new Font("Arial",Font.BOLD,18));
		lblBsquedaDeCompetencias.setBounds(290, 37, 151, 44);
		contentPane.add(lblBsquedaDeCompetencias);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte:");
		lblDeporteAsociado.setBounds(87, 168, 70, 14);
		contentPane.add(lblDeporteAsociado);
		
		JLabel nombreDeporte = new JLabel(compe.getDeporte().getNombre());
		nombreDeporte.setBounds(160, 172, 160, 15);
		contentPane.add(nombreDeporte);
		
		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setBounds(77, 137, 109, 14);
		contentPane.add(lblModalidad);
		
		JLabel nombreModalidad = new JLabel(compe.getModalidad().getNombre());
		nombreModalidad.setBounds(160, 136, 160, 15);
		contentPane.add(nombreModalidad);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(87, 208, 54, 14);
		contentPane.add(lblEstado);
		
		JLabel nombreEstado = new JLabel(compe.getEstado().getNombre());
		nombreEstado.setBounds(160, 208, 160, 15);
		contentPane.add(nombreEstado);
		
		JButton btnCancelar = new JButton("Ver fixture");
		btnCancelar.setBounds(403, 164, 170, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCrearCompetencia = new JButton("Eliminar competencia");
		btnCrearCompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu004 ventana = new Cu004();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCrearCompetencia.setBounds(575, 128, 175, 23);
		contentPane.add(btnCrearCompetencia);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(77, 348, 239, 143);
		contentPane.add(scrollPane2);
		
		
		
		//Recuperamos en un Array solamente los nombres de los participantes
		Vector<String> nombres = new Vector<String>();
		for(ParticipanteDTO parti: compe.getParticipantes()){
			nombres.add(parti.getNombre());
		}
		
		
		DefaultTableModel tableModel = new DefaultTableModel(new String [] {"Participante"},0);
				
		JTable table2 = new JTable(tableModel);
		
		//Recorremos los nombres para agregarlo a la tabla
		for(String nombre: nombres){
			Object[] obj = {nombre};
			tableModel.addRow(obj);
		}

		scrollPane2.setViewportView(table2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 348, 314, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"Participante 1","Participante 2","Lugar"   
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar_1.setBounds(381, 522, 89, 23);
		contentPane.add(btnCancelar_1);
		
		JLabel lblDinamico = new JLabel(compe.getNombre());
		lblDinamico.setBounds(420, 54, 330, 14);
		contentPane.add(lblDinamico);
		
		JButton btnModificarCompetencia = new JButton("Modificar competencia");
		btnModificarCompetencia.setBounds(403, 128, 170, 23);
		contentPane.add(btnModificarCompetencia);
		
		JButton btnGenerarFixture = new JButton("Generar fixture");
		btnGenerarFixture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				if((compe.getEstado().getNombre().equals("creada")) || 
						(compe.getEstado().getNombre().equals("planificada"))){
					Cu017 ventanaGenFixture = new Cu017(id_competencia);
					ventanaGenFixture.setVisible(true);
					dispose();
				}
				else{
					Cu017Error ventanaErrFixture = new Cu017Error(id_competencia);
					ventanaErrFixture.setVisible(true);
					dispose();
				}
			}
		});
		btnGenerarFixture.setBounds(575, 164, 175, 23);
		contentPane.add(btnGenerarFixture);
		
		JButton btnVerTablaDe = new JButton("Ver tabla de posiciones");
		btnVerTablaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cu021 ventanaPosiciones = new Cu021(id_competencia);
				ventanaPosiciones.setVisible(true);
				dispose();
			}
		});
		btnVerTablaDe.setBounds(403, 200, 170, 23);
		contentPane.add(btnVerTablaDe);
		
		JButton btnVerParticipantes = new JButton("Ver participantes");
		btnVerParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
				Cu008 ventanaParticipantes = new Cu008(id_competencia);
				ventanaParticipantes.setVisible(true);
				dispose();
			}
		});
		btnVerParticipantes.setBounds(575, 200, 175, 23);
		contentPane.add(btnVerParticipantes);
		
		JLabel lblEncuentrosMsPrximos = new JLabel("Encuentros m\u00E1s pr\u00F3ximos");
		lblEncuentrosMsPrximos.setBounds(420, 323, 314, 14);
		contentPane.add(lblEncuentrosMsPrximos);
		
		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setBounds(78, 323, 94, 14);
		contentPane.add(lblParticipantes);
		
	}
}
