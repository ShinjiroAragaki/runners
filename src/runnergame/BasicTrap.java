package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicTrap {

	protected int sizeX;
	protected int sizeY;
	protected Image image;
	protected int pos_x;
	protected int pos_y;
	
	public BasicTrap() throws SlickException
	{
		setInit();
		getImage();
	}

	protected void setInit() {
		sizeX = 31;
		sizeY = 33;
		pos_x = 500;
		pos_y = 30;
	}

	protected void getImage() throws SlickException {
		image = new Image("res/spike.png");
	}
	
	public void render()
	{
		image.draw(pos_x,RunnerGame.GAME_HEIGHT - pos_y - sizeY);
	}
	
	public void update()
	{
		pos_x -= 5;
		if(pos_x < -200)
		{
			pos_x += RunnerGame.GAME_WIDTH+200;
		}
	}
	
	public int getX(){
		return pos_x;
	}
	
	public int getY(){
		return pos_y;
	}
	
	public int getSizeX(){
		return sizeX;
	}
	
	public int getSizeY(){
		return sizeY;
	}
}
