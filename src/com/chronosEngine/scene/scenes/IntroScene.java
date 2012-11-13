package com.chronosEngine.scene.scenes;

import java.awt.event.KeyEvent;

import com.chronosEngine.component.Dialogue;
import com.chronosEngine.game.Game;
import com.chronosEngine.scene.Scene;
import com.chronosEngine.scene.Scenes;

public class IntroScene extends Scene{
	private Dialogue[] dialogue = new Dialogue[2];
	private int currDialogue;

	public IntroScene(Game gameRef) {
		super(gameRef);
		
		dialogue[0] = new Dialogue();
		{
			dialogue[0].addLine("???: wake up, dear god... wake up!");
			dialogue[0].addLine("     it's the temple, it has fallen!");
			dialogue[0].addLine("     everything's collapsing!");
			dialogue[0].setCurrentLine(0);
		}
		
		dialogue[1] = new Dialogue();
		{
			dialogue[1].addLine("chronos: hmph??");
			dialogue[1].setCurrentLine(0);
		}
		
		currDialogue = 0;
	}

	public void Update() {
		ticks++;
		
		if(gameRef.inputManager.isKeyReleased(KeyEvent.VK_ENTER)){
			if(dialogue[currDialogue].finished){
				currDialogue++;
			}
			if(currDialogue > dialogue.length - 1){
				currDialogue = dialogue.length - 1;
				gameRef.gamePlay.nextScene = Scenes.game;
			}
		}
	}

	public void Draw() {
		dialogue[currDialogue].Draw(gameRef.screen, 0, 5);
	}
}

