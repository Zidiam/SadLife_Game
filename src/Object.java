import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Object {
	private int height, width;
	private Point location;
	private boolean solid, interact;
	private ImageIcon image;
	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	private Color color;
	private String type;//item or object
	private String name;//item name
	private boolean inventory = false;
	private boolean colorI = false;
	private String thingNeeded = "";
	private ArrayList<Object> objects;
	private boolean follow = false;
	private boolean eventOver = false;
	private int currentImage = 0;
	private int cutScene = 0;
	private boolean left = true;
	private boolean right = false;
	private ImageIcon leftI;
	private ImageIcon rightI;
	private String speach = "";
	private boolean visible = true;
	
	public Object() {
		
	}
	
	public Object(int width, int height, Color color, Point location, ImageIcon image, boolean interact, boolean solid) {
		this.height = height;
		this.width = height;
		this.color = color;
		this.location = location;
		this.image = image;
		this.interact = interact;
		this.solid = solid;
		this.type = "object";
	}
	
	public void setVisible(boolean a) {
		visible = a;
	}
	
	public void setSpeach(String talk) {
		speach = talk;
	}
	
	public void setLeftImage(ImageIcon image) {
		leftI = image;
	}
	
	public void setRightImage(ImageIcon image) {
		rightI = image;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public void setRight(boolean a) {
		right = a;
	}
	
	public void setLeft(boolean a) {
		left = a;
	}
	
	public void setCutScene(int a) {
		cutScene = a;
	}
	
	public int getCutScene() {
		return cutScene;
	}
	
	public void setEventOver(boolean event) {
		eventOver = event;
	}
	
	public boolean getEventOver() {
		return eventOver;
	}
	
	public void setImages(ArrayList<ImageIcon> images) {
		this.images = images;
	}
	
	public ArrayList<ImageIcon> getImages(){
		return images;
	}
	
	public boolean getFollow() {
		return follow;
	}
	
	public void setFollow(boolean follow) {
		this.follow = follow;
	}
	
	public boolean getInteract() {
		return interact;
	}
	public void destroy() {
		Global.allObjects.remove(this);
		
		for(int x = 0; x < objects.size(); x++) {
			Global.allObjects.remove(objects.get(x));
		}
		
		this.objects = new ArrayList<Object>();
	}
	
	public void setObjects(ArrayList<Object> objects) {
		Global.allObjects.addAll(objects);
		this.objects = objects;
	}
	
	public ArrayList<Object> getObjects(){
		return objects;
	}
	
	public void setThingNeeded(String thingNeeded) {
		this.thingNeeded = thingNeeded;
	}
	
	public String getThingNeeded() {
		return thingNeeded;
	}
	
	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}
	
	public boolean getInventory() {
		return inventory;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public boolean isInteract() {
		return interact;
	}

	public void setInteract(boolean interact) {
		this.interact = interact;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return name;
	}
	
	public void setColorI(boolean colorI) {
		this.colorI = colorI;
	}
	
	public boolean getColorI(boolean colorI) {
		return colorI;
	}
	
	public boolean collision(Point player) {
		if(-Global.cx + player.x <= location.x + width && -Global.cx + player.x + 48 >= location.x && 
			-Global.cy + player.y >= location.y - height &&
			-Global.cy + player.y + 96 <= location.y + height + 24) {
			return true;
		}
		return false;
	}
	
	public void paint(Component ths, Graphics page) {
		if(eventOver) {
			if(right == true) {
				rightI.paintIcon(ths, page, location.x, location.y);
			}
			if(left == true) {
				leftI.paintIcon(ths, page, location.x, location.y);
			}
			else {
				images.get(currentImage).paintIcon(ths, page, location.x, location.y);
				if(currentImage < images.size() - 1) {
					currentImage ++;
				}
				else
					currentImage = 0;
			}
		}
		else {
			if(visible == false) {
				//dont paint
			}
			else if((type.equals("color") || type.equals("touch")) && colorI == false) {
				image.paintIcon(ths, page, location.x + Global.cx, location.y + Global.cy);
			}
			else if(type.equals("color") && colorI == true) {
				image.paintIcon(ths, page, location.x, location.y);
			}
			else if(type.equals("item") && inventory == false) {
				image.paintIcon(ths, page, location.x + Global.cx, location.y + Global.cy);
			}
			else if(type.equals("item") && inventory == true) {
				image.paintIcon(ths, page, location.x, location.y);
			}
			else {
				if(!type.equals("collide")) {
					Color temp = page.getColor();
					page.setColor(color);
					page.fillRect(location.x + Global.cx, location.y + Global.cy, width, height);
					page.setColor(temp);
				}
			}
		}
	}
	
}
