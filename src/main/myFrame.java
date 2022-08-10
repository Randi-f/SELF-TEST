package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class myFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myFrame frame = new myFrame();
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
	public myFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 22));
		lblNewLabel.setBounds(224, 106, 74, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(148, 216, 44, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setFont(new Font("ËÎÌו", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(136, 304, 44, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(194, 216, 164, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 307, 164, 32);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(101, 446, 97, 23);
		contentPane.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String myID=textField.getText();
				 String myName = textField_1.getText();
				 SQLiteJDBC myJDBC= new SQLiteJDBC();
				 String loginResult=myJDBC.login(myID, myName);
					if(loginResult.equals("")) {
						System.out.println("not found");
					}
					else {
						System.out.println("ii is:"+loginResult);
						String[] info=loginResult.split("--");
						mainFrame mf = new mainFrame(info[0],info[1], Integer.parseInt(info[2]));
						//setVisible(false);
						dispose();
						mf.setVisible(true);
					}
					
					myJDBC.closeConnection();
				 }
			 
			 });
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(314, 446, 97, 23);
		contentPane.add(btnCancel);
	}
}
