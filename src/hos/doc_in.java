package hos;
import hos.DOCTORS;
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
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
public class doc_in extends javax.swing.JFrame implements ActionListener{
	
	String driver="com.microsoft.sqlserver.jdbc.SQLlServerDriver";
	static String url="jdbc:sqlserver://localhost;databaseName=Hospital";
	static String user="javaUser";
	static String pass="P@ssw0rd";
	
	public JLabel idLabel;
	public JTextField textfield;
	public JButton in;
	public doc_in() 
			{
				getContentPane().setForeground(new Color(0, 0, 64));
				
				in = new JButton("Sign in");
				in.setBackground(new Color(255, 255, 255));
				in.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				in.setBounds(800, 224, 82, 31);
				
				textfield = new JTextField();
				textfield.setBounds(525, 219, 250, 40);
				
				
				idLabel = new JLabel("Enter Your ID");
				idLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
				idLabel.setBounds(363, 217, 127, 40);
					
				getContentPane().add(textfield);
				getContentPane().add(in);
				getContentPane().add(idLabel);
				
				in.addActionListener(this);
				
				getContentPane().setLayout(null);
				
				this.setVisible(true);
				getContentPane().setBackground(new Color(0, 128, 128));
				this.setSize(1920,1080);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==in) {
						try {    		
					    	Connection con = DriverManager.getConnection(url, user, pass); 		    		
					    	String sql="SELECT * FROM Doctor where Dssn=?";
				    		PreparedStatement s=con.prepareStatement(sql);
				    		s.setString(1,textfield.getText());
				    		ResultSet rs= s.executeQuery();
				    		
				    		if(rs.next()) {
				    			DOCTORS ps=new DOCTORS();
				    			ps.doc_name.setText(rs.getString("doc_name"));
				    			ps.specialization.setText(rs.getString("specialization"));
				    	        ps.d=(rs.getString("Dssn")).toString();
				    			ps.show();
				    			dispose();

					    		}
					        else
					        {
					        	JOptionPane.showMessageDialog(null,"id wrong");
					        }
						}
					        catch(SQLException i) {
					        	JOptionPane.showMessageDialog(null,"connection in wrong");
					        }
					        
					        
					        
					     
			}}

	}


