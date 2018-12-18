import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class HomeClientForm extends JFrame {

	private JPanel contentPane;
    public String Username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeClientForm frame = new HomeClientForm();
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
	public HomeClientForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Showhistory = new JButton("HISTORY");
		Showhistory.setBackground(new Color(153, 102, 51));
		Showhistory.setForeground(new Color(255, 255, 255));
		Showhistory.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		Showhistory.setBounds(205, 235, 169, 87);
		contentPane.add(Showhistory);
		Showhistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HistoryBookingForm historybooking = new HistoryBookingForm();
				
				historybooking.username = Username;
				
				historybooking.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("BOOKING");
		btnNewButton_1.setBackground(new Color(153, 102, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormSearch search = new FormSearch();
				search.username = Username;
				search.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(476, 235, 169, 87);
		contentPane.add(btnNewButton_1);
		
		JButton btnCancel = new JButton("LOGOUT");
		btnCancel.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		btnCancel.setBackground(new Color(204, 153, 102));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm a = new LoginForm();
				a.main(null);
				setVisible(false);
			}
		});
		btnCancel.setBounds(12, 13, 89, 23);
		contentPane.add(btnCancel);
	}
}
