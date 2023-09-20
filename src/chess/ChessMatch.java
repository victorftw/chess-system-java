package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Represents a chess match, including the chessboard and its pieces.
 */

public class ChessMatch {

  private Board board;

  public ChessMatch() {
    board = new Board(8, 8);
    initialSetup();
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

  private void initialSetup() {
    board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
    board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
    board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
  }

}
