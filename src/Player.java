import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 * 
 */
public class Player {
	private Point location;
	private int height, width, jumpTime;
	private ImageIcon image;
	private boolean left, right, up, down, jumping;
	private boolean item = false;
	private boolean interaction = false;
	private Object itemO;
	private Object interactionO;
	private boolean color = false;
	private Object colorO;
	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	private int imageLocation = 2;
	private int stillLocation = 2;
	private int rightLocation = 3;
	private int leftLocation = 1;
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public Player() {
		this.jumpTime = 0;
		this.jumping = false;
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
		setUpImg();
	}
	
	public Player(Point location, int height, int width, ImageIcon image) {
		this.location = location;
		this.height = height;
		this.width = width;
		this.image = image;
		this.jumpTime = 0;
		this.jumping = false;
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
		setUpImg();
	}
	
	private void setUpImg() {
		//left
		leftLocation = 8;
		images.add(new ImageIcon("src\\Images\\left1B.png"));
		images.add(new ImageIcon("src\\Images\\left1B.png"));
		images.add(new ImageIcon("src\\Images\\left1B.png"));
		
		images.add(new ImageIcon("src\\Images\\left2B.png"));
		images.add(new ImageIcon("src\\Images\\left2B.png"));
		images.add(new ImageIcon("src\\Images\\left2B.png"));
		
		images.add(new ImageIcon("src\\Images\\left3B.png"));
		images.add(new ImageIcon("src\\Images\\left3B.png"));
		images.add(new ImageIcon("src\\Images\\left3B.png"));
		
		
		//still
		stillLocation = 9;
		images.add(new ImageIcon("src\\Images\\standingstillB.png"));
		
		//right
		rightLocation = 10;
		images.add(new ImageIcon("src\\Images\\right1B.png"));
		images.add(new ImageIcon("src\\Images\\right1B.png"));
		images.add(new ImageIcon("src\\Images\\right1B.png"));
		
		images.add(new ImageIcon("src\\Images\\right2B.png"));
		images.add(new ImageIcon("src\\Images\\right2B.png"));
		images.add(new ImageIcon("src\\Images\\right2B.png"));
		
		images.add(new ImageIcon("src\\Images\\right3B.png"));
		images.add(new ImageIcon("src\\Images\\right3B.png"));
		images.add(new ImageIcon("src\\Images\\right3B.png"));
	}
	
	private boolean moveRight(ArrayList<Object> solids) {
		boolean temp = true;
		for(int x = 0; x < solids.size(); x++) {
			if (solids.get(x).isSolid() == true && 
				location.x + 48 <= solids.get(x).getLocation().x + 48 + Global.cx &&
				location.x + 48 >= solids.get(x).getLocation().x + Global.cx &&
				location.y > solids.get(x).getLocation().y - 48*2 + Global.cy &&
				location.y + 48*2  < solids.get(x).getLocation().y + 48*2 + 48 + Global.cy) {
				temp = false;
			}
		}
		return temp;
	}
	
	private boolean moveLeft(ArrayList<Object> solids) {
		boolean temp = true;
		for(int x = 0; x < solids.size(); x++) {
			if(solids.get(x).isSolid() == true && 
				location.x <= solids.get(x).getLocation().x + 48 + Global.cx &&
				location.x >= solids.get(x).getLocation().x + Global.cx &&
				location.y > solids.get(x).getLocation().y - 48*2 + Global.cy &&
				location.y + 48*2 < solids.get(x).getLocation().y + 48*2 + 48 + Global.cy) {
				temp = false;
			}
		}
		return temp;
	}
	
	private boolean moveDown(ArrayList<Object> solids) {
		boolean temp = true;
		for(int x = 0; x < solids.size(); x++) {
			if (solids.get(x).isSolid() == true && 
				location.y == solids.get(x).getLocation().y - 48*2 + Global.cy &&
				location.x + 48 > solids.get(x).getLocation().x  + Global.cx &&
				location.x < solids.get(x).getLocation().x + 48 + Global.cx) {
				temp = false;
			}
		}
		
		return temp;
	}
	
