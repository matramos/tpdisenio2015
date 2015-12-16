package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DTO.CompetenciaDTO;
import DTO.EncuentroDTO;
import DTO.RondaDTO;
import gestores.GestorCompetencias;
import igrafica.TestModel.ColumnContext;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;

public class Cu019 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TestModelCU19 model;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu019 frame = new Cu019((long )92, (long)1);
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
	public Cu019(final long id_competencia, final long id_usuario) {
		CompetenciaDTO competencia = GestorCompetencias.getCompetencia(id_competencia);
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFixture = new JLabel("FIXTURE");
		lblFixture.setBounds(357, 26, 126, 14);
		lblFixture.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblFixture);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(226, 67, 46, 14);
		contentPane.add(lblFecha);
		
		JComboBox comboFecha = new JComboBox();
		comboFecha.setBounds(271, 64, 116, 20);
		contentPane.add(comboFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 118, 564, 186);
		contentPane.add(scrollPane);
		
		model = new TestModelCU19();
		String columnHeaders[]={"Ronda","idronda","Encuentro","P1","P2",""};
		table = new JTable(model);
        
        TableColumn column = table.getColumnModel().getColumn(5);
        column.setCellRenderer(new DeleteButtonRendererCU19());
        column.setCellEditor(new DeleteButtonEditorCU19(table,competencia.getRondas(),id_competencia,id_usuario));
        column.setPreferredWidth(80);
        column.setResizable(false);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);

		

		scrollPane.setViewportView(table);
		
		for(RondaDTO ronda: competencia.getRondas()){
			for(EncuentroDTO encuentro: ronda.getEncuentros()){
				
				model.addTest(new TestCU19(ronda.getNumeroRonda(),ronda.getId_ronda(),encuentro.getId_encuentro(),encuentro.getJugador1().getNombre(),encuentro.getJugador2().getNombre()));
			}
		}


		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cu020 cu = new Cu020(id_competencia,id_usuario);
				cu.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(357, 381, 89, 23);
		contentPane.add(btnSalir);
	}
}


class TestCU19{
    private String p1,p2;
    private int name;
    private long comment, idronda;
    public TestCU19(int name, long idronda,long comment, String p1, String p2) {
        this.name = name;
        this.comment = comment;
        this.p1 = p1;
        this.p2 = p2;
        this.idronda = idronda;
    }
    
    
    public long getIdronda() {
		return idronda;
	}


	public void setIdronda(long idronda) {
		this.idronda = idronda;
	}


	public String getP1() {
		return p1;
	}


	public void setP1(String p1) {
		this.p1 = p1;
	}


	public String getP2() {
		return p2;
	}


	public void setP2(String p2) {
		this.p2 = p2;
	}


	public void setName(int str) {
        name = str;
    }
    public void setComment(long str) {
        comment = str;
    }
    public int getName() {
        return name;
    }
    public long getComment() {
        return comment;
    }
}

// class model
class TestModelCU19 extends DefaultTableModel {
    private static final ColumnContext[] COLUMN_ARRAY = {
        new ColumnContext("Ronda",     String.class, true),
        new ColumnContext("IDRonda",     String.class, true),
        new ColumnContext("Encuentro",    String.class,  true),
        new ColumnContext("P1",    String.class,  true),
        new ColumnContext("P2",    String.class,  true),
        new ColumnContext("", String.class,  true),
    };
    public void addTest(TestCU19 testCU19) {
        Object[] obj = {testCU19.getName(), testCU19.getIdronda(), testCU19.getComment(),testCU19.getP1(),testCU19.getP2(), ""};
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


class ButtonRendererCU19 extends JButton implements TableCellRenderer{

	public ButtonRendererCU19(){
			
		}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object objeto, boolean seleccionado, boolean focused, int fila,
			int columna) {
		// TODO Auto-generated method stub
		setText((objeto==null) ? "":objeto.toString());
		return this;
	}

}

class ButtonEditorCU19 extends DefaultCellEditor{
	protected JButton btn;
	private String lbl;
	private Boolean clicked;
	public ButtonEditorCU19(JTextField txt) {
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
class DeleteButtonCU19 extends JButton {
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setRolloverEnabled(false);
        setText("Modificar resultado");
    }
}

class DeleteButtonRendererCU19 extends DeleteButtonCU19 implements TableCellRenderer {
    public DeleteButtonRendererCU19() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class DeleteButtonEditorCU19 extends DeleteButtonCU19 implements TableCellEditor {
    public DeleteButtonEditorCU19(final JTable table, final List<RondaDTO> rondas, final long id_competencia, final long id_usuario) {
        super();
        addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                fireEditingStopped();
                System.out.println(table.getValueAt(row, 1));
                Cu018 cu = new Cu018(id_competencia,(long) table.getValueAt(row, 1),(long)table.getValueAt(row, 2),id_usuario);
				cu.setVisible(true);
				//((DefaultTableModel) table.getModel()).removeRow(row);
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