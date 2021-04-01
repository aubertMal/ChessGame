package aubert.chessGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partie {
    private Plateau plateau;
    private List<Deplacement> deplacementsRealises;
    private Couleur turn;

    public void creerNouvellePartie(){
        List<Piece> piecesNoires = new ArrayList<>();
        List<Piece> piecesBlanches = new ArrayList<>();
        List<Case> cases = new ArrayList<>();

        plateau = new Plateau(piecesNoires, piecesBlanches,cases);
        plateau.initPlateau();
        System.out.println("Début Nouvelle Partie");

    }

    public void effectuerDeplacement(){

    }

    public void annulerDeplacement(){

    }
}
