import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Painel2 {
	
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painel2 janela = new Painel2();
					janela.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Painel2() {
		frame = new JFrame();
		frame.setTitle("Tipo de Cobra");
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Botoes com Cada Tipo de Cobra
		JButton comum = new JButton("Comum");
		comum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Main("Comum");
			}
		});
		comum.setBounds(70, 60, 100, 25);
		frame.getContentPane().add(comum);
		
		JButton kitty = new JButton("Kitty");
		kitty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Main("Kitty");
			}
		});
		kitty.setBounds(70, 90, 100, 25);
		frame.getContentPane().add(kitty);
		
		JButton star = new JButton("Star");
		star.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Main("Star");
			}
		});
		star.setBounds(70, 120, 100, 25);
		frame.getContentPane().add(star);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
