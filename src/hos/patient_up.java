package hos;
import hos.Sign_in;
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


public class patient_up extends javax.swing.JFrame implements ActionListener {
	public JButton up,loginbt;
	public JTextField inField,namefield,ssnfield,medicalfield,outField;
	public JLabel ssn_label,name_label,med_label,d_inlabel,d_out;

	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";

	public patient_up()
	{
		up = new JButton("Submit");
		up.setBackground(new Color(255, 255, 255));
		up.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		up.setBounds(330, 497, 95, 40);
		
		namefield = new JTextField();
		namefield.setBounds(10, 104, 250, 40);
		
		ssnfield = new JTextField();
		ssnfield.setBounds(10, 202, 250, 40);
		
		medicalfield = new JTextField();
		medicalfield.setBounds(10, 307, 250, 40);
		
		inField = new JTextField();
		inField.setBounds(10, 406, 250, 40);
		
		outField = new JTextField();
		outField.setBounds(10, 497, 250, 40);  
		
		getContentPane().add(namefield);
		getContentPane().add(ssnfield);
		getContentPane().add(medicalfield);
		getContentPane().add(outField);
		getContentPane().add(inField);
		getContentPane().add(up);
		getContentPane().setLayout(null);
		
		name_label = new JLabel("Name");
		name_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name_label.setBounds(10, 79, 64, 20);
		getContentPane().add(name_label);
		
		 ssn_label = new JLabel("SSN");
		 ssn_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		 ssn_label.setBounds(10, 177, 46, 14);
		getContentPane().add(ssn_label);
		
	    med_label = new JLabel("Medical Insurance");
		med_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		med_label.setBounds(10, 282, 105, 14);
		getContentPane().add(med_label);
		
		
		d_inlabel = new JLabel("Date in: ");
		d_inlabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		d_inlabel.setBounds(10, 381, 64, 14);
		getContentPane().add(d_inlabel);
		
		d_out = new JLabel("Date out:");
		d_out.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		d_out.setBounds(10, 472, 64, 14);
		getContentPane().add(d_out);
		
	    loginbt = new JButton("Login");
	    loginbt.setBackground(new Color(255, 255, 255));
	    loginbt.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		loginbt.setBounds(10, 606, 105, 40);
		getContentPane().add(loginbt);
		
		up.addActionListener(this);
		loginbt.addActionListener(this);
		
		this.setVisible(true);
		getContentPane().setBackground(new Color(0, 128, 128));
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==up) {
		
			try {    		
		    	Connection con = DriverManager.getConnection(url, user, pass); 		    		
	    		String sql="INSERT INTO PATIENT values (?,?,?,?,?)";
	    		
	    		PreparedStatement s=con.prepareStatement(sql);
	    		s.setString(1,ssnfield.getText());
	    		s.setString(2,namefield.getText());
	    		s.setString(3,medicalfield.getText());
	    		s.setString(4,inField.getText());
	    		s.setString(5,outField.getText());
	    		
	    		JOptionPane.showMessageDialog(null,"Data inserted");
	    		s.executeQuery();
	    	    con.close();	
			}
		        catch(SQLException i) {
		        	
		        }
		}
		  if(e.getSource()==loginbt) {
				Sign_in in_pt= new Sign_in();
		        in_pt.show();
			    dispose();} 
		  
	
		}}
	
