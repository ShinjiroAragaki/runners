package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicTrap {

	protected float sizeX;
	protected float sizeY;
	protected Image image;
	protected float pos_x = 500;
	protected float pos_y = RunnerGame.GAME_HEIGHT - 30;
	
	public BasicTrap() throws SlickException
	{
		this.sizeX = 31;
		this.sizeY = 33;
		image = new Image("res/spike.png");
	}
	public void render()
	{
		image.draw(pos_x,pos_y-sizeY);
	}
	public void update()
	{
		pos_x -= 5;
		if(pos_x < -31)
		{
			pos_x += RunnerGame.GAME_WIDTH+31;
		}
	}
}
