package view.Mitarbeiter;

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
import de.oszimt.lf10aContractMgmt.model.Employee;
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

public class Mitarbeiterliste {

	private JFrame frmAuftragsverwaltung;
	String[] columnNames = { "Id", "Vorname", "Nachname", "Email", "Tel.Nr", "Edit" };
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
					Mitarbeiterliste window = new Mitarbeiterliste();
					window.frmAuftragsverwaltung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mitarbeiterliste() {initialize();}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HaseGmbHManagement haseMgmtDriver =  HaseGmbHManagement.GET_INSTANCE();
		ArrayList<Employee> mliste = haseMgmtDriver.employeeList;

		Object[][] data = new Object[mliste.size()][5];

		
		for (int i = 0; i < mliste.size(); i++) {

			data[i][0] = mliste.get(i).getEmployeeID();
			data[i][1] = mliste.get(i).getFirstname();
			data[i][2] = mliste.get(i).getLastname();
			data[i][3] = mliste.get(i).getEmail();
			data[i][4] = mliste.get(i).getTelephone();

		}

		frmAuftragsverwaltung = new JFrame();
		frmAuftragsverwaltung.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmAuftragsverwaltung.setMinimumSize(new Dimension(1200, 400));
		frmAuftragsverwaltung.setTitle("Auftragsverwaltung");
		frmAuftragsverwaltung.setBounds(100, 100, 1200, 587);
		frmAuftragsverwaltung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuftragsverwaltung.getContentPane().setLayout(null);

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable( model );
		table.setRowSelectionAllowed(false);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(64, 357, 1034, 226);
		table.getColumnModel().getColumn(5).setMaxWidth(85);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(64, 260, 1034, 174);
		frmAuftragsverwaltung.getContentPane().add(scrollPane);
		
		
		AbstractAction delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        List<String> selectedRow = ((DefaultTableModel)table.getModel()).getDataVector().get(modelRow);
		        MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung(selectedRow);
		        mv.frame.setVisible(true);
		        frmAuftragsverwaltung.setVisible(false);
		        
		    }
		};
		 
		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 5);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
	

		JLabel lb_NewLabel = new JLabel("Mitarbeiterliste");
		lb_NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lb_NewLabel.setBounds(64, 139, 207, 70);
		frmAuftragsverwaltung.getContentPane().add(lb_NewLabel);


		JButton btn_AddEmployee = new JButton(this.icon);
		btn_AddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_AddEmployee.setFocusTraversalKeysEnabled(false);
		btn_AddEmployee.setFocusPainted(false);
		btn_AddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
				mv.frame.setVisible(true);
				frmAuftragsverwaltung.setVisible(false);
			}
		});
		btn_AddEmployee.setBounds(281, 156, 81, 52);
		frmAuftragsverwaltung.getContentPane().add(btn_AddEmployee);

		JButton btn_back = new JButton("zur\u00FCck");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Startseite window = new Startseite();
				Startseite.newWindow();
				frmAuftragsverwaltung.setVisible(false);
			}
		});
		btn_back.setBounds(64, 465, 89, 36);
		frmAuftragsverwaltung.getContentPane().add(btn_back);

	}

}
