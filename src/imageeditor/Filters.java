/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageeditor;

import static imageeditor.Image.loadRGB;
import static imageeditor.Image.writeRGB;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author moh
 */
public class Filters {

    public static void addRed (int arr1 [][],JLabel label) throws IOException{
           
         try {
                    for (int i = 0 ; i < arr1.length ; i++){
                        for (int j = 0 ; j < arr1[i].length ; j++){
                            arr1[i][j] &=0xff00ff ;
                        }
                    }
                  
                    String new_path = "C:\\Users\\moh\\Desktop\\pic\\AfterEffect.jpg";
                     writeRGB(new_path, arr1);
                    File my =new File(new_path);
                    BufferedImage new_bi = ImageIO.read(my); 
                  label.setIcon(new ImageIcon(new_bi));
                 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
                }
         
    }
    public static void addNoise (int arr2[][],JLabel label){
          try {
                  Random r =new Random();
                    for (int i = 0 ; i < arr2.length ; i++){
                        for (int j = 0 ; j < arr2[i].length ; j++){
                            if (r.nextBoolean())
                            arr2[i][j] = r.nextInt(0xffffff) ;
                        }
                    }
                     

                    String new_path = "C:\\Users\\moh\\Desktop\\pic\\AfterEffect.jpg";
                     writeRGB(new_path, arr2);
                    File my =new File(new_path);
                    BufferedImage new_bi = ImageIO.read(my); 
                  label.setIcon(new ImageIcon(new_bi));
                   
                    
                } catch (IOException ex) {
                    Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
}
