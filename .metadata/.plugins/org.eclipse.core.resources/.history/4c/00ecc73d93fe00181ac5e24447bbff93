import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 684, 461);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 73, 664, 201);
		panel_1.add(panel);
		panel.setForeground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
		username = new JTextField();
		username.setBounds(257, 40, 225, 20);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(257, 89, 225, 20);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 24));
		lblNewLabel.setBounds(127, 40, 91, 17);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Angsana New", Font.BOLD, 24));
		lblPassword.setBounds(127, 89, 91, 17);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setBounds(585, 427, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm re = new RegisterForm();
				re.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(480, 427, 89, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ArrayList<User> arr = new ArrayList<>();
				arr.add(new User(username.getText(),password.getText(),""));
				
				LoginService login = new LoginService();
				ArrayList<User> arr2 = login.checkLogin(arr);
				System.out.println(username.getText());
				System.out.println(arr2.size());
				
				if(arr2.size()==0) {
					  
					JOptionPane.showMessageDialog(null, "Login incorrect!!");
				      
				}else {
					if(arr2.get(0).status.equals("client")) {
							HomeClientForm client = new HomeClientForm();
							client.Username = username.getText();
				            client.setVisible(true);
				            frame.setVisible(false);
					}else {
						
						 ConfirmStatus con = new  ConfirmStatus();
						 con.main(null);
						 frame.setVisible(false);
						
						
					}
				}
			
				
			}
		});
	}
}
