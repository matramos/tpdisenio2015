package igrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import DTO.CompetenciaDTO;
import DTO.ParticipanteDTO;
import gestores.GestorCompetencias;
import net.miginfocom.swing.MigLayout;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class Cu009 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txturl;
	private CompetenciaDTO competencia;
	private Clip clip;
    private String ruta="/audio/";
    private byte[] imageInByte;
    private JLabel lblImagen;
    private Image mostrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cu009 frame = new Cu009(1,1, false);
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
	 * @param desdeEl4 
	 */
	public Cu009(final long id_competencia,final long id_usuario, final boolean desdeEl4) {
		
		
		competencia= (CompetenciaDTO) GestorCompetencias.getCompetencia(id_competencia);
		
		
		
		// codigo para agregar imagen por exploracion 
		
		JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Imagen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(panel, BorderLayout.WEST);
        panel.setLayout(new MigLayout("", "[70px,center]", "[grow][][][grow]"));
       
        lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon("res/img/etc/noImage.png"));
        panel.add(lblImagen, "cell 0 1,alignx left,aligny top");
       
		setTitle("Gevico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image img = new ImageIcon(this.getClass().getResource("/silueta.gif")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblInscribirParticipante = new JLabel("INSCRIBIR PARTICIPANTE");
		lblInscribirParticipante.setBounds(248, 30, 257, 14);
		lblInscribirParticipante.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(lblInscribirParticipante);
		
		JLabel lblNombrecompetencia = new JLabel("nombreCompetencia");
		lblNombrecompetencia.setBounds(116, 84, 182, 14);
		contentPane.add(lblNombrecompetencia);
		lblNombrecompetencia.setText(competencia.getNombre());
		JLabel lblCompetencia = new JLabel("Competencia:");
		lblCompetencia.setBounds(28, 84, 78, 14);
		contentPane.add(lblCompetencia);
		
		final JLabel lblNombreDelParticipante = new JLabel("Nombre del Participante o Equipo:");
		lblNombreDelParticipante.setBounds(92, 122, 227, 14);
		contentPane.add(lblNombreDelParticipante);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 147, 161, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(90, 192, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(92, 217, 159, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblImagenopcional = new JLabel("Imagen(opcional):");
		lblImagenopcional.setBounds(92, 258, 148, 14);
		contentPane.add(lblImagenopcional);
		
		
		
		final JLabel lblimagen = new JLabel("");
		lblimagen.setBounds(92, 283, 148, 111);
		contentPane.add(lblimagen);
		lblimagen.setIcon(new ImageIcon(img));
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileFilter filtro = new FileFilter() {
        			public boolean accept(File f) {
        				if(f !=null &&
        						(f.getName().toLowerCase().endsWith("png") ||
        						f.getName().toLowerCase().endsWith("jpg") ||
        						f.isDirectory()))
        					return true;
        				else
        					return false;
        			}
        			
        			public String getDescription() {
        				return "Archivos de imagen";
        			}
        		};
        		JFileChooser fileChooser = new JFileChooser();
        		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        		fileChooser.setAcceptAllFileFilterUsed(false);
        		fileChooser.setFileFilter(filtro);
        		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        			ImageIcon icono = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
        			Image newimg = icono.getImage().getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);  
        			icono = new ImageIcon(newimg);
        			mostrar = newimg;
        			lblimagen.setIcon(new ImageIcon(mostrar));
        			lblImagen.setIcon(icono);
        		}
        	
				
			}
		});
	       
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new MigLayout("", "[grow,right]", "[]"));
        
		btnIngresar.setBounds(117, 425, 89, 23);
		contentPane.add(btnIngresar);

		final JLabel lblIngreseNombre = new JLabel("Ingrese el nombre");
		lblIngreseNombre.setBounds(92, 167, 179, 14);
		lblIngreseNombre.setForeground(Color.red);
		lblIngreseNombre.setVisible(false);
		contentPane.add(lblIngreseNombre);
		
		final JLabel lblYaExiste = new JLabel("El nombre elegido ya existe");
		lblYaExiste.setBounds(92, 167, 179, 14);
		lblYaExiste.setForeground(Color.red);
		lblYaExiste.setVisible(false);
		contentPane.add(lblYaExiste);
		
		final JLabel lblIngreseEmail = new JLabel("Ingrese el email");
		lblIngreseEmail.setBounds(92, 236, 179, 14);
		lblIngreseEmail.setForeground(Color.red);
		lblIngreseEmail.setVisible(false);
		contentPane.add(lblIngreseEmail);
		
		final JLabel lblEmailYaExiste = new JLabel("El email ingresado est� vinculado a otro participante");
		lblEmailYaExiste.setBounds(92, 236, 344, 14);
		lblEmailYaExiste.setForeground(Color.red);
		lblEmailYaExiste.setVisible(false);
		contentPane.add(lblEmailYaExiste);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(competencia.getEstado().getNombre().equals("creada") || competencia.getEstado().getNombre().equals("planificada"))){
					JOptionPane.showMessageDialog(null, "La competencia no se encuentra en estado creada o planificada");
					Cu008 ventana = new Cu008(id_competencia, id_usuario, desdeEl4);
					ventana.setVisible(true);
					dispose();
				}
				else{
					boolean noExistemail = GestorCompetencias.validarMail(txtEmail.getText(),id_competencia);
					boolean noExistenombre = GestorCompetencias.validarNombreP(txtNombre.getText(),id_competencia);
					ParticipanteDTO participanteDTO = new ParticipanteDTO();
				if(txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || !noExistemail || !noExistenombre){
					if(txtNombre.getText().isEmpty()){
						lblIngreseNombre.setVisible(true);
						sonido("error");
					}
					else{
						lblIngreseNombre.setVisible(false);
					}
					if(txtEmail.getText().isEmpty()){
						lblIngreseEmail.setVisible(true);
						sonido("error");
					}
					else{
						lblIngreseEmail.setVisible(false);
					}
					if(!noExistemail){
						lblEmailYaExiste.setVisible(true);
						sonido("error");
					}
					else{
						lblEmailYaExiste.setVisible(false);
					}
					if(!noExistenombre){
						lblYaExiste.setVisible(true);
						sonido("error");
					}
					else{
						lblYaExiste.setVisible(false);
					}
				}
				else{
					try {
						BufferedImage originalImage = ImageIO.read(new File("lblImagen"));

						// convert BufferedImage to byte array
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(originalImage, "jpg", baos);
						baos.flush();
						imageInByte = baos.toByteArray();
						baos.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					
					participanteDTO.setNombre(txtNombre.getText());
					participanteDTO.setEmail(txtEmail.getText());
					participanteDTO.imagen = imageInByte;
			
					if(id_competencia==GestorCompetencias.agregarParticipante(participanteDTO,id_competencia)){
						if(competencia.getEstado().getId_estado() == 1){
							JOptionPane.showMessageDialog(null, "La operaci�n ha culminado con �xito");
							Cu008 ventana = new Cu008(id_competencia,id_usuario, desdeEl4);
							ventana.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "La operaci�n ha culminado con �xito y"
									+ " el fixture ha sido eliminado.");
							Cu008 ventana = new Cu008(id_competencia,id_usuario, desdeEl4);
							ventana.setVisible(true);
							dispose();
						}

					}
				}
			
			}
			}});
		
		btnAceptar.setBounds(260, 511, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cu008 ventana = new Cu008(id_competencia,id_usuario, desdeEl4);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(402, 511, 89, 23);
		contentPane.add(btnCancelar);
		
		
		}
}
