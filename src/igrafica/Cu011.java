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

public class Cu011 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cu011 dialog = new Cu011();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cu011() {
		setTitle("Gevico");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDarDeBaja = new JLabel("DAR DE BAJA PARTICIPANTE");
			lblDarDeBaja.setBounds(75, 35, 274, 14);
			lblDarDeBaja.setFont(new Font("Arial",Font.BOLD,18));
			contentPanel.add(lblDarDeBaja);
		}
		{
			JLabel lbldeseaDarDe = new JLabel("\u00BFDesea dar de baja el");
			lbldeseaDarDe.setBounds(47, 97, 113, 14);
			contentPanel.add(lbldeseaDarDe);
		}
		{
			JLabel lblParticipante = new JLabel("participante");
			lblParticipante.setBounds(158, 97, 57, 14);
			contentPanel.add(lblParticipante);
		}
		{
			JLabel label = new JLabel("?");
			label.setBounds(227, 97, 46, 14);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton aceptarButton = new JButton("Aceptar");
				aceptarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				aceptarButton.setActionCommand("OK");
				buttonPane.add(aceptarButton);
				getRootPane().setDefaultButton(aceptarButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
	}

}
