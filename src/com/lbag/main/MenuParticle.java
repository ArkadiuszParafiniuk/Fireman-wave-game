package com.lbag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MenuParticle extends GameObject{
	
	private Handler handler;
	
	private BufferedImage fire_image;
	
	Random r = new Random();
	
	private Color col;
	
	int dir = 0;
	
	public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		

			velX = (r.nextFloat()*4 -4);
			velY = (r.nextFloat()*4 -4);
		
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
		//g.setColor(col);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(fire_image, (int)x,  (int)y, null);
	}
	
}

