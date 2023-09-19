package chess;

import boardgame.Board;

/**
 * Represents a chess match, including the chessboard and its pieces.
 */

public class ChessMatch {

  private Board board;

  public ChessMatch() {
    board = new Board(8, 8);
  }

  /**
   * Retrieves a 2D array of ChessPieces representing the current state of the chessboard.
   *
   * @return A 2D array of ChessPieces.
   */

  public ChessPiece[][] getPieces() {
    ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        mat[i][j] = (ChessPiece) board.piece(i, j);
      }
    }
    return mat;
  }
}
