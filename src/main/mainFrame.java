package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private String myID;
	private String myName;
	private int myScore;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame("000","Shihan FU",50);
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
	public mainFrame(String id, String name,int score) {
		myID=id;
		myName=name;
		myScore=score;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//选择框
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(60, 78, 466, 528);
		contentPane.add(tabbedPane);
		
		//用户信息页面
		JPanel panel1= new JPanel();
		tabbedPane.addTab("user_info", panel1);
	    panel1.setLayout(null);
	    
	    //放置头像界面
	    JPanel panel_picture = new JPanel();
	    panel_picture.setBounds(293, 23, 138, 187);
	    panel1.add(panel_picture);
	    JLabel lblNewLabel = new JLabel(new ImageIcon("D:\\Java\\myGUI\\data\\standard.jpg"));
	    lblNewLabel.setBounds(10, 10, 133, 203);
	    panel_picture.add(lblNewLabel);
	    
	    //ID LABEL
	    JLabel lblNewLabel_1 = new JLabel("ID:");
	    lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(50, 43, 58, 32);
	    panel1.add(lblNewLabel_1);
	    
	    //NAME LABEL
	    JLabel lblNewLabel_1_1 = new JLabel("NAME:");
	    lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_1_1.setBounds(50, 97, 58, 32);
	    panel1.add(lblNewLabel_1_1);
	    
	    //ID TEXTPANE
	    JTextPane txtpnDefault_1 = new JTextPane();
	    txtpnDefault_1.setText(myID);
	    txtpnDefault_1.setFont(new Font("宋体", Font.PLAIN, 15));
	    txtpnDefault_1.setBounds(118, 43, 113, 32);
	    txtpnDefault_1.setEditable(false);
	    panel1.add(txtpnDefault_1);
	    
	    //NAME TEXTPANE
	    JTextPane txtpnDefault = new JTextPane();
	    txtpnDefault.setText(myName);
	    txtpnDefault.setFont(new Font("宋体", Font.PLAIN, 15));
	    txtpnDefault.setBounds(118, 97, 113, 32);
	    txtpnDefault.setEditable(false);
	    panel1.add(txtpnDefault);
	    
	    //LEVEL LABEL
	    JLabel lblNewLabel_1_1_1 = new JLabel("LV.");
	    lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_1_1_1.setBounds(50, 155, 58, 32);
	    panel1.add(lblNewLabel_1_1_1);
	    
	    //LEVEL TEXTPANE
	    JTextPane textPane_1_1 = new JTextPane();
	    textPane_1_1.setFont(new Font("宋体", Font.PLAIN, 15));
	    textPane_1_1.setText(""+(myScore/10+1));
	    textPane_1_1.setBounds(118, 155, 113, 32);
	    panel1.add(textPane_1_1);
	    
	    JList list = new JList();
	    list.setToolTipText("HISTORY");
	    list.setBounds(66, 261, 346, 174);
	    panel1.add(list);
		
	    JPanel panel2= new JPanel();
		tabbedPane.addTab("Test", panel2);
	    panel2.setLayout(null);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(30, 367, 386, 36);
	    panel2.add(comboBox);
	    comboBox.addItem("Definition");
	    comboBox.addItem("Equations");
	    comboBox.addItem("Vocabulary");

	    
	    JButton btnNewButton = new JButton("OK");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(180, 437, 97, 23);
	    panel2.add(btnNewButton);
	    
	    JTextPane txtpnList = new JTextPane();
	    txtpnList.setText("LIST:");
	    txtpnList.setBounds(30, 43, 386, 273);
	    panel2.add(txtpnList);
	    
		JTextPane txtpnDefaultinfo = new JTextPane();
		txtpnDefaultinfo.setText("HELLO! "+myName);
		txtpnDefaultinfo.setBounds(209, 22, 153, 21);
		txtpnDefaultinfo.setEditable(false);
		contentPane.add(txtpnDefaultinfo);
	}
}
