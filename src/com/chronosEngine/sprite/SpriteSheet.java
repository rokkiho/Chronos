package com.chronosEngine.sprite;

import java.awt.image.BufferedImage;

import com.chronosEngine.resource.ImageResource;

public class SpriteSheet{
	BufferedImage image;
	
	public SpriteSheet(ImageResource resource) {
		this.image = resource.getImage();
	}
	
	public BufferedImage getSubImage(int x, int y, int w, int h){
		return image.getSubimage(x * w, y * h, w, h);
	}

}
