package igrafica;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import igrafica.TestModel.ColumnContext;
import com.mxrck.autocompleter.*;

import DTO.CompetenciaDTO;
import DTO.DeporteDTO;
import DTO.DisponibilidadDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import capanegocios.Lugar;
import gestores.GestorCompetencias;
import gestores.GestorDeportes;
import gestores.GestorLugar;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cu004 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField lugar;
	private JTextField disponibilidad;
	private JTextField deporte;
	private JTextField puntosVictoria;
	private JTable table;
	private JTextField puntosEmpate;
	private JTextField resultado;
    private TestModel model;// variable para tablas
    private ListaLugaresDTO lugares;
    private ListaDeportesDTO deportes;
    private Clip clip;
    private String ruta="/audio/";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu004 frame = new Cu004(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void sonido(String archivo){
		try{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
			clip.start();
			
			
		}catch(Exception e){
			
		}
	}
	/**
	 * Create the frame.
	 */
	
	//ESTE ES EL CONSTRUCTOR, NO?-matt
	public Cu004(final long id_usuario) {
		
		//DEFINIMOS LA VENTANA?--matt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setTitle("Gevico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(56, 75, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel Lugar = new JLabel("Lugar");
		Lugar.setBounds(56, 118, 46, 14);
		contentPane.add(Lugar);
		
		
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setBounds(210, 118, 89, 14);
		contentPane.add(lblDisponibilidad);
		
		
		final JLabel lblIndiqueAlgunLugar = new JLabel("Debe agregar al menos un lugar a la tabla");
		lblIndiqueAlgunLugar.setBounds(75, 349, 255, 14);
		lblIndiqueAlgunLugar.setForeground(Color.red);
		lblIndiqueAlgunLugar.setVisible(false);
		contentPane.add(lblIndiqueAlgunLugar);
		// boton agregar para la tabla
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean lugarRepetido = false;
				for(int i = 0; i<table.getRowCount(); i++){
					if(table.getValueAt(i, 0).equals(lugar.getText()))
						lugarRepetido = true;
				}
				if(disponibilidad.getText().isEmpty() || !(isNumeric(disponibilidad.getText()))|| lugar.getText().isEmpty() || !(perteneceL(lugar.getText(),lugares)) || lugarRepetido){
					
				}
				else {
					model.addTest(new Test(lugar.getText(), disponibilidad.getText()));
				}
				
			}

			private boolean perteneceL(String text, ListaLugaresDTO lugares) {
				boolean b = false;
				for(LugarDTO l: lugares.getLugares()){
					if(l.getNombre().equals(text))
						b = true;
				}
				return b;
			}
		});
		btnAgregar.setBounds(169, 146, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(393, 75, 46, 14);
		contentPane.add(lblDeporte);
		
		nombre = new JTextField();
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(Character.isLowerCase(c)){
					String cad = (""+c).toUpperCase();
					c=cad.charAt(0);
					arg0.setKeyChar(c);
				}
			}
		});
		nombre.setBounds(104, 72, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		lugar = new JTextField();
		lugar.setBounds(104, 115, 86, 20);
		contentPane.add(lugar);
		lugar.setColumns(10);
		lugar.setEditable(false);
		
		final JLabel lblSeleccioneDeporte = new JLabel("seleccione un deporte valido");
		lblSeleccioneDeporte.setBounds(539, 90, 179, 14);
		lblSeleccioneDeporte.setForeground(Color.red);
		lblSeleccioneDeporte.setVisible(false);
		contentPane.add(lblSeleccioneDeporte);
		
		
		/*Toda esta parte hay que corregirla despues para que busque los lugares despues de haber elegido el deporte,
		 o sea, que busque la lista de lugares con un id_deporte en la base de datos, ma�ana lo voy a ver*/
		deportes = GestorDeportes.getListadoDeportes();
		
		disponibilidad = new JTextField();
		disponibilidad.setBounds(290, 115, 86, 20);
		contentPane.add(disponibilidad);
		disponibilidad.setColumns(10);
		deporte = new JTextField();
		deporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(perteneceD(deporte.getText(),deportes)){
				lugar.setEditable(true);
				long idDeporteElegido = deportes.returnId(deporte.getText());
				
				lugares = GestorLugar.getListadoLugares(idDeporteElegido);
				
				TextAutoCompleter lugaresAC = new TextAutoCompleter(lugar);
				for(LugarDTO object: lugares.getLugares()){
				
					lugaresAC.addItem(object.getNombre());
				}
				
				lblSeleccioneDeporte.setVisible(false);
			}
			else{
				lblSeleccioneDeporte.setVisible(true);
				lugar.setEditable(false);
			}
			}

			private boolean perteneceD(String text, ListaDeportesDTO deportes) {
				boolean b = false;
				for(DeporteDTO d : deportes.getDeportes()){
					if(d.getNombre().equals(text)){
						b = true;
					}
				}
				return b;
			}
		});
		deporte.setBounds(539, 72, 86, 20);
		contentPane.add(deporte);
		deporte.setColumns(10);		
		/*Recupero la lista de deportes (tipo ListaDeportesDTO)*/
		
		TextAutoCompleter deportesAC = new TextAutoCompleter(deporte);
		for(DeporteDTO depor: deportes.getDeportes()){
			
			deportesAC.addItem(depor.getNombre());
		}
		
		/*Recupero los lugares (tipo ListaLugaresDTO)*/
		
		/*Recorro la lista y voy agregando al autocomplete los lugares */

		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(393, 118, 63, 14);
		contentPane.add(lblModalidad);

		final JComboBox comboPuntos = new JComboBox();
		comboPuntos.setBounds(539, 263, 86, 20);
		contentPane.add(comboPuntos);
		
		
		puntosVictoria = new JTextField();
		puntosVictoria.setBounds(539, 147, 86, 20);
		puntosVictoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i<Integer.parseInt(puntosVictoria.getText());i++){
					comboPuntos.addItem(i);
				}
			}
		});
		contentPane.add(puntosVictoria);
		puntosVictoria.setColumns(10);
		
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		final JTextArea reglamento = new JTextArea();
		reglamento.setBounds(75, 401, 255, 159);
		reglamento.setBorder(border);
		contentPane.add(reglamento);
		
		
		puntosEmpate = new JTextField();
		puntosEmpate.setBounds(539, 218, 86, 20);
		contentPane.add(puntosEmpate);
		puntosEmpate.setColumns(10);

		
		
		final JCheckBox chckbxSePermiteEmpate = new JCheckBox("Se permite empate?");
		chckbxSePermiteEmpate.setSelected(true);
		chckbxSePermiteEmpate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()== ItemEvent.SELECTED){
					puntosEmpate.setEditable(true);
				}
				else{
					puntosEmpate.setEditable(false);
				}
			}
		});
		
		chckbxSePermiteEmpate.setBounds(392, 183, 140, 23);
		contentPane.add(chckbxSePermiteEmpate);
		
		resultado = new JTextField();
		resultado.setBounds(539, 312, 86, 20);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		final JComboBox comboCantidadSets = new JComboBox();
		comboCantidadSets.addItem(1);
		
		comboCantidadSets.addItem(3);
		
		comboCantidadSets.addItem(5);
		
		comboCantidadSets.addItem(7);
		
		comboCantidadSets.addItem(9);
		comboCantidadSets.setBounds(539, 404, 70, 20);
		contentPane.add(comboCantidadSets);
		comboCantidadSets.setEnabled(false);
		
		
		
		
		
		
		final JComboBox comboFormaPuntuacion = new JComboBox();
		comboFormaPuntuacion.addItem("Puntuacion");
		comboFormaPuntuacion.addItem("Sets");
		comboFormaPuntuacion.addItem("Resultado final");
		comboFormaPuntuacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
                String seleccion = (String) arg0.getItem();
				if(arg0.getStateChange()== ItemEvent.SELECTED){
					if(seleccion == "Sets"){
					comboCantidadSets.setEnabled(true);
					chckbxSePermiteEmpate.setEnabled(false);
					puntosEmpate.setEditable(false);
					
					
				}
					else{
					comboCantidadSets.setEnabled(false);
					chckbxSePermiteEmpate.setEnabled(true);
					puntosEmpate.setEditable(true);
					
				}
				
				
				
			}
		}});
		comboFormaPuntuacion.setBounds(539, 354, 147, 20);
		contentPane.add(comboFormaPuntuacion);
		
		
		
		final JComboBox comboModalidad = new JComboBox();
		comboModalidad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
                String seleccion = (String) arg0.getItem();
				if(arg0.getStateChange()== ItemEvent.SELECTED){
					if(seleccion == "Liga"){
					puntosVictoria.setEditable(true);
					chckbxSePermiteEmpate.setEnabled(true);
					puntosEmpate.setEditable(true);
					resultado.setEditable(true);
					comboPuntos.setEnabled(true);
				}
					else{
					puntosVictoria.setEditable(false);
					chckbxSePermiteEmpate.setEnabled(false);
					puntosEmpate.setEditable(false);
					resultado.setEditable(false);
					comboPuntos.setEnabled(false);
					
				}
				
				
				
			}
		}});
		comboModalidad.setBounds(539, 115, 112, 20);
		contentPane.add(comboModalidad);
		
		comboModalidad.addItem("Liga");
		comboModalidad.addItem("Eliminatoria simple");
		comboModalidad.addItem("Eliminatoria doble");
		
		
		JLabel lblPuntosVictoria = new JLabel("Puntos Victoria");
		lblPuntosVictoria.setBounds(393, 148, 94, 14);
		contentPane.add(lblPuntosVictoria);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 180, 255, 159);
		contentPane.add(scrollPane);
		
		model = new TestModel();
		String columnHeaders[]={"Lugar","Disponibilidad",""};
		table = new JTable(model);
        
        TableColumn column = table.getColumnModel().getColumn(2);
        column.setCellRenderer(new DeleteButtonRenderer());
        column.setCellEditor(new DeleteButtonEditor(table));
        column.setMinWidth(20);
        column.setMaxWidth(20);
        column.setResizable(false);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JLabel lblPuntosEmpate = new JLabel("Puntos Empate");
		lblPuntosEmpate.setBounds(393, 221, 106, 14);
		contentPane.add(lblPuntosEmpate);
		
				
		JLabel lblPuntosPorPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPorPresentarse.setBounds(393, 266, 137, 14);
		contentPane.add(lblPuntosPorPresentarse);
		
		JLabel lblResultadoPorNo = new JLabel("Resultado por no ");
		lblResultadoPorNo.setBounds(393, 315, 158, 14);
		contentPane.add(lblResultadoPorNo);
		
		
		
		JLabel lblFormaDePuntuacin = new JLabel("Forma de Puntuaci\u00F3n");
		lblFormaDePuntuacin.setBounds(393, 357, 134, 14);
		contentPane.add(lblFormaDePuntuacin);
		
		
		
		JLabel lblCantidadDeSets = new JLabel("Cantidad de Sets");
		lblCantidadDeSets.setBounds(393, 407, 109, 14);
		contentPane.add(lblCantidadDeSets);
		
		
		final JLabel lblSeleccioneUnNombre = new JLabel("seleccione un nombre");
		lblSeleccioneUnNombre.setBounds(103, 93, 179, 14);
		lblSeleccioneUnNombre.setForeground(Color.red);
		lblSeleccioneUnNombre.setVisible(false);
		contentPane.add(lblSeleccioneUnNombre);
		
		final JLabel lblSeleccionePuntosVictoria = new JLabel("seleccione los puntos");
		lblSeleccionePuntosVictoria.setBounds(539, 169, 179, 14);
		lblSeleccionePuntosVictoria.setForeground(Color.red);
		lblSeleccionePuntosVictoria.setVisible(false);
		contentPane.add(lblSeleccionePuntosVictoria);
		
		
		
		final JLabel lblSeleccionePuntosEmpate = new JLabel("seleccione los puntos");
		lblSeleccionePuntosEmpate.setBounds(539, 241, 179, 14);
		lblSeleccionePuntosEmpate.setForeground(Color.red);
		lblSeleccionePuntosEmpate.setVisible(false);
		contentPane.add(lblSeleccionePuntosEmpate);
		
		final JLabel lblSeleccioneResultado = new JLabel("seleccione resultado");
		lblSeleccioneResultado.setBounds(539, 329, 158, 14);
		lblSeleccioneResultado.setForeground(Color.red);
		lblSeleccioneResultado.setVisible(false);
		contentPane.add(lblSeleccioneResultado);
		
		final JLabel lblYaExiste = new JLabel("ya existe una competencia con ese nombre");
		lblYaExiste.setBounds(104, 93, 295, 14);
		lblYaExiste.setForeground(Color.red);
		lblYaExiste.setVisible(false);
		contentPane.add(lblYaExiste);
		
		
		final JLabel lblPuntosvMenor = new JLabel("debe ser mayor que puntos por empate");
		lblPuntosvMenor.setBounds(539, 169, 272, 14);
		lblPuntosvMenor.setForeground(Color.red);
		lblPuntosvMenor.setVisible(false);
		contentPane.add(lblPuntosvMenor);
		
		
		final JLabel lblPuntosNegativos = new JLabel("Los puntos no pueden ser negativos");
		lblPuntosNegativos.setBounds(539, 169, 272, 14);
		lblPuntosNegativos.setForeground(Color.red);
		lblPuntosNegativos.setVisible(false);
		contentPane.add(lblPuntosNegativos);
		
		final JLabel lblComboVacio = new JLabel("Seleccione puntos victoria y presione enter");
		lblComboVacio.setBounds(539, 286, 272, 14);
		lblComboVacio.setForeground(Color.red);
		lblComboVacio.setVisible(false);
		contentPane.add(lblComboVacio);
		
		final Date ahora = new Date();
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//VALIDACIONES
				
				boolean noexiste = GestorCompetencias.validarNombre(nombre.getText());
				boolean menor = !(puntosVictoria.isEditable() && puntosVictoria.getText().isEmpty()) && !(puntosEmpate.isEditable() && puntosEmpate.getText().isEmpty()) && ((Integer.parseInt(puntosVictoria.getText()) < Integer.parseInt(puntosEmpate.getText())));
				boolean negativo = !(puntosVictoria.isEditable() && puntosVictoria.getText().isEmpty()) && !(puntosEmpate.isEditable() && puntosEmpate.getText().isEmpty()) && (Integer.parseInt(puntosVictoria.getText()) <0);
				
				if(nombre.getText().isEmpty() || (puntosVictoria.isEditable() && puntosVictoria.getText().isEmpty()) || (puntosEmpate.isEditable() && puntosEmpate.getText().isEmpty())|| resultado.isEditable() && resultado.getText().isEmpty() || table.getRowCount()==0  || !noexiste || menor || negativo || comboPuntos.getItemCount()==0){
				if(nombre.getText().isEmpty()){
					lblSeleccioneUnNombre.setVisible(true);
					sonido("error");
				}
				else
					lblSeleccioneUnNombre.setVisible(false);
				if(comboPuntos.getItemCount()==0){
					lblComboVacio.setVisible(true);
					sonido("error");
				}
				else{
					lblComboVacio.setVisible(false);
				}
				if(!noexiste){
					lblYaExiste.setVisible(true);
					sonido("error");
				}
				else
					lblYaExiste.setVisible(false);
				if(table.getRowCount() == 0){
					lblIndiqueAlgunLugar.setVisible(true);
					sonido("error");
				}
				else{
					lblIndiqueAlgunLugar.setVisible(false);
				}
				if(puntosVictoria.isEditable() && puntosVictoria.getText().isEmpty()){
					lblSeleccionePuntosVictoria.setVisible(true);
					sonido("error");
				}
				else if(Integer.parseInt(puntosVictoria.getText()) <0){
					lblSeleccionePuntosVictoria.setVisible(false);	
					lblPuntosNegativos.setVisible(true);
					sonido("error");
				}
				else if (puntosEmpate.isEditable() && puntosEmpate.getText().isEmpty()){
					lblPuntosNegativos.setVisible(false);
					lblSeleccionePuntosVictoria.setVisible(false);
					lblSeleccionePuntosEmpate.setVisible(true);
					sonido("error");
				}
				
				else{
					lblPuntosNegativos.setVisible(false);
					lblSeleccionePuntosVictoria.setVisible(false);
					lblSeleccionePuntosEmpate.setVisible(false);
					if((Integer.parseInt(puntosVictoria.getText()) < Integer.parseInt(puntosEmpate.getText()))){
						lblPuntosvMenor.setVisible(true);
						sonido("error");
					}
					else{
						lblPuntosvMenor.setVisible(false);
					}
				}
				if(puntosEmpate.isEditable() && puntosEmpate.getText().isEmpty()){
					lblSeleccionePuntosEmpate.setVisible(true);
					sonido("error");
				}
				else
					lblSeleccionePuntosEmpate.setVisible(false);
				if(resultado.isEditable() && resultado.getText().isEmpty()){
					lblSeleccioneResultado.setVisible(true);
					sonido("error");
				}
				else
					lblSeleccioneResultado.setVisible(false);
				}
				//VALIDACIONES
				else{
					CompetenciaDTO competencia = new CompetenciaDTO();
					for(int i = 0; i<table.getRowCount();i++){
						DisponibilidadDTO disponibilidad = new DisponibilidadDTO();
						String dis = (String) table.getValueAt(i, 1);
						disponibilidad.setDisponibilidad(Integer.parseInt(dis));
						disponibilidad.setLugar(lugares.getLugar(table.getValueAt(i, 0).toString()));
						competencia.addLugar(disponibilidad);
					}
					competencia.setNombre(nombre.getText());
					
					
					competencia.setReglamento(reglamento.getText());
					
					competencia.setCantidad_sets((int)comboCantidadSets.getSelectedItem());
					
					competencia.setFecha_hora(ahora);
					
					
					/*Falta agregar los lugares y disponibilidad*/
					int idforma;
					long idmodalidad;
					if(comboFormaPuntuacion.getSelectedIndex()==0)
						idforma = 2;
					else if(comboFormaPuntuacion.getSelectedIndex()==1)
						idforma=1;
					else
						idforma=3;
					
					if(comboModalidad.getSelectedIndex()==0){
						idmodalidad = 1;
						competencia.setPuntos_ganador(Integer.parseInt(puntosVictoria.getText()));
						competencia.setPuntos_empate(Integer.parseInt(puntosEmpate.getText()));
						competencia.setPermite_empates(chckbxSePermiteEmpate.isSelected());
						competencia.setPuntos_presentarse((int)comboPuntos.getSelectedItem());
						competencia.setResultado_final(Integer.parseInt(resultado.getText()));
					}
					else if(comboModalidad.getSelectedIndex()==1)
						idmodalidad=2;
					else
						idmodalidad=3;
					long idGenerado = GestorCompetencias.crearCompetencia(competencia,idforma,deporte.getText(),idmodalidad,id_usuario);
					
					if(idGenerado!=(long) -1){
						JOptionPane.showMessageDialog(null, "Se cargo con exito");
						Cu008 ventana = new Cu008(idGenerado,id_usuario);
						ventana.setVisible(true);
						dispose();
					}
					
					
				}
			}
		});
		btnAceptar.setBounds(424, 537, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cu003 ventana = new Cu003(id_usuario);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(559, 537, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDarDeAlta = new JLabel("DAR DE ALTA COMPETENCIA DEPORTIVA");
		lblDarDeAlta.setBounds(209, 24, 400, 14);
		lblDarDeAlta.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblDarDeAlta);
		
	
		JLabel reg = new JLabel("Reglamento (opcional)");
		reg.setBounds(75, 374, 140, 14);
		contentPane.add(reg);
		
		JLabel lblNewLabel = new JLabel("presentarse contrincante");
		lblNewLabel.setBounds(394, 329, 166, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal (id_usuario);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setBounds(665, 537, 105, 23);
		contentPane.add(btnMenuPrincipal);
		
		
		
		
	}


	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
}
class ButtonRenderer extends JButton implements TableCellRenderer{

