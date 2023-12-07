package hos;
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

public class DOCTORS extends javax.swing.JFrame  implements ActionListener {
    
	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	public JLabel lblNewLabel,lblNewLabel_1,doc_label,Spec_label;
	public JTextField doc_name,specialization;
	public JButton deletebtn,home;
	public String d; 
	
public DOCTORS()
	{
		
	this.setVisible(true);
	getContentPane().setBackground(new Color(0, 128, 128));
	getContentPane().setLayout(null);
	
	deletebtn= new JButton("Delete Doctor");
	deletebtn.setBounds(178, 230, 131, 31);
	getContentPane().add(deletebtn);
	
	doc_name = new JTextField();
	doc_name.setBounds(178, 89, 163, 39);
	getContentPane().add(doc_name);
	
	specialization = new JTextField();
	specialization.setBounds(178, 144, 163, 45);
	getContentPane().add(specialization);
	
	doc_label = new JLabel("Doctor:");
	doc_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
	doc_label.setBounds(54, 89, 89, 39);
	getContentPane().add(doc_label);
	
	Spec_label = new JLabel("Specilization:");
	Spec_label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 25));
	Spec_label.setBounds(54, 144, 114, 45);
	getContentPane().add(Spec_label);
	
	 home = new JButton("Home Page");
	 home.setBounds(562, 151, 131, 31);
	getContentPane().add(home);
	
	home.addActionListener(this);
	deletebtn.addActionListener(this);
	
	this.setSize(1920,1080);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deletebtn) {
try {
		
		 
			Connection con = DriverManager.getConnection(url, user, pass); 
			String sql="DELETE FROM Doctor WHERE Dssn='"+d+"'";
			PreparedStatement s=con.prepareStatement(sql);
		  s.executeUpdate();
		 
			doc_name.setText("");
			specialization.setText("");
			
			JOptionPane.showMessageDialog(null,"Deleted");
		}
		catch(SQLException i) {
			JOptionPane.showMessageDialog(null,"not Deleted");
        }

	}
		
	if(e.getSource()==home) {
		new hospital();
		 dispose();
	}
	
	
		
		
	}
	
	}	

	
		

