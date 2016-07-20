# GameOfLife
VividSeat Challenge

//This is a solution for the game of life challenge from the website http://rubyquiz.strd6.com/quizzes/193-game-of-life

In this case, a random initial situation is generated and the application iterates over the board until there is a recursive situation,
which means that the board does not change from one iteration to the next one, or until all cells are either died or alive.

The architecture consists in a Board class which has a 2D array for the grid formed by object of the class Cell which has a Boolean
attribute which represents the status of the cell.

