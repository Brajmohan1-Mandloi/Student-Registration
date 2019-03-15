import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Update implements ActionListener
{
	JFrame fupdate;
	JLabel lUsername,lsem;
	JTextField tUsername;
	Choice sem;
	JButton update  ;
	
	
	public Update()
	{
		fupdate=new JFrame("UPDATE");
		fupdate.setLayout(null);
		
		lUsername=new JLabel("Username");
		lUsername.setBounds(460,200,100,30);
		
		tUsername=new JTextField();
		tUsername.setBounds(610,200,250,30);
		
		lsem=new JLabel("Semester");
		lsem.setBounds(460,250,100,30);
		
		sem=new Choice();
		sem.setBounds(610,250,0,0);
		sem.add("1");
		sem.add("2");
		sem.add("3");
		sem.add("4");
		sem.add("5");
		sem.add("6");
		sem.add("7");
		sem.add("8");
		
		update=new JButton("UPDATE");
		update.setBounds(530,350,200,40);
		update.addActionListener(this);
		
		
		fupdate.add(lUsername);
		fupdate.add(tUsername);
		fupdate.add(lsem);
		fupdate.add(sem);
		fupdate.add(update);
		
		//fshow.add();
		//fshow.add();
		//fshow.add();
		
		fupdate.setSize(900,900);
		fupdate.setVisible(true);
		//fupdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==update)
		{
			try
			{
				String usern=tUsername.getText();
				int semes=Integer.parseInt(sem.getSelectedItem());
				JOptionPane.showMessageDialog(fupdate,"Username ="+usern+" Seme ="+semes);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/0187cs161034","root","rootwdp");
				String qry="update profile set sem ="+semes+" where username='"+usern+"'" ;
				Statement st=con.createStatement();
				JOptionPane.showMessageDialog(fupdate,"Updated");
				int res=st.executeUpdate(qry);
				if(res!=0)
				{
					JOptionPane.showMessageDialog(fupdate,"Updated ");
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


