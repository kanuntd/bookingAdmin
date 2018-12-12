import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FormHistory extends JFrame{

	private JFrame frame;
	private JPanel contentPane;
	public String room, date, timeStart, timeEnd, user,size;
	JComboBox comboBoxRoom = new JComboBox();
	JComboBox comboBoxSize = new JComboBox();
	JComboBox comboBoxTimestart = new JComboBox();
	JComboBox comboBoxTimeend = new JComboBox();
	JDateChooser dateChooser = new JDateChooser();
	String dateChoo="";
	JPanel panel_0 = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_4 = new JPanel();
	JPanel panel_5 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void showHistory() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHistory frame = new FormHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormHistory() {

		getContentPane().setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		getContentPane().setBackground(new Color(153, 153, 102));
		setBackground(Color.WHITE);
		setResizable(false);
		setBounds(100, 100, 900, 653);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 672);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panellist = new JPanel();
		panellist.setBackground(Color.WHITE);
		panellist.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panellist.setBounds(52, 277, 896, 360);
		JPanel gui = new JPanel(new BorderLayout(2, 2));
		gui.setBounds(0, 0, 896, 360);
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		final JScrollPane scroll = new JScrollPane(panel);
		scroll.setBounds(52, 277, 896, 360);
		scroll.setPreferredSize(new Dimension(415, 410));
		gui.add(scroll, BorderLayout.CENTER);
		
		panellist.setLayout(null);
		panellist.add(gui);
		contentPane.add(panellist);
		panellist.setVisible(false);
		
		comboBoxRoom.setBounds(407, 24, 177, 38);
		comboBoxRoom.setModel(new DefaultComboBoxModel(new String[] {"R01"}));
		comboBoxRoom.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 28));
		comboBoxRoom.setBackground(Color.WHITE);
		getContentPane().add(comboBoxRoom);
		
		JLabel lblRoom = new JLabel("ROOM");
		lblRoom.setBounds(306, 24, 89, 36);
		lblRoom.setForeground(new Color(255, 255, 255));
		lblRoom.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		lblRoom.setBackground(Color.WHITE);
		getContentPane().add(lblRoom);
		
		JLabel label_1 = new JLabel("SIZE");
		label_1.setBounds(306, 75, 72, 36);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		label_1.setBackground(Color.WHITE);
		getContentPane().add(label_1);
		
		comboBoxSize.setBounds(407, 75, 177, 38);
		comboBoxSize.setModel(new DefaultComboBoxModel(new String[] {"50", "100", "150", "200"}));
		comboBoxSize.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 28));
		comboBoxSize.setBackground(Color.WHITE);
		getContentPane().add(comboBoxSize);
		
		JLabel label = new JLabel("DATE");
		label.setBounds(306, 124, 72, 36);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		getContentPane().add(label);
		
		JLabel label_2 = new JLabel("TIME");
		label_2.setBounds(306, 173, 72, 36);
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		label_2.setBackground(Color.WHITE);
		getContentPane().add(label_2);
		
		
		comboBoxTimestart.setBounds(407, 174, 87, 38);
		comboBoxTimestart.setModel(new DefaultComboBoxModel(new String[] {"", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		comboBoxTimestart.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		comboBoxTimestart.setBackground(Color.WHITE);
		getContentPane().add(comboBoxTimestart);
		
		JLabel label_3 = new JLabel("to");
		label_3.setBounds(506, 175, 26, 36);
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		label_3.setBackground(Color.WHITE);
		getContentPane().add(label_3);
		
		
		comboBoxTimeend.setBounds(544, 174, 87, 38);
		comboBoxTimeend.setModel(new DefaultComboBoxModel(new String[] {"", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		comboBoxTimeend.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		comboBoxTimeend.setBackground(Color.WHITE);
		getContentPane().add(comboBoxTimeend);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RoomService service = new RoomService();
				Room roomDetail = new Room(comboBoxRoom.getSelectedItem().toString(),comboBoxSize.getSelectedItem().toString());
				try {
					if(dateChooser.getDate().toLocaleString().equals("")) {
						dateChoo="";
					}else if(dateChooser.getDate().toLocaleString().substring(11,12).equals(" ")) {
						dateChoo = dateChooser.getDate().toLocaleString().substring(0,11);
					}else {
						dateChoo = dateChooser.getDate().toLocaleString().substring(0,12);
					}
				} catch (Exception e) {
					
				}
				
				 System.out.println(dateChoo+"+++++++++++");
				ArrayList<Booking> arr = service.getBooking(roomDetail, dateChoo, comboBoxTimestart.getSelectedItem().toString(), comboBoxTimeend.getSelectedItem().toString());
				//System.out.println(arr.isEmpty()+"--------");
				if(arr.isEmpty()) {
					panel.removeAll();
					ListHistory listHistory = new ListHistory();	
					listHistory.user.setText("");
					listHistory.room.setText("");
					listHistory.size.setText("----------------------------- Not found Room -----------------------------");
					listHistory.date.setText("");
					listHistory.timeStart.setText("");
					listHistory.timeEnd.setText("");
					
					panel.add(listHistory.pannelsearch());
					panel.revalidate();
					int height = (int) panel.getPreferredSize().getHeight();
					scroll.getVerticalScrollBar().setValue(height);
				}else {
					panel.removeAll();
				for (int i = 0; i < arr.size(); i++) {
						user = (String) arr.get(i).user.username;
						room = (String) arr.get(i).room.room;
						size = (String) arr.get(i).room.size;
						date = (String) arr.get(i).date;
						timeStart = (String) arr.get(i).timeStart;
						timeEnd = (String) arr.get(i).timeEnd;
						ListHistory listHistory = new ListHistory();
					
					listHistory.size.setText(size);
					listHistory.date.setText(date);
					listHistory.room.setText(room);
					listHistory.user.setText(user);
					listHistory.timeStart.setText(timeStart);
					listHistory.timeEnd.setText(timeEnd);
					
					panel.add(listHistory.pannelsearch());
					panel.revalidate();
					int height = (int) panel.getPreferredSize().getHeight();
					scroll.getVerticalScrollBar().setValue(height);
				}
			}panellist.setVisible(true);
			panel_0.setVisible(true);
			panel_1.setVisible(true);
			panel_2.setVisible(true);
			panel_3.setVisible(true);
			panel_4.setVisible(true);
			panel_5.setVisible(true);

			}
		});
		btnSearch.setBounds(654, 184, 87, 25);
		btnSearch.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 25));
		btnSearch.setBackground(new Color(204, 204, 153));
		getContentPane().add(btnSearch);
		
		
		panel_0.setBackground(new Color(153, 102, 51));
		panel_0.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_0.setBounds(52, 219, 150, 58);
		getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblNewLabel.setBounds(52, 13, 56, 32);
		panel_0.add(lblNewLabel);
		
		
		panel_1.setBackground(new Color(153, 102, 51));
		panel_1.setAlignmentY(0.0f);
		panel_1.setBounds(202, 219, 150, 58);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRoom_1 = new JLabel("ROOM");
		lblRoom_1.setForeground(Color.WHITE);
		lblRoom_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblRoom_1.setBounds(50, 13, 56, 32);
		panel_1.add(lblRoom_1);
		
		
		panel_2.setBackground(new Color(153, 102, 51));
		panel_2.setAlignmentY(0.0f);
		panel_2.setBounds(351, 219, 150, 58);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSize = new JLabel("SIZE");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblSize.setBounds(56, 13, 56, 32);
		panel_2.add(lblSize);
		
		
		panel_3.setBackground(new Color(153, 102, 51));
		panel_3.setAlignmentY(0.0f);
		panel_3.setBounds(500, 219, 150, 58);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblDate.setBounds(48, 13, 56, 32);
		panel_3.add(lblDate);
		
		
		panel_4.setBackground(new Color(153, 102, 51));
		panel_4.setAlignmentY(0.0f);
		panel_4.setBounds(649, 219, 150, 58);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTimestart = new JLabel("START");
		lblTimestart.setForeground(Color.WHITE);
		lblTimestart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblTimestart.setBounds(55, 13, 83, 32);
		panel_4.add(lblTimestart);
		
		
		panel_5.setBackground(new Color(153, 102, 51));
		panel_5.setAlignmentY(0.0f);
		panel_5.setBounds(798, 219, 150, 58);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTimeend = new JLabel("END");
		lblTimeend.setForeground(Color.WHITE);
		lblTimeend.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblTimeend.setBounds(67, 13, 83, 32);
		panel_5.add(lblTimeend);
		
		panel_0.setVisible(false);
		panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		dateChooser.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 22));
		
		dateChooser.setBounds(407, 126, 177, 34);
		contentPane.add(dateChooser);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 672);
	}
	class ListHistory extends JPanel {
		JPanel pannel = new JPanel();
		JLabel room;
		JLabel size;
		JLabel date;
		JLabel timeStart;
		JLabel timeEnd;
		JLabel user;

		public ListHistory() {
			pannel.setBackground(Color.WHITE);
			user = new JLabel("New label");
			user.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			user.setBounds(798, 11, 100, 40);
			pannel.add(user);
			
			JLabel a4 = new JLabel("                   ");
			pannel.add(a4);

			room = new JLabel("New label");
			room.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			room.setBounds(52, 11, 100, 40);
			pannel.add(room);

			JLabel a = new JLabel("                    ");
			pannel.add(a);

			size = new JLabel("New label");
			size.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			size.setBounds(202, 11, 100, 40);
			pannel.add(size);

			JLabel a1 = new JLabel("                   ");
			pannel.add(a1);

			date = new JLabel("New label");
			date.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			date.setBounds(351, 11, 100, 40);
			pannel.add(date);

			JLabel a2 = new JLabel("                   ");
			pannel.add(a2);

			timeStart = new JLabel("New label");
			timeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			timeStart.setBounds(500, 11, 100, 40);
			pannel.add(timeStart);

			JLabel a3 = new JLabel("                   ");
			pannel.add(a3);

			timeEnd = new JLabel("New label");
			timeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
			timeEnd.setBounds(649, 11, 100, 40);
			pannel.add(timeEnd);

			
		}

		JPanel pannelsearch() {
			return pannel;

		}

		public void setlabelRoom(String txt) {
			this.room.setText(txt);
			System.out.println(room.getText() + " 230");
		}

		public void setlabelSize(String txt) {
			this.size.setText(txt);
		}

		public void setlabelDate(String txt) {
			this.date.setText(txt);
		}

		public void setlabelTimeStart(String txt) {
			this.timeStart.setText(txt);
		}

		public void setlabelTimeEnd(String txt) {
			this.timeEnd.setText(txt);
		}

	}
}
