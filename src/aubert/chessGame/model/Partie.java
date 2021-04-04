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

    }

    public Plateau getPlateau() {
        return plateau;
    }

    public List<Deplacement> getDeplacementsRealises() {
        return deplacementsRealises;
    }

    public Couleur getTurn() {
        return turn;
    }

    public void effectuerDeplacement(Case ancienneCase,Case nouvelleCase, Piece pieceADeplacer){

        Deplacement nouveauDeplacement = new Deplacement(pieceADeplacer, ancienneCase, nouvelleCase);
        deplacementsRealises.add(nouveauDeplacement);
        plateau.deplacerPiece(nouveauDeplacement);
        turn = turn == Couleur.BLANC ? Couleur.NOIR : Couleur.BLANC;
    }

    public void annulerDeplacement(Deplacement dernierDeplacement){
        deplacementsRealises.remove(dernierDeplacement);
    }
}
