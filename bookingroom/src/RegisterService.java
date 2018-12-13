import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RegisterService {
    RoomDao room = new RoomDao();
	public RegisterService(String username, String password, String re_password) {
		if (password.length() >= 6) {
			if (room.checkUserName(username) == false) {
				JOptionPane.showMessageDialog(null, "Username incorrect!!");
			} else {
				if (password.equals(re_password)) {
					ArrayList<User> arr = new ArrayList<>();
					arr.add(new User(username,password,"client"));
					boolean insert = room.insert(arr);
					if(insert) {
						JOptionPane.showMessageDialog(null, "Successful!!");
						
					}else {
						JOptionPane.showMessageDialog(null, "Username incorrect!!");
					}
					
					
				
				} else {
					JOptionPane.showMessageDialog(null, "Password incorrect!!");
				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "Password is greater than 6 characters");
		}
		

	}


}
