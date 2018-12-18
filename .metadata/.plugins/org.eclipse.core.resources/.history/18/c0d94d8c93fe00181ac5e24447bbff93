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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(37, 37, 605, 310);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Angsana New", Font.PLAIN, 21));
		lblUsername.setBounds(111, 84, 124, 22);
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(319, 89, 147, 20);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Angsana New", Font.PLAIN, 21));
		lblPassword.setBounds(111, 154, 90, 17);
		panel.add(lblPassword);
		
		JLabel lblRepassword = new JLabel("Re-password");
		lblRepassword.setFont(new Font("Angsana New", Font.PLAIN, 21));
		lblRepassword.setBounds(111, 214, 111, 17);
		panel.add(lblRepassword);
		
		password = new JTextField();
		password.setBounds(319, 151, 147, 20);
		panel.add(password);
		password.setColumns(10);
		
		repassword = new JTextField();
		repassword.setBounds(319, 211, 147, 20);
		panel.add(repassword);
		repassword.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterService re = new RegisterService(username.getText(),password.getText(),repassword.getText());
			}
		});
		btnRegister.setBounds(540, 427, 102, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancle = new JButton("CANCLE");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginForm a = new LoginForm();
				
				a.main(null);
				frame.setVisible(false);
			}
		});
		btnCancle.setBounds(413, 427, 102, 23);
		frame.getContentPane().add(btnCancle);
	}
}
