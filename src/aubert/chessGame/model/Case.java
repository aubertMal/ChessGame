package aubert.chessGame.model;

public class Case {
    private Piece piece;
    private Position positionCase;

    public Case(Piece piece, Position positionCase) {
        this.piece = piece;
        this.positionCase = positionCase;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPositionCase(Position positionCase) {
        this.positionCase = positionCase;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getPositionCase() {
        return positionCase;
    }
}
