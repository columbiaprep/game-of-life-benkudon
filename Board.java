public class Board {

  private Cell[][] board;

  public Board(int rows, int cols) {
    board = new Cell[rows][cols];
    clearBoard();
    placeFirstGen();
    displayBoard();
  }

  //loops through 2D array and sets every char to the default emoji
  public void clearBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = new Cell(false);
      }
    }
  }

  //prints the board
  public void displayBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

//starts the board with the glider pattern
  public void placeFirstGen() {
    //setting up a glider pattern with alive cells
    board[1][2] = new Cell(true);
    board[2][3] = new Cell(true);
    board[3][1] = new Cell(true);
    board[3][2] = new Cell(true);
    board[3][3] = new Cell(true);
}


//counts live neighbors around cell at i, j
public int countLiveNeighbors(int i, int j) {
    int liveNeighbors = 0;
    int[] directions = {-1, 0, 1}; //to iterate over all eight neighbors
    for (int x : directions) {
      for (int y : directions) {
        //skipping cell itself because we're only interested in the neighbors
        if (x == 0 && y == 0) continue;
        
        //calculate the coordinates of the neighboring cell
        int ni = i + x; //countLiveNeighborsi --> the row index of the neighbor
        int nj = j + y; //nj --> the column index of the neighbor
        
        //now check if the neighbor's coordinates are within the bounds of the board
        //making sure we dont get an error by trying to access elements outside the array
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                //if the neighbor is within bounds, check if it's alive
                //make go up liveNeighbors count if this neighbor is alive
                if (board[ni][nj].getIsAlive()) {
                    liveNeighbors++;
                }
            }
        }
    }

    // return total at postion
    return liveNeighbors;
}


    //method that updates board for next generation based on the rules of Game of Life
    public void createNewGeneration() {
        Cell[][] nextGenBoard = new Cell[board.length][board[0].length]; //temp board for next gen
        for (int i = 0; i < board.length; i++) { //loop through
            for (int j = 0; j < board[i].length; j++) {
                int liveNeighbors = countLiveNeighbors(i, j); //count live neighbors
                boolean isAlive = board[i][j].getIsAlive(); //current cells state
                //rules for cell survival or death
                if (isAlive && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    //live cell with 2 or 3 neighbors survives
                    nextGenBoard[i][j] = new Cell(true);
                } else if (!isAlive && liveNeighbors == 3) {
                    //dead cell with exactly 3 live neighbors becomes alive
                    nextGenBoard[i][j] = new Cell(true);
                } else {
                    //all other cells die or remain dead
                    nextGenBoard[i][j] = new Cell(false);
                }
            }
        }
        board = nextGenBoard; //updates board to next gen
    }
}
