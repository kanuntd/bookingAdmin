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

public class ConfirmStatus {

	private JFrame frame;
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
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_R) {
					showTable();
				}
			}
		});
		frame.setBounds(100, 100, 1003, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(37, 35, 884, 362);
		frame.getContentPane().add(scrollPaneTable);

		table = new JTable();
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
		buttonApprove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				ConfirmService confirmService = new ConfirmService();
				
				ConfirmService.updateEditBooking(roomNumber,
						size,
						userName,
						dateOld,
						timeStartOld,
						timeEndOld,
						dateNew,
						timeStartNew,
						timeEndNew);
			}
		});
		buttonApprove.setBounds(646, 568, 118, 23);
		frame.getContentPane().add(buttonApprove);

		JButton butttonDisapprove = new JButton("DisApprove");
		butttonDisapprove.setBounds(797, 568, 124, 23);
		frame.getContentPane().add(butttonDisapprove);

		JButton btnHistory = new JButton("History");
		btnHistory.setBounds(41, 568, 109, 23);
		frame.getContentPane().add(btnHistory);
		
		showTable();
		
	}
	public void showTable() {
		////////////////////////////////////////////////////////////////////
		String[] columnNames = { "room", "size", "userName", "dateOld", "timeStartOle", "timeEndOle", "dateNew", "timeStartNew", "timeEndNew" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
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
		////////////////////////////////////////////////////////////////////
	}
}
