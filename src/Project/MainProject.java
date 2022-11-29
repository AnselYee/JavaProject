package Project;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame=new Frame("Orders");
		frame.setBounds(200, 200, 500, 400);
		GridLayout layout= new GridLayout(4,3,5,5);
		frame.setLayout(layout);
		
		Panel pn1=new Panel();
		pn1.setLayout(new FlowLayout());
		TextField tf=new TextField("",40);
		pn1.add(tf);
		Button but1=new Button("Enter");
		pn1.add(but1);
		frame.add(pn1);
		
		Button but2=new Button("Display all the orders");
		Panel pn2=new Panel();
		pn2.setLayout(new FlowLayout());
		pn2.add(but2);
		Button but3=new Button("Display all the unpaid orders");
		pn2.add(but3);
		Button but4=new Button("Sum all the unpaid orders");
		pn2.add(but4);
		Button but5=new Button("Display current company's unpaid orders");
		pn2.add(but5);
		Button but6=new Button("Sum current company's unpaid orders");
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
	
	}

}
