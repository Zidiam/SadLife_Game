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
import javax.swing.border.LineBorder;

public class ChapterScene {
	private ImageIcon image;
	private JPanel ths;
	private JButton chapter1, chapter2;
	private JLabel chapter1L, chapter2L;
	private boolean addB = false;
	private boolean chapter2U = false;
	
	public ChapterScene(JPanel ths) {
		this.ths = ths;
		image = new ImageIcon("src\\Images\\chaptersImage.png");
		
		ths.setLayout(null);
		
		chapter1 = new JButton();
		chapter1L = new JLabel("Friends can bring color");
		
		chapter2 = new JButton();
		chapter2L = new JLabel("A world without color");
		
		chapter1.setIcon(new ImageIcon("src\\Images\\chapter1.png"));
		chapter2.setIcon(new ImageIcon("src\\Images\\chapter2.png"));
		
		chapter1L.setForeground(Color.WHITE);
		chapter2L.setForeground(Color.WHITE);
		
		chapter1.setBounds(0, 100, Global.width, 100);
		chapter1L.setBounds(Global.width/2 - 150/2, 135, 150, 25);
		
		chapter2.setBounds(0, 225, Global.width, 100);
		chapter2L.setBounds(Global.width/2 - 150/2, 260, 150, 25);
		
		chapter1.addActionListener(new ButtonListener());
		chapter2.addActionListener(new ButtonListener());
	}
	
	private void removal() {
		ths.remove(chapter1);
		ths.remove(chapter1L);
		
		ths.remove(chapter2);
		ths.remove(chapter2L);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == chapter1) {
				Global.ChaptersScene = false;
				Global.level1Scene = true;
				ths.removeAll();
			}
			
			if(event.getSource() == chapter2 && chapter2U == true) {
				Global.ChaptersScene = false;
				//Global.level2Scene = true;
				ths.removeAll();
			}
			
		}
	}
	
	public void addB() {
		if (addB == false){
			ths.add(chapter1L);
			ths.add(chapter1);
			ths.add(chapter2L);
			ths.add(chapter2);
			addB = true;
		}
	}
	
	public ChapterScene(ImageIcon image, JPanel ths) {
		this.image = image;
		this.ths = ths;
	}
	
	public void paint(Component thsP, Graphics page) {
		addB();
		image.paintIcon(thsP, page, 0, 0);
	}
	
}
