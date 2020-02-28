import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOver {
	
	private JFrame frame;
	public static int score;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver fim = new GameOver(score);
					fim.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GameOver(int score) {
		frame = new JFrame();
		frame.setTitle("Fim de Jogo");
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel fim = new JLabel("GAME OVER!");
		fim.setBounds(70, 60, 100, 25);
		frame.getContentPane().add(fim);
		
		JLabel aviso = new JLabel("Para voltar ao menu, feche as");
		aviso.setBounds(30, 80, 170, 25);
		frame.getContentPane().add(aviso);
		
		JLabel aviso2 = new JLabel("janelas abertas acima dele.");
		aviso2.setBounds(35, 100, 170, 25);
		frame.getContentPane().add(aviso2);
		
		JLabel pontos = new JLabel("Score Final: " + score);
		pontos.setBounds(70, 120, 170, 25);
		frame.getContentPane().add(pontos);
		
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
