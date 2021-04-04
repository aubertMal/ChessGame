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

    public Deplacement(Piece pieceDeplacee, Piece pieceMangee, Case oldCase, Case newCase) {
        this.pieceDeplacee = pieceDeplacee;
        this.pieceMangee = pieceMangee;
        this.oldCase = oldCase;
        this.newCase = newCase;
    }

    public Piece getPieceMangee() {
        return pieceMangee;
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
