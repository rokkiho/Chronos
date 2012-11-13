package com.chronosEngine.sprite;

import com.chronosEngine.game.Screen;
import com.chronosEngine.resource.ImageResource;

public class SpriteFont {
	private static SpriteSheet charSheet;
	public static String identifier = "ABCDEFGHIJKLMNOPQRSTUVWXYZ      " + 
									  "?!.,:;''\"\"";
	
	public static void loadFont(ImageResource sheet){
		charSheet = new SpriteSheet(sheet);
	}
	
	public static void DrawString(String str, Screen screen, int x, int y){
		str = str.toUpperCase();
		for(int i=0;i<str.length();i++){
			int charIndex = identifier.indexOf(str.charAt(i));
			if(charIndex >= 0){
				screen.DrawString(charSheet.getSubImage(charIndex % 32, charIndex / 32, 16, 16).getRGB(0, 0, 16, 16, null, 0, 16), x + (i * 16), y);
			}
		}
	}
}