	private boolean moveUp(ArrayList<Object> solids) {
		boolean temp = true;
		for(int x = 0; x < solids.size(); x++) {
			if (solids.get(x).isSolid() == true && 
				location.y == solids.get(x).getLocation().y + 48 + Global.cy &&
				location.x + 48 > solids.get(x).getLocation().x + Global.cx &&
				location.x < solids.get(x).getLocation().x + 48 + Global.cx) {
				temp = false;
			}
		}
		
		return temp;
	}
	
	public void move() {
		registerPickUp();
		
		if(Global.cx <= 0 && location.x >= 504) {
			if(left == true && moveLeft(Global.allObjects) == true) {
				Global.cx += 24;
				if(imageLocation > leftLocation) {
					imageLocation = leftLocation;
				}
				else if(imageLocation == 0) {
					imageLocation = leftLocation;
				}
				else {
					imageLocation --;
				}
			}
			if(right == true && moveRight(Global.allObjects) == true) {
				Global.cx -= 24;
				if(imageLocation < rightLocation) {
					imageLocation = rightLocation;
				}
				else if(imageLocation == images.size()-1) {
					imageLocation = rightLocation;
				}
				else {
					imageLocation ++;
				}
			}
		}
		if(location.x <= 504 || Global.cx >= 24) {
			Global.cx = 0;
			if(location.x - 24 >= 0) {
				if(left == true && moveLeft(Global.allObjects) == true) {
					location.x = location.x - 24;
					if(imageLocation > leftLocation) {
						imageLocation = leftLocation;
					}
					else if(imageLocation == 0) {
						imageLocation = leftLocation;
					}
					else {
						imageLocation --;
					}
				}
			}
			if(location.x + 24 <= 12096) {
				if(right == true && moveRight(Global.allObjects) == true) {
					location.x = location.x + 24;
					if(imageLocation < rightLocation) {
						imageLocation = rightLocation;
					}
					else if(imageLocation == images.size()-1) {
						imageLocation = rightLocation;
					}
					else {
						imageLocation ++;
					}
				}
			}
		}
		if(down == true && moveDown(Global.allObjects) == true) {
			Global.cy -= 24;
		}
		if(up == true && moveDown(Global.allObjects) == false && moveUp(Global.allObjects) == true) {
			jumping = true;
		}
		jumping();
		
		if(up == false && down == false && right == false && left == false) {
			imageLocation = stillLocation;
		}
	}
	
	public void jumping() {
		if(moveUp(Global.allObjects) == false) {
			jumping = false;
		}
		if(jumpTime > 20) {
			jumping = false;
		}
		if(jumping == true) {
			Global.cy += 12;
			jumpTime ++;
		}
		else {
			if(moveDown(Global.allObjects) == true) {
				jumpTime = 0;
				Global.cy -= 12;
			}
		}
	}
	
	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
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

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	public void pickUp(boolean pick) {
		if (pick == true && item == true) {
			itemO.setInventory(true);
			Global.Inventory.add(itemO);
			Global.cutScene = itemO.getCutScene();
			Global.allObjects.remove(itemO);
			item = false;
		}
		if (pick == true && color == true) {
			if(colorO.getFollow()) {
				colorO.setEventOver(true);
				Global.Following.add(colorO);
			}
			colorO.setColorI(true);
			Global.Colors.add(colorO.getColor());
			Global.cutScene = colorO.getCutScene();
			Global.allObjects.remove(colorO);
			color = false;
		}
		if (pick == true && interaction == true) {
			for(int x = 0; x < Global.Inventory.size(); x++) {
				if(interactionO.getThingNeeded().equals(Global.Inventory.get(x).getName())) {
					interactionO.destroy();
					Global.cutScene = Global.Inventory.get(x).getCutScene();
					Global.Inventory.remove(x);
					interaction = false;
				}
			}
		}
	}
	
