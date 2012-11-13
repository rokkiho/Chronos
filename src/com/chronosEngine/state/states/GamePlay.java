package com.chronosEngine.state.states;

import com.chronosEngine.game.Game;
import com.chronosEngine.scene.Scene;
import com.chronosEngine.scene.Scenes;
import com.chronosEngine.state.State;

public class GamePlay extends State{
	public Scene nextScene;

	public GamePlay(Game gameRef) {
		super(gameRef);
		
		nextScene = Scenes.intro;
	}

	public void Update() {
		nextScene.Update();
	}

	public void Draw() {
		nextScene.Draw();
	}
}
