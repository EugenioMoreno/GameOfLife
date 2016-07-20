package vividseats.challenge.gameOfLife;

public class GameOfLife {
    public static int generation=1;
    protected static boolean endGame=false;
    protected static boolean tiedGame=false;

    public static void main(String[] args) {
        //Create the board
        Board board=new Board(3,3);
        //Initialize it with random values
        board.setRandomGrid();

        //Print the first generation
        System.out.println("Generation"+generation);
        board.printBoard();
        //Play the game until there is a final situation
        while(!endGame){
            playGame(board);
        }

    }
    public static void playGame(Board b){
        tiedGame=true;
        endGame=false;
        generation++;
        //Create and set up a buffer for the Board
        Board auxBoard=new Board(b.getyGrid(),b.getxGrid());
        auxBoard.setRandomGrid();
        auxBoard.copyBoardFrom(b);
        //Evaluate each cell's neighbors and apply a rule
        for (int i = 0; i <b.getyGrid() ; i++) {
            for (int j = 0; j < b.getxGrid(); j++) {
                //Current cell that it is being evaluated
                Cell currentCell=b.getBoardGrid()[i][j];
                //index 0 alive; index 1 dead
                int[] neighbors=countNeighbors(b.getBoardGrid(),i,j);
                int aliveNeighbors = neighbors[0];
                //Classify the cell and save the future status in to the buffer
                auxBoard.getBoardGrid()[i][j].setAlive(classifyCell(currentCell,aliveNeighbors));
                //Look for different value between iterations
                if (auxBoard.getBoardGrid()[i][j].isAlive()== !b.getBoardGrid()[i][j].isAlive()){
                    tiedGame=false;
                }
            }
        }
        b.copyBoardFrom(auxBoard);
        System.out.println("Generation"+generation);
        b.printBoard();
        //Check if there is a final situation
        checkResult(b);
    }

    private static void checkResult(Board b) {
        if (b.getTotalAlive()==b.getyGrid()*b.getxGrid()){
            endGame=true;
            System.out.println("Everyone is alive!:)");
        }

        if(b.getTotalAlive()==0){
            endGame=true;
            System.out.println("Everyone is dead:(");
        }
        if (tiedGame&&!endGame){
            endGame=true;
            System.out.println("There is an recurrent situation, the final situation is: "+"\n"
                                +"Number of cells alive= "+b.getTotalAlive()+"\n"
                                +"Number of dead cells= "+b.getTotalDead()+"\n");
        }
    }

    public static int[] countNeighbors(Cell[][] b, int y, int x){
        int[] neighbors={0,0};
        //Evaluate neighbors
        for (int i = y-1; i <=y+1 ; i++) {
            for (int j = x-1; j <=x+1 ; j++) {

                if(i==y&&j==x){
                    //This does not count because it is the cell itself
                }else if(i<0||j<0||i>=b.length||j>=b[0].length){
                //If we are out of the grid we will look at the next neighbor
                continue;
                } else{
                    if (b[i][j].isAlive())
                        neighbors[0]++;
                    else
                        neighbors[1]++;
                }
            }
        }
        return neighbors;
    }
    public static boolean classifyCell(Cell c, int alive){
        switch (alive){
            case 0:return false;
            case 1:return false;
            case 2:if (c.isAlive()) return true;
                else return false;
            case 3:return true;
            default: return false;
        }
    }

}

