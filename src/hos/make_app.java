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

public class make_app extends javax.swing.JFrame  implements ActionListener {

	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	
	public JTextField code,Name;
	public JLabel appcode_label,appdate_label;
	public JButton submitbtn;
	
	public make_app() {
		getContentPane().setLayout(null);
		
		submitbtn = new JButton("Submit");
		submitbtn.setBounds(388, 148, 139, 55);
		submitbtn.setBackground(new Color(255, 255, 255));
		submitbtn.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		getContentPane().add(submitbtn);
		
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 128, 128));
		
		code = new JTextField();
		code.setBounds(33, 94, 209, 30);
		getContentPane().add(code);
		
		appcode_label = new JLabel("Enter Appointement code");
		appcode_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		appcode_label.setBounds(33, 69, 122, 14);
		getContentPane().add(appcode_label);
		
		appdate_label = new JLabel("Enter Appointment Date");
		appdate_label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		appdate_label.setBounds(33, 137, 122, 14);
		getContentPane().add(appdate_label);
		
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
		    		String sql="INSERT INTO appointement (app_code,app_date) VALUES(?,?)";                                  
		    		PreparedStatement s=con.prepareStatement(sql);
		    		
		    		s.setString(1,code.getText());
		    		s.setString(2,Name.getText());	
		    		s.executeQuery();
				}
		
			        catch(SQLException i) {
			        }
				 JOptionPane.showMessageDialog(null,"Appointement submitted");
			        }
}}
