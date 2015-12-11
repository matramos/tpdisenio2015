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
import DTO.ListaEncuentrosDTO;
import DTO.ListaRondasDTO;
import DTO.ModalidadDTO;
import DTO.ParticipanteDTO;
import DTO.RegistroEncuentroDTO;
import DTO.RondaDTO;
import DTO.SetDTO;
import capanegocios.Competencia;
import capanegocios.Encuentro;
import capanegocios.Participante;
import capanegocios.RegistroEncuentro;
import capanegocios.Ronda;
import capanegocios.Set;
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
					Cu018 frame = new Cu018(1,1,1);
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
	public Cu018(long id_competencia,long id_ronda,long id_encuentro) {
		
		//llamar al fixture
		final EncuentroDTO encuentro=GestorFixture.GestionarResultado(id_competencia,id_ronda,id_encuentro);
		final InfoCompetenciaDTO informacion = GestorCompetencias.getInfoCompetencia(id_competencia);
		final int cantidad=encuentro.getSets().size();
		final long id_comp = id_competencia;
		final long id_ron = id_ronda;
		final long id_encu = id_encuentro;
		final boolean secargo;
		int prueba = cantidad;
		
		
		
		for(int j=0;j<9;j++){
			puntajeP1[j]=0;
			puntajeP2[j]=0;
		}
				for(SetDTO set : encuentro.getSets()){
					idSets[i]=(set.getId_set());
					puntajeP1[i]=(set.getPuntajep1());
					puntajeP2[i]=(set.getPuntajep2());
					i++;
				}
				while(prueba!=0){
					if(puntajeP1[prueba]>puntajeP2[prueba])
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
		
		final JCheckBox checkPart1 = new JCheckBox("",encuentro.isEstadop1());
		checkPart1.setBounds(239, 95, 21, 23);
		checkPart1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.DESELECTED){
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
						if(!(puntajeP1[0]==-1 && puntajeP2[0]==0)){
							txtS1P1.setEditable(true);
							txtS1P2.setEditable(true);
						}
						
						if(!(puntajeP1[1]==0 && puntajeP2[1]==0)){
							txtS2P1.setEditable(true);
							txtS2P2.setEditable(true);
						}
						
						if(!(puntajeP1[2]==0 && puntajeP2[2]==0)){
							txtS3P1.setEditable(true);
							txtS3P2.setEditable(true);
						}
						
						if(!(puntajeP1[3]==0 && puntajeP2[3]==0)){
							txtS4P1.setEditable(true);
							txtS4P2.setEditable(true);
						}
						
						if(!(puntajeP1[4]==0 && puntajeP2[4]==0)){
							txtS5P1.setEditable(true);
							txtS5P2.setEditable(true);
						}
						
						if(!(puntajeP1[5]==0 && puntajeP2[5]==0)){
							txtS6P1.setEditable(true);
							txtS6P2.setEditable(true);
						}
						
						if(!(puntajeP1[6]==0 && puntajeP2[6]==0)){
							txtS7P1.setEditable(true);
							txtS7P2.setEditable(true);
						}
						
						if(!(puntajeP1[7]==0 && puntajeP2[7]==0)){
							txtS8P1.setEditable(false);
							txtS8P2.setEditable(false);
						}
						
						if(!(puntajeP1[8]==0 && puntajeP2[8]==0)){
							txtS9P1.setEditable(true);
							txtS9P2.setEditable(true);
						}
					}
				}
			}
		});
		contentPane.add(checkPart1);
		
		final JCheckBox checkPart2 = new JCheckBox("",encuentro.isEstadop2());
		checkPart2.setBounds(362, 95, 97, 23);
		checkPart2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.DESELECTED){
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
						if(!(puntajeP1[0]==-1 && puntajeP2[0]==0)){
							txtS1P1.setEditable(true);
							txtS1P2.setEditable(true);
						}
						
						if(!(puntajeP1[1]==0 && puntajeP2[1]==0)){
							txtS2P1.setEditable(true);
							txtS2P2.setEditable(true);
						}
						
						if(!(puntajeP1[2]==0 && puntajeP2[2]==0)){
							txtS3P1.setEditable(true);
							txtS3P2.setEditable(true);
						}
						
						if(!(puntajeP1[3]==0 && puntajeP2[3]==0)){
							txtS4P1.setEditable(true);
							txtS4P2.setEditable(true);
						}
						
						if(!(puntajeP1[4]==0 && puntajeP2[4]==0)){
							txtS5P1.setEditable(true);
							txtS5P2.setEditable(true);
						}
						
						if(!(puntajeP1[5]==0 && puntajeP2[5]==0)){
							txtS6P1.setEditable(true);
							txtS6P2.setEditable(true);
						}
						
						if(!(puntajeP1[6]==0 && puntajeP2[6]==0)){
							txtS7P1.setEditable(true);
							txtS7P2.setEditable(true);
						}
						
						if(!(puntajeP1[7]==0 && puntajeP2[7]==0)){
							txtS8P1.setEditable(false);
							txtS8P2.setEditable(false);
						}
						
						if(!(puntajeP1[8]==0 && puntajeP2[8]==0)){
							txtS9P1.setEditable(true);
							txtS9P2.setEditable(true);
						}
					}
				}
			}
		});
		contentPane.add(checkPart2);
		
		JLabel lblSet = new JLabel("Set 1");
		lblSet.setBounds(289, 124, 46, 14);
		contentPane.add(lblSet);
		
		JLabel lblSet_1 = new JLabel("Set 2");
		lblSet_1.setBounds(287, 149, 46, 14);
		contentPane.add(lblSet_1);
		
		JLabel lblSet_2 = new JLabel("Set 3");
		lblSet_2.setBounds(289, 177, 46, 14);
		contentPane.add(lblSet_2);
		
		JLabel lblSet_3 = new JLabel("Set 4");
		lblSet_3.setBounds(289, 197, 46, 14);
		contentPane.add(lblSet_3);
		
		JLabel lblSet_4 = new JLabel("Set 5");
		lblSet_4.setBounds(289, 228, 46, 14);
		contentPane.add(lblSet_4);
		
		JLabel lblSet_5 = new JLabel("Set 6");
		lblSet_5.setBounds(289, 253, 46, 14);
		contentPane.add(lblSet_5);
		
		JLabel lblSet_6 = new JLabel("Set 7");
		lblSet_6.setBounds(289, 284, 46, 14);
		contentPane.add(lblSet_6);
		
		JLabel lblSet_7 = new JLabel("Set 8");
		lblSet_7.setBounds(289, 309, 46, 14);
		contentPane.add(lblSet_7);
		
		JLabel lblSet_8 = new JLabel("Set 9");
		lblSet_8.setBounds(289, 338, 46, 14);
		contentPane.add(lblSet_8);
		
		txtS1P2 = new JTextField(Integer.toString(puntajeP2[0]));
		txtS1P2.setBounds(347, 121, 46, 20);
		contentPane.add(txtS1P2);
		txtS1P2.setColumns(10);
		
		txtS1P1 = new JTextField(Integer.toString(puntajeP1[0]));
		txtS1P1.setColumns(10);
		txtS1P1.setBounds(226, 122, 46, 20);
		contentPane.add(txtS1P1);
		
		txtS2P1 = new JTextField(Integer.toString(puntajeP1[1]));
		txtS2P1.setColumns(10);
		txtS2P1.setBounds(226, 148, 46, 20);
		contentPane.add(txtS2P1);
		
		txtS2P2 = new JTextField(Integer.toString(puntajeP2[1]));
		txtS2P2.setColumns(10);
		txtS2P2.setBounds(347, 148, 46, 20);
		contentPane.add(txtS2P2);
		
		txtS3P2 = new JTextField(Integer.toString(puntajeP2[2]));
		txtS3P2.setColumns(10);
		txtS3P2.setBounds(346, 174, 46, 20);
		contentPane.add(txtS3P2);
		
		txtS4P2 = new JTextField(Integer.toString(puntajeP2[3]));
		txtS4P2.setColumns(10);
		txtS4P2.setBounds(347, 194, 46, 20);
		contentPane.add(txtS4P2);
		
		txtS5P2 = new JTextField(Integer.toString(puntajeP2[4]));
		txtS5P2.setColumns(10);
		txtS5P2.setBounds(347, 225, 46, 20);
		contentPane.add(txtS5P2);
		
		txtS3P1 = new JTextField(Integer.toString(puntajeP1[2]));
		txtS3P1.setColumns(10);
		txtS3P1.setBounds(226, 172, 46, 20);
		contentPane.add(txtS3P1);
		
		txtS4P1 = new JTextField(Integer.toString(puntajeP1[3]));
		txtS4P1.setColumns(10);
		txtS4P1.setBounds(226, 194, 46, 20);
		contentPane.add(txtS4P1);
		
		txtS5P1 = new JTextField(Integer.toString(puntajeP1[4]));
		txtS5P1.setColumns(10);
		txtS5P1.setBounds(226, 225, 46, 20);
		contentPane.add(txtS5P1);
		
		txtS6P1 = new JTextField(Integer.toString(puntajeP1[5]));
		txtS6P1.setColumns(10);
		txtS6P1.setBounds(226, 253, 46, 20);
		contentPane.add(txtS6P1);
		
		txtS7P1 = new JTextField(Integer.toString(puntajeP1[6]));
		txtS7P1.setColumns(10);
		txtS7P1.setBounds(226, 281, 46, 20);
		contentPane.add(txtS7P1);
		
		txtS8P1 = new JTextField(Integer.toString(puntajeP1[7]));
		txtS8P1.setColumns(10);
		txtS8P1.setBounds(226, 304, 46, 20);
		contentPane.add(txtS8P1);
		
		txtS9P1 = new JTextField(Integer.toString(puntajeP1[8]));
		txtS9P1.setColumns(10);
		txtS9P1.setBounds(226, 335, 46, 20);
		contentPane.add(txtS9P1);
		
		txtS6P2 = new JTextField(Integer.toString(puntajeP2[5]));
		txtS6P2.setColumns(10);
		txtS6P2.setBounds(347, 253, 46, 20);
		contentPane.add(txtS6P2);
		
		txtS7P2 = new JTextField(Integer.toString(puntajeP2[6]));
		txtS7P2.setColumns(10);
		txtS7P2.setBounds(347, 281, 46, 20);
		contentPane.add(txtS7P2);
		
		txtS8P2 = new JTextField(Integer.toString(puntajeP2[7]));
		txtS8P2.setColumns(10);
		txtS8P2.setBounds(347, 306, 46, 20);
		contentPane.add(txtS8P2);
		
		txtS9P2 = new JTextField(Integer.toString(puntajeP2[8]));
		txtS9P2.setColumns(10);
		txtS9P2.setBounds(347, 335, 46, 20);
		contentPane.add(txtS9P2);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(262, 411, 94, 14);
		contentPane.add(lblPuntuacion);
		
		txtRP1 = new JTextField(Integer.toString(encuentro.getPuntajep1()));
		txtRP1.setBounds(206, 408, 46, 20);
		contentPane.add(txtRP1);
		txtRP1.setColumns(10);
		
		txtRP2 = new JTextField(Integer.toString(encuentro.getPuntajep2()));
		txtRP2.setColumns(10);
		txtRP2.setBounds(361, 408, 46, 20);
		contentPane.add(txtRP2);
		
		JLabel lblResultadoFinal = new JLabel("Resultado Final:");
		lblResultadoFinal.setBounds(134, 460, 138, 14);
		contentPane.add(lblResultadoFinal);
		
		
		if(informacion.getPuntuacion().isSets()){
			comboResultadoFinal.setEnabled(false);
			txtRP1.setEditable(false);
			txtRP2.setEditable(false);
			if(puntajeP1[0]==0 && puntajeP2[0]==0){
				txtS1P1.setEditable(false);
				txtS1P2.setEditable(false);
			}
			
			if(puntajeP1[1]==0 && puntajeP2[1]==0){
				txtS2P1.setEditable(false);
				txtS2P2.setEditable(false);
			}
			
			if(puntajeP1[2]==0 && puntajeP2[2]==0){
				txtS3P1.setEditable(false);
				txtS3P2.setEditable(false);
			}
			
			if(puntajeP1[3]==0 && puntajeP2[3]==0){
				txtS4P1.setEditable(false);
				txtS4P2.setEditable(false);
			}
			
			if(puntajeP1[4]==0 && puntajeP2[4]==0){
				txtS5P1.setEditable(false);
				txtS5P2.setEditable(false);
			}
			
			if(puntajeP1[5]==0 && puntajeP2[5]==0){
				txtS6P1.setEditable(false);
				txtS6P2.setEditable(false);
			}
			
			if(puntajeP1[6]==0 && puntajeP2[6]==0){
				txtS7P1.setEditable(false);
				txtS7P2.setEditable(false);
			}
			
			if(puntajeP1[7]==0 && puntajeP2[7]==0){
				txtS8P1.setEditable(false);
				txtS8P2.setEditable(false);
			}
			
			if(puntajeP1[8]==0 && puntajeP2[8]==0){
				txtS9P1.setEditable(false);
				txtS9P2.setEditable(false);
			}
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
		}
		else if (informacion.getPuntuacion().puntuacion){
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
		btnCancelar.setBounds(195, 537, 89, 23);
		contentPane.add(btnCancelar);
		
		puntajeP1[0]=Integer.parseInt(txtS1P1.getText());
		puntajeP2[0]=Integer.parseInt(txtS1P2.getText());
		puntajeP1[1]=Integer.parseInt(txtS2P1.getText());
		puntajeP2[1]=Integer.parseInt(txtS2P2.getText());
		puntajeP1[2]=Integer.parseInt(txtS3P1.getText());
		puntajeP2[2]=Integer.parseInt(txtS3P2.getText());
		puntajeP1[3]=Integer.parseInt(txtS4P1.getText());
		puntajeP2[3]=Integer.parseInt(txtS4P2.getText());
		puntajeP1[4]=Integer.parseInt(txtS5P1.getText());
		puntajeP2[4]=Integer.parseInt(txtS5P2.getText());
		puntajeP1[5]=Integer.parseInt(txtS6P1.getText());
		puntajeP2[5]=Integer.parseInt(txtS6P2.getText());
		puntajeP1[6]=Integer.parseInt(txtS7P1.getText());
		puntajeP2[6]=Integer.parseInt(txtS7P2.getText());
		puntajeP1[7]=Integer.parseInt(txtS8P1.getText());
		puntajeP2[7]=Integer.parseInt(txtS8P2.getText());
		puntajeP1[8]=Integer.parseInt(txtS9P1.getText());
		puntajeP2[8]=Integer.parseInt(txtS9P2.getText());
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			/*VALIDACIONES:
			 * Si es por set, que no se permita empate en el puntaje de los sets
			 * Si es por puntuacion, verificar si se permite o no empate y en base a eso tirar o no un error
			 * Si es por resultado final, nada de eso.
			 * otras.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				
					
						//settear el encuentro si no se presento ninguno (no me acuerdo este caso) , EXPLOTA EL SISTEMA
						if(!(checkPart1.isSelected()) && !(checkPart2.isSelected()))
							;
						//setear el encuentro si no se presento el primero
						else if(!(checkPart1.isSelected()) && (checkPart2.isSelected())){
							encuentro.setEstadop1(false);
							encuentro.setEstadop2(true);
							ParticipanteDTO x = encuentro.getJugador1();
							ParticipanteDTO y = encuentro.getJugador2();
							x.setPartidosPerdidos((x.getPartidosPerdidos()+1));
							x.setTantosCont(x.getTantosCont()+informacion.getResultado_final());
							x.setTantosDif(x.getTantosDif()-informacion.getResultado_final());
							y.setPartidosGanados(y.getPartidosGanados()+1);
							y.setTantosFav(y.getTantosFav()+informacion.getResultado_final());
							y.setTantosDif(y.getTantosDif()+informacion.getResultado_final());
							y.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_ganador());
							encuentro.setJugador1(x);
							encuentro.setJugador2(y);
						}
						
						//settear el encuentro si no se presento el segundo
						else if((checkPart1.isSelected()) && !(checkPart2.isSelected())){
							encuentro.setEstadop1(true);
							encuentro.setEstadop2(false);
							ParticipanteDTO x = encuentro.getJugador1();
							ParticipanteDTO y = encuentro.getJugador2();
							y.setPartidosPerdidos((x.getPartidosPerdidos()+1));
							y.setTantosCont(x.getTantosCont()+informacion.getResultado_final());
							y.setTantosDif(x.getTantosDif()-informacion.getResultado_final());
							x.setPartidosGanados(y.getPartidosGanados()+1);
							x.setTantosFav(y.getTantosFav()+informacion.getResultado_final());
							x.setTantosDif(y.getTantosDif()+informacion.getResultado_final());
							x.setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_ganador());
							encuentro.setJugador1(x);
							encuentro.setJugador2(y);
						}
						
						else{
						// setear el encuentro teniendo en cuenta el combobox de resultado final
						if(informacion.getPuntuacion().isResultadoFinal()){
							String seleccionado =  (String) comboResultadoFinal.getSelectedItem();
							ParticipanteDTO x = encuentro.getJugador1();
							ParticipanteDTO y = encuentro.getJugador2();
							if(seleccionado==encuentro.getJugador1().getNombre()){
								 x.setPartidosGanados(x.getPartidosGanados()+1);
								 x.setPuntaje(x.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								 y.setPartidosPerdidos(y.getPartidosPerdidos()+1);
								 encuentro.setGanador(encuentro.getJugador1()); 
							 }
							 else{
								 y.setPartidosGanados(y.getPartidosGanados()+1);
								 y.setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
								 x.setPartidosPerdidos(x.getPartidosPerdidos()+1);
								 encuentro.setGanador(encuentro.getJugador2());
							 }
						}
						
						//setear el encuentro teniendo en cuenta el textfield de puntuacion
						else if(informacion.getPuntuacion().isPuntuacion()){
							int puntajeP1=Integer.parseInt(txtRP1.getText());
							int puntajeP2=Integer.parseInt(txtRP2.getText());
							ParticipanteDTO x = encuentro.getJugador1();
							ParticipanteDTO y = encuentro.getJugador2();
							
							encuentro.setPuntajep1(puntajeP1);
							encuentro.setPuntajep2(puntajeP2);
							encuentro.getSets().get(0).setPuntajep1(puntajeP1);
							encuentro.getSets().get(0).setPuntajep2(puntajeP2);
							if(informacion.isPermite_empates() && puntajeP1==puntajeP2){
								JOptionPane.showMessageDialog(null, "La competencia no permite empates en los resultados");
								Cu018 ventana = new Cu018(id_comp,id_ron,id_encu);
								ventana.setVisible(true);
								dispose();
							}
							else{
								if(puntajeP1 > puntajeP2){
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+puntajeP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+puntajeP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+puntajeP1-puntajeP2);
									encuentro.getJugador1().setPartidosGanados(x.getPartidosGanados()+1);
									encuentro.getJugador1().setPuntaje(encuentro.getJugador1().getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+puntajeP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+puntajeP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+puntajeP2-puntajeP1);
									encuentro.getJugador2().setPartidosPerdidos(y.getPartidosPerdidos()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse());
									encuentro.setGanador(encuentro.getJugador1());
								}
								else if (puntajeP2 > puntajeP1){
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+puntajeP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+puntajeP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+puntajeP2-puntajeP1);
									encuentro.getJugador2().setPartidosGanados(y.getPartidosGanados()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
									
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+puntajeP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+puntajeP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+puntajeP1-puntajeP2);
									encuentro.getJugador1().setPartidosPerdidos(x.getPartidosPerdidos()+1);
									encuentro.getJugador1().setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse());
									encuentro.setGanador(encuentro.getJugador2());
								}
								else{
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+puntajeP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+puntajeP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+puntajeP2-puntajeP1);
									encuentro.getJugador2().setPartidosEmpatados(y.getPartidosEmpatados()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_empate()+informacion.getPuntos_presentarse());
									
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+puntajeP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+puntajeP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+puntajeP1-puntajeP2);
									encuentro.getJugador1().setPartidosEmpatados(x.getPartidosEmpatados()+1);
									encuentro.getJugador1().setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_empate());
								}
							}						
						}
						//setear el encuentro teniendo en cuenta los textfields de set
						else if(informacion.getPuntuacion().isSets()){
							ParticipanteDTO x = encuentro.getJugador1();
							ParticipanteDTO y = encuentro.getJugador2();
							int setGanadosP1=0;
							int setGanadosP2=0;
							int tantosFavorP1=0;
							int tantosFavorP2=0;
							int a=0;
							boolean hayEmpate=false;
							
							for(int i=0 ; i<9 ; i++)
								if(puntajeP1[i]==puntajeP2[i])
									hayEmpate=true;
							
							for(SetDTO s: encuentro.getSets()){
								s.setPuntajep1(puntajeP1[a]);
								s.setPuntajep2(puntajeP2[a]);
								a++;
								
							}
							if(hayEmpate){
								JOptionPane.showMessageDialog(null, "No se permiten empates en los Sets");
								Cu018 ventana = new Cu018(id_comp,id_ron,id_encu);
								ventana.setVisible(true);
								dispose();
							}
							else{
								for(int i=0 ; i < 9 ; i++){
									tantosFavorP1 = tantosFavorP1 + puntajeP1[i];
									tantosFavorP2 = tantosFavorP2 + puntajeP2[i];
									if(puntajeP1[i] > puntajeP2[i])
										setGanadosP1++;
									else
										setGanadosP2++;
								}
								if(setGanadosP1 > setGanadosP2){
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+tantosFavorP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+tantosFavorP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+tantosFavorP1-tantosFavorP2);
									encuentro.getJugador1().setPartidosGanados(x.getPartidosGanados()+1);
									encuentro.getJugador1().setPuntaje(x.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
									
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+tantosFavorP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+tantosFavorP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+tantosFavorP2-tantosFavorP1);
									encuentro.getJugador2().setPartidosPerdidos(y.getPartidosPerdidos()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_presentarse());
									encuentro.setGanador(encuentro.getJugador1());
								}
								else if(setGanadosP2 > setGanadosP1){
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+tantosFavorP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+tantosFavorP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+tantosFavorP2-tantosFavorP1);
									encuentro.getJugador2().setPartidosGanados(y.getPartidosGanados()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_ganador()+informacion.getPuntos_presentarse());
									
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+tantosFavorP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+tantosFavorP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+tantosFavorP1-tantosFavorP2);
									encuentro.getJugador1().setPartidosPerdidos(x.getPartidosPerdidos()+1);
									encuentro.getJugador1().setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse());
									encuentro.setGanador(encuentro.getJugador2());
								}
								else{
									encuentro.getJugador2().setTantosFav(y.getTantosFav()+tantosFavorP2);
									encuentro.getJugador2().setTantosCont(y.getTantosCont()+tantosFavorP1);
									encuentro.getJugador2().setTantosDif(y.getTantosDif()+tantosFavorP2-tantosFavorP1);
									encuentro.getJugador2().setPartidosEmpatados(y.getPartidosEmpatados()+1);
									encuentro.getJugador2().setPuntaje(y.getPuntaje()+informacion.getPuntos_empate()+informacion.getPuntos_presentarse());
									
									encuentro.getJugador1().setTantosFav(x.getTantosFav()+tantosFavorP1);
									encuentro.getJugador1().setTantosCont(x.getTantosCont()+tantosFavorP2);
									encuentro.getJugador1().setTantosDif(x.getTantosDif()+tantosFavorP1-tantosFavorP2);
									encuentro.getJugador1().setPartidosEmpatados(x.getPartidosEmpatados()+1);
									encuentro.getJugador1().setPuntaje(x.getPuntaje()+informacion.getPuntos_presentarse()+informacion.getPuntos_empate());
								}
							}
						}
					}
						//voy a gestionar fixture para cargar el resultado de los datos actualizados
						
						GestorFixture.cargarResultado(id_comp,id_ron,id_encu,encuentro);
						
						
						/*if(secargo==true){
							JOptionPane.showMessageDialog(null, "Se cargo con exito");
							//Cu008 ventana = new Cu008(idGenerado,id_usuario);
							//ventana.setVisible(true);
							//dispose();
						}*/
			
			}
			
					
					
				/*puntajeP1[0]=Integer.parseInt(txtS1P1.getText());
				puntajeP2[0]=Integer.parseInt(txtS1P2.getText());
				puntajeP1[1]=Integer.parseInt(txtS2P1.getText());
				puntajeP2[1]=Integer.parseInt(txtS2P2.getText());
				puntajeP1[2]=Integer.parseInt(txtS3P1.getText());
				puntajeP2[2]=Integer.parseInt(txtS3P2.getText());
				puntajeP1[3]=Integer.parseInt(txtS4P1.getText());
				puntajeP2[3]=Integer.parseInt(txtS4P2.getText());
				puntajeP1[4]=Integer.parseInt(txtS5P1.getText());
				puntajeP2[4]=Integer.parseInt(txtS5P2.getText());
				puntajeP1[5]=Integer.parseInt(txtS6P1.getText());
				puntajeP2[5]=Integer.parseInt(txtS6P2.getText());
				puntajeP1[6]=Integer.parseInt(txtS7P1.getText());
				puntajeP2[6]=Integer.parseInt(txtS7P2.getText());
				puntajeP1[7]=Integer.parseInt(txtS8P1.getText());
				puntajeP2[7]=Integer.parseInt(txtS8P2.getText());
				puntajeP1[8]=Integer.parseInt(txtS9P1.getText());
				puntajeP2[8]=Integer.parseInt(txtS9P2.getText());
				
				
				//guardo todos los datos de nuevo en el encuentro
				int cantidad=encuentro.getSets().size();
				boolean secargo=false;
				List<SetDTO> setActualizados= new ArrayList<>();
				i=0;
				while(cantidad!=0){
					SetDTO set = new SetDTO(idSets[i],puntajeP1[i],puntajeP2[i]);
					setActualizados.add(set);
					cantidad--;
					i++;
				}
				List<SetDTO> setsNuevos = new ArrayList<>();
				encuentro.setSets(setsNuevos);
				encuentro.setSets(setActualizados);
				encuentro.setEstadop1(checkPart1.isSelected());
				encuentro.setEstadop2(checkPart2.isSelected());
				encuentro.setPuntajep1(Integer.parseInt(txtRP1.getText()));
				encuentro.setPuntajep2(Integer.parseInt(txtRP2.getText()));
				
				//actualizar datos de encuentro en los participantes
				ParticipanteDTO participanteP1 = encuentro.getJugador1();
				ParticipanteDTO participanteP2 = encuentro.getJugador2();
				
				if(encuentro.isEmpate()==true){
					participanteP1.setPartidosEmpatados(participanteP1.getPartidosEmpatados()+1);
					participanteP2.setPartidosEmpatados(participanteP2.getPartidosEmpatados()+1);
				}
				
				for(SetDTO set : encuentro.getSets()){
					participanteP1.setTantosFav(participanteP1.getTantosFav()+set.getPuntajep1());
					participanteP2.setTantosFav(participanteP2.getTantosFav()+set.getPuntajep2());
					participanteP1.setTantosCont(participanteP1.getTantosCont()+set.getPuntajep2());
					participanteP2.setTantosCont(participanteP2.getTantosCont()+set.getPuntajep1());
					participanteP1.setTantosDif(participanteP1.getTantosDif()+(set.getPuntajep1()-set.getPuntajep2()));
					participanteP2.setTantosDif(participanteP2.getTantosDif()+(set.getPuntajep2()-set.getPuntajep1()));
				}
				
				encuentro.setJugador1(participanteP1);
				encuentro.setJugador2(participanteP2);
				encuentro.setEstadop1(checkPart1.isSelected());
				encuentro.setEstadop2(checkPart2.isSelected());
				
				 String seleccionado =  (String) comboResultadoFinal.getSelectedItem();
				 if(seleccionado==participanteP1.getNombre())
					encuentro.setGanador(participanteP1);
				 else
					 encuentro.setGanador(participanteP2);
					
				
				//voy a gestionar fixture para cargar el resultado de los datos actualizados
				secargo=GestorFixture.cargarResultado(id_comp,id_ron,id_encu,encuentro);
				
				if(secargo==true){
					JOptionPane.showMessageDialog(null, "Se cargo con exito");
					/*Cu008 ventana = new Cu008(idGenerado,id_usuario);
					ventana.setVisible(true);
					dispose();
				}*/
			
		});
		btnAceptar.setBounds(362, 537, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel nombreP1 = new JLabel(encuentro.getJugador1().getNombre());
		nombreP1.setBounds(180, 52, 123, 14);
		contentPane.add(nombreP1);
		
		JLabel nombreP2 = new JLabel(encuentro.getJugador2().getNombre());
		nombreP2.setBounds(462, 52, 198, 14);
		contentPane.add(nombreP2);
	}
}
