package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DTO.CompetenciaDTO;
import DTO.ListaDeportesDTO;
import DTO.ListaParticipantesDTO;
import DTO.ParticipanteDTO;
import gestores.GestorCompetencias;
import gestores.GestorDeportes;
import igrafica.TestModelCU3.ColumnContext;

public class Cu008 extends JFrame {

	private JPanel contentPane;
	private TestModelCU8 model;
	private JTable table;
	private CompetenciaDTO competencia;
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu008 frame = new Cu008(1);
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
	public Cu008(long id_competencia) {
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoDeCompetencia = new JLabel("LISTADO DE COMPETENCIA");
		lblListadoDeCompetencia.setBounds(226, 34, 293, 14);
		lblListadoDeCompetencia.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblListadoDeCompetencia);
		
		JLabel lblCompetencia = new JLabel("Competencia");
		lblCompetencia.setBounds(57, 98, 68, 14);
		contentPane.add(lblCompetencia);
		
		JLabel lblCompe = new JLabel("");
		lblCompe.setBounds(181, 98, 46, 14);
		contentPane.add(lblCompe);
		
		JButton btnAgregarParticipante = new JButton("Agregar Participante");
		btnAgregarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu009 ventana = new Cu009(id_competencia);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnAgregarParticipante.setBounds(70, 359, 143, 23);
		contentPane.add(btnAgregarParticipante);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuprincipal ventana = new menuprincipal();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(335, 400, 89, 23);
		contentPane.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 146, 601, 159);
		contentPane.add(scrollPane);
		
		model = new TestModelCU8();
		table = new JTable(model);
	    
		
	    TableColumn column1 = table.getColumnModel().getColumn(2);
	    column1.setCellRenderer(new DeleteButtonRendererCU8());
	    column1.setCellEditor(new DeleteButtonEditorCU8(table));
	    column1.setMinWidth(20);
	    column1.setMaxWidth(20);
	    column1.setResizable(false);
	    
	    
	    TableColumn column2 = table.getColumnModel().getColumn(3);
	    column2.setCellRenderer(new DeleteButtonRendererCU8());
	    column2.setCellEditor(new DeleteButtonEditorCU8(table));
	    column2.setMinWidth(20);
	    column2.setMaxWidth(20);
	    column2.setResizable(false);
	    
	    table.getColumnModel().getColumn(0).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		competencia= GestorCompetencias.getCompetencia(id_competencia);
		
		for(ParticipanteDTO PDTO : competencia.getParticipantes()){
			/*System.out.println(CDTO.getNombre());
			System.out.println(CDTO.getDeporte());
			System.out.println(CDTO.getModalidad());
			System.out.println(CDTO.getEstado());*/
			//model.addTest(new TestCU3(CDTO.getNombre(),CDTO.getDeporte().getNombre(),""+CDTO.getModalidad().getId_modalidad()));
			model.addTest(new TestCU8(PDTO.getNombre(),PDTO.getEmail(),PDTO.getImagen()));
		}
		
		lblCompe.setText(competencia.getNombre());
		
		
	}

}

class TestCU8 {
    private String nombreEquipo,email;
    private Image imagen;
    
    public TestCU8(String nombreEquipo, String email ,byte[] imagen) {
        this.nombreEquipo=nombreEquipo;
        this.email=email;
        try {
        /*
        InputStream in = new ByteArrayInputStream(imagen);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, "jpg", new File("C:/Users/Fran/workspace/as/imagenCreada.jpg"));*/
        
        File newFile= new File("C:\\images\\destino\\imgTest-"+System.currentTimeMillis()+".jpg");
        //BufferedImage imag=ImageIO.read(new ByteArrayInputStream(imagen));
        //ImageIO.write(imag, "jpg", newFile);
        Image image = ImageIO.read(newFile);
        this.imagen=image;
    } catch (IOException e){

        e.printStackTrace();
    }
        
		
    }
    public void setNombreEquipo(String str) {
        nombreEquipo = str;
    }
    public void setEmail(String str) {
        email = str;
    }
    
    public String getnombreEquipo() {
        return nombreEquipo;
    }
    public String getEmail() {
        return email;
    }
    public void setImagen(Image str){
    	imagen=str;
    }
    public Image getImagen(){
    	return imagen;
    }
}


class TestModelCU8 extends DefaultTableModel {
    private static final ColumnContext[] COLUMN_ARRAY = {
        new ColumnContext("Nombre de Equipo o Participante",     String.class, true),
        new ColumnContext("Email",    String.class,  true),
        new ColumnContext("Imagen", Image.class, true),
        new ColumnContext("Eliminar Participante", String.class, true), 
        new ColumnContext("Modificar Participante", String.class,  true)
    };
    public void addTest(TestCU8 t) {
        Object[] obj = {t.getnombreEquipo(), t.getEmail(),"",""};
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

class DeleteButtonCU8 extends JButton {
    @Override public void updateUI() {
        super.updateUI();
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
        setRolloverEnabled(false);
        setText("Eliminar Participante");
    }
}

class DeleteButtonRendererCU8 extends DeleteButtonCU8 implements TableCellRenderer {
    public DeleteButtonRendererCU8() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

class DeleteButtonEditorCU8 extends DeleteButtonCU8 implements TableCellEditor {
    public DeleteButtonEditorCU8(final JTable table) {
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

