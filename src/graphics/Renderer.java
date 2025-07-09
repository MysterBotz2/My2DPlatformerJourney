/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import javax.swing.JPanel;
import config.Constants;
import inputs.KeyInput;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import objects.RenderComponent;

/**
 *
 * @author MysterBotz
 */
public class Renderer extends JPanel{
    
    private int scale = 3;


    private List<RenderComponent> ren;
    
    public Renderer()
    {
        this.setPreferredSize(
                new Dimension(Constants.BASE_WIDTH * scale, Constants.BASE_HEIGTH * scale));
        this.setFocusable(true);
    }
    

    
    public void getRenderables(List<RenderComponent> ren)
    {
        this.ren = ren;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        for(RenderComponent rc : ren)
        {
            if(ren != null)
            {
                g2.drawRect((int)rc.posX, (int)rc.posY, (int)rc.width, (int)rc.heigth);
            }
        }
        
        
    }
    
    public void setScale(int scale)
    {
        this.scale = scale;
        this.setPreferredSize(
                new Dimension(Constants.BASE_WIDTH * scale, Constants.BASE_HEIGTH * scale));
        //repaint();
    }
    
}
