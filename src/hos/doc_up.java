package hos;
import hos.hospital;
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
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;

public class doc_up extends javax.swing.JFrame implements ActionListener {
	JTextField namefield,dssnfield,specialization;
	JButton up,homebtn;
	JLabel spec_label,dssn_label,name_label;

	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	
	public doc_up()
	{
		
		up = new JButton("Submit");
		up.setBackground(new Color(255, 255, 255));
		up.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		up.setBounds(375, 307, 95, 40);
		
		up.addActionListener(this);
		
		namefield = new JTextField();
		namefield.setBounds(10, 104, 250, 40);
		
		dssnfield = new JTextField();
		dssnfield.setBounds(10, 202, 250, 40);
		
		specialization = new JTextField();
		specialization.setBounds(10, 307, 250, 40);
		
		getContentPane().add(namefield);
		getContentPane().add(dssnfield);
		getContentPane().add(specialization);
		getContentPane().add(up);
		
		getContentPane().setLayout(null);
		
		name_label = new JLabel("Name");
		name_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name_label.setBounds(10, 79, 64, 14);
		getContentPane().add(name_label);
		
		dssn_label = new JLabel("DSSN");
		dssn_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		dssn_label.setBounds(10, 177, 46, 14);
		getContentPane().add(dssn_label);
		
		spec_label = new JLabel("Specalization");
		spec_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		spec_label.setBounds(10, 282, 100, 14);
		getContentPane().add(spec_label);
		
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 128, 128));
		
	    homebtn = new JButton("Home Page");
		homebtn.setBounds(10, 388, 100, 32);
		getContentPane().add(homebtn);
		
		homebtn.addActionListener(this);
		
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==up) {
		
			try {    		
		    	Connection con = DriverManager.getConnection(url, user, pass); 		    		
	    		String sql="INSERT INTO Doctor values (?,?,?)";
	    		
	    		
	    		PreparedStatement s=con.prepareStatement(sql);
	    		s.setString(1,dssnfield.getText());
	    		s.setString(2,namefield.getText());
	    		s.setString(3,specialization.getText());
	    		JOptionPane.showMessageDialog(null,"Data inserted");
	    		s.executeQuery();
	    	con.close();	
			}
		        catch(SQLException i) {
		
		        }
		        
		        }
		if(e.getSource()==homebtn) {
			new hospital();
		}
}	
}