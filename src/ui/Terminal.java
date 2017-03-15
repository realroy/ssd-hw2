package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import game.Game;

public class Terminal {

	private Game game;
	private Scanner scanner;

	public void run() {
		// TODO: Write all game logic in here.
		game = new Game();
		game.start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!game.isEnd()) {
      System.out.println(game.getCurrentPlayerName() + " turn!");
      int row = 0;
      int col = 0;
      try {
        System.out.print("Selecte row: ");
        row = Integer.parseInt(reader.readLine());
        System.out.print("Selecte column: ");
        col = Integer.parseInt(reader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
      if(game.isEnd()) {
        System.out.println("Congratulation " + game.getWinnerName() + " win!");
        break;
      }
      game.currentPlayerTakesAction(row, col);
      renderBoard(game);
    }

		// If you do it correctly, you don't need to add new
		// functions into other classes.
	}

	private void renderBoard(Game game) {
		int size = game.getBoardSize();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				String s = game.getSymbolOnBoard(row, col);
				if(s == null) {
					s = "_";
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Terminal ui = new Terminal();
		ui.run();
	}

}
