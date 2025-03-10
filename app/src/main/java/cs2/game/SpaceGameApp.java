package cs2.game;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.HashSet;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SpaceGameApp extends Application {
  // now a scope and can be accesed in both timer and here 
  private EnemySwarm SwarmE;
  
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
          SwarmE = new EnemySwarm(2, 5, enemyi, bullImage);
         ArrayList<Bullet>bullets = new ArrayList<Bullet>();
         ArrayList<Bullet> enemBullets = new ArrayList<Bullet>();

         // making a set for smooth player movement 
         HashSet<KeyCode> pressed = new HashSet<KeyCode>();

         // creating a keyPressed event handeler 
        canvas.requestFocus();
         canvas.setOnKeyPressed( (KeyEvent e) -> {
        //this is where i do stuff
        pressed.add(e.getCode());
        
      });

      // making the release key 
      canvas.setOnKeyReleased((KeyEvent e)->{
        // simplifiedd 
        pressed.remove(e.getCode());
        
      });


      //////////////////////////////////////////////
      // keypressed event handeler for shooting bullet 
     
      
      //g.drawImage(img, 100, 100);
      AnimationTimer timer = new AnimationTimer(){

        private int counter = 0;
        double score = 0;
        double lives = 4;
        boolean gameOver = false;
      
        public void handle(long t){
          g.setFill(Color.BLUE);
          g.fillRect(0,0,800,800);
          

          //right here need to keep decreasing it within the timer and once that variable gets to 0
          //then I will be able to shoot
          counter= counter-1;

          //drawing here
          g.setFill(Color.BLUEVIOLET);
          g.fillRect(0,0,800,800);

          if (Math.random() < .04){
            if(counter <= 0){
              Bullet shootE =SwarmE.shoot() ; // * Math.random() and then if it gets 0 or 1  
              enemBullets.add(shootE);
              counter = 15;
            }
            
          }

          player1.display(g);
          //enemy1.display(g);
          SwarmE.display(g);
          // this is for smooth transition of ship using keys
          if (pressed.contains(KeyCode.RIGHT) || pressed.contains(KeyCode.D) ){
            player1.moveRight();
          }
          if (pressed.contains(KeyCode.LEFT) || pressed.contains(KeyCode.A)){
            player1.moveLeft();
          }
          if (pressed.contains(KeyCode.UP) || pressed.contains(KeyCode.W)){
            player1.moveUp();
          }
          if( pressed.contains(KeyCode.DOWN) || pressed.contains(KeyCode.S)){
            player1.moveDown();
          }
          if (pressed.contains(KeyCode.SPACE)){
            // make a codition right here if only our variable is 0 we can shoot 
            if(counter <= 0){
              Bullet save = player1.shoot(new Vec2(0, -10 ));
              bullets.add(save);//save.update();
              counter =15;
            }
          }
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
          // for loop for bullet player intersection 
          // keeping track of the amount of lives the player has 
          
          for ( int i = 0; i< enemBullets.size(); i++){
            if (player1.intersection(enemBullets.get(i))){
              enemBullets.remove(i);
              player1.setter(); 
              lives -=1;
              System.out.println("Live remaining: "+lives);
            }
            
          }
          g.setFill(Color.BLACK);
          g.setStroke(Color.rgb(0,0,0));
          g.fillText("Lives left: "+lives, 45, 440);
          // for loop for player bullet hit enemy removing bullet 
          // also score for player 
          // made rect for the displaying of lives and score 
          g.strokeRect(40, 400, 100, 60);
          for( int i=0; i< bullets.size() ; i++){
            if (SwarmE.intersection(bullets.get(i))){
              bullets.remove(i);
              score += 50;
              System.out.println("your score: "+score);
            }

          }
          g.setFill(Color.BLACK);
          g.setStroke(Color.rgb(0,0,0));
          g.fillText("Score: "+score, 45, 420);
          //if player intersects with enemy then return player to starting posistion 
          if(SwarmE.intersection(player1)){
            player1.setter();
          }
          
          // if player and enemy bullet intersect remove them
          for(int i = 0; i<bullets.size(); i++){
            for(int j =0; j<enemBullets.size(); j++){
              // need to put another if stament saying if i is still valid 
              // strating pint of the array list 0 end point is the size 
              if( i >= 0 && i <= bullets.size() ){
                if (bullets.get(i).intersection(enemBullets.get(j))){
                  bullets.remove(i);
                  enemBullets.remove(j);
                  System.out.println(bullets.size());
                }
              }
            }
          }
          // these for loops will remove the bullets if they go outside the screen
          for(int i=0; i<bullets.size(); i++){
            if(bullets.get(i).pos.getY() < 0){
              bullets.remove(i);
            }
          }
          for(int i=0; i< enemBullets.size(); i++){
            if(enemBullets.get(i).pos.getY() > 800){
              enemBullets.remove(i);
            }
          }
        
          // resetting the game and making a new EnemySwarm
          if(SwarmE.swarm.size() == 0){
            EnemySwarm nexLevel = new EnemySwarm(2, 5, enemyi, bullImage);
            SwarmE = nexLevel;
            nexLevel.display(g);
          }
          // GameOver
          if(lives == 0){
            gameOver = true;
          }
          if (gameOver == true){
            g.setFill(Color.RED);
            g.fillRect(0,0,800,800);
            int fontSize = 50;
            g.setFont(new Font("Arial", fontSize));
            g.setFill(Color.BLACK);
            g.setStroke(Color.rgb(0,0,0));
            g.fillText("GAME OVER", 260,400);
            g.fillText("TOTAL SCORE: "+score, 160,450);
            
            
          }
          
          
          
          
      
        }
      };
      
      

   
    timer.start();
  }
  
  
}