	public ButtonRenderer(){
			
		}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object objeto, boolean seleccionado, boolean focused, int fila,
			int columna) {
		// TODO Auto-generated method stub
		setText((objeto==null) ? "":objeto.toString());
		return this;
	}

}

class ButtonEditor extends DefaultCellEditor{
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	public ButtonEditor(JTextField txt) {
		super(txt);
		// TODO Auto-generated constructor stub
		btn = new JButton();
		btn.setOpaque(true);
	}
	@Override
	public Component getTableCellEditorComponent(JTable table, Object objeto,boolean seleccionado, int fila, int columna){
		lbl=(objeto==null) ? "":objeto.toString();
		btn.setText(lbl);
		clicked=true;
		return btn;
	}
	@Override
	public Object getCellEditorValue(){
		if(clicked){
			JOptionPane.showMessageDialog(btn, lbl+" Clicked");
		}
		clicked =false;
		return new String(lbl);
	}
	@Override
	public boolean stopCellEditing(){
		clicked = false;
		return super.stopCellEditing();
	}
	@Override
	protected void fireEditingStopped(){
		super.fireEditingStopped();
	}
}

////
class DeleteButton extends JButton {
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setRolloverEnabled(false);
        setText("X");
    }
}

class DeleteButtonRenderer extends DeleteButton implements TableCellRenderer {
    public DeleteButtonRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class DeleteButtonEditor extends DeleteButton implements TableCellEditor {
    public DeleteButtonEditor(final JTable table) {
        super();
        addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                fireEditingStopped();
				((DefaultTableModel) table.getModel()).removeRow(row);
                //String nombre = table.getValueAt(row, 1).toString();
                //JOptionPane.showMessageDialog(null, nombre);
            }
        });
    }
    @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return this;
    }
    @Override public Object getCellEditorValue() {
        return "";
    }

    //Copied from AbstractCellEditor
    //protected EventListenerList listenerList = new EventListenerList();
    //protected transient ChangeEvent changeEvent;

    @Override public boolean isCellEditable(EventObject e) {
        return true;
    }
    @Override public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
    @Override public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }
    @Override public void cancelCellEditing() {
        fireEditingCanceled();
    }
    @Override public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }
    @Override public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }
    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }
    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (Objects.isNull(changeEvent)) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
            }
        }
    }
    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (Objects.isNull(changeEvent)) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
            }
        }
    }
}

