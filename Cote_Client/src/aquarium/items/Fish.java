package aquarium.items;

import java.util.ArrayList;
import java.util.List;

import aquarium.util.RandomNumber;

public class Fish extends MobileItem {
	private static final int MIN_WIDTH = 30, MAX_WIDTH = 60;
	private static ArrayList<String> img= new ArrayList<String>("image/fish.png", "image/fish2.png","image/dolphin.gif", "image/fish3.png");

	public Fish() {
		super(MIN_WIDTH, MAX_WIDTH, img.get(RandomNumber.randomValue(0, img.length - 1)));
	}
	public Fish(int width) {
		super(width, img.get(RandomNumber.randomValue(0, img.length - 1)));
	}

	public Fish(int width, String image){
		img.add(image);
		super(width, image);
	}
	
	public AquariumItem target(List<AquariumItem> neighbours) {
		return neighbours.get(RandomNumber.randomValue(0, neighbours.size() - 1));
	}

	public int getMaximalWidth() {
		// TODO Auto-generated method stub
		return MAX_WIDTH;
	}
}
