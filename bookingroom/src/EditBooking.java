import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class EditBooking {

	public JFrame frmChangeSchudal;
	String newDate = "";
	public ArrayList<Booking> arr;
	public String date1;
	public String timeStart1;
	public String timeEnd1;
	public String status1;
	public String room1;
	public String size1;
	public String username1;
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getTimeStart1() {
		return timeStart1;
	}

	public void setTimeStart1(String timeStart1) {
		this.timeStart1 = timeStart1;
	}

	public String getTimeEnd1() {
		return timeEnd1;
	}

	public void setTimeEnd1(String timeEnd1) {
		this.timeEnd1 = timeEnd1;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getRoom1() {
		return room1;
	}

	public void setRoom1(String room1) {
		this.room1 = room1;
	}

	public String getSize1() {
		return size1;
	}

	public void setSize1(String size1) {
		this.size1 = size1;
	}

	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}
	
	
	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBooking window = new EditBooking();
					window.frmChangeSchudal.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditBooking() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void set(String data, String ts1, String te1, String sta, String room, String size, String name) {
		date1 = data;
		timeStart1 = ts1;
		timeEnd1 = te1;
		status1 = sta;
		room1 = room;
		size1 = size;
		username1 = name;
	}
	public void initialize() {
		//System.out.println(size1);
		frmChangeSchudal = new JFrame();
		frmChangeSchudal.getContentPane().setBackground(new Color(255, 204, 51));
		frmChangeSchudal.setTitle("Change Schedule");
		frmChangeSchudal.setBounds(100, 100, 1003,672 );
		frmChangeSchudal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangeSchudal.getContentPane().setLayout(null);
		String calendarDate;

		JLabel date = new JLabel("Date");
		date.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		date.setBounds(252, 189, 97, 35);
		frmChangeSchudal.getContentPane().add(date);

		JLabel timeStart = new JLabel("Start");
		timeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		timeStart.setBounds(252, 256, 97, 43);
		frmChangeSchudal.getContentPane().add(timeStart);

		JLabel timeEnd = new JLabel("end");
		timeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 40));
		timeEnd.setBounds(503, 258, 76, 38);
		frmChangeSchudal.getContentPane().add(timeEnd);

		JButton buttonSendRequest = new JButton("Send Request");
		buttonSendRequest.setBackground(new Color(153, 102, 51));
		buttonSendRequest.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
	
		buttonSendRequest.setBounds(504, 392, 190, 35);
		frmChangeSchudal.getContentPane().add(buttonSendRequest);

		String[] TimeStart = new String[] { "8.00", "9.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00",
				"16.00", "17.00", "18.00", "19.00", "20.00" };
		JComboBox<String> dropdownTimeStart = new JComboBox(TimeStart);
		dropdownTimeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		dropdownTimeStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newTimeStart = dropdownTimeStart.getItemAt(dropdownTimeStart.getSelectedIndex());
			}
		});
		dropdownTimeStart.setModel(new DefaultComboBoxModel(new String[] { "8.00", "9.00", "10.00", "11.00", "12.00",
				"13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00" }));
		dropdownTimeStart.setBounds(361, 256, 116, 42);
		frmChangeSchudal.getContentPane().add(dropdownTimeStart);

		String[] TimeEnd = new String[] { "9.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00",
				"17.00", "18.00", "19.00", "20.00", "21.00" };
		JComboBox<String> dropdownTimeEnd = new JComboBox(TimeEnd);
		dropdownTimeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		dropdownTimeEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newTimeEnd = dropdownTimeEnd.getItemAt(dropdownTimeEnd.getSelectedIndex());
			}
		});

		dropdownTimeEnd.setBounds(578, 256, 116, 42);
		frmChangeSchudal.getContentPane().add(dropdownTimeEnd);

		JButton buttonBack = new JButton("Back");
		buttonBack.setBackground(new Color(153, 102, 51));
		buttonBack.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			
				frmChangeSchudal.setVisible(false);
			}
		});

		buttonBack.setBounds(282, 392, 190, 35);
		frmChangeSchudal.getContentPane().add(buttonBack);

		JDateChooser calendarMenu = new JDateChooser();
		calendarMenu.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		calendarMenu.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (calendarMenu.getDate() != null) {
					String date = calendarMenu.getDate().toString();
					String day = date.substring(8, 10);
					String month = date.substring(4, 8);
					String year = date.substring(23, 28);
					newDate = month + day + "," + year;
				}
			}
		});
		
		buttonSendRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//System.out.println(date1 +" fsgsgdfg");
				sendRequest(dropdownTimeStart ,dropdownTimeEnd ,calendarMenu);
			}   
		});
		calendarMenu.setBounds(361, 181, 333, 43);
		frmChangeSchudal.getContentPane().add(calendarMenu);

	}
	public void sendRequest(JComboBox dropdownTimeStart ,JComboBox dropdownTimeEnd , JDateChooser calendarMenu) {
		
		ArrayList<Booking> arr = new ArrayList<>();
		String S =  (String) dropdownTimeStart.getSelectedItem();
		String E = (String) dropdownTimeEnd.getSelectedItem();
		
		
		System.out.println(S + " " + E+ " " +getDate1() + " " + getUsername1());
	    arr.add(new Booking(getDate1(),getTimeStart1(),getTimeEnd1(),getStatus1(),new Room(getRoom1(),getSize1()),new User(getUsername1())));
		
		
	RoomService service = new RoomService();
	service.insertRequest(arr, newDate, S, E);
		
		JOptionPane.showMessageDialog(null,"Your request has send");
	 
	}

}
