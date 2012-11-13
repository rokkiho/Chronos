package com.chronosEngine.level;

import com.chronosEngine.game.Game;
import com.chronosEngine.tile.Tile;

public class Level {
	public static int modifier = 4;
	public int width;
	public int height;
	public byte[][] tiles;
	
	private final Game gameRef;
	
	public Level(Game gameRef){
		this.gameRef = gameRef;
	}
	
	public void genTestLevel(){
		width = 30;
		height = 30;
		
		tiles = new byte[width][height];
		
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				tiles[x][y] = (byte)((x + (y * width)) % 4);
			}
		}
	}
	
	public void loadLevel(String fileName){
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || x >= width || y < 0 || y >= height) return Tile.VoidTile;
		
		return Tile.tiles[tiles[x][y]];
	}
	
	public void Draw(){
		int xMin = ((gameRef.camera.x + gameRef.camera.xMin) >> modifier);
		int xMax = ((gameRef.camera.x + gameRef.camera.xMax) >> modifier);
		int yMin = ((gameRef.camera.y + gameRef.camera.yMin) >> modifier);
		int yMax = ((gameRef.camera.y + gameRef.camera.yMax) >> modifier);
		
		if(xMin < 0) xMin = 0;
		if(xMax >= width) xMax = width - 1;
		if(yMin < 0) yMin = 0;
		if(yMax >= height) yMax = height - 1;
		
		for(int y=yMin;y<=yMax;y++){
			for(int x=xMin;x<=xMax;x++){
				getTile(x, y).Draw(gameRef.screen, x << modifier, y << modifier, gameRef.camera);
			}
		}
	}
}
