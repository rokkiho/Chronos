package com.chronosEngine.scene.scenes;

import com.chronosEngine.game.Game;
import com.chronosEngine.level.Level;
import com.chronosEngine.scene.Scene;

public class GameScene extends Scene{
	Level level;

	public GameScene(Game gameRef) {
		super(gameRef);
		
		level = new Level(gameRef);
		level.genTestLevel();
	}

	public void Update() {
		
	}

	public void Draw() {
		level.Draw();
	}

}
