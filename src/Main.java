import javax.swing.JFrame;

public class Main {

	public Main(String tipo) {

		JFrame frame = new JFrame();
		Painel1 painel1 = new Painel1(tipo);

		frame.add(painel1);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("JOGO DA COBRINHA NAQUELE PIQUE");

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}