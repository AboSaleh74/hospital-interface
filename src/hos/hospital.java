/*
      
*/

package hos;
import hos.doc_in_or_up;
import hos.pt_up_in;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class hospital extends javax.swing.JFrame implements ActionListener{
	
	JButton doc,pat;
	JLabel hospitalmange_system;
	
	public static void main(String[] args) {
		hospital obj =new hospital();
		obj.setVisible(true);
	}
	public hospital()
	{
	
		doc= new JButton("Doctor");
		doc.setBackground(new Color(255, 255, 255));
		doc.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		doc.setBounds(440, 425, 128, 45);
		
		pat= new JButton("Patient");
		pat.setBackground(new Color(255, 255, 255));
		pat.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		pat.setBounds(769, 425, 128, 45);
		getContentPane().setLayout(null);
		
		getContentPane().add(doc);
		getContentPane().add(pat);
		
	    hospitalmange_system = new JLabel("Hospital Management System ");
		hospitalmange_system.setHorizontalAlignment(SwingConstants.CENTER);
		hospitalmange_system.setFont(new Font("Lucida Fax", Font.BOLD, 52));
		hospitalmange_system.setBounds(194, 150, 1001, 114);
		getContentPane().add(hospitalmange_system);
		
		doc.addActionListener(this);
		pat.addActionListener(this);
		
		doc.setFocusable(false);
		pat.setFocusable(false);      //remove focus on button
		
		setVisible(true);
		setSize(1920,1080);
		getContentPane().setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pat) {
			new pt_up_in();
		 dispose();}
	    if(e.getSource()==doc) {
			new doc_in_or_up();
		 dispose();}
	}
}