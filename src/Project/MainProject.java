package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.JFrame;
public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Orders");
		frame.setBounds(200, 200, 700, 600);
		GridLayout layout= new GridLayout(4,3,5,5);
		frame.setLayout(layout);
		
		JPanel pn1=new JPanel();
		pn1.setLayout(new FlowLayout());
		JTextField tf=new JTextField("",40);
		pn1.add(tf);
		JButton but1=new JButton("Enter");
		pn1.add(but1);
		TextArea textarea = new TextArea();
		pn1.add(textarea);
		textarea.setColumns(15);
		textarea.setRows(1);
		frame.add(pn1);
		
		JPanel pn2=new JPanel();
		pn2.setLayout(new FlowLayout());
		JButton but2=new JButton("Display all the orders");
		pn2.add(but2);
		JButton but3=new JButton("Display all the unpaid orders");
		pn2.add(but3);
		JButton but4=new JButton("Sum all the unpaid orders");
		pn2.add(but4);
		JButton but5=new JButton("Display current company's unpaid orders");
		pn2.add(but5);
		JButton but6=new JButton("Sum current company's unpaid orders");
		pn2.add(but6);
		frame.add(pn2);
		
		JFrame frame2=new JFrame("Login");
		frame2.setBounds(100, 100, 320, 200);
		frame2.setLayout(null);
		FlowLayout fl=new FlowLayout(FlowLayout.CENTER,10,10);
		frame2.setLayout(fl);
		JPanel pn3=new JPanel();
		JPanel pn5=new JPanel();
		JPanel pn4=new JPanel();

		JLabel l1= new JLabel("User Name");
		JTextField name=new JTextField("",20);
		JLabel l2= new JLabel("Password");
		JPasswordField password=new JPasswordField("",20);
		password.setEchoChar('*');
		JButton loginb1=new JButton("Login");
		loginb1.setBounds(100,100,200,150);
		pn3.add(l1);
		pn3.add(name);
		pn5.add(l2);
		pn5.add(password);
		pn4.add(loginb1);
		
		frame2.add(pn3,BorderLayout.WEST);
		frame2.add(pn5,BorderLayout.WEST);
		frame2.add(pn4,BorderLayout.SOUTH);
		frame2.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame2.setLocationRelativeTo(null);
		frame2.setResizable(false);
		frame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				
				System.exit(0);
			}
		});
		
		JButton addinfo=new JButton("Add/update order");
		JPanel pn6=new JPanel();
		pn6.add(addinfo);
		pn6.setLayout(new FlowLayout());
		
		
		List list=new List();
		frame.add(list);
		frame.add(pn6);
		frame.setVisible(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				
				System.exit(0);
			}
		});
		 String url = "jdbc:sqlserver://localhost:1433;databaseName=ProjectDatabase";
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String userName="sa";
		 String userPwd="qwerty";
		 
		 JFrame frame3=new JFrame("add/update order");
		 frame3.setBounds(100, 100, 500, 450);
		 frame3.setLayout(null);
		 frame3.setLayout(fl);
		 JPanel addpn1=new JPanel();
		 JLabel addid=new JLabel("CompanyID   ");
		 addpn1.add(addid);
		 JTextField idfield= new JTextField(30);
		 addpn1.add(idfield);
		 JPanel addpn2=new JPanel();
		 JLabel addname= new JLabel("CompanyName");
		 addpn2.add(addname);
		 JTextField namefield= new JTextField(30);
		 addpn2.add(namefield);
		 JPanel addpn3=new JPanel();
		 JLabel addorderid= new JLabel("OrderID         ");
		 addpn3.add(addorderid);
		 JTextField orderidfield= new JTextField(30);
		 addpn3.add(orderidfield);
		 JPanel addpn4=new JPanel();
		 JLabel addamt= new JLabel("OrderAmt  ");
		 addpn4.add(addamt);
		 JTextField amtfield= new JTextField(30);
		 addpn4.add(amtfield);
		 JPanel addpn5=new JPanel();
		 JLabel adddate= new JLabel("OrderDate  ");
		 addpn5.add(adddate);
		 JTextField datefield= new JTextField(30);
		 addpn5.add(datefield);
		 JPanel addpn6=new JPanel();
		 JLabel addstatus= new JLabel("OrderStatus  ");
		 addpn6.add(addstatus);
		 JTextField statusfield= new JTextField(30);
		 addpn6.add(statusfield);
		 JPanel addpn7=new JPanel();
		 JButton add=new JButton("Add");
		 addpn7.add(add);
		 JButton update=new JButton("Update by OrderID");
		 addpn7.add(update);
		 frame3.add(addpn1,BorderLayout.CENTER);
		 frame3.add(addpn2,BorderLayout.CENTER);
		 frame3.add(addpn3,BorderLayout.CENTER);
		 frame3.add(addpn4,BorderLayout.CENTER);
		 frame3.add(addpn5,BorderLayout.CENTER);
		 frame3.add(addpn6,BorderLayout.CENTER);
		 frame3.add(addpn7,BorderLayout.CENTER);
		 frame3.setVisible(false);
		 frame3.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frame.setVisible(false);
					
					System.exit(0);
				}
			});
		 addinfo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 frame3.setVisible(true);
			 }
			
		 });
		 
		 add.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 Connection dbConn= null;
					 dbConn = DriverManager.getConnection(url,userName,userPwd);
					 Statement stat=dbConn.createStatement();
					 String companyid=idfield.getText();
					 String name=namefield.getText();
					 String orderid=orderidfield.getText();
					 String amt=amtfield.getText();
					 String date=datefield.getText();
					 String status=statusfield.getText();
					 int resultset=stat.executeUpdate("INSERT into Orders(CompanyID,CompanyName,OrderID,OrderAmt,OrderDate,OrderStatus) values('"+companyid+"','"+name+"','"+orderid+"','"+amt+"','"+date+"','"+status+"')");
					 if(resultset>0) {
						 JOptionPane.showMessageDialog(null, "New order is successfully added");
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
					 String message=E.getMessage();
					 JOptionPane.showMessageDialog(null, "Error! "+message);
				 }
			 }
			
		 });
		 
		 update.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 Connection dbConn= null;
					 dbConn = DriverManager.getConnection(url,userName,userPwd);
					 Statement stat=dbConn.createStatement();
					 String companyid=idfield.getText();
					 String name=namefield.getText();
					 String orderid=orderidfield.getText();
					 String amt=amtfield.getText();
					 String date=datefield.getText();
					 String status=statusfield.getText();
					 int resultset=stat.executeUpdate("UPDATE Orders SET CompanyID='"+companyid+"',CompanyName='"+name+"',OrderAmt='"+amt+"',OrderDate='"+date+"',OrderStatus='"+status+"' WHERE OrderID='"+orderid+"'");
					 if(resultset>0) {
						 JOptionPane.showMessageDialog(null, "One order is successfully updated");
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
					 String message=E.getMessage();
					 JOptionPane.showMessageDialog(null, "Error! "+message);
				 }
			 }
			
		 });
		 
		 loginb1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 Connection dbConn= null;
					 dbConn = DriverManager.getConnection(url,userName,userPwd);
					 Statement stat=dbConn.createStatement();
					 String username=name.getText();
					 String Password=new String(password.getPassword());
					 ResultSet resultset=stat.executeQuery("Select * from Login where UserName='"+username+"'and Password='"+Password+"'");
					 if(resultset.next()) {
					 		JOptionPane.showMessageDialog(null, "Welcome, "+username);
					 		frame.setVisible(true);
					 		frame2.setVisible(false);
					 }
					 else {
					 		JOptionPane.showMessageDialog(null, "Invalid username or password");
					 	}
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		 
		 but1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(list.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
					 else {
						 list.removeAll();
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
				
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		 
		 but2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(list.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select * from Orders");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
					 else {
						 list.removeAll();
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select * from Orders");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		
		 but3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(list.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE OrderStatus = 'unpaid'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
					 else {
						 list.removeAll();
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE OrderStatus = 'unpaid'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
				
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		 
		 but4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(textarea.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select sum(OrderAmt) from Orders WHERE OrderStatus = 'unpaid'");
						 while (resultset.next()) {
							 String total= resultset.getString(1);
							 textarea.append("Total= "+total);
						 } 
					 }
					 else {
						 textarea.setText("");
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 ResultSet resultset=stat.executeQuery("Select sum(OrderAmt) from Orders WHERE OrderStatus = 'unpaid'");
						 while (resultset.next()) {
							 String total= resultset.getString(1);
							 textarea.append("Total= "+total);
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		 
		 but5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(list.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE OrderStatus = 'unpaid' and CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
					 else {
						 list.removeAll();
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select * from Orders WHERE OrderStatus = 'unpaid' and CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 int id=resultset.getInt("CompanyID");
							 String name=resultset.getString("CompanyName");
							 int orderid=resultset.getInt("OrderID");
							 double amt=resultset.getDouble("OrderAmt");
							 String date=resultset.getString("OrderDate");
							 String status=resultset.getString("OrderStatus");
							 
							 list.add("[CompanyID: "+id+"]     [Name: "+name+"]     [OrderID: "+orderid+"]     [Amount: "+amt+"]     [Date: "+date+"]     [Status: "+status+"]");
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
		 
		 but6.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 if(textarea.equals(null)) {
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select sum(OrderAmt) from Orders WHERE OrderStatus = 'unpaid' and CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 String total= resultset.getString(1);
							 textarea.append("Total= "+total);
						 } 
					 }
					 else {
						 textarea.setText("");
						 Connection dbConn= null;
						 dbConn = DriverManager.getConnection(url,userName,userPwd);
						 Statement stat=dbConn.createStatement();
						 String text=tf.getText();
						 ResultSet resultset=stat.executeQuery("Select sum(OrderAmt) from Orders WHERE OrderStatus = 'unpaid' and CompanyName like"+"'%"+text+"%'");
						 while (resultset.next()) {
							 String total= resultset.getString(1);
							 textarea.append("Total= "+total);
						 } 
					 }
				 }
				 catch(SQLException E) {
					 E.printStackTrace();
				 }
			 }
			
		 });
	}

}
