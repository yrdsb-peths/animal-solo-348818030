import greenfoot.*;
// World where our hero lives
// Adrian
// April 27 2026


public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        // Create elephant
        Elephant hero = new Elephant();
        addObject(hero,300,200);
        
        // Creates a label
        Label scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        // Spawn apple
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
