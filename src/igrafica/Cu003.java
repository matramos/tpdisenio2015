package igrafica;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Objects;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DAO.CompetenciaDAO;
import DTO.ListaCompetenciasDTO;

import DTO.CompetenciaDTO;
import DTO.DeporteDTO;
import DTO.ListaDeportesDTO;
import gestores.GestorCompetencias;
import gestores.GestorDeportes;
import igrafica.TestModel.ColumnContext;

public class Cu003 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
    private ListaDeportesDTO deportes;
    private ListaCompetenciasDTO competencias;
    private TestModelCU3 model;
    private JTable table;
    public ArrayList<CompetenciaDTO> listaCompetenciasEncontradas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu003 frame = new Cu003(1);
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
	public Cu003(final long id_usuario) {
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
		nombre.setBounds(150, 149, 172, 20);
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
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		final JComboBox<String> comboDeporte = new JComboBox<>();
		comboDeporte.setBounds(150, 205, 172, 20);
		contentPane.add(comboDeporte);
		
		comboDeporte.addItem(null);
		//Recuperamos los Deportes y los mostramos en el ComboBox
		//habria que ver de ordenarlos alfabeticamente
		deportes = GestorDeportes.getListadoDeportes();
		
		for(DeporteDTO depor: deportes.getDeportes()){
			
			comboDeporte.addItem(depor.getNombre());
		}
		
		final JComboBox<String> comboModalidad = new JComboBox<String>();
		comboModalidad.setBounds(452, 149, 172, 20);
		contentPane.add(comboModalidad);
		
		//Agregamos las modalidades de manera directa
		comboModalidad.addItem(null);
		comboModalidad.addItem("Liga");
		comboModalidad.addItem("Eliminacion Simple");
		comboModalidad.addItem("Eliminacion Doble");
		
		final JComboBox<String> comboEstado = new JComboBox<>();
		comboEstado.setBounds(452, 205, 172, 20);
		contentPane.add(comboEstado);
		
		//Los estados tambien los agregamos de manera directa
		comboEstado.addItem(null);
		comboEstado.addItem("Creada");
		comboEstado.addItem("Planificada");
		comboEstado.addItem("En Disputa");
		comboEstado.addItem("Finalizada");
		
		JLabel lblNombreDeCompetencia = new JLabel("Nombre de competencia");
		lblNombreDeCompetencia.setBounds(150, 124, 151, 14);
		contentPane.add(lblNombreDeCompetencia);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte asociado");
		lblDeporteAsociado.setBounds(150, 180, 109, 14);
		contentPane.add(lblDeporteAsociado);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(452, 124, 59, 14);
		contentPane.add(lblModalidad);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(452, 180, 46, 14);
		contentPane.add(lblEstado);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 335, 567, 159);
		contentPane.add(scrollPane);
		
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		//Definimos la accion del boton BUSCAR
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombre.getText().equals("") && comboDeporte.getSelectedItem()==null && comboModalidad.getSelectedItem()==null && comboEstado.getSelectedItem()==null){
					JOptionPane.showMessageDialog(null, "Debe utilizar al menos un filtro");
				}
				else{
				 listaCompetenciasEncontradas = 
						GestorCompetencias.buscarCompetencias(nombre.getText(), comboDeporte.getSelectedIndex(), 
								comboModalidad.getSelectedIndex(), comboEstado.getSelectedIndex(), id_usuario);
				//Descomentar para ver que estamos eligiendo
				 model = new TestModelCU3();
					table = new JTable(model);
				    
					TableColumn column1 = table.getColumnModel().getColumn(3);
				    column1.setCellRenderer(new DeleteButtonRendererCU3());
				    column1.setCellEditor(new DeleteButtonEditorCU3(table, listaCompetenciasEncontradas));
				    column1.setMinWidth(20);
				    column1.setMaxWidth(20);
				    column1.setResizable(false);
				    
				    TableColumn column2 = table.getColumnModel().getColumn(4);
				    column2.setCellRenderer(new DeleteButtonRenderer2CU3());
				    column2.setCellEditor(new DeleteButtonEditor2CU3(table, listaCompetenciasEncontradas,id_usuario));
				    column2.setMinWidth(60);
				    column2.setMaxWidth(60);
				    column2.setResizable(false);
					
					table.getColumnModel().getColumn(0).setPreferredWidth(55);
					scrollPane.setViewportView(table);
				
				for(CompetenciaDTO CDTO : listaCompetenciasEncontradas){
					model.addTest(new TestCU3(CDTO.getNombre(),CDTO.getDeporte().getNombre(),""+CDTO.getModalidad().getNombre()));
				}
				}
			}
			
		});
		
		btnBuscar.setBounds(150, 288, 151, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCrearCompetencia = new JButton("Crear competencia");
		btnCrearCompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu004 ventana = new Cu004(id_usuario);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCrearCompetencia.setBounds(473, 288, 151, 23);
		contentPane.add(btnCrearCompetencia);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal ventana = new menuprincipal(id_usuario);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(340, 522, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}
	
}


class TestCU3 {
    private String nombreCompetencia, deporteAsociado,modalidad;
    public TestCU3(String nombreCompetencia, String deporteAsociado, String modalidad) {
        this.nombreCompetencia=nombreCompetencia;
        this.deporteAsociado=deporteAsociado;
        this.modalidad=modalidad;
    }
    public void setNombreCompetencia(String str) {
        nombreCompetencia = str;
    }
    public void setDeporteAsociado(String str) {
        deporteAsociado = str;
    }
    public void setModalidad(String str) {
    	modalidad = modalidad;
    }
    public String getnombreCompetencia() {
        return nombreCompetencia;
    }
    public String getdeporteAsociado() {
        return deporteAsociado;
    }
    public String getmodalidad() {
    	return modalidad;
    }
}


class TestModelCU3 extends DefaultTableModel {
    private static final ColumnContext[] COLUMN_ARRAY = {
        new ColumnContext("Nombre de Competencia",     String.class, true),
        new ColumnContext("Deporte Asociado",    String.class,  true),
        new ColumnContext("Modalidad", String.class, true),
        new ColumnContext("", String.class, true), 
        new ColumnContext("", String.class,  true)
    };
    public void addTest(TestCU3 t) {
        Object[] obj = {t.getnombreCompetencia(), t.getdeporteAsociado(),t.getmodalidad(),"",""};
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

class DeleteButtonCU3 extends JButton {
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setRolloverEnabled(false);
        setText("X");
    }
}
class DeleteButton2CU3 extends JButton {
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setRolloverEnabled(false);
        setText("Ver");
    }
}
class DeleteButtonRendererCU3 extends DeleteButtonCU3 implements TableCellRenderer {
    public DeleteButtonRendererCU3() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class DeleteButtonRenderer2CU3 extends DeleteButton2CU3 implements TableCellRenderer {
    public DeleteButtonRenderer2CU3() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class DeleteButtonEditorCU3 extends DeleteButtonCU3 implements TableCellEditor {
    public DeleteButtonEditorCU3(final JTable table, final ArrayList<CompetenciaDTO> listaCompetenciasEncontradas) {
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

class DeleteButtonEditor2CU3 extends DeleteButton2CU3 implements TableCellEditor {
    public DeleteButtonEditor2CU3(final JTable table, final ArrayList<CompetenciaDTO> listaCompetenciasEncontradas, final long id_usuario) {
        super();
        addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                fireEditingStopped();
                Cu020 ventana = new Cu020(listaCompetenciasEncontradas.get(row).getId_competencia(),id_usuario);
				ventana.setVisible(true);
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


