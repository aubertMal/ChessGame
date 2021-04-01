package aubert.chessGame.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Piece> piecesNoires;
    private List<Piece> piecesBlanches;
    private List<Case> cases;
    private List<Position> positionsPossibles = new ArrayList<>();

    public List<Piece> getPiecesNoires() {
        return piecesNoires;
    }

    public List<Piece> getPiecesBlanches() {
        return piecesBlanches;
    }

    public List<Case> getCases() {
        return cases;
    }

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
        piecesBlanches.add(new Tour("Tour",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_rook.png"));
        piecesBlanches.add(new Cavalier("Cavalier",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_knight.png"));
        piecesBlanches.add(new Fou("Fou",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_bishop.png"));
        piecesBlanches.add(new Roi("Roi",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_king.png"));
        piecesBlanches.add(new Dame("Dame",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_queen.png"));
        piecesBlanches.add(new Fou("Fou",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_bishop.png"));
        piecesBlanches.add(new Cavalier("Cavalier",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_knight.png"));
        piecesBlanches.add(new Tour("Tour",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_rook.png"));
        for (int i = 0; i < 8; i++) {
            piecesBlanches.add(new Pion("Pion",Couleur.BLANC,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/white_pawn.png"));
        }
    }

    private void initPiecesNoires() {
        for (int i = 0; i < 8; i++) {
            piecesNoires.add(new Pion("Pion",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_pawn.png"));
        }
        piecesNoires.add(new Tour("Tour",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_rook.png"));
        piecesNoires.add(new Cavalier("Cavalier",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_knight.png"));
        piecesNoires.add(new Fou("Fou",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_bishop.png"));
        piecesNoires.add(new Roi("Roi",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_king.png"));
        piecesNoires.add(new Dame("Dame",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_queen.png"));
        piecesNoires.add(new Fou("Fou",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_bishop.png"));
        piecesNoires.add(new Cavalier("Cavalier",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_knight.png"));
        piecesNoires.add(new Tour("Tour",Couleur.NOIR,"File:C:/Workspace/ChessGame/src/aubert/chessGame/img/black_rook.png"));
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
