import java.util.Scanner;
class OandX extends Game {

  int[][] grid;
  public int turn;
  public int player;
  public int winner;
  public char[] icons = {' ','O','X'};
  Scanner scanner;

  public OandX(){
    name = "Noughts and Crosses";
    description = "For 2 players. Try to make a line of threes 0s or three Xs in the grid.";
  }

  public void init(){
    turn = 1;
    player = 1;
    gameover = false;
    winner = 0;
    scanner = new Scanner(System.in);
    grid = new int[3][3];
    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++){
        grid[i][j]=0;
      }
    }
  }

  public void render(){
    String display = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
    display+= "Noughts and Crosses\r\n";
    display+= "____________________________\r\n";
    if(gameover && winner==0){
      display+="Game over. It was a draw.\r\n";
    } else if(gameover){
      display+="Game over. The winner is "+icons[winner]+"\r\n";
    } else {
    display+= "Turn: "+turn+" Current Player: "+icons[player]+"\r\n";
    }
    display+= "____________________________\r\n";
    display+= "a  |b  |c  \r\n";
    display+= " "+icons[grid[0][0]]+" | "+icons[grid[0][1]]+" | "+icons[grid[0][2]]+" \r\n";
    display+= "___|___|___\r\n";
    display+= "d  |e  |f  \r\n";
    display+= " "+icons[grid[1][0]]+" | "+icons[grid[1][1]]+" | "+icons[grid[1][2]]+" \r\n";
    display+= "___|___|___\r\n";
    display+= "g  |h  |i  \r\n";
    display+= " "+icons[grid[2][0]]+" | "+icons[grid[2][1]]+" | "+icons[grid[2][2]]+" \r\n";
    display+= "   |   |   \r\n";
    display+= "____________________________\r\n";
    if(gameover){
      display+="Return to menu in 5 seconds.";
    } else{
      display+= "Enter a letter corresponding to an empty grid space.";
    }
    System.out.println(display);
  }

  public void input(){
    char input = scanner.next().charAt(0);
    switch (input){
      case 'a':
        if(grid[0][0]==0){
          grid[0][0]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'b':
        if(grid[0][1]==0){
          grid[0][1]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'c':
        if(grid[0][2]==0){
          grid[0][2]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'd':
        if(grid[1][0]==0){
          grid[1][0]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'e':
        if(grid[1][1]==0){
          grid[1][1]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'f':
        if(grid[1][2]==0){
          grid[1][2]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'g':
        if(grid[2][0]==0){
          grid[2][0]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'h':
        if(grid[2][1]==0){
          grid[2][1]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      case 'i':
        if(grid[2][2]==0){
          grid[2][2]=player;
          player = 3 - player;
          turn ++;
        }
        break;
      default:
        break;
    }
  }

  public void update(){
    if(grid[0][0]==grid[0][1] && grid[0][0]==grid[0][2] && grid[0][0]!=0){gameover = true;winner=grid[0][0];}
    if(grid[1][0]==grid[1][1] && grid[1][0]==grid[1][2] && grid[1][0]!=0){gameover = true;winner=grid[1][0];}
    if(grid[2][0]==grid[2][1] && grid[2][0]==grid[2][2] && grid[2][0]!=0){gameover = true;winner=grid[2][0];}
    if(grid[0][0]==grid[1][0] && grid[0][0]==grid[2][0] && grid[0][0]!=0){gameover = true;winner=grid[0][0];}
    if(grid[0][1]==grid[1][1] && grid[0][1]==grid[2][1] && grid[0][1]!=0){gameover = true;winner=grid[0][1];}
    if(grid[0][2]==grid[1][2] && grid[0][2]==grid[2][2] && grid[0][2]!=0){gameover = true;winner=grid[0][2];}
    if(grid[0][0]==grid[1][1] && grid[0][0]==grid[2][2] && grid[0][0]!=0){gameover = true;winner=grid[0][0];}
    if(grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0] && grid[0][2]!=0){gameover = true;winner=grid[0][2];}
    if(turn==10){gameover = true;winner=0;}
  }

  public void endgame(){
    render();
    try{
      Thread.sleep(5000);
    } catch (Exception e){}
  }
}