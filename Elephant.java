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
    GreenfootImage[] idle = new GreenfootImage[8];
    
    // Constructor
    public Elephant()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/tile00" + i + ".png");
            idle[i].scale(100,100);
        }
        setImage(idle[0]);
    }    
    
    // Animate the elephant
    int imageIndex = 0;
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(1);
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
