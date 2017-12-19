/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageeditor;

import static imageeditor.Image.loadRGB;
import static imageeditor.Filters.addRed;
import static imageeditor.Filters.addNoise;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author moh
 */
public class Gui extends Component  {
    
    public Gui () throws IOException{
        uploadImageActionPerformed(null);
    }
   private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                            
     JFileChooser filechooser= new JFileChooser();
    JLabel jLabel1 = new JLabel ();
    filechooser.setDialogTitle("Choose Your File");
    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    //below codes for select  the file 
    int returnval=filechooser.showOpenDialog(this);
    if(returnval==JFileChooser.APPROVE_OPTION)
    {
        File file = filechooser.getSelectedFile();
        BufferedImage bi;
     
        
       JFrame frame = new JFrame ("mine");
       JPanel panel = new JPanel();
       frame.add(panel);
       
       
       JLabel label = new JLabel ();
       JButton btn  =new JButton ("Red");
       JButton btn2 = new JButton ("Noise");
       JButton original = new JButton ("original");

       btn.setPreferredSize(new Dimension(60,30));
       btn2.setPreferredSize(new Dimension(80,30));
        btn2.setPreferredSize(new Dimension(110,30));
        bi=ImageIO.read(file);
        frame.setSize(500,500);
            label.setIcon(new ImageIcon(bi));
            panel.add(btn);
            panel.add(btn2);
            panel.add(original);
            panel.add(label);
           
            String path = file.getAbsolutePath();
            
 final int [][] arr1 = loadRGB(path);

   int [][] arr2 = loadRGB(path);
btn.addActionListener(new ActionListener() {

  
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {  
                 addRed(arr1,label);
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
        });
btn2.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
               
                addNoise(arr2, label);
            }
    
    
});
original.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                 label.setIcon(new ImageIcon(bi));
            }
    
});
   panel.setVisible(true);
            frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }}  
}


