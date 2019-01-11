import javafx.animation.* ;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.input.* ;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.control.Label;


public class Pallo extends Application
{

  double IconSpeed = 10.7;
  double sijaintiY = 300;
  double sijaintiX = 400;
  double korkeus = 50;
  double leveys = 50;
  double kasvu = 8.8;
  int sceneLeveys = 780;
  int sceneKorkeus = 580;
  double stop = 0;



  public void start(Stage stage)
  {


  Group group_for_pallo = new Group();

  stage.setTitle("Pallo.java");

  Scene scene = new Scene(group_for_pallo, sceneLeveys,sceneKorkeus);

  scene.setFill(Color.LIGHTBLUE);




  Label control_label = new Label("Controls: UP,DOWN,LEFT RIGHT for moving. W and S to increase and decrease my head ");
  control_label.setTranslateY(0);


  Image myIconImage = new Image("Me.png");
  ImageView myIcon = new ImageView(myIconImage);
  myIcon.setX(400);
  myIcon.setY(300);



  myIcon.setFitHeight(50);
  myIcon.setFitWidth(50);
  float ballspeed = 10;
  float x = (float)(Math.random()*501);
  float y = (float)(Math.random()*501);
  float uusiX = 12;
  float uusiY = 12;
  float rad = 10;
  Circle circle = new Circle(x,y,rad);


  circle.setFill(Color.RED);




  scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
          switch (event.getCode()) {
              case UP:     if(sijaintiY>0)
              {
                myIcon.setY(sijaintiY = sijaintiY - IconSpeed);
              }
              break;
              case DOWN:   if(sijaintiY<sceneKorkeus-korkeus)
              {
                myIcon.setY(sijaintiY = sijaintiY + IconSpeed);
              }
              break;
              case LEFT:  if(sijaintiX>0)
              {
                myIcon.setX(sijaintiX = sijaintiX - IconSpeed);
              }
              break;
              case RIGHT:  if(sijaintiX<sceneLeveys-leveys)
              {
                myIcon.setX(sijaintiX = sijaintiX + IconSpeed);
              }
              break;
              case W:      myIcon.setFitWidth(leveys = leveys + kasvu);
                           myIcon.setFitHeight(korkeus = korkeus + kasvu);

                           break;
              case S:      myIcon.setFitWidth(leveys = leveys - kasvu);
                           myIcon.setFitHeight(korkeus = korkeus - kasvu);
                           break;
        

              }


          }



  });


  group_for_pallo.getChildren().addAll(myIcon, control_label,circle);
  stage.setScene( scene ) ;
  stage.show() ;


}




public static void main( String[] command_line_parameters )
   {
      launch( command_line_parameters ) ;
   }
}
