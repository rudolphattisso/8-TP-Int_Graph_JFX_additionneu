package fr.afpa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private int sum;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Additionneur");

        // champ
        TextArea area = new TextArea();
        area.setEditable(false);


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
                String textButton = clickedButton.getText();
                area.setText(area.getText() + textButton + "+");
                sum = sum + Integer.valueOf(clickedButton.getText());
            });
                
            if (i <= 4) {
                hBoxNum1.getChildren().add(button);
            }else  {
                hBoxNum2.getChildren().add(button);
            }

        }

        Button clearbButton = new Button("Clear");
        clearbButton.setOnAction(e -> {// action qui efface les données du champs
            area.clear();
        });

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {// action qui qui va permettre l'addition;

            @Override
            public void handle(ActionEvent event) {

             area.setText(String.valueOf(sum));
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
        VBox totalVbox = new VBox(area, hBoxNum1, hBoxNum2, actionHBox1);

        var scene = new Scene(totalVbox);
        stage.setScene(scene);
        stage.show();

    }

}