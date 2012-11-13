package com.chronosEngine.scene;

import com.chronosEngine.game.Game;

public abstract class Scene {
	protected final int id;
	protected Game gameRef;
	protected int ticks;
	public boolean finished;
	
	public Scene(int id,Game gameRef){
		this.id = id;
		this.gameRef = gameRef;
	}
	
	public int getID(){
		return id;
	}
	
	public abstract void Update();
	public abstract void Draw();
}
