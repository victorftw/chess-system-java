package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the user interface for printing the chessboard and its pieces.
 */

public class UserInterface {

  // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  // https://stackoverflow.com/questions/2979383/java-clear-the-console

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Reads a chess position from the given Scanner.
   *
   * @param sc The Scanner to read the chess position from.
   * @return The ChessPosition read from the Scanner.
   * @throws InputMismatchException If the input does not match the expected format.
   */

  public static ChessPosition readChessPosition(Scanner sc) {
    try {
      String s = sc.nextLine();
      char column = s.charAt(0);
      int row = Integer.parseInt(s.substring(1));
      return new ChessPosition(column, row);
    } catch (RuntimeException e) {
      throw new InputMismatchException(
          "Error reading ChessPosition. Valid values are from a1 to h8.");
    }
  }

  /**
   * Prints the current state of a chess match, including the chessboard, turn number, and current
   * player.
   *
   * @param chessMatch The ChessMatch object representing the current chess match.
   */

  public static void printMatch(ChessMatch chessMatch) {
    printBoard(chessMatch.getPieces());
    System.out.println();
    System.out.println("Turn: " + chessMatch.getTurn());
    System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
  }

  /**
   * Prints the chessboard with its pieces to the console.
   *
   * @param pieces A 2D array of ChessPieces representing the state of the chessboard.
   */

  public static void printBoard(ChessPiece[][] pieces) {
    for (int i = 0; i < pieces.length; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < pieces.length; j++) {
        printPiece(pieces[i][j], false);
      }
      System.out.println();
    }
    System.out.println("  a b c d e f g h");
  }

  /**
   * Prints the chessboard with chess pieces and highlights possible moves.
   *
   * @param pieces The 2D array representing chess pieces on the board.
   * @param possibleMoves A 2D boolean array indicating possible moves for each piece.
   */

  public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
    for (int i = 0; i < pieces.length; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < pieces.length; j++) {
        printPiece(pieces[i][j], possibleMoves[i][j]);
      }
      System.out.println();
    }
    System.out.println("  a b c d e f g h");
  }

  private static void printPiece(ChessPiece piece, boolean background) {
    if (background) {
      System.out.print(ANSI_BLUE_BACKGROUND);
    }
    if (piece == null) {
      System.out.print("-" + ANSI_RESET);
    } else {
      if (piece.getColor() == Color.WHITE) {
        System.out.print(ANSI_WHITE + piece + ANSI_RESET);
      } else {
        System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
      }
    }
    System.out.print(" ");
  }

}
