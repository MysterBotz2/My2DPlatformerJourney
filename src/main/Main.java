/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import graphics.Renderer;
import java.util.Scanner;

/**
 *
 * @author MysterBotz
 */
public class Main {
    
    public static void main(String[] args)
    {
        Renderer renderer = new Renderer();
        Window win = new Window(renderer);
   
        Game game = new Game(win);
        Thread gameThread = new Thread(game);
        gameThread.start();
        

    }
    
}
