package com.chronosEngine.component;

import java.util.ArrayList;

import com.chronosEngine.game.Screen;
import com.chronosEngine.sprite.SpriteFont;

public class Dialogue {
	private ArrayList<String> strings = new ArrayList<String>();
	private int currLine = -1;
	private int caretPos;
	private int tick;
	public boolean finished;
	
	public void addLine(String str){
		strings.add(str);
	}
	
	public void removeLine(int index){
		strings.remove(index);
	}
	
	public void setCurrentLine(int line){
		currLine = line;
	}
	
	public void rewind(){
		currLine = 0;
		caretPos = 0;
		tick = 0;
		finished = false;
	}
	
	public void Draw(Screen screen, int x, int y){
		if(currLine < 0 || currLine >= strings.size()){
			throw new RuntimeException("Dialogue index out of bounds");
		}
		
		for(int i=0;i<currLine;i++){
			SpriteFont.DrawString(strings.get(i), screen, x, y + i * 16);
		}
		
		caretPos = tick / 5;
		
		if(caretPos >= strings.get(currLine).length()){
			if(currLine >= strings.size() - 1){
				currLine = strings.size() - 1;
				caretPos = strings.get(currLine).length();
				finished = true;
			}
			else{
				currLine++;
				caretPos = 0;
				tick = 0;
			}
		}
		
		tick++;
		
		SpriteFont.DrawString(strings.get(currLine).substring(0, caretPos), screen, x, y + currLine * 16);
	}
}
