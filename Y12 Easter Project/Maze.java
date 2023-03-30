class Maze extends Game {
  
  //Variables go here

  public Maze(){
    name = "Maze";
    description = "Not yet implemented.";
  }

  public void init(){
    //Map generation?
  }

  public void render(){
    // Need to draw walls , empty space, player, target
    // e.g.
    // #######
    // # #   V
    // # # ###
    // # #   #
    // # ### #
    // X     #
    // #######
  }

  public void input(){
    //W up, A left, S, down, D right
  }

  public void update(){
    //Check if player has reached end of maze.
  }

  public void endgame(){
  }
}