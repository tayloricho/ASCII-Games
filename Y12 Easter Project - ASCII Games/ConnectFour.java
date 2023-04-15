import java.util.Scanner;

class ConnectFour extends Game {

  // Variable declarations go here. Standard connect 4 has a 6x7 board and the
  // pieces are red (R) or black (B).

  int[][] grid;
  int[] colHeight = { 0, 0, 0, 0, 0, 0 };
  public int turn;
  public int player;
  public int winner;
  public char[] icons = { ' ', 'R', 'B' };
  Scanner scanner;

  public ConnectFour() {
    name = "ConnectFour";
    description = "For 2 players. Not yet implemented.";
  }

  public void init() {
    // Set variables to initial values for a new game
    turn = 1;
    player = 1;
    gameover = false;
    winner = 0;
    scanner = new Scanner(System.in);
    grid = new int[6][7];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        grid[i][j] = 0;
      }
    }
  }

  public void render() {
    // draw the grid to the screen

    // clear screen
    String display = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
    // title
    display += "Noughts and Crosses\r\n";
    display += "____________________________\r\n\r\n";
    // play info
    if (gameover && winner == 0) {
      display += "Game over. It was a draw.\r\n";
    } else if (gameover) {
      display += "Game over. The winner is " + icons[winner] + "\r\n";
    } else {
      display += "Turn: " + turn + " Current Player: " + icons[player] + "\r\n";
    }
    display += "____________________________\r\n";
    // grid
    display += "| " + icons[grid[0][0]] + " | " + icons[grid[1][0]] + " | " + icons[grid[2][0]] + " | "
        + icons[grid[3][0]] + " | " + icons[grid[4][0]] + " | " + icons[grid[5][0]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][1]] + " | " + icons[grid[1][1]] + " | " + icons[grid[2][1]] + " | "
        + icons[grid[3][1]] + " | " + icons[grid[4][1]] + " | " + icons[grid[5][1]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][2]] + " | " + icons[grid[1][2]] + " | " + icons[grid[2][2]] + " | "
        + icons[grid[3][2]] + " | " + icons[grid[4][2]] + " | " + icons[grid[5][2]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][3]] + " | " + icons[grid[1][3]] + " | " + icons[grid[2][3]] + " | "
        + icons[grid[3][3]] + " | " + icons[grid[4][3]] + " | " + icons[grid[5][3]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][4]] + " | " + icons[grid[1][4]] + " | " + icons[grid[2][4]] + " | "
        + icons[grid[3][4]] + " | " + icons[grid[4][4]] + " | " + icons[grid[5][4]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][5]] + " | " + icons[grid[1][5]] + " | " + icons[grid[2][5]] + " | "
        + icons[grid[3][5]] + " | " + icons[grid[4][5]] + " | " + icons[grid[5][5]] + " |\r\n";
    display += "|___|___|___|___|___|___|\r\n";

    display += "| " + icons[grid[0][6]] + " | " + icons[grid[1][6]] + " | " + icons[grid[2][6]] + " | "
        + icons[grid[3][6]] + " | " + icons[grid[4][6]] + " | " + icons[grid[5][6]] + " |\r\n";
    display += "|_1_|_2_|_3_|_4_|_5_|_6_|\r\n";
    // play help
    if (gameover) {
      display += "Return to menu in 5 seconds.";
    } else {
      display += "Enter a number corresponding to an empty collumn.";
    }
    // print
    System.out.println(display);
  }

  public void input() {
    // get the next move from the current player
    int input = scanner.nextInt();
    if (colHeight[input - 1] < 7) {
      grid[input - 1][6 - colHeight[input - 1]] = player;
      colHeight[input - 1] = colHeight[input - 1] + 1;
      player = 3 - player;
      turn++;
    }
  }

  public void update() {
    // check if a player has won
  }

  public void endgame() {
    // run render to display an end game message, wait for a few seconds then
    // terminate.
    render();
    try {
      Thread.sleep(5000);
    } catch (Exception e) {
    }
  }
}