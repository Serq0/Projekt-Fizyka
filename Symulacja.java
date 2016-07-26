package paka;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;



public class Symulacja extends JFrame {
	public Symulacja(int r, int e){
		System.out.println(r+" "+e);
		rr=r;
		ee=e;
		setTitle("Symulacja");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
public int bg=1;
public int rr;
public int ee;
	

	public void paint(Graphics g){
		double x;
		double y;
		double skala = 0;
		Random random = new Random();
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(bg==0){
			g2d.setColor(Color.BLACK);
			g2d.fillOval(-400, -100, 1550, 1550);
			g2d.setColor(Color.GREEN);
			g2d.fillOval(20, 30, 560, 560);
			
			g2d.setColor(Color.BLACK);
			g2d.fillOval(300, 300, 1, 1);
			bg=1;
		}
		g2d.setColor(Color.BLACK);
		g2d.fillOval(-400, -100, 1550, 1550);
		
		skala=300/(double)rr;
		for(int i=0;i<ee;i++)
		{
			//rr=rr*(int)skala;
		//	x = random.nextInt(rr-0+1)+0;
		//	y = random.nextInt(rr-0+1)+0;
			x = 0 + (rr - 0) * random.nextDouble();
			y = 0 + (rr - 0) * random.nextDouble();
			
			if (((x * x) + (y * y)) <= (rr*rr)) 
			{
				g2d.setColor(Color.RED);
			}
			else{
				g2d.setColor(Color.WHITE);
			}
			x=x*skala;
			y=y*skala;
			int full=1;
			if (full==1)
			{
				g2d.fillOval(300+(int)x, 300+(int)y, 2, 2);
				g2d.fillOval(300-(int)x, 300+(int)y, 2, 2);
				g2d.fillOval(300+(int)x, 300-(int)y, 2, 2);
				g2d.fillOval(300-(int)x, 300-(int)y, 2, 2);
			}
			if (full==0)
			{
				g2d.fillOval((int)x*2,(int)y*2, 6, 6);
			}
			if(i>=30000)
			{
				break;
			}
		}
		
	}
	



}