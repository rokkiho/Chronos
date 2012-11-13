package com.chronosEngine.state.states;

import com.chronosEngine.game.Game;
import com.chronosEngine.scene.SceneManager;
import com.chronosEngine.scene.scenes.GameScene;
import com.chronosEngine.scene.scenes.IntroScene;
import com.chronosEngine.state.State;

public class GamePlay extends State{
	private SceneManager sceneManager;
	
	private IntroScene intro;
	private GameScene game;

	public GamePlay(Game gameRef) {
		super(gameRef);
		
		sceneManager = new SceneManager();
		
		intro = new IntroScene(0, gameRef);
		game = new GameScene(1, gameRef);
		
		sceneManager.addScene(intro);
		sceneManager.addScene(game);
		
		sceneManager.nextScene(intro);
	}

	public void Update() {
		if(intro.finished && sceneManager.getCurrScene() == intro.getID()){
			sceneManager.nextScene(game);
		}
		
		sceneManager.Update();
	}

	public void Draw() {
		sceneManager.Draw();
	}
}
