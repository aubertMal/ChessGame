package aubert.chessGame.controller;

import aubert.chessGame.model.Partie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessGameController implements Initializable {

    private Partie partie = new Partie();

    @FXML
    private Button boutonNouvellePartie;

    @FXML
    private Pane pane_0_0;
    @FXML
    private Pane pane_0_1;
    @FXML
    private Pane pane_0_2;
    @FXML
    private Pane pane_0_3;
    @FXML
    private Pane pane_0_4;
    @FXML
    private Pane pane_0_5;
    @FXML
    private Pane pane_0_6;
    @FXML
    private Pane pane_0_7;

    @FXML
    private Pane pane_1_0;
    @FXML
    private Pane pane_1_1;
    @FXML
    private Pane pane_1_2;
    @FXML
    private Pane pane_1_3;
    @FXML
    private Pane pane_1_4;
    @FXML
    private Pane pane_1_5;
    @FXML
    private Pane pane_1_6;
    @FXML
    private Pane pane_1_7;

    @FXML
    private Pane pane_2_0;
    @FXML
    private Pane pane_2_1;
    @FXML
    private Pane pane_2_2;
    @FXML
    private Pane pane_2_3;
    @FXML
    private Pane pane_2_4;
    @FXML
    private Pane pane_2_5;
    @FXML
    private Pane pane_2_6;
    @FXML
    private Pane pane_2_7;

    @FXML
    private Pane pane_3_0;
    @FXML
    private Pane pane_3_1;
    @FXML
    private Pane pane_3_2;
    @FXML
    private Pane pane_3_3;
    @FXML
    private Pane pane_3_4;
    @FXML
    private Pane pane_3_5;
    @FXML
    private Pane pane_3_6;
    @FXML
    private Pane pane_3_7;

    @FXML
    private Pane pane_4_0;
    @FXML
    private Pane pane_4_1;
    @FXML
    private Pane pane_4_2;
    @FXML
    private Pane pane_4_3;
    @FXML
    private Pane pane_4_4;
    @FXML
    private Pane pane_4_5;
    @FXML
    private Pane pane_4_6;
    @FXML
    private Pane pane_4_7;

    @FXML
    private Pane pane_5_0;
    @FXML
    private Pane pane_5_1;
    @FXML
    private Pane pane_5_2;
    @FXML
    private Pane pane_5_3;
    @FXML
    private Pane pane_5_4;
    @FXML
    private Pane pane_5_5;
    @FXML
    private Pane pane_5_6;
    @FXML
    private Pane pane_5_7;

    @FXML
    private Pane pane_6_0;
    @FXML
    private Pane pane_6_1;
    @FXML
    private Pane pane_6_2;
    @FXML
    private Pane pane_6_3;
    @FXML
    private Pane pane_6_4;
    @FXML
    private Pane pane_6_5;
    @FXML
    private Pane pane_6_6;
    @FXML
    private Pane pane_6_7;

    @FXML
    private Pane pane_7_0;
    @FXML
    private Pane pane_7_1;
    @FXML
    private Pane pane_7_2;
    @FXML
    private Pane pane_7_3;
    @FXML
    private Pane pane_7_4;
    @FXML
    private Pane pane_7_5;
    @FXML
    private Pane pane_7_6;
    @FXML
    private Pane pane_7_7;

    @FXML
    private GridPane echiquier;

    ImageView imageTour = new ImageView(new Image("File:C:/Workspace/ChessGame/src/aubert/chessGame/img/tour.JPG"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGrid();
        boutonNouvellePartie.setOnMouseClicked(mouseEvent -> {
            partie.creerNouvellePartie();
        });

    }

    public void initGrid(){
        //pane_0_0.setStyle("-fx-background-image: " + imageTour + ";");
        pane_0_0.getChildren().add(imageTour);
    }
}
