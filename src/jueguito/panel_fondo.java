/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.*;

/**
 *
 * @author Miguel
 */
public class panel_fondo extends JPanel implements KeyListener,Runnable {
    
    private int puntuacion;
    private long time_sleep = 500;
    private ImageIcon fondo = new ImageIcon(getClass().getResource("/resources/calle.jpg"));
    private ExecutorService pool;
    private ExecutorService pool_2;
    private boolean condicion_de_juego;
    jugador jugador1;
    private JLabel contador_lbl;
    ArrayList<bala> vector = new ArrayList();
  
    public panel_fondo(){
        super();
        puntuacion = 0;
        jugador1 = new jugador(40,400, this);
        contador_lbl = new JLabel();
        this.add(contador_lbl, BorderLayout.NORTH);
        addKeyListener((KeyListener) this);
        this.setFocusable(true);
        condicion_de_juego = true;
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
        
        
       
        while(condicion_de_juego){
            int aleatorio = (int)Math.floor(Math.random()*900);
            
            try {
                bala bala1 = new bala(aleatorio, -50, panel_fondo.this);
                vector.add(bala1);                            
                panel_fondo.this.repaint();
                Thread.sleep(time_sleep);
                pool.execute(bala1); 
           
                for (int i = 0; i < vector.size(); i++) {
                   
                    if(vector.get(i).getY() >= 450){
                        vector.remove(i);
                        vector.get(i).setCond_pintado(false);
                        this.repaint();
                        puntuacion += 1;
                        contador_lbl.setText(Integer.toString(puntuacion));
                        System.out.println(puntuacion);
                    }
                    if( vector.get(i).getY()+50>= jugador1.getY()
                         && vector.get(i).getX()+25>=jugador1.getX() 
                        && vector.get(i).getX()+25<=jugador1.getX()+100) {
                        //se acaba el juego si una bala le da al zombie
                        condicion_de_juego = false;
                        contador_lbl.setText("fin del juego, su puntuacion fue: "+ Integer.toString(puntuacion));
                        System.out.println("fin del juego, su puntuacion fue: "+ Integer.toString(puntuacion));
                        System.out.println("NOTA: por alguna razon no esta funcionando el contador_lbl :(");
                        this.removeKeyListener(this);
                        for (int j = 0; j < vector.size(); j++) {
                            vector.get(j).setCond_pintado(false);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error" +e);
                
            } 
        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        int direccion = ke.getKeyCode();
        
        if (direccion == KeyEvent.VK_RIGHT && jugador1.getX() <= 1100){
            jugador1.setX(jugador1.getX() +10);
            jugador1.setSentido_right(true);
            this.repaint();
        }
        if (direccion == KeyEvent.VK_LEFT && jugador1.getX() >= 2){
            jugador1.setX(jugador1.getX()-10);
            jugador1.setSentido_right(false);
            this.repaint();
        }

    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
     }
        
    
}
