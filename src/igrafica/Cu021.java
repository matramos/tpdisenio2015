package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
import DTO.ListaParticipantesDTO;
import DTO.ParticipanteDTO;
import gestores.GestorCompetencias;

public class Cu021 extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private CompetenciaDTO compe;
	private JTable table_2;
	private Clip clip;
    private String ruta="/audio/";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu021 frame = new Cu021((long) 1,1, false);
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
	public void sonido(String archivo){
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
			clip.start();
			
			
		}catch(Exception e){
			
		}
	}
	
	public Cu021(final long id_competencia, final long id_usuario, final boolean desdeEl4) {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setTitle("Gevico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExportar = new JButton("Exportar tabla");
		
		JButton btnImprimir = new JButton("Imprimir tabla");
		
		JLabel lblDarDeAlta = new JLabel("Tabla de posiciones");
		lblDarDeAlta.setBounds(307, 43, 400, 14);
		lblDarDeAlta.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblDarDeAlta);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cu020 ventana = new Cu020(id_competencia,id_usuario, desdeEl4);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(85, 475, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnExportarTabla = new JButton("Exportar tabla");
		btnExportarTabla.setBounds(464, 475, 124, 23);
		contentPane.add(btnExportarTabla);
		
		JButton btnImprimirTabla = new JButton("Imprimir tabla");
		btnImprimirTabla.setBounds(603, 475, 126, 23);
		contentPane.add(btnImprimirTabla);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 116, 644, 310);
		contentPane.add(scrollPane);
		
		modeloTabla = new DefaultTableModel();
		table_2 = new JTable();
		table_2.setModel(modeloTabla);
		scrollPane.setViewportView(table_2);
		
		CompetenciaDTO competencia = GestorCompetencias.getCompetencia(id_competencia);
		if(competencia.getModalidad().liga && (competencia.getEstado().getId_estado()==3 || competencia.getEstado().getId_estado()==4)){
			this.setVisible(true);
			
			modificarTabla(GestorCompetencias.mostrarTabla(competencia));
		}
		else if(!competencia.getModalidad().liga){
			sonido("error");
			JOptionPane.showMessageDialog(null, "La modalidad de la competencia no es Liga");
			Cu020 ventana = new Cu020(id_competencia,id_usuario, desdeEl4);
			ventana.setVisible(true);
			dispose();
		}
		else{
			sonido("error");
			JOptionPane.showMessageDialog(null, "La competencia a�n no se disput�");
			Cu020 ventana = new Cu020(id_competencia,id_usuario, desdeEl4);
			ventana.setVisible(true);
			dispose();
		}
				
	}
	private void modificarTabla(ListaParticipantesDTO participantes){
		if(participantes.getParticipantes().get(0).getTantosFav()==-1){
			modeloTabla.setColumnIdentifiers(new String[] {"Nombre","Puntos","Ganados","Empatados", "Perididos"});
		}
		else{
			modeloTabla.setColumnIdentifiers(new String[] {"Nombre","Puntos","Ganados","Empatados", "Perididos","Tantos favor","Tantos contra","Diferencia"});
		}
		for(ParticipanteDTO part : participantes.getParticipantes()){
			modeloTabla.addRow(part.crearFila());
		}
		
	}
}
