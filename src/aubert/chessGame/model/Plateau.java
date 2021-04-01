package aubert.chessGame.model;

import java.util.List;

public class Plateau {
    private List<Piece> piecesNoires;
    private List<Piece> piecesBlanches;
    private Case[] cases = new Case[64];

    public Plateau(List<Piece> piecesNoires, List<Piece> piecesBlanches, Case[] cases) {
        this.piecesNoires = piecesNoires;
        this.piecesBlanches = piecesBlanches;
        this.cases = cases;
    }

    public void initPlateau(){

    }

    public List<Case> deplacementsPossibles (Case caseActuelle){
        return null;
    }
}
