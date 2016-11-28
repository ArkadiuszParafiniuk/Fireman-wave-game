package com.lbag.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Potion extends GameObject{
	
	private Handler handler;
	
	private Random r = new Random();
	
	private BufferedImage potion_image;

	public Potion(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

		potion_image = ss.grabImage(1,3,32,32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {;
		
		
	}

	public void render(Graphics g) {		

		g.drawImage(potion_image, (int)x,  (int)y, null);
	}
	
}
