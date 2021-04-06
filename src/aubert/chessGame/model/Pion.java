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

        if (getCouleurPiece()==Couleur.BLANC) {
            //déplacement de base
            positionsPossibles.add(new Position(posX, posY + 1));

            //le déplacement par deux au départ
            for (Position positionDepart:positionsDepartPionsBlancs()) {
                if (Position.comparePositions(position,positionDepart))
                    positionsPossibles.add(new Position(posX,posY+2));
            }

            //le déplacement en diagonal à filtrer selon l'état du plateau
            positionsPossibles.add(new Position(posX+1, posY + 1));
            positionsPossibles.add(new Position(posX-1, posY + 1));

        } else{
            positionsPossibles.add(new Position(posX,posY-1));
            //le déplacement par deux au départ
            for (Position positionDepart:positionsDepartPionsNoirs()) {
                if (Position.comparePositions(position,positionDepart))
                    positionsPossibles.add(new Position(posX,posY-2));
            }
            //le déplacement en diagonal à filtrer plus tard
            positionsPossibles.add(new Position(posX-1, posY - 1));
            positionsPossibles.add(new Position(posX+1, posY - 1));
        }
        return positionsPossibles;
    }
    public List<Position> positionsDepartPionsBlancs(){
        List<Position> positionsDepartBlancs = new ArrayList<>();
        //Les cases de départ des pions blancs
        positionsDepartBlancs.add(new Position(0,1));
        positionsDepartBlancs.add(new Position(1,1));
        positionsDepartBlancs.add(new Position(2,1));
        positionsDepartBlancs.add(new Position(3,1));
        positionsDepartBlancs.add(new Position(4,1));
        positionsDepartBlancs.add(new Position(5,1));
        positionsDepartBlancs.add(new Position(6,1));
        positionsDepartBlancs.add(new Position(7,1));
        return positionsDepartBlancs;
    }
    public List<Position> positionsDepartPionsNoirs(){
        List<Position> positionsDepartNoirs = new ArrayList<>();
        //Les cases de départ des pions noirs
        positionsDepartNoirs.add(new Position(0,6));
        positionsDepartNoirs.add(new Position(1,6));
        positionsDepartNoirs.add(new Position(2,6));
        positionsDepartNoirs.add(new Position(3,6));
        positionsDepartNoirs.add(new Position(4,6));
        positionsDepartNoirs.add(new Position(5,6));
        positionsDepartNoirs.add(new Position(6,6));
        positionsDepartNoirs.add(new Position(7,6));
        return positionsDepartNoirs;
    }
}
