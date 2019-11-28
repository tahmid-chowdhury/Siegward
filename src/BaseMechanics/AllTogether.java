package BaseMechanics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class AllTogether extends JPanel {
	
	public AllTogether(Map m, UserInterface ui,	InputMethod input, GameLogic gl) {
		this.map = m;
		this.viewport = new Viewport(m);
		this.ui = ui;
		this.input = input;
		this.gl = gl;
	}
	
	public Viewport viewport;
	public Map map;
	UserInterface ui;
	public InputMethod input;
	public GameLogic gl;
	
	public void paint(Graphics g){
		Graphics2D wnk = (Graphics2D) g;
		viewport.paint(wnk);
		ui.paint(wnk);
		}
	
	public void update() {
		viewport.move(input.returnInputs());
		ui.update(this);
		gl.update(this);
	}
}
