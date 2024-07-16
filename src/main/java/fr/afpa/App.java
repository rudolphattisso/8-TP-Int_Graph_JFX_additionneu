package fr.afpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Logger logger = LogManager.getLogger(App.class);

    private int sum;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Additionneur");

        // Image icon = new Image(getClass().getResourceAsStream("src\\main\\calculatrice.png"));
        // stage.getIcons().add(icon);
        
        // champ
        TextArea area = new TextArea();
        area.setEditable(false);
        area.setWrapText(true);
     
        area.setPrefHeight(200);
        
       
    

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(area);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
       

        HBox hBoxNum1 = new HBox();
        hBoxNum1.setSpacing(5);
        hBoxNum1.setAlignment(Pos.CENTER);

        HBox hBoxNum2 = new HBox();
        hBoxNum2.setSpacing(5);
        hBoxNum2.setAlignment(Pos.CENTER);

        int nbBoutons = 9;
        for (int i = 0; i <= nbBoutons; i++) {
            Button button = new Button(String.valueOf(i));

            button.setOnAction(event -> {
                // Utilisation de l'objet événement pour obtenir le bouton cliqué
                Button clickedButton = (Button) event.getTarget();
                String textButton = clickedButton.getText();// recuper la e texte issue de la valeur du bouton cliqué
                area.setText(area.getText() + textButton + "+");
                sum = sum + Integer.valueOf(clickedButton.getText());
                area.setScrollTop(Double.MAX_VALUE);// forcer le scroll en bas
                
            });

            if (i <= 4) {
                hBoxNum1.getChildren().add(button);
            } else {
                hBoxNum2.getChildren().add(button);
            }

        }

        Button clearbButton = new Button("Clear");
        clearbButton.setPrefSize(80.0, 20.0);
        clearbButton.setOnAction(e -> {// action qui efface les données du champs
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Careful with the next step!");

            alert.showAndWait();
            area.clear();
            
        });

        Button calculateButton = new Button("Calculate");
        calculateButton.setPrefSize(80.0, 20.0);
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {// action qui qui va permettre l'addition;

            @Override
            public void handle(ActionEvent event) {

                //area.setText(String.valueOf(sum));
                area.appendText("="+String.valueOf(sum)+"+");
            }
            
        });

        // 1/ déclarer: Textfiel 9 boutons à mettre dans un GridPane 2 boutons à mettre
        // dans une Hbox mettre les 3 dans une Vbox

        // Vboxes

        // horizontal; avec les boutons action;
        HBox actionHBox1 = new HBox(clearbButton, calculateButton);
        actionHBox1.setSpacing(15);
        actionHBox1.setAlignment(Pos.CENTER);

        // conteneur horizontal pour les bouttons;|

        // VBox vBoxForH = new VBox(hBoxNum1,hBoxNum2);

        // grille pour placer les boutton et le champ;
        // GridPane gridBox = new GridPane();
        // gridBox.setAlignment(Pos.CENTER);

        // gridBox.add(hBoxNumZ,0,7,7,2);

        // Vbox qui recupère toutes les VBOX;
        VBox totalVbox = new VBox(scrollPane, hBoxNum1, hBoxNum2, actionHBox1);
        totalVbox.setSpacing(10);
        totalVbox.setAlignment(Pos.TOP_CENTER);

        var scene = new Scene(totalVbox, 500, 400);
        stage.setScene(scene);
        stage.show();

    }

}