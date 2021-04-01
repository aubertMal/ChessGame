package aubert.chessGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plateau {
    private List<Piece> piecesNoires;
    private List<Piece> piecesBlanches;
    private List<Case> cases;
    private List<Position> positionsPossibles = new ArrayList<>();

    public Plateau(List<Piece> piecesNoires, List<Piece> piecesBlanches, List<Case> cases) {
        this.piecesNoires = piecesNoires;
        this.piecesBlanches = piecesBlanches;
        this.cases = cases;
    }

    public void initPlateau(){

        initPositions();
        initPiecesBlanches();
        initPiecesNoires();
        initCases();
        }

    private void initPiecesBlanches() {
        piecesBlanches.add(new Tour());
        piecesBlanches.add(new Cavalier());
        piecesBlanches.add(new Fou());
        piecesBlanches.add(new Roi());
        piecesBlanches.add(new Dame());
        piecesBlanches.add(new Fou());
        piecesBlanches.add(new Cavalier());
        piecesBlanches.add(new Tour());
        for (int i = 0; i < 8; i++) {
            piecesBlanches.add(new Pion());
        }
    }

    private void initPiecesNoires() {
        for (int i = 0; i < 8; i++) {
            piecesNoires.add(new Pion());
        }
        piecesNoires.add(new Tour());
        piecesNoires.add(new Cavalier());
        piecesNoires.add(new Fou());
        piecesNoires.add(new Roi());
        piecesNoires.add(new Dame());
        piecesNoires.add(new Fou());
        piecesNoires.add(new Cavalier());
        piecesNoires.add(new Tour());
    }

    private void initCases() {
        //on place les pièces blanches
        for (int i = 0; i < 16; i++) {
            cases.add(new Case(piecesBlanches.get(i),positionsPossibles.get(i)));
        }

        //on définit les cases vides
        for (int i = 16; i < 48; i++) {
            cases.add(new Case(null,positionsPossibles.get(i)));
        }

        //on place les pièces noires
        for (int i = 48; i < 64; i++) {
            cases.add(new Case(piecesNoires.get(i-48),positionsPossibles.get(i)));
        }
    }

    private void initPositions(){
        //créer une liste de toutes les positions possibles sur le plateau; position (0,0) correspond à la 1ère case en bas à gauche
        for (int posY = 0; posY < 8; posY++) {
            for (int posX = 0; posX < 8; posX++) {
                positionsPossibles.add(new Position(posX,posY));
            }
        }
    }

    public List<Position> deplacementsPossibles (Case caseActuelle){
        return null;
    }

    public List<Position> getPositionsPossibles() {
        return positionsPossibles;
    }
}
