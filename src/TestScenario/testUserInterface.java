package TestScenario;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import BaseMechanics.AllTogether;
import BaseMechanics.Tile;
import BaseMechanics.UserInterface;

public class testUserInterface extends UserInterface {
	public testUserInterface(){
		super();
		elements.add(new testButton());
	}
	
	public static class testButton extends UserInterface.Element{
		boolean rightDepressed;
		boolean leftDepressed;

		@Override
		public void paint(Graphics2D g, AllTogether a) {
			if(rightDepressed){
				g.setColor(Color.RED);
			}else{
				g.setColor(Color.BLUE);
			}
				g.fillRect(69, 69, 69, 69);
				
			if(leftDepressed){
				g.setColor(Color.RED);
			}else{
				g.setColor(Color.BLUE);
			}
				g.fillRect(69*2, 69, 69, 69);
		}

		@Override
		public void update(AllTogether a) {
			if(a.input.current.contains(KeyEvent.VK_RIGHT)){
				rightDepressed = true;
			}else{
				rightDepressed = false;
			}
			
			if(a.input.current.contains(KeyEvent.VK_LEFT)){
				leftDepressed = true;
			}else{
				leftDepressed = false;
			}
		}

		@Override
		public void toIterateOnEachTile(AllTogether a, Tile tile, int x, int y) {
			// TODO Auto-generated method stub
			
		}
	}
}
