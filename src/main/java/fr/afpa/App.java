package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Additionneur");
        //instanciation
        TextField displaField = new TextField();
        displaField.setEditable(false);
       
        // int numberButton;
        // for (int i=0; i<=numberButton ; i++) {
        //     Button b = new Button (Integer.toString(i)); 
        // }
    //buttons    
       Button b0 = new Button("0");
       Button b1 = new Button("1");
       Button b2 = new Button("2");
       Button b3 = new Button("3");
       Button b4 = new Button("4");
       Button b5 = new Button("5");
       Button b6 = new Button("6");
       Button b7 = new Button("7");
       Button b8 = new Button("8");
       Button b9 = new Button("9");
       Button clearbButton = new Button("Clear");
       Button calculateButton = new Button("Calculate");
       
       

    //Vboxes
      
        
       // horizontal
       HBox numHBox1 = new HBox(b0,b1,b2,b3,b4);
       HBox numHBox2 = new HBox(b5,b6,b7,b8,b9);
       numHBox1.setAlignment(Pos.CENTER);
       numHBox2.setAlignment(Pos.CENTER);
       VBox actionBox = new VBox(clearbButton, calculateButton);
       VBox vBoxNum = new VBox(numHBox1,numHBox2);



       GridPane boxPan = new GridPane();
        boxPan.add(displaField, 0,0,1,4);
         boxPan.add(vBoxNum,0,1,5,2);

       

        

      
        var scene = new Scene(boxPan);
        stage.setScene(scene);
        stage.show();
        
    }


}