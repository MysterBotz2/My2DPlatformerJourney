/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javax.swing.JPanel;
import config.Constants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author MysterBotz
 */
public class Renderer extends JPanel{
    
    private int scale = 3;
    private int x = 120;
    
    public Renderer()
    {
        this.setPreferredSize(
                new Dimension(Constants.BASE_WIDTH * scale, Constants.BASE_HEIGTH * scale));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.drawRect(x*scale, 88*scale, Constants.TILE_SIZE * scale, Constants.TILE_SIZE * scale);
    }
    
    public void setScale(int scale)
    {
        this.scale = scale;
        this.setPreferredSize(
                new Dimension(Constants.BASE_WIDTH * scale, Constants.BASE_HEIGTH * scale));
        repaint();
    }
    
    public void changeX(int x)
    {
        this.x += x;
    }
    
}
