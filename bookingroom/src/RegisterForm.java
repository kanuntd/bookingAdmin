import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterForm {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	private JTextField repassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm window = new RegisterForm();
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
	public RegisterForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 51));
		frame.setBounds(100, 100, 900, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(54, 102, 783, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblUsername.setBounds(158, 50, 124, 37);
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(367, 50, 251, 39);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblPassword.setBounds(158, 120, 124, 37);
		panel.add(lblPassword);
		
		JLabel lblRepassword = new JLabel("Re-password");
		lblRepassword.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		lblRepassword.setBounds(158, 188, 152, 37);
		panel.add(lblRepassword);
		
		password = new JTextField();
		password.setBounds(367, 124, 251, 39);
		panel.add(password);
		password.setColumns(10);
		
		repassword = new JTextField();
		repassword.setBounds(366, 191, 252, 40);
		panel.add(repassword);
		repassword.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(new Color(204, 153, 102));
		btnRegister.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterService re = new RegisterService(username.getText(),password.getText(),repassword.getText());
			}
		});
		btnRegister.setBounds(441, 444, 141, 45);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancle = new JButton("CANCLE");
		btnCancle.setBackground(new Color(204, 153, 102));
		btnCancle.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 30));
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginForm a = new LoginForm();
				
				a.main(null);
				frame.setVisible(false);
			}
		});
		btnCancle.setBounds(242, 444, 141, 45);
		frame.getContentPane().add(btnCancle);
	}
}
