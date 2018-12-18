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

	public JFrame frame;
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
		frame.setBounds(100, 100, 900, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(0, 0, 882, 606);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(56, 131, 777, 223);
		panel_1.add(panel);
		panel.setForeground(Color.GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		username.setBounds(344, 66, 225, 36);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		password.setBounds(344, 115, 225, 36);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblNewLabel.setBounds(182, 66, 123, 36);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblPassword.setBounds(182, 115, 123, 36);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(204, 153, 102));
		btnNewButton.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 30));
		
		btnNewButton.setBounds(445, 385, 132, 39);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(204, 153, 102));
		btnNewButton_1.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm re = new RegisterForm();
				re.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(288, 385, 132, 39);
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
