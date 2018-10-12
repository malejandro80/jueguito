/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author miguel
 */
public class bala extends JPanel implements Runnable{
    private int x,y;
    private panel_fondo panel1;
    private ImageIcon bala1 = new ImageIcon(getClass().getResource("/resources/bala1.png"));
  
      
    public bala(int x, int y, panel_fondo panel1){
        super();
        this.x = x;
        this.y = y;
        this.panel1 = panel1;
  
          setBounds(x, y, 50,50);
          setOpaque(false);
          panel1.add(this);
          
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bala1.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    private void mover(){
        y += 1;
    }

    @Override
    public void run() {
        
        while(true){
            
            try {
                this.repaint();
                    mover();
                Thread.sleep(5);
            } catch (Exception e) {
                System.out.println("Error" +e);
            }
        }
    }

}
         


