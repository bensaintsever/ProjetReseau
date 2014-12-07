package aquarium.items;

import java.util.ArrayList;
import java.util.List;

import aquarium.util.RandomNumber;
import java.awt.Point;

public class Fish extends MobileItem {
	private static final int MIN_WIDTH = 30, MAX_WIDTH = 60;
	private static String[] img= {"image/fish.png", "image/fish2.png","image/dolphin.gif", "image/fish3.png"};

	public Fish() {
		super(MIN_WIDTH, MAX_WIDTH, img[RandomNumber.randomValue(0, img.length - 1)]);
	}
	public Fish(int width) {
		super(width, img[RandomNumber.randomValue(0, img.length - 1)]);
	}
        
	public AquariumItem target(List<AquariumItem> neighbours) {
		return neighbours.get(RandomNumber.randomValue(0, neighbours.size() - 1));
	}

	public int getMaximalWidth() {
		// TODO Auto-generated method stub
		return MAX_WIDTH;
	}
        
        public void move(int dx,int dy) {

		double v = getMaximalWidth()/getWidth();
		
		double direction = (float)Math.atan2(dy, dx);
		double speed = 5.0+v;
		int modx = (int) (speed * Math.cos(direction));
		int mody = (int) (speed * Math.sin(direction));
		Point p = getPosition();
		p.translate(modx, mody);
		setPosition(p);
	}
        
}
