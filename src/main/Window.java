/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import config.Constants;
import javax.swing.JFrame;
import graphics.Renderer;
import java.awt.Dimension;

/**
 *
 * @author MysterBotz
 */
public class Window extends JFrame{
    
    private int scale = 2; //Default Scale
    private Renderer renderer;
    
    public Window(Renderer renderer){
        
        this.renderer = renderer;
        initComponents();
        
    }

    private void initComponents() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.renderer);
        this.pack();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    public void changeScale(int scale)
    {
        this.renderer.setScale(scale);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    public Renderer getRenderer()
    {
        return this.renderer;
    }

    
}
