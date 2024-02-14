[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=13860966)
# Lab: Game of Life
![Game of Life](https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif)

Conway's Game of Life is not quite a game - it's actually a simulation or automaton that, based on a few simple rules, evolves as the simulation continues running. 

By using the comments in the project (on Replit) and by studying the rules of the Game of Life, correctly complete the methods countLiveNeighbors() and createNewGeneration() in the Board.java file to create a Game of Life simulation. 

Once that is complete, modify your project by:
- Change the images that are used for each character
- Change the board size
- Change the initial generation so that a self-sustaining pattern of more than 3 blocks appears in your simulation (i.e. it does not completely disappear - it can move however!).

### Rules of the Game of Life (from Wikipedia):

Every cell interacts with its eight neighbors, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:Any live cell with fewer than two live neighbors dies, as if by underpopulation.Any live cell with two or three live neighbors lives on to the next generation.Any live cell with more than three live neighbors dies, as if by overpopulation.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

These rules, which compare the behavior of the automaton to real life, can be condensed into the following:

Any live cell with two or three live neighbors survives.
Any dead cell with three live neighbors becomes a live cell.
All other live cells die in the next generation. Similarly, all other dead cells stay dead.

The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed, live or dead; births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick.


Each generation is a pure function of the preceding one. The rules continue to be applied repeatedly to create further generations.

## Grading Criteria
- Coding the simulation: Ensure that your simulation runs as expected (2x points)
- Adding in additional features
- Commenting and explaining code
- Indentation and structure

### Mastery (4):
Choose one of the following variations of Game of Life:

HighLife is similar to Game of Life, with one extra rule: a dead cell comes back to life if it is surrounded by 6 living cells. (+1)

The Immigration Game is identical to the original Game of Life, except any newborn cell is colored according to the majority color of its 3 living neighbors. For this, you would create new types of Cells with different emoji, and create a new method that would return the emoji type that is most prevalent as a neighbor. (+3)
