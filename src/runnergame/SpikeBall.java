package runnergame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpikeBall extends BasicTrap{
	
	private Random random;
	private float vy;
	private int coin;

	public SpikeBall() throws SlickException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void getImage() throws SlickException {
		image = new Image("res/spikeball.png");
	}
	
	protected void setInit() {
		Random random = new Random();
		sizeX = 64;
		sizeY = 64;
		pos_x = 640;
		pos_y = 80 + random.nextInt(220);
		if( random.nextInt(2) == 1)
		{
			vy = 5;
		}
		else{
			vy = -5;
		}
		
	}
	
	protected void movement(float v) { 
		pos_x -= v;
		pos_y += vy;
		if(pos_y <= 80){
			vy = 5;
		}
		else if(pos_y >= 300){
			vy= -5;
		}
	}

}
