package com.lbag.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	
	private Random r = new Random();
	
	private BufferedImage fire_image;

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (float) ((r.nextFloat()-0.5)*10);
		velY = (float) ((r.nextFloat()-0.5)*10);
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

		fire_image = ss.grabImage(1,2,32,32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= -100 || y >= Game.HEIGHT + 100) velY *= -1;
		if(x <= -100 || x >= Game.WIDTH + 100) velX *= -1;
		
		handler.addObject(new ImgTrail((int)x, (int)y, ID.Trail, 16, 16, 0.03f, handler, fire_image));

	}

	public void render(Graphics g) {		
		//g.setColor(Color.red);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(fire_image, (int)x,  (int)y, null);
	}
	
}
