package boardgame;

/**
 * Represents a game piece that can be placed on a board.
 */

public class Piece {
  protected Position position;
  private Board board;

  public Piece(Board board) {
    this.board = board;
    position = null;
  }

  protected Board getBoard() {
    return board;
  }

}
