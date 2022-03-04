import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingScene {
	private ImageIcon image;
	private JPanel ths;
	private JLabel volumeInfo;
	private JSlider volume;
	private boolean addB = false;
	
	public SettingScene(JPanel ths) {
		this.ths = ths;
		volume = new JSlider(JSlider.HORIZONTAL, 0, 80, 0);
		volume.setMajorTickSpacing(10);
		volume.setMinorTickSpacing(1);
		volume.addChangeListener(new SliderListener());
		volume.setBounds(0, Global.height/2 - 50 + 50, Global.width, 50);
		
		volume.setInverted(true);
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer(80), new JLabel("Mute") );
		labelTable.put( new Integer(0), new JLabel("Loud") );
		volume.setLabelTable(labelTable);

		volume.setPaintLabels(true);
		
		image = new ImageIcon("src\\Images\\settingsImage.png");
		
		ths.setLayout(null);
		
		volumeInfo = new JLabel("Volume:");
		volumeInfo.setForeground(Color.WHITE);
		volumeInfo.setBounds(Global.width/2 - 25, Global.height/2 - 50, 100, 50);
		
	}
	
	private class SliderListener implements ChangeListener{
		public void stateChanged(ChangeEvent event) {
			ths.remove(volumeInfo);
			Global.Volume = volume.getValue();
			volumeInfo.setText("Volume");
			ths.add(volumeInfo);
		}
		
	}
	
	public void addB() {
		if (addB == false){
			ths.add(volume);
			ths.add(volumeInfo);
			volume.setValue(Global.Volume);
			addB = true;
		}
	}
	
	public SettingScene(ImageIcon image, JPanel ths) {
		this.image = image;
		this.ths = ths;
	}
	
	public void paint(Component thsP, Graphics page) {
		addB();
		image.paintIcon(thsP, page, 0, 0);
	}
	
}
