package com.chronosEngine.sprite;

import java.awt.image.BufferedImage;

import com.chronosEngine.resource.ImageResource;

public class Sprite {
	public int width;
	public int height;
	public int[] pixels;
	
	public Sprite(ImageResource image){
		this.width = image.getImage().getWidth();
		this.height = image.getImage().getHeight();
		
		pixels = new int[width * height];
		
		pixels = image.getImage().getRGB(0, 0, this.width, this.height, null, 0, this.width);
	}
	
	public Sprite(BufferedImage image){
		width = image.getWidth();
		height = image.getHeight();
		
		pixels = new int[width * height];
		
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
	}
}
