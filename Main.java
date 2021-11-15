package Assignment3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
* 
* @author Srikar Vodeti 1223253239
* @author Chandana Bandlamudi 1220495432
* version 1.0
* 
* @author Chandana Bandlamudi 1220495432
* version 2.0
*/ 
public class Main extends JFrame{
	
	public Main() {
		WorkSpace drawArea = new WorkSpace();
		add(drawArea);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Connections");
		JMenuItem menuItem0 = new JMenuItem("Clustering");
		JMenuItem menuItem1 = new JMenuItem("UserConnect");
		menu.add(menuItem0);
		menu.add(menuItem1);

		menuBar.add(menu);
		setJMenuBar(menuBar);
		menuItem0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 

					drawArea.callCluster();
				}
			});
		
		menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 

					drawArea.userconnect();
				}
			});
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500, 500);
		main.setVisible(true);
		}
}
