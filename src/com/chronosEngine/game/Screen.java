package com.chronosEngine.game;

import com.chronosEngine.sprite.Sprite;
import com.chronosEngine.util.PixelGrabber;

public class Screen {
	public static enum Effect{
		none, fadeOut, fadeIn
	}
	
	public int width;
	public int height;
	public int[] pixels;
	
	private final int transparentColor = PixelGrabber.grabPixel(255, 0, 255);
	private final int gridColor = PixelGrabber.grabPixel(160, 0, 160);
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
	}
	
	public void flush(){
		for(int i=0;i<pixels.length;i++){
			pixels[i] = 0;
		}
	}
	
	public void Draw(Sprite sprite, int xPos, int yPos, Camera camera){
		for(int y=0;y<sprite.height;y++){
			if(yPos + y - camera.y < 0 || yPos + y - camera.y >= height) continue;
			for(int x=0;x<sprite.width;x++){
				if(xPos + x - camera.x < 0 || xPos + x - camera.x >= width) continue;
				int col = sprite.pixels[x + y * sprite.width];
				if(col < 0 && col != transparentColor && col != gridColor) pixels[(x + xPos - camera.x) + (y + yPos - camera.y) * width] = col;
			}
		}
	}
	
	public void DrawString(int[] pixels, int xPos, int yPos){
		for(int y=0;y<16;y++){
			if(y + yPos < 0 || y + yPos >= height) continue;
			for(int x=0;x<16;x++){
				if(x + xPos < 0 || x + xPos >= width) continue;
				int col = pixels[x + y * 16];
				if(col < 0 && col != 0xff000000) this.pixels[(x + xPos) + (y + yPos) * width] = col;
			}
		}
	}
}
