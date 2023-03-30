import java.io.*;
abstract class Game {
  public boolean gameover = false;
  public long time = 1000;
  public String name;
  public String description;
  public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  
  public abstract void init();
  public abstract void render();
  public abstract void input();
  public abstract void update();
  public abstract void endgame();
  
  public final void gameloop(){
  while(!gameover){
      render();
      input();
      update();
      try{
      Thread.sleep(time);
      } catch (InterruptedException e){}
    }
  }

  public final void play(){
    init();
    gameloop();
    endgame();
  }

  
}