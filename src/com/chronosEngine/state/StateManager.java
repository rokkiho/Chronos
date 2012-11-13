package com.chronosEngine.state;

import java.util.ArrayList;

public class StateManager {
	public ArrayList<State> states = new ArrayList<State>();
	public int currState = -1;
	
	public void addState(State s){
		for(State st : states){
			if(st.equals(s)){
				return;
			}
		}
		
		states.add(s);
	}
	
	public void removeState(State s){
		for(State st : states){
			if(st.equals(s)){
				states.remove(s);
				return;
			}
		}
	}
	
	public void setCurrentState(State s){
		for(State st : states){
			if(st.equals(s)){
				currState = states.indexOf(st);
				return;
			}
		}
		
		System.out.println("Error: Cannot find the state");
	}
	
	public void Update(){
		if(currState == -1){
			return;
		}
		
		states.get(currState).Update();
	}
	
	public void Draw(){
		if(currState == -1){
			return;
		}
		
		states.get(currState).Draw();
	}
}
