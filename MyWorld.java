import greenfoot.*;
// World where our hero lives
// Adrian
// April 27 2026


public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Elephant hero = new Elephant();
        addObject(hero,300,200);
        
        Apple apple = new Apple();
        addObject(apple,300,0);
        
        
    }
}
