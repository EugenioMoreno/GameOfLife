package vividseats.challenge.gameOfLife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eugen on 7/19/2016.
 */
public class GameOfLifeTest {

    public static Board testBoard=new Board(4,5);
    int [][] initialGrid={
            {1,1,1,0,0},
            {1,0,1,0,1},
            {1,1,1,0,0},
            {1,1,1,0,0}
    };

    @org.junit.Before
    public void setUp() throws Exception {
        testBoard.setBoardGrid(initialGrid);
    }
    @Test
    public void aliveCellWithTwoOrThreeNeighborsShouldLive(){
        //Having
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertTrue(testBoard.getBoardGrid()[0][0].isAlive());
        assertTrue(testBoard.getBoardGrid()[3][2].isAlive());
    }

    @Test
    public void deadCellWithThreeNeighborsShouldLive(){
        //Having
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertTrue(testBoard.getBoardGrid()[0][3].isAlive());
    }

    @Test
    public void deadCellWithLessThanThreeNeighborsShouldDie(){
        //Having
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[3][4].isAlive());//None neighbor alive
        assertFalse(testBoard.getBoardGrid()[0][4].isAlive());//One neighbor alive
        assertFalse(testBoard.getBoardGrid()[3][3].isAlive());//Two neighbors alive
    }

    @Test
    public void deadCellWithMoreThanThreeNeighborsShouldDie(){
        //Having
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[1][1].isAlive());//6 neighbors alive

    }

    @Test
    public void aliveCellWithMoreThanThreeNeighborsShouldDie(){
        //Having
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[0][1].isAlive());//6 neighbors alive

    }

    @Test
    public void everyoneDeadFinalSituation(){
        //Having
        Board deadBoard=new Board(2,2);
        int [][] initialGrid={
                {1,0},
                {1,0}
        };
        deadBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(deadBoard);
        //Then
        assertFalse(GameOfLife.tiedGame);
        assertTrue(GameOfLife.endGame);

    }
    @Test
    public void everyoneIsAliveFinalSituation(){
        //Having
        Board deadBoard=new Board(2,2);
        int [][] initialGrid={
                {1,0},
                {1,1}
        };
        deadBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(deadBoard);
        //Then
        assertFalse(GameOfLife.tiedGame);
        assertTrue(GameOfLife.endGame);

    }
    @Test
    public void TieFinalSituation(){
        //Having
        Board deadBoard=new Board(2,2);
        int [][] initialGrid={
                {1,1,0},
                {1,0,0},
                {1,0,0}
        };
        deadBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        GameOfLife.playGame(testBoard);
        GameOfLife.playGame(testBoard);

        //Then
        assertTrue(GameOfLife.tiedGame);
        assertTrue(GameOfLife.endGame);

    }
}