class Test {
    private String name, comment;
    public Test(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }
    public void setName(String str) {
        name = str;
    }
    public void setComment(String str) {
        comment = str;
    }
    public String getName() {
        return name;
    }
    public String getComment() {
        return comment;
    }
}

// class model
class TestModel extends DefaultTableModel {
    private static final ColumnContext[] COLUMN_ARRAY = {
        new ColumnContext("Lugar",     String.class, true),
        new ColumnContext("Disponibilidad",    String.class,  true),
        new ColumnContext("", String.class,  true),
    };
    public void addTest(Test t) {
        Object[] obj = {t.getName(), t.getComment(), ""};
        super.addRow(obj);
    }
    @Override public boolean isCellEditable(int row, int col) {
        return COLUMN_ARRAY[col].isEditable;
    }
    @Override public Class<?> getColumnClass(int modelIndex) {
        return COLUMN_ARRAY[modelIndex].columnClass;
    }
    @Override public int getColumnCount() {
        return COLUMN_ARRAY.length;
    }
    @Override public String getColumnName(int modelIndex) {
        return COLUMN_ARRAY[modelIndex].columnName;
    }
    public static class ColumnContext {
        public final String  columnName;
        public final Class   columnClass;
        public final boolean isEditable;
        public ColumnContext(String columnName, Class columnClass, boolean isEditable) {
            this.columnName = columnName;
            this.columnClass = columnClass;
            this.isEditable = isEditable;
        }
    }
}


