import java.io.*;
import java.util.*;
class Beanstalk extends Game {

  public int min, max, position, level, score, axe, width, height, difficulty;
  public int[] beanstalks;
  public String message;
  public char[] upchars = {'A','D','H','S'};
  public List<int[]> upgrades;

  public Beanstalk(){
    name = "Beanstalk Pruning Game";
    description = "Stop the beanstalks from reaching the top of the screen.";
  }

  public void init(){
    gameover = false;
    difficulty = 0; min = 2; max = 4; position = 3; level = 1; score = 0; axe = 1; height = 10; width=7;
    beanstalks = new int[width];
    for(int i=0;i<width;i++){
      beanstalks[i]=0;
    }
    message = "";
    upgrades = new LinkedList<int[]>();
    time=1500;
  }
  
  public void render(){
    String display = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
    display+= "Magic Beanstalk Pruning Game\r\n";
    display+= "____________________________\r\n";
    display+= "Score: "+score+"   Level: "+level+"   Difficulty: "+difficulty+"   Axe: "+axe+"\r\n";
    display+= message +"\r\n";
    String[][] parts = new String[width][height];
    for (int i=0;i<width;i++){
      for (int j=0;j<height;j++){
        if(beanstalks[i]<j){
          parts[i][j]="   ";
        } else if(beanstalks[i]>j){
          String m,n;
          if((i+j)%2==beanstalks[i]%2){
            m="/";
          } else {
            m="\\";
          }
          n =m;
          for (int k=0;k<upgrades.size();k++){
            int[] name = upgrades.get(k);
            if(name[0]==i && name[1]==j){
              if((name[2]==0 && axe>=6) ||(name[2]==2 && height >=18)){
                n = ""+upchars[3];
              } else {
                n=""+upchars[name[2]];
              }
            }
          }
          parts[i][j]=m+n+m;
        } else {
          if(j==0){
            parts[i][j]="___";
          } else if ((i+j)%2==beanstalks[i]%2){
            parts[i][j]="/\\ ";
          }
          else {
            parts[i][j]=" /\\";   
          }
        }
      }
    }
    for (int y=height-1;y>=0;y--){
      if (y==height/2 && gameover){
        display+="GAME OVER - FINAL SCORE "+score+". RETURN TO MENU IN 5 SECONDS.";
      } else
      for (int x=0;x<width;x++){
        display+=" "+parts[x][y];
      }
      display+="\r\n";
    }
    for (int i=0;i<width;i++){
      if (position == i){
        display +="  X ";
      } else {
        display +="    ";
      }
    }
    System.out.println(display);
  }

  public void input(){
    try{
      while(br.ready()){
        char input = (char)br.read();
        switch (input){
          case 'a':
            if(position > 0){
              position--;
            }
            break;
          case 'd':
            if(position < width-1){
              position++;
            }
            break;
          default:
        }
      }
    } catch (IOException e){}
  }

  public void update(){
    message = "";
    int grow = min+(int)Math.floor(Math.random()*(max+1-min));
    beanstalks[grow]++;
    for (int i=1;i<Math.sqrt(level);i++){
      if (Math.random()*10>7-difficulty){
        grow = min+(int)Math.floor(Math.random()*(max+1-min));
        beanstalks[grow]++;
      }
    }
    int i=0;
    while (i<upgrades.size()){
      int[] name = upgrades.get(i);
      if(name[0]==position && name[1]>axe){
        upgrades.get(i)[1]-=axe;
      }
      else if(name[0]==position && name[1]<=axe){
        switch(name[2]){
          case 0:
            if(axe<6){
              axe++;
              message+="Axe upgraded! ";
            } else {
              score+=Math.max(10,level*(1+difficulty));
            message+="Score bonus +"+Math.max(10,level*(1+difficulty))+"! ";
            }
            break;
          case 1:
            difficulty++;
            time = 750+ 750/(1+difficulty);
            message+="Difficulty and score multiplier increased. ";
            break;
          case 2:
            if(height<18){
              height ++;
              message+="Maximum height increased! ";
            } else {
              score+=Math.max(10,level*(1+difficulty));
            message+="Score bonus +"+Math.max(10,level*(1+difficulty))+"! ";
            }
            break;
          case 3:
            score+=Math.max(10,level*(1+difficulty));
            message+="Score bonus +"+Math.max(10,level*(1+difficulty))+"! ";
            break;
          default:
        } 
      upgrades.remove(i);
      }else {
        i++;
      }
    }
    if (beanstalks[position]>axe){
      score +=axe*(1+difficulty/5);
      beanstalks[position]-=axe;
    } else {
      score+=beanstalks[position];
      beanstalks[position]=0;
    }
    for (int j=min;j<=max;j++){
      if (beanstalks[j]>=height){
        gameover = true;
        return;
      }
    }
    if(score > level*10 & score > level*level){
      level ++;
      if(level%10==0 && min>0){
        min--;
      }
      if(level%10==5 && max<width-1){
        max++;
      }
    }
    if(10*Math.random()<3-2/level){
      int x=0,y=0;
      boolean busy = true;
      int tries = 0;
      while(busy && tries < 10){
        x = min+(int)Math.floor(Math.random()*(max-min+1));
        y = (int)Math.floor(Math.random()*beanstalks[x]);
        tries++;
        boolean safe = true;
        for(int p=0;p<upgrades.size();p++){
          int[] name = upgrades.get(p);
          if(name[0]==x & name[1]==y){
            safe = false;
          }
        }
        if(safe){busy = false;}
        }
        if(!busy){
          int prize = (int)Math.floor(Math.random()*4);
          upgrades.add(new int[]{x,y,prize});
        }
      }
    }

  public void endgame(){
    message = "Score: "+score + " + Bonus: "+(level*level+difficulty*difficulty);
    score += level*level+difficulty*difficulty;
    render();
    try{
    Thread.sleep(5000);
    } catch(Exception e){}
  }
}