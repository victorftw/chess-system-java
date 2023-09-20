package chess;

import boardgame.Position;

/**
 * Represents a chess position on the chessboard.
 */

public class ChessPosition {

  private char column;
  private int row;

  /**
   * Constructs a ChessPosition object with the specified column and row.
   *
   * @param column The column, represented by a character from 'a' to 'h'.
   * @param row The row, represented by an integer from 1 to 8.
   * @throws ChessException If the column or row values are not within valid chessboard limits.
   */

  public ChessPosition(char column, int row) {
    if (column < 'a' || column > 'h' || row < 1 || row > 8) {
      throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
    }
    this.column = column;
    this.row = row;
  }

  public char getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }

  protected Position toPosition() {
    return new Position(8 - row, column - 'a');
  }

  protected static ChessPosition fromPosition(Position position) {
    return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
  }

  @Override
  public String toString() {
    return "" + column + row;
  }

}
