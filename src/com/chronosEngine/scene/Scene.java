package com.chronosEngine.scene;

import com.chronosEngine.game.Game;

public abstract class Scene {
	protected Game gameRef;
	protected int ticks;
	
	public Scene(Game gameRef){
		this.gameRef = gameRef;
	}
	
	public abstract void Update();
	public abstract void Draw();
}
