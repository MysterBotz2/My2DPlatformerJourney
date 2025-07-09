/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.awt.Graphics2D;

/**
 *
 * @author MysterBotz
 */
public class Player extends Entity{
    
    private RenderComponent renderComp;
    
    private boolean isUP, isDown, isLeft, isRigth;

    public Player(int posX, int posY, int width, int heigth) {
        super(posX, posY, width, heigth);
        this.renderComp = new RenderComponent();
        this.renderComp.updateComp(this.posX, this.posY, this.width, this.heigth);
    }
    
    public void update()
    {
        int x = 0;
        
        if(this.isLeft && !this.isRigth)
        {
            x = -1;
        }
        
        if(!this.isLeft && this.isRigth)
        {
            x = 1;
        }
        
        this.posX += x;
        
        this.renderComp.updateComp(this.posX, this.posY, this.width, this.heigth);
    }
    
    public RenderComponent getRenderComp()
    {
        return this.renderComp;
    }

    public void setIsUP(boolean isUP) {
        this.isUP = isUP;
    }

    public void setIsDown(boolean isDown) {
        this.isDown = isDown;
    }

    public void setIsLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public void setIsRigth(boolean isRigth) {
        this.isRigth = isRigth;
    }
    
    public void displayPosition()
    {
        System.out.println("(playerData)X: " + this.posX + " | Y: " + posY);
        System.out.println("(renderData)X: " + renderComp.posX + " | Y: " + renderComp.posY);
        System.out.println("-------------------------------------------------");
    }
    
    
}
