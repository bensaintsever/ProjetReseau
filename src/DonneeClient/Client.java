/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DonneeClient;
import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public class Client {
    
    private ArrayList IdClient;
    private int indice;
    
    public Client(){
        IdClient = new ArrayList();
    }
    
    public void addClient(){
        IdClient.add(indice);
        indice++;
        
    }
    
    public void deleteClient(){
        try{
             if (indice > 0)
                indice--;
        }catch(Exception e){System.err.println("Impossible de supprimer un client");}
       
    }
    
    public int getIndice(){
        return indice--;
    }
    
    
}
