package boardgame;

/**
 * Represents a game board with a grid of rows and columns.
 */

public class Board {

  private int rows;
  private int columns;
  private Piece[][] pieces;

  /**
   * Constructs a new Board with the specified number of rows and columns.
   *
   * @param rows The number of rows on the board.
   * @param columns The number of columns on the board.
   */

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    pieces = new Piece[rows][columns];
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getColumns() {
    return columns;
  }

  public void setColumns(int columns) {
    this.columns = columns;
  }

}
