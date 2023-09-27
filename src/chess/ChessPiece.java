package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Represents a chess piece, which is a specific kind of piece on the chess board.
 */

public abstract class ChessPiece extends Piece {

  private Color color;

  public ChessPiece(Board board, Color color) {
    super(board);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

}
