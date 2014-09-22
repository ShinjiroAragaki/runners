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
	private float invul;

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
		trap = new FireBall();
		walls = new Wall[4][4];
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<4 ; y++)
			{
				walls[x][y] = new Wall(x*239 , y*168);
			}
		}
		invul = 0;
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
		invul -=1;
		trap.update();
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<3 ; y++)
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
		if( isCollide(player.getX(),player.getY(),player.getSizeX(),player.getSizeY(),trap.getX(),trap.getY(),trap.getSizeX(), trap.getSizeY() , invul) ){
			System.out.print("HIT");
			invul = 30;
		}
	} 
	
	public boolean isCollide(int x1, int y1 ,int sizex1 , int sizey1 ,int x2, int y2 ,int sizex2  , int sizey2 , float invul) throws SlickException {

			float deltaX = (sizex1 + sizex2)/2;
			float deltaY = (sizey1 + sizey2)/2;
			if(Math.abs(x1-x2)<=deltaX && Math.abs(y1-y2)<=deltaY && invul <= 0){
				return true;
			}
		return false;
	}

}
