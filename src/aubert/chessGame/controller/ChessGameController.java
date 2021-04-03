package aubert.chessGame.controller;

import aubert.chessGame.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private LinkedHashMap<Pane, Case> mapCasePane = new LinkedHashMap<>();//utiliser LinkedHadhMap parce que ça conserve l'ordre d'insertion


    @FXML
    private Button boutonNouvellePartie;
    @FXML
    private Button boutonQuitter;
    @FXML
    private Button boutonAnnuler;

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
    private Text infoPartie;

    @FXML
    private Text tour;

    private Case casePrecedente;

    private Deplacement deplacementPrecedent;

    private List<Pane> panes = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        demarrerApplication();

        boutonNouvellePartie.setOnMouseClicked(mouseEvent -> {
            demarrerNouvellePartie();
            initPaneListeners();
            infoPartie.setText("Début d'une nouvelle partie");
            tour.setText("Blancs");
        });

        boutonQuitter.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) boutonQuitter.getScene().getWindow();
            stage.close();
        });

        boutonAnnuler.setOnMouseClicked(mouseEvent -> {
            if (partie.getDeplacementsRealises().size()!=0){
                partie.annulerDeplacement(deplacementPrecedent);
                updateImagePane(trouverPaneParCase(deplacementPrecedent.getOldCase().getPositionCase(),mapCasePane), deplacementPrecedent.getNewCase());
                //TODO récupérer la pièce mangée du déplacement
                trouverPaneParCase(deplacementPrecedent.getNewCase().getPositionCase(),mapCasePane).getChildren().clear();
            }
        });
    }

    private void demarrerApplication() {
        //on prépare les panes pour l'affichage
        initListePanes();
        initGridPane();
    }

    private void demarrerNouvellePartie(){
        //on prépare le platean, les positions, les cases, les listes blanches et noires
        partie.creerNouvellePartie();
        //on établit les liens entre les cases et les panes
        initMapPositions();
        //on transmet les cases sur les panes
        refreshPanes();
    }

    private void initListePanes(){
        panes.add(0,pane_0_0);
        panes.add(1,pane_1_0);
        panes.add(2,pane_2_0);
        panes.add(3,pane_3_0);
        panes.add(4,pane_4_0);
        panes.add(5,pane_5_0);
        panes.add(6,pane_6_0);
        panes.add(7,pane_7_0);

        panes.add(8,pane_0_1);
        panes.add(9,pane_1_1);
        panes.add(10,pane_2_1);
        panes.add(11,pane_3_1);
        panes.add(12,pane_4_1);
        panes.add(13,pane_5_1);
        panes.add(14,pane_6_1);
        panes.add(15,pane_7_1);

        panes.add(16,pane_0_2);
        panes.add(17,pane_1_2);
        panes.add(18,pane_2_2);
        panes.add(19,pane_3_2);
        panes.add(20,pane_4_2);
        panes.add(21,pane_5_2);
        panes.add(22,pane_6_2);
        panes.add(23,pane_7_2);

        panes.add(24,pane_0_3);
        panes.add(25,pane_1_3);
        panes.add(26,pane_2_3);
        panes.add(27,pane_3_3);
        panes.add(28,pane_4_3);
        panes.add(29,pane_5_3);
        panes.add(30,pane_6_3);
        panes.add(31,pane_7_3);

        panes.add(32,pane_0_4);
        panes.add(33,pane_1_4);
        panes.add(34,pane_2_4);
        panes.add(35,pane_3_4);
        panes.add(36,pane_4_4);
        panes.add(37,pane_5_4);
        panes.add(38,pane_6_4);
        panes.add(39,pane_7_4);

        panes.add(40,pane_0_5);
        panes.add(41,pane_1_5);
        panes.add(42,pane_2_5);
        panes.add(43,pane_3_5);
        panes.add(44,pane_4_5);
        panes.add(45,pane_5_5);
        panes.add(46,pane_6_5);
        panes.add(47,pane_7_5);

        panes.add(48,pane_0_6);
        panes.add(49,pane_1_6);
        panes.add(50,pane_2_6);
        panes.add(51,pane_3_6);
        panes.add(52,pane_4_6);
        panes.add(53,pane_5_6);
        panes.add(54,pane_6_6);
        panes.add(55,pane_7_6);

        panes.add(56,pane_0_7);
        panes.add(57,pane_1_7);
        panes.add(58,pane_2_7);
        panes.add(59,pane_3_7);
        panes.add(60,pane_4_7);
        panes.add(61,pane_5_7);
        panes.add(62,pane_6_7);
        panes.add(63,pane_7_7);
    }

    private void initPaneListeners() {
//        for (Pane paneEcoute:panes) {
//            paneEcoute.setOnMouseClicked(mouseEvent -> {
//                //quand on clique sur une case c'est où pour voir les déplacements possibles d'une pièce ou pour déplacer une pièce
//                infoPartie.setText(" ");
//                if (paneEcoute.getStyle().contains("#4C8295"))
//
//            });
//        }
        //à chaque fois qu'on clique sur une case on va chercher la case correspondante dans les cases enregistrées, s'il y a une pièce dessus on va récupérer ses déplacements possibles
        for (Map.Entry<Pane, Case> entry : mapCasePane.entrySet()) {
            entry.getKey().setOnMouseClicked(mouseEvent -> {
                System.out.println("case cliquee" + entry.getKey().getId());
                infoPartie.setText(" ");
                //si la case est en highlight alors on peut y effectuer un déplacement
                if (entry.getKey().getStyle().contains("#4C8295")){
                    //on enlève le marquage
                    initGridPane();
                    //On fait le déplacement
                    if (partie.effectuerDeplacement(casePrecedente, entry.getValue(), casePrecedente.getPiece())) {
                        //on met à jour le nouveauPane
                        updateImagePane(entry.getKey(), entry.getValue());
                        //On met à jour l'ancienPane
                        updateImagePane(trouverPaneParCase(casePrecedente.getPositionCase(), mapCasePane), casePrecedente);
                        //On passe au 2ème joueur
                        tour.setText(partie.getTurn() == Couleur.BLANC ? "Blancs" : "Noirs");
                        //Sauvegarder le dernier déplacement
                        deplacementPrecedent = new Deplacement(entry.getValue().getPiece(), casePrecedente, entry.getValue());
                    } else
                        infoPartie.setText("Ce n'est pas à votre tour de jouer");
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

    private void initMapPositions() {
        for (int i = 0; i < 64; i++) {
            mapCasePane.put(panes.get(i), plateau.getCases().get(i));
        }
    }

    public void updateImagePane(Pane paneAMettreAJour, Case nouvelleCase){
        if (nouvelleCase.getPiece()!=null)
            paneAMettreAJour.getChildren().add(new ImageView(new Image(nouvelleCase.getPiece().getImage())));
        else
            paneAMettreAJour.getChildren().clear();
    }

    //méthode pour transmettre les cases sur les panes
    //pour chaque case, si on a une pièce on va l'afficher dans le pane sinon on fait un clear
    private void refreshPanes(){
        for (Map.Entry <Pane,Case> entry:mapCasePane.entrySet()) {
            if (entry.getValue().getPiece()!=null)
                entry.getKey().getChildren().add(new ImageView(new Image(entry.getValue().getPiece().getImage())));
            else
                entry.getKey().getChildren().clear();
        }
    }


    private void initGridPane() {//TODO: à revoir
        for (int i = 0; i < 8; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
            else
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
        }
        for (int i = 8; i < 16; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
            else
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
        }
        for (int i = 16; i < 24; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
            else
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
        }
        for (int i = 24; i < 32; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
            else
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
        }
        for (int i = 32; i < 40; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
            else
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
        }
        for (int i = 40; i < 48; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
            else
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
        }
        for (int i = 48; i < 56; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
            else
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
        }
        for (int i = 56; i < 64; i++) {
            if (i%2==0)
                panes.get(i).setStyle("-fx-background-color: #FFFFFF;");
            else
                panes.get(i).setStyle("-fx-background-color: #DDDDDD;");
        }
    }
}
