package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Cu005 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField lugar;
	private JTextField disponibilidad;
	private JTextField deporte;
	private JTextField puntosVictoria;
	private JTable table;
	private JTextField puntosEmpate;
	private JTextField resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu005 frame = new Cu005();
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
	public Cu005() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Gevico");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarCompetencia = new JLabel("MODIFICAR COMPETENCIA DEPORTIVA");
		lblModificarCompetencia.setFont(new Font("Arial",Font.BOLD,18));
		lblModificarCompetencia.setBounds(224, 26, 422, 48);
		contentPane.add(lblModificarCompetencia);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(46, 78, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel Lugar = new JLabel("Lugar");
		Lugar.setBounds(46, 106, 46, 14);
		contentPane.add(Lugar);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(200, 106, 70, 14);
		contentPane.add(lblDisponibilidad);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(160, 133, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(427, 78, 46, 14);
		contentPane.add(lblDeporte);
		
		nombre = new JTextField();
		nombre.setBounds(94, 75, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		lugar = new JTextField();
		lugar.setBounds(94, 103, 86, 20);
		contentPane.add(lugar);
		lugar.setColumns(10);
		
		disponibilidad = new JTextField();
		disponibilidad.setBounds(280, 103, 86, 20);
		contentPane.add(disponibilidad);
		disponibilidad.setColumns(10);
		
		deporte = new JTextField();
		deporte.setBounds(500, 75, 86, 20);
		contentPane.add(deporte);
		deporte.setColumns(10);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(427, 106, 63, 14);
		contentPane.add(lblModalidad);
		
		JComboBox comboModalidad = new JComboBox();
		comboModalidad.setBounds(500, 103, 112, 20);
		contentPane.add(comboModalidad);
		
		JLabel lblPuntosVictoria = new JLabel("Puntos Victoria");
		lblPuntosVictoria.setBounds(396, 136, 94, 14);
		contentPane.add(lblPuntosVictoria);
		
		puntosVictoria = new JTextField();
		puntosVictoria.setBounds(500, 134, 86, 20);
		contentPane.add(puntosVictoria);
		puntosVictoria.setColumns(10);
		
		JCheckBox chckbxSePermiteEmpate = new JCheckBox("Se permite empate?");
		chckbxSePermiteEmpate.setBounds(393, 181, 140, 23);
		contentPane.add(chckbxSePermiteEmpate);
		
		table = new JTable();
		table.setBounds(77, 185, 255, 159);
		contentPane.add(table);
		
		JLabel lblPuntosEmpate = new JLabel("Puntos Empate");
		lblPuntosEmpate.setBounds(427, 221, 106, 14);
		contentPane.add(lblPuntosEmpate);
		
		puntosEmpate = new JTextField();
		puntosEmpate.setBounds(539, 218, 86, 20);
		contentPane.add(puntosEmpate);
		puntosEmpate.setColumns(10);
		
		JLabel lblPuntosPorPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPorPresentarse.setBounds(396, 261, 117, 14);
		contentPane.add(lblPuntosPorPresentarse);
		
		JLabel lblResultadoPorNo = new JLabel("Resultado por no presentarse contrincante");
		lblResultadoPorNo.setBounds(356, 297, 214, 14);
		contentPane.add(lblResultadoPorNo);
		
		resultado = new JTextField();
		resultado.setBounds(567, 294, 86, 20);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		JLabel lblFormaDePuntuacin = new JLabel("Forma de Puntuaci\u00F3n");
		lblFormaDePuntuacin.setBounds(356, 334, 112, 14);
		contentPane.add(lblFormaDePuntuacin);
		
		JComboBox comboFormaPuntuacion = new JComboBox();
		comboFormaPuntuacion.setBounds(478, 331, 147, 20);
		contentPane.add(comboFormaPuntuacion);
		
		JLabel lblCantidadDeSets = new JLabel("Cantidad de Sets");
		lblCantidadDeSets.setBounds(381, 377, 87, 14);
		contentPane.add(lblCantidadDeSets);
		
		JComboBox comboCantidadSets = new JComboBox();
		comboCantidadSets.setBounds(518, 374, 70, 20);
		contentPane.add(comboCantidadSets);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(412, 537, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(579, 537, 89, 23);
		contentPane.add(btnCancelar);
		
		JTextArea reglamento = new JTextArea();
		reglamento.setBounds(77, 394, 255, 166);
		contentPane.add(reglamento);
		
		JLabel lblReglamentoopcional = new JLabel("Reglamento (opcional)");
		lblReglamentoopcional.setBounds(77, 369, 140, 14);
		contentPane.add(lblReglamentoopcional);
		
		JComboBox comboPuntos = new JComboBox();
		comboPuntos.setBounds(542, 258, 83, 20);
		contentPane.add(comboPuntos);
	}

}
