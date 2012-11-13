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
		height = 40;
		
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
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				getTile(x, y).Draw(gameRef.screen, x << modifier, y << modifier, gameRef.camera);
			}
		}
	}
}
