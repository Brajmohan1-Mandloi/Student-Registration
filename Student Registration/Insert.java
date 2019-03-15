import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Insert implements ActionListener
{
	JFrame finsert;
	JLabel lUsername,lEnrollNo,lName,lBranch,lSem,lPassword;
	JTextField tUsername,tEnrollNo,tName;
	Choice branch,sem;
	JPasswordField pass;
	JButton insert;
	public Insert()
	{
			 finsert=new JFrame("INSERT");
			 finsert.setLayout(null);
			 
			 lUsername=new JLabel("Username");
			 lEnrollNo=new JLabel("Enrolment No.");
			 lName=new JLabel("Name");
			 lBranch=new JLabel("Branch");
			 lSem=new JLabel("Semester");
			 lPassword=new JLabel("Password");
			 
			 tUsername=new JTextField();
			 tEnrollNo=new JTextField();
			 tName=new JTextField();
			 pass=new JPasswordField();
			 
			 lUsername.setBounds(300,100,100,30);
			 lEnrollNo.setBounds(300,155,100,30);
			 lName.setBounds(300,210,100,30);
			 lBranch.setBounds(300,265,100,30);
			 lSem.setBounds(300,320,100,30);
			 lPassword.setBounds(300,375,100,30);
			 
			 tUsername.setBounds(410,100,170,30);
			 tEnrollNo.setBounds(410,155,170,30);
			 tName.setBounds(410,210,170,30);
			 pass.setBounds(410,375,170,30);
			 
			 insert=new JButton("INSERT");
			 insert.addActionListener(this);
			 insert.setBounds(500,500,150,30);
			 
			 branch=new Choice();
			 branch.add("CSE");
			 branch.add("ME");
			 branch.add("CE");
			 branch.add("EE");
			 
			 sem=new Choice();
			 sem.add("1");
			 sem.add("2");
			 sem.add("3");
			 sem.add("4");
			 sem.add("5");
			 sem.add("6");
			 sem.add("7");
			 sem.add("8");
			 
			 branch.setBounds(410,265,0,0);
			 sem.setBounds(410,320,0,0);
			 finsert.add(lUsername);
			 finsert.add(lEnrollNo);
			 finsert.add(lName);
			 finsert.add(lBranch);
			 finsert.add(lSem);
			 finsert.add(lPassword);
			 
			 finsert.add(tUsername);
			 finsert.add(tEnrollNo);
			 finsert.add(tName);
			 
			 finsert.add(pass);
			 finsert.add(branch);
			 finsert.add(sem);
			 finsert.add(insert);
			 
			 
			 
			 finsert.setSize(900,900);
			 finsert.setVisible(true);
			 
			 //finsert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==insert)
		{
			String uname=tUsername.getText();
			String eno=tEnrollNo.getText();
			String name=tName.getText();
			String bra=branch.getSelectedItem();
			int semes=Integer.parseInt(sem.getSelectedItem());
			String password=new String(pass.getText());
			
			
			try
		    {
				//JOptionPane.showMessageDialog(finsert,"Loading");
				Class.forName("com.mysql.jdbc.Driver");
				//JOptionPane.showMessageDialog(finsert,"Driver Loaded");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/0187cs161034","root","rootwdp");
				Statement st=con.createStatement();
				String qry="insert into profile values"+
				"('"+uname+"','"+eno+"','"+name+"','"+bra+"',"+semes+",'"+password+"')";
				int res=st.executeUpdate(qry);
				con.close();
				
				if(res!=0)
				{
					JOptionPane.showMessageDialog(finsert,"INSERTED");
				}
				else
					JOptionPane.showMessageDialog(finsert,"####ERROR#####");
			}
			catch(Exception sqle)
			{
				sqle.printStackTrace();
			}
		}
	}
	public static void main(String[] arg)
	{
		System.out.println("PLZZ Login first");
		//new Centre();
	}
}