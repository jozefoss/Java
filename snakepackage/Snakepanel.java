package snakepackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Snakepanel extends JPanel implements Runnable, KeyListener {
	
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500, HEIGHT = 500;
	
	private Thread thread;
	private boolean running;
	private boolean right = true, left = false, up = false, down = false;
	private Body b;
	private ArrayList<Body>snake;
	private int xCoor = 10, yCoor = 10, size =5;
	private int ticks = 0;
	private Point point;
	private ArrayList<Point> points;
	private int pkt;
	private Random r;
	public Snakepanel() {
	setFocusable(true);
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
	addKeyListener(this);
	snake = new ArrayList<Body>();
	points = new ArrayList<Point>();
	r = new Random();
	start();
	}
	
	
public void start() {
	running = true;
	thread = new Thread(this);
	thread.start();
	
}
public void stop() {
	running = false;
	try {
		thread.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}

public void tick() {
	if(snake.size() ==0) {
		b = new Body(xCoor, yCoor, 10);
				snake.add(b);
	}
	ticks++;
	
	if (ticks >500000 )
	{
		if(right) xCoor++;
		if(left) xCoor--;
		if(up) yCoor--;
		if(down) yCoor++;
		
		ticks =0;
		b=new Body(xCoor, yCoor, 10);
		snake.add(b);
		
		if(snake.size() > size) {
			snake.remove(0);
		}
	}
	if(points.size()==0) {
		int xCoor = r.nextInt(49);
		int yCoor = r.nextInt(49);
		
		point = new Point(xCoor, yCoor, 10);
		points.add(point);
		

	}
	
	for(int i = 0; i < points.size() ; i++) {
		if(xCoor == points.get(i).getxCoor() && yCoor == points.get(i).getyCoor()) {
			size++;
			points.remove(i);
			i++;
			pkt++;
		}
	}
	
	for(int i=0; i<snake.size(); i++) {
		if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor())
		{
			if(i != snake.size()-1) {
				System.out.println("See you");
				stop();
			}
		}
	}
	
	

	/* if(xCoor == 0 && !right) {
		xCoor = 50;
	}

	if(xCoor == 50 && !left) {
		xCoor = 0;		
	}
	if(yCoor < 0 && !down) {
		yCoor =50;	
}
	if(yCoor > 50 && !up ) {
		yCoor = 1;	
} */
	if(xCoor > 49 ||  xCoor <1 || yCoor >49 || yCoor <1) 
	{
		System.out.println("See you");
		stop(); }
	
}



public void paint(Graphics g) {
	g.clearRect(0, 0, WIDTH, HEIGHT);
	g.setColor(Color.BLACK );
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	for(int i = 0 ; i <WIDTH/10; i++)
	{
		g.drawLine(i *10, 0, i *10, HEIGHT);
	}
	
	for(int i = 0 ; i <HEIGHT/10; i++)
	{
		g.drawLine(0, i *10, HEIGHT, i*10);
	}
	for(int i = 0; i<snake.size(); i++) {
		snake.get(i).draw(g);
	}
	for(int i = 0 ; i<points.size(); i++) {
		points.get(i).draw(g);
	}
	g.setColor(Color.RED);
	g.drawString(Integer.toString(pkt), 30, 30);
	
}


@Override
public void run() {
	while(running) {
		tick();
		repaint();
	}
	
}

@Override
public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if(key==KeyEvent.VK_RIGHT && !left) {
		right = true;
		up = false;
		down = false;
	}
	if(key==KeyEvent.VK_LEFT && !right) {
		left = true;
		up = false;
		down = false;
	}
	if(key==KeyEvent.VK_UP && !down) {
		up = true;
		left = false;
		right = false;
	}
	if(key==KeyEvent.VK_DOWN && !up) {
		down = true;
		left = false;
		right = false;
	}
	
}



@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
