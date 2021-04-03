package aubert.chessGame.model;

public enum IndexPieceBlanche {
    TOUR(0),
    CAVALIER1(1),
    FOU1(2),
    DAME(3),
    ROI(4),
    FOU2(5),
    CAVALIER2(6),
    TOUR2(7),
    PION1(8),
    PION2(9),
    PION3(10),
    PION4(11),
    PION5(12),
    PION6(13),
    PION7(14),
    PION8(15);

    private int indexPieceBlanche;
    IndexPieceBlanche(int index) {
        this.indexPieceBlanche =index;
    }

    public int getIndexPieceBlanche() {
        return indexPieceBlanche;
    }
}
