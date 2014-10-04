package runnergame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FireBall extends BasicTrap{

	public FireBall() throws SlickException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setInit() {
		sizeX = 80;
		sizeY = 80;
		pos_x = 640;
		pos_y = 300;
	}
	
	@Override
	protected void getImage() throws SlickException {
		image = new Image("res/neofire.png");
	}
}
