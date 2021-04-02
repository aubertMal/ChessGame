package aubert.chessGame.model;

import java.util.List;

public class Partie {
    private Plateau plateau;
    private List<Deplacement> deplacementsRealises;
    private Couleur turn;

    public Partie(Plateau plateau, List<Deplacement> deplacementsRealises, Couleur turn) {
        this.plateau = plateau;
        this.deplacementsRealises = deplacementsRealises;
        this.turn = turn;
    }

    public void creerNouvellePartie(){

        plateau.initPlateau();
        System.out.println("Début Nouvelle Partie");

    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Couleur getTurn() {
        return turn;
    }

    public void effectuerDeplacement(Case ancienneCase,Case nouvelleCase, Piece pieceADeplacer){
        Deplacement nouveauDeplacement = new Deplacement(pieceADeplacer,ancienneCase,nouvelleCase);
        deplacementsRealises.add(nouveauDeplacement);
        plateau.deplacerPiece(nouveauDeplacement);
    }

    public void annulerDeplacement(){

    }
}
