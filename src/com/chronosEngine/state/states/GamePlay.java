package com.chronosEngine.state.states;

import com.chronosEngine.game.Game;
import com.chronosEngine.scene.Scene;
import com.chronosEngine.scene.Scenes;
import com.chronosEngine.state.State;

public class GamePlay extends State{
	public enum gameInitState{
		load, newGame
	}
	
	public Scene nextScene;

	public GamePlay(Game gameRef) {
		super(gameRef);
	}
	
	public void init(gameInitState state){
		switch(state){
		case load:
			nextScene = Scenes.game;
			break;
		case newGame:
			nextScene = Scenes.intro;
			break;
		}
	}

	public void Update() {
		nextScene.Update();
	}

	public void Draw() {
		nextScene.Draw();
	}
}
