package Assignment3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
* 
* @author Srikar Vodeti 1223253239
* @author Chandana Bandlamudi 1220495432
* version 1.0
* 
* @author Chandana Bandlamudi 1220495432
* version 2.0
*/ 
public class City {
	private Rectangle bounds;
	private String label;
	
	public City(String label, int x, int y, int w, int h) {
		bounds = new Rectangle(x, y, w, h);
		this.label = label;
	}
	
	public int getX() {
		return bounds.x;
		}
	public int getY() { 
		return bounds.y; 
		}
	public String getLabel()
	{
		return label;
	}
	public void draw (Graphics g) {
		int x = bounds.x, y = bounds.y, h = bounds.height, w = bounds.width;
		g.drawRect(x, y, w, h);
		Color c = g.getColor();
		g.setColor(Color.white);
		g.fillRect(x + 1, y + 1, w - 1, h - 1);
		g.setColor(Color.red);
		g.setFont(new Font("Courier", Font.PLAIN, 10));
		g.drawString(label, x + w, y);
		g.setColor(c);
	}
	public void move(int x, int y) {
		bounds.x = x;
		bounds.y = y;
		}
	private Point center() {
		return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
	}
	public void drawConnect(City b, Graphics2D g) {
		g.drawLine(center().x, center().y, b.center().x, b.center().y);
	}
	public boolean contains(int x, int y) {
		if( (x >= bounds.x && x<= bounds.x + bounds.width) && (y >= bounds.y && y<= bounds.y + bounds.height) ) {

			return true;
		}
		else {

			return false;
		}
	}
}

