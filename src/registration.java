import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class registration {

	private JFrame frmRegistrationForm;
	private JTextField studentNameField;
	private JTextField rollNumberField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JPasswordField rePasswordField;
	private JPasswordField passwordField;
	private JTextField usernameField;

	String institute = "", gender = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frmRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.setTitle("Registration Form");
		frmRegistrationForm.getContentPane().setBackground(Color.DARK_GRAY);
		frmRegistrationForm.setBounds(100, 100, 521, 525);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 2, 261, 29);
		frmRegistrationForm.getContentPane().add(lblNewLabel);

		rePasswordField = new JPasswordField();
		rePasswordField.setText(null);
		rePasswordField.setBackground(new Color(255, 222, 173));
		rePasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rePasswordField.setBounds(209, 130, 222, 20);
		frmRegistrationForm.getContentPane().add(rePasswordField);

		passwordField = new JPasswordField();
		passwordField.setText(null);
		passwordField.setBackground(new Color(255, 222, 173));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(209, 99, 222, 20);
		frmRegistrationForm.getContentPane().add(passwordField);

		JLabel lblNewLabel_9 = new JLabel("Create Username");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setForeground(Color.CYAN);
		lblNewLabel_9.setBounds(66, 66, 126, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Create Password");
		lblNewLabel_10.setForeground(Color.CYAN);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(66, 97, 126, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Re-Enter Password");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setForeground(Color.CYAN);
		lblNewLabel_11.setBounds(66, 128, 133, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(66, 161, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Roll Number");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(66, 193, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Select Institute");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(66, 224, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select Institute");
		comboBox.setBackground(new Color(224, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "SVIIT", "SVITS", "SVIFS", "SVITT", "SVSM", "SVIA" }));
		comboBox.setBounds(209, 223, 92, 22);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				institute = "" + comboBox.getItemAt(comboBox.getSelectedIndex());
			}
		});
		frmRegistrationForm.getContentPane().add(comboBox);

		studentNameField = new JTextField();
		studentNameField.setText(null);
		studentNameField.setBackground(new Color(255, 222, 173));
		studentNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentNameField.setBounds(209, 161, 222, 20);
		frmRegistrationForm.getContentPane().add(studentNameField);
		studentNameField.setColumns(10);

		rollNumberField = new JTextField();
		rollNumberField.setText(null);
		rollNumberField.setBackground(new Color(255, 222, 173));
		rollNumberField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rollNumberField.setBounds(209, 192, 222, 20);
		frmRegistrationForm.getContentPane().add(rollNumberField);
		rollNumberField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(66, 255, 109, 22);
		frmRegistrationForm.getContentPane().add(lblNewLabel_4);

		phoneNumberField = new JTextField();
		phoneNumberField.setText(null);
		phoneNumberField.setBackground(new Color(255, 222, 173));
		phoneNumberField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberField.setBounds(209, 256, 222, 20);
		frmRegistrationForm.getContentPane().add(phoneNumberField);
		phoneNumberField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(Color.GREEN);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setBounds(209, 283, 69, 23);
		frmRegistrationForm.getContentPane().add(rdbtnNewRadioButton);

		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setForeground(Color.CYAN);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(66, 282, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_5);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setForeground(Color.MAGENTA);
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setBounds(291, 283, 79, 23);
		frmRegistrationForm.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_2.setForeground(Color.YELLOW);
		rdbtnNewRadioButton_2.setBounds(372, 283, 59, 23);
		frmRegistrationForm.getContentPane().add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				gender = "Male";
				;
			}
		});

		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				gender = "Female";
			}
		});

		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				gender = "Other";
			}
		});

		JLabel lblNewLabel_6 = new JLabel("Email ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(Color.CYAN);
		lblNewLabel_6.setBounds(66, 313, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_6);

		emailField = new JTextField();
		emailField.setText(null);
		emailField.setBackground(new Color(255, 222, 173));
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailField.setBounds(209, 313, 222, 20);
		frmRegistrationForm.getContentPane().add(emailField);
		emailField.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setForeground(Color.CYAN);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(66, 345, 109, 20);
		frmRegistrationForm.getContentPane().add(lblNewLabel_7);

		JTextArea addressField = new JTextArea();
		addressField.setText(null);
		addressField.setBackground(new Color(255, 222, 173));
		addressField.setFont(new Font("Tomoha", Font.PLAIN, 14));
		addressField.setBounds(209, 344, 222, 97);
		frmRegistrationForm.getContentPane().add(addressField);

		usernameField = new JTextField();
		usernameField.setText(null);
		usernameField.setBackground(new Color(255, 222, 173));
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(209, 68, 222, 20);
		frmRegistrationForm.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(10, 32, 485, 23);
		frmRegistrationForm.getContentPane().add(lblNewLabel_8);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass1 = new String(passwordField.getPassword());
				String pass2 = new String(rePasswordField.getPassword());

				if (studentNameField.getText() == null ||
						rollNumberField.getText() == null ||
						phoneNumberField.getText() == null ||
						emailField.getText() == null ||
						usernameField.getText() == null ||
						passwordField.getText() == null ||
						rePasswordField.getText() == null ||
						addressField.getText() == null ||
						gender == "" ||
						institute == "") {

					lblNewLabel_8.setText("Fill all fields");
					lblNewLabel_8.setEnabled(true);
				} else if (!pass1.equals(pass2)) {
					lblNewLabel_8.setText("Passwords do not match");
					lblNewLabel_8.setEnabled(true);
				} else {
					lblNewLabel_8.setEnabled(false);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/student?use SSL = false", "root", "dragonarts@007");

						Statement stm = con.createStatement();
						String sql = "insert into registration values ('" + usernameField.getText() + "', '"
								+ pass1 + "', '"
								+ studentNameField.getText() + "', '"
								+ rollNumberField.getText() + "', '"
								+ institute + "', '"
								+ phoneNumberField.getText() + "', '"
								+ gender + "', '"
								+ emailField.getText() + "', '"
								+ addressField.getText() + "');";

						int check = stm.executeUpdate(sql);
						if (check > 0) {
							try {
								lblNewLabel_8.setText("Login Successful! Redirecting to login Window");

								login window = new login();
								window.frmLogin.setVisible(true);
								frmRegistrationForm.setEnabled(false);
							} catch (Exception ea) {
								ea.printStackTrace();
							}

						}
						con.close();
					} catch (Exception ae) {
						lblNewLabel_8.setText("Fill all fields");
						lblNewLabel_8.setEnabled(true);
						ae.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(139, 452, 89, 23);
		frmRegistrationForm.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Clear All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentNameField.setText("");
				rollNumberField.setText("");
				phoneNumberField.setText("");
				emailField.setText("");
				usernameField.setText("");
				addressField.setText("");
				passwordField.setText("");
				rePasswordField.setText("");
				gender = "";
				institute = "";
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				comboBox.setSelectedItem(false);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(261, 452, 89, 23);
		frmRegistrationForm.getContentPane().add(btnNewButton_1);

	}
}
