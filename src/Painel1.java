import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Painel1 extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;

	//Setando tamanho da janela
	private static final int WIDTH = 500, HEIGHT = 500;
	//Thread
	private Thread thread;
	//Mantem o jogo rodando
	private boolean running;
	//Variaveis para movimentar a cobra
	private boolean right = true, left = false, up = false, down = false;
	
	//Cobra
	private Corpo c;
	private ArrayList<Corpo> snake;
	private int size = 5;
	private String tipo;
	
	//Fruta
	private Fruta fruta;
	private ArrayList<Fruta> frutas;
	private ArrayList<Fruta> obstaculos;
	private Random r;
	
	private int xCoor = 10, yCoor = 10;
	private int ticks = 0;
	private int score = 0;

	public Painel1(String tipo) {
		
		this.tipo = tipo;
		
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		
		snake = new ArrayList<Corpo>();
		frutas = new ArrayList<Fruta>();
		obstaculos = new ArrayList<Fruta>();
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tick() {
		if (snake.size() == 0) {
			c = new Corpo(xCoor, yCoor, 10, tipo);
			snake.add(c);
		}
		ticks++;
		if (ticks > 250000) {
			if (right)
				xCoor++;
			if (left)
				xCoor--;
			if (up)
				yCoor--;
			if (down)
				yCoor++;

			ticks = 0;

			c = new Corpo(xCoor, yCoor, 10, tipo);
			snake.add(c);
			if (snake.size() > size) {
				snake.remove(0);
			}
		}
		if(frutas.size() == 0) {
			int xCoor = r.nextInt(49);
			int yCoor = r.nextInt(49);
			
			fruta = new Fruta(xCoor, yCoor, 10);
			frutas.add(fruta);
		}
		
		
		for(int i = 0; i < frutas.size(); i++) {
			if(xCoor == frutas.get(i).getxCoor() && yCoor == frutas.get(i).getyCoor()) {
				if(frutas.get(i).getTipo() == "bomb") {
					new GameOver(score);
					stop();
				}else if(frutas.get(i).getTipo() == "decrease") {
					size = 5;
					while(snake.size()!=5) {
						snake.remove(0);
					}
					score++;
				}else if(frutas.get(i).getTipo() == "big") {
					size += 2;
					score++;
					score++;
				}else {
					score++;
					size ++;
				}
				
				if(c.getTipo()=="Star") {
					this.score += (frutas.get(i).getScore()*2);
				}else if(c.getTipo()=="Comum" || c.getTipo()=="Kitty") {
					this.score += frutas.get(i).getScore();
				}

				
				frutas.remove(i);
				i++;
			}
		}
		
		//Colisão com parte do corpo da cobra
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()){
				if(i != snake.size()-1) {
					new GameOver(score);
					stop();
				}
			}
		}
		
		/*if(xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49) {
			new GameOver();
			stop();
		}*/
		if(xCoor < 0) {
			xCoor = 49;
		}
		if(yCoor < 0) {
			yCoor = 49;
		}
		if(xCoor > 49) {
			xCoor = 0;
		}
		if(yCoor > 49) {
			yCoor = 0;
		}
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (int i = 0; i < WIDTH / 10; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for (int i = 0; i < WIDTH / 10; i++) {
			g.drawLine(0, i * 10, HEIGHT, i * 10);
		}
		
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for(int i = 0; i < frutas.size(); i++) {
			frutas.get(i).draw(g);
		}
		
		for(int i = 10;i < 20; i++) {	
			fruta = new Fruta(30, i, 10, "obstaculo");
			obstaculos.add(fruta);
			fruta = new Fruta(i, 30, 10,"obstaculo");
			obstaculos.add(fruta);
		}
		for(int i = 20; i < 25; i++) {
			fruta = new Fruta(30, i, 10, "obstaculo");
			obstaculos.add(fruta);
			fruta = new Fruta(i, 30, 10, "obstaculo");
			obstaculos.add(fruta);
		}
		for(int i = 30; i < 35; i++) {
			fruta = new Fruta(30, i, 10, "obstaculo");
			obstaculos.add(fruta);
			fruta = new Fruta(i, 30, 10, "obstaculo");
			obstaculos.add(fruta);
		}
		
		for(int i = 0; i < obstaculos.size(); i++){
			obstaculos.get(i).draw(g);
		}
		
		for(int i = 0; i < obstaculos.size(); i++) {
			if(tipo == "Kitty") {
				break;
			}
			if(xCoor == obstaculos.get(i).getxCoor() && yCoor == obstaculos.get(i).getyCoor()) {
				new GameOver(score);
				stop();
				break;
			}
		}
	}

	@Override
	public void run() {
		while (running) {
			tick();
			repaint();
		}

	}

	@Override

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		if (key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		if (key == KeyEvent.VK_UP && !down) {
			up = true;
			right = false;
			left = false;
		}
		if (key == KeyEvent.VK_DOWN && !up) {
			right = false;
			down = true;
			left = false;
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
