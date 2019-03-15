import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Show implements ActionListener
{
	JFrame fshow;
	JLabel lUsername;
	JTextField tUsername;
	JButton show,exit;
	JTextArea display;
	
	public Show()
	{
		fshow=new JFrame("SHOW");
		fshow.setLayout(null);
		
		lUsername=new JLabel("Username");
		lUsername.setBounds(480,150,100,30);
		
		tUsername=new JTextField();
		tUsername.setBounds(610,150,250,30);
		
		show=new JButton("SHOW");
		show.setBounds(530,200,200,40);
		show.addActionListener(this);
		display=new JTextArea(10,10);
		display.setBounds(400,400,300,300);
		//display.setFont("Comic Sans MS");
		
		exit=new JButton("Exit");
		//exit.addActionListener(this);
		exit.setBounds(400,300,200,40);
		
		fshow.add(lUsername);
		fshow.add(tUsername);
		fshow.add(show);
		fshow.add(display);
		//fshow.add(exit);
		//fshow.add();
		//fshow.add();
		
		fshow.setSize(900,900);
		fshow.setVisible(true);
		//fshow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==show)
		{
			try
		    {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/0187cs161034","root","rootwdp");
				
				String usern=tUsername.getText();
				JOptionPane.showMessageDialog(fshow,"HII  "+usern);
				
				String qry="select * from profile where username='"+usern+"'" ;
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery(qry);
				if(res.next()){
					JOptionPane.showMessageDialog(fshow,"Name :"+res.getString(3)+"   Password :"+res.getString(6));
				display.setText("Name  :"+res.getString(3)+"\nEnrollment No : "+res.getString(2)+"\nBranch  :"+res.getString(4)
				+"\nSemester:"+res.getString(5));
				display.setFont(new Font("Serif", Font.ITALIC, 16));
				display.setEditable(false);
				
				}
				else
				{
					display.setText("NO record found!!\n Username :"+usern);
				}
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==exit)
		{
			//fshow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	public static void main(String[] arg)
	{
		System.out.println("PLZZ Login first");
		//new Centre();
	}
}
