package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Runner {
	private int HP;
	private int PW;
	private Image image;
	private static final int HEIGHT = 100;
	private static final int WIDTH = 50;
	private int INIT_VY = 20;
	private int vy;
	private int y;

	
	public Runner() throws SlickException{
		this(3,3);
	}
	
	public Runner(int hp , int pw ) throws SlickException
	{
		this.HP = hp;
		this.PW = pw;
		image = new Image("res/run.png");
		this.y = 0;
	}

	public void render() {
		image.draw(50, RunnerGame.GAME_HEIGHT - this.HEIGHT - 30 +y);
	}

	public void update(){
		if(y >= 0)
		{
			y = 0;
			vy = 0;
		}
		else
		{
			vy -= 1;
		}
		y -= vy;
	}
	
	public void jump(){
		y-=2;
		vy = INIT_VY;
	}
}
