package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class login implements ActionListener {

	private JFrame frame;
	private JTextField txtFBenutzer;
	private JPasswordField pwdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 566, 343);
		frame.getContentPane().add(panel);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogin.setBounds(190, 35, 200, 100);
		panel.add(lblLogin);
		
		JLabel lblBenutzer = new JLabel("Benutzername:");
		lblBenutzer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBenutzer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBenutzer.setBounds(165, 145, 116, 20);
		panel.add(lblBenutzer);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasswort.setBounds(148, 186, 133, 20);
		panel.add(lblPasswort);
		
		txtFBenutzer = new JTextField();
		txtFBenutzer.setBounds(291, 145, 149, 22);
		panel.add(txtFBenutzer);
		txtFBenutzer.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(291, 184, 149, 22);
		panel.add(pwdField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(350, 226, 91, 21);
		panel.add(btnLogin);
		
		
		panel.setLayout(null);
		btnLogin.addActionListener(this); 


		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int length = pwdField.getPassword().length;
		if(txtFBenutzer.getText().isEmpty() || pwdField.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "One or both fields are empty");
		}else {
			startseite window = new startseite();
		startseite.newWindow();
		frame.setVisible(false);
		}
		
		
	}
}
