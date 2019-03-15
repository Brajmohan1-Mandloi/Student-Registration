 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Centre implements ActionListener
{
	JFrame fcentre;
	JButton binsert,bupdte,bshow,bdelete,bexit;
	public Centre()
	{
		binsert=new JButton("Insert");
		binsert.addActionListener(this);
		bupdte=new JButton("Update");
		bupdte.addActionListener(this);
		bshow=new JButton("Show");
		bshow.addActionListener(this);
		bdelete=new JButton("Delete");
		bdelete.addActionListener(this);
		bexit=new JButton("Exit");
		bexit.addActionListener(this);
		fcentre=new JFrame("Centre");
		fcentre.setLayout(null);
		
		binsert.setBounds(400,200,200,100);
		bshow.setBounds(610,200,200,100);
		bupdte.setBounds(400,310,200,100);
		bdelete.setBounds(610,310,200,100);
		bexit.setBounds(550,500,100,30);
		fcentre.add(binsert);
		fcentre.add(bshow);
		fcentre.add(bupdte);
		fcentre.add(bdelete);
		fcentre.add(bexit);
		
		fcentre.setSize(500,500);
		fcentre.setVisible(true);
		fcentre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==binsert)
		{
			new Insert();
		}
		if(ae.getSource()==bshow)
		{
			new Show();
		}
		if(ae.getSource()==bupdte)
		{
			new Update();
		}
		if(ae.getSource()==bdelete)
		{
			new Delete();
		}
		if(ae.getSource()==bexit)
		{
			System.exit(0);
		}
	}
	public static void main(String[] arg)
	{
		System.out.println("PLZZ Login first");
		//new Centre();
	}
}