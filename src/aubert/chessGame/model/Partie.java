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

    public void effectuerDeplacement(Case ancienneCase,Case nouvelleCase){

        Deplacement nouveauDeplacement;

        if (nouvelleCase.getPiece()!=null)
            nouveauDeplacement = new Deplacement(ancienneCase.getPiece(),nouvelleCase.getPiece(),ancienneCase,nouvelleCase);
        else
            nouveauDeplacement = new Deplacement(ancienneCase.getPiece(), ancienneCase, nouvelleCase);

        deplacementsRealises.add(nouveauDeplacement);
        plateau.deplacerPiece(nouveauDeplacement);

        turn = turn == Couleur.BLANC ? Couleur.NOIR : Couleur.BLANC;
    }

    public void annulerDeplacement(){
        Deplacement dernierDeplacement=deplacementsRealises.get(deplacementsRealises.size()-1);
        //on effectue le déplacement dans le sens inverse
        effectuerDeplacement(dernierDeplacement.getNewCase(), dernierDeplacement.getOldCase());
        //si une piève a été mangée, on la remet
        if (dernierDeplacement.getPieceMangee()!=null)
            dernierDeplacement.getNewCase().setPiece(dernierDeplacement.getPieceMangee());
        deplacementsRealises.remove(dernierDeplacement);
    }
}
