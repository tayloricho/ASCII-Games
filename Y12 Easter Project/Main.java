import java.util.Scanner;
class Main {

  static Game[] games;
  static Scanner scanner;

  public static void main(String[] args){
    games = new Game[5];
    games[0] = new Beanstalk();
    games[1] = new OandX();
    games[2] = new ConnectFour();
    games[3] = new Hangman();
    games[4] = new Maze();
    //games[5] = ???
    while(true){
      String display = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
      display+="Welcome to the Main Menu. What game would you like to play?\r\n";
      for(int i=0;i<games.length;i++){
        display+="---"+(i+1)+". "+games[i].name+"\r\n      "+games[i].description+"\r\n";
      }
      scanner = new Scanner(System.in);
      int choice = -1;
      System.out.println(display);
      while(choice<1 || choice>games.length){
        System.out.println("Enter a number between 1 and "+games.length);
        choice = Character.getNumericValue(scanner.next().charAt(0));
      }
      games[choice-1].play();
    }
  }

  
}