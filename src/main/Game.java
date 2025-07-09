/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import graphics.Renderer;
import inputs.KeyInput;
import objects.Player;
import objects.PlayerService;

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
        this.player = new Player();
        PlayerService.registerPlayer(this.player);
        this.key = new KeyInput(PlayerService.getRegPlayer());
        
        this.win = win;
        this.ren = win.getRenderer();
        this.ren.getKeyInput(key);
        
        //Test PlayerService
        
    }

    @Override
    public void run() {
        
        int fpsRate = 120;
        int upsRate = 60;
        int fpsCount = 0;
        int upsCount = 0;

        double fps = 1000000000/fpsRate;
        double ups = 1000000000/upsRate;

        long prevTime = System.nanoTime();

        double deltaU = 0;
        double deltaF = 0;

        long lastCheck = System.currentTimeMillis();
        
        while(true)
        {
            long currTime = System.nanoTime();
            
            deltaF += (currTime - prevTime) / fps;
            deltaU += (currTime - prevTime) / ups;
            prevTime = currTime;
            
            if(deltaF >= 1)
            {
                deltaF--;
                fpsCount++;
                ren.repaint();
            }
            
            if(deltaU >= 1)
            {
                deltaU--;
                upsCount++;
                
            }
            
            if((System.currentTimeMillis() - lastCheck) >= 1000)
            {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + fpsCount + " | UPS: " + upsCount);
                fpsCount = 0;
                upsCount = 0;
            }
        }
        
    }
    
    
    
}
