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

    public boolean effectuerDeplacement(Case ancienneCase,Case nouvelleCase, Piece pieceADeplacer){
        boolean statutDeplacement;
        if (pieceADeplacer.getCouleurPiece().equals(turn)) {
            Deplacement nouveauDeplacement = new Deplacement(pieceADeplacer, ancienneCase, nouvelleCase);
            deplacementsRealises.add(nouveauDeplacement);
            plateau.deplacerPiece(nouveauDeplacement);
            turn = turn == Couleur.BLANC ? Couleur.NOIR : Couleur.BLANC;
            statutDeplacement=true;
        }
        else {
            System.out.println("Ce n'est pas à votre tour de jouer");
            statutDeplacement =false;
        }
        return statutDeplacement;
    }

    public void annulerDeplacement(Deplacement dernierDeplacement){
        deplacementsRealises.remove(dernierDeplacement);
    }
}
