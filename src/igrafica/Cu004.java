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
import DTO.ListaDeportesDTO;
import DTO.ListaLugaresDTO;
import DTO.LugarDTO;
import capanegocios.Lugar;
import gestores.GestorCompetencias;
import gestores.GestorDeportes;
import gestores.GestorLugar;
import java.awt.event.ItemEvent;

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
    private TestModel model;
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
					Cu004 frame = new Cu004();
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
	public Cu004() {
		
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
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.addTest(new Test(lugar.getText(), disponibilidad.getText()));
			}
		});
		btnAgregar.setBounds(169, 146, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(427, 78, 46, 14);
		contentPane.add(lblDeporte);
		
		nombre = new JTextField();
		nombre.setBounds(104, 72, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		lugar = new JTextField();
		lugar.setBounds(104, 115, 86, 20);
		contentPane.add(lugar);
		lugar.setColumns(10);
		lugar.setEditable(false);
		
		
		
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
			if(deporte.getText()!=""){
				lugar.setEditable(true);
				long idDeporteElegido = deportes.returnId(deporte.getText());
				
				lugares = GestorLugar.getListadoLugares(idDeporteElegido);
				
				TextAutoCompleter lugaresAC = new TextAutoCompleter(lugar);
				for(LugarDTO object: lugares.getLugares()){
				
					lugaresAC.addItem(object.getNombre());
				}
				

			}
			else{
				lugar.setEditable(false);
			}
			}
		});
		deporte.setBounds(473, 75, 86, 20);
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
		lblModalidad.setBounds(427, 106, 63, 14);
		contentPane.add(lblModalidad);


		puntosVictoria = new JTextField();
		puntosVictoria.setBounds(500, 134, 86, 20);
		contentPane.add(puntosVictoria);
		puntosVictoria.setColumns(10);
		
		final JTextArea reglamento = new JTextArea();
		reglamento.setBounds(75, 377, 255, 159);
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
		
		chckbxSePermiteEmpate.setBounds(393, 181, 140, 23);
		contentPane.add(chckbxSePermiteEmpate);
		
		resultado = new JTextField();
		resultado.setBounds(609, 294, 86, 20);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		final JComboBox comboCantidadSets = new JComboBox();
		comboCantidadSets.addItem(1);
		
		comboCantidadSets.addItem(3);
		
		comboCantidadSets.addItem(5);
		
		comboCantidadSets.addItem(7);
		
		comboCantidadSets.addItem(9);
		comboCantidadSets.setBounds(542, 374, 70, 20);
		contentPane.add(comboCantidadSets);
		
		final JComboBox comboPuntos = new JComboBox();
		comboPuntos.setBounds(559, 258, 86, 20);
		contentPane.add(comboPuntos);
		
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
		comboFormaPuntuacion.setBounds(534, 331, 147, 20);
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
		comboModalidad.setBounds(500, 103, 112, 20);
		contentPane.add(comboModalidad);
		
		comboModalidad.addItem("Liga");
		comboModalidad.addItem("Eliminatoria simple");
		comboModalidad.addItem("Eliminatoria doble");
		
		
		JLabel lblPuntosVictoria = new JLabel("Puntos Victoria");
		lblPuntosVictoria.setBounds(396, 136, 94, 14);
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
		lblPuntosEmpate.setBounds(427, 221, 106, 14);
		contentPane.add(lblPuntosEmpate);
		
				
		JLabel lblPuntosPorPresentarse = new JLabel("Puntos por Presentarse");
		lblPuntosPorPresentarse.setBounds(396, 261, 137, 14);
		contentPane.add(lblPuntosPorPresentarse);
		
		JLabel lblResultadoPorNo = new JLabel("Resultado por no presentarse contrincante");
		lblResultadoPorNo.setBounds(356, 297, 289, 14);
		contentPane.add(lblResultadoPorNo);
		
		
		
		JLabel lblFormaDePuntuacin = new JLabel("Forma de Puntuaci\u00F3n");
		lblFormaDePuntuacin.setBounds(356, 334, 134, 14);
		contentPane.add(lblFormaDePuntuacin);
		
		
		
		JLabel lblCantidadDeSets = new JLabel("Cantidad de Sets");
		lblCantidadDeSets.setBounds(381, 377, 109, 14);
		contentPane.add(lblCantidadDeSets);
		
		
		final JLabel lblSeleccioneUnNombre = new JLabel("seleccione un nombre");
		lblSeleccioneUnNombre.setBounds(104, 90, 179, 14);
		lblSeleccioneUnNombre.setForeground(Color.red);
		lblSeleccioneUnNombre.setVisible(false);
		contentPane.add(lblSeleccioneUnNombre);
		
		final Date ahora = new Date();
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nombre.getText().isEmpty()){
					lblSeleccioneUnNombre.setVisible(true);
					sonido("error");
				}
				/*Aca irian las demas validaciones*/
				else{
					CompetenciaDTO competencia = new CompetenciaDTO();
					competencia.setNombre(nombre.getText());
					competencia.setPuntos_ganador(Integer.parseInt(puntosVictoria.getText()));
					competencia.setPuntos_empate(Integer.parseInt(puntosEmpate.getText()));
					competencia.setPermite_empates(chckbxSePermiteEmpate.isSelected());
					competencia.setReglamento(reglamento.getText());
					competencia.setResultado_final(Integer.parseInt(resultado.getText()));
					competencia.setCantidad_sets((int)comboCantidadSets.getSelectedItem());
					competencia.setPuntos_presentarse((int)comboPuntos.getSelectedItem());
					competencia.setFecha_hora(ahora);
					
					/*Falta agregar los lugares y disponibilidad*/
					long idforma;
					long idmodalidad;
					if(comboFormaPuntuacion.getSelectedIndex()==0)
						idforma = 2;
					else if(comboFormaPuntuacion.getSelectedIndex()==1)
						idforma=1;
					else
						idforma=3;
					
					if(comboModalidad.getSelectedIndex()==0)
						idmodalidad = 1;
					else if(comboModalidad.getSelectedIndex()==1)
						idmodalidad=2;
					else
						idmodalidad=3;
					GestorCompetencias.crearCompetencia(competencia,idforma,deporte.getText(),idmodalidad);
					
				}
			}
		});
		btnAceptar.setBounds(424, 513, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(581, 513, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDarDeAlta = new JLabel("DAR DE ALTA COMPETENCIA DEPORTIVA");
		lblDarDeAlta.setBounds(159, 21, 400, 14);
		lblDarDeAlta.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblDarDeAlta);
		
	
		JLabel reg = new JLabel("Reglamento (opcional)");
		reg.setBounds(75, 350, 140, 14);
		contentPane.add(reg);
		
		
		
		
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


