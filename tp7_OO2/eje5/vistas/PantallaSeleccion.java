package vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaSeleccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaSeleccion frame = new PantallaSeleccion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaSeleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 30, 189, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(224, 30, 179, 22);
		contentPane.add(comboBox_1);

		JButton btnNewButton = new JButton("Confirmar Compra");
		btnNewButton.setBounds(148, 227, 158, 23);
		contentPane.add(btnNewButton);
	}
}
