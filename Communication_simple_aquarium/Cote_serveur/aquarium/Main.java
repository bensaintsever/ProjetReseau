package aquarium;

import java.util.ArrayList;
import DonneeClient.Client;
import ServeurTCP.ServeurTCP;
import aquarium.gui.AquariumWindow;
import aquarium.gui.Aquarium;
import aquarium.items.Fish;
import ServeurThread.*;
import aquarium.items.AquariumItem;
import aquarium.items.MobileItem;
import java.awt.Point;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Starting point of the Aquarium application
 */
public class Main{
	
	
	public static void main(String[] args) {
            
           
            
            
		Aquarium aquarium = new Aquarium();
		AquariumWindow animation = new AquariumWindow(aquarium);
		animation.displayOnscreen();
                

                            
                try{

                    //Lancement du Serveur
                ServeurTCP serveur = new ServeurTCP(7760);
                
                
                
                while(true){
                Socket client;
                    
                    //Accepte un client
                     serveur.accept();
                
                     //Tant que l'on recois
                   while(true){ 
                    String Rcpt = serveur.receive();
                    
                    int IdFish = 0; //Pas d'exploitation d'id pour l'instant
                    System.out.println(Rcpt); //Affichage des données recus
                    
                    if (Rcpt.equals("end")){
                        serveur.closeClient();
                        break;
                    }
                    else{
                        String[] decoupe = Rcpt.split("!");
                        
                        if (decoupe[1].equals("addFish")){
                            
                            
                            IdFish = Integer.parseInt(decoupe[2]);
                            
                            int width = Integer.parseInt(decoupe[3]);
                            
                            int x = Integer.parseInt(decoupe[4]);
                            
                            int y = Integer.parseInt(decoupe[5]);
                            
                            Point p = new Point(x,y);
                            Fish poisson = new Fish(width);
                            poisson.setPosition(p);
                            
                            aquarium.addItem(poisson); 
                        }
                        
                       /*Ne fonctionne pas ! Problème de type
                        if (decoupe[1].equals("moveFish")){
                            
                            IdFish = Integer.parseInt(decoupe[2]);
                        
                            int x = Integer.parseInt(decoupe[3]);
                            
                            int y = Integer.parseInt(decoupe[4]);
                            
                            //Deplacement du poisson
                           Fish a = (Fish)aquarium.getItem(IdFish);
                           a.move(x, y);
                          
                        
                        }*/
                        
                        
                        
                    }
                   
                  
                   }
                }
                   
                   
                
            }catch(Exception e){
                
                
                        System.out.println("Erreur serveur");
                    }
                
              
              
                
	/*
                ArrayList<Thread> t = new ArrayList<>();
                
                //Creer 10 Thread maximum, ils gerent par une file les differents threads 
                final ScheduledExecutorService t1 = Executors.newScheduledThreadPool(10);
                
                
		
                // Ajouter au client le parametre qui designe le nom d'un machine (realiser un getByname peut etre)
		
               	
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
                                    
                                    //a************** WIP ******************
                                    ServeurCommunication sCom = new ServeurCommunication(serveur,sockClient);
                                    sCom.start();
                                    //*************************************
                                    
                                    
                                    
                                    
                                    numClient++;
                            }
                            
                        }catch(RuntimeException e){
                            e.printStackTrace();}
                                
                    }
                        
                });
*/
}}
