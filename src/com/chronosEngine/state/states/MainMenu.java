package com.chronosEngine.state.states;

import java.awt.event.KeyEvent;

import com.chronosEngine.component.MenuList;
import com.chronosEngine.game.Game;
import com.chronosEngine.resource.ImageResource;
import com.chronosEngine.resource.ResourceLoader;
import com.chronosEngine.sprite.Sprite;
import com.chronosEngine.sprite.SpriteFont;
import com.chronosEngine.state.State;
import com.chronosEngine.state.states.GamePlay.gameInitState;

public class MainMenu extends State{
	private Sprite logo;
	private Sprite arrow;
	private MenuList menu;
	
	public MainMenu(Game gameRef) {
		super(gameRef);
		
		logo = new Sprite((ImageResource) ResourceLoader.getResource("logo"));
		arrow = new Sprite((ImageResource) ResourceLoader.getResource("arrow"));
		
		menu = new MenuList();
		menu.addMenu("Continue");
		menu.addMenu("New Game");
		menu.addMenu("Options");
		menu.addMenu("Exit");
		
		menu.setCurrMenu("Continue");
	}

	public void Update() {
		if(gameRef.inputManager.isKeyPressed(KeyEvent.VK_UP) || gameRef.inputManager.isKeyPressed(KeyEvent.VK_LEFT)) menu.alterCurrMenu(-1);
		if(gameRef.inputManager.isKeyPressed(KeyEvent.VK_DOWN) || gameRef.inputManager.isKeyPressed(KeyEvent.VK_RIGHT)) menu.alterCurrMenu(1);
		if(gameRef.inputManager.isKeyReleased(KeyEvent.VK_ENTER)){
			if(menu.getCurrMenu() == menu.indexOf("Exit")){
				gameRef.stop();
			}
			if(menu.getCurrMenu() == menu.indexOf("New Game")){
				gameRef.stateManager.setCurrentState(gameRef.gamePlay);
				gameRef.gamePlay.init(gameInitState.newGame);
			}
			if(menu.getCurrMenu() == menu.indexOf("Continue")){
				gameRef.stateManager.setCurrentState(gameRef.gamePlay);
				gameRef.gamePlay.init(gameInitState.load);
			}
		}
	}

	public void Draw() {
		gameRef.screen.Draw(logo, (Game.width / 2) - (logo.width / 2), 100 - (logo.height / 2), gameRef.camera);
		
		for(int i=0;i<4;i++){
			SpriteFont.DrawString(menu.getMenu(i), gameRef.screen, (Game.width / 2) - (menu.getMenu(i).length() * 16 / 2), (Game.height / 2) + (i * 26));
		}
		
		gameRef.screen.Draw(arrow, (Game.width / 2) - (menu.getMenu(menu.getCurrMenu()).length() * 16 / 2) - 50, (Game.height / 2) - 4 + (menu.getCurrMenu() * 26), gameRef.camera);
	}

}
