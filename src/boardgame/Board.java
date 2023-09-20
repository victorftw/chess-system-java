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
    if (rows < 1 || columns < 1) {
      throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
    }
    this.rows = rows;
    this.columns = columns;
    pieces = new Piece[rows][columns];
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  /**
   * Returns the piece located at the specified position on the board.
   *
   * @param row The row of the position.
   * @param column The column of the position.
   * @return The piece at the specified position, or null if the position is empty.
   * @throws BoardException If the specified position is not on the board.
   */

  public Piece piece(int row, int column) {
    if (!positionExists(row, column)) {
      throw new BoardException("Position not on the board");
    }
    return pieces[row][column];
  }

  /**
   * Returns the piece located at the specified position on the board.
   *
   * @param position The position to check.
   * @return The piece at the specified position, or null if the position is empty.
   * @throws BoardException If the specified position is not on the board.
   */

  public Piece piece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }
    return pieces[position.getRow()][position.getColumn()];
  }

  /**
   * Places a piece on the board at the specified position.
   *
   * @param piece The piece to be placed on the board.
   * @param position The position where the piece should be placed.
   * @throws BoardException If there is already a piece at the specified position.
   */

  public void placePiece(Piece piece, Position position) {
    if (thereIsPiece(position)) {
      throw new BoardException("There is already a piece on position " + position);
    }
    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  private boolean positionExists(int row, int column) {
    return row >= 0 && row < rows && column >= 0 && column < columns;
  }

  public boolean positionExists(Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  /**
   * Checks if there is a piece at the specified position on the board.
   *
   * @param position The position to check.
   * @return True if there is a piece at the specified position, false otherwise.
   * @throws BoardException If the specified position is not on the board.
   */

  public boolean thereIsPiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }
    return piece(position) != null;
  }

}
