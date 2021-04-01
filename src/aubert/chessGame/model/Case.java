package aubert.chessGame.model;

public class Case {
    private Piece piece;
    private Position positionCase;

    public Case(Piece piece, Position positionCase) {
        this.piece = piece;
        this.positionCase = positionCase;
    }
}
