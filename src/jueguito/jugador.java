/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author miguel
 */
public class jugador extends JPanel {
    private int x,y;
  
    private panel_fondo panel1;

    //imagenes
    private ImageIcon zombie_der = new ImageIcon(getClass().getResource("/resources/zombie.png"));
    private ImageIcon zombie_izq = new ImageIcon(getClass().getResource("/resources/zombie_izq.png"));
    
    private boolean sentido_right;

    
    
    public jugador(int x, int y, panel_fondo panel1){
        super();
        this.x = x;
        this.y = y;
        this.panel1 = panel1;
       
          sentido_right = true;
      
          setBounds(x, y, 100,100);
          setOpaque(false);
          panel1.add(this);   
          //this.addKeyListener(new TAdapter());
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
  
    public void keyPressed(KeyEvent e)
 {
 int direccion = e.getKeyCode();

 if (direccion == KeyEvent.VK_RIGHT && x <= 1100){
 x += 15;
 sentido_right = true;
 System.out.println("tecla oprimida");
 }
 if (direccion == KeyEvent.VK_LEFT && x >= 2)
 {
 x -= 15;
 sentido_right = false;
 }
      
 }
    
//    private class TAdapter extends KeyAdapter{
//
// public void keyReleased(KeyEvent e){
// this.keyReleased(e);
// }
// public void keyPressed(KeyEvent e){
// int direccion = e.getKeyCode();
//
// if (direccion == KeyEvent.VK_RIGHT && x <= 1100){
// x += 15;
// sentido_right = true;
//     System.out.println("tecla oprimida");
// }
// if (direccion == KeyEvent.VK_LEFT && x >= 2)
// {
// x -= 15;
// sentido_right = true;
// }
// }
// }


 
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
    
}
