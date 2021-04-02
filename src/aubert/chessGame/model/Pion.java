package aubert.chessGame.model;

import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{
    public Pion(String nom, Couleur couleurPiece, String image) {
        super(nom, couleurPiece, image);
    }

    @Override
    public List<Position> deplacementsPossibles(Position position){
        List <Position> positionsPossibles = new ArrayList<>();
        int posX = position.getX();
        int posY = position.getY();

        positionsPossibles.add(new Position(posX,posY+1));
        //TODO: 3 cas particuliers à gérer
        positionsPossibles.add(new Position(posX+1, posY+1));
        positionsPossibles.add(new Position(posX-1, posY+1));
        positionsPossibles.add(new Position(posX, posY+2));

        return positionsPossibles;
    }
}
