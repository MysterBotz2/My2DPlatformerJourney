/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package config;

/**
 *
 * @author MysterBotz
 */
public final class Constants {
    
    //Resolution 4:3
    public static final int RES_WIDTH = 16;
    public static final int RES_HEIGHT = 12;
    
    //Tile Sizing
    public static final int TILE_SIZE = 16;
    public static final int BASE_WIDTH = RES_WIDTH * TILE_SIZE;
    public static final int BASE_HEIGTH = RES_HEIGHT * TILE_SIZE;
    
    //Scaling
    
    //Gravity / Physics
    public static final float GRAVITY = 1000f;
    public static final float TERMINAL_VEL = 1000f;
    public static final float PLAYER_JUMP_STRENGTH = 500f;
    public static final float AIR_FRICTION_FACTOR = 0.95f;
    
    //Movement
    public static final float PLAYER_SPEED = 300.0f;
    public static float AIR_ACCELERATION_RATE = 700f;
    public static float MIN_VEL_THRESHOLD = 0.1f;
}
