package chess;

import boardgame.Board;
import boardgame.Piece;
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

  /**
   * Performs a chess move from the source position to the target position.
   *
   * @param sourcePosition The source position from which to move a chess piece.
   * @param targetPosition The target position to which the chess piece will be moved.
   * @return The captured chess piece, if any.
   * @throws ChessException If there is no piece on the source position or if the move is invalid.
   */

  public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
    Position source = sourcePosition.toPosition();
    Position target = targetPosition.toPosition();
    validateSourcePosition(source);
    Piece capturedPiece = makeMove(source, target);
    return (ChessPiece) capturedPiece;
  }

  private Piece makeMove(Position source, Position target) {
    Piece p = board.removePiece(source);
    Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    return capturedPiece;
  }

  private void validateSourcePosition(Position position) {
    if (!board.thereIsPiece(position)) {
      throw new ChessException("There is no piece on source position");
    }
    if (!board.piece(position).isThereAnyPossibleMove()) {
      throw new ChessException("There is no possible moves for the chosen piece");
    }
  }

  private void placeNewPiece(char column, int row, ChessPiece piece) {
    board.placePiece(piece, new ChessPosition(column, row).toPosition());
  }

  private void initialSetup() {
    placeNewPiece('c', 1, new Rook(board, Color.WHITE));
    placeNewPiece('c', 2, new Rook(board, Color.WHITE));
    placeNewPiece('d', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 2, new Rook(board, Color.WHITE));
    placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    placeNewPiece('d', 1, new King(board, Color.WHITE));

    placeNewPiece('c', 7, new Rook(board, Color.BLACK));
    placeNewPiece('c', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 7, new Rook(board, Color.BLACK));
    placeNewPiece('e', 8, new Rook(board, Color.BLACK));
    placeNewPiece('d', 8, new King(board, Color.BLACK));
  }

}
