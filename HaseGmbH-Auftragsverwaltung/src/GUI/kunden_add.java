package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class kunden_add {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kunden_add window = new kunden_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kunden_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 15, 555, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel k_title = new JLabel("Kunde");
		k_title.setFont(new Font("Tahoma", Font.BOLD, 28));
		k_title.setHorizontalTextPosition(SwingConstants.CENTER);
		k_title.setHorizontalAlignment(SwingConstants.CENTER);
		k_title.setBounds(10, 10, 114, 75);
		panel.add(k_title);
		
		JLabel k_id = new JLabel("Kunden ID:");
		k_id.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_id.setHorizontalAlignment(SwingConstants.RIGHT);
		k_id.setBounds(30, 95, 66, 28);
		panel.add(k_id);
		
		JLabel k_vorname = new JLabel("Vorname:");
		k_vorname.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_vorname.setHorizontalAlignment(SwingConstants.RIGHT);
		k_vorname.setBounds(20, 130, 76, 28);
		panel.add(k_vorname);
		
		JLabel k_nachname = new JLabel("Nachname:");
		k_nachname.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_nachname.setHorizontalAlignment(SwingConstants.RIGHT);
		k_nachname.setBounds(30, 165, 66, 28);
		panel.add(k_nachname);
		
		JLabel k_bday = new JLabel("Geburtstag:");
		k_bday.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_bday.setHorizontalAlignment(SwingConstants.RIGHT);
		k_bday.setBounds(234, 95, 76, 28);
		panel.add(k_bday);
		
		JLabel k_email = new JLabel("Email:");
		k_email.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_email.setHorizontalAlignment(SwingConstants.RIGHT);
		k_email.setBounds(244, 130, 66, 28);
		panel.add(k_email);
		
		JButton btnNewButton = new JButton("Zur\u00FCck");
		btnNewButton.setBounds(10, 304, 76, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Speichern");
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setBounds(451, 304, 94, 21);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 100, 96, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(115, 135, 96, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(115, 170, 96, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(320, 100, 96, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(320, 135, 96, 19);
		panel.add(textField_5);
		
		JLabel k_address = new JLabel("Adresse:");
		k_address.setHorizontalTextPosition(SwingConstants.RIGHT);
		k_address.setHorizontalAlignment(SwingConstants.RIGHT);
		k_address.setBounds(244, 165, 66, 28);
		panel.add(k_address);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(320, 170, 96, 19);
		panel.add(textField_6);
	}
}
