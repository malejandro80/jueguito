/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author miguel
 */
public class jugador extends JPanel {
    
    private int x,y;
    private int dx;
    //imagenes
    private ImageIcon zombie_der = new ImageIcon(getClass().getResource("/resources/zombie.png"));
    private ImageIcon zombie_izq = new ImageIcon(getClass().getResource("/resources/zombie_izq.png"));
    panel_fondo panel1;
    private boolean sentido_right;
    
    
    
    public jugador(int x,int y, panel_fondo panel1){
        super();
        this.x = x;
        this.y = y;
        this.panel1 = panel1;
        
        panel1.add(this);
          sentido_right = true;
      
          setBounds(x, y, 100,100);
          setOpaque(false);  
    }   

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon dir_zombie = zombie_der;
        if(!sentido_right){
            dir_zombie = zombie_izq;
            this.repaint();
        }
        g.drawImage(dir_zombie.getImage(), 0, 0, getWidth(), getHeight(), this);
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
       public boolean isSentido_right() {
        return sentido_right;
    }

    public void setSentido_right(boolean sentido_right) {
        this.sentido_right = sentido_right;
    }
}

