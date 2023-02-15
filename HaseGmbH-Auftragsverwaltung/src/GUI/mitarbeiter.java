package GUI;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mitarbeiter {

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
	public static void newMWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mitarbeiter window = new mitarbeiter();
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
	public mitarbeiter() {
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
		
		JLabel m_title = new JLabel("Mitarbeiter");
		m_title.setFont(new Font("Tahoma", Font.BOLD, 28));
		m_title.setHorizontalTextPosition(SwingConstants.CENTER);
		m_title.setHorizontalAlignment(SwingConstants.CENTER);
		m_title.setBounds(10, 10, 188, 75);
		panel.add(m_title);
		
		JLabel m_id = new JLabel("Mitarbeiter ID:");
		m_id.setHorizontalTextPosition(SwingConstants.RIGHT);
		m_id.setHorizontalAlignment(SwingConstants.RIGHT);
		m_id.setBounds(30, 95, 66, 28);
		panel.add(m_id);
		
		JLabel m_vorname = new JLabel("Vorname:");
		m_vorname.setHorizontalTextPosition(SwingConstants.RIGHT);
		m_vorname.setHorizontalAlignment(SwingConstants.RIGHT);
		m_vorname.setBounds(20, 130, 76, 28);
		panel.add(m_vorname);
		
		JLabel m_nachname = new JLabel("Nachname:");
		m_nachname.setHorizontalTextPosition(SwingConstants.RIGHT);
		m_nachname.setHorizontalAlignment(SwingConstants.RIGHT);
		m_nachname.setBounds(30, 165, 66, 28);
		panel.add(m_nachname);
		
		JLabel m_tel = new JLabel("Telefon Nr:");
		m_tel.setHorizontalTextPosition(SwingConstants.RIGHT);
		m_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		m_tel.setBounds(234, 95, 76, 28);
		panel.add(m_tel);
		
		JLabel m_email = new JLabel("Email:");
		m_email.setHorizontalTextPosition(SwingConstants.RIGHT);
		m_email.setHorizontalAlignment(SwingConstants.RIGHT);
		m_email.setBounds(244, 130, 66, 28);
		panel.add(m_email);
		
		JButton btnZuruck = new JButton("Zur\u00FCck");
		btnZuruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mitarbeiterliste marbeiterl = new mitarbeiterliste();
				marbeiterl.newMLWindow();
			}
		});
		btnZuruck.setBounds(10, 304, 76, 21);
		panel.add(btnZuruck);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSpeichern.setBounds(451, 304, 94, 21);
		panel.add(btnSpeichern);
		
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
