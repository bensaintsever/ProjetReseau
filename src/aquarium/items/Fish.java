package aquarium.items;

import java.util.List;

public class Fish extends MobileItem {
	private static final int MIN_WIDTH = 30, MAX_WIDTH = 60;
	private static final String img = "image/seastone.png";

	public Fish() {
		super(MIN_WIDTH, MAX_WIDTH, img);
	}
	public Fish(int width) {
		super(width, img);
	}
	@Override
	public AquariumItem target(List<AquariumItem> neighbours) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getMaximalWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
