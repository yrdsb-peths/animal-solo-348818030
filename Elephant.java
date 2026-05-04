import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant class, hero of the game
 * 
 * @author (Adrian) 
 * @version (April 27 2026)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephant.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Direction the elephant is facing
    String facing = "right";
    
    // Constructor - The code that gets run one time when the object is created
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/tile00" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/tile00" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        
        // Initial Elephant image
        setImage(idleRight[0]);
    }    
    
    // Animate the elephant
    int imageIndex = 0;
    public void animateElephant()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-1);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(1);
            facing = "right";
        }
        
        // Removes apple if elephant is touching it
        eat();
        
        // Animate the elephant
        animateElephant();
        
    }
    
    // Eat the apple and spawn a new apple
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            
            elephantSound.play();
        }
    }
}
