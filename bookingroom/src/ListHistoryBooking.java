import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListHistoryBooking extends JPanel {
	JPanel pannel = new JPanel();
	JLabel room;
	JLabel size;
	JLabel date;
	JLabel timeStart;
	JLabel timeEnd;
	JLabel status;
	JButton edit;
	public String username = "";

	public <edit> ListHistoryBooking() {
		pannel.setBackground(Color.WHITE);

		room = new JLabel("New label");
		room.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		room.setBounds(52, 11, 100, 40);
		pannel.add(room);

		JLabel a = new JLabel("                         ");
		pannel.add(a);

		size = new JLabel("New label");
		size.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		size.setBounds(202, 11, 100, 40);
		pannel.add(size);

		JLabel a1 = new JLabel("                         ");
		pannel.add(a1);

		date = new JLabel("New label");
		date.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		date.setBounds(351, 11, 100, 40);
		pannel.add(date);

		JLabel a2 = new JLabel("                         ");
		pannel.add(a2);

		timeStart = new JLabel("New label");
		timeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeStart.setBounds(500, 11, 100, 40);
		pannel.add(timeStart);

		JLabel a3 = new JLabel("                         ");
		pannel.add(a3);

		timeEnd = new JLabel("New label");
		timeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeEnd.setBounds(649, 11, 100, 40);
		pannel.add(timeEnd);

		JLabel a4 = new JLabel("                         ");
		pannel.add(a4);



		edit = new JButton("Edit");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<Booking> arr = new ArrayList<>();
				EditBooking ed = new EditBooking();
				
				ed.setDate1(date.getText());
				ed.setRoom1(room.getText());
				ed.setSize1(size.getText());
				ed.setStatus1("false");
				ed.setTimeEnd1(timeEnd.getText());
				ed.setTimeStart1(timeStart.getText());
				ed.setUsername1(username);
				ed.frmChangeSchudal.setVisible(true);
				setVisible(false);
 
			}
		});
		edit.setBackground(new Color(204, 153, 102));
		edit.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		edit.setBounds(798, 11, 100, 40);
		pannel.add(edit);

	}

	JPanel pannelhistorybooking() {
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
		
		