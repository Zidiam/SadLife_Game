import javax.swing.JFrame;

public class SadLifeGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("SadLife");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new SadLifePanel());
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
