package igrafica;

import java.util.ArrayList;

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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.CompetenciaDAO;
import DTO.ListaCompetenciasDTO;

import DTO.CompetenciaDTO;
import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;
import gestores.GestorCompetencias;
import gestores.GestorDeportes;

public class Cu003 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTable table;
	private ListaCompetenciasDTO competencias;
    private ListaDeportesDTO deportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu003 frame = new Cu003();
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
	public Cu003() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setTitle("Gevico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBsquedaDeCompetencias = new JLabel("BUSQUEDA DE COMPETENCIA");
		lblBsquedaDeCompetencias.setFont(new Font("Arial",Font.BOLD,18));
		lblBsquedaDeCompetencias.setBounds(249, 56, 318, 44);
		contentPane.add(lblBsquedaDeCompetencias);
		
		nombre = new JTextField();
		nombre.setBounds(206, 147, 172, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JComboBox comboDeporte = new JComboBox();
		comboDeporte.setBounds(206, 203, 172, 20);
		contentPane.add(comboDeporte);
		
		comboDeporte.addItem(null);
		//Recuperamos los Deportes y los mostramos en el ComboBox
		//habria que ver de ordenarlos alfabeticamente
		deportes = GestorDeportes.getListadoDeportes();
		
		for(DeporteDTO depor: deportes.getDeportes()){
			
			comboDeporte.addItem(depor.getNombre());
		}
		
		JComboBox comboModalidad = new JComboBox();
		comboModalidad.setBounds(508, 147, 172, 20);
		contentPane.add(comboModalidad);
		
		//Agregamos las modalidades de manera directa
		comboModalidad.addItem(null);
		comboModalidad.addItem("Liga");
		comboModalidad.addItem("Eliminación Simple");
		comboModalidad.addItem("Eliminación Doble");
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(508, 203, 172, 20);
		contentPane.add(comboEstado);
		
		//Los estados tambien los agregamos de manera directa
		comboEstado.addItem(null);
		comboEstado.addItem("Creada");
		comboEstado.addItem("Planificada");
		comboEstado.addItem("En Disputa");
		comboEstado.addItem("Finalizada");
		
		JLabel lblNombreDeCompetencia = new JLabel("Nombre de competencia");
		lblNombreDeCompetencia.setBounds(206, 122, 151, 14);
		contentPane.add(lblNombreDeCompetencia);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte asociado");
		lblDeporteAsociado.setBounds(206, 178, 109, 14);
		contentPane.add(lblDeporteAsociado);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(508, 122, 59, 14);
		contentPane.add(lblModalidad);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(508, 178, 46, 14);
		contentPane.add(lblEstado);
		
		JButton btnCancelar = new JButton("Buscar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				competencias = CompetenciaDAO.getListado(); //habria que comunicarse con el gestor primero
				System.out.println(competencias.getCompetencias().get(0).getNombre());//imprimo el nombre por consola para ver que anda, que es lo unico que recupere
			}
		});
		btnCancelar.setBounds(206, 286, 151, 23);
		contentPane.add(btnCancelar);
		JButton btnBuscar = new JButton("Buscar");
		//Definimos la accion del boton BUSCAR
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CompetenciaDTO> listaCompetenciasEncontradas = 
						GestorCompetencias.buscarCompetencias(nombre.getText(), comboDeporte.getSelectedIndex(), 
								comboModalidad.getSelectedIndex(), comboEstado.getSelectedIndex())
			}
		});
		btnBuscar.setBounds(206, 286, 151, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCrearCompetencia = new JButton("Crear competencia");
		btnCrearCompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu004 ventana = new Cu004();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCrearCompetencia.setBounds(529, 286, 151, 23);
		contentPane.add(btnCrearCompetencia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 348, 630, 143);
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
			},
			new String[] {
					"Nombre","Deporte Asociado","Modalidad","Estado","Ver", "Eliminar"   
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(381, 522, 89, 23);
		contentPane.add(btnCancelar);
	}
}
