package aquarium;

import Protocole.Protocole;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.AquariumItem;
import aquarium.items.Fish;
import aquarium.items.MobileItem;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Starting point of the Aquarium application
 */
public class Main {
	
	/*public static void handleInstruction(String inst, Aquarium aq){
		//split instruction
		instructions = inst.split("!");
		
		//evaluate
		if(instructions.get(0).equals("addFish")){
			aquarium.addItem(new Fish(instructions.get(2))); //width?
			aquarium.getItem().get(aquarium.getItem().size()).setPosition(new Point(instructions.get(4), instructions.get(5)));
		}
	}*/
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
                for (int i = 0; i < 9; i++) {
                   
			MobileItem ai = new Fish();
                        
                        aquarium.addItem(ai);
                        
                    
                        
		}
		
                
                Protocole p =new Protocole();
                
                
                //ArrayList<AquariumItem> mine;
                ClientTCP client;
		client = new ClientTCP("127.0.0.1",7760);
                
                int posItem = 0; //Position dans la liste des item de l'aquarium
                int maxitem = aquarium.getNumberofItem();
                for (int i = 0; i < maxitem; i++) {
                    AquariumItem item = aquarium.getItem(i);
                    posItem++;
                    if (item instanceof MobileItem){
                        try {
                            //Position Poisson
                            Point pos = item.getPosition();
                            
                            //Destination
                            //AquariumItem NouvelleDst = ((MobileItem)item).getCurrentDestination();
                            //Point DstPos = NouvelleDst.getPosition();
                            
                            //Envoi Position du poisson
                            client.send(p.addFish(posItem,item.getWidth() , pos.x, pos.y));
                            
                            
                            //Envoi Destination du poisson
                            //client.send(p.moveFish(posItem,DstPos.x , DstPos.y));
                            //System.out.println("Numero item"+posItem);
                            
                            //On Envoi un poisson toutes les secondes afin que le serveur recoive bien l'information
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
		}
                
                client.send("end");
                client.close();
		 
		
                
                
		
		
		/*Autoriser le client a avoir son poisson
		si on recois une demande de move alors on move le poisson vers un target correspondant*/
		
		
		
		//ClientTCP client;
		//int numClient;
		
		/*new Thread(new Runnable()
			{
				public void run(){
					
					
				}
			}
		).start();*/
		
		/*
		ArrayList<AquariumItem> mine = aquarium.getItems();

		client = new ClientTCP("10.0.206.6",7760);
		client.send("Add me"); //or whatever to get permission
		
		// receive authorisation
		numClient = client.receive();
		
		for(int i = 0; i < items.size(); i++){
			client.send("addFish!"+ i +"!" + items.get(i).getWidth() +"!"+ items.get(i).getPosition().getX() + "!" + items.get(i).getPosition().getY())
		}
		
		int i = 0;
		
		Timer time = new Timer();
		while(true){
			time.scheduleAtFixedRate(new TimerTask() {
				  public void run() {
				    handleInstruction(client.receive(), aquarium);
				  }
				}, 1, SECONDS);
		}	
		
		client.close();
                        
                        */
        }
}
