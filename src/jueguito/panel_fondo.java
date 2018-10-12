/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.*;

/**
 *
 * @author Estudiante
 */
public class panel_fondo extends JPanel implements Runnable {

    private ImageIcon fondo = new ImageIcon(getClass().getResource("/resources/calle.jpg"));

    private ExecutorService pool;
    private ExecutorService pool_2;
    
    private long time_sleep = 1000;
    jugador jugador1;
    private ArrayList<bala> vector;
    
  
    public panel_fondo(){
        super();
        vector = new ArrayList<>();
        jugador1 = new jugador(40, 400, this);
        this.addKeyListener(new oyente());
        setLayout(null);
        pool = Executors.newCachedThreadPool();
        pool_2 = Executors.newCachedThreadPool();
        pool_2.execute(this);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(),0,0,getWidth(),getHeight(),this);
    }
    
    
    @Override
    public void run() {
       
        while(true){
            int aleatorio = (int)Math.floor(Math.random()*900);
            try {
                bala bala1 = new bala(aleatorio, -50, panel_fondo.this);
                vector.add(bala1);
                panel_fondo.this.repaint();
                Thread.sleep(time_sleep);
                pool.execute(bala1);                 
            } catch (Exception e) {
                System.out.println("Error" +e);
            } 
        }
    }
    private class oyente implements KeyListener {

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println(ke.getKeyCode());  
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        @Override
        public void keyTyped(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
    
    
}
