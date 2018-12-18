
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListSearch extends JPanel {
	String username = "";
	JPanel pannel = new JPanel();
	JLabel room;
	JLabel size;
	JLabel date;
	JLabel timeStart;
	JLabel timeEnd;
	JLabel status;
	JCheckBox status2;
	
	static ArrayList<Booking> arr0 = new ArrayList<>();
	public ListSearch() {
		pannel.setBackground(Color.WHITE);
		status2 = new JCheckBox("");
	
		status2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				boolean isSelected = status2.isSelected();
				if (isSelected == true) {
					
					
					Room arr = new Room();
					arr.size = size.getText();
					User arr1 = new User();
					arr1.setUsername(username);
				  
					System.out.println(arr1.getUsername());
				    arr0.add(new Booking(room.getText(),date.getText(),timeStart.getText(),timeEnd.getText(),status.getText(),arr.size,arr1.getUsername()));
  
				} else {
					arr0.clear();
                   System.out.println("cas");
				}
			}
		});
		status2.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		status2.setBounds(798, 11, 100, 40);
		pannel.add(status2);

		room = new JLabel("New label");
		room.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		room.setBounds(52, 11, 100, 40);
		pannel.add(room);

		JLabel a = new JLabel("                    ");
		a.setFont(new Font("Angsana New", Font.PLAIN, 27));
		pannel.add(a);

		size = new JLabel("New label");
		size.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		size.setBounds(202, 11, 100, 40);
		pannel.add(size);

		JLabel a1 = new JLabel("                    ");
		pannel.add(a1);

		date = new JLabel("New label");
		date.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		date.setBounds(351, 11, 100, 40);
		pannel.add(date);

		JLabel a2 = new JLabel("                    ");
		pannel.add(a2);

		timeStart = new JLabel("New label");
		timeStart.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeStart.setBounds(500, 11, 100, 40);
		pannel.add(timeStart);

		JLabel a3 = new JLabel("                    ");
		pannel.add(a3);

		timeEnd = new JLabel("New label");
		timeEnd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		timeEnd.setBounds(649, 11, 100, 40);
		pannel.add(timeEnd);

		JLabel a4 = new JLabel("                    ");
		pannel.add(a4);

		status = new JLabel("New label");
		status.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 25));
		status.setBounds(798, 11, 100, 40);
		pannel.add(status);

	}

	public void getBooking(JButton btnBooking) {
         
         
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								//System.out.println("booking Process");
				boolean a;
				for(int i = 0 ; i<arr0.size(); i++) {
					if(arr0.get(i).status.equals("false")) {
					  
						////
				         JOptionPane.showMessageDialog(null,"You not booking room");
				         break;
					}else {
					
					RoomService s= new RoomService();
					 a = s.updateBooking(arr0);
					
				  }

					 if(a) {
						  /////
						 JOptionPane.showMessageDialog(null,"You can booking room sucessful");
						
					 }else {
						 JOptionPane.showMessageDialog(null,"You not booking room");
					 }
					
					
					
				}
                System.out.println(username);
			
			}
		});

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

	public void setlabelStatus(String txt) {
		this.status.setText(txt);
	}

	public void setJCheckBoxStatus(String txt) {
		this.status2.setText(txt);
	}

}