package domain.model;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AgregarParticipante {

	private Connection dbConn;
	 private JTextField nombre;
	 private JTextField telefono;
	 private JTextField region;
	 
	 public AgregarParticipante() throws SQLException {
		 setupBaseDeDatos();
		 setupUIComponents();
	 }
	
	 private boolean validarTelefono(String telefono) {
		 String regex = "\\d{4}-\\d{6}";
		 return telefono.matches(regex);
	}


}
