package com.chronosEngine.game;

public class Camera {
	public int x;
	public int y;
	
	public int xMin;
	public int xMax;
	public int yMin;
	public int yMax;
	
	public Camera(int x, int y, Screen screen){
		this.x = x;
		this.y = y;
		
		this.xMin = 0;
		this.xMax = screen.width;
		this.yMin = 0;
		this.yMax = screen.height;
	}
}
