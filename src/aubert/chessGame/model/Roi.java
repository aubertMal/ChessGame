package aubert.chessGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Roi extends Piece{
    public Roi(String nom, Couleur couleurPiece, String image) {
        super(nom, couleurPiece, image);
    }

    @Override
    public List<Position> deplacementsPossibles(Position position){
        List <Position> positionsPossibles = new ArrayList<>();
        int posX = position.getX();
        int posY = position.getY();

        positionsPossibles.add(new Position(posX+1,posY));
        positionsPossibles.add(new Position(posX-1, posY));
        positionsPossibles.add(new Position(posX, posY-1));
        positionsPossibles.add(new Position(posX, posY+1));
        positionsPossibles.add(new Position(posX+1, posY+1));
        positionsPossibles.add(new Position(posX+1, posY-1));
        positionsPossibles.add(new Position(posX-1, posY+1));
        positionsPossibles.add(new Position(posX-1, posY-1));

        return positionsPossibles;
    }
}
