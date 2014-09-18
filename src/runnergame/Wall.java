package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Wall {
	private Image image;
	private float x;
	private float y;
	
	public Wall(float x,float y) throws SlickException
	{
	this.x = x;
	this.y = y;
	image = new Image("res/wall.png");
	}
	public void render()
	{
		image.draw(x,y);
	}
	public void update()
	{
		x -= 5;
		if(x<-239)
		{
			x+=956;
		}
	}

}
