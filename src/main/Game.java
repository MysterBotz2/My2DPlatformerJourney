/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import graphics.Renderer;
import inputs.KeyInput;
import java.util.ArrayList;
import java.util.List;
import objects.Player;
import objects.RenderComponent;

/**
 *
 * @author MysterBotz
 */
public class Game implements Runnable{
    
     Window win;
     Renderer ren;

     
     Player player;
     KeyInput key;
    
    public Game(Window win)
    {
        this.player = new Player(100,100,100,100);
        this.key = new KeyInput(this.player);

        
        this.win = win;
        this.ren = win.getRenderer();
        
        this.win.addKeyListener(key);
        this.win.setFocusable(true);
        this.win.requestFocusInWindow();

        
    }

    @Override
    public void run() {
        
        int fpsRate = 60;
        int upsRate = 60;
        int fpsCount = 0;
        int upsCount = 0;

        double nsPerFrame = 1000000000/fpsRate;
        double nsPerUpdate = 1000000000/upsRate;

        long prevTime = System.nanoTime();

        double deltaU = 0;
        double deltaF = 0;

        long lastCheck = System.currentTimeMillis();
        
        while(true)
        {
            long currTime = System.nanoTime();
            
            deltaF += (currTime - prevTime) / nsPerFrame;
            deltaU += (currTime - prevTime) / nsPerUpdate;
            prevTime = currTime;
            
            if(deltaF >= 1)
            {
                deltaF--;
                fpsCount++;
                List<RenderComponent> currRens = new ArrayList<>();
                currRens.add(player.getRenderComp());
                
                ren.getRenderables(currRens);
            }
            
            if(deltaU >= 1)
            {
                deltaU--;
                upsCount++;
                
                float deltaTime = (float)(1.0 / upsRate);
                
                player.update(deltaTime);
            }
            
            if((System.currentTimeMillis() - lastCheck) >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                //System.out.println("FPS: " + fpsCount + " | UPS: " + upsCount);
                player.displayPosition();
                fpsCount = 0;
                upsCount = 0;
            }
            
             try {
                long sleepTime = (long) (Math.min(nsPerFrame - deltaF * nsPerFrame, nsPerUpdate - deltaU * nsPerUpdate) / 1_000_000);
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }
        
    }
    
                
    
}
