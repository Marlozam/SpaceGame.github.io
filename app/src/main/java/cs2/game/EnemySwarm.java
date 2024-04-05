package cs2.game;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemySwarm {
  private ArrayList<Enemy> swarm;
  private Image bullPic;

  
  // This constructor should create a swarm of enemies in a grid
  // The grid should be nRows x nCols in size.
  // The enemPic and bullPic should be used to create the Enemy instances
  // that are added to the ArrayList. The enemies should be spaced out
  // in a grid pattern across the top of the screen.
  public EnemySwarm(int nRows, int nCols, Image enemPic, Image bullPic) { 
    swarm = new ArrayList<>();
    nRows = 2;
    nCols = 7;
    this.bullPic = bullPic;
    
    //don't have to define anything yet
    
    // now do a forLoop in order to make a swarm of enemies 
    for(int i = 0; i < nRows; i++){
      for( int j = 0; j < nCols; j++){
        Enemy enemPic2 = new Enemy( enemPic, bullPic, new Vec2(50 + 100*j,100 + 100*i));
        swarm.add(enemPic2);
        
        //a bit confused on how I can then apply this to the new instance of Enemy for the spacing
      }
      
    }
    
  }
  

  
  // This method should display all enemies in the swarm
  public void display(GraphicsContext g) {
    // have to make another for loop that loops over each enemy i'm wanting to display
    // also want to use swarm.get() but we need to get a particular thing within this arrayList
    for(int i = 0; i < swarm.size(); i++){
      //within int should be :enemPic2 
      swarm.get(i).display(g);
      

    }
   }
  

  
  // This method should choose one enemy at random from the swarm,
  // and have that enemy shoot a bullet. Return that Bullet.
  public Bullet shoot() {
    int random = (int) (Math.random() * swarm.size());
    Enemy ran = swarm.get(random);
    Bullet enemB = new Bullet(this.bullPic, ran.pos.clone(), new Vec2(0, 1)  );
    return enemB;
    //however should I call this method from this class and then put it with in  my KeyPress
   }
  
}
