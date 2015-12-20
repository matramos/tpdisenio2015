package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.CompetenciaDTO;
import DTO.EncuentroDTO;
import DTO.InfoCompetenciaDTO;
import DTO.ParticipanteDTO;
import DTO.SetDTO;
import gestores.GestorCompetencias;
import gestores.GestorFixture;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cu018 extends JFrame {

	private JPanel contentPane;
	private JLabel lblSePresento;
	private JTextField txtS1P2;
	private JTextField txtS1P1;
	private JTextField txtS2P1;
	private JTextField txtS2P2;
	private JTextField txtS3P2;
	private JTextField txtS4P2;
	private JTextField txtS5P2;
	private JTextField txtS3P1;
	private JTextField txtS4P1;
	private JTextField txtS5P1;
	private JTextField txtS6P1;
	private JTextField txtS7P1;
	private JTextField txtS8P1;
	private JTextField txtS9P1;
	private JTextField txtS6P2;
	private JTextField txtS7P2;
	private JTextField txtS8P2;
	private JTextField txtS9P2;
	private JTextField txtRP1;
	private JTextField txtRP2;
	
	
	int[] puntajeP1 = new int [9];  
	int[] puntajeP2 = new int [9];
	long[] idSets = new long [9];
	int i=0;
	int setGanadosP1=0;
	int setGanadosP2=0;
	String ganador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu018 frame = new Cu018(1,1,1,1);
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
	public Cu018(long id_competencia,long id_ronda,long id_encuentro, final long id_usuario) {
		
		//llamar al fixture
		final EncuentroDTO encuentro=GestorFixture.GestionarResultado(id_competencia,id_ronda,id_encuentro);
		final EncuentroDTO encuentroAnterior = GestorFixture.GestionarResultado(id_competencia,id_ronda,id_encuentro);
		final InfoCompetenciaDTO informacion = GestorCompetencias.getInfoCompetencia(id_competencia);
		final int cantidad=encuentro.getSets().size();
		final long id_comp = id_competencia;
		final long id_ron = id_ronda;
		final long id_encu = id_encuentro;
		int prueba = cantidad;
		
		
		
		for(int j=0;j<9;j++){
			puntajeP1[j]=-1;
			puntajeP2[j]=-1;
		}
		for(SetDTO set : encuentro.getSets()){
			idSets[i]=(set.getId_set());
			puntajeP1[i]=(set.getPuntajep1());
			puntajeP2[i]=(set.getPuntajep2());
			i++;
		}
		while(prueba!=0){
			if(puntajeP1[prueba-1]>puntajeP2[prueba-1])
				setGanadosP1++;
			else
				setGanadosP2++;
				prueba--;
		}
		if(setGanadosP1>setGanadosP2)
			ganador=encuentro.getJugador1().getNombre();
		else
			ganador=encuentro.getJugador2().getNombre();
		
		
				
		// mostrar datos del encuentro en la pantalla
				
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionDeResultado = new JLabel("GESTION DE RESULTADO");
		lblGestionDeResultado.setBounds(196, 11, 336, 14);
		lblGestionDeResultado.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblGestionDeResultado);
		
		JLabel lblParticipante = new JLabel("Participante 1:");
		lblParticipante.setBounds(87, 52, 97, 14);
		contentPane.add(lblParticipante);
		
		JLabel lblParticipante_1 = new JLabel("Participante 2:");
		lblParticipante_1.setBounds(347, 52, 123, 14);
		contentPane.add(lblParticipante_1);
		
		lblSePresento = new JLabel("Se Presento?");
		lblSePresento.setBounds(279, 99, 77, 14);
		contentPane.add(lblSePresento);
		
		final JComboBox comboResultadoFinal = new JComboBox();
		comboResultadoFinal.setBounds(281, 457, 112, 20);
		contentPane.add(comboResultadoFinal);
		comboResultadoFinal.addItem(encuentro.getJugador1().getNombre());
		comboResultadoFinal.addItem(encuentro.getJugador2().getNombre());
		
		final JCheckBox checkPart2 = new JCheckBox("",encuentro.isEstadop2());
		checkPart2.setBounds(362, 95, 97, 23);
		
		final JCheckBox checkPart1 = new JCheckBox("",encuentro.isEstadop1());
		checkPart1.setBounds(239, 95, 21, 23);
		checkPart1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.DESELECTED || !checkPart2.isSelected()){
					comboResultadoFinal.setEnabled(false);
					txtS1P1.setEditable(false);
					txtS1P2.setEditable(false);
					txtS2P1.setEditable(false);
					txtS2P2.setEditable(false);
					txtS3P1.setEditable(false);
					txtS3P2.setEditable(false);
					txtS4P1.setEditable(false);
					txtS4P2.setEditable(false);
					txtS5P1.setEditable(false);
					txtS5P2.setEditable(false);
					txtS6P1.setEditable(false);
					txtS6P2.setEditable(false);
					txtS7P1.setEditable(false);
					txtS7P2.setEditable(false);
					txtS8P1.setEditable(false);
					txtS8P2.setEditable(false);
					txtS9P1.setEditable(false);
					txtS9P2.setEditable(false);
					txtRP1.setEditable(false);
					txtRP2.setEditable(false);
				}
				else{
					if(informacion.getPuntuacion().isPuntuacion()){
						txtRP1.setEditable(true);
						txtRP2.setEditable(true);
					}
					else if(informacion.getPuntuacion().isResultadoFinal()){
						comboResultadoFinal.setEnabled(true);
					}
					else if(informacion.getPuntuacion().isSets()){
						if(!(puntajeP1[0]==-1 && puntajeP2[0]==-1)){
							txtS1P1.setEditable(true);
							txtS1P2.setEditable(true);
						}
						
						if(!(puntajeP1[1]==-1 && puntajeP2[1]==-1)){
							txtS2P1.setEditable(true);
							txtS2P2.setEditable(true);
						}
						
						if(!(puntajeP1[2]==-1 && puntajeP2[2]==-1)){
							txtS3P1.setEditable(true);
							txtS3P2.setEditable(true);
						}
						
						if(!(puntajeP1[3]==-1 && puntajeP2[3]==-1)){
							txtS4P1.setEditable(true);
							txtS4P2.setEditable(true);
						}
						
						if(!(puntajeP1[4]==-1 && puntajeP2[4]==-1)){
							txtS5P1.setEditable(true);
							txtS5P2.setEditable(true);
						}
						
						if(!(puntajeP1[5]==-1 && puntajeP2[5]==-1)){
							txtS6P1.setEditable(true);
							txtS6P2.setEditable(true);
						}
						
						if(!(puntajeP1[6]==-1 && puntajeP2[6]==-1)){
							txtS7P1.setEditable(true);
							txtS7P2.setEditable(true);
						}
						
						if(!(puntajeP1[7]==-1 && puntajeP2[7]==-1)){
							txtS8P1.setEditable(true);
							txtS8P2.setEditable(true);
						}
						
						if(!(puntajeP1[8]==-1 && puntajeP2[8]==-1)){
							txtS9P1.setEditable(true);
							txtS9P2.setEditable(true);
						}
					}
				}
			}
		});
		contentPane.add(checkPart1);
		
		
		checkPart2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.DESELECTED || !checkPart1.isSelected()){
					comboResultadoFinal.setEnabled(false);
					txtS1P1.setEditable(false);
					txtS1P2.setEditable(false);
					txtS2P1.setEditable(false);
					txtS2P2.setEditable(false);
					txtS3P1.setEditable(false);
					txtS3P2.setEditable(false);
					txtS4P1.setEditable(false);
					txtS4P2.setEditable(false);
					txtS5P1.setEditable(false);
					txtS5P2.setEditable(false);
					txtS6P1.setEditable(false);
					txtS6P2.setEditable(false);
					txtS7P1.setEditable(false);
					txtS7P2.setEditable(false);
					txtS8P1.setEditable(false);
					txtS8P2.setEditable(false);
					txtS9P1.setEditable(false);
					txtS9P2.setEditable(false);
					txtRP1.setEditable(false);
					txtRP2.setEditable(false);
				}
				else{
					if(informacion.getPuntuacion().isPuntuacion()){
						txtRP2.setEditable(true);
						txtRP1.setEditable(true);
					}
					else if(informacion.getPuntuacion().isResultadoFinal()){
						comboResultadoFinal.setEnabled(true);
					}
					else if(informacion.getPuntuacion().isSets()){
						if(!(puntajeP1[0]==-1 && puntajeP2[0]==-1)){
							txtS1P2.setEditable(true);
							txtS1P1.setEditable(true);
						}
						
						if(!(puntajeP1[1]==-1 && puntajeP2[1]==-1)){
							txtS2P2.setEditable(true);
							txtS2P1.setEditable(true);
						}
						
						if(!(puntajeP1[2]==-1 && puntajeP2[2]==-1)){
							txtS3P2.setEditable(true);
							txtS3P1.setEditable(true);
						}
						
						if(!(puntajeP1[3]==-1 && puntajeP2[3]==-1)){
							txtS4P2.setEditable(true);
							txtS4P1.setEditable(true);
						}
						
						if(!(puntajeP1[4]==-1 && puntajeP2[4]==-1)){
							txtS5P2.setEditable(true);
							txtS5P1.setEditable(true);
						}
						
						if(!(puntajeP1[5]==-1 && puntajeP2[5]==-1)){
							txtS6P2.setEditable(true);
							txtS6P1.setEditable(true);
						}
						
						if(!(puntajeP1[6]==-1 && puntajeP2[6]==-1)){
							txtS7P2.setEditable(true);
							txtS7P1.setEditable(true);
						}
						
						if(!(puntajeP1[7]==-1 && puntajeP2[7]==-1)){
							txtS8P2.setEditable(true);
							txtS8P1.setEditable(true);
						}
						
						if(!(puntajeP1[8]==-1 && puntajeP2[8]==-1)){
							txtS9P2.setEditable(true);
							txtS9P1.setEditable(true);
						}
					}
				}
			}
		});
		contentPane.add(checkPart2);
		
		JLabel lblSet = new JLabel("Set 1");
		lblSet.setBounds(289, 143, 46, 14);
		contentPane.add(lblSet);
		
		JLabel lblSet_1 = new JLabel("Set 2");
		lblSet_1.setBounds(289, 168, 46, 14);
		contentPane.add(lblSet_1);
		
		JLabel lblSet_2 = new JLabel("Set 3");
		lblSet_2.setBounds(279, 196, 46, 14);
		contentPane.add(lblSet_2);
		
		JLabel lblSet_3 = new JLabel("Set 4");
		lblSet_3.setBounds(289, 221, 46, 14);
		contentPane.add(lblSet_3);
		
		JLabel lblSet_4 = new JLabel("Set 5");
		lblSet_4.setBounds(289, 246, 46, 14);
		contentPane.add(lblSet_4);
		
		JLabel lblSet_5 = new JLabel("Set 6");
		lblSet_5.setBounds(279, 271, 46, 14);
		contentPane.add(lblSet_5);
		
		JLabel lblSet_6 = new JLabel("Set 7");
		lblSet_6.setBounds(289, 302, 46, 14);
		contentPane.add(lblSet_6);
		
		JLabel lblSet_7 = new JLabel("Set 8");
		lblSet_7.setBounds(279, 333, 46, 14);
		contentPane.add(lblSet_7);
		
		JLabel lblSet_8 = new JLabel("Set 9");
		lblSet_8.setBounds(289, 358, 46, 14);
		contentPane.add(lblSet_8);
		
		txtS1P2 = new JTextField();
		if(puntajeP2[0] != -1){
			txtS1P2.setText(Integer.toString(puntajeP2[0]));
		}
		txtS1P2.setBounds(347, 140, 46, 20);
		contentPane.add(txtS1P2);
		txtS1P2.setColumns(10);
		
		txtS1P1 = new JTextField();
		if(puntajeP1[0] != -1)
			txtS1P1.setText(Integer.toString(puntajeP1[0]));
		txtS1P1.setColumns(10);
		txtS1P1.setBounds(226, 140, 46, 20);
		contentPane.add(txtS1P1);
		
		txtS2P1 = new JTextField();
		if (puntajeP1[1]!=-1)
			txtS2P1.setText(Integer.toString(puntajeP1[1]));
		txtS2P1.setColumns(10);
		txtS2P1.setBounds(226, 165, 46, 20);
		contentPane.add(txtS2P1);
		
		txtS2P2 = new JTextField();
		if(puntajeP2[1]!=-1)
			txtS2P2.setText(Integer.toString(puntajeP2[1]));
		txtS2P2.setColumns(10);
		txtS2P2.setBounds(347, 165, 46, 20);
		contentPane.add(txtS2P2);
		
		txtS3P2 = new JTextField();
		if(puntajeP2[2]!=-1)
			txtS3P2.setText(Integer.toString(puntajeP2[2]));
		txtS3P2.setColumns(10);
		txtS3P2.setBounds(347, 193, 46, 20);
		contentPane.add(txtS3P2);
		
		txtS4P2 = new JTextField();
		if(puntajeP2[3]!=-1)
			txtS4P2.setText(Integer.toString(puntajeP2[3]));
		txtS4P2.setColumns(10);
		txtS4P2.setBounds(347, 215, 46, 20);
		contentPane.add(txtS4P2);
		
		txtS5P2 = new JTextField();
		if(puntajeP2[4]!=-1)
			txtS5P2.setText(Integer.toString(puntajeP2[4]));
		txtS5P2.setColumns(10);
		txtS5P2.setBounds(347, 243, 46, 20);
		contentPane.add(txtS5P2);
		
		txtS3P1 = new JTextField();
		if(puntajeP1[2]!=-1)
			txtS3P1.setText(Integer.toString(puntajeP1[2]));
		txtS3P1.setColumns(10);
		txtS3P1.setBounds(226, 186, 46, 20);
		contentPane.add(txtS3P1);
		
		txtS4P1 = new JTextField();
		if(puntajeP1[3]!=-1)
			txtS4P1.setText(Integer.toString(puntajeP1[3]));
		txtS4P1.setColumns(10);
		txtS4P1.setBounds(226, 206, 46, 20);
		contentPane.add(txtS4P1);
		
		txtS5P1 = new JTextField();
		if(puntajeP1[4]!=-1)
			txtS5P1.setText(Integer.toString(puntajeP1[4]));
		txtS5P1.setColumns(10);
		txtS5P1.setBounds(226, 237, 46, 20);
		contentPane.add(txtS5P1);
		
		txtS6P1 = new JTextField();
		if(puntajeP1[5]!=-1)
			txtS6P1.setText(Integer.toString(puntajeP1[5]));
		txtS6P1.setColumns(10);
		txtS6P1.setBounds(226, 268, 46, 20);
		contentPane.add(txtS6P1);
		
		txtS7P1 = new JTextField();
		if(puntajeP1[6]!=-1)
			txtS7P1.setText(Integer.toString(puntajeP1[6]));
		txtS7P1.setColumns(10);
		txtS7P1.setBounds(226, 299, 46, 20);
		contentPane.add(txtS7P1);
		
		txtS8P1 = new JTextField();
		if(puntajeP1[7]!=-1)
			txtS8P1.setText(Integer.toString(puntajeP1[7]));
		txtS8P1.setColumns(10);
		txtS8P1.setBounds(226, 330, 46, 20);
		contentPane.add(txtS8P1);
		
		txtS9P1 = new JTextField();
		if(puntajeP1[8]!=-1)
			txtS9P1.setText(Integer.toString(puntajeP1[8]));
		txtS9P1.setColumns(10);
		txtS9P1.setBounds(226, 355, 46, 20);
		contentPane.add(txtS9P1);
		
		txtS6P2 = new JTextField();
		if(puntajeP2[5]!=-1)
			txtS6P2.setText(Integer.toString(puntajeP2[5]));
		txtS6P2.setColumns(10);
		txtS6P2.setBounds(347, 268, 46, 20);
		contentPane.add(txtS6P2);
		
		txtS7P2 = new JTextField();
		if(puntajeP2[6]!=-1)
			txtS7P2.setText(Integer.toString(puntajeP2[6]));
		txtS7P2.setColumns(10);
		txtS7P2.setBounds(347, 299, 46, 20);
		contentPane.add(txtS7P2);
		
		txtS8P2 = new JTextField();
		if(puntajeP2[7]!=-1)
			txtS8P2.setText(Integer.toString(puntajeP2[7]));
		txtS8P2.setColumns(10);
		txtS8P2.setBounds(347, 330, 46, 20);
		contentPane.add(txtS8P2);
		
		txtS9P2 = new JTextField();
		if(puntajeP2[8]!=-1)
			txtS9P2.setText(Integer.toString(puntajeP2[8]));
		txtS9P2.setColumns(10);
		txtS9P2.setBounds(347, 355, 46, 20);
		contentPane.add(txtS9P2);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(262, 411, 94, 14);
		contentPane.add(lblPuntuacion);
		
		txtRP1 = new JTextField();
		if(informacion.getPuntuacion().puntuacion)
			txtRP1.setText(Integer.toString(encuentro.getPuntajep1()));
		txtRP1.setBounds(206, 408, 46, 20);
		contentPane.add(txtRP1);
		txtRP1.setColumns(10);
		txtRP1.setEditable(checkPart1.isSelected());
		
		txtRP2 = new JTextField();
		if(informacion.getPuntuacion().puntuacion)
			txtRP2.setText(Integer.toString(encuentro.getPuntajep2()));
		txtRP2.setColumns(10);
		txtRP2.setBounds(361, 408, 46, 20);
		contentPane.add(txtRP2);
		txtRP2.setEditable(checkPart2.isSelected());
		
		
		JLabel lblResultadoFinal = new JLabel("Resultado Final:");
		lblResultadoFinal.setBounds(134, 460, 138, 14);
		contentPane.add(lblResultadoFinal);
		
		final JLabel lblSeleccioneAlMenos = new JLabel("Seleccione al menos un equipo");
		lblSeleccioneAlMenos.setForeground(Color.RED);
		lblSeleccioneAlMenos.setBounds(239, 121, 161, 14);
		lblSeleccioneAlMenos.setVisible(false);
		contentPane.add(lblSeleccioneAlMenos);
		
		final JLabel lblIngreseLaPuntuacion = new JLabel("Ingrese la puntuaci\u00F3n");
		lblIngreseLaPuntuacion.setForeground(Color.RED);
		lblIngreseLaPuntuacion.setBounds(347, 436, 187, 14);
		lblIngreseLaPuntuacion.setVisible(false);
		contentPane.add(lblIngreseLaPuntuacion);
		
		final JLabel lblSeleccioneUnGanador = new JLabel("Seleccione un ganador");
		lblSeleccioneUnGanador.setForeground(Color.RED);
		lblSeleccioneUnGanador.setBounds(240, 488, 116, 14);
		lblSeleccioneUnGanador.setVisible(false);
		contentPane.add(lblSeleccioneUnGanador);
		
		final JLabel lblNoSePermite = new JLabel("No se permite que haya resultados de empate en los sets");
		lblNoSePermite.setForeground(Color.RED);
		lblNoSePermite.setBounds(180, 383, 329, 14);
		lblNoSePermite.setVisible(false);
		contentPane.add(lblNoSePermite);
		
		final JLabel lblNoPermiteEmpates = new JLabel("La Competencia NO permite empates");
		lblNoPermiteEmpates.setForeground(Color.RED);
		lblNoPermiteEmpates.setBounds(160, 436, 187, 14);
		lblNoPermiteEmpates.setVisible(false);
		contentPane.add(lblNoPermiteEmpates);
		
		
		if(informacion.getPuntuacion().isSets()){
			if(!checkPart1.isSelected() || !checkPart2.isSelected()){
				txtS1P1.setEditable(false);
				txtS1P2.setEditable(false);
				txtS2P1.setEditable(false);
				txtS2P2.setEditable(false);
				txtS3P1.setEditable(false);
				txtS3P2.setEditable(false);
				txtS4P1.setEditable(false);
				txtS4P2.setEditable(false);
				txtS5P1.setEditable(false);
				txtS5P2.setEditable(false);
				txtS6P1.setEditable(false);
				txtS6P2.setEditable(false);
				txtS7P1.setEditable(false);
				txtS7P2.setEditable(false);
				txtS8P1.setEditable(false);
				txtS8P2.setEditable(false);
				txtS9P1.setEditable(false);
				txtS9P2.setEditable(false);
				txtRP1.setEditable(false);
				txtRP2.setEditable(false);
				comboResultadoFinal.setEnabled(false);
			}
			else{
			comboResultadoFinal.setEnabled(false);
			txtRP1.setEditable(false);
			txtRP2.setEditable(false);
			if(puntajeP1[0]==-1 && puntajeP2[0]==-1){
				txtS1P1.setEditable(false);
				txtS1P2.setEditable(false);
			}
			
			if(puntajeP1[1]==-1 && puntajeP2[1]==-1){
				txtS2P1.setEditable(false);
				txtS2P2.setEditable(false);
			}
			
			if(puntajeP1[2]==-1 && puntajeP2[2]==-1){
				txtS3P1.setEditable(false);
				txtS3P2.setEditable(false);
			}
			
			if(puntajeP1[3]==-1 && puntajeP2[3]==-1){
				txtS4P1.setEditable(false);
				txtS4P2.setEditable(false);
			}
			
			if(puntajeP1[4]==-1 && puntajeP2[4]==-1){
				txtS5P1.setEditable(false);
				txtS5P2.setEditable(false);
			}
			
			if(puntajeP1[5]==-1 && puntajeP2[5]==-1){
				txtS6P1.setEditable(false);
				txtS6P2.setEditable(false);
			}
			
			if(puntajeP1[6]==-1 && puntajeP2[6]==-1){
				txtS7P1.setEditable(false);
				txtS7P2.setEditable(false);
			}
			
			if(puntajeP1[7]==-1 && puntajeP2[7]==-1){
				txtS8P1.setEditable(false);
				txtS8P2.setEditable(false);
			}
			
			if(puntajeP1[8]==-1 && puntajeP2[8]==-1){
				txtS9P1.setEditable(false);
				txtS9P2.setEditable(false);
			}}
		}
		else if (informacion.getPuntuacion().isResultadoFinal()){
			txtS1P1.setEditable(false);
			txtS1P2.setEditable(false);
			txtS2P1.setEditable(false);
			txtS2P2.setEditable(false);
			txtS3P1.setEditable(false);
			txtS3P2.setEditable(false);
			txtS4P1.setEditable(false);
			txtS4P2.setEditable(false);
			txtS5P1.setEditable(false);
			txtS5P2.setEditable(false);
			txtS6P1.setEditable(false);
			txtS6P2.setEditable(false);
			txtS7P1.setEditable(false);
			txtS7P2.setEditable(false);
			txtS8P1.setEditable(false);
			txtS8P2.setEditable(false);
			txtS9P1.setEditable(false);
			txtS9P2.setEditable(false);
			txtRP1.setEditable(false);
			txtRP2.setEditable(false);
			comboResultadoFinal.setEnabled(false);
		}
		else if (informacion.getPuntuacion().isPuntuacion()){
			txtS1P1.setEditable(false);
			txtS1P2.setEditable(false);
			txtS2P1.setEditable(false);
			txtS2P2.setEditable(false);
			txtS3P1.setEditable(false);
			txtS3P2.setEditable(false);
			txtS4P1.setEditable(false);
			txtS4P2.setEditable(false);
			txtS5P1.setEditable(false);
			txtS5P2.setEditable(false);
			txtS6P1.setEditable(false);
			txtS6P2.setEditable(false);
			txtS7P1.setEditable(false);
			txtS7P2.setEditable(false);
			txtS8P1.setEditable(false);
			txtS8P2.setEditable(false);
			txtS9P1.setEditable(false);
			txtS9P2.setEditable(false);
			comboResultadoFinal.setEnabled(false);
		}
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(347, 537, 89, 23);
		contentPane.add(btnCancelar);
		
	
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			/*VALIDACIONES:
			 * Si es por set, que no se permita empate en el puntaje de los sets
			 * Si es por puntuacion, verificar si se permite o no empate y en base a eso tirar o no un error
			 * Si es por resultado final, nada de eso.
			 * otras.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				
				boolean datosValidos=false;
	
				if(informacion.getPuntuacion().isSets()){
				if(!txtS1P1.getText().equals(""))
				puntajeP1[0]=Integer.parseInt(txtS1P1.getText());
				if(!txtS1P2.getText().equals(""))
				puntajeP2[0]=Integer.parseInt(txtS1P2.getText());
				if(!txtS2P1.getText().equals(""))
				puntajeP1[1]=Integer.parseInt(txtS2P1.getText());
				if(!txtS2P2.getText().equals(""))
				puntajeP2[1]=Integer.parseInt(txtS2P2.getText());
				if(!txtS3P1.getText().equals(""))
				puntajeP1[2]=Integer.parseInt(txtS3P1.getText());
				if(!txtS3P2.getText().equals(""))
				puntajeP2[2]=Integer.parseInt(txtS3P2.getText());
				if(!txtS4P1.getText().equals(""))
				puntajeP1[3]=Integer.parseInt(txtS4P1.getText());
				if(!txtS4P2.getText().equals(""))
				puntajeP2[3]=Integer.parseInt(txtS4P2.getText());
				if(!txtS5P1.getText().equals(""))
				puntajeP1[4]=Integer.parseInt(txtS5P1.getText());
				if(!txtS5P2.getText().equals(""))
				puntajeP2[4]=Integer.parseInt(txtS5P2.getText());
				if(!txtS6P1.getText().equals(""))
				puntajeP1[5]=Integer.parseInt(txtS6P1.getText());
				if(!txtS6P2.getText().equals(""))
				puntajeP2[5]=Integer.parseInt(txtS6P2.getText());
				if(!txtS7P1.getText().equals(""))
				puntajeP1[6]=Integer.parseInt(txtS7P1.getText());
				if(!txtS7P2.getText().equals(""))
				puntajeP2[6]=Integer.parseInt(txtS7P2.getText());
				if(!txtS8P1.getText().equals(""))
				puntajeP1[7]=Integer.parseInt(txtS8P1.getText());
				if(!txtS8P2.getText().equals(""))
				puntajeP2[7]=Integer.parseInt(txtS8P2.getText());
				if(!txtS9P1.getText().equals(""))
				puntajeP1[8]=Integer.parseInt(txtS9P1.getText());
				if(!txtS9P2.getText().equals(""))
				puntajeP2[8]=Integer.parseInt(txtS9P2.getText());
				}

				if(!(datosValidos)){
					if(!(checkPart1.isSelected()) && !(checkPart2.isSelected())){
						lblSeleccioneAlMenos.setVisible(true);
						
						lblNoSePermite.setVisible(false);
						lblIngreseLaPuntuacion.setVisible(false);
						lblNoPermiteEmpates.setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos");
					}
					else if(informacion.getPuntuacion().isSets() &&(checkPart1.isSelected()) && (checkPart2.isSelected())){
						boolean b = false;
						int cantidad = informacion.getCantidad_sets();
						int contador = 0;
						for(int i=0 ; i < informacion.getCantidad_sets() ; i++){
							
							if(puntajeP1[i]==puntajeP2[i]){
								
								lblNoSePermite.setVisible(true);
								b = true;
								lblSeleccioneAlMenos.setVisible(false);
								lblIngreseLaPuntuacion.setVisible(false);
								lblNoPermiteEmpates.setVisible(false);
								
							}
				
								
						}
						if(b){
							JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos");
						}
						else
							datosValidos = true;
					}
					else if((txtRP1.getText().length()==0 || txtRP2.getText().length()==0 || (txtRP1.getText().length()==0 && txtRP2.getText().length()==0))&& (checkPart1.isSelected()) && (checkPart2.isSelected()) && informacion.getPuntuacion().isPuntuacion()){
						lblIngreseLaPuntuacion.setVisible(true);
						
						lblNoSePermite.setVisible(false);
						lblSeleccioneAlMenos.setVisible(false);
						lblNoPermiteEmpates.setVisible(false);
						
						JOptionPane.showMessageDialog(null, "Ha introducido datos incorrectos");
					}
					else if( !(informacion.getPuntuacion().isResultadoFinal()) && !(informacion.getPuntuacion().isSets()) && !informacion.isPermite_empates() && ( txtRP1.getText().equals(txtRP2.getText()) && (checkPart1.isSelected()) && (checkPart2.isSelected()))){
						lblSeleccioneAlMenos.setVisible(false);
						lblNoSePermite.setVisible(false);
						lblIngreseLaPuntuacion.setVisible(false);
						
						lblNoPermiteEmpates.setVisible(true);
						JOptionPane.showMessageDialog(null, "La competencia NO permite empates.");
						}
					else{
						datosValidos=true;}
				}
				
				System.out.println(datosValidos);
				if(datosValidos){
				
					System.out.println("ENCUENTRO ANTERIOR");
					System.out.println(encuentroAnterior.getPuntajep1());
					System.out.println(encuentroAnterior.getPuntajep2());
					
					System.out.println("PARTICIPANTE 1");
					System.out.println(encuentroAnterior.getJugador1().getTantosFav());
					System.out.println(encuentroAnterior.getJugador1().getTantosCont());
					System.out.println(encuentroAnterior.getJugador1().getTantosDif());
					System.out.println("PARTICIPANTE 2");
					System.out.println(encuentroAnterior.getJugador2().getTantosFav());
					System.out.println(encuentroAnterior.getJugador2().getTantosCont());
					System.out.println(encuentroAnterior.getJugador2().getTantosDif());
					
					
					ParticipanteDTO x = encuentro.getJugador1();
					ParticipanteDTO y = encuentro.getJugador2();
					
					System.out.println("DATOS DE X e Y");
					System.out.println("PARTICIPANTE X");
					System.out.println(encuentro.getJugador1().getTantosFav());
					System.out.println(encuentro.getJugador1().getTantosCont());
					System.out.println(encuentro.getJugador1().getTantosDif());
					System.out.println("PARTICIPANTE Y");
					System.out.println(encuentro.getJugador2().getTantosFav());
					System.out.println(encuentro.getJugador2().getTantosCont());
					System.out.println(encuentro.getJugador2().getTantosDif());
					
					if(!(encuentroAnterior.getGanador() == null)){
						
						
						
						//BORRAMOS CARGAS ANTERIORES
						if(encuentroAnterior.getGanador().getId_participante() == x.getId_participante()){
							//EL GANADOR ANTERIOR FUE X
							System.out.println("GANO EL PRIMERO");
							x.setPartidosGanados(x.getPartidosGanados()-1);
							y.setPartidosPerdidos(y.getPartidosPerdidos()-1);
							
							if(!informacion.getPuntuacion().isSets()){
								System.out.println("NO ES POR SET");
								x.setTantosFav(x.getTantosFav()-encuentroAnterior.getPuntajep1());
								x.setTantosCont(x.getTantosCont()-encuentroAnterior.getPuntajep2());
								
								y.setTantosFav(y.getTantosFav()-encuentroAnterior.getPuntajep2());
								y.setTantosCont(y.getTantosCont()-encuentroAnterior.getPuntajep1());
							}
							else{
								for(int s=0; s<informacion.getCantidad_sets();s++){
									x.setTantosFav(x.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep1()));
									y.setTantosFav(y.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep2()));
									x.setTantosCont(x.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep2());
									y.setTantosCont(y.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep1());	
								}
								
							}
							
							x.setTantosDif(x.getTantosFav()-x.getTantosCont());
							y.setTantosDif(y.getTantosFav()-y.getTantosCont());
							
							x.setPuntaje(x.getPuntaje()-informacion.getPuntos_ganador()-informacion.getPuntos_presentarse());
							if(encuentroAnterior.isEstadop2()){
								y.setPuntaje(y.getPuntaje()-informacion.getPuntos_presentarse());}
							//y.setPuntaje(y.getPuntaje()-informacion.getPuntos_presentarse());
						}
						else if(encuentroAnterior.getGanador().getId_participante() == y.getId_participante()){
							//EL GANADOR ANTERIOR FUE Y
							System.out.println("GANO EL SEGUNDO");
							x.setPartidosPerdidos(x.getPartidosPerdidos()-1);
							y.setPartidosGanados(y.getPartidosGanados()-1);
							
							if(!informacion.getPuntuacion().isSets()){
								System.out.println("NO ES POR SET");
								x.setTantosFav(x.getTantosFav()-encuentroAnterior.getPuntajep1());
								x.setTantosCont(x.getTantosCont()-encuentroAnterior.getPuntajep2());
								y.setTantosFav(y.getTantosFav()-encuentroAnterior.getPuntajep2());
								y.setTantosCont(y.getTantosCont()-encuentroAnterior.getPuntajep1());
							}
							else{
								for(int s=0; s<informacion.getCantidad_sets();s++){
									x.setTantosFav(x.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep1()));
									y.setTantosFav(y.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep2()));
									x.setTantosCont(x.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep2());
									y.setTantosCont(y.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep1());	
								}
								
							}
							x.setTantosDif(x.getTantosFav()-x.getTantosCont());
							y.setTantosDif(y.getTantosFav()-y.getTantosCont());
							
							if(encuentroAnterior.isEstadop1()){
								x.setPuntaje(x.getPuntaje()-informacion.getPuntos_presentarse());}
							y.setPuntaje(y.getPuntaje()-informacion.getPuntos_ganador()-informacion.getPuntos_presentarse());
							//x.setPuntaje(x.getPuntaje()-informacion.getPuntos_presentarse());
						}
						
					}
					else {
						if (encuentroAnterior.isEmpate()){
							//EMPATARON EL PARTIDO ANTERIOR
							System.out.println("EMPATARON");
							x.setPartidosEmpatados(x.getPartidosEmpatados()-1);
							y.setPartidosEmpatados(y.getPartidosEmpatados()-1);
							encuentro.setEmpate(false);
							
							if(!informacion.getPuntuacion().isSets()){
								System.out.println("NO ES POR SET");
								x.setTantosFav(x.getTantosFav()-encuentroAnterior.getPuntajep1());
								x.setTantosCont(x.getTantosCont()-encuentroAnterior.getPuntajep2());
								y.setTantosFav(y.getTantosFav()-encuentroAnterior.getPuntajep2());
								y.setTantosCont(y.getTantosCont()-encuentroAnterior.getPuntajep1());
							}
							else{
								for(int s=0; s<informacion.getCantidad_sets();s++){
									x.setTantosFav(x.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep1()));
									y.setTantosFav(y.getTantosFav()-(encuentroAnterior.getSets().get(s).getPuntajep2()));
									x.setTantosCont(x.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep2());
									y.setTantosCont(y.getTantosCont()-encuentroAnterior.getSets().get(s).getPuntajep1());	
								}
								
							}
							x.setTantosDif(x.getTantosFav()-x.getTantosCont());
							y.setTantosDif(y.getTantosFav()-y.getTantosCont());
							
							x.setPuntaje(x.getPuntaje()-informacion.getPuntos_empate()-informacion.getPuntos_presentarse());
							y.setPuntaje(y.getPuntaje()-informacion.getPuntos_empate()-informacion.getPuntos_presentarse());
						}
					}
					
					
					
					System.out.println("DATOS DE X e Y DESPUES DE LA MODIFICACION");
					System.out.println("PARTICIPANTE X");
					System.out.println(encuentro.getJugador1().getTantosFav());
					System.out.println(encuentro.getJugador1().getTantosCont());
					System.out.println(encuentro.getJugador1().getTantosDif());
					System.out.println("PARTICIPANTE Y");
					System.out.println(encuentro.getJugador2().getTantosFav());
					System.out.println(encuentro.getJugador2().getTantosCont());
					System.out.println(encuentro.getJugador2().getTantosDif());
					
					
					//settear el encuentro si no se presento ninguno (no me acuerdo este caso) , EXPLOTA EL SISTEMA
					/*if(!(checkPart1.isSelected()) && !(checkPart2.isSelected()))
						;*/
						
					//setear el encuentro si no se presento el primero
					if(!(checkPart1.isSelected()) && (checkPart2.isSelected())){
						System.out.println("NO SE PRESENTO EL PRIMER PARTICIPANTE");
						encuentro.setEstadop1(false);
						encuentro.setEstadop2(true);

						x.setPartidosPerdidos((x.getPartidosPerdidos()+1));
						if(!informacion.getPuntuacion().isSets())
							x.setTantosCont(x.getTantosCont()+informacion.getResultado_final());
						else
							x.setTantosCont(x.getTantosCont()+(informacion.getResultado_final()*informacion.getCantidad_sets()));
						x.setTantosDif(x.getTantosFav() - x.getTantosCont());
						
						y.setPartidosGanados(y.getPartidosGanados()+1);
						if(!informacion.getPuntuacion().isSets())
							y.setTantosFav(y.getTantosFav()+informacion.getResultado_final());
						else
							y.setTantosFav(y.getTantosFav()+(informacion.getResultado_final()*informacion.getCantidad_sets()));
						y.setTantosDif(y.getTantosFav() - y.getTantosCont());
						y.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_ganador());
						
						if(!informacion.getPuntuacion().isSets()){
						encuentro.setPuntajep1(0);
						encuentro.setPuntajep2(informacion.getResultado_final());
						}
						else{
							encuentro.setPuntajep1(0);
							encuentro.setPuntajep2(informacion.getCantidad_sets());
						}
						
						encuentro.setJugador1(x);
						encuentro.setJugador2(y);
						if(informacion.getPuntuacion().isSets()){
							for(int i = 0 ; i<informacion.getCantidad_sets(); i++){
								encuentro.getSets().get(i).setPuntajep1(0);
								encuentro.getSets().get(i).setPuntajep2(informacion.getResultado_final());
							}
						}
						//System.out.println(informacion.getPuntuacion().isSets());
						//System.out.println(encuentro.getSets().get(0).getPuntajep2());
						//System.out.println(encuentro.getSets().get(1).getPuntajep2());
						encuentro.setGanador(y);
						encuentro.setEmpate(false);
					}
					
					//settear el encuentro si no se presento el segundo
					else if((checkPart1.isSelected()) && !(checkPart2.isSelected())){
						System.out.println("NO SE PRESENTO EL SEGUNDO PARTICIPANTE");
						
						
						encuentro.setEstadop1(true);
						encuentro.setEstadop2(false);
						y.setPartidosPerdidos((y.getPartidosPerdidos()+1));
						if(!informacion.getPuntuacion().isSets())
							y.setTantosCont(y.getTantosCont()+informacion.getResultado_final());
						else{
							System.out.println(informacion.getResultado_final());
							System.out.println(informacion.getCantidad_sets());
							y.setTantosCont(y.getTantosCont()+(informacion.getResultado_final()*informacion.getCantidad_sets()));
							System.out.println("caca");
							System.out.println(y.getTantosCont());
						}
						y.setTantosDif(y.getTantosFav() - y.getTantosCont());
						
						x.setPartidosGanados(x.getPartidosGanados()+1);
						if(!informacion.getPuntuacion().isSets())
							x.setTantosFav(x.getTantosFav()+informacion.getResultado_final());
						else
							x.setTantosFav(x.getTantosFav()+(informacion.getResultado_final()*informacion.getCantidad_sets()));
						x.setTantosDif(x.getTantosFav() - x.getTantosCont());
						x.setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_ganador());
						
						if(!informacion.getPuntuacion().isSets()){
						encuentro.setPuntajep1(informacion.getResultado_final());
						encuentro.setPuntajep2(0);
						}
						else{
							encuentro.setPuntajep1(informacion.getCantidad_sets());
							encuentro.setPuntajep2(0);
						}
						
						encuentro.setJugador1(x);
						encuentro.setJugador2(y);
						if(informacion.getPuntuacion().isSets()){
							for(int i = 0 ; i<informacion.getCantidad_sets(); i++){
								encuentro.getSets().get(i).setPuntajep2(0);
								encuentro.getSets().get(i).setPuntajep1(informacion.getResultado_final());
							}
						}
						encuentro.setGanador(x);
						encuentro.setEmpate(false);
					}
										
					// setear el encuentro teniendo en cuenta el combobox de resultado final
					else if(informacion.getPuntuacion().isResultadoFinal()){
							System.out.println("SETEO EN BASE A RESULTADO FINAL DEL COMBO BOX");
							String seleccionado =  (String) comboResultadoFinal.getSelectedItem();

							if(seleccionado.equals( encuentro.getJugador1().getNombre()) ){
								 x.setPartidosGanados(x.getPartidosGanados()+1);
								 x.setPuntaje(x.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								 y.setPartidosPerdidos(y.getPartidosPerdidos()+1);
								 y.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse());
								 encuentro.setGanador(x);
								 encuentro.setEmpate(false);
							 }
							 else if (seleccionado.equals(encuentro.getJugador2().getNombre()) ){
								 y.setPartidosGanados(y.getPartidosGanados()+1);
								 y.setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								 x.setPartidosPerdidos(x.getPartidosPerdidos()+1);
								 x.setPuntaje(x.getPuntaje() + informacion.getPuntos_presentarse());
								 encuentro.setGanador(y);
								 encuentro.setEmpate(false);
							 }
							encuentro.setJugador1(x);
							encuentro.setJugador2(y);
					}
						
					//setear el encuentro teniendo en cuenta el textfield de puntuacion
					else if(informacion.getPuntuacion().isPuntuacion()){
							int puntajeP1=Integer.parseInt(txtRP1.getText());
							int puntajeP2=Integer.parseInt(txtRP2.getText());
							
							System.out.println("SETEO POR PUNTUACION");
							encuentro.setPuntajep1(puntajeP1);
							encuentro.setPuntajep2(puntajeP2);
							//encuentro.getSets().get(0).setPuntajep1(puntajeP1);
							//encuentro.getSets().get(0).setPuntajep2(puntajeP2);

							if(puntajeP1 > puntajeP2){
								System.out.println("GANA P1");
								x.setTantosFav(x.getTantosFav()+puntajeP1);
								x.setTantosCont(x.getTantosCont()+puntajeP2);
								x.setTantosDif(x.getTantosFav() - x.getTantosCont());
								x.setPartidosGanados(x.getPartidosGanados()+1);
								x.setPuntaje(x.getPuntaje() + informacion.getPuntos_ganador() + informacion.getPuntos_presentarse());
								
								y.setTantosFav(y.getTantosFav()+puntajeP2);
								y.setTantosCont(y.getTantosCont()+puntajeP1);
								y.setTantosDif(y.getTantosFav() - y.getTantosCont());
								y.setPartidosPerdidos(y.getPartidosPerdidos()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse());
								encuentro.setGanador(x);
								encuentro.setEmpate(false);
							}
							else if (puntajeP2 > puntajeP1){
								System.out.println("GANA P2");
								y.setTantosFav(y.getTantosFav()+puntajeP2);
								y.setTantosCont(y.getTantosCont()+puntajeP1);
								y.setTantosDif(y.getTantosFav() - y.getTantosCont());
								y.setPartidosGanados(y.getPartidosGanados()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+ informacion.getPuntos_presentarse());
									
								x.setTantosFav(x.getTantosFav()+puntajeP1);
								x.setTantosCont(x.getTantosCont()+puntajeP2);
								x.setTantosDif(x.getTantosFav() - x.getTantosCont());
								x.setPartidosPerdidos(x.getPartidosPerdidos()+1);
								x.setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse());
								encuentro.setGanador(y);
								encuentro.setEmpate(false);
							}
							else{
								System.out.println("EMPATARON");
								y.setTantosFav(y.getTantosFav()+puntajeP2);
								y.setTantosCont(y.getTantosCont()+puntajeP1);
								y.setTantosDif(y.getTantosFav() - y.getTantosCont());
								y.setPartidosEmpatados(y.getPartidosEmpatados()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_empate()+informacion.getPuntos_presentarse());
								
								x.setTantosFav(x.getTantosFav()+puntajeP1);
								x.setTantosCont(x.getTantosCont()+puntajeP2);
								x.setTantosDif(x.getTantosFav() - x.getTantosCont());
								x.setPartidosEmpatados(x.getPartidosEmpatados()+1);
								x.setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_empate());
								encuentro.setEmpate(true);
								encuentro.setGanador(null);
								
							}
							
							encuentro.setPuntajep1(puntajeP1);
							encuentro.setPuntajep2(puntajeP2);
							
							encuentro.setJugador1(x);
							encuentro.setJugador2(y);
						
						}
						//setear el encuentro teniendo en cuenta los textfields de set
						else if(informacion.getPuntuacion().isSets()){
							System.out.println("SETEO POR SET");
							
							System.out.println("SETEO POR SET");
							
							int setGanadosP1=0;
							int setGanadosP2=0;
							int tantosFavorP1=0;
							int tantosFavorP2=0;
							boolean hayEmpate=false;
							
							for(int i=0 ; i<encuentro.getSets().size() ; i++){
								if(puntajeP1[i]==puntajeP2[i] )
									hayEmpate=true;}
							
							for(int a = 0; a < encuentro.getSets().size(); a++){
								encuentro.getSets().get(a).setPuntajep1(puntajeP1[a]);
								encuentro.getSets().get(a).setPuntajep2(puntajeP2[a]);
								
							}

							for(int i=0 ; i < informacion.getCantidad_sets() ; i++){
								tantosFavorP1 = tantosFavorP1 + puntajeP1[i];
								tantosFavorP2 = tantosFavorP2 + puntajeP2[i];
								if(puntajeP1[i] > puntajeP2[i]){
									setGanadosP1++;
								}
								else
									setGanadosP2++;
							}
							/*if(hayEmpate){
								y.setTantosFav(y.getTantosFav()+tantosFavorP2);
								y.setTantosCont(y.getTantosCont()+tantosFavorP1);
								y.setTantosDif(y.getTantosFav()-y.getTantosCont());
								y.setPartidosEmpatados(y.getPartidosEmpatados()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_empate()+informacion.getPuntos_presentarse());
								
								x.setTantosFav(x.getTantosFav()+tantosFavorP1);
								x.setTantosCont(x.getTantosCont()+tantosFavorP2);
								x.setTantosDif(x.getTantosFav()-x.getTantosCont());
								x.setPartidosEmpatados(x.getPartidosEmpatados()+1);
								x.setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_empate());
							
								encuentro.setPuntajep1(0);
								encuentro.setPuntajep2(0);
								encuentro.setEmpate(true);
								
								
							}*/
							
							if(setGanadosP1 > setGanadosP2){
								x.setTantosFav(x.getTantosFav()+tantosFavorP1);
								x.setTantosCont(x.getTantosCont()+tantosFavorP2);
								x.setTantosDif(x.getTantosFav() - x.getTantosCont());
								x.setPartidosGanados(x.getPartidosGanados()+1);
								x.setPuntaje(x.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								
									
								y.setTantosFav(y.getTantosFav()+tantosFavorP2);
								y.setTantosCont(y.getTantosCont()+tantosFavorP1);
								y.setTantosDif(y.getTantosFav() - y.getTantosCont());
								y.setPartidosPerdidos(y.getPartidosPerdidos()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse());
								
								
								encuentro.setPuntajep1(setGanadosP1);
								encuentro.setPuntajep2(setGanadosP2);
								encuentro.setGanador(x);
								
								
							}
							else if(setGanadosP2 > setGanadosP1){
								y.setTantosFav(y.getTantosFav()+tantosFavorP2);
								y.setTantosCont(y.getTantosCont()+tantosFavorP1);
								y.setTantosDif(y.getTantosFav() - y.getTantosCont());
								y.setPartidosGanados(y.getPartidosGanados()+1);
								y.setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								
								
								x.setTantosFav(x.getTantosFav()+tantosFavorP1);
								x.setTantosCont(x.getTantosCont()+tantosFavorP2);
								x.setTantosDif(x.getTantosFav() - x.getTantosCont());
								x.setPartidosPerdidos(x.getPartidosPerdidos()+1);
								x.setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse());
								
								encuentro.setPuntajep1(setGanadosP1);
								encuentro.setPuntajep2(setGanadosP2);
								encuentro.setGanador(y);
							}
							
						}
					
					encuentro.setJugador1(x);
					encuentro.setJugador2(y);
					
					System.out.println("DATOS DE X e Y ACTUALIZADOS EN EL ENCUENTRO");
					System.out.println(encuentro.getPuntajep1());
					System.out.println(encuentro.getPuntajep2());
					System.out.println("PARTICIPANTE X");
					System.out.println(encuentro.getJugador1().getTantosFav());
					System.out.println(encuentro.getJugador1().getTantosCont());
					System.out.println(encuentro.getJugador1().getTantosDif());
					System.out.println("PARTICIPANTE Y");
					System.out.println(encuentro.getJugador2().getTantosFav());
					System.out.println(encuentro.getJugador2().getTantosCont());
					System.out.println(encuentro.getJugador2().getTantosDif());
					
					//voy a gestionar fixture para cargar el resultado de los datos actualizados
					encuentro.setEstadop1(checkPart1.isSelected());
					encuentro.setEstadop2(checkPart2.isSelected());
						
					GestorFixture.cargarResultado(id_comp,id_ron,id_encu,encuentro);		
					JOptionPane.showMessageDialog(null, "Se cargo con exito");
					//Cu019 ventana = new Cu019(id_comp, id_usuario, false);
					//ventana.setVisible(true);
					dispose();
					
				}	
						
			}
		});
		btnAceptar.setBounds(224, 537, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel nombreP1 = new JLabel(encuentro.getJugador1().getNombre());
		nombreP1.setBounds(180, 52, 123, 14);
		contentPane.add(nombreP1);
		
		JLabel nombreP2 = new JLabel(encuentro.getJugador2().getNombre());
		nombreP2.setBounds(462, 52, 198, 14);
		contentPane.add(nombreP2);
	}
}
