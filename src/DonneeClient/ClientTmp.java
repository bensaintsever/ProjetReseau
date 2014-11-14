package DonneeClient;

import java.awt.Point;
import java.util.ArrayList;

import aquarium.items.AquariumItem;


public class ClientTmp {
	private int clientId;
	private ArrayList<AquariumItem> clientsFish;
	
	public ClientTmp(int clientId){
		this.clientId = clientId;
		clientsFish = new ArrayList<AquariumItem>();
	}
	
	public ClientTmp(int clientId, ArrayList<AquariumItem> items){
		this.clientId = clientId;
		clientsFish = new ArrayList<AquariumItem>();
		
		for (int i = 0; i < items.size(); i++)
			clientsFish.add(items.get(i)); //Fish should be cloned ideally
	}
	
	public void addFish(AquariumItem fish){
		clientsFish.add(fish);
		
	}
	public Point getImage(int index){
		return clientsFish.get(index).getPosition();
	}
	
}
