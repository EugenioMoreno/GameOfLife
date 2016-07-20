package vividseats.challenge.gameOfLife;

/**
 * Created by eugen on 7/19/2016.
 */
public class Board {
    private int xGrid;
    private int yGrid;
    private int totalAlive=0;
    private int totalDead=0;
    private Cell[][] boardGrid;

    public Board(int gridHeight, int gridWidth) {
        this.yGrid = gridHeight;
        this.xGrid = gridWidth;
        this.boardGrid =new Cell[yGrid][xGrid];
    }


    public int getxGrid() {
        return xGrid;
    }

    public int getyGrid() {
        return yGrid;
    }

    public Cell[][] getBoardGrid() {
        return this.boardGrid;
    }

    public void setBoardGrid(int[][] integerGrid) {
        setTotalAlive(0);
        setTotalDead(0);
        for (int i = 0; i <getyGrid() ; i++) {
            for (int j = 0; j <getxGrid() ; j++) {
                if (integerGrid[i][j]==1){
                    boardGrid[i][j]=new Cell(true);
                    this.totalAlive++;
                }else{boardGrid[i][j]=new Cell(false);
                    this.totalDead++;
                }
            }

        }
    }

    public int getTotalAlive() {
        return totalAlive;
    }

    public void setTotalAlive(int totalAlive) {
        this.totalAlive = totalAlive;
    }

    public int getTotalDead() {
        return totalDead;
    }

    public void setTotalDead(int totalDead) {
        this.totalDead = totalDead;
    }

    public void setRandomGrid(){
        for (int i = 0; i <getyGrid() ; i++) {
            for (int j = 0; j <getxGrid() ; j++) {
                boardGrid[i][j]=new Cell(true);
                boardGrid[i][j].setRandomValue();
                if(boardGrid[i][j].isAlive()){
                    this.totalAlive++;
                } else this.totalDead++;

            }
        }
    }

    public void copyBoardFrom(Board b){
        setTotalAlive(0);
        setTotalDead(0);
        for (int i = 0; i <getyGrid() ; i++) {
            for (int j = 0; j <getxGrid() ; j++) {
                boardGrid[i][j].setAlive(b.getBoardGrid()[i][j].isAlive());
                if (boardGrid[i][j].isAlive()){
                    this.totalAlive++;
                }else this.totalDead++;
            }
        }
    }

    public void printBoard(){
        int x=getxGrid();
        int y=getyGrid();

        String[] lines2print=new String[y];


        for (int i = 0; i < y; i++) {
            StringBuilder line=new StringBuilder();
            for (int j = 0; j < x; j++) {
                line.append(getBoardGrid()[i][j].toString());
            }
            lines2print[i]=line.toString();
        }

        System.out.println("---------------------------------------------------------- ");
        for (String line:lines2print) {
            System.out.println(line);
        }
        System.out.println("---------------------------------------------------------- ");
    }
}
