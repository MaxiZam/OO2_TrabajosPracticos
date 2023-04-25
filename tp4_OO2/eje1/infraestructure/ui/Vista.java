package infraestructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.portsin.UI;

public class Vista extends JFrame implements UI {

	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;

	public void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onBotonCargar();
				} catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() throws SQLException {
		if (nombre.getText().equals("")) {
			JOptionPane.showMessageDialog(nombre, this, "Debe cargar un nombre", 0);
			return;
		}
		if (telefono.getText().equals("")) {
			JOptionPane.showMessageDialog(nombre, this, "Debe cargar un telefono", 0);
			return;
		}
		if (!validarTelefono(telefono.getText())) {
			JOptionPane.showMessageDialog(nombre, this,
					"El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN", 0);
			return;
		}
		if (!region.getText().equals("China") && !region.getText().equals("US") && !region.getText().equals("Europa")) {
			JOptionPane.showMessageDialog(nombre, this, "Region desconocida. Las conocidas son: China, US, Europa", 0);
			return;
		}

		dispose();
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	@Override
	public String[] obtenerDatosParticipante() {
		String[] datosParticipante = null;
		datosParticipante[0] = nombre.getText();
		datosParticipante[1] = telefono.getText();
		datosParticipante[2] = region.getText();
		return datosParticipante;
	}
}
