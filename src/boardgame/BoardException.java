package boardgame;

/**
 * Custom exception class for board-related exceptions.
 */

public class BoardException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BoardException(String msg) {
    super(msg);
  }

}
