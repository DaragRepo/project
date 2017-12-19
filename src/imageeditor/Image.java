/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageeditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author moh
 */
public class Image {
    
public static int [][] loadRGB(String path) throws IOException{
    File file = new File(path);
    BufferedImage image =  ImageIO.read(file);
    int [][] pixels = new int [image.getWidth()][image.getHeight()];
    for (int i = 0 ; i  < pixels.length ; i ++){
        for (int j = 0 ; j < pixels[i].length ; j++){
            pixels [i][j] = image.getRGB(i, j);
        }
    }
    return pixels;
}
public static void writeRGB(String path , int[][] pixels) throws IOException{
    BufferedImage image = new BufferedImage (pixels.length, pixels[0].length , BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < image.getWidth(); i ++){
        for (int j = 0 ; j < image.getHeight() ; j++){
            image.setRGB(i, j, pixels[i][j]);
        }
    }
    File imageFile = new File(path);
    String format =  path.substring(path.lastIndexOf(".")+1);
    ImageIO.write(image, format, imageFile);
     
}

}
