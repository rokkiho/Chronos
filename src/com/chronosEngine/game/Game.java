package com.chronosEngine.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.chronosEngine.resource.ImageResource;
import com.chronosEngine.resource.ResourceLoader;
import com.chronosEngine.sprite.SpriteFont;
import com.chronosEngine.state.StateManager;
import com.chronosEngine.state.states.GamePlay;
import com.chronosEngine.state.states.MainMenu;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static String name = "Chronos";
	public static final int width = 800;
	public static final int height = 600;
	public static final int SCALE = 1;
	public volatile boolean running = false;
	
	public BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Screen screen;
	public Camera camera;
	public InputManager inputManager;
	public StateManager stateManager;
	
	public MainMenu mainMenu;
	public GamePlay gamePlay;
	
	public void init(){
		screen = new Screen(width, height);
		camera = new Camera(0, 0, screen);
		
		stateManager = new StateManager();
		
		inputManager = new InputManager(this);
		
		mainMenu = new MainMenu(this);
		gamePlay = new GamePlay(this);
		
		stateManager.addState(mainMenu);
		stateManager.addState(gamePlay);
		
		stateManager.setCurrentState(mainMenu);
		
		SpriteFont.loadFont((ImageResource)ResourceLoader.getResource("font"));
	}
	
	public void loadContent(){
		ResourceLoader.loadImage("/title.png", "logo");
		ResourceLoader.loadImage("/font.png", "font");
		ResourceLoader.loadImage("/arrow.png", "arrow");
		ResourceLoader.loadImage("/tile_sheet.png", "tileSheet");
	}
	
	synchronized public void start(){
		running = true;
		new Thread(this).start();
	}
	
	synchronized public void stop(){
		running = false;
	}
	
	public void run(){
		double prevTime = System.nanoTime();
		double currTime;
		double delta = 0D;
		double nsPerTick = 1000000000/60D;
		int ticks = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		loadContent();
		init();
		
		while(running){
			currTime = System.nanoTime();
			delta += (currTime - prevTime) / nsPerTick;
			prevTime = currTime;
			
			while(delta > 1){
				Update();
				delta--;
				ticks++;
			}
			
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			Draw();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				System.out.println("Ticks: " + ticks + " Frames: " + frames);
				ticks = 0;
				frames = 0;
				timer += 1000;
			}
		}
		
		cleanUp();
	}
	
	public void Update(){
		stateManager.Update();
	}
	
	public void Draw(){
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		screen.flush();
		
		stateManager.Draw();
		
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				pixels[x + (y * width)] = screen.pixels[x + (y * screen.width)];
			}
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, width * SCALE, height * SCALE, null);
		g.dispose();
		bs.show();
	}
	
	public void cleanUp(){
		System.exit(0);
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame(name);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(width * SCALE, height * SCALE));
		game.setMinimumSize(new Dimension(width * SCALE, height * SCALE));
		game.setMaximumSize(new Dimension(width * SCALE, height * SCALE));
		
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		game.start();
	}
}
