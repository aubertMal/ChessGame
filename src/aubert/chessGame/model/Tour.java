package aubert.chessGame.model;

import java.util.List;

public class Tour extends Piece{

    public Tour(String nom, Couleur couleurPiece, String image) {
        super(nom, couleurPiece, image);
    }

    @Override
    public List<Position> deplacementsPossibles(Position position){
        return null;
    }
}
