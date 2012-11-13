package com.chronosEngine.scene;

import com.chronosEngine.game.Game;
import com.chronosEngine.scene.scenes.GameScene;
import com.chronosEngine.scene.scenes.IntroScene;

public class Scenes {
	public static IntroScene intro;
	public static GameScene game;
	
	public Scenes(Game gameRef){
		intro = new IntroScene(gameRef);
		game = new GameScene(gameRef);
	}
}
