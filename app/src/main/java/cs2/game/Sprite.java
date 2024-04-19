package cs2.game;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
  protected Image img; // the image to be displayed for this sprite
  protected Vec2 pos; // the current position of this sprite

  /* The remained of the constructors and methods should be uncommented
   * as you write your code. I recommend keeping your project in a state
   * that it can always be run, even if it doesn't do much.
   * Then slowly over time, you can un-comment and add in additional
   * features.
   * DO NOT TRY TO WRITE EVERYTHING ALL AT ONCE. IT WILL NOT WORK.
   */


  // The constructor should initialize the fields of the class
  public Sprite(Image i, Vec2 p) { 
    this.img = i;
    this.pos = p;
  }

  // This method should draw the image at the current position
  public void display(GraphicsContext g) { 
    g.drawImage(img, pos.getX(), pos.getY(),100, 100);
  }

  
  // This method should change the location/position of the sprite
  // by the amount specified in the parameter delta
  public void move(Vec2 delta) { 
     this.pos.addThis(delta);
  }
  // can add another method making a setter for where my player originates once shot 
  public void setter(){
    this.pos = new Vec2(300, 650);
  }

  // maing a intersection and using booleans using that they are not intersecting 
  public boolean intersection( Sprite other){
    // need to make variables of width and height of player and bullet 
    // want to check x = width and y = height of object
    // want to negate final boolean do ths taking final reselt of what we are itersecting and flip it 
    int width = 100;
    int height = 100;
    if (((this.pos.getX() + 100) < other.pos.getX()) || (this.pos.getX() >(other.pos.getX()+100)) || (this.pos.getY() > (other.pos.getY()+100)) || ((this.pos.getY() + 100) < other.pos.getY() )){
      return false; // Not intersecting at all
    }
    else{return true;} // Intersecting
  }
   

}
