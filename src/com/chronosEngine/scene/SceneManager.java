package com.chronosEngine.scene;

import java.util.ArrayList;

public class SceneManager {
	public ArrayList<Scene> scenes = new ArrayList<Scene>();
	private int currPlayingScene = -1;
	
	public void addScene(Scene scene){
		scenes.add(scene);
	}
	
	public void removeScene(Scene scene){
		for(Scene s : scenes){
			if(s.equals(scene)){
				scenes.remove(s);
				return;
			}
		}
		
		throw new RuntimeException("Cannot find such scene");
	}
	
	public void nextScene(Scene next){
		for(Scene s : scenes){
			if(s.equals(next)){
				currPlayingScene = scenes.indexOf(s);
				return;
			}
		}
	}
	
	public int getCurrScene(){
		return currPlayingScene;
	}
	
	public void Update(){
		if(currPlayingScene == -1){
			return;
		}
		scenes.get(currPlayingScene).Update();
	}
	
	public void Draw(){
		if(currPlayingScene == -1){
			return;
		}
		scenes.get(currPlayingScene).Draw();
	}
}
