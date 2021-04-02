package aubert.chessGame.controller;

import aubert.chessGame.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.*;

public class ChessGameController implements Initializable {

    private List<Piece> piecesNoires = new ArrayList<>();
    private List<Piece> piecesBlanches = new ArrayList<>();
    private List<Case> casesEchiquier = new ArrayList<>();
    private List<Deplacement> deplacementsEffectues = new ArrayList<>();
    private Couleur tourAJouer = Couleur.BLANC;

    private Plateau plateau = new Plateau(piecesNoires, piecesBlanches, casesEchiquier);

    private Partie partie = new Partie(plateau, deplacementsEffectues, tourAJouer);
    private HashMap<Pane, Case> mapCasePane = new HashMap<>();


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
    private Text debutPartie;

    @FXML
    private Text tour;

    private Case casePrecedente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        boutonNouvellePartie.setOnMouseClicked(mouseEvent -> {
            partie.creerNouvellePartie();
            initMapPositions();
            initGridPane();
            initPaneListeners();
            placerPiecesBlanches();
            placerPiecesNoires();
            debutPartie.setText("Début d'une nouvelle partie");
            tour.setText("Blancs");
        });

    }


    private void initPaneListeners() {
        //à chaque fois qu'on clique sur une case on va chercher la case correspondante dans les cases enregistrées, s'il y a une pièce dessus on va récupérer ses déplacements possibles
        for (Map.Entry<Pane, Case> entry : mapCasePane.entrySet()) {
            entry.getKey().setOnMouseClicked(mouseEvent -> {
                //si la case est en highlight alors on peut y effectuer un déplacement
                if (entry.getKey().getStyle().contains("#4C8295")){
                    //on enlève le marquage
                    initGridPane();
                    //On fait le déplacement
                    partie.effectuerDeplacement(casePrecedente, entry.getValue(), casePrecedente.getPiece());
                    //on met à jour le nouveauPane
                    updateImagePane(entry.getKey(), entry.getValue());
                    //On met à jour l'ancienPane
                    updateImagePane(trouverPaneParCase(casePrecedente.getPositionCase(), mapCasePane),casePrecedente);
                    System.out.println("ça marche");
                }
                // sinon on vérifie s'il y a une pièce alors on va voir ses déplacements possibles sinon la case est vide et on ne fait rien
                else if (entry.getValue().getPiece()!=null){
                    //pour enlever le setStyle défini au précédent clic
                    initGridPane();

                    //pour chaque position possible on va chercher les panes correspondants pour highlight
                    marquerPositionsPossibles(entry.getValue().getPositionCase());

                }
                casePrecedente=entry.getValue();
            });
        }
    }


    private Pane trouverPaneParCase(Position position, HashMap<Pane, Case> map) {
        Pane paneToReturn = new Pane();
        for (Map.Entry<Pane, Case> entry : this.mapCasePane.entrySet()) {
            if (plateau.comparePositions(position, entry.getValue().getPositionCase())) {
                paneToReturn = entry.getKey();
                return paneToReturn;
            }
        }
        //si la position ne correspond à aucun pane dans la map c'est qu'on dépasse le plateau
        return paneToReturn;
    }

    private void marquerPositionsPossibles(Position positionDepart){
        if (plateau.deplacementsPossibles(positionDepart) != null && plateau.deplacementsPossibles(positionDepart).size() != 0) {
            for (Position posPossible : plateau.deplacementsPossibles(positionDepart)) {
                Pane panePossible = trouverPaneParCase(posPossible, mapCasePane);
                if (panePossible != null)
                    panePossible.setStyle("-fx-background-color: #4C8295;");
            }
        }
    }

    private void initMapPositions() {//TODO: mieux avec un tableau de panes et une boucle for

        mapCasePane.put(pane_0_0, plateau.getCases().get(0));
        mapCasePane.put(pane_1_0, plateau.getCases().get(1));
        mapCasePane.put(pane_2_0, plateau.getCases().get(2));
        mapCasePane.put(pane_3_0, plateau.getCases().get(3));
        mapCasePane.put(pane_4_0, plateau.getCases().get(4));
        mapCasePane.put(pane_5_0, plateau.getCases().get(5));
        mapCasePane.put(pane_6_0, plateau.getCases().get(6));
        mapCasePane.put(pane_7_0, plateau.getCases().get(7));

        mapCasePane.put(pane_0_1, plateau.getCases().get(8));
        mapCasePane.put(pane_1_1, plateau.getCases().get(9));
        mapCasePane.put(pane_2_1, plateau.getCases().get(10));
        mapCasePane.put(pane_3_1, plateau.getCases().get(11));
        mapCasePane.put(pane_4_1, plateau.getCases().get(12));
        mapCasePane.put(pane_5_1, plateau.getCases().get(13));
        mapCasePane.put(pane_6_1, plateau.getCases().get(14));
        mapCasePane.put(pane_7_1, plateau.getCases().get(15));

        mapCasePane.put(pane_0_2, plateau.getCases().get(16));
        mapCasePane.put(pane_1_2, plateau.getCases().get(17));
        mapCasePane.put(pane_2_2, plateau.getCases().get(18));
        mapCasePane.put(pane_3_2, plateau.getCases().get(19));
        mapCasePane.put(pane_4_2, plateau.getCases().get(20));
        mapCasePane.put(pane_5_2, plateau.getCases().get(21));
        mapCasePane.put(pane_6_2, plateau.getCases().get(22));
        mapCasePane.put(pane_7_2, plateau.getCases().get(23));

        mapCasePane.put(pane_0_3, plateau.getCases().get(24));
        mapCasePane.put(pane_1_3, plateau.getCases().get(25));
        mapCasePane.put(pane_2_3, plateau.getCases().get(26));
        mapCasePane.put(pane_3_3, plateau.getCases().get(27));
        mapCasePane.put(pane_4_3, plateau.getCases().get(28));
        mapCasePane.put(pane_5_3, plateau.getCases().get(29));
        mapCasePane.put(pane_6_3, plateau.getCases().get(30));
        mapCasePane.put(pane_7_3, plateau.getCases().get(31));

        mapCasePane.put(pane_0_4, plateau.getCases().get(32));
        mapCasePane.put(pane_1_4, plateau.getCases().get(33));
        mapCasePane.put(pane_2_4, plateau.getCases().get(34));
        mapCasePane.put(pane_3_4, plateau.getCases().get(35));
        mapCasePane.put(pane_4_4, plateau.getCases().get(36));
        mapCasePane.put(pane_5_4, plateau.getCases().get(37));
        mapCasePane.put(pane_6_4, plateau.getCases().get(38));
        mapCasePane.put(pane_7_4, plateau.getCases().get(39));

        mapCasePane.put(pane_0_5, plateau.getCases().get(40));
        mapCasePane.put(pane_1_5, plateau.getCases().get(41));
        mapCasePane.put(pane_2_5, plateau.getCases().get(42));
        mapCasePane.put(pane_3_5, plateau.getCases().get(43));
        mapCasePane.put(pane_4_5, plateau.getCases().get(44));
        mapCasePane.put(pane_5_5, plateau.getCases().get(45));
        mapCasePane.put(pane_6_5, plateau.getCases().get(46));
        mapCasePane.put(pane_7_5, plateau.getCases().get(47));

        mapCasePane.put(pane_0_6, plateau.getCases().get(48));
        mapCasePane.put(pane_1_6, plateau.getCases().get(49));
        mapCasePane.put(pane_2_6, plateau.getCases().get(50));
        mapCasePane.put(pane_3_6, plateau.getCases().get(51));
        mapCasePane.put(pane_4_6, plateau.getCases().get(52));
        mapCasePane.put(pane_5_6, plateau.getCases().get(53));
        mapCasePane.put(pane_6_6, plateau.getCases().get(54));
        mapCasePane.put(pane_7_6, plateau.getCases().get(55));

        mapCasePane.put(pane_0_7, plateau.getCases().get(56));
        mapCasePane.put(pane_1_7, plateau.getCases().get(57));
        mapCasePane.put(pane_2_7, plateau.getCases().get(58));
        mapCasePane.put(pane_3_7, plateau.getCases().get(59));
        mapCasePane.put(pane_4_7, plateau.getCases().get(60));
        mapCasePane.put(pane_5_7, plateau.getCases().get(61));
        mapCasePane.put(pane_6_7, plateau.getCases().get(62));
        mapCasePane.put(pane_7_7, plateau.getCases().get(63));
    }

    public void updateImagePane(Pane paneAMettreAJour, Case nouvelleCase){
        if (nouvelleCase.getPiece()!=null)
            paneAMettreAJour.getChildren().add(new ImageView(new Image(nouvelleCase.getPiece().getImage())));
        else
            paneAMettreAJour.getChildren().clear();
    }
    public void placerPiecesBlanches() {//TODO: remplacer les positions en dur par un enum

        pane_0_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(0).getImage())));
        pane_1_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(1).getImage())));
        pane_2_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(2).getImage())));
        pane_3_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(3).getImage())));
        pane_4_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(4).getImage())));
        pane_5_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(5).getImage())));
        pane_6_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(6).getImage())));
        pane_7_0.getChildren().add(new ImageView(new Image(piecesBlanches.get(7).getImage())));

        pane_0_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(8).getImage())));
        pane_1_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(9).getImage())));
        pane_2_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(10).getImage())));
        pane_3_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(11).getImage())));
        pane_4_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(12).getImage())));
        pane_5_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(13).getImage())));
        pane_6_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(14).getImage())));
        pane_7_1.getChildren().add(new ImageView(new Image(piecesBlanches.get(15).getImage())));

    }

    public void placerPiecesNoires() {//TODO: enlever les variables locales comme pour la liste des blanches
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

    private void initGridPane() {//TODO: pas possible avec le keySet car les Pane ne seront pas dans l'ordre --> trouver mieux

//        Pane[] panes = mapCasePane.keySet().toArray(new Pane[0]);
//        for (int i = 0; i < panes.length; i++) {
//            if (i%2==0)
//                panes[i].setStyle("-fx-background-color: #DDDDDD;");
//            else
//                panes[i].setStyle("-fx-background-color: #FFFFFF;");
//        }

        pane_0_0.setStyle("-fx-background-color: #DDDDDD;");
        pane_1_0.setStyle("-fx-background-color: #FFFFFF;");
        pane_2_0.setStyle("-fx-background-color: #DDDDDD;");
        pane_3_0.setStyle("-fx-background-color: #FFFFFF;");
        pane_4_0.setStyle("-fx-background-color: #DDDDDD;");
        pane_5_0.setStyle("-fx-background-color: #FFFFFF;");
        pane_6_0.setStyle("-fx-background-color: #DDDDDD;");
        pane_7_0.setStyle("-fx-background-color: #FFFFFF;");

        pane_0_1.setStyle("-fx-background-color: #FFFFFF;");
        pane_1_1.setStyle("-fx-background-color: #DDDDDD;");
        pane_2_1.setStyle("-fx-background-color: #FFFFFF;");
        pane_3_1.setStyle("-fx-background-color: #DDDDDD;");
        pane_4_1.setStyle("-fx-background-color: #FFFFFF;");
        pane_5_1.setStyle("-fx-background-color: #DDDDDD;");
        pane_6_1.setStyle("-fx-background-color: #FFFFFF;");
        pane_7_1.setStyle("-fx-background-color: #DDDDDD;");

        pane_0_2.setStyle("-fx-background-color: #DDDDDD;");
        pane_1_2.setStyle("-fx-background-color: #FFFFFF;");
        pane_2_2.setStyle("-fx-background-color: #DDDDDD;");
        pane_3_2.setStyle("-fx-background-color: #FFFFFF;");
        pane_4_2.setStyle("-fx-background-color: #DDDDDD;");
        pane_5_2.setStyle("-fx-background-color: #FFFFFF;");
        pane_6_2.setStyle("-fx-background-color: #DDDDDD;");
        pane_7_2.setStyle("-fx-background-color: #FFFFFF;");

        pane_0_3.setStyle("-fx-background-color: #FFFFFF;");
        pane_1_3.setStyle("-fx-background-color: #DDDDDD;");
        pane_2_3.setStyle("-fx-background-color: #FFFFFF;");
        pane_3_3.setStyle("-fx-background-color: #DDDDDD;");
        pane_4_3.setStyle("-fx-background-color: #FFFFFF;");
        pane_5_3.setStyle("-fx-background-color: #DDDDDD;");
        pane_6_3.setStyle("-fx-background-color: #FFFFFF;");
        pane_7_3.setStyle("-fx-background-color: #DDDDDD;");

        pane_0_4.setStyle("-fx-background-color: #DDDDDD;");
        pane_1_4.setStyle("-fx-background-color: #FFFFFF;");
        pane_2_4.setStyle("-fx-background-color: #DDDDDD;");
        pane_3_4.setStyle("-fx-background-color: #FFFFFF;");
        pane_4_4.setStyle("-fx-background-color: #DDDDDD;");
        pane_5_4.setStyle("-fx-background-color: #FFFFFF;");
        pane_6_4.setStyle("-fx-background-color: #DDDDDD;");
        pane_7_4.setStyle("-fx-background-color: #FFFFFF;");

        pane_0_5.setStyle("-fx-background-color: #FFFFFF;");
        pane_1_5.setStyle("-fx-background-color: #DDDDDD;");
        pane_2_5.setStyle("-fx-background-color: #FFFFFF;");
        pane_3_5.setStyle("-fx-background-color: #DDDDDD;");
        pane_4_5.setStyle("-fx-background-color: #FFFFFF;");
        pane_5_5.setStyle("-fx-background-color: #DDDDDD;");
        pane_6_5.setStyle("-fx-background-color: #FFFFFF;");
        pane_7_5.setStyle("-fx-background-color: #DDDDDD;");

        pane_0_6.setStyle("-fx-background-color: #DDDDDD;");
        pane_1_6.setStyle("-fx-background-color: #FFFFFF;");
        pane_2_6.setStyle("-fx-background-color: #DDDDDD;");
        pane_3_6.setStyle("-fx-background-color: #FFFFFF;");
        pane_4_6.setStyle("-fx-background-color: #DDDDDD;");
        pane_5_6.setStyle("-fx-background-color: #FFFFFF;");
        pane_6_6.setStyle("-fx-background-color: #DDDDDD;");
        pane_7_6.setStyle("-fx-background-color: #FFFFFF;");

        pane_0_7.setStyle("-fx-background-color: #FFFFFF;");
        pane_1_7.setStyle("-fx-background-color: #DDDDDD;");
        pane_2_7.setStyle("-fx-background-color: #FFFFFF;");
        pane_3_7.setStyle("-fx-background-color: #DDDDDD;");
        pane_4_7.setStyle("-fx-background-color: #FFFFFF;");
        pane_5_7.setStyle("-fx-background-color: #DDDDDD;");
        pane_6_7.setStyle("-fx-background-color: #FFFFFF;");
        pane_7_7.setStyle("-fx-background-color: #DDDDDD;");
    }
}
