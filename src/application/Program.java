package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;

/**
 * This is an empty Java program It serves as a starting point for your application.
 */

public class Program {

  /**
   * The main method that drives the program execution.
   *
   * @param args The command-line arguments (unused).
   */

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();

    while (true) {
      UserInterface.printBoard(chessMatch.getPieces());
      System.out.println();
      System.out.print("Source: ");
      ChessPosition source = UserInterface.readChessPosition(sc);

      System.out.println();
      System.out.print("Target: ");
      ChessPosition target = UserInterface.readChessPosition(sc);

      ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
    }
  }

}
