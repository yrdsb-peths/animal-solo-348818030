import greenfoot.*;
// World where our hero lives
// Adrian
// April 27 2026


public class MyWorld extends World {
    
    public int score = 0;
    Label scoreLabel;
    int level = 1;    
    // Constructor for objects of class MyWorld
    public MyWorld() {
        super(600, 400, 1, false);
        
        // Resize background to fit world
        GreenfootImage plainsBg = new GreenfootImage("Images/prideLands.jpg");
        plainsBg.scale(getWidth(), getHeight());
        setBackground(plainsBg);
        
        // Create elephant
        Elephant hero = new Elephant();
        addObject(hero,300,200);
        
        // Creates a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        // Spawn apple
        createApple();
        
    }
    
    // End the game and draw 'GameOver'
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    // Increase score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    // Creates a new apple at a random location at the top
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple,x,y);
        
        
    }
    
}
