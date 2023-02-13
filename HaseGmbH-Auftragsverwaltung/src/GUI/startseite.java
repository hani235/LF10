package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class startseite {

	private JFrame frmStartseite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startseite window = new startseite();
					window.frmStartseite.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public startseite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartseite = new JFrame();
		frmStartseite.setMinimumSize(new Dimension(600, 400));
		frmStartseite.setTitle("Auftragsverwaltung");
		frmStartseite.setBounds(100, 100, 450, 300);
		frmStartseite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartseite.getContentPane().setLayout(null);
		
		JLabel ss_name = new JLabel("Startseite");
		ss_name.setHorizontalAlignment(SwingConstants.CENTER);
		ss_name.setFont(new Font("Tahoma", Font.BOLD, 30));
		ss_name.setBounds(190, 35, 200, 100);
		frmStartseite.getContentPane().add(ss_name);
		
		JButton btnKunden = new JButton("Kunden");
		btnKunden.setBounds(84, 188, 119, 54);
		frmStartseite.getContentPane().add(btnKunden);
		
		JButton btnAuftrag = new JButton("Auftr\u00E4ge");
		btnAuftrag.setBounds(228, 188, 119, 54);
		frmStartseite.getContentPane().add(btnAuftrag);
		
		JButton btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.setBounds(372, 188, 119, 54);
		frmStartseite.getContentPane().add(btnMitarbeiter);
	}
}
