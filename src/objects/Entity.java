/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author MysterBotz
 */
public abstract class Entity {
    
    protected float posX;
    protected float posY;
    protected float width;
    protected float heigth;

    public Entity(float posX, float posY, float width, float heigth) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.heigth = heigth;
    }


    
    
    
}
