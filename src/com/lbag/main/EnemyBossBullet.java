package com.lbag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBossBullet extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private BufferedImage fire_image;

	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

		fire_image = ss.grabImage(1,2,32,32);

	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new ImgTrail((int)x, (int)y, ID.Trail, 16, 16, 0.03f, handler, fire_image));

	}

	public void render(Graphics g) {		
		//g.setColor(Color.white);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(fire_image, (int)x,  (int)y, null);
	}
	
}
