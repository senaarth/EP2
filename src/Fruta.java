import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Fruta {
	
	private int xCoor, yCoor, width, height, score;
	private String tipo;
	
	public Fruta(int xCoor, int yCoor, int tileSize) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
		
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("simple");
		tipos.add("bomb");
		tipos.add("decrease");
		tipos.add("big");
		
		Random random = new Random();
		int r = random.nextInt(4);
		
		this.tipo = tipos.get(r);
		
		if(tipo == "simples") {
			this.score = 1;
		}else if(tipo == "big") {
			this.score = 2;
		}else if(tipo == "decrease") {
			this.score = 0;
		}else if(tipo == "bomb") {
			this.score = 0;
		}else if(tipo == "obstaculo") {
			this.score = 0;
		}
	}
	
	public Fruta(int xCoor, int yCoor, int tileSize, String tipo) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
		this.tipo = tipo;
		
		if(tipo == "simples") {
			this.score = 1;
		}else if(tipo == "big") {
			this.score = 2;
		}else if(tipo == "decrease") {
			this.score = 0;
		}else if(tipo == "bomb") {
			this.score = 0;
		}else if(tipo == "obstaculo") {
			this.score = 0;
		}
		
		
	}

	public void tick() {

	}
	public void draw(Graphics g) {
		if(tipo == "simple") {
			g.setColor(Color.yellow);
		}else if(tipo == "bomb") {
			g.setColor(Color.RED);
		}else if(tipo == "big") {
			g.setColor(Color.CYAN);
		}else if(tipo == "decrease") {
			g.setColor(Color.WHITE);
		}else if(tipo == "obstaculo") {
			g.setColor(Color.DARK_GRAY);
		}
		g.fillRect(xCoor * width, yCoor * height, width, height);
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}