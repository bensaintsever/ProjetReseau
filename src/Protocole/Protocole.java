/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Protocole;

/**
 *
 * @author benjamin
 */
public class Protocole {
    
    public Protocole(){
        
    }
    
    //addFish!numFish!width!x!y 
    
    public String addFish(int IdFish, int width, int x, int y){
        
        return "aquarium!addFish!"+Integer.toString(IdFish)+Integer.toString(width)+Integer.toString(x)+Integer.toString(y);
    }
    
    //removeFish!numFish
    public String removeFish(int IdFish){
        return "aquarium!removefish"+IdFish;
    }
    
    //moveFish!numFish!x!y 
    public String moveFish(int IdFish, int x, int y){
        
        return "aquarium!moveFish!"+Integer.toString(IdFish)+Integer.toString(x)+Integer.toString(y);
    }
     
    //setFishWidth!numFish!width
    public String setFishWidth(int IdFish, int width){
        return "aquarium!setFish!"+Integer.toString(IdFish)+Integer.toString(width);
    }
     
     //addStone!width!x!y 
    public String addStone(int width, int x, int y){
        return "aquarium!addStone!"+Integer.toString(width)+Integer.toString(x)+Integer.toString(y);
    }
     
    //addWeed!width!x!y 
    public String addWeed(int width, int x, int y){
        return "aquarium!addWeed!"+Integer.toString(width)+Integer.toString(x)+Integer.toString(y);
    }
    
    
    
    
}
/****************Protocole****************/
                        
                  
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