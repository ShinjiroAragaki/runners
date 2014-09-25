package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Runner {
	private int HP;
	private int PW;
	private Image image;
	private final int HEIGHT = 64;
	private final int WIDTH = 64;
	private int INIT_VY = 18;
	private int vy;
	private int y;
	private int jumps;
	private int defaultX = 50;
	private Image floor;
	private Image HealthPoint;
	private Image PowerUp;
	public boolean GameOver;

	
	public Runner() throws SlickException{
		this(3,3);
	}
	
	public Runner(int hp , int pw ) throws SlickException
	{
		this.HP = hp;
		this.PW = pw;
		image = new Image("res/run.png");
		this.y = 0;
		this.jumps = 0;
		floor = new Image("res/floor.png");
		HealthPoint = new Image("res/HP.png");
		}

	public void render() {
		image.draw( defaultX , RunnerGame.GAME_HEIGHT - HEIGHT - 30 +y);
		floor.draw(0,RunnerGame.GAME_HEIGHT -30);
		for(int i = 1; i <= HP ; i++)
		{
		HealthPoint.draw(30+ i*50 ,50);
		}
	}  

	public void update() throws SlickException{
		if(y >= 0)
		{
			y = 0;
			vy = 0;
			jumps = 0;
		}
		else
		{
			vy -= 1;
		}
		y -= vy;
		if(HP < 1){
			GameOver = true;
			image = new Image("res/ded.png");
		}
	}
	
	public void jump(){
		if(jumps < 2)
		{
		y-=2;
		vy = INIT_VY;
		jumps += 1;
		}
	}
	
	public void HIT(){
		HP -= 1;
	}
	
	public int getX(){
		return defaultX+(WIDTH/2);
	}
	
	public int getY(){
		return HEIGHT/2 + 30 -y;
	}
	
	public int getSizeX(){
		return WIDTH;
	}
	
	public int getSizeY(){
		return HEIGHT;
	}
} 
