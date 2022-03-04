import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu {
	private ImageIcon image;
	private JPanel ths;
	private JButton startB, settingsB, colorsB, chapterB;
	
	public Menu(JPanel ths) {
		this.ths = ths;
		image = new ImageIcon("src\\Images\\menuImage.png");
		
		ths.setLayout(null);
		
		startB = new JButton("Start");
		settingsB = new JButton("Settings");
		colorsB = new JButton("Colors");
		chapterB = new JButton("Chapters");
		
		startB.setBounds(Global.width/2 - 100, 200, 200, 50);
		chapterB.setBounds(Global.width/2 - 100, 250, 200, 50);
		colorsB.setBounds(Global.width/2 - 100, 300, 200, 50);
		settingsB.setBounds(Global.width/2 - 100, 350, 200, 50);
		
		startB.setBackground(Color.WHITE);
		chapterB.setBackground(Color.WHITE);
		colorsB.setBackground(Color.WHITE);
		settingsB.setBackground(Color.WHITE);
		
		startB.addActionListener(new ButtonListener());
		chapterB.addActionListener(new ButtonListener());
		colorsB.addActionListener(new ButtonListener());
		settingsB.addActionListener(new ButtonListener());
		
		ths.add(startB);
		ths.add(chapterB);
		ths.add(colorsB);
		ths.add(settingsB);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == startB) {
				Global.MenuScene = false;
				Global.level1Scene = true;
				ths.removeAll();
			}
			if(event.getSource() == chapterB) {
				Global.ChaptersScene = true;
				Global.MenuScene = false;
				ths.removeAll();
			}
			if(event.getSource() == colorsB) {
				Global.ColorScene = true;
				Global.MenuScene = false;
				ths.removeAll();
			}
			if(event.getSource() == settingsB) {
				Global.SettingScene = true;
				Global.MenuScene = false;
				ths.removeAll();
			}
		}
	}
	
	public Menu(ImageIcon image, JPanel ths) {
		this.image = image;
		this.ths = ths;
	}
	
	public void paint(Component ths, Graphics page) {
		image.paintIcon(ths, page, 0, 0);
	}
	
}