	public void registerPickUp() {
		boolean ifItem = false;
		boolean interactionT = false;
		boolean colorT = false;
		for(int x = 0; x < Global.allObjects.size(); x++) {
			if(Global.allObjects.get(x).getType().equals("collide") && Global.allObjects.get(x).getInteract() == true && Global.allObjects.get(x).collision(location)) {
				Global.cutScene = Global.allObjects.get(x).getCutScene();
				Global.allObjects.remove(x);
			}
			if(Global.allObjects.get(x).getType().equals("item") && Global.allObjects.get(x).getInteract() == true && Global.allObjects.get(x).collision(location)) {
				ifItem = true;
				item = true;
				itemO = Global.allObjects.get(x);
			}
			if(Global.allObjects.get(x).getType().equals("touch") && Global.allObjects.get(x).getInteract() == true && Global.allObjects.get(x).collision(location)) {
				interactionT = true;
				interaction = true;
				interactionO = Global.allObjects.get(x);
			}
			if(Global.allObjects.get(x).getType().equals("color") && Global.allObjects.get(x).getInteract() == true && Global.allObjects.get(x).collision(location)) {
				colorT = true;
				color = true;
				colorO = Global.allObjects.get(x);
			}
			if(interactionT == false) {
				interaction = false;
			}
			if(ifItem == false) {
				item = false;
			}
		}
	}
	private boolean lastside = false;
	
	public void paint(Component ths, Graphics page) {
		//Following
		for(int x =0; x < Global.Following.size(); x++) {
			if(imageLocation >= rightLocation) {
				Global.Following.get(x).setLeft(false);
				Global.Following.get(x).setRight(true);
				Global.Following.get(x).setLocation(new Point(location.x - x*96 - 96, location.y + 48));
			}
			else if(imageLocation <= leftLocation) {
				Global.Following.get(x).setLeft(true);
				Global.Following.get(x).setRight(false);
				Global.Following.get(x).setLocation(new Point(location.x + x*96 + 96, location.y + 48));
			}
			Global.Following.get(x).paint(ths, page);
		}
		
		if(item == true) {
			Color temp = page.getColor();
			page.setColor(Color.WHITE);
			page.drawString("Press E to pick up " + itemO.getName(), itemO.getLocation().x + Global.cx, itemO.getLocation().y - 50 + Global.cy);
			page.setColor(temp);
		}
		if(color == true) {
			Color temp = page.getColor();
			page.setColor(Color.WHITE);
			page.drawString("Press E to pick up " + colorO.getName(), colorO.getLocation().x + Global.cx, colorO.getLocation().y - 50 + Global.cy);
			page.setColor(temp);
		}
		if(interaction == true) {
			Color temp = page.getColor();
			page.setColor(Color.WHITE);
			boolean haveItem = false;
			
			for(int x = 0; x < Global.Inventory.size(); x++) {
				if(Global.Inventory.get(x).getName().equals(interactionO.getThingNeeded())) {
					haveItem = true;
				}
			}
			if(haveItem == true)
				page.drawString("Press E to use the " + interactionO.getThingNeeded(), interactionO.getLocation().x + Global.cx, interactionO.getLocation().y + Global.cy - 50);
			else
				page.drawString("You still need to find a " + interactionO.getThingNeeded(), interactionO.getLocation().x + Global.cx, interactionO.getLocation().y + Global.cy - 50);
			page.setColor(temp);
		}
		
		if(Global.Inventory.size() >= 1) {
			Color temp = page.getColor();
			page.setColor(Color.WHITE);
			for(int x = 0; x < Global.Inventory.size(); x++) {
				page.fillOval(Global.width - 60, x*60, 60, 60);
				Global.Inventory.get(x).setLocation(new Point(Global.width - 48, x*60 + 6));
				Global.Inventory.get(x).paint(ths, page);
			}
		}
		
		System.out.println(imageLocation);
		images.get(imageLocation).paintIcon(ths, page, location.x, location.y);
	}
}
