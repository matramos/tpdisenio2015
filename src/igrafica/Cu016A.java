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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cu016A extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cu016A dialog = new Cu016A();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cu016A() {
		setTitle("Gevico");
		setBounds(100, 100, 600, 250);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDarDeBaja = new JLabel("DAR DE BAJA LUGAR DE REALIZACION");
		lblDarDeBaja.setBounds(92, 25, 377, 14);
		lblDarDeBaja.setFont(new Font("Arial",Font.BOLD,18));
		contentPanel.add(lblDarDeBaja);
		{
			JLabel lblLosDatosDel = new JLabel("Los datos del lugar de realizaci\u00F3n");
			lblLosDatosDel.setBounds(63, 76, 170, 14);
			contentPanel.add(lblLosDatosDel);
		}
		{
			JLabel lblNombreLugarDe = new JLabel("Nombre lugar de realizacion");
			lblNombreLugarDe.setBounds(241, 76, 142, 14);
			contentPanel.add(lblNombreLugarDe);
		}
		{
			JLabel lblSeranDadoDe = new JLabel("seran dado de baja.");
			lblSeranDadoDe.setBounds(397, 76, 125, 14);
			contentPanel.add(lblSeranDadoDe);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
