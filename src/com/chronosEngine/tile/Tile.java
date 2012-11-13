package com.chronosEngine.tile;

import com.chronosEngine.game.Camera;
import com.chronosEngine.game.Screen;
import com.chronosEngine.resource.ImageResource;
import com.chronosEngine.resource.ResourceLoader;
import com.chronosEngine.sprite.Sprite;

public class Tile {
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VoidTile = new Tile(0, (ImageResource)ResourceLoader.getResource("tileSheet"));
	public static final Tile GrassTile_LCliff = new Tile(1, (ImageResource)ResourceLoader.getResource("tileSheet"));
	public static final Tile GrassTile_C = new Tile(2, (ImageResource)ResourceLoader.getResource("tileSheet"));
	public static final Tile GrassTile_RCliff = new Tile(3, (ImageResource)ResourceLoader.getResource("tileSheet"));
	
	protected byte id;
	protected Sprite sprite;
	
	public Tile(int id, ImageResource tileSheet){
		this.id = (byte) id;
		
		if(tiles[id] != null) throw new RuntimeException("Duplicate id at: " + id);
		tiles[id] = this;
		
		sprite = new Sprite(tileSheet.getImage().getSubimage((id * 16) % 256, (id * 16) / 256, 16, 16));
	}
	
	public void Draw(Screen screen, int xPos, int yPos, Camera camera){
		screen.Draw(sprite, xPos, yPos, camera);
	}
}
