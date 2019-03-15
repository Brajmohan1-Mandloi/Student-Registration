import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Delete implements ActionListener
{
	JFrame fdelete;
	JLabel lUsername;
	JTextField tUsername;
	JButton delete;
	
	
	public Delete()
	{
		fdelete=new JFrame("DELETE");
		fdelete.setLayout(null);
		
		lUsername=new JLabel("Username");
		lUsername.setBounds(460,200,100,30);
		
		tUsername=new JTextField();
		tUsername.setBounds(610,200,250,30);
		
		delete=new JButton("DELETE");
		delete.setBounds(530,300,200,40);
		delete.addActionListener(this);
		
		
		fdelete.add(lUsername);
		fdelete.add(tUsername);
		fdelete.add(delete);
		
		//fshow.add();
		//fshow.add();
		//fshow.add();
		
		fdelete.setSize(900,900);
		fdelete.setVisible(true);
		//fdelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==delete)
		{
			try
			{
				String usern=tUsername.getText();
				
				JOptionPane.showMessageDialog(fdelete,"Username ="+usern);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/0187cs161034","root","rootwdp");
				String qry="delete from profile where username='"+usern+"'" ;
				Statement st=con.createStatement();
				JOptionPane.showMessageDialog(fdelete,"Deleted");
				int res=st.executeUpdate(qry);
				if(res!=0)
				{
					JOptionPane.showMessageDialog(fdelete,"Deleted 1");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] arg)
	{
		System.out.println("PLZZ Login first");
		//new Centre();
	}
}
