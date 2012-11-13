package com.chronosEngine.component;

import java.util.ArrayList;

public class MenuList {
	private ArrayList<String> menus = new ArrayList<String>();
	private int currMenuIndex = -1;
	
	public void addMenu(String menu){
		for(String s : menus){
			if(s.equals(menu))
				return;
		}
		
		menus.add(menu);
	}
	
	public void removeMenu(String menu){
		for(String s : menus){
			if(s.equals(menu)){
				menus.remove(s);
				return;
			}
		}
	}
	
	public void setCurrMenu(String menu){
		for(String s : menus){
			if(s.equals(menu)){
				currMenuIndex = menus.indexOf(s);
			}
		}
	}
	
	public int getCurrMenu(){
		return currMenuIndex;
	}
	
	public void alterCurrMenu(int dir){
		currMenuIndex += dir;
		
		if(currMenuIndex < 0){
			currMenuIndex = 0;
		}
		if(currMenuIndex > menus.size() - 1){
			currMenuIndex = menus.size() - 1;
		}
	}
	
	public int indexOf(String menu){
		for(String s : menus){
			if(s.equals(menu)){
				return menus.indexOf(s);
			}
		}
		
		return -1;
	}
	
	public String getMenu(int index){
		if(index >= menus.size()){
			return null;
		}
		
		return menus.get(index);
	}
}
