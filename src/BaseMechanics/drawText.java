package BaseMechanics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class drawText {
	public static void drawUnbounded(Graphics2D g, String s, int x, int y, font f) {
		int xpos = x;
		int ypos = y;
		char[] wnk = s.toCharArray();
		for(char w: wnk) {
			if(w == ' ') {
				xpos += f.yes[0].img.getWidth();
			}
			for(textChar c: f.yes) {
				if(c.associate==w) {
					g.drawImage(c.img, xpos, ypos, xpos+c.img.getWidth(), ypos+c.img.getHeight(), 0, 0, c.img.getWidth(), c.img.getHeight(), null);
					xpos+=c.img.getWidth();
				}
			}
		}
		
	}
	
	public static int drawInBoundedBox(Graphics2D g, String s, int x1, int y1, int x2, int y2, font f) {
		int xpos = x1;
		int ypos = y1;
		char[] wnk = s.toCharArray();
		for(char w: wnk) {
			if(w == ' ') {
				xpos += f.yes[0].img.getWidth();
			}
			for(textChar c: f.yes) {
				if(c.associate==w&&xpos <= x2-c.img.getWidth()&&ypos <= y2-c.img.getHeight()) {
					g.drawImage(c.img, xpos, ypos, xpos+c.img.getWidth(), ypos+c.img.getHeight(), 0, 0, c.img.getWidth(), c.img.getHeight(), null);
					xpos+=c.img.getWidth();
				}else if(c.associate==w&&ypos <= y2-c.img.getHeight()){
					xpos = x1;
					ypos += c.img.getHeight();
					g.drawImage(c.img, xpos, ypos, xpos+c.img.getWidth(), ypos+c.img.getHeight(), 0, 0, c.img.getWidth(), c.img.getHeight(), null);
					xpos+=c.img.getWidth();
				}
			}
		}
		return ypos + f.yes[0].img.getHeight();
	}
	
	public static class infiniteScroller{
		protected static class scrollerString{
			String string;
			font Font;
			scrollerString(String s, font f){
				string = s;
				Font = f;
			}
		}
		
		ArrayList<scrollerString> scrolls;
		int x1; int y1;
		int x2; int y2;
		int xpos;
		boolean bottomUp;
		int n;
		
		public infiniteScroller(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			scrolls = new ArrayList<scrollerString>(0);
		}
		
		public infiniteScroller(int x1, int y1, int x2, int y2, boolean b){
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.bottomUp = b;
			scrolls = new ArrayList<scrollerString>(0);
		}
		
		public void paint(Graphics2D g) {
				int ypos = y1;
			for(scrollerString s: scrolls) {
				n = drawInBoundedBox(g, s.string, x1, ypos, x2, y2, s.Font);
				ypos = n; 
			}
		}
		
		public void addItem(String s, font f) {
			if(!bottomUp) {
				scrolls.add(0, new scrollerString(s, f));
			}else {
				scrolls.add(new scrollerString(s, f));
			}
		}
	}
	public static abstract class font {
		public String name;
		public textChar[] yes;
	}
	public static class textChar {
		public textChar(BufferedImage i, char a){
			img = i;
			associate = a;
		}
		public BufferedImage img;
		public char associate;
	}
}
