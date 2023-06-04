package infraestructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.model.AdministrarParticipantes;

public class RegistrarParticipanteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private AdministrarParticipantes admin;

	public RegistrarParticipanteView(AdministrarParticipantes admin) {
		this.admin = admin;
		setupUIComponents();
	}

	public void setupUIComponents() {
		setTitle("Add Participant");
		setSize(467, 82);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField nombreField = new JTextField(10);
		JTextField mailField = new JTextField(10);
		nombreField.setText("");
		mailField.setText("");

		JLabel nombreLabel = new JLabel("Nombre: ");
		JLabel mailLabel = new JLabel("Mail: ");
		JLabel regionLabel = new JLabel("Region: ");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(nombreLabel);
		contentPane.add(nombreField);
		contentPane.add(mailLabel);
		contentPane.add(mailField);
		contentPane.add(regionLabel);

		JComboBox regionBox = new JComboBox();
		regionBox.addItem("China");
		regionBox.addItem("USA");
		regionBox.addItem("Europa");
		contentPane.add(regionBox);

		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(e -> {
			try {
				String nombre = nombreField.getText();
				String mail = mailField.getText();
				String region = regionBox.getSelectedItem().toString();

				admin.agregarParticipante(nombre, mail, region);

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
}
