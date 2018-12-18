import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ConfirmStatus {

	public JFrame frame;
	private JTable table;
	String roomNumber = "";
	String size = "";
	String userName = "";
	String dateOld = "";
	String timeStartOld = "";
	String timeEndOld = "";
	String dateNew = "";
	String timeStartNew = "";
	String timeEndNew = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmStatus window = new ConfirmStatus();
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
	public ConfirmStatus() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_R) {
					System.out.println("fuck");
					showTable();
				}
			}
		});
		frame.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				showTable();
			}
			@Override
			public void focusLost(FocusEvent e) {
				showTable();
			}
		});
		frame.getContentPane().setBackground(new Color(153, 153, 102));
		frame.setBounds(100, 100, 1003, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(37, 66, 884, 389);
		frame.getContentPane().add(scrollPaneTable);

		table = new JTable();
		table.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
					roomNumber = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0));
					size = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 1));
					userName = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 2));
					dateOld = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 3));
					timeStartOld = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 4));
					timeEndOld = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 5));
					dateNew = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 6));
					timeStartNew = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 7));
					timeEndNew = String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 8));
				
			}
		});
		String[] columnNames = { "room", "size", "userName", "dateOld", "timeStartOle", "timeEndOle", "dateNew", "timeStartNew", "timeEndNew" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		table.setModel(model);
		scrollPaneTable.setViewportView(table);

		JButton buttonApprove = new JButton("Approve");
		buttonApprove.setBounds(563, 523, 150, 57);
		buttonApprove.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		buttonApprove.setBackground(new Color(204, 204, 153));
		buttonApprove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				ConfirmService confirmService = new ConfirmService();
				
				boolean f = ConfirmService.updateEditBooking(roomNumber,
						size,
						userName,
						dateOld,
						timeStartOld,
						timeEndOld,
						dateNew,
						timeStartNew,
						timeEndNew);
		
				if(f) {
					
					showTable();
			     }else {
			    	 showTable();
			     }
			}
		
		});
		frame.getContentPane().add(buttonApprove);

		JButton butttonDisapprove = new JButton("DisApprove");
		butttonDisapprove.setBounds(723, 526, 191, 51);
		butttonDisapprove.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		butttonDisapprove.setBackground(new Color(204, 204, 153));
		frame.getContentPane().add(butttonDisapprove);

		JButton btnHistory = new JButton("History");
		btnHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormHistory his = new FormHistory();
				his.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnHistory.setBounds(203, 523, 159, 57);
		btnHistory.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		btnHistory.setBackground(new Color(204, 204, 153));
		frame.getContentPane().add(btnHistory);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginForm login = new LoginForm();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		btnLogout.setBackground(new Color(204, 204, 153));
		btnLogout.setBounds(37, 524, 142, 54);
		frame.getContentPane().add(btnLogout);
		
		showTable();
		
	}
	public void showTable() {
		////////////////////////////////////////////////////////////////////
		String[] columnNames = { "room", "size", "userName", "dateOld", "timeStartOle", "timeEndOle", "dateNew", "timeStartNew", "timeEndNew" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		System.out.println(555);
		for (Request read : ConfirmService.getRequest()) {
			roomNumber = read.booking.room.room;
			size = read.booking.room.size;
			userName = read.booking.user.username;
			dateOld = read.booking.date;
			timeStartOld = read.booking.timeStart;
			timeEndOld = read.booking.timeEnd;
			dateNew = read.newDate;
			timeStartNew = read.newTimeStart;
			timeEndNew = read.newTimeEnd;
			model.addRow(new String[] { roomNumber, size, userName, dateOld, timeStartOld, timeEndOld , dateNew, timeStartNew, timeEndNew });
		}		

		table.setModel(model);
		System.out.println(table.getRowCount());
		////////////////////////////////////////////////////////////////////
	}
}
