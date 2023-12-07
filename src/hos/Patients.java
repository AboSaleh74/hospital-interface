package hos;

import hos.Sign_in;
import hos.make_app;
import hos.test1;
import hos.hospital;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
                                                                                 //To access the interface methods, the interface must be "implemented"
public class Patients extends javax.swing.JFrame  implements ActionListener {   // implements means you are using the elements of a Java Interface in your class.
	                                                                            //extends means that you are creating a subclass of the base class you are extending.
	                                                                            // JFrame class is the foundation for creating graphical Java applications
	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	public JLabel pt_label,med_label,update_label,appoint_label,ptid_label,test_label;
	public JTextField patient_name,mdi_Field,updatefield,ssnfield;
	public JButton app_btn,tests,home,update_pt;

public Patients()
	{
	
	getContentPane().setLayout(null);    //null layout means absolute positioning - you have to do all the work in your code. No layout manager to help you out.
	
	pt_label = new JLabel("Patient Name: ");
	pt_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
	pt_label.setBounds(32, 73, 96, 33);
	getContentPane().add(pt_label);
	
	med_label = new JLabel("Medical insurance: ");
	med_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
	med_label.setBounds(22, 100, 109, 40);
	getContentPane().add(med_label);
	
	this.setVisible(true);                               //set frame visible
	getContentPane().setBackground(new Color(0, 128, 128));
	
	patient_name = new JTextField();
	patient_name.setBounds(152, 81, 131, 20);
	getContentPane().add(patient_name);
	
	mdi_Field = new JTextField();
	mdi_Field.setBounds(152, 112, 131, 20);
	getContentPane().add(mdi_Field);
	
	appoint_label = new JLabel("Make an Appointement");
	appoint_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
	appoint_label.setBounds(10, 412, 149, 23);
	getContentPane().add(appoint_label);
	
    test_label = new JLabel("Tests and Examinations");
    test_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
    test_label.setBounds(275, 414, 149, 18);
	getContentPane().add(test_label);
	
	app_btn = new JButton("Make an Appointment");
	app_btn.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
	app_btn.setBounds(10, 446, 149, 33);
	getContentPane().add(app_btn);
	
	tests = new JButton("Tests and Examinations");
	tests.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
	tests.setBounds(275, 446, 149, 33);
	getContentPane().add(tests);
	
	 home = new JButton("Home Page");
	 home.setBounds(10, 576, 131, 31);
	getContentPane().add(home);
	
	update_pt = new JButton("Update");
	update_pt.setBounds(22, 265, 108, 33);
	getContentPane().add(update_pt);
	
	updatefield = new JTextField();
	updatefield.setText("");
	updatefield.setBounds(22, 216, 200, 33);
	getContentPane().add(updatefield);
	
	update_label = new JLabel("Update Medical insurance");
	update_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
	update_label.setBounds(22, 185, 164, 20);
	getContentPane().add(update_label);
	
	ssnfield = new JTextField();
	ssnfield.setBounds(152, 50, 131, 20);
	getContentPane().add(ssnfield);    // "getContentPane()" method retrieves the content pane layer so that you can add an object to it
	
	ptid_label = new JLabel("Patient ID: ");
	ptid_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
	ptid_label.setBounds(32, 42, 79, 33);
	getContentPane().add(ptid_label);
	
	
	home.addActionListener(this);         // "this" refers to the current object in a method or constructor 
	update_pt.addActionListener(this);
	tests.addActionListener(this);
	app_btn.addActionListener(this);
	
	
	this.setSize(1920,1080);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
try{
		
    	Connection con = DriverManager.getConnection(url, user, pass);     //creates a Connection object, which is used to create SQL statements
    	Sign_in pt=new Sign_in();
        String tf= pt.intextfield.toString();      //object from Sign_in page to get SSN entered by user in the "intextfield" to put it in the sql condition , tostring it returns the String representation of the object
                                                   
		String sql="SELECT SSN,pt_Name,med_insurance FROM PATIENT where SSN='"+tf+"'";

		PreparedStatement s=con.prepareStatement(sql);    //An object that represents a precompiled SQL statement. A SQL statement is precompiled and stored in a PreparedStatement object. 
		                                                   //This object can then be used to efficiently execute this statement multiple times.
		
		 s.executeUpdate();           // used to execute: insert,update,delete returns an integer value represents number of rows affected

		}
		 
		catch(SQLException i) {
        	i.printStackTrace();                         //diagnosing exceptions 
        System.out.println(i.getMessage());              // print exception message
        }
	
if(e.getSource()==tests) {          //  getSource()  method used in the actionPerformed method to determine which button was clicked
	new test1();
 dispose();}

if(e.getSource()==app_btn) {
	new make_app();     // open another frame
 dispose();}
	
if(e.getSource()==home) {
	new hospital();
	 dispose();        //close the opened framed or causes the JFrame window to be destroyed and cleaned up by the operating system
	                   // System.exit(0) causes the Java VM to terminate completely
}

if(e.getSource()==update_pt)
{
	try {
		Connection con2 = DriverManager.getConnection(url, user, pass); 

	   String sql2="update PATIENT set med_insurance='"+updatefield.getText()+"' where SSN='"+ssnfield.getText()+"'";
	   PreparedStatement s2=con2.prepareStatement(sql2);
	    s2.executeUpdate();
	     

			 mdi_Field.setText(updatefield.getText());  // change text field with data entered in update field
			 
			 this.setVisible(true); //stay in same frame
			 JOptionPane.showMessageDialog(null,"Updated");
			 
		 }

	catch(SQLException i) {
    	JOptionPane.showMessageDialog(null,"not Updated");}

}


	}

}

