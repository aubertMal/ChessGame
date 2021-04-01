package aubert.chessGame.controller;

import aubert.chessGame.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class ChessGameController implements Initializable {

    private List<Piece> piecesNoires = new ArrayList<>();
    private List<Piece> piecesBlanches = new ArrayList<>();
    private List<Case> casesEchiquier = new ArrayList<>();
    private List<Deplacement> deplacementsEffectues = new ArrayList<>();
    private Couleur tourAJouer=Couleur.BLANC;

    private Plateau plateau = new Plateau(piecesNoires, piecesBlanches, casesEchiquier);

    private Partie partie = new Partie(plateau, deplacementsEffectues,tourAJouer);
    private HashMap<Pane, Position> mapCasePane = new HashMap<>();

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

    @FXML
    private Text debutPartie;

    @FXML
    private Text tour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initMapPositions();

        boutonNouvellePartie.setOnMouseClicked(mouseEvent -> {
            partie.creerNouvellePartie();
            debutPartie.setText("Début d'une nouvelle partie");
            placerPiecesBlanches();
            placerPiecesNoires();
            tour.setText("Blancs");
        });

//        pane_0_0.setOnMouseClicked(mouseEvent -> {
//            Position positionCliquee = new Position(0,0);
//            List<Position> positionsPossibles = new ArrayList<>();
//            for (Case caseCliquee: casesEchiquier) {
//                if (caseCliquee.getPositionCase().equals(positionCliquee)){
//                    if (caseCliquee.getPiece()!=null){
//                        positionsPossibles = caseCliquee.getPiece().deplacementsPossibles(positionCliquee);
//                    }
//                }
//            }
//        });

        for (Map.Entry<Pane,Position> entry:mapCasePane.entrySet()) {
            Pane paneTemp = entry.getKey();
            paneTemp.setOnMouseClicked(mouseEvent -> {
                List<Position> positionsPossibles = new ArrayList<>();
                for (Case caseCliquee:casesEchiquier) {
                    if (caseCliquee.getPositionCase().equals(entry.getValue())){
                        positionsPossibles = caseCliquee.getPiece().deplacementsPossibles(entry.getValue());
                    }

                }

                for (Position posPossible:positionsPossibles) {
                    Pane panePossible = trouverPaneParPosition(posPossible,mapCasePane);
                    panePossible.setStyle("-fx-background-color: #641010;");
                }
            });
        }
    }

    private Pane trouverPaneParPosition(Position position, HashMap<Pane, Position> map){
        Pane paneToReturn = new Pane();
        for (Map.Entry<Pane,Position> entry: this.mapCasePane.entrySet()) {
            if (entry.getValue().equals(position))
                paneToReturn=entry.getKey();
        }
        return paneToReturn;
    }

    private void initMapPositions() {

        mapCasePane.put(pane_0_0,new Position(0,0));
        mapCasePane.put(pane_1_0,new Position(1,0));
        mapCasePane.put(pane_2_0,new Position(2,0));
        mapCasePane.put(pane_3_0,new Position(3,0));
        mapCasePane.put(pane_4_0,new Position(4,0));
        mapCasePane.put(pane_5_0,new Position(5,0));
        mapCasePane.put(pane_6_0,new Position(6,0));
        mapCasePane.put(pane_7_0,new Position(7,0));

        mapCasePane.put(pane_0_1,new Position(0,0));
        mapCasePane.put(pane_1_1,new Position(1,1));
        mapCasePane.put(pane_2_1,new Position(2,1));
        mapCasePane.put(pane_3_1,new Position(3,1));
        mapCasePane.put(pane_4_1,new Position(4,1));
        mapCasePane.put(pane_5_1,new Position(5,1));
        mapCasePane.put(pane_6_1,new Position(6,1));
        mapCasePane.put(pane_7_1,new Position(7,1));

        mapCasePane.put(pane_0_2,new Position(0,2));
        mapCasePane.put(pane_1_2,new Position(1,2));
        mapCasePane.put(pane_2_2,new Position(2,2));
        mapCasePane.put(pane_3_2,new Position(3,2));
        mapCasePane.put(pane_4_2,new Position(4,2));
        mapCasePane.put(pane_5_2,new Position(5,2));
        mapCasePane.put(pane_6_2,new Position(6,2));
        mapCasePane.put(pane_7_2,new Position(7,2));

        mapCasePane.put(pane_0_3,new Position(0,3));
        mapCasePane.put(pane_1_3,new Position(1,3));
        mapCasePane.put(pane_2_3,new Position(2,3));
        mapCasePane.put(pane_3_3,new Position(3,3));
        mapCasePane.put(pane_4_3,new Position(4,3));
        mapCasePane.put(pane_5_3,new Position(5,3));
        mapCasePane.put(pane_6_3,new Position(6,3));
        mapCasePane.put(pane_7_3,new Position(7,3));

        mapCasePane.put(pane_0_4,new Position(0,4));
        mapCasePane.put(pane_1_4,new Position(1,4));
        mapCasePane.put(pane_2_4,new Position(2,4));
        mapCasePane.put(pane_3_4,new Position(3,4));
        mapCasePane.put(pane_4_4,new Position(4,4));
        mapCasePane.put(pane_5_4,new Position(5,4));
        mapCasePane.put(pane_6_4,new Position(6,4));
        mapCasePane.put(pane_7_4,new Position(7,4));

        mapCasePane.put(pane_0_5,new Position(0,5));
        mapCasePane.put(pane_1_5,new Position(1,5));
        mapCasePane.put(pane_2_5,new Position(2,5));
        mapCasePane.put(pane_3_5,new Position(3,5));
        mapCasePane.put(pane_4_5,new Position(4,5));
        mapCasePane.put(pane_5_5,new Position(5,5));
        mapCasePane.put(pane_6_5,new Position(6,5));
        mapCasePane.put(pane_7_5,new Position(7,5));

        mapCasePane.put(pane_0_6,new Position(0,6));
        mapCasePane.put(pane_1_6,new Position(1,6));
        mapCasePane.put(pane_2_6,new Position(2,6));
        mapCasePane.put(pane_3_6,new Position(3,6));
        mapCasePane.put(pane_4_6,new Position(4,6));
        mapCasePane.put(pane_5_6,new Position(5,6));
        mapCasePane.put(pane_6_6,new Position(6,6));
        mapCasePane.put(pane_7_6,new Position(7,6));

        mapCasePane.put(pane_0_7,new Position(0,7));
        mapCasePane.put(pane_1_7,new Position(1,7));
        mapCasePane.put(pane_2_7,new Position(2,7));
        mapCasePane.put(pane_3_7,new Position(3,7));
        mapCasePane.put(pane_4_7,new Position(4,7));
        mapCasePane.put(pane_5_7,new Position(5,7));
        mapCasePane.put(pane_6_7,new Position(6,7));
        mapCasePane.put(pane_7_7,new Position(7,7));
    }

    public void placerPiecesBlanches(){
        ImageView imageTourBlanche = new ImageView(new Image(piecesBlanches.get(0).getImage()));
        ImageView imageCavalierBlanc = new ImageView(new Image(piecesBlanches.get(1).getImage()));
        ImageView imageFouBlanc = new ImageView(new Image(piecesBlanches.get(2).getImage()));
        ImageView imageReineBlanche = new ImageView(new Image(piecesBlanches.get(4).getImage()));
        ImageView imageRoiBlanc = new ImageView(new Image(piecesBlanches.get(3).getImage()));
        ImageView imageFouBlanc2 = new ImageView(new Image(piecesBlanches.get(5).getImage()));
        ImageView imageCavalierBlanc2 = new ImageView(new Image(piecesBlanches.get(6).getImage()));
        ImageView imageTourBlanche2 = new ImageView(new Image(piecesBlanches.get(7).getImage()));
        ImageView imagePionBlanc1 = new ImageView(new Image(piecesBlanches.get(8).getImage()));
        ImageView imagePionBlanc2 = new ImageView(new Image(piecesBlanches.get(9).getImage()));
        ImageView imagePionBlanc3 = new ImageView(new Image(piecesBlanches.get(10).getImage()));
        ImageView imagePionBlanc4 = new ImageView(new Image(piecesBlanches.get(11).getImage()));
        ImageView imagePionBlanc5 = new ImageView(new Image(piecesBlanches.get(12).getImage()));
        ImageView imagePionBlanc6 = new ImageView(new Image(piecesBlanches.get(13).getImage()));
        ImageView imagePionBlanc7 = new ImageView(new Image(piecesBlanches.get(14).getImage()));
        ImageView imagePionBlanc8 = new ImageView(new Image(piecesBlanches.get(15).getImage()));


        pane_0_0.getChildren().add(imageTourBlanche);
        pane_1_0.getChildren().add(imageCavalierBlanc);
        pane_2_0.getChildren().add(imageFouBlanc);
        pane_3_0.getChildren().add(imageReineBlanche);
        pane_4_0.getChildren().add(imageRoiBlanc);
        pane_5_0.getChildren().add(imageFouBlanc2);
        pane_6_0.getChildren().add(imageCavalierBlanc2);
        pane_7_0.getChildren().add(imageTourBlanche2);

        pane_0_1.getChildren().add(imagePionBlanc1);
        pane_1_1.getChildren().add(imagePionBlanc2);
        pane_2_1.getChildren().add(imagePionBlanc3);
        pane_3_1.getChildren().add(imagePionBlanc4);
        pane_4_1.getChildren().add(imagePionBlanc5);
        pane_5_1.getChildren().add(imagePionBlanc6);
        pane_6_1.getChildren().add(imagePionBlanc7);
        pane_7_1.getChildren().add(imagePionBlanc8);

    }

    public void placerPiecesNoires(){
        ImageView imageTourNoire = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(8).getImage()));
        ImageView imageCavalierNoir1 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(9).getImage()));
        ImageView imageFouNoir1 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(10).getImage()));
        ImageView imageRoiNoir = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(11).getImage()));
        ImageView imageReineNoire = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(12).getImage()));
        ImageView imageFouNoir2 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(13).getImage()));
        ImageView imageCavalierNoir2 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(4).getImage()));
        ImageView imageTourNoire2 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(15).getImage()));
        ImageView imagePionNoir1 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(0).getImage()));
        ImageView imagePionNoir2 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(1).getImage()));
        ImageView imagePionNoir3 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(2).getImage()));
        ImageView imagePionNoir4 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(3).getImage()));
        ImageView imagePionNoir5 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(4).getImage()));
        ImageView imagePionNoir6 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(5).getImage()));
        ImageView imagePionNoir7 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(6).getImage()));
        ImageView imagePionNoir8 = new ImageView(new Image(partie.getPlateau().getPiecesNoires().get(7).getImage()));

        pane_0_7.getChildren().add(imageTourNoire);
        pane_1_7.getChildren().add(imageCavalierNoir1);
        pane_2_7.getChildren().add(imageFouNoir1);
        pane_3_7.getChildren().add(imageRoiNoir);
        pane_4_7.getChildren().add(imageReineNoire);
        pane_5_7.getChildren().add(imageFouNoir2);
        pane_6_7.getChildren().add(imageCavalierNoir2);
        pane_7_7.getChildren().add(imageTourNoire2);

        pane_0_6.getChildren().add(imagePionNoir1);
        pane_1_6.getChildren().add(imagePionNoir2);
        pane_2_6.getChildren().add(imagePionNoir3);
        pane_3_6.getChildren().add(imagePionNoir4);
        pane_4_6.getChildren().add(imagePionNoir5);
        pane_5_6.getChildren().add(imagePionNoir6);
        pane_6_6.getChildren().add(imagePionNoir7);
        pane_7_6.getChildren().add(imagePionNoir8);

    }
}
