package com.chronosEngine.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class InputManager implements KeyListener{
	private HashMap<Integer, Key> keys = new HashMap<Integer, Key>();
	
	public InputManager(Game game){
		game.addKeyListener(this);
		
		keys.put(KeyEvent.VK_UP, new Key());
		keys.put(KeyEvent.VK_DOWN, new Key());
		keys.put(KeyEvent.VK_LEFT, new Key());
		keys.put(KeyEvent.VK_RIGHT, new Key());
		keys.put(KeyEvent.VK_ENTER, new Key());
		keys.put(KeyEvent.VK_ENTER, new Key());
	}
	
	public void keyPressed(KeyEvent e) {
		if(keys.containsKey(e.getKeyCode())){
			keys.get(e.getKeyCode()).toggle(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(keys.containsKey(e.getKeyCode())){
			keys.get(e.getKeyCode()).toggle(false);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean isKeyPressed(int keyCode){
		if(keys.containsKey(keyCode))
			return keys.get(keyCode).isPressed();
		return false;
	}
	
	public boolean isKeyDown(int keyCode){
		if(keys.containsKey(keyCode))
			return keys.get(keyCode).isDown();
		return false;
	}
	
	public boolean isKeyReleased(int keyCode){
		if(keys.containsKey(keyCode))
			return keys.get(keyCode).isReleased();
		return false;
	}
	
	public class Key{
		public boolean prevPressed;
		public boolean pressed;
		
		public void toggle(boolean toggle){
			prevPressed = pressed;
			pressed = toggle;
		}
		
		public boolean isDown(){
			if(prevPressed && pressed){
				prevPressed = pressed;
				pressed = false;
				return true;
			}
			return false;
		}
		
		public boolean isPressed(){
			if(!prevPressed && pressed){
				prevPressed = pressed;
				pressed = false;
				return true;
			}
			return false;
		}
		
		public boolean isReleased(){
			if(prevPressed && !pressed){
				prevPressed = pressed;
				pressed = false;
				return true;
			}
			return false;
		}
	}
	
}
