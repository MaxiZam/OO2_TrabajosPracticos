package infraestructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.model.AdministrarParticipantes;
import domain.portsin.View;

public class RegistrarParticipanteView extends JFrame implements View {

	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private AdministrarParticipantes admin;

	public RegistrarParticipanteView(AdministrarParticipantes admin) {
		this.admin = admin;
		setupUIComponents();
	}

	public void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField nombreField = new JTextField(10);
		JTextField telefonoField = new JTextField(10);
		JTextField regionField = new JTextField(10);
		nombreField.setText("");
		telefonoField.setText("");
		regionField.setText("China");

		JLabel nombreLabel = new JLabel("Nombre: ");
		JLabel telefonoLabel = new JLabel("Telefono: ");
		JLabel regionLabel = new JLabel("Region: ");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(nombreLabel);
		contentPane.add(nombreField);
		contentPane.add(telefonoLabel);
		contentPane.add(telefonoField);
		contentPane.add(regionLabel);
		contentPane.add(regionField);

		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(e -> {
			try {
				String nombre = nombreField.getText();
				String telefono = telefonoField.getText();
				String region = regionField.getText();

				admin.agregarParticipante(nombre, telefono, region);

				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error al cargar el participante");
			}
		});
		contentPane.add(botonCargar);

		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

//	@Override
//	public String[] obtenerDatosParticipante() {
//		String[] datosParticipante = null;
//		datosParticipante[0] = nombre.getText();
//		datosParticipante[1] = telefono.getText();
//		datosParticipante[2] = region.getText();
//		return datosParticipante;
//	}
}
