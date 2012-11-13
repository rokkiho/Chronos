package com.chronosEngine.state;

import com.chronosEngine.game.Game;

public abstract class State {
	protected final Game gameRef;
	
	public State(Game gameRef){
		this.gameRef = gameRef;
	}
	
	public abstract void Update();
	
	public abstract void Draw();
}
