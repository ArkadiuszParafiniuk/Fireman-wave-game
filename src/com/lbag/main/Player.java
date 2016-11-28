package com.lbag.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	private BufferedImage player_image;	
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1,1,32,32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new ImgTrail((int)x, (int)y, ID.Trail, 32, 32, 0.15f, handler, player_image));

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.EnemyBoss) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					if(HUD.getScore() >= 100) {
						HUD.HEALTH -= 2;
					}
				}
			}
			
			if (tempObject.getId() == ID.Potion) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					if(HUD.HEALTH <= 70){
						HUD.HEALTH += 30;
					} else {
						float p = 100 - HUD.HEALTH;
						HUD.HEALTH += p;
					}
					handler.removeObject(tempObject);
				}
			}

		}
	}

	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect((int)x, (int)y, 32, 32);
		g.drawImage(player_image, (int)x,  (int)y, null);
		
	}

}
