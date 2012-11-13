package com.chronosEngine.resource;

import java.awt.image.BufferedImage;

public class ImageResource extends Resource{
	private BufferedImage image;

	public ImageResource(String name, BufferedImage image) {
		super(name);
		
		this.image = image;
	}
	
	public BufferedImage getImage(){
		return image;
	}

}
