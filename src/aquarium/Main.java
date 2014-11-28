package aquarium;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import DonneeClient.Client;
import clientTCP.ClientTCP;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.Fish;

/**
 * Starting point of the Aquarium application
 */
public class Main {
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
                ArrayList<Thread> t = new ArrayList<>();
                Thread t1;
                
               
		
		
		/*Autoriser le client a avoir son poisson
		si on recois une demande de move alors on move le poisson vers un target correspondant*/
		
                /* Ajouter au client le parametre qui designe le nom d'un machien (realiser un getByname peut etre)*/
		
		
                 //Preparation des données clients
                Client c = new Client();
                 /****************Protocole****************/
                        
                    String AddFish = "aquarium!addfish!";
                    String DeleteFish = "aquarium!deletefish";
                    //String SendData = c.getCoordonnees()+ "!"+c.getTaille()+"!"+c.getImagesBuffer();
                    //String Image = c.getImage()
                        
                    /* LIRE IMAGE
                    File file = (File)obj;
                    FileInputStream fis = new FileInputStream(file);
                    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fis);
                    BufferedImage image = decoder.decodeAsBufferedImage();
                    fis.close();
                    
                    */
                    
                    
                 /******************************************/
                
                
               	
		ServeurTCP serveur = new ServeurTCP(7763);
		
               
				
		
                
                //AJOUTER THREAD ! + SYNCHRO !
                /**************** WIP *****************/
                
                //Quand on ajout une information
                //serveur.send(SendData);
                
                
                
                
                /**************************************/
                
                t1 = new Thread(new Runnable()
			{
				public void run(){
					
					
				
			
                
                
                    int i = 0;
                    while(true){
                            //Ecoute du serveur
                            serveur.accept();

                            //Ajout d'un poisson client
                            c.addClient();

                            //Reception d'un commande provenant du client
                            String commande1 = serveur.receive();



                            //Interprétation commandes
                            if (commande1.equals("Add me")){
                                aquarium.addFish();//Ajout d'un poisson dans l'aquarium
                                c.addClient(); //Ajout reference d'un nouveau client

                                Fish poisson = aquarium.getFish(c.getIndice());//On recupere l'objet Fish que l'on souhaite créer


                                //On envoi aux clients la nouvelle position du poisson
                                serveur.send(AddFish+poisson.getPosition());

                            }
                 
                    }
                    }
                }
		).start();
		
		
		
	}
}
/*new Thread(new Runnable()
			{
				public void run(){
					
					
				}
			}
		).start();*/