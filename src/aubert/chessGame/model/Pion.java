package aubert.chessGame.model;

import java.util.List;

public class Pion extends Piece{
    public Pion(String nom, Couleur couleurPiece, String image) {
        super(nom, couleurPiece, image);
    }

    @Override
    public List<Position> deplacementsPossibles(Position position){
        return null;
    }
}
