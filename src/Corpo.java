import java.awt.Color;
import java.awt.Graphics;

public class Corpo {
	
	private int xCoor, yCoor, width, height;
	private String tipo;
	
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

	public Corpo(int xCoor, int yCoor, int tileSize, String tipo) {
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void tick() {

	}
	public void draw(Graphics g) {
		if(tipo == "Comum") {
			g.setColor(Color.BLUE);
		}else if(tipo == "Kitty") {
			g.setColor(Color.RED);
		}else if(tipo == "Star") {
			g.setColor(Color.GREEN);
		}
		g.fillRect(xCoor * width, yCoor * height, width, height);
	}
}
