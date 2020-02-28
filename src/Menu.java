import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu {
	
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu menu = new Menu();
					menu.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		frame = new JFrame();
		frame.setTitle("Menu Principal");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Configurando Botão de Jogar
		JButton play = new JButton("JOGAR");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Painel2(); //Chama menu para escolha do tipo de cobra
			}
		});
		play.setBounds(150, 300, 150, 40);
		frame.getContentPane().add(play);
		
		frame.setLocationRelativeTo(null);
	}
}