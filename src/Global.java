import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Global {
	public static int cx = 0, cy = 0;
	public static ArrayList<Object> allObjects = new ArrayList<Object>();
	public static ArrayList<Object> Inventory = new ArrayList<Object>();
	public static ArrayList<Object> Following = new ArrayList<Object>();
	public static ArrayList<Color> Colors = new ArrayList<Color>();
	public static int width = 1008;
	public static int height = 492;
	public static boolean gameOverScene = false;
	public static boolean MenuScene = true;
	public static boolean ChaptersScene = false;
	public static boolean SettingScene = false;
	public static boolean ColorScene = false;
	public static boolean level1Scene = false;
	public static int Volume = 40;
	public static int cutScene = 0;
}
