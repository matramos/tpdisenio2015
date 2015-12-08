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
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

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
	private GestorFixture fixture = new GestorFixture();

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
				System.out.println("caca");
				EncuentroDTO encuentro=fixture.GestionarResultado(id_competencia,id_ronda,id_encuentro);
				int[] puntajeP1 = null;
				int[] puntajeP2 = null;
				long[] idSets = null;
				int i=0;
				int cantidad=encuentro.getSets().size();
				int setGanadosP1=0;
				int setGanadosP2=0;
				String ganador;
				
				for(SetDTO set : encuentro.getSets()){
					idSets[i]=(set.getId_set());
					puntajeP1[i]=(set.getPuntajep1());
					puntajeP2[i]=(set.getPuntajep2());
					i++;
				}
				while(cantidad!=0){
					if(puntajeP1[cantidad]>puntajeP2[cantidad])
						setGanadosP1++;
					else
						setGanadosP2++;
					cantidad--;
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
		lblParticipante.setBounds(126, 52, 77, 14);
		contentPane.add(lblParticipante);
		
		JLabel lblParticipante_1 = new JLabel("Participante 2:");
		lblParticipante_1.setBounds(347, 52, 80, 14);
		contentPane.add(lblParticipante_1);
		
		lblSePresento = new JLabel("Se Presento?");
		lblSePresento.setBounds(279, 99, 77, 14);
		contentPane.add(lblSePresento);
		
		JCheckBox checkPart1 = new JCheckBox("",encuentro.isEstadop1());
		checkPart1.setBounds(239, 95, 21, 23);
		contentPane.add(checkPart1);
		
		JCheckBox checkPart2 = new JCheckBox("",encuentro.isEstadop2());
		checkPart2.setBounds(362, 95, 97, 23);
		contentPane.add(checkPart2);
		
		JLabel lblSet = new JLabel("Set 1");
		lblSet.setBounds(289, 125, 46, 14);
		contentPane.add(lblSet);
		
		JLabel lblSet_1 = new JLabel("Set 2");
		lblSet_1.setBounds(289, 143, 46, 14);
		contentPane.add(lblSet_1);
		
		JLabel lblSet_2 = new JLabel("Set 3");
		lblSet_2.setBounds(289, 168, 46, 14);
		contentPane.add(lblSet_2);
		
		JLabel lblSet_3 = new JLabel("Set 4");
		lblSet_3.setBounds(289, 188, 46, 14);
		contentPane.add(lblSet_3);
		
		JLabel lblSet_4 = new JLabel("Set 5");
		lblSet_4.setBounds(289, 209, 46, 14);
		contentPane.add(lblSet_4);
		
		JLabel lblSet_5 = new JLabel("Set 6");
		lblSet_5.setBounds(289, 234, 46, 14);
		contentPane.add(lblSet_5);
		
		JLabel lblSet_6 = new JLabel("Set 7");
		lblSet_6.setBounds(289, 259, 46, 14);
		contentPane.add(lblSet_6);
		
		JLabel lblSet_7 = new JLabel("Set 8");
		lblSet_7.setBounds(289, 284, 46, 14);
		contentPane.add(lblSet_7);
		
		JLabel lblSet_8 = new JLabel("Set 9");
		lblSet_8.setBounds(289, 309, 46, 14);
		contentPane.add(lblSet_8);
		//String a=puntajeP1[0].toString;
		txtS1P2 = new JTextField(Integer.toString(puntajeP2[0]));
		txtS1P2.setBounds(329, 122, 46, 20);
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
		txtS2P2.setBounds(329, 150, 46, 20);
		contentPane.add(txtS2P2);
		
		txtS3P2 = new JTextField(Integer.toString(puntajeP2[2]));
		txtS3P2.setColumns(10);
		txtS3P2.setBounds(329, 185, 46, 20);
		contentPane.add(txtS3P2);
		
		txtS4P2 = new JTextField(Integer.toString(puntajeP2[3]));
		txtS4P2.setColumns(10);
		txtS4P2.setBounds(329, 213, 46, 20);
		contentPane.add(txtS4P2);
		
		txtS5P2 = new JTextField(Integer.toString(puntajeP2[4]));
		txtS5P2.setColumns(10);
		txtS5P2.setBounds(329, 256, 46, 20);
		contentPane.add(txtS5P2);
		
		txtS3P1 = new JTextField(Integer.toString(puntajeP1[2]));
		txtS3P1.setColumns(10);
		txtS3P1.setBounds(226, 185, 46, 20);
		contentPane.add(txtS3P1);
		
		txtS4P1 = new JTextField(Integer.toString(puntajeP1[3]));
		txtS4P1.setColumns(10);
		txtS4P1.setBounds(226, 213, 46, 20);
		contentPane.add(txtS4P1);
		
		txtS5P1 = new JTextField(Integer.toString(puntajeP1[4]));
		txtS5P1.setColumns(10);
		txtS5P1.setBounds(226, 242, 46, 20);
		contentPane.add(txtS5P1);
		
		txtS6P1 = new JTextField(Integer.toString(puntajeP1[5]));
		txtS6P1.setColumns(10);
		txtS6P1.setBounds(226, 273, 46, 20);
		contentPane.add(txtS6P1);
		
		txtS7P1 = new JTextField(Integer.toString(puntajeP1[6]));
		txtS7P1.setColumns(10);
		txtS7P1.setBounds(226, 306, 46, 20);
		contentPane.add(txtS7P1);
		
		txtS8P1 = new JTextField(Integer.toString(puntajeP1[7]));
		txtS8P1.setColumns(10);
		txtS8P1.setBounds(226, 335, 46, 20);
		contentPane.add(txtS8P1);
		
		txtS9P1 = new JTextField(Integer.toString(puntajeP1[8]));
		txtS9P1.setColumns(10);
		txtS9P1.setBounds(226, 366, 46, 20);
		contentPane.add(txtS9P1);
		
		txtS6P2 = new JTextField(Integer.toString(puntajeP2[5]));
		txtS6P2.setColumns(10);
		txtS6P2.setBounds(329, 284, 46, 20);
		contentPane.add(txtS6P2);
		
		txtS7P2 = new JTextField(Integer.toString(puntajeP2[6]));
		txtS7P2.setColumns(10);
		txtS7P2.setBounds(329, 309, 46, 20);
		contentPane.add(txtS7P2);
		
		txtS8P2 = new JTextField(Integer.toString(puntajeP2[7]));
		txtS8P2.setColumns(10);
		txtS8P2.setBounds(329, 334, 46, 20);
		contentPane.add(txtS8P2);
		
		txtS9P2 = new JTextField(Integer.toString(puntajeP2[8]));
		txtS9P2.setColumns(10);
		txtS9P2.setBounds(329, 366, 46, 20);
		contentPane.add(txtS9P2);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(279, 411, 56, 14);
		contentPane.add(lblPuntuacion);
		
		txtRP1 = new JTextField();
		txtRP1.setBounds(226, 408, 46, 20);
		contentPane.add(txtRP1);
		txtRP1.setColumns(10);
		
		txtRP2 = new JTextField();
		txtRP2.setColumns(10);
		txtRP2.setBounds(341, 408, 46, 20);
		contentPane.add(txtRP2);
		
		JLabel lblResultadoFinal = new JLabel("Resultado Final:");
		lblResultadoFinal.setBounds(180, 460, 112, 14);
		contentPane.add(lblResultadoFinal);
		
		JComboBox comboResultadoFinal = new JComboBox();
		comboResultadoFinal.setBounds(262, 457, 112, 20);
		contentPane.add(comboResultadoFinal);
		
		JLabel lblGanador = new JLabel("Ganador:");
		lblGanador.setBounds(190, 485, 46, 14);
		contentPane.add(lblGanador);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(195, 537, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(362, 537, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel nombreP1 = new JLabel(encuentro.getJugador1().getNombre());
		nombreP1.setBounds(214, 52, 78, 14);
		contentPane.add(nombreP1);
		
		JLabel nombreP2 = new JLabel(encuentro.getJugador2().getNombre());
		nombreP2.setBounds(428, 52, 64, 14);
		contentPane.add(nombreP2);
		
		JLabel nombreGanador = new JLabel(ganador);
		nombreGanador.setBounds(262, 485, 46, 14);
		contentPane.add(nombreGanador);
		
		//guardo todos los datos de nuevo en el encuentro
		cantidad=encuentro.getSets().size();
		List<SetDTO> setActualizados= null;
		i=0;
		while(cantidad!=0){
			SetDTO set = new SetDTO(idSets[i],puntajeP1[i],puntajeP2[i]);
			setActualizados.add(set);
			cantidad--;
		}
		encuentro.setSets(setActualizados);
		//voy a gestionar fixture para cargar el resultado de los datos actualizados
		fixture.cargarResultado(id_competencia,id_ronda,id_encuentro,encuentro);
	}
}
