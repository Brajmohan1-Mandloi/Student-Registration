import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Login implements ActionListener
{
	JFrame flogin;
	JLabel lUname,lPassword;
	JTextField tUname;
	JPasswordField pass;
	JButton login;
	public Login()
	{
			flogin=new JFrame("LOGIN");
			flogin.setLayout(null);	
			
			lUname=new JLabel("Username");
			lUname.setBounds(460,200,100,30);
			
			lPassword=new JLabel("Password");
			lPassword.setBounds(460,300,100,30);
			
			tUname=new JTextField();
			tUname.setBounds(610,200,250,30);
			
			pass=new JPasswordField();
			pass.setBounds(610,300,250,30);
			
			login=new JButton("LOGIN");
			login.setBounds(700,500,100,50);
			login.addActionListener(this);
			
			flogin.add(lUname);
			flogin.add(tUname);
			flogin.add(lPassword);
			flogin.add(pass);
			flogin.add(login);
			
			flogin.setSize(700,700);
			flogin.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			//String username=tuname.getText();
			//String password=new String(pass.getText());
			try
			{
				String uname=tUname.getText();
				String password=new String(pass.getText());
				
				JOptionPane.showMessageDialog(flogin,"Username ="+uname+" pass ="+password);
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/0187cs161034","root","rootwdp");
				
				String qry="select * from admin where username ='"+uname+"' and password='"+password+"'" ;
				Statement st=con.createStatement();
				JOptionPane.showMessageDialog(flogin,"selected");
				ResultSet res=st.executeQuery(qry);
				if(!res.next())
				{
					JOptionPane.showMessageDialog(flogin,"no match");
				}
				else
				{
					JOptionPane.showMessageDialog(flogin,"match");
					new Centre();
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
		new Login();
	}
}