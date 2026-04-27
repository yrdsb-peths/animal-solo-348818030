import greenfoot.*;
// World where our hero lives
// Adrian
// April 27 2026


public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Elephant hero = new Elephant();
        addObject(hero,300,200);
        
        createApple();
        
    }
    
    // Creates a new apple at a random location at the top
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple,x,y);
        
        
    }
    
}
