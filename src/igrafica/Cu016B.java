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

public class Cu016B extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cu016B dialog = new Cu016B();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cu016B() {
		setTitle("Gevico");
		setBounds(100, 100, 600, 250);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDarDeBaja = new JLabel("DAR DE BAJA LUGAR DE REALIZACI\u00D3N");
			lblDarDeBaja.setBounds(99, 34, 377, 14);
			lblDarDeBaja.setFont(new Font("Arial",Font.BOLD,18));
			contentPanel.add(lblDarDeBaja);
		}
		{
			JLabel lblLosDatosDe = new JLabel("Los datos de lugar de realizaci\u00F3n");
			lblLosDatosDe.setBounds(10, 89, 164, 14);
			contentPanel.add(lblLosDatosDe);
		}
		{
			JLabel lblNombreLugar = new JLabel("nombre lugar ");
			lblNombreLugar.setBounds(184, 89, 72, 14);
			contentPanel.add(lblNombreLugar);
		}
		{
			JLabel lblHanSidoEliminado = new JLabel("han sido eliminado del sistema.");
			lblHanSidoEliminado.setBounds(255, 89, 169, 14);
			contentPanel.add(lblHanSidoEliminado);
		}
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
