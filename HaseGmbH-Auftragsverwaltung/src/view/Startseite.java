package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import view.Kunden.Kundenliste;
import view.Mitarbeiter.Mitarbeiterliste;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Startseite {

	private JFrame frmStartseite;
	
	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startseite window = new Startseite();
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
	public Startseite() {
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
		btnKunden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Kundenliste kl = new Kundenliste();
				kl.main(null);
				frmStartseite.setVisible(false);
			}
		});
		btnKunden.setBounds(84, 188, 119, 54);
		frmStartseite.getContentPane().add(btnKunden);
		
		JButton btnAuftrag = new JButton("Auftr\u00E4ge");
		btnAuftrag.setBounds(228, 188, 119, 54);
		frmStartseite.getContentPane().add(btnAuftrag);
		
		JButton btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				Mitarbeiterliste ma = new Mitarbeiterliste();
				ma.main(null);
				frmStartseite.setVisible(false);
				
			}
		});
		btnMitarbeiter.setBounds(372, 188, 119, 54);
		frmStartseite.getContentPane().add(btnMitarbeiter);


	}
}
