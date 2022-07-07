import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField txtAge;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtUname;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/edgarbriandt/Desktop/akira.jpeg"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 614);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 38, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewFiield_1 = new JLabel("Address :");
		lblNewFiield_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewFiield_1.setBounds(23, 95, 61, 16);
		contentPane.add(lblNewFiield_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 157, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_3.setBounds(23, 216, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No. :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_4.setBounds(23, 282, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email :");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_5.setBounds(23, 362, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("User Name :");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_6.setBounds(23, 434, 87, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password :");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_7.setBounds(23, 502, 87, 16);
		contentPane.add(lblNewLabel_7);
		
		txtName = new JTextField();
		txtName.setBounds(175, 34, 130, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtAddr = new JTextArea();
		txtAddr.setBounds(140, 78, 227, 51);
		contentPane.add(txtAddr);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(122, 154, 79, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(213, 154, 99, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		txtAge = new JTextField();
		txtAge.setBounds(175, 212, 130, 26);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(175, 278, 130, 26);
		contentPane.add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(175, 358, 130, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUname = new JTextField();
		txtUname.setBounds(175, 430, 130, 26);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(175, 498, 130, 26);
		contentPane.add(txtPass);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lib","<username>","<password>");
					
					String query = "insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setString(1, txtName.getText());
					pst.setString(2, txtAddr.getText());
				
					if(rdbtnMale.isSelected())
						pst.setString(3, rdbtnMale.getText());
					
					else
						pst.setString(3, rdbtnNewRadioButton.getText());
					pst.setInt(4, Integer.parseInt(txtAge.getText()));
					pst.setInt(5, Integer.parseInt(txtAge.getText()));
					pst.setString(6, txtEmail.getText());
					pst.setString(7, txtUname.getText());
					pst.setString(8, txtPass.getText());
					
					
				int i =	pst.executeUpdate();
				
				JOptionPane.showMessageDialog(btnValidate, i+ "Record added");
				pst.close();
				con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnValidate.setBounds(92, 539, 117, 29);
		contentPane.add(btnValidate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddr.setText("");
				txtAge.setText("");
				txtMobile.setText("");
				txtEmail.setText("");
				txtUname.setText("");
				txtPass.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnReset.setBounds(250, 539, 117, 29);
		contentPane.add(btnReset);
	}
}
