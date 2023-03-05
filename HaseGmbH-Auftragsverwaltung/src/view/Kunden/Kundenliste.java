package view.Kunden;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Customer;
import view.Startseite;

import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Extension.ButtonColumn;

public class Kundenliste {

	private JFrame frmKunden;
	String[] columnNames = { "Id", "Vorname", "Nachname", "E-mail", "Edit" };
	private JTable table;

	ImageIcon diceIcon = new ImageIcon(getClass().getResource("/image/nutzer-hinzufugen.png"));
	Image img = diceIcon.getImage() ;  
	   Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH );
	   Icon icon = new ImageIcon( newimg );

	/**
	 * Launch the application.
	 * 
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kundenliste window = new Kundenliste();
					window.frmKunden.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Kundenliste() {initialize();}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HaseGmbHManagement haseMgmtDriver =  HaseGmbHManagement.GET_INSTANCE();
		ArrayList<Customer> cListe = haseMgmtDriver.getAllCustomers();

		Object[][] data = new Object[cListe.size()][4];

		
		for (int i = 0; i < cListe.size(); i++) {

			data[i][0] = cListe.get(i).getCustomerID();
			data[i][1] = cListe.get(i).getFirstname();
			data[i][2] = cListe.get(i).getLastname();
			data[i][3] = cListe.get(i).getEmail();

		}

		frmKunden = new JFrame();
		frmKunden.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmKunden.setMinimumSize(new Dimension(1200, 400));
		frmKunden.setTitle("Auftragsverwaltung");
		frmKunden.setBounds(100, 100, 1200, 587);
		frmKunden.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKunden.getContentPane().setLayout(null);

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable( model );
		table.setRowSelectionAllowed(false);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(64, 357, 1034, 226);
		table.getColumnModel().getColumn(4).setMaxWidth(85);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(64, 260, 1034, 174);
		frmKunden.getContentPane().add(scrollPane);
		
		
		AbstractAction delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        List<String> selectedRow = ((DefaultTableModel)table.getModel()).getDataVector().get(modelRow);
		        KundenVerwaltung mv = new KundenVerwaltung(selectedRow);
		        mv.frame.setVisible(true);
		        frmKunden.setVisible(false);
		        
		    }
		};
		 
		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 4);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	

		JLabel lb_NewLabel = new JLabel("Kundenliste");
		lb_NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lb_NewLabel.setBounds(64, 139, 207, 70);
		frmKunden.getContentPane().add(lb_NewLabel);


		JButton btn_AddCustomer = new JButton(this.icon);
		btn_AddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_AddCustomer.setFocusTraversalKeysEnabled(false);
		btn_AddCustomer.setFocusPainted(false);
		btn_AddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundenVerwaltung mv = new KundenVerwaltung();
				mv.frame.setVisible(true);
				frmKunden.setVisible(false);
			}
		});
		btn_AddCustomer.setBounds(244, 156, 81, 52);
		frmKunden.getContentPane().add(btn_AddCustomer);

		JButton btn_back = new JButton("zur\u00FCck");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startseite window = new Startseite();
				Startseite.newWindow();
				frmKunden.setVisible(false);
			}
		});
		btn_back.setBounds(64, 465, 89, 36);
		frmKunden.getContentPane().add(btn_back);

	}

}
