package runnergame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class RunnerGame extends BasicGame{
	
	public final static int GAME_WIDTH = 640;
	public final static int GAME_HEIGHT = 480;
	private Runner player;
	public final float v_obstacles = 1;
	private BasicTrap trap;
	private Wall[][] walls;
	private Input input;

	public RunnerGame(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			RunnerGame game = new RunnerGame("runner");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<4 ; y++)
			{
				walls[x][y].render();
			}
		}
		player.render();
		trap.render();
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		player = new Runner();
		trap = new BasicTrap();
		walls = new Wall[4][4];
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<4 ; y++)
			{
				walls[x][y] = new Wall(x*239 , y*168);
			}
		}
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
		trap.update();
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<4 ; y++)
			{
				walls[x][y].update();
			}
		}
		input = container.getInput();
		player.update();
		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			player.jump();
		}
		
	}

}
