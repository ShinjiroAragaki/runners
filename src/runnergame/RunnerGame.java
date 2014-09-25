package runnergame;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
	private float invul_frame;
	private Random random;
	private float v;
	private Image SplashGameOver;

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
		if(player.GameOver){
			SplashGameOver.draw(140,140);
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		player = new Runner();
		randomTrap();
		walls = new Wall[4][4];
		for(int x = 0 ; x<4 ; x++)
		{
			for(int y = 0; y<4 ; y++)
			{
				walls[x][y] = new Wall(x*239 , y*168);
			}
		}
		invul_frame = 0;
		v = 8;
		SplashGameOver = new Image("res/gameover.png");
	}

	protected void randomTrap() throws SlickException {
		Random random = new Random();
		int x = random.nextInt(3);
		if( x==1 )
		{
			trap = new FireBall();
		}
		else if( x == 2){
			trap = new BasicTrap();
		}
		else{
			trap = new SpikeBall();
		}
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
		if(!player.GameOver)
		{
			invul_frame -=1;
			trap.update(v);
			for(int x = 0 ; x<4 ; x++)
			{
				for(int y = 0; y<3 ; y++)
				{
					walls[x][y].update(v);
				}
			}
			input = container.getInput();
			player.update();
			if(input.isKeyPressed(Input.KEY_SPACE))
			{
				player.jump();
			}
			if( isCollide(player,trap, invul_frame) ){
				player.HIT();;
				invul_frame = 30;
			}
			if(trap.getX() <= -100)
			{
				randomTrap();
			}
		}

	} 
	
	public boolean isCollide(Runner player ,BasicTrap trap, float invul) throws SlickException {

			float deltaX = (player.getSizeX() + trap.getSizeX())/2;
			float deltaY = (player.getSizeY() + trap.getSizeY())/2;
			if(Math.abs(player.getX() - trap.getX())<=deltaX && Math.abs(player.getY()-trap.getY())<=deltaY && invul <= 0){
				return true;
			}
		return false;
	}

}
