package aubert.chessGame.model;


public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static boolean comparePositions(Position position1, Position position2){
        if (position1.getX() == position2.getX() && position1.getY()== position2.getY())
            return true;
        else
            return false;
    }

}
