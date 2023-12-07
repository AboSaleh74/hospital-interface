package hos;
import hos.patient_up;
import hos.Sign_in;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class pt_up_in extends JFrame implements ActionListener{

	JButton sign_in,sign_up;
	JLabel hospitalmange_system;
	
	public pt_up_in()
	{
		getContentPane().setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 27));
		setForeground(new Color(0, 0, 102));
		sign_in= new JButton("Sign in");
		sign_in.setBackground(new Color(255, 255, 255));
		sign_in.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		sign_in.setBounds(440, 425, 128, 45);
		
		sign_up= new JButton("Sign up");
		sign_up.setBackground(new Color(255, 255, 255));
		sign_up.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		sign_up.setBounds(769, 425, 128, 45);
		getContentPane().setLayout(null);
		
		getContentPane().add(sign_in);
		getContentPane().add(sign_up);
		
	    hospitalmange_system = new JLabel("Hospital Management System ");
		hospitalmange_system.setHorizontalAlignment(SwingConstants.CENTER);
		hospitalmange_system.setFont(new Font("Lucida Fax", Font.BOLD, 52));
		hospitalmange_system.setBounds(194, 150, 1001, 114);
		getContentPane().add(hospitalmange_system);
		
		sign_in.addActionListener(this);
		sign_up.addActionListener(this);
		
		sign_in.setFocusable(false);
		sign_up.setFocusable(false);
		
		setVisible(true);
		setSize(1920,1080);
		getContentPane().setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sign_up) {
			new patient_up();
		 dispose();}
	    if(e.getSource()==sign_in) {
			new Sign_in();
		 dispose();}
	}
}