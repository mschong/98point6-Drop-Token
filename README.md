# 98point6 Drop Token
Drop Token takes place on a 4x4 grid. A token is dropped along a
column (labeled 1-4) and said token goes to the lowest unoccupied
row of the board. A player wins when they have 4 tokens next to each
other either along a row, in a column, or on a diagonal. If the board is
filled, and nobody has won then the game is a draw. Each player takes
a turn, starting with player 1, until the game reaches either win or
draw. If a player tries to put a token in a column that is already full, that
results in an error state, and the player must play again until the play a
valid move.

## Getting Started
* Download/Clone project
* In command prompt, go to the project directory
* Run
```
javac Game.java
java Game
```

## Game Instructions
* To add token to the board
```
PUT <column number>
```
* To display board
```
BOARD
```
* To display all successful moves
```
GET
```
* To exit game
```
EXIT
```

### Example
```
> BOARD
| 0 0 0 0
| 0 0 0 0 
| 0 0 0 0 
| 0 0 0 0 
+--------
  1 2 3 4 
> PUT 1
OK

> BOARD
| 0 0 0 0 
| 0 0 0 0 
| 0 0 0 0 
| 1 0 0 0 
+--------
  1 2 3 4 
```
