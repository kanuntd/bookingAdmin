import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FormSearch extends JFrame {

	private JPanel contentPane;
	public  String room, date="", timeStart, timeEnd, status,size;
	ListSearch listSearch;
	JComboBox comboBoxTimeStart = new JComboBox();
	JComboBox comboBoxTimeEnd = new JComboBox();
	JDateChooser dateChooser = new JDateChooser();
	String username;
	JPanel panellist = new JPanel();
	final JPanel panels = new JPanel(new GridLayout(0, 1));
	final JScrollPane scroll = new JScrollPane(panels);
	JComboBox comboBoxSize = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FormSearch frame = new FormSearch();
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
	public FormSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(21, 13, 824, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		comboBoxSize.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		
		
		comboBoxSize.setModel(new DefaultComboBoxModel(new String[] {"", "50", "100", "150", "200"}));
		comboBoxSize.setBounds(256, 25, 176, 37);
		panel.add(comboBoxSize);
		comboBoxTimeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		
		
		comboBoxTimeStart.setModel(new DefaultComboBoxModel(new String[] { "", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
		comboBoxTimeStart.setBounds(256, 122, 74, 34);
		panel.add(comboBoxTimeStart);
		comboBoxTimeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		
		
		comboBoxTimeEnd.setModel(new DefaultComboBoxModel(new String[] { "", "08:00", "09:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
		comboBoxTimeEnd.setBounds(389, 122, 74, 34);
		panel.add(comboBoxTimeEnd);

		
		panellist.setBackground(Color.WHITE);
		panellist.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panellist.setBounds(61, 285, 763, 308);
		JPanel gui = new JPanel(new BorderLayout(2, 2));
		gui.setBounds(0, 0, 763, 307);
		
		panels.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		scroll.setBounds(52, 277, 620, 200);
		scroll.setPreferredSize(new Dimension(620, 200));
		gui.add(scroll, BorderLayout.CENTER);

		
		panellist.setLayout(null);
		panellist.add(gui);
		contentPane.add(panellist);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(204, 153, 102));
		btnSearch.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 30));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		btnSearch.setBounds(595, 120, 123, 36);
		panel.add(btnSearch);
		
		
		
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.setBackground(new Color(204, 153, 102));
		btnBooking.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 30));
		listSearch = new ListSearch();
	    listSearch.getBooking(btnBooking);
		
	    btnBooking.setBounds(595, 75, 123, 34);
		panel.add(btnBooking);
		
		
		dateChooser.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 22));
		dateChooser.setBounds(255, 75, 177, 34);
		panel.add(dateChooser);
		
		JLabel lblSize = new JLabel("size");
		lblSize.setForeground(Color.BLACK);
		lblSize.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		lblSize.setBackground(Color.BLACK);
		lblSize.setBounds(188, 26, 72, 36);
		panel.add(lblSize);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		lblDate.setBackground(Color.BLACK);
		lblDate.setBounds(188, 71, 72, 36);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("time");
		lblTime.setForeground(Color.BLACK);
		lblTime.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		lblTime.setBackground(Color.BLACK);
		lblTime.setBounds(188, 120, 72, 36);
		panel.add(lblTime);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		lblTo.setBackground(Color.BLACK);
		lblTo.setBounds(342, 112, 42, 36);
		panel.add(lblTo);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HomeClientForm home = new HomeClientForm();
				home.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(204, 153, 102));
		btnNewButton.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 20));
		btnNewButton.setBounds(12, 13, 97, 25);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 51));
		panel_1.setBounds(62, 227, 128, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblNewLabel.setBounds(40, 13, 56, 29);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 102, 51));
		panel_2.setBounds(190, 227, 128, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSize_1 = new JLabel("Size");
		lblSize_1.setForeground(Color.WHITE);
		lblSize_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblSize_1.setBounds(48, 13, 56, 29);
		panel_2.add(lblSize_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 102, 51));
		panel_3.setBounds(316, 227, 128, 58);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setForeground(Color.WHITE);
		lblDate_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblDate_1.setBounds(44, 13, 56, 29);
		panel_3.add(lblDate_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 102, 51));
		panel_4.setBounds(443, 227, 128, 58);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTimestart = new JLabel("timeStart");
		lblTimestart.setForeground(Color.WHITE);
		lblTimestart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblTimestart.setBounds(30, 13, 73, 29);
		panel_4.add(lblTimestart);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 102, 51));
		panel_5.setBounds(571, 227, 128, 58);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTimeend = new JLabel("timeEnd");
		lblTimeend.setForeground(Color.WHITE);
		lblTimeend.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblTimeend.setBounds(27, 13, 73, 29);
		panel_5.add(lblTimeend);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 102, 51));
		panel_6.setBounds(696, 227, 128, 58);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		lblStatus.setBounds(43, 13, 73, 29);
		panel_6.add(lblStatus);
	}
	public void search() {
		RoomService roomService = new RoomService();
		Room roomDetail = new Room(comboBoxSize.getSelectedItem().toString());
		
		try {
			if(dateChooser.getDate().toLocaleString().equals("")) {
				date="";
			}else if(dateChooser.getDate().toLocaleString().substring(11,12).equals(" ")) {
				date = dateChooser.getDate().toLocaleString().substring(0,11);
			}else {
				date = dateChooser.getDate().toLocaleString().substring(0,12);
			}
		} catch (Exception e) {
			
		}
		System.out.println(date);
		ArrayList<Booking> arr = roomService.getRoomAll(roomDetail,date,comboBoxTimeStart.getSelectedItem().toString(),comboBoxTimeEnd.getSelectedItem().toString());

          if (arr.isEmpty()) {
				panels.removeAll();
				listSearch = new ListSearch();
			    listSearch.date.setText("------------------------Not found Room------------------------");
				listSearch.room.setText("");
				listSearch.size.setText("");
				listSearch.timeStart.setText("");
				listSearch.timeEnd.setText("");
				listSearch.status.setText("");
				panels.add(listSearch.pannelsearch());
				panels.revalidate();
				int height = (int) panels.getPreferredSize().getHeight();
				scroll.getVerticalScrollBar().setValue(height);
			} else {
				panels.removeAll();
				for (int i = 0; i < arr.size(); i++) {

					room = (String) arr.get(i).room.room;
					status = (String) arr.get(i).status;
					size = (String) arr.get(i).room.size;
					date = (String) arr.get(i).date;
					timeStart = (String) arr.get(i).timeStart;
					timeEnd = (String) arr.get(i).timeEnd;
					    listSearch = new ListSearch();
						listSearch.size.setText(size);
						listSearch.date.setText(date);
						listSearch.room.setText(room);
						listSearch.status.setText(status);
						listSearch.timeStart.setText(timeStart);
						listSearch.timeEnd.setText(timeEnd);
						panels.add(listSearch.pannelsearch());
						panels.revalidate();
						int height = (int) panels.getPreferredSize().getHeight();
						scroll.getVerticalScrollBar().setValue(height);
						
					
				}
			}
          
	}
}