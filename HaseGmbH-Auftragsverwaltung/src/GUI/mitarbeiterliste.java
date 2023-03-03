package GUI;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Employee;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class mitarbeiterliste {

	private JFrame frmAuftragsverwaltung;
	private JTextField tx_filter;
	String[] columnNames = {
			"Id",
			"Vorname",
			"Nachname",
            "Email",
            "Tel.Nr"
	};
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mitarbeiterliste window = new mitarbeiterliste();
					window.frmAuftragsverwaltung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mitarbeiterliste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HaseGmbHManagement haseMgmtDriver = new HaseGmbHManagement();
		ArrayList<Employee> mliste = haseMgmtDriver.getAllEmployees();
		
		Object[][] data = new Object[mliste.size()][5];
		
		for(int i = 0; i < mliste.size(); i++) {
			
			data[i][0] = mliste.get(i).getEmployeeID();
			data[i][1] = mliste.get(i).getFirstname();
			data[i][2] = mliste.get(i).getLastname();
			data[i][3] = mliste.get(i).getEmail();
			data[i][4] = mliste.get(i).getTelephone();
				 
		}
		
		
		frmAuftragsverwaltung = new JFrame();
		frmAuftragsverwaltung.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmAuftragsverwaltung.setMinimumSize(new Dimension(1200, 800));
		frmAuftragsverwaltung.setTitle("Auftragsverwaltung");
		frmAuftragsverwaltung.setBounds(100, 100, 450, 300);
		frmAuftragsverwaltung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuftragsverwaltung.getContentPane().setLayout(null);
		
		
		
		
		
		table = new JTable( data, this.columnNames);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBounds(64, 357, 1034, 230);
		frmAuftragsverwaltung.getContentPane().add(table);
		
		JLabel lb_NewLabel = new JLabel("Mitarbeiterliste");
		lb_NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lb_NewLabel.setBounds(64, 139, 207, 70);
		frmAuftragsverwaltung.getContentPane().add(lb_NewLabel);
		
		JButton btn_AddEmployee = new JButton("+");
		btn_AddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_AddEmployee.setFocusTraversalKeysEnabled(false);
		btn_AddEmployee.setFocusPainted(false);
		btn_AddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_AddEmployee.setBounds(281, 156, 81, 52);
		frmAuftragsverwaltung.getContentPane().add(btn_AddEmployee);
		
		JLabel lb_filter = new JLabel("Filtern nach Mitarbeiter Namen: ");
		lb_filter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_filter.setBounds(64, 255, 238, 14);
		frmAuftragsverwaltung.getContentPane().add(lb_filter);
		
		tx_filter = new JTextField();
		tx_filter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tx_filter.setBounds(281, 245, 201, 36);
		frmAuftragsverwaltung.getContentPane().add(tx_filter);
		tx_filter.setColumns(10);
		
		JButton btn_back = new JButton("zur\u00FCck");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startseite window = new startseite();
				startseite.newWindow();
				frmAuftragsverwaltung.setVisible(false);
			}
		});
		btn_back.setBounds(64, 672, 89, 36);
		frmAuftragsverwaltung.getContentPane().add(btn_back);
		
		JLabel lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(64, 321, 207, 36);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vorname");
		lblNewLabel_1.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(271, 321, 207, 36);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nachname\r\n");
		lblNewLabel_2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(476, 321, 209, 36);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(684, 321, 208, 36);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel");
		lblNewLabel_4.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(891, 321, 207, 36);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_4);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
