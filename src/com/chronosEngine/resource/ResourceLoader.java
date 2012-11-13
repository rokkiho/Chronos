package com.chronosEngine.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResourceLoader {
	private static HashMap<String, Resource> resources = new HashMap<String, Resource>();
	
	public static void loadImage(String fileName, String name){
		if(resources.containsKey(name)){
			return;
		}
		
		try {
			BufferedImage image = ImageIO.read(ResourceLoader.class.getResourceAsStream(fileName));
			ImageResource imgResource = new ImageResource(name, image);
			
			resources.put(name, imgResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Resource getResource(String name){
		if(resources.containsKey(name)){
			return resources.get(name);
		}
		return null;
	}
}
