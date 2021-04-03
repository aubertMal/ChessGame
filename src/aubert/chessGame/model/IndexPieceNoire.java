package aubert.chessGame.model;

public enum IndexPieceNoire {
    TOUR(8),
    CAVALIER1(9),
    FOU1(10),
    DAME(11),
    ROI(12),
    FOU2(13),
    CAVALIER2(14),
    TOUR2(15),
    PION1(0),
    PION2(1),
    PION3(2),
    PION4(3),
    PION5(4),
    PION6(5),
    PION7(6),
    PION8(7);

    private int indexPieceNoire;
    IndexPieceNoire(int index) {
        this.indexPieceNoire = index;
    }

    public int getIndexPieceNoire() {
        return indexPieceNoire;
    }
}
