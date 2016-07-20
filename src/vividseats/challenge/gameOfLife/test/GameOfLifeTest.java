package vividseats.challenge.gameOfLife.test;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import vividseats.challenge.gameOfLife.Board;
import vividseats.challenge.gameOfLife.GameOfLife;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugen on 7/19/2016.
 */
public class GameOfLifeTest {


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void aliveCellWithTwoOrThreeNeighborsShouldLive()throws Exception{
        //Having
        Board testBoard=new Board(2,2);
        int [][] initialGrid={
                {1,1},
                {1,1}
        };
        testBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertTrue(testBoard.getBoardGrid()[0][0].isAlive());
        assertTrue(testBoard.getBoardGrid()[0][1].isAlive());
        assertTrue(testBoard.getBoardGrid()[1][0].isAlive());
        assertTrue(testBoard.getBoardGrid()[1][1].isAlive());
    }

    @Test
    public void deadCellWithThreeNeighborsShouldLive() throws Exception{
        //Having
        Board testBoard=new Board(2,2);
        int [][] initialGrid={
                {1,1},
                {1,0}
        };
        testBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertTrue(testBoard.getBoardGrid()[0][0].isAlive());
        assertTrue(testBoard.getBoardGrid()[0][1].isAlive());
        assertTrue(testBoard.getBoardGrid()[1][0].isAlive());
        assertTrue(testBoard.getBoardGrid()[1][1].isAlive());
    }

    @Test
    public void deadCellWithLessThanThreeNeighborsShouldDie() throws Exception{
        //Having
        Board testBoard=new Board(2,2);
        int [][] initialGrid={
                {0,0},
                {1,1}
        };
        testBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[0][0].isAlive());
        assertFalse(testBoard.getBoardGrid()[0][1].isAlive());
        //Any live cell with fewer than two live neighbours dies
        assertFalse(testBoard.getBoardGrid()[1][0].isAlive());
        assertFalse(testBoard.getBoardGrid()[1][1].isAlive());
    }

    @Test
    public void deadCellWithMoreThanThreeNeighborsShouldDie() throws Exception{
        //Having
        Board testBoard=new Board(3,2);
        int [][] initialGrid={
                {1,1},
                {0,1},
                {1,1}
        };
        testBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[1][0].isAlive());
    }

    @Test
    public void aliveCellWithMoreThanThreeNeighborsShouldDie() throws Exception{
        //Having
        Board testBoard=new Board(3,2);
        int [][] initialGrid={
                {1,1},
                {1,0},
                {1,1}
        };
        testBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(testBoard);
        //Then
        assertFalse(testBoard.getBoardGrid()[1][0].isAlive());
        assertFalse(testBoard.getBoardGrid()[1][1].isAlive());
    }

    @Test
    public void everyoneDeadFinalSituation() throws Exception {
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
        assertTrue(GameOfLife.isFinished(deadBoard));
        assertFalse(GameOfLife.tiedGame);

    }
    @Test
    public void everyoneIsAliveFinalSituation() throws Exception{
        //Having
        Board aliveBoard=new Board(2,2);
        int [][] initialGrid={
                {1,0},
                {1,1}
        };
        aliveBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(aliveBoard);
        //Then
        assertTrue(GameOfLife.isFinished(aliveBoard));
        assertFalse(GameOfLife.tiedGame);

    }
    @Test
    public void TieFinalSituation() throws Exception{
        //Having
        Board tiedBoard=new Board(3,3);
        int [][] initialGrid={
                {1,1,0},
                {1,0,0},
                {1,0,0}
        };
        tiedBoard.setBoardGrid(initialGrid);
        //When
        GameOfLife.playGame(tiedBoard);

        //Then
        assertTrue(GameOfLife.isFinished(tiedBoard));
        assertTrue(GameOfLife.tiedGame);


    }
    @Test(expected = Exception.class)
    public void dimensionException() throws Exception {
        //Having
        Board tiedBoard = new Board(5, 3);
        int[][] initialGrid = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 0, 0}
        };
        tiedBoard.setBoardGrid(initialGrid);
    }
}