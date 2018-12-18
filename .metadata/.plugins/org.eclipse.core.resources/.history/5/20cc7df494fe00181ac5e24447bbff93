import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Showhistory = new JButton("HISTORY");
		Showhistory.setBounds(169, 138, 89, 87);
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormSearch search = new FormSearch();
				search.username = Username;
				search.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(440, 138, 89, 87);
		contentPane.add(btnNewButton_1);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnCancel = new JButton("CANCLE");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm a = new LoginForm();
				a.main(null);
				setVisible(false);
			}
		});
		btnCancel.setBounds(108, 11, 89, 23);
		contentPane.add(btnCancel);
	}
}
