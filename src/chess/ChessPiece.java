package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

  protected boolean isThereOpponentPiece(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);
    return p != null && p.getColor() != color;
  }

}
