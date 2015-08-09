#ObjectChess

##NHN NEXT 2014 2nd semester PL in Java final project

###Class Diagram
![alt tag](https://github.com/Ma-rk/ObjectiveChess/blob/master/img/img_04.png)

1. `Tile` type instance represents a tile on the chess board. Only "ONE" piece can occupy the tile.
2. A class `Piece` defines the "position/move count/color/serial of each piece of game.
3. An abstract class `TypeCross` defines that how the piece moves on the chess board. Cross type pieces(Bishop/Queen/Rock) extend it.
4. An abstract class `TypeJump` defines that how the piece moves on the chess board. Jump type pieces(King/Kight/Pawn) extend it.
5. The rest classes have the position or direction for themselves. Espetially `Pawn` has some more methods because of its special character. It can choose the distance of move when its first move.

###How to play
1. Run the main method then you can play the game.

2. White moves first.

3. Pick your piece which you want to move.

4. Select A highlighted point where you want to go or an enemy piece what you want to capture.
  - Movalbe point of Jump type piece.
    - ![alt tag](https://github.com/Ma-rk/ObjectiveChess/blob/master/img/img_01.png)
  - Movalbe path of Cross type piece.
    - ![alt tag](https://github.com/Ma-rk/ObjectiveChess/blob/master/img/img_02.png)

5. Players alternately move one piece per turn.

6. Player who captuers all pieces or King of opponent wins.
  - White Knight captured black King. White wins.
    - ![alt tag](https://github.com/Ma-rk/ObjectiveChess/blob/master/img/img_03.png)

7. Enjoy the game!!!
