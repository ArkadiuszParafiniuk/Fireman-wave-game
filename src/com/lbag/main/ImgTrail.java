package com.lbag.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ImgTrail extends GameObject{
	
	private BufferedImage image;
	
	private float alpha = 1;
	private float life;
	
	private Handler handler;

	
	private int width, height;
	
	//life = 0.001 - 0.1

	public ImgTrail(int x, int y, ID id, int width, int height, float life, Handler handler, BufferedImage image) {
		super(x, y, id);
		this.handler = handler;
		this.image = image;
		this.width = width;
		this.height = height;
		this.life = life;
	}


	public void tick() {
		if(alpha > life){
			alpha -= (life - 0.0001f);
		} else handler.removeObject(this);
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		//g.setColor(color);
		//g.fillRect((int)x, (int)y, width, height);
		g.drawImage(image, (int)x,  (int)y, null);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}


	public Rectangle getBounds() {	
		return null;
	}

}
