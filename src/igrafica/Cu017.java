package igrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.CompetenciaDTO;
import gestores.GestorCompetencias;
import javax.swing.JLabel;
import java.awt.Font;

public class Cu017 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CompetenciaDTO compe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cu017 dialog = new Cu017((long) 1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cu017(final long id_competencia) {
		//BUSCAMOS LA COMPETENCIA
		compe = GestorCompetencias.getCompetencia(id_competencia);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lbldeseaGenerarUn = new JLabel("¿Desea generar un nuevo fixture?");
			lbldeseaGenerarUn.setFont(new Font("Dialog", Font.BOLD, 20));
			contentPanel.add(lbldeseaGenerarUn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				//okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GestorCompetencias.generarFixture(id_competencia);
						Cu020 caso20 = new Cu020(id_competencia);
						caso20.setVisible(true);
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent p) {
						Cu020 caso20 = new Cu020(id_competencia);
						caso20.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
