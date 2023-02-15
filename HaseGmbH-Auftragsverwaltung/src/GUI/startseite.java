package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class startseite {

	private JFrame frmStartseite;

	/**
	 * Launch the application.
	 */
	public static void newSWindow() {
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
		
		JButton btnKunden = new JButton(new AbstractAction("Kunden") {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//kundenliste kwindow = new kundenliste();
				//kwindow.newKLWindow();
				}
			}); 
			
		btnKunden.setBounds(84, 188, 119, 54);
		frmStartseite.getContentPane().add(btnKunden);
		
		JButton btnAuftrag = new JButton(new AbstractAction("Auftr\u00E4ge") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnAuftrag.setBounds(228, 188, 119, 54);
		frmStartseite.getContentPane().add(btnAuftrag);
		
		JButton btnMitarbeiter = new JButton(new AbstractAction("Mitarbeiter") {

			@Override
			public void actionPerformed(ActionEvent e) {
				mitarbeiterliste mwindow = new mitarbeiterliste();
				mwindow.newMLWindow();
				
			}
			
		});
		btnMitarbeiter.setBounds(372, 188, 119, 54);
		frmStartseite.getContentPane().add(btnMitarbeiter);
		
		
		
	}

	

	/*@Override
	public void actionPerformed(ActionEvent e) {
		mitarbeiterliste mwindow = new mitarbeiterliste();
		mwindow.newMLWindow();
		
		
		
	}*/
}
