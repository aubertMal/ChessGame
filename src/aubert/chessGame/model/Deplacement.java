package aubert.chessGame.model;

public class Deplacement {
    private Piece pieceDeplacee;
    private Piece pieceMangee;
    private Case oldCase;
    private Case newCase;

    public Deplacement(Piece pieceDeplacee, Case oldCase, Case newCase) {
        this.pieceDeplacee = pieceDeplacee;
        this.oldCase = oldCase;
        this.newCase = newCase;
    }

    public Piece getPieceDeplacee() {
        return pieceDeplacee;
    }

    public Case getOldCase() {
        return oldCase;
    }

    public Case getNewCase() {
        return newCase;
    }
}
