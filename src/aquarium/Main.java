package aquarium;

import java.util.ArrayList;
import DonneeClient.Client;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.Fish;
import ServeurThread.*;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 
 * Starting point of the Aquarium application
 */
public class Main{
	
	
	public static void main(String[] args) {
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
	
                ArrayList<Thread> t = new ArrayList<>();
                
                //Creer 10 Thread maximum, ils gerent par une file les differents threads 
                final ScheduledExecutorService t1 = Executors.newScheduledThreadPool(10);
                
                
		
                /* Ajouter au client le parametre qui designe le nom d'un machine (realiser un getByname peut etre)*/
		
               	
		ServeurTCP serveur = new ServeurTCP(7763);

                //Thread General Serveur
                t1.execute(new Runnable() {

                    
                    public void run() {
                        
			
			try{	
				
                            //Preparation des données clients
                            Client c = new Client();  
                            int numClient = 0;
                            
                            while(true){
                                    //Ecoute du serveur
                                    serveur.accept();
                                    
                                    c.addClient(numClient);
                                    Socket sockClient = c.getSocketClient();
                                    
                                    //Modifier surement l'ajout de poisson (voir modifier l'utilisation protocole)
                                    //Premier contact avec le(s) client(s) (possible ajout de poisson)
                                    ServeurInit sInit = new ServeurInit(serveur,aquarium, sockClient);
                                    sInit.start();
                                    
                                    /************** WIP ******************/
                                    ServeurCommunication sCom = new ServeurCommunication(serveur,sockClient);
                                    sCom.start();
                                    /*************************************/
                                    
                                    
                                    
                                    
                                    numClient++;
                            }
                            
                        }catch(RuntimeException e){
                            e.printStackTrace();}
                                
                    }
                        
                });

}}
