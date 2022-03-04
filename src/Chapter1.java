import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Chapter1 {
	private ImageIcon background;
	private ArrayList<Object> theObjects;
	
	public Chapter1() {
		createMap();
	}
	
	public Chapter1(ImageIcon background) {
		this.background = background;
		createMap();
	}
	
	public Chapter1(ImageIcon background, ArrayList<Object> allObjects) {
		this.background = background;
		this.theObjects = allObjects;
	}
	
	public void paint(Component ths, Graphics page) {
		page.setColor(Color.BLACK);
		//behind the backgroundImg
		page.fillRect(0, 0, Global.width + 48, Global.height + 48);
		
		background.paintIcon(ths, page, Global.cx, Global.cy - 508);
		
		
		
		for(int x = 0; x < Global.allObjects.size(); x++) {
			Global.allObjects.get(x).paint(ths, page);
		}
	}
	
	private void createMap() {
		theObjects = new ArrayList<Object>();
		
		Object wrench = new Object(48, 48, Color.BLACK, new Point(1248, Global.height - 420), new ImageIcon("src\\Images\\wrenchImg.png"), true, false);
		wrench.setName("wrench");
		wrench.setType("item");
		theObjects.add(wrench);
		
		Object flashback1 = new Object(48, 4800, Color.BLACK, new Point(1632, Global.height - 4800), new ImageIcon(), true, false);
		flashback1.setType("collide");
		flashback1.setCutScene(1);
		theObjects.add(flashback1);
		
		Object dog = new Object(48, 48, new Color(123,63,0), new Point(1920, Global.height - 84), new ImageIcon("src\\Images\\dogTrashImg.png"), true, true);
		dog.setType("color");
		dog.setName("Dog");
		dog.setFollow(true);
		dog.setThingNeeded("");
		ArrayList<ImageIcon> tem = new ArrayList<ImageIcon>();
		tem.add(new ImageIcon("src\\Images\\dogRightImg.png"));
		dog.setLeftImage(new ImageIcon("src\\Images\\dogLeftImg.png"));
		dog.setRightImage(new ImageIcon("src\\Images\\dogRightImg.png"));
		dog.setImages(tem);
		dog.setCutScene(2);
		theObjects.add(dog);
		
		Object wrenchNeed = new Object(48, 48, Color.BLACK, new Point(1536, Global.height - 84), new ImageIcon("src\\Images\\wrenchFixImg.png"), true, true);
		wrenchNeed.setType("touch");
		
		ArrayList<Object> temp1 = new ArrayList<Object>();
		
		for(int x = 0; x < 20; x++) {
			temp1.add(new Object(48, 48, Color.BLACK, new Point(1584, Global.height - 36 - x*48), new ImageIcon(), false, true));
		}
		
		wrenchNeed.setObjects(temp1);
		wrenchNeed.setThingNeeded("wrench");
		
		theObjects.add(wrenchNeed);
		
		for(int x = 0; x < 1000; x++) {
			theObjects.add(new Object(48, 48, Color.BLACK, new Point(x*48, Global.height - 36), new ImageIcon(), false, true));
		}
		
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(240, Global.height - 516), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(384, Global.height - 516), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(768, Global.height - 708), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(1248, Global.height - 372), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(0, Global.height - 372), new ImageIcon(), false, true));
		
		theObjects.add(new Object(48, 48, Color.BLACK, new Point(384, Global.height - 228), new ImageIcon(), false, true));
		
		//Second part
		
		Object playerH = new Object(48, 48, Color.BLACK, new Point(3936, Global.height - 84), new ImageIcon(), true, true);
		playerH.setType("touch");
		
		temp1 = new ArrayList<Object>();
		
		for(int x = 0; x < 8; x++) {
			temp1.add(new Object(48, 48, new Color(123,63,0), new Point(3936, Global.height - 36 - x*48), new ImageIcon(), false, true));
		}
		
		for(int x = 0; x < 10; x++) {
			Object tempd = new Object(48, 48, new Color(123,63,0), new Point(3936, Global.height - 420 - x*48), new ImageIcon(), false, true);
			tempd.setVisible(false);
			theObjects.add(tempd);
		}
		
		playerH.setObjects(temp1);
		playerH.setThingNeeded("axe");
		theObjects.add(playerH);
		
		Object axe = new Object(48, 48, Color.BLACK, new Point(2688, Global.height - 852), new ImageIcon("src\\Images\\axeImg.png"), true, false);
		axe.setName("axe");
		axe.setType("item");
		theObjects.add(axe);
		
		Object personH = new Object(48, 48, Color.BLUE, new Point(4272, Global.height - 228), new ImageIcon("src\\Images\\playerSaveImg.png"), true, true);
		personH.setType("color");
		personH.setName("Person");
		personH.setFollow(true);
		personH.setThingNeeded("");
		tem = new ArrayList<ImageIcon>();
		tem.add(new ImageIcon("src\\Images\\personImg.png"));
		personH.setLeftImage(new ImageIcon("src\\Images\\personImg.png"));
		personH.setRightImage(new ImageIcon("src\\Images\\personImg.png"));
		personH.setImages(tem);
		personH.setCutScene(3);
		theObjects.add(personH);
		
		
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(3216, Global.height - 276), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(3120, Global.height - 468), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(3600, Global.height - 564), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(3696, Global.height - 756), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(3120, Global.height - 948), new ImageIcon(), false, true));
		theObjects.add(new Object(48, 48, new Color(123,63,0), new Point(2688, Global.height - 804), new ImageIcon(), false, true));
		
		
		Global.allObjects.addAll(theObjects);
	}
}
