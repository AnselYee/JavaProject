package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		
		
		
		
		
		List list=new List();
		frame.add(list);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				
				System.exit(0);
			}
		});
		 String url = "jdbc:sqlserver://10.22.6.188:1433;databaseName=ProjectDatabase";
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String userName="sa";
		 String userPwd="qwerty";
		 
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
