package igrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Cu016C extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cu016C dialog = new Cu016C();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cu016C() {
		setTitle("Gevico");
		setBounds(100, 100, 600, 250);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDarDeBaja = new JLabel("DAR DE BAJA LUGAR DE REALIZACI\u00D3N");
			lblDarDeBaja.setBounds(122, 26, 370, 14);
			lblDarDeBaja.setFont(new Font("Arial",Font.BOLD,18));
			contentPanel.add(lblDarDeBaja);
		}
		{
			JLabel lblLosDatosDel = new JLabel("Los datos del lugar de realizaci\u00F3n");
			lblLosDatosDel.setBounds(10, 65, 191, 14);
			contentPanel.add(lblLosDatosDel);
		}
		{
			JLabel lblNombreLugar = new JLabel("nombre lugar");
			lblNombreLugar.setBounds(211, 65, 153, 14);
			contentPanel.add(lblNombreLugar);
		}
		{
			JLabel lblEstaSiendoUsado = new JLabel("esta siendo usado en las siguientes competencias:");
			lblEstaSiendoUsado.setBounds(322, 65, 262, 14);
			contentPanel.add(lblEstaSiendoUsado);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 90, 231, 59);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Competencias"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continuar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
