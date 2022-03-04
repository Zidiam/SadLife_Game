import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorScene {
	private ImageIcon image;
	private JPanel ths;
	private JButton white, black, brown, blue;
	private JLabel info;
	private boolean addB = false;
	private ArrayList<JButton> colors = new ArrayList<JButton>();
	
	public ColorScene(JPanel ths) {
		this.ths = ths;
		image = new ImageIcon("src\\Images\\colorsImage.png");
		
		ths.setLayout(null);
		
		info = new JLabel();
		info.setBounds(0, Global.height - 50, Global.width, 50);
		
		white = new JButton("White");
		black = new JButton("Black");
		brown = new JButton("Brown");
		blue = new JButton("Blue");
		
		white.setBounds(70, 100, 200, 50);
		black.setBounds(295, 100, 200, 50);
		brown.setBounds(520, 100, 200, 50);
		blue.setBounds(745, 100, 200, 50);
		
		brown.setBackground(new Color(123,63,0));
		white.setBackground(Color.WHITE);
		black.setBackground(Color.BLACK);
		blue.setBackground(Color.BLUE);
		
		black.setForeground(Color.WHITE);
		brown.setForeground(Color.BLACK);
		blue.setForeground(Color.WHITE);
		
		white.addActionListener(new ButtonListener());
		black.addActionListener(new ButtonListener());
		brown.addActionListener(new ButtonListener());
		blue.addActionListener(new ButtonListener());
		
		colors.add(brown);
		colors.add(blue);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			ths.remove(info);
			if(event.getSource() == white) {
				info.setForeground(Color.WHITE);
				info.setText("The color white usually represents light and goodness but for you its just more emptiness");
			}
			if(event.getSource() == black) {
				info.setForeground(Color.BLACK);
				info.setText("You have this color because your mind is stuck in a never ending black void that is consuming your life slowly");
			}
			if(event.getSource() == brown) {
				info.setForeground(new Color(123,63,0));
				info.setText("A little hope has been granted to you with this color but you have long ways to go.");
			}
			if(event.getSource() == blue) {
				info.setForeground(Color.BLUE);
				info.setText("You saved a life which granted you a little more happyness that is only temporary.");
			}
			ths.add(info);
			
		}
	}
	
	public void addB() {
		if (addB == false){
			ths.add(white);
			ths.add(black);
			ths.add(info);
			for(int x = 0; x < Global.Colors.size(); x++) {
				ths.add(colors.get(x));
			}
			addB = true;
		}
	}
	
	public ColorScene(ImageIcon image, JPanel ths) {
		this.image = image;
		this.ths = ths;
	}
	
	public void paint(Component thsP, Graphics page) {
		addB();
		image.paintIcon(thsP, page, 0, 0);
	}
	
}
