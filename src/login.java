import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class login {

	public JFrame frmLogin;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.DARK_GRAY);
		frmLogin.setBounds(100, 100, 420, 236);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(169, 44, 140, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(70, 50, 89, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		textField_1 = new JPasswordField();
		textField_1.setText("");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(169, 75, 140, 20);
		frmLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(70, 76, 89, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Username & Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(10, 11, 384, 22);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(textField_1.getPassword());
				String user = new String(textField.getText());
				
				if(textField.getText() == "" || pass == "") {
					lblNewLabel_2.setText("Enter all Fields");
					
				}
				else {
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?use SSL = false", "root", "root");
						//String pass = new String(textField_1.getPassword());
						
						Statement stm = con.createStatement();
						String sql = "select * from registration where user_name = '"+ user + "' and pass_word = '"+ pass +"';";
						
						ResultSet rs = stm.executeQuery(sql);
						lblNewLabel_2.setText("Login Successful");
					}
					catch(Exception ae){
						lblNewLabel_2.setText("Wrong Username or Password");
					}
				}
			}
		});
		btnNewButton.setBounds(102, 129, 79, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(211, 129, 79, 23);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		
	}
}
