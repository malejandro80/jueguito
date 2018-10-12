/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguito;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Estudiante
 */
public class ventana_principal extends JFrame {
    private panel_fondo panel1;
    public ventana_principal(){
        super("Balas");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenedor =getContentPane();
        contenedor.setLayout(new BorderLayout());
        panel1 = new panel_fondo();
        contenedor.add(panel1, BorderLayout.CENTER);  
    }
}
