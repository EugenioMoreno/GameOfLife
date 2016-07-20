package vividseats.challenge.gameOfLife;

import java.util.Random;

/**
 * Created by eugen on 7/19/2016.
 */
public class Cell {
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setRandomValue(){
        Random random = new Random();
        setAlive(random.nextBoolean());
    }

    @Override
    public String toString() {
        if (isAlive())
            return "1";
        else
            return "0";
    }
}
