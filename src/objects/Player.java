/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import config.Constants;
import java.awt.Graphics2D;

/**
 *
 * @author MysterBotz
 */
public class Player extends Entity{
    
    private RenderComponent renderComp;
    
    private boolean isUP, isDown, isLeft, isRigth;
    private boolean isOnGround = false;
    
    private float velX = 0, velY = 0;

    public Player(float posX, float posY, float width, float heigth) {
        super(posX, posY, width, heigth);
        this.renderComp = new RenderComponent();
        this.renderComp.updateComp(this.posX, this.posY, this.width, this.heigth);
    }
    
    public void update(float deltaTime)
    {
        float groundLevel = 500f; // Test
        float targetVelX = 0f;
        this.velY += Constants.GRAVITY * deltaTime;
        
        if(velY > Constants.TERMINAL_VEL)
        {
            velY = Constants.TERMINAL_VEL;
        }
        
        if(this.isLeft && !this.isRigth)
        {
            targetVelX = -Constants.PLAYER_SPEED;
        }
        
        if(!this.isLeft && this.isRigth)
        {
            targetVelX =  Constants.PLAYER_SPEED;
        }
        
        if(this.isOnGround())
        {
            this.velX = targetVelX;
        }
        else
        {
            this.velX *= Constants.AIR_FRICTION_FACTOR;
            
            if(targetVelX != 0f)
            {
                float currentAirAcceleration = Math.signum(targetVelX) * Constants.AIR_ACCELERATION_RATE;
                this.velX += currentAirAcceleration * deltaTime;
            }
            if (Math.abs(this.velX) > Constants.PLAYER_SPEED) { 
                this.velX = Math.signum(this.velX) * Constants.PLAYER_SPEED;
            }   
            if(Math.abs(this.velX) < Constants.MIN_VEL_THRESHOLD)
            {
                this.velX = 0;
            }
        }
        
        this.posX += velX * deltaTime; 
        this.posY += velY * deltaTime; 
        
        
        if(this.heigth + this.posY >= groundLevel)
        {
            this.posY = groundLevel - this.heigth;
            this.velY = 0;
            this.setOnGround(true);
        }else
        {
            this.setOnGround(false);
        }
        
        
        this.renderComp.updateComp(this.posX, this.posY, this.width, this.heigth);
    }
    
    public void jump()
    {
        if(this.isOnGround)
        {
            this.velY = -Constants.PLAYER_JUMP_STRENGTH;
            this.isOnGround = false;
            //System.out.println("YAH");
        }
    }
    
    public RenderComponent getRenderComp()
    {
        return this.renderComp;
    }
    
    public void setOnGround(boolean onGround) {
        this.isOnGround = onGround;
    }
    
    public boolean isOnGround() {
        return this.isOnGround;
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
        //System.out.println("(playerData)X: " + this.posX + " | Y: " + posY);
        //System.out.println("(renderData)X: " + renderComp.posX + " | Y: " + renderComp.posY);
       // System.out.println("-------------------------------------------------");
    }
    
    
}
