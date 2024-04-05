package cs2.game;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import cs2.util.Vec2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpaceGameApp extends Application {
  
  public void start(Stage stage) {
    stage.setTitle("Walmart Galaga");
    stage.show();
    //You can change the window size here if you want
    Canvas canvas = new Canvas(800,800);
    stage.setScene(new Scene(new StackPane(canvas)));
    GraphicsContext g = canvas.getGraphicsContext2D();
    
    //fields
    //(should i make these doubles ?)
    

    /* Your main game logic will go here
     * This will likely mean creating instances of Player and EnemySwarm, along
     * with a collection (probably ArrayList) of Bullets.
     * 
     * You should create a KeyPressed event handler that moves the player
     * when the left or right arrow keys are pressed, and fires a bullet when
     * the space bar is pressed. Add the bullet created to the collection.
     * 
     * You should also create an AnimationTimer that displays everything and
     * moves the bullets around the screen. Also, an enemy chosen from the swarm
     * at random should shoot and have that bullet added to the collection.
     */
    // constructors (should i use protected of public) prob need to change lthis whole part

      
         
         final Image img = new Image("file:Player.jpg");
         final Image bullImage = new Image("file:Bullets.png");
         final Image enemyi = new Image("file:Enemy.jpeg");


         Enemy enemy1 = new Enemy(enemyi, bullImage, new Vec2(300, 100));
         
         // need some sort of possistion in here 
         //Bullet enemB = new Bullet(bullImage,, new Vec2(0, -1)  );
         
        
         Player player1= new Player(img, bullImage, new Vec2(300, 650) );
         
         //new help with this one 
         EnemySwarm SwarmE = new EnemySwarm(2, 5, enemyi, bullImage);
         ArrayList<Bullet>bullets = new ArrayList<Bullet>();
         ArrayList<Bullet> enemBullets = new ArrayList<Bullet>();

         // creating a keyPressed event handeler 
        canvas.requestFocus();
         canvas.setOnKeyPressed( (KeyEvent e) -> {
        //this is where i do stuff
        if(e.getCode()== KeyCode.LEFT && player1.pos.getX()>5){
          player1.moveLeft();
          // now think about how this can stay in the parameters of 800x800
        }
        else if(e.getCode() == KeyCode.RIGHT && player1.pos.getX()<700){
          player1.moveRight(); // have to get this to move right 
        }
        else if(e.getCode() == KeyCode.SPACE){
          Bullet save = player1.shoot(new Vec2(0, -10 ));
          bullets.add(save);
          
           //save.update();
           // have to use the update() somwhere in order to get the bullet ot move

           
          
          //want this to shoot
        }
      });
      //////////////////////////////////////////////
      // keypressed event handeler for shooting bullet 
     
      
      
      //g.drawImage(img, 100, 100);
      AnimationTimer timer = new AnimationTimer(){
        public void handle(long t){
          //drawing here
          g.setFill(Color.WHITE);
          g.fillRect(0,0,800,800);
          

          Bullet shootE =SwarmE.shoot();
          enemBullets.add(shootE);

          player1.display(g);
          enemy1.display(g);
          SwarmE.display(g);
          //Bullets saveS
          // want to loop through the arrayList 
           for( int i=0; i< bullets.size(); i++){
            bullets.get(i).update();
            bullets.get(i).display(g);


          }
          for (int j = 0; j< enemBullets.size(); j++){
            enemBullets.get(j).update();
            enemBullets.get(j).display(g);

          }
          
          
          
      
        }
      };
      
      

   
    timer.start();
  }
  
  
}
