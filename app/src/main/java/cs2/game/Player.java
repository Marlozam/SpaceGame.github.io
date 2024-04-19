package cs2.game;

import cs2.util.Vec2;
import javafx.scene.image.Image;

public class Player extends Sprite {
  private Image bulletPicture;

  
  //This constructor should initialize all fields
  //**Remember that some fields are inherited from Sprite
  public Player(Image avatar, Image bullPic, Vec2 p) { 
    // keyword suer always has to go before everything else 
    super(avatar, p);
    this.bulletPicture = bullPic;
    
    
    
  }

  
  // This method should create a new Bullet object and return it
  // The Bullet should be initialized with the bulletPicture, the
  // current position of the player, and a velocity going up the screen
  public Bullet shoot(Vec2 vel) { 
    
    Bullet shoot = new Bullet(this.bulletPicture, this.pos.clone(), vel);
    return shoot;

  }

  
  // This method should move the player left by some amount
  public void moveLeft() {
    Vec2 mov= new Vec2(-5,0);
    double x = this.pos.getX();
    if (x > 5 ){
      this.move(mov);
    }

   }
  // will use this.pos.x then add or subtract it by a number prob good to start with 1 pixel
  // we would need to either add or subtract based on what specific was we are moving 
  
  //

  
  // This method should move the player right by some amount
  public void moveRight() { 
    Vec2 movR = new Vec2(5,0);
    double xPos = this.pos.getX();
    if (xPos <= 700.0){
      this.move(movR);
    }
    
  }
  // moving up
  public void moveUp(){
    Vec2 movU = new Vec2(0, -5);
    double goU = this.pos.getY();
    if ( goU > 100 ){
      this.move(movU);
    }
  }
  // moving down 
  public void moveDown(){
    Vec2 movD = new Vec2(0, 5);
    double goD = this.pos.getY();
    if (goD < 670 ){
      this.move(movD);
    }
    
  }
  
}
