package hos;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;

public class test1 extends javax.swing.JFrame  implements ActionListener {

	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	public JTextField ID,Name,DATE,TIME;
	
	public JLabel date_label,time_label,testid_label,name_label ;

	public JButton submitbtn;
	
	public test1() {
		getContentPane().setLayout(null);
		
		submitbtn = new JButton("Submit");
		submitbtn.setBounds(394, 282, 139, 55);
		submitbtn.setBackground(new Color(255, 255, 255));
		submitbtn.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		getContentPane().add(submitbtn);
		
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 128, 128));
		
		DATE = new JTextField();
		DATE.setBounds(33, 296, 209, 30);
		getContentPane().add(DATE);
		
		TIME = new JTextField();
		TIME.setBounds(33, 231, 209, 30);
		getContentPane().add(TIME);
		TIME.setColumns(10);
		
		date_label= new JLabel("Enter Date");
		date_label.setBounds(33, 269, 74, 28);
		getContentPane().add(date_label);
		
		time_label = new JLabel("Enter Time");
		time_label.setBounds(33, 203, 74, 20);
		getContentPane().add(time_label);
		
		ID = new JTextField();
		ID.setBounds(33, 94, 209, 30);
		getContentPane().add(ID);
		
		testid_label = new JLabel("Enter Test ID");
		testid_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		testid_label.setBounds(33, 69, 64, 14);
		getContentPane().add(testid_label);
		
		name_label = new JLabel("Enter Test Name");
		name_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		name_label.setBounds(33, 137, 93, 14);
		getContentPane().add(name_label);
		
		Name = new JTextField();
		Name.setBounds(33, 162, 209, 30);
		getContentPane().add(Name);
		
		submitbtn.addActionListener(this);
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitbtn) {
				try {    		
			    	Connection con = DriverManager.getConnection(url, user, pass); 		    		
		    		String sql="INSERT INTO TESTS (test_id,test_name,test_date,test_time) VALUES(?,?,?,?)";                                  
		    		PreparedStatement s=con.prepareStatement(sql);     
	    		
		    		s.setString(1,ID.getText());
		    		s.setString(2,Name.getText());
		    		s.setString(3,DATE.getText());
		    		s.setString(4,TIME.getText());		
		    		s.executeQuery();
				}
		
			        catch(SQLException i) {
			        }
				    JOptionPane.showMessageDialog(null,"submitted");
			        }
}}