import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class CutScene {
	
	private int number;
	
	public CutScene(int number) {
		this.number = number;
	}
	
	public void paint(Component ths, Graphics page) {
		Color old = page.getColor();
		if(number == 1) {
			page.setColor(Color.BLACK);
			page.fillRect(0, 0, Global.width, Global.height);
			page.setColor(Color.WHITE);
			page.drawString("You get an instant flash back", 0, 75);
			page.drawString("You are at the vet with your old dog", 0, 100);
			page.drawString("Your dog is very sick", 0, 125);
			page.drawString("The vet tells you to say your last good bye's", 0, 175);
			page.drawString("You see your dog's eyes slowely drift away while you hold him crying", 0, 225);
		}
		
		if(number == 2) {
			page.setColor(new Color(139,69,19));
			page.fillRect(0, 0, Global.width, Global.height);
			page.setColor(Color.WHITE);
			page.drawString("A cute puppy has been found by you!", 0, 75);
			page.drawString("The puppy jumps into your arms", 0, 100);
			page.drawString("The puppy instantely starts licking you and wagging its tail", 0, 125);
			page.drawString("Your bad memories slowly faid away", 0, 175);
			page.drawString("You decide to keep the puppy since it brings you joy", 0, 225);
			page.drawString("You start to see a new color...", 0, 275);
			page.drawString("The color is Brown! You notice this because the dog is brown!", 0, 325);
			page.drawString("You set down the pup and it starts following you...", 0, 375);
		}
		if(number == 3) {
			page.setColor(Color.BLUE);
			page.fillRect(0, 0, Global.width, Global.height);
			page.setColor(Color.WHITE);
			page.drawString("*Conversation with person*", 0, 75);
			page.drawString("He wanted to jump off the bridge and die", 0, 100);
			page.drawString("you ask him why and he explains how hard like has been to him", 0, 125);
			page.drawString("you share your story about crippling debt and family problems", 0, 175);
			page.drawString("you two become to bond and he slowly gets off the bridge", 0, 225);
			page.drawString("You start to see a new color...", 0, 275);
			page.drawString("The color is Blue! You notice this because the guys shirt is blue!", 0, 325);
			page.drawString("You start leaving but he follows you since he is now your new friend", 0, 375);
		}
		
		page.setColor(old);
		
	}
}
