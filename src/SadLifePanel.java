import java.awt.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class SadLifePanel extends JPanel{
	
	private final int WIDTH = 1008, HEIGHT = 492;//images are height 504
	private int speed = 24;
	private Timer timer;
	private Player player;
	private Chapter1 level1;
	private Menu menu;
	private CutScene scene;
	private ColorScene colorScene;
	private ChapterScene chapterScene;
	private SettingScene settingScene;
	private JButton moveOn, back;
	private boolean addB = false;
	private Sound sound;
	
	public SadLifePanel() {

		try {
			sound = new Sound();
			sound.volumeControl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		level1 = new Chapter1(new ImageIcon("src\\Images\\backgroundImg.png"));
		player = new Player(new Point(WIDTH/2, HEIGHT-132), 48, 96, new ImageIcon("src\\Images\\playerImg.png"));
		
		menu = new Menu(this);
		colorScene = new ColorScene(this);
		chapterScene = new ChapterScene(this);
		settingScene = new SettingScene(this);
		
		moveOn = new JButton("Move on");
		back = new JButton("Back");
		
		moveOn.setBounds(Global.width - 100, Global.height-25, 100, 25);
		back.setBounds(0, 0, 75, 25);
		
		moveOn.setBackground(Color.WHITE);
		back.setBackground(Color.WHITE);
		
		moveOn.addActionListener(new ButtonListener());
		back.addActionListener(new ButtonListener());
		
		moveOn.setVisible(false);
		back.setVisible(false);
		
		add(moveOn);
		add(back);
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		setLayout(null);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
		sound.play();
	}
	
	private void addA() {
		menu = new Menu(this);
		colorScene = new ColorScene(this);
		chapterScene = new ChapterScene(this);
		settingScene = new SettingScene(this);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == moveOn) {
				Global.cutScene = 0;
				moveOn.setVisible(false);
			}
			if(event.getSource() == back) {
				Global.MenuScene = true;
				Global.level1Scene = false;
				Global.ColorScene = false;
				Global.ChaptersScene = false;
				Global.SettingScene = false;
				addB = false;
				removeAll();
				addA();
			}
		}
	}
	
	private void addB() {
		remove(back);
		back.setVisible(true);
		add(back);
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		if(Global.cutScene == 0) {
			if(Global.level1Scene == true) {
				level1.paint(this, page);
				player.paint(this, page);
				
			}
			if(Global.MenuScene == true) {
				menu.paint(this, page);
				addB = false;
			}
			else {
				if(addB == false || this.getComponentCount() < 1) {
					addB();
					addB = true;
				}
			}
			if(Global.ColorScene == true) {
				colorScene.paint(this, page);
			}
			if(Global.ChaptersScene == true) {
				chapterScene.paint(this, page);
			}
			if(Global.SettingScene == true) {
				settingScene.paint(this, page);
			}
			
		}
		if(Global.cutScene > 0) {
			scene = new CutScene(Global.cutScene);
			scene.paint(this, page);
			
			moveOn.setVisible(true);
			add(moveOn);
		}
	}
	
	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.setLeft(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.setRight(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.setDown(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.setUp(true);
			}
			if(event.getKeyCode() == KeyEvent.VK_E) {
				player.pickUp(true);
			}
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {
				player.setLeft(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				player.setRight(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_S) {
				player.setDown(false);
			}
			if(event.getKeyCode() == KeyEvent.VK_W) {
				player.setUp(false);
			}
		}
	}

	
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			repaint();
			try {
				sound.volumeControl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Global.level1Scene == true) {
				if(Global.cutScene == 0)
					player.move();
					
			}
		}
	}
	
}
	
	